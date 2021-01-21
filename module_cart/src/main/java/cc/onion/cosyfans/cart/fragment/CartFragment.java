package cc.onion.cosyfans.cart.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.google.gson.Gson;

import org.apache.commons.lang3.StringUtils;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import cc.onion.cosyfans.base.BaseFragment;
import cc.onion.cosyfans.base.common.AppCommonInfo;
import cc.onion.cosyfans.base.dialog.LoadingDialog;
import cc.onion.cosyfans.base.entity.BaseRequestBean;
import cc.onion.cosyfans.base.event.AppEvent;
import cc.onion.cosyfans.base.event.CartViewRereshEvent;
import cc.onion.cosyfans.base.event.Event;
import cc.onion.cosyfans.base.event.LoginSuccessEvent;
import cc.onion.cosyfans.base.exception.ExceptionCode;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.KLogUtils;
import cc.onion.cosyfans.base.utils.MathUtils;
import cc.onion.cosyfans.base.utils.TypeUtils;
import cc.onion.cosyfans.base.view.loadView.ULoadView;
import cc.onion.cosyfans.cart.CartViewModel;
import cc.onion.cosyfans.cart.adapter.CartListAdapter;
import cc.onion.cosyfans.cart.adapter.ProductGridAdapter;
import cc.onion.cosyfans.cart.entity.CartRequest;
import cc.onion.cosyfans.cart.entity.response.ItemEntity;
import cc.onion.cosyfans.cart.entity.response.CartListEntity;
import cc.onion.cosyfans.cart.listener.CartViewListener;
import cc.onion.cosyfans.cart.listener.ItemOnClickSelectListener;
import cc.onion.cosyfans.item.entity.SkuBaseEntity;
import cc.onion.cosyfans.main.event.CartCount;
import cc.onion.cosyfans.module_cart.BR;
import cc.onion.cosyfans.module_cart.R;
import cc.onion.cosyfans.module_cart.databinding.CartFragmentBinding;
import io.reactivex.disposables.Disposable;

/**
 * @author guobihai
 * @version V1.0
 * @Title: CartFragment
 * @Package cc.onion.cosyfans.cart.fragment.CartFragment
 * @date 2019-12-03 14:53
 * @email: anhui-zhuang@msyc.cc
 * @Description: (购物车)
 */
@Route(path = RouterPath.Cart.ROUTE_CART_PATH)
public class CartFragment extends BaseFragment<CartFragmentBinding, CartViewModel> implements CartViewListener, ItemOnClickSelectListener {

    public static CartFragment newInstance() {
        Bundle args = new Bundle();

        CartFragment fragment = new CartFragment();
        fragment.setArguments(args);
        return fragment;
    }


    /**
     * 购物车适配器
     */
    CartListAdapter cartListAdapter;
    ProductGridAdapter likeGridListAdapter;
    List<String> stringList;
    GridLayoutManager gridLayoutManager;
    LinearLayoutManager linearLayoutManager;
    private ULoadView loadVew;
    // 加载视图
    private int pageNum = 1;
    // 每页数量
    /**
     * 判断购物车数据是否为空
     */
    boolean  isCartData  = false;


    /**
     * 当前购物车数据
     * 1、购物车数据，所有的接口返回的数据都赋值此操作，
     * 2、所有的业务逻辑操作主线，切勿乱操作
     * 3、增加是否选择字段，方便控制
     */
    private List<CartListEntity.DataBean.CartDetailListBean> currentCartDatalist;


    /**
     * 判断购物车是否全部选择
     */
    private boolean isCartAllCheck = false;
    private LoadingDialog loadingDialog;

