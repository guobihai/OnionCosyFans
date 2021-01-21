package cc.onion.cosyfans.module_trade;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.ipay.IPayIH;
import com.ipay.IPayIHPayment;

import org.apache.commons.lang3.StringUtils;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.NotSerializableException;
import java.util.List;

import cc.onion.cosyfans.base.BaseToolBarActivity;
import cc.onion.cosyfans.base.entity.BaseResponse;
import cc.onion.cosyfans.base.event.CartViewRereshEvent;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.KLogUtils;
import cc.onion.cosyfans.base.utils.SoftKeyBoardUtils;
import cc.onion.cosyfans.base.utils.ToastUtil;
import cc.onion.cosyfans.base.utils.TypeUtils;
import cc.onion.cosyfans.base.view.loadView.ULoadView;
import cc.onion.cosyfans.cart.entity.response.CartListEntity;
import cc.onion.cosyfans.item.entity.SkuBaseEntity;
import cc.onion.cosyfans.module_trade.adapter.ProductsAdapter;
import cc.onion.cosyfans.module_trade.databinding.TradeOrderBinding;
import cc.onion.cosyfans.module_trade.dialog.PlayListDialog;
import cc.onion.cosyfans.module_trade.entity.AddressListEntity;
import cc.onion.cosyfans.module_trade.entity.CartCreateEntity;
import cc.onion.cosyfans.module_trade.entity.CreateOrderEntity;
import cc.onion.cosyfans.module_trade.entity.PlayListEntity;
import cc.onion.cosyfans.module_trade.entity.PlayRequestEntity;
import cc.onion.cosyfans.module_trade.entity.request.CreateOrderRequest;
import cc.onion.cosyfans.module_trade.entity.request.IPlay1688Request;
import cc.onion.cosyfans.module_trade.event.ActiviytStateEvent;
import cc.onion.cosyfans.module_trade.event.PlayTypeEvent;
import cc.onion.cosyfans.module_trade.listener.PlayOnClickListener;
import cc.onion.cosyfans.module_trade.listener.TradeViewOnClickListener;
import cc.onion.cosyfans.module_trade.play.ResultDelegate;
import cc.onion.cosyfans.passport.Event.PlayResultEvent;
import cc.onion.cosyfans.passport.Event.SigninPageEvent;
import io.reactivex.disposables.Disposable;

/**
 * @author guobihai
 * @version V1.0
 * @Title: AppCommonInfo
 * @Package cc.onion.cosyfans.base.common
 * @date 2019-12-03 14:53
 * @email: anhui-zhuang@msyc.cc
 * @Description: (提交订单结算界面)
 */
@Route(path = RouterPath.Trade.ROUTE_TRADE_ORDER)
public class TradeAcivity extends BaseToolBarActivity<TradeOrderBinding,TradeAndroidViewModel> implements TradeViewOnClickListener, PlayOnClickListener {

    private static String TAG_MONERY =  "-￥";

    ProductsAdapter productsAdapter;

    private ULoadView loadVew;


    /**
     * 购物车数据
     */
    List<CartListEntity.DataBean.CartDetailListBean> currentCartDatalist;

    //购物车数据
    @Autowired
    String carts;

    /**
     * 现金卷价格
     */
    String CashPrice;


    /**
     * 基本属性
     */
    CartCreateEntity.DataBean mCreateOrderData;

