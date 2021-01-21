package cc.onion.cosyfans.my.activity.merchants;

import android.support.design.widget.TabLayout;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import cc.onion.cosyfans.base.BaseToolBarActivity;
import cc.onion.cosyfans.base.dialog.AlertDialog;
import cc.onion.cosyfans.base.dialog.LoadingDialog;
import cc.onion.cosyfans.base.dialog.ProgressLoading;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.JsonUtils;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.SystemUtils;
import cc.onion.cosyfans.base.utils.ToastUtil;
import cc.onion.cosyfans.base.view.loadView.ULoadView;
import cc.onion.cosyfans.module_my.R;
import cc.onion.cosyfans.module_my.databinding.MyMechantOrderActivityBinding;
import cc.onion.cosyfans.my.adapter.HistoryListOrdersAdapt;
import cc.onion.cosyfans.my.dialogs.OrderInComeDialog;
import cc.onion.cosyfans.my.entity.OrderInComeEntry;
import cc.onion.cosyfans.my.entity.OrderListEntity;
import cc.onion.cosyfans.my.entity.request.OrderHistoryRequest;
import cc.onion.cosyfans.my.interfaces.ItemOnClickInterface;
import cc.onion.cosyfans.my.viewdModel.MySaleOrderViewModel;
import io.reactivex.disposables.Disposable;

