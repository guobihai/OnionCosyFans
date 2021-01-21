package cc.onion.cosyfans.module_order.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.ipay.IPayIH;
import com.ipay.IPayIHPayment;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

import cc.onion.cosyfans.base.BaseFragment;
import cc.onion.cosyfans.base.exception.ExceptionCode;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.network.RetrofitManager;
import cc.onion.cosyfans.base.observer.ResponseObserver;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.KLogUtils;
import cc.onion.cosyfans.base.utils.RxUtils;
import cc.onion.cosyfans.base.utils.ToastUtil;
import cc.onion.cosyfans.base.utils.TypeUtils;
import cc.onion.cosyfans.base.view.loadView.ILoadVew;
import cc.onion.cosyfans.base.view.loadView.ULoadView;
import cc.onion.cosyfans.item.entity.SkuBaseEntity;
import cc.onion.cosyfans.module_order.BR;
import cc.onion.cosyfans.module_order.OrderListViewModel;
import cc.onion.cosyfans.module_order.R;
import cc.onion.cosyfans.module_order.adapter.OrderListFatherAdapter;
import cc.onion.cosyfans.module_order.databinding.OrderFragmentListBinding;
import cc.onion.cosyfans.module_order.entity.OderReturnListRequest;
import cc.onion.cosyfans.module_order.entity.OrderListEntity;
import cc.onion.cosyfans.module_order.entity.OrderListRequest;
import cc.onion.cosyfans.module_order.entity.OrderRequest;
import cc.onion.cosyfans.module_order.listener.OrderListeViewListener;
import cc.onion.cosyfans.module_trade.api.TradeApi;
import cc.onion.cosyfans.module_trade.entity.PlayListEntity;
import cc.onion.cosyfans.module_trade.entity.PlayRequestEntity;
import cc.onion.cosyfans.module_trade.entity.request.IPlay1688Request;
import cc.onion.cosyfans.module_trade.listener.PlayOnClickListener;
import cc.onion.cosyfans.module_trade.play.ResultDelegate;
import io.reactivex.disposables.Disposable;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.module_order.fragment
 * @ClassName: OrderListFragment
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2019-12-16 14:27
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-16 14:27
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */

@Route(path = RouterPath.Order.ROUTE_ORDER_DETAIL_Fragment)
public class OrderListFragment extends BaseFragment<OrderFragmentListBinding, OrderListViewModel> implements PlayOnClickListener, OrderListeViewListener {

    private int pageNo = 1;
    private int pageSize = 20;

    /**
     * 场景参数（0，全部订单，1，待支付，2，待收货，3，售后）
     */
    @Autowired
    String statusType;

    /**
     * 订单状态
     */
    int orderState  = 0;

    private ILoadVew loadView;

