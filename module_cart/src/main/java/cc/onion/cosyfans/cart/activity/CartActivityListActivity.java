package cc.onion.cosyfans.cart.activity;

import android.databinding.Observable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import org.apache.commons.lang3.StringUtils;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import cc.onion.cosyfans.base.BaseActivity;
import cc.onion.cosyfans.base.common.AppCommonInfo;
import cc.onion.cosyfans.base.entity.BaseResponse;
import cc.onion.cosyfans.base.event.Event;
import cc.onion.cosyfans.base.event.LoginSuccessEvent;
import cc.onion.cosyfans.base.event.PageEvent;
import cc.onion.cosyfans.base.exception.ExceptionCode;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.SoftKeyBoardUtils;
import cc.onion.cosyfans.base.utils.ToastUtil;
import cc.onion.cosyfans.base.utils.TypeUtils;
import cc.onion.cosyfans.base.view.loadView.ULoadView;
import cc.onion.cosyfans.cart.CartActivityViewModel;
import cc.onion.cosyfans.cart.adapter.PopListProductAdapter;
import cc.onion.cosyfans.cart.entity.CartPomEntity;
import cc.onion.cosyfans.cart.entity.CartPomListRequest;
import cc.onion.cosyfans.cart.entity.PromotionRequest;
import cc.onion.cosyfans.cart.entity.response.PomptionListEntity;
import cc.onion.cosyfans.cart.event.AddStateEvent;
import cc.onion.cosyfans.cart.listener.AddCartStateListener;
import cc.onion.cosyfans.cart.listener.PopVIewListener;
import cc.onion.cosyfans.item.entity.SkuBaseEntity;
import cc.onion.cosyfans.module_cart.BR;
import cc.onion.cosyfans.module_cart.R;
import cc.onion.cosyfans.module_cart.databinding.CartActivityListBinding;
import cc.onion.cosyfans.passport.Event.SigninPageEvent;
import cc.onion.cosyfans.passport.utils.SoftKeyboard;
import io.reactivex.disposables.Disposable;

/**
 * @author guobihai
 * @version V1.0
 * @Title: AppCommonInfo
 * @Package cc.onion.cosyfans.base.common
 * @date 2019-12-03 14:53
 * @email: anhui-zhuang@msyc.cc
 * @Description: (活动列表界面)
 */
@Route(path = RouterPath.Cart.ROUTE_CART_PATH_ACTIVITY)
public class CartActivityListActivity extends BaseActivity<CartActivityListBinding, CartActivityViewModel> implements  AddCartStateListener, PopVIewListener {

    @Autowired()
    String promotionId;


    // 加载视图
    private int pageNum = 1;


    private ULoadView loadVew;