    /**
     * 订单对象
     */
    CreateOrderEntity.DataBean  orderNumber;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trade_order);
        setToolbarTitle("提交订单");
        mBinding.setViewModel(mViewModel);
        mViewModel.setmContext(this);
        mViewModel.setTradeViewOnClickListener(this);
        EventBus.getDefault().register(this);
    }

    @Override
    public void initParam() {
        // 获取ARouter注入
        ARouter.getInstance().inject(this);
    }

    @Override
    public void initData() {
        super.initData();

        loadVew = new ULoadView(mBinding.body);
        loadVew.showLoading();
        initRecleyew();
        loadData();
    }

    private void initRecleyew() {
        productsAdapter = new ProductsAdapter(this,null);
        mBinding.rlItem.setLayoutManager(new LinearLayoutManager(this,1,false));
        mBinding.rlItem.setAdapter(productsAdapter);
    }

    /**
     * 初始化数据
     */
    private void loadData() {
        KLog.i("test","json数据初始化"+carts);
        CreateOrderRequest request = new CreateOrderRequest();
        request.setCartIds(carts);
        request.getKeyMap().put("cartIds",carts);
        request.setRequestSign(request.getKeyMap());
        mViewModel.gotoCreateOrder(request, new ResponseListener<CartCreateEntity>() {
            @Override
            public void loadSuccess(CartCreateEntity data) {
                loadVew.hide();
                if(data.getData() != null){
                    mCreateOrderData = data.getData();
                    //设置数据对象到model
                    mViewModel.setmCartCareateList(data.getData());
                    //判断地址是否为空，判断显示地址布局
                    CartCreateEntity.DataBean item = data.getData();
                    if(StringUtils.isNotEmpty(data.getData().getConsignee()) && StringUtils.isNotEmpty(data.getData().getAddress())){
                        mViewModel.isShowAddress.set(true);
                        mViewModel.isShowNullData.set(false);

                        if(StringUtils.isNotEmpty(item.getAddress())){
                            mViewModel.address.set(item.getAddress());
                        }
                        if(StringUtils.isNotEmpty(item.getConsignee())){
                            mViewModel.name.set(item.getConsignee());
                        }
                        if(StringUtils.isNotEmpty(item.getTel())){
                            mViewModel.mobile.set(item.getTel());
                        }
                    }else{
                        mViewModel.isShowAddress.set(false);
                        mViewModel.isShowNullData.set(true);
                    }

                    //addapter
                    if(data.getData().getItemDetails() !=null && data.getData().getItemDetails().size() >0){
                        productsAdapter.setNewData(data.getData().getItemDetails());
                        productsAdapter.notifyDataSetChanged();
                    }


                    //    	        "commodityAmount":"112.60",
                    //                "freight":"0.00",
                    //                "totalAmount":"112.60",
                    //                "totalDiscountPrice":"0.00",
                    //                "totalVoucherPrice":"0.00",
                    //                "feeConfig":"99.00"
                    mViewModel.commodityAmount.set(TAG_MONERY+item.getCommodityAmount());
                    mViewModel.freight.set(TAG_MONERY+item.getFreight());
                    mViewModel.totalAmount.set(TAG_MONERY+item.getTotalAmount());
                    mViewModel.totalAmount2.set(item.getTotalAmount());//设置金额数据
                    mViewModel.cashCouponId.set(item.getCashCouponId());

                    mViewModel.totalDiscountPrice.set(TAG_MONERY+item.getTotalDiscountPrice());
                    mViewModel.totalVoucherPrice.set(TAG_MONERY+item.getTotalVoucherPrice());

                    try {


                        if(!StringUtils.isNotEmpty(item.getCashPrice())){
                            //null
                            mViewModel.totalMonery.set("订单总额:"+ TAG_MONERY+TypeUtils.toString(item.getTotalAmount()));
                        }else{
                            Double totoalMonunt = Double.parseDouble(item.getTotalAmount());
                            Double coshPrice = Double.parseDouble(item.getCashPrice());
                            mViewModel.totalMonery.set("订单总额:"+ TAG_MONERY+TypeUtils.toString(totoalMonunt -coshPrice));
                        }


                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    if(item.getFreight().equals("0.00")){
                        mViewModel.freight.set("包邮");
                    }else{
                        mViewModel.freight.set(TAG_MONERY+item.getFreight());
                    }

                    if(StringUtils.isNotEmpty(item.getCashPrice())){
                        mViewModel.cashPrice.set(TAG_MONERY+item.getCashPrice());
                        mViewModel.cashPrice1.set(TAG_MONERY+item.getCashPrice());
                    }else{
                        mViewModel.cashPrice.set("0张可用");
                        mViewModel.cashPrice1.set( TAG_MONERY+"0.00");
                    }

                }


            }

            @Override
            public void loadFailed(String errorCode, String errorMsg) {
                loadVew.hide();

            }

            @Override
            public void addDisposable(Disposable disposable) {

                addSubscription(disposable);
            }
        });
    }



    @Subscribe(threadMode = ThreadMode.MAIN)
    public void handelEvent(String event) {
        SoftKeyBoardUtils.closeKeyBoard(this);
        switch (event){
            case PlayResultEvent.SUCCESS:
                if(orderNumber != null){
                    if(StringUtils.isNotEmpty(orderNumber.getOrderNo())){
                        ARouter.getInstance()
                                .build(RouterPath.Trade.ROUTE_TRADE_PLAY_RESULE)
                                .withString("totalMonery",mCreateOrderData.getTotalAmount())
                                .withString("orderNumber",orderNumber.getOrderNo())
                                .withInt("orderState",1)
                                .navigation(this,10001);
                    }
                }
                break;
            case PlayResultEvent.ERROR:
                if(StringUtils.isNotEmpty(orderNumber.getOrderNo())){
                    ARouter.getInstance()
                            .build(RouterPath.Trade.ROUTE_TRADE_PLAY_RESULE)
                            .withString("totalMonery",mCreateOrderData.getTotalAmount())
                            .withString("orderNumber",orderNumber.getOrderNo())
                            .withInt("orderState",2)
                            .navigation(this,10001);
                }

                break;
            case PlayResultEvent.CANCLE:
                if(StringUtils.isNotEmpty(orderNumber.getOrderNo())){
                    ARouter.getInstance()
                            .build(RouterPath.Trade.ROUTE_TRADE_PLAY_RESULE)
                            .withString("totalMonery",mCreateOrderData.getTotalAmount())
                            .withString("orderNumber",orderNumber.getOrderNo())
                            .withInt("orderState",3)
                            .navigation(this,10001);
                }
                break;

        }



    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 10000){
            ToastUtil.Short("tt");
            AddressListEntity address = (AddressListEntity) data.getSerializableExtra("address");
            KLog.i("test","返回数据成功");

        }else if(requestCode == 10001){
            //回到主页
            finish();
            EventBus.getDefault().post(CartViewRereshEvent.VIEW_REFSH);
        }
    }




    /**
     * 订单支付操作，唤醒第三方支付操作
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




                                Intent selectionIntent = IPayIH.getInstance().checkout(payment, this,
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


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    /**
     * 展示支付对话框
     * @param data
     */
    @Override
    public void toShowPlayDialog(CreateOrderEntity data) {
        if(data != null){
            orderNumber = data.getData();
            PlayListDialog playListDialog = new PlayListDialog(this,data.getData().getOrderNo(),this);
            if(!playListDialog.isShowing()){
                playListDialog.show();
            }
        }

    }

    /**
     * 回调支付第三方的操作
     * @param item
     */
    @Override
    public void toPlayResule(PlayListEntity.DataBean item,String orderNumber) {
        KLog.i("test","执行支付操作");
        if(orderNumber != null){
            //支付
            IPlay1688Request iPlay1688Request = new IPlay1688Request();
            iPlay1688Request.setOrderNo(orderNumber);
            iPlay1688Request.setPaymentId(TypeUtils.toString(item.getId()));
//            iPlay1688Request.setShopId("");

            iPlay1688Request.getKeyMap().put("orderNo",orderNumber);
            iPlay1688Request.getKeyMap().put("paymentId",TypeUtils.toString(item.getId()));
            iPlay1688Request.setRequestSign(iPlay1688Request.getKeyMap());

            mViewModel.doPlay1688(iPlay1688Request, new ResponseListener<PlayRequestEntity>() {
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


}