    /**
     * 新的购物车数据链
     */
    List<CartListEntity.DataBean.CartDetailListBean> newCurrentCartDatalist = new ArrayList<>();


    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.cart_fragment;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }


    @Override
    public void initParam() {
        // 获取ARouter注入
        ARouter.getInstance().inject(this);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initData() {
        super.initData();
        loadingDialog = new LoadingDialog(getActivity());
        mBinding.tvTitle.setText("购物车");

        loadVew = new ULoadView(mBinding.body);
        loadVew.showLoading();
        //初始化数据列表
        mViewModel.isShowBaseView.set(false);
        mBinding.lvCartRecyclerview.setVisibility(View.GONE);
        mBinding.lvCartData.setVisibility(View.GONE);

        initListLayout();
        loadingData();
        mViewModel.setCartViewListener(this);

        mBinding.usedCartRefreshLayout.setEnableRefresh(true);
        // 下拉刷新监听
        mBinding.usedCartRefreshLayout.setOnRefreshListener(
                refreshLayout -> {
                    pageNum = 1;

                    loadingData();
                });

        // 上拉加载监听
        mBinding.usedCartRefreshLayout.setOnLoadMoreListener(
                refreshLayout -> {
                    pageNum++;
                    if(isCartData){
                        //刷新推荐数据
                        //当前购物车没有数据，显示推荐数据
                        setSwitchView(false);
                        getRecommendItem();
                    }else{
                        //加载购物车数据
                        setSwitchView(true);
                        loadingData();
                    }

                });


    }

    /**
     * 加载购物车数据
     */
    private void loadingData() {
        if (pageNum == 1) {
            mBinding.usedCartRefreshLayout.setEnableAutoLoadMore(true);
        }
        CartRequest request  = new CartRequest();
        request.setPageSize(TypeUtils.toString(AppCommonInfo.pageSize));
        request.setPageNum(TypeUtils.toString(pageNum));
        request.getKeyMap().put("pageNum", TypeUtils.toString(pageNum));
        request.getKeyMap().put("pageSize", TypeUtils.toString(AppCommonInfo.pageSize));
        request.setRequestSign(request.getKeyMap());
        mViewModel.getCartList(request, new ResponseListener<CartListEntity>() {
            @Override
            public void loadSuccess(CartListEntity data) {
                KLog.i("test",data.getMsg());
                loadVew.hide();
                mBinding.usedCartRefreshLayout.finishRefresh();
                mBinding.usedCartRefreshLayout.finishLoadMore();
                //判断数据不能为空，如果购物车数据为空的情况下就显示推荐数据
                if(data.getData()  == null || data.getData().getCartDetailList() == null){
                    isCartData = true;
                    setSwitchView(false);
                    //当前购物车没有数据，显示推荐数据
                    getRecommendItem();
                }else{
                    //显示购物车的数据显示
                    isCartData = false;
                    setSwitchView(true);
                    setCartListShowData(data.getData().getCartDetailList());


                }

            }

            @Override
            public void loadFailed(String errorCode, String errorMsg) {
                loadVew.hide();
                mBinding.usedCartRefreshLayout.finishRefresh();
                mBinding.usedCartRefreshLayout.finishLoadMore();
                if(StringUtils.isNoneEmpty(errorCode)) {
                    if (errorCode.equals(ExceptionCode.NO_NERWORK_ERROR)) {
                        loadVew.showNetworkError(v -> {
                            // 无网络
                            loadVew.showLoading();
                            loadingData();

                        });
                    } else {
                        loadVew.showError("数据加载失败：" + errorCode + "\n" + errorMsg, v -> {
                            loadVew.showLoading();
                            loadingData();

                        });
                    }
                }
            }

            @Override
            public void addDisposable(Disposable disposable) {
                addSubscription(disposable);
            }
        });
    }

    /**
     * 显示购物车数据
     * @param cartDetailList
     */
    private void setCartListShowData(List<CartListEntity.DataBean.CartDetailListBean> cartDetailList){


        cartListAdapter = new CartListAdapter(null,getActivity(),this);
        mBinding.lvCartData.setLayoutManager(linearLayoutManager);
        mBinding.lvCartData.setAdapter(cartListAdapter);



        if(pageNum == 1){
            //购物车数据赋值操作
            currentCartDatalist = cartDetailList;
            cartListAdapter.setNewData(currentCartDatalist);
            cartListAdapter.notifyDataSetChanged();
        }else{
            //此处存在BUG
            if(cartDetailList != null && cartDetailList.size() >0 ){
                //购物车数据赋值操作
                currentCartDatalist.addAll(cartDetailList);
                cartListAdapter.addData(currentCartDatalist);
                cartListAdapter.notifyDataSetChanged();
                mBinding.usedCartRefreshLayout.setEnableAutoLoadMore(false);
            }else{
                //关闭加载更多
                mBinding.usedCartRefreshLayout.setEnableAutoLoadMore(false);
            }

        }



    }


    /**
     * 获取推荐产品
     */
    public  void  getRecommendItem(){


        BaseRequestBean requestBean = new BaseRequestBean();
        requestBean.setRequestSign(requestBean.getKeyMap());
        mViewModel.getRecommendItem(requestBean, new ResponseListener<ItemEntity>() {
            @Override
            public void loadSuccess(ItemEntity data) {
                loadVew.hide();
            if(data.getData() != null && data.getData().size() >0){
                likeGridListAdapter.setNewData(data.getData());
                likeGridListAdapter.notifyDataSetChanged();
            }

            }

            @Override
            public void loadFailed(String errorCode, String errorMsg) {
                loadVew.hide();
                mBinding.usedCartRefreshLayout.finishRefresh();
                mBinding.usedCartRefreshLayout.finishLoadMore();
                if(StringUtils.isNoneEmpty(errorCode)) {
                    if (errorCode.equals(ExceptionCode.NO_NERWORK_ERROR)) {
                        loadVew.showNetworkError(v -> {
                            // 无网络
                            loadVew.showLoading();
                            getRecommendItem();

                        });
                    } else {
                        loadVew.showError("数据加载失败：" + errorCode + "\n" + errorMsg, v -> {
                            loadVew.showLoading();
                            getRecommendItem();

                        });
                    }
                }
            }

            @Override
            public void addDisposable(Disposable disposable) {
                addSubscription(disposable);
            }
        });
    }

    /**
     * 设置view的显示控制
     * @param isCartShow
     */
    private void setSwitchView(boolean isCartShow) {
        if(isCartShow){
            mViewModel.isShowBaseView.set(isCartShow);
            mBinding.lvCartRecyclerview.setVisibility(View.GONE);
            mBinding.lvCartData.setVisibility(View.VISIBLE);
        }else{
            mViewModel.isShowBaseView.set(isCartShow);
            mBinding.lvCartRecyclerview.setVisibility(View.VISIBLE);
            mBinding.lvCartData.setVisibility(View.GONE);
        }

    }

    private void initListLayout() {
        gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        linearLayoutManager = new LinearLayoutManager(getActivity(),1,false);
        likeGridListAdapter = new ProductGridAdapter(null,getActivity());
        //Left adapter

        View headerVew = LayoutInflater.from(getActivity()).inflate(R.layout.cart_fragment_no_data, null, false);
        likeGridListAdapter.addHeaderView(headerVew);
        headerVew.findViewById(R.id.btn_cart_nodata).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //商品列表数据


        mBinding.lvCartRecyclerview.setLayoutManager(gridLayoutManager);
        mBinding.lvCartRecyclerview.setAdapter(likeGridListAdapter);
        mBinding.lvCartRecyclerview.setNestedScrollingEnabled(false);
        likeGridListAdapter.openLoadAnimation();
        likeGridListAdapter.setOnItemClickListener((adapter, view, position) -> {

            ItemEntity.DataBean model  = (ItemEntity.DataBean) adapter.getItem(position);
            if(StringUtils.isNotEmpty(model.getItemId())){
                //商品详情
                ARouter.getInstance()
                        .build(RouterPath.Item.ROUTE_ITEM_PRODUCTS_PATH)
                        .withString("itemId",model.getItemId())
                        .navigation(getActivity());
            }



        });
    }

    /**
     * 进行购物车操作，选择全部数据
     */
    @Override
    public void selectAllItem() {
        //选择全部按钮

        KLog.i("test","购物车操作流程----点击全部");
        try {
            //检查所有的Item状态
            checkAllItemState(isCartAllCheck);
            isCartAllCheck = !isCartAllCheck;

            //计算选中金额
            CalculateSelectedAmount(currentCartDatalist);


        }catch (Exception e){
            KLog.i("test","购物车操作流程,错误堆栈如下:");
            e.printStackTrace();
        }

    }

    /**
     *检查所有的状态
     * @param check
     */
    private void checkAllItemState(boolean check) {
        if(check){
            //判断状态
            KLog.i("test","全部取消");
            setCartCheckState(false);
            mBinding.layoutLayout1.imgSelect.setImageResource(R.mipmap.icon_cart_cicle);
        }else{
            KLog.i("test","全部选中");
            setCartCheckState(true);
            mBinding.layoutLayout1.imgSelect.setImageResource(R.mipmap.icon_check_agreen);

        }
    }

    /**
     * 计算选中金额
     */
    private void CalculateSelectedAmount(List<CartListEntity.DataBean.CartDetailListBean>  listBeans) {
        try {

        BigDecimal itemtotalMonery = new BigDecimal("0.00");
        //计算业务
        if(listBeans != null && listBeans.size() >0){


            List<String> carList = new ArrayList<>();
            for ( CartListEntity.DataBean.CartDetailListBean model:listBeans) {
                //查看是否选择勾选
                if(model.isGroupCheck()){
                    for (CartListEntity.DataBean.CartDetailListBean.CartItemDetailDTOListBean cartItem : model.getCartItemDetailDTOList()) {
                      //查看孩子是否勾选
                        if(cartItem.isCHeck()){

                            BigDecimal itemTotalMonery = MathUtils.multiply(cartItem.getSkuPrice()).multiply(new BigDecimal(cartItem.getAmount()));
                            itemtotalMonery =  itemtotalMonery.add(itemTotalMonery);
                            KLog.i("test","计算金额:"+ TypeUtils.toString(itemtotalMonery));
                        }

                    }

                }

            }


        }


        mViewModel. totalMonery.set("总价: "+TypeUtils.toString(itemtotalMonery));
        mViewModel.disMonery.set("已优惠￥0.00");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 判断全部选中或者取消选择
     * @param isCartAllCheck
     */
    private void setCartCheckState(boolean isCartAllCheck) {
        if (currentCartDatalist != null && currentCartDatalist.size() > 0) {
            for (CartListEntity.DataBean.CartDetailListBean model : currentCartDatalist) {
                model.setGroupCheck(isCartAllCheck);
                for (CartListEntity.DataBean.CartDetailListBean.CartItemDetailDTOListBean childen : model.getCartItemDetailDTOList()) {
                    childen.setCHeck(isCartAllCheck);
                }
            }

            cartListAdapter.setNewData(currentCartDatalist);
            cartListAdapter.notifyDataSetChanged();
        }
    }

    /**
     * 提交订单
     */
    @Override
    public void checkItemCalculation() {


        if(newCurrentCartDatalist != null && newCurrentCartDatalist.size() >0){

          List<String> carList = new ArrayList<>();
            for ( CartListEntity.DataBean.CartDetailListBean model:newCurrentCartDatalist) {
                if(model.isGroupCheck()){
                    for (CartListEntity.DataBean.CartDetailListBean.CartItemDetailDTOListBean cartItem : model.getCartItemDetailDTOList()) {
                        if(cartItem.isCHeck()){
                            carList.add(TypeUtils.toString(cartItem.getCartId()));
                        }

                    }
                }

            }
            // Join with ", "
            String step1 = StringUtils.join(carList, "\", \"");
            // Wrap step1 with "
            String step2 = StringUtils.wrap(step1, "\"");
            KLog.i("test","打印数据出来："+step2);

            if(carList != null && carList.size() >0){
                String gsonString = TypeUtils.toString(new Gson().toJson(carList));
                ARouter.getInstance()
                        .build(RouterPath.Trade.ROUTE_TRADE_ORDER)
                        .withString("carts", gsonString)
                        .navigation(getActivity());
            }


        }



    }

    @Override
    public void editItem() {

    }



    /**
     * 刷新界面
     * @param
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public  void refresh(String event){

        KLog.i("test","刷新操作开始");
        if(event.equals(CartViewRereshEvent.VIEW_REFSH)){
          loadingData();
        }else if(event.equals(CartViewRereshEvent.VIEW_LOGING_START)){
            loadingDialog.show();
        }else if(event.equals(CartViewRereshEvent.VIEW_LOGIN_FINISH)){
            loadingDialog.dismiss();
        }
    }





    @Override
    protected void onUnbind() {
        super.onUnbind();
    }

    /**
     * 子View选中返回的数据，要重新进行刷新界面的数据再次更新
     * @param childenItem
     * @param FatherItem
     */
    @Override
    public void setSelectIitem(CartListEntity.DataBean.CartDetailListBean.CartItemDetailDTOListBean childenItem,
                               CartListEntity.DataBean.CartDetailListBean FatherItem) {

        try {

            newCurrentCartDatalist.clear();

        KLog.i("test","选中的子View:"+childenItem.getItemName());

        //处理业务逻辑，根虎选中进行操作

        if (currentCartDatalist != null && currentCartDatalist.size() > 0) {

            for (CartListEntity.DataBean.CartDetailListBean model : currentCartDatalist) {

                for (CartListEntity.DataBean.CartDetailListBean.CartItemDetailDTOListBean childenModel: model.getCartItemDetailDTOList()) {
                    if(childenItem.getCartId() == childenModel.getCartId()){
                        childenModel.setCHeck(childenItem.isCHeck);

                    }
                }
            }
            newCurrentCartDatalist.addAll(currentCartDatalist);
            cartListAdapter.setNewData(newCurrentCartDatalist);
            cartListAdapter.notifyDataSetChanged();
        }

            //处理完之后，进行计算业务
            CalculateSelectedAmount(currentCartDatalist);
        }catch (Exception e){
            e.printStackTrace();
        }

    }



    @Override
    protected void receiveEvent(Event event) {
        // 接受到Event后的相关逻辑
        if (event != null) {
            switch (event.getCode()){
                case AppEvent.EventCode.carRefresh:
                    //刷新购物车数据
                    KLog.i("test","主界面调用刷新购物车数据");
                    loadingData();
                    break;
            }
        }

    }



    @Override
    protected boolean isRegisterEventBus() {
        return true;
    }

}