    PopListProductAdapter popListProductAdapter;

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.cart_activity_list;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding.setModel(mViewModel);
        mViewModel.setPopVIewListener(this);

    }


    @Override
    public void initParam() {
        // 获取ARouter注入
        ARouter.getInstance().inject(this);

    }



    private void initRootView() {
        mViewModel.searchWord.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                if(StringUtils.isNotEmpty(mViewModel.searchWord.get())){
                    mViewModel.isShowDeleteView.set(true);
                }else{
                    mViewModel.isShowDeleteView.set(false);
                }
            }
        });

        mBinding.getRoot().setOnClickListener(v -> {
            SoftKeyBoardUtils.closeKeyBoard(this);
        });

        mBinding.etSearch.setOnFocusChangeListener((v, hasFocus) -> {
            if (!mBinding.etSearch.isFocused()){
                //操作
                mViewModel.isShowBaseView.set(true);
            }else{
                mViewModel.isShowBaseView.set(false);
            }

        });

        SoftKeyboard.of(this).listen(new SoftKeyboard.OnSoftKeyboardChangeListener() {
            @Override
            public void onHide() {
                if (StringUtils.isNotEmpty(mViewModel.searchWord.get())){
                    mViewModel.isShowBaseView.set(false);
                }else{
                    mViewModel.isShowBaseView.set(true);
                }

            }

            @Override
            public void onShow() {

            }
        });
    }



    @Override
    public int initVariableId() {
        return BR.model;
    }

    @Override
    public void initData() {
        super.initData();
        loadVew = new ULoadView(mBinding.body);
        loadVew.showLoading();

        mBinding.imgLeft.setOnClickListener(v -> onBackPressed());

        initLayout();
        if(StringUtils.isNotEmpty(promotionId)){
            loadPromotionInfo();
            loadPopList();
        }


        mBinding.popCartRefreshLayout.setEnableRefresh(true);
        // 下拉刷新监听
        mBinding.popCartRefreshLayout.setOnRefreshListener(
                refreshLayout -> {
                    pageNum = 1;
                    loadPopList();
                });

        // 上拉加载监听
        mBinding.popCartRefreshLayout.setOnLoadMoreListener(
                refreshLayout -> {
                    pageNum++;
                    loadPopList();
                });

        initRootView();

    }

    private void initLayout() {
        popListProductAdapter = new PopListProductAdapter(this,null,this);
        mBinding.lvCartRecyclerview.setLayoutManager(new LinearLayoutManager(this,1,false));
        mBinding.lvCartRecyclerview.setAdapter(popListProductAdapter);
        mBinding.lvCartRecyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
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
                        mBinding.imgTop.setVisibility(View.GONE);
                    } else {
                        //显示回到顶部按钮
                        mBinding.imgTop.setVisibility(View.VISIBLE);
                    }
                    //获取RecyclerView滑动时候的状态
                } else if (newState == RecyclerView.SCROLL_STATE_DRAGGING) {//拖动中
                    mBinding.imgTop.setVisibility(View.GONE);
                }
            }
        });

        mBinding.imgTop.setOnClickListener(v -> {
//            mBinding.netScroview.scrollTo(0,0);
            mBinding.lvCartRecyclerview.smoothScrollBy(0, 1);
        });
    }

    /**
     * 加载列表数据
     */
    private void loadPopList() {
        if (pageNum == 1) {
            mBinding.popCartRefreshLayout.setEnableAutoLoadMore(true);
        }

        CartPomListRequest request = new CartPomListRequest();
        request.setPageNum(pageNum);
        request.setPageSize(AppCommonInfo.pageSize);
        request.setPromotionId(promotionId);
        //
        request.getKeyMap().put("pageNum", TypeUtils.toString(pageNum));
        request.getKeyMap().put("pageSize", TypeUtils.toString(AppCommonInfo.pageSize));
        request.getKeyMap().put("promotionId",request.getPromotionId());


        //关键字不为空
        if(StringUtils.isNotEmpty(mViewModel.searchWord.get())){
            request.setQ(mViewModel.searchWord.get());
            request.getKeyMap().put("q", mViewModel.searchWord.get());
        }
        request.setRequestSign(request.getKeyMap());

        mViewModel.getPromotionList(request, new ResponseListener<PomptionListEntity>() {
            @Override
            public void loadSuccess(PomptionListEntity data) {
                loadVew.hide();
                mBinding.popCartRefreshLayout.finishRefresh();
                mBinding.popCartRefreshLayout.finishLoadMore();
                if(data.getData() != null){

                    KLog.i("test","有数据了～～～～");


                    if(pageNum ==1){
                        if(data.getData().getItems() != null && data.getData().getItems().size() >0){
                            popListProductAdapter.setNewData(data.getData().getItems());
                            popListProductAdapter.notifyDataSetChanged();
                        }

                    }else{
                        if(data.getData().getItems() != null && data.getData().getItems().size() >0){
                            popListProductAdapter.addData(data.getData().getItems());
                            popListProductAdapter.notifyDataSetChanged();
                        }else{
                            ToastUtil.Short("暂无更多数据");
                        }
                    }

                }

            }

            @Override
            public void loadFailed(String errorCode, String errorMsg) {
                mBinding.popCartRefreshLayout.finishRefresh();
                mBinding.popCartRefreshLayout.finishLoadMore();
                if(StringUtils.isNoneEmpty(errorCode)) {
                    if (errorCode.equals(ExceptionCode.NO_NERWORK_ERROR)) {
                        loadVew.showNetworkError(v -> {
                            // 无网络
                            loadVew.showLoading();
                            loadPopList();

                        });
                    } else {
                        loadVew.showError("数据加载失败：" + errorCode + "\n" + errorMsg, v -> {
                            loadVew.showLoading();
                            loadPopList();

                        });
                    }
                }
            }

            @Override
            public void addDisposable(Disposable disposable) {
                addDisposable(disposable);
            }
        });
    }

    /**
     * 获取折扣数据
     */
    private void loadPromotionInfo() {
        PromotionRequest request = new PromotionRequest();
        request.setPromotionId(promotionId);
        request.getKeyMap().put("promotionId",request.getPromotionId());
        request.setRequestSign(request.getKeyMap());
        mViewModel.getPromotioninfo(request, new ResponseListener<BaseResponse<CartPomEntity>>() {
            @Override
            public void loadSuccess(BaseResponse<CartPomEntity> data) {
                if(data.getData() != null){

                    if(StringUtils.isNotEmpty(data.getData().getLevelName())){
                        mViewModel.pormotion.set(data.getData().getLevelName());
                        mViewModel.totalMonery.set(data.getData().getLevelName());
                        if(StringUtils.isNotEmpty(data.getData().getDiscountPrice()) && StringUtils.isNotEmpty(data.getData().getTotalPrice())){
                            mViewModel.disMonery.set("已优惠￥"+data.getData().getDiscountPrice());
                            mViewModel.allMonery.set("小计:￥"+data.getData().getTotalPrice());
                        }else{
                            mViewModel.disMonery.set("已优惠￥"+"0.00");
                            mViewModel.allMonery.set("小计:￥"+"0.00");
                        }


                    }

                    if(StringUtils.isNotEmpty(data.getData().getStartTime()) && StringUtils.isNotEmpty(data.getData().getEndTime())){
                        mViewModel.time.set("促销时间:"+data.getData().getStartTime()+"-"+data.getData().getEndTime());
                    }
                }

            }

            @Override
            public void loadFailed(String errorCode, String errorMsg) {

            }

            @Override
            public void addDisposable(Disposable disposable) {
                    addSubscription(disposable);
            }
        });
    }

    @Override
    public void onSuccess() {
        KLog.i("test","加入购物车成功过");
        loadPromotionInfo();

    }

    @Override
    public void onError() {

    }

    @Override
    public void close() {
        EventBus.getDefault().post(PageEvent.HOME_PAGE_3);
        finish();
    }

    @Override
    public void searchWord() {
        //带关键字搜索
        loadPopList();
    }

    @Override
    public void deleteSearchWord() {
        mViewModel.searchWord.set("");
        mViewModel.isShowBaseView.set(true);
        //清空搜索
        loadPopList();
    }
}