/**
 * 商家-我的销售订单
 *
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.activity.merchants
 * @ClassName: MySalesOrderActivity
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2020/1/13 14:07
 * @UpdateUser: guobihai
 * @UpdateDate: 2020/1/13 14:07
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Route(path = RouterPath.MyCosy.ROUTE_MIME_MERCHANT_ORDERS)
public class MySalesOrderActivity extends BaseToolBarActivity<MyMechantOrderActivityBinding, MySaleOrderViewModel> {

    private ULoadView uLoadView;
    private LoadingDialog mLoadingDialog;
    private int pageNum = 1;
    private int pageSize = 10;
    private int mSelectIndex = 0;//游标
    private int mTotalPage;//总页数


    private HistoryListOrdersAdapt mHistoryListOrdersAdapt;

    private List<OrderListEntity.DataBean.OrderListBean> mDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_mechant_order_activity);
        setToolbarTitle(getString(R.string.my_sale_order_title));
        mBinding.setViewModel(mViewModel);
        if (SystemUtils.v21()) {
            mAppBarLayout.setElevation(0);
            mToolBar.setElevation(0);
        }
        String[] titles = getResources().getStringArray(R.array.my_sale_orders_array);
        for (String title : titles) {
            mBinding.myCenterTablayout.addTab(mBinding.myCenterTablayout.newTab().setText(title));
        }
        mBinding.myCenterTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int selectIndex = tab.getPosition();
                mSelectIndex = selectIndex;
                pageNum = 1;
                selectOrderType(selectIndex, true);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mBinding.etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String value = s.toString();
                mViewModel.showDelete.set(value.length() > 0);
            }
        });
        initLayout();
    }

    //选择加载订单类型
    private void selectOrderType(int selectIndex, boolean isOnReflash) {
        if (isOnReflash) {
            mDataList.clear();
            uLoadView.showLoading();
            mBinding.floatbutton.setVisibility(View.GONE);
            mBinding.smartRefreshLayout.setNoMoreData(false);
        }
        KLog.i("selectTab index:" + selectIndex);
        switch (selectIndex) {
            case 0:
                loadDataByType(OrderHistoryRequest.getAllOrderRequest(pageNum, pageSize), isOnReflash);
                mViewModel.orderStatus.set("");
                break;
            case 1:
                loadDataByType(OrderHistoryRequest.getUnPaidOrderRequest(pageNum, pageSize), isOnReflash);
                mViewModel.orderStatus.set(String.valueOf(OrderHistoryRequest.ORDER_UNPAID));
                break;
            case 2:
                loadDataByType(OrderHistoryRequest.getDeliveringOrderRequest(pageNum, pageSize), isOnReflash);
                mViewModel.orderStatus.set(String.valueOf(OrderHistoryRequest.ORDER_DELIVERING));
                break;
            case 3:
                loadDataByType(OrderHistoryRequest.getCompletedOrderRequest(pageNum, pageSize), isOnReflash);
                mViewModel.orderStatus.set(String.valueOf(OrderHistoryRequest.ORDER_COMPLETE));
                break;
            case 4:
                loadDataByType(OrderHistoryRequest.getReturnOrderRequest(pageNum, pageSize), isOnReflash);
                mViewModel.orderStatus.set(String.valueOf(OrderHistoryRequest.ORDER_RETURN));
                break;
            default:
                break;
        }
    }

    //初始化layout
    private void initLayout() {
        mBinding.myOrderRecycleview.setLayoutManager(new LinearLayoutManager(this));
        mBinding.myOrderRecycleview.setAdapter(mHistoryListOrdersAdapt);
        mHistoryListOrdersAdapt.setEmptyView(R.layout.my_item_emptry_data_layout, mBinding.myOrderRecycleview);
        mBinding.tvSearch.setOnClickListener(v -> {
            mDataList.clear();
            uLoadView.showLoading();
            loadDataByType(OrderHistoryRequest.getSearchOrderRequest(mViewModel.searchText.get(),
                    mViewModel.orderStatus.get(), pageNum, pageSize), true);
        });

        //下拉刷新
        mBinding.smartRefreshLayout.setOnRefreshListener(refreshLayout -> {
            pageNum = 1;
            selectOrderType(mSelectIndex, true);
        });
        //上拉加载
        mBinding.smartRefreshLayout.setOnLoadMoreListener(refreshLayout -> {
            pageNum++;
            if (pageNum >= mTotalPage)
                mBinding.smartRefreshLayout.finishLoadMoreWithNoMoreData();
            else
                selectOrderType(mSelectIndex, false);
        });

        //快速滑动
        mBinding.floatbutton.setOnClickListener(v -> {
            mBinding.myOrderRecycleview.smoothScrollToPosition(0);
        });
        mBinding.myOrderRecycleview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                //获得recyclerView的线性布局管理器
                LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
                //获取到第一个item的显示的下标  不等于0表示第一个item处于不可见状态 说明列表没有滑动到顶部 显示回到顶部按钮
                int firstVisibleItemPosition = manager.findFirstVisibleItemPosition();
                // 当不滚动时
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    // 判断是否滚动超过一屏
                    if (firstVisibleItemPosition == 0) {
                        mBinding.floatbutton.setVisibility(View.GONE);
                    } else {
                        //显示回到顶部按钮
                        mBinding.floatbutton.setVisibility(View.VISIBLE);
                    }
                    //获取RecyclerView滑动时候的状态
                } else if (newState == RecyclerView.SCROLL_STATE_DRAGGING) {//拖动中
                    mBinding.floatbutton.setVisibility(View.GONE);
                }
            }
        });
        //回调监听
        mHistoryListOrdersAdapt.setItemOnClickInterface(new ItemOnClickInterface<String>() {
            @Override
            public void onClick(View view, String data, int type) {
                if (view.getId() == R.id.btn_order_income) {
                    loadOrderInComeInfo(data, type);
                } else if (view.getId() == R.id.btn_order_tracking) {
                    String orderNo = data;
                    KLog.i("=======cur====orderNo=====" + orderNo);
                    ARouter.getInstance()
                            .build(RouterPath.MyCosy.ROUTE_MIME_MERCHANT_TRACKING)
                            .withString("orderNo", orderNo)
                            .navigation();
                }
            }

            @Override
            public void onLongClick(View view, String data, int type) {

            }
        });

    }

    /**
     * 查询我的订单收益
     *
     * @param orderNo
     */
    private void loadOrderInComeInfo(String orderNo, int orderStatus) {
        mLoadingDialog.show();
        mViewModel.loadOrderInComeInfo(orderNo, new ResponseListener<OrderInComeEntry.DataBean>() {
            @Override
            public void loadSuccess(OrderInComeEntry.DataBean data) {
                mLoadingDialog.dismiss();
                if (null != data) {
                    new OrderInComeDialog(MySalesOrderActivity.this, data, orderStatus).show();
                }
            }

            @Override
            public void loadFailed(String errorCode, String errorMsg) {
                mLoadingDialog.dismiss();
                ToastUtil.Short(errorMsg);
            }

            @Override
            public void addDisposable(Disposable disposable) {
                addSubscription(disposable);
            }
        });
    }

    @Override
    public void initParam() {
        super.initParam();
        mDataList = new ArrayList<>();
        mHistoryListOrdersAdapt = new HistoryListOrdersAdapt(mDataList);
    }

    @Override
    public void initData() {
        super.initData();
        uLoadView = new ULoadView(mBinding.smartRefreshLayout);
        uLoadView.showLoading();
        mLoadingDialog = new LoadingDialog(this);
        loadDataByType(OrderHistoryRequest.getAllOrderRequest(pageNum, pageSize), true);
    }

    /**
     * 加载数据
     *
     * @param request
     */
    private void loadDataByType(OrderHistoryRequest request, boolean isOnReflash) {
        mViewModel.loadHisOrderListInfo(request, new ResponseListener<OrderListEntity.DataBean>() {
            @Override
            public void loadSuccess(OrderListEntity.DataBean data) {
                uLoadView.hide();
                mBinding.smartRefreshLayout.finishLoadMore();
                mBinding.smartRefreshLayout.finishRefresh();
                if (null != data.getOrderList() && data.getOrderList().size() != 0) {
                    mTotalPage = data.getTotalPages();
                    if (isOnReflash)
                        mHistoryListOrdersAdapt.replaceData(data.getOrderList());
                    else {
                        mHistoryListOrdersAdapt.addData(data.getOrderList());
                        if (pageNum >= mTotalPage)
                            mBinding.smartRefreshLayout.finishLoadMoreWithNoMoreData();
                    }
                } else {
                    if (pageNum >= mTotalPage)
                        mBinding.smartRefreshLayout.finishLoadMoreWithNoMoreData();
                }
            }

            @Override
            public void loadFailed(String errorCode, String errorMsg) {
                uLoadView.hide();
                mBinding.smartRefreshLayout.finishLoadMore();
                mBinding.smartRefreshLayout.finishRefresh();
            }

            @Override
            public void addDisposable(Disposable disposable) {
                addSubscription(disposable);
            }
        });
    }
}