    OrderListFatherAdapter orderListFatherAdapter;


    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.order_fragment_list;
    }

    @Override
    public int initVariableId() {
        return BR.viewModels;
    }

    @Override
    public void initParam() {
        ARouter.getInstance().inject(this);
    }



    @Override
    public void initData() {
        super.initData();
        loadView = new ULoadView(mBinding.refreshLayout);
        mViewModel.setStatusType(statusType);
        mBinding.setViewModels(mViewModel);
        mBinding.refreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                pageNo++;
                initWithData(false);
            }

            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                resetData(false);
            }
        });
        initRecyclerView();
        initWithData(true);
    }

    private void initRecyclerView() {
        mBinding.listView.setLayoutManager(new LinearLayoutManager(getActivity(),1,false));
        orderListFatherAdapter = new OrderListFatherAdapter(null,getActivity(),this,this);
        mBinding.listView.setAdapter(orderListFatherAdapter);
    }

    /**
     * 重置界面，刷新数据
     */
    private void resetData(boolean needLoading) {
        pageNo = 1;
//        mViewModel.items.clear();
        mBinding.refreshLayout.setEnableAutoLoadMore(true);
        mBinding.refreshLayout.setEnableLoadMore(true);
        mBinding.refreshLayout.setEnableRefresh(true);
        initWithData(needLoading);


    }

    private void initWithData(boolean needLoading) {
        if (needLoading) {
            loadView.showLoading();
        }
          pageNo = 1;
        if(statusType.equals( "3")){
            //处理售后
            loadReturnOrder();

        }else{
            //获取订单列表数据
            loadOrderList();
        }



    }

    //处理售后
    private void loadReturnOrder() {
        OderReturnListRequest oderReturnListRequest = new OderReturnListRequest();
        oderReturnListRequest.setPageNum(pageNo);
        oderReturnListRequest.setPageSize(pageSize);
        oderReturnListRequest.getKeyMap().put("pageNum",TypeUtils.toString(pageNo));
        oderReturnListRequest.getKeyMap().put("pageSize", TypeUtils.toString(pageSize));
        oderReturnListRequest.setRequestSign(oderReturnListRequest.getKeyMap());
        mViewModel.getReturnOrderList(oderReturnListRequest, new ResponseListener<OrderListEntity>() {
            @Override
            public void loadSuccess(OrderListEntity data) {
                KLog.i("test","退单数据加载成功～～～～～");
                mBinding.refreshLayout.finishLoadMore();
                mBinding.refreshLayout.finishRefresh();
                if(data.getData() != null && data.getData().size() >0){
                    if (loadView != null) {
                        loadView.hide();
                    }
                    mViewModel.showList.set(true);
                    if (data.getData().size() < pageSize) {
                        mBinding.refreshLayout.setEnableAutoLoadMore(false);
                        mBinding.refreshLayout.setEnableLoadMore(false);
                        if (pageNo > 1) {
                            ToastUtil.Short(getString(R.string.load_more_no_data));
                        }
                    }

                    //设置数据
                    orderListFatherAdapter.setNewData(data.getData());
                    orderListFatherAdapter.notifyDataSetChanged();

                }else if (data.getData().size() == 0) {
                    // 没有数据
                    loadView.showEmpty(v -> {
                        // 点击重新加载数据
                        loadView.showLoading();
                        resetData(true);
                    });
                }
            }

            @Override
            public void loadFailed(String errorCode, String errorMsg) {
                loadView.hide();
                mBinding.refreshLayout.finishRefresh();
                mBinding.refreshLayout.finishLoadMore();
                if (ExceptionCode.NO_NERWORK_ERROR.equals(errorCode)) {
                    loadView.showNetworkError(v -> {
                        // 无网络
                        loadView.showLoading();
                        resetData(true);
                    });
                } else {
                    loadView.showError("数据加载失败：" + errorMsg, v -> {
                        loadView.showLoading();
                        resetData(true);
                    });
                }
            }

            @Override
            public void addDisposable(Disposable disposable) {
                addDisposable(disposable);
            }
        });
    }

    /**
     *      //获取订单列表数据
     */
    private void loadOrderList() {
        OrderListRequest request = new OrderListRequest();
        if(orderState != 0){
            //当订单是全部的时候就是空，根据滑动的角标记载数据
            KLog.i("test","订单的类型："+orderState);
            request.setOrderStatus(TypeUtils.toString(orderState));
            request.getKeyMap().put("orderStatus",TypeUtils.toString(orderState));
        }
        request.setPageNum(pageNo);
        request.setPageSize(pageSize);
        request.getKeyMap().put("pageNum",TypeUtils.toString(pageNo));
        request.getKeyMap().put("pageSize", TypeUtils.toString(pageSize));
        request.setRequestSign(request.getKeyMap());
        mViewModel.getOrderList(request, new ResponseListener<OrderListEntity>() {
            @Override
            public void loadSuccess(OrderListEntity data) {
                KLog.i("test","数据加在成功");
                mBinding.refreshLayout.finishLoadMore();
                mBinding.refreshLayout.finishRefresh();

                if(data.getData() != null && data.getData().size() >0){
                    if (loadView != null) {
                        loadView.hide();
                    }
                    mViewModel.showList.set(true);
                    if (data.getData().size() < pageSize) {
                        mBinding.refreshLayout.setEnableAutoLoadMore(false);
                        mBinding.refreshLayout.setEnableLoadMore(false);
                        if (pageNo > 1) {
                            ToastUtil.Short(getString(R.string.load_more_no_data));
                        }
                    }

                    //设置数据
                    orderListFatherAdapter.setNewData(data.getData());
                    orderListFatherAdapter.notifyDataSetChanged();

                }else if (data.getData().size() == 0) {
                    // 没有数据
                    loadView.showEmpty(v -> {
                        // 点击重新加载数据
                        loadView.showLoading();
                        resetData(true);
                    });
                }


            }

            @Override
            public void loadFailed(String errorCode, String errorMsg) {
                loadView.hide();
                mBinding.refreshLayout.finishRefresh();
                mBinding.refreshLayout.finishLoadMore();
                if (ExceptionCode.NO_NERWORK_ERROR.equals(errorCode)) {
                    loadView.showNetworkError(v -> {
                        // 无网络
                        loadView.showLoading();
                        resetData(true);
                    });
                } else {
                    loadView.showError("数据加载失败：" + errorMsg, v -> {
                        loadView.showLoading();
                        resetData(true);
                    });
                }
            }


            @Override
            public void addDisposable(Disposable disposable) {
                addSubscription(disposable);
            }
        });
    }

    /**
     * 筛选请求数据
     * @param
     */
    public void filterData(int position) {
        this.orderState = position;
        resetData(true);
    }


    @Override
    public void toPlayResule(PlayListEntity.DataBean item,String orderNo) {
        KLog.i("test","执行支付操作");
        if(StringUtils.isNotEmpty(orderNo)){
            //支付
            IPlay1688Request iPlay1688Request = new IPlay1688Request();
            iPlay1688Request.setOrderNo(orderNo);
            iPlay1688Request.setPaymentId(TypeUtils.toString(item.getId()));
//            iPlay1688Request.setShopId("");

            iPlay1688Request.getKeyMap().put("orderNo",orderNo);
            iPlay1688Request.getKeyMap().put("paymentId",TypeUtils.toString(item.getId()));
            iPlay1688Request.setRequestSign(iPlay1688Request.getKeyMap());

            doPlay1688(iPlay1688Request, new ResponseListener<PlayRequestEntity>() {
                @Override
                public void loadSuccess(PlayRequestEntity data) {
                    if(data.getData() != null){
                        KLogUtils.logTest("获取支付数据成功");
                        orderPlay(item,data.getData());
                    }
                }

                @Override
                public void loadFailed(String errorCode, String errorMsg) {
                    KLogUtils.logTest(errorCode+"---"+errorMsg);
                }

                @Override
                public void addDisposable(Disposable disposable) {
                    addDisposable(disposable);
                }
            });
        }
    }


    /**
     * 订单支付操作，唤醒第三方支付操作
     * @param item 支付对象
     * @param data
     */
    private void orderPlay(PlayListEntity.DataBean item, PlayRequestEntity.DataBeanX data) {

        if(data != null){
//            是否需要跳转（0：不需要；1：需要）
            try {
                PlayRequestEntity.DataBeanX.PayResultBean payResult = data.getPayResult();
                if(payResult.getStatus() == 200){
                    PlayRequestEntity.DataBeanX.PayResultBean.DataBean playAttritube = payResult.getData();
                    IPayIHPayment payment = new IPayIHPayment();


//                                        "country":"MY",
//                                        "merchantCode":"M16384",
//                                        "amount":"290.56",
//                                        "orderNo":"CTMS2019122600001001084",
//                                        "backendURL":"https://cosyfans-api.factorychain2social.cn/transaction/ipay88/paynotify",
//                                        "userContact":"60123456789",
//                                        "userName":"mask123",
//                                        "merchantKey":"qUj1RnO1yz",
//                                        "paymentId":"",
//                                        "userEmail":"13838455438@139.com.net",
//                                        "currency":"MYR",
//                                        "shopId":null,
//                                        "prodDesc":"CTMS2019122600001001084"


                    payment.setPaymentId(playAttritube.getPaymentId());
                    payment.setMerchantCode(playAttritube.getMerchantCode());
                    payment.setMerchantKey(playAttritube.getMerchantKey());

                    payment.setRefNo(playAttritube.getOrderNo());

                    payment.setCurrency(playAttritube.getCurrency());
                    payment.setAmount("1.0");


                    payment.setProdDesc(playAttritube.getProdDesc());
                    payment.setUserName(playAttritube.getUserName());
                    payment.setUserEmail(playAttritube.getUserEmail());
                    payment.setUserContact(playAttritube.getUserContact());
                    payment.setRemark("cheap,cheap");
                    payment.setLang("UTF-8");

                    payment.setCountry(playAttritube.getCountry());
                    payment.setBackendPostURL(playAttritube.getBackendURL());
//                                payment.setResponseURL(playAttritube.getBackendURL());




                    Intent selectionIntent = IPayIH.getInstance().checkout(payment, getActivity(),
                            new ResultDelegate(), IPayIH.PAY_METHOD_CREDIT_CARD);
                    startActivityForResult(selectionIntent, 1);
                }else{
                    ToastUtil.Short("服务器错误，请稍后重试");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


        }


    }

    /**
     * 对接play1688返回相应对应参数
     * @param requestBean
     * @param listener
     */
    public void doPlay1688(IPlay1688Request requestBean, ResponseListener<PlayRequestEntity> listener) {
        RetrofitManager
                .createToken(TradeApi.class)
                .doPlay1688(requestBean)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<PlayRequestEntity>() {
                    @Override
                    public void onSuccess(PlayRequestEntity data) {
                        listener.loadSuccess(data);

                    }

                    @Override
                    public void onError(String code, String msg) {
                        listener.loadFailed(code, msg);
                    }
                });
    }


    /**
     * 重新刷新界面
     */
    @Override
    public void refeshView() {
        initWithData(true);

    }
}
