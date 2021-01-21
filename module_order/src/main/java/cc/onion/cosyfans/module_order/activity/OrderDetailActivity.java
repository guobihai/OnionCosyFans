package cc.onion.cosyfans.module_order.activity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.KeyEvent;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.ipay.IPayIH;
import com.ipay.IPayIHPayment;
import com.jakewharton.rxbinding2.view.RxView;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import cc.onion.cosyfans.base.BaseToolBarActivity;
import cc.onion.cosyfans.base.dialog.DeleteOrConfirmCheckDialog;
import cc.onion.cosyfans.base.entity.BaseResponse;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.KLogUtils;
import cc.onion.cosyfans.base.utils.TimeTools;
import cc.onion.cosyfans.base.utils.ToastUtil;
import cc.onion.cosyfans.base.utils.TypeUtils;
import cc.onion.cosyfans.base.view.loadView.ULoadView;
import cc.onion.cosyfans.item.entity.SkuBaseEntity;
import cc.onion.cosyfans.module_order.OrderState;
import cc.onion.cosyfans.module_order.R;
import cc.onion.cosyfans.module_order.adapter.OrderDetailItemAdapter;
import cc.onion.cosyfans.module_order.api.OrderApi;
import cc.onion.cosyfans.module_order.databinding.OrderDetailBinding;
import cc.onion.cosyfans.module_order.dialog.LogsicDialog;
import cc.onion.cosyfans.module_order.entity.ConfimOrderEntity;
import cc.onion.cosyfans.module_order.entity.OrderAfterEntity;
import cc.onion.cosyfans.module_order.entity.OrderDetailEntity;
import cc.onion.cosyfans.module_order.entity.OrderRequest;
import cc.onion.cosyfans.module_order.entity.request.ConfimRequest;
import cc.onion.cosyfans.module_order.viewModel.OrderDetailViewModel;
import cc.onion.cosyfans.module_trade.dialog.PlayListDialog;
import cc.onion.cosyfans.module_trade.entity.CartCreateEntity;
import cc.onion.cosyfans.module_trade.entity.CreateOrderEntity;
import cc.onion.cosyfans.module_trade.entity.PlayListEntity;
import cc.onion.cosyfans.module_trade.entity.PlayRequestEntity;
import cc.onion.cosyfans.module_trade.entity.request.IPlay1688Request;
import cc.onion.cosyfans.module_trade.listener.PlayOnClickListener;
import cc.onion.cosyfans.module_trade.play.ResultDelegate;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.activity.order
 * @ClassName: OrderDetailActivity
 * @Description: 订单详情
 * @Author: guobihai
 * @CreateDate: 2019-12-12 17:10
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-12 17:10
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Route(path = RouterPath.Order.ROUTE_ORDER_DETAIL)
public class OrderDetailActivity extends BaseToolBarActivity<OrderDetailBinding, OrderDetailViewModel> implements PlayOnClickListener {

    private static final int WHAT = 101;
    private static String TAG_MONERY =  "-￥";
    private static String TAG_MONERY2 =  "￥";

    /**
     * 售后的订单
     */
    private String orderItemIds;


    @Autowired
    String orderNo;

    private ULoadView loadVew;

    private OrderDetailItemAdapter detailFatherAdapter;


    private Timer mTimer;
    private TimerTask mTimerTask;
    //
    private static final long MAX_TIME = 40*60*1000;
    private long curTime = 0;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_detail);
        setToolbarTitle("订单详情");
        mBinding.setViewModel(mViewModel);
    }

    @Override
    public void initData() {
        super.initData();
        loadVew = new ULoadView(mBinding.body);
        loadVew.showLoading();
        initRecleyew();
        if(StringUtils.isNotEmpty(orderNo)){
            loadData();
        }


    }

    private void initRecleyew() {
        detailFatherAdapter = new OrderDetailItemAdapter(null,this);
        mBinding.rlItem.setLayoutManager(new LinearLayoutManager(this,1,false));
        mBinding.rlItem.setAdapter(detailFatherAdapter);
    }

    @Override
    public void initParam() {
        ARouter.getInstance().inject(this);
    }


    private void loadData() {
        OrderRequest request = new OrderRequest();
        request.setOrderNo(orderNo);
        request.setRole(1);
        request.getKeyMap().put("orderNo",request.getOrderNo());
        request.getKeyMap().put("role",1);
        request.setRequestSign(request.getKeyMap());
        mViewModel.getOrderDetail(request, new ResponseListener<OrderDetailEntity>() {
            @Override
            public void loadSuccess(OrderDetailEntity data) {
                KLog.i("test","加载数据成功:");
                loadVew.hide();
                try {


                if(data.getData() != null){
                    //设置数据对象到model
//                    mViewModel.setmCartCareateList(data.getData());
                    //判断地址是否为空，判断显示地址布局
                    OrderDetailEntity.DataBean item = data.getData();
                    //设置页面基本属性
                    setLayoutAttritube(data, item);

                    //orderStatus
//                    订单状态(1待支付，2已支付，3.已完成,4.已取消,5.支付超时,6.售后中)
//                    isAfterSalesDisplay	number
//                    非必须
//                    售后按钮是否显示（0：否，1：是）
//                    delayedReceipt	number
//                    非必须
//                    延迟收货状态（0：否，1：是）
//                    isDelayedReceiptDisplay	number
//                    非必须
//                    延迟收货按钮是否显示（0：否，1：是）

                    mViewModel.isShowLogsic.set(false);
                    mBinding.layoutTime.setVisibility(View.GONE);
                    mBinding.orderTime.setVisibility(View.GONE);

                    if(item.getOrderStatusCode() == OrderState.ORDER_ONE){

                        //待支付
                        toBePaid(item);

                    }else if(item.getOrderStatusCode() == OrderState.ORDER_TWO){
                        //处理运输中流程
                        InTransitOrder(item);

                    }else if(item.getOrderStatusCode() == OrderState.ORDER_THREE){
                        mBinding.tvOrderStateTitle.setText("已完成");

                    }else if(item.getOrderStatusCode() == OrderState.ORDER_FOUR){
                        mBinding.tvOrderStateTitle.setText("已取消");

                    }else if(item.getOrderStatusCode() == OrderState.ORDER_FIVE){
                        mBinding.tvOrderStateTitle.setText("支付超时");
                        mViewModel.orderNumber.set("订单关闭");

                    }else if(item.getOrderStatusCode() == OrderState.ORDER_SEVENT){
                        mBinding.tvOrderStateTitle.setText("售后中");

                    }else{

                    }
                }

                }catch (Exception E){
                    E.printStackTrace();
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

    /**
     * 待支付
     * @param item
     */
    @SuppressLint("CheckResult")
    private void toBePaid(OrderDetailEntity.DataBean item) {
        mBinding.tvOrderStateTitle.setText("待支付");
        mBinding.orderTime.setVisibility(View.VISIBLE);
        mBinding.layoutTime.setVisibility(View.VISIBLE);
        mViewModel.isShowPlay.set(true);


        initTimer();
        mTimer.schedule(mTimerTask, 0, 1000);
        mViewModel.orderTime.set("超时订单自动取消");
        mBinding.tvPlay.setOnClickListener(v -> {
                    RxView.clicks( mBinding.tvPlay)
                            .throttleFirst(1, TimeUnit.SECONDS)
                            .subscribe(new Consumer<Object>() {

                                @Override
                                public void accept(Object o) throws Exception {
                                    //支付
                                    if(StringUtils.isNotEmpty(item.getOrderNo())){
                                        orderNo = item.getOrderNo();
                                        PlayListDialog playListDialog = new PlayListDialog(OrderDetailActivity.this,item.getOrderNo(),
                                                OrderDetailActivity.this);
                                        if(!playListDialog.isShowing()){
                                            playListDialog.show();
                                        }

                                    }
                                }
                            });


        });

        mBinding.tvCancle.setOnClickListener(v -> {
            RxView.clicks( mBinding.tvCancle)
                    .throttleFirst(1, TimeUnit.SECONDS)
                    .subscribe(new Consumer<Object>() {

                                   @Override
                                   public void accept(Object o) throws Exception {
                                       //取消订单
                                       DeleteOrConfirmCheckDialog dialog = new DeleteOrConfirmCheckDialog(OrderDetailActivity.this,getString(R.string.order_cancle_order),
                                               getString(R.string.order_concle_ordr_config));
                                       dialog.show();
                                       dialog.setDialogClickListener(new DeleteOrConfirmCheckDialog.AlertDialogClickListener() {
                                           @Override
                                           public void onCancel() {
                                               dialog.dismiss();

                                           }

                                           @Override
                                           public void onOk() {
                                               //取消订单
                                               cancleOrder();
                                               dialog.dismiss();
                                           }
                                       });

                                   }
                                   });


        });

    }

    /**
     * 设置页面基本属性
     * @param data
     * @param item
     */
    private void setLayoutAttritube(OrderDetailEntity data, OrderDetailEntity.DataBean item) {
        if(StringUtils.isNotEmpty(data.getData().getAddress())){
            mViewModel.isShowAddress.set(true);
            mViewModel.isShowNullData.set(false);

            if(StringUtils.isNotEmpty(item.getAddress())){
                mViewModel.address.set(item.getAddress());
            }
            if(StringUtils.isNotEmpty(item.getUserName())){
                mViewModel.name.set(item.getUserName());
            }
            if(StringUtils.isNotEmpty(item.getTel())){
                mViewModel.mobile.set(item.getTel());
            }
        }else{
            mViewModel.isShowAddress.set(false);
            mViewModel.isShowNullData.set(true);
        }


        //时间
        if(StringUtils.isNotEmpty(item.getCreateTime())){
            mViewModel.createTime.set(item.getCreateTime());
        }
        if(StringUtils.isNotEmpty(item.getPayTime())){
            mViewModel.playTime.set(item.getPayTime());
        }


        //订单小计

        mViewModel.totalAmount.set(TAG_MONERY+item.getOrderSaleFee());
        mViewModel.totalDiscountPrice.set(TAG_MONERY+item.getOrderDiscountFee());
        mViewModel.cashPrice.set(TAG_MONERY+item.getCashCouponFee());
        mViewModel.totalVoucherPrice.set(TAG_MONERY+item.getOrderCouponFee());
        mViewModel.freight.set(TAG_MONERY+item.getFreight());

        //总计
        mViewModel.totalMonery.set(TAG_MONERY2+item.getOrderTotalFee());

        //商品列表
        if(item.getOrderItemList() != null && item.getOrderItemList().size() >0){
            detailFatherAdapter.setNewData(item.getOrderItemList());
            detailFatherAdapter.notifyDataSetChanged();
        }


        //订单状态
        if(StringUtils.isNotEmpty(item.getOrderNo())){
            mBinding.tvOrderNumber.setText(item.getOrderNo());
        }
        if(StringUtils.isNotEmpty(item.getOrderStatus())){
            mBinding.tvOrderState.setText(item.getOrderStatus());
        }
        //订单时间
        if(StringUtils.isNotEmpty(item.getOrderNo())){
            mViewModel.orderNumber.set("订单号"+item.getOrderNo());
        }
        if(StringUtils.isNotEmpty(item.getPayTime())){
            mViewModel.orderTime.set("支付时间:"+item.getPayTime());
        }


        //订单总价格
        //物流时效
        mBinding.tvSaleMonery.setText("总计:"+TAG_MONERY2+item.getOrderSaleFee());
        mBinding.tvLogistics.setText("物流时效:"+item.getTimelinessStr());
    }

    /**
     * 处理运输中流程
     * @param item
     */
    @SuppressLint("CheckResult")
    private void InTransitOrder(OrderDetailEntity.DataBean item) {
        mBinding.tvOrderStateTitle.setText("已支付");
        mViewModel.isShowLogsic.set(true);
        mBinding.orderTime.setVisibility(View.VISIBLE);
        if(item.getIsAfterSalesDisplay() ==1){
            mBinding.tvPlay.setText(getString(R.string.order_play_return_monery));
            mBinding.tvPlay.setBackgroundResource(R.drawable.order_btn_bg);
            mBinding.tvPlay.setTextColor(getResources().getColor(R.color.text));
            mBinding.tvPlay.setVisibility(View.VISIBLE);
        }else{
            mBinding.tvPlay.setVisibility(View.GONE);
        }

        if(item.getIsDelayedReceiptDisplay() ==1){
            mBinding.tvCancle.setText(getString(R.string.order_play_return_monery));
            mBinding.tvCancle.setVisibility(View.VISIBLE);
        }else{
            mBinding.tvCancle.setVisibility(View.GONE);
        }

        mBinding.tvCancle.setText(getString(R.string.order_play_return_monery));

        mBinding.tvOk.setOnClickListener(v -> {
            //确认订单
            checkOrder();
        });
        mBinding.tvLogisc.setOnClickListener(v -> {

            RxView.clicks( mBinding.tvLogisc)
                    .throttleFirst(1, TimeUnit.SECONDS)
                    .subscribe(new Consumer<Object>() {
                        @Override
                        public void accept(Object o) throws Exception {
                            //查看物流
                            LogsicDialog logsicDialog = new LogsicDialog(OrderDetailActivity.this);
                            logsicDialog.onShow();
                        }
                    });


        });


        mBinding.tvPlay.setOnClickListener(v -> {
//            @Autowired
//            String orderNo;
//
//            /**
//             * 订单商品项ID集合，多个以,隔开
//             */
//            @Autowired
//            String orderItemIds;
//
//            /**
//             * 时间差（0:整单售后，1：单个售后）
//             */
//            @Autowired
//            String timeDifference;



            //退款
            ARouter.getInstance().build(RouterPath.Order.ROUTE_ORDER_DETAIL_AFTER_SALSE)
                    .withString("orderNo",item.getOrderNo())
                    .withString("timeDifference","0")
                    .greenChannel()
                    .navigation();

        });
        mBinding.tvCancle.setOnClickListener(v -> {

        });

    }

    /**
     * 确认订单
     */
    private void checkOrder() {
        RxView.clicks(mBinding.tvCancle)
                .throttleFirst(1, TimeUnit.SECONDS)
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        DeleteOrConfirmCheckDialog dialog = new DeleteOrConfirmCheckDialog(OrderDetailActivity.this,
                                getString(R.string.order_confim),getString(R.string.order_confim_str));
                        dialog.show();
                        dialog.setDialogClickListener(new DeleteOrConfirmCheckDialog.AlertDialogClickListener() {
                            @Override
                            public void onCancel() {
                                dialog.dismiss();

                            }

                            @Override
                            public void onOk() {
                                confimOrder();
                                dialog.dismiss();
                            }
                        });
                    }
                });


    }

    /**
     * 确认订单
     */
    private void confimOrder() {
        ConfimRequest request = new ConfimRequest();
        request.setOrderNo(orderNo);
        request.getKeyMap().put("orderNo",orderNo);
        request.setRequestSign(request.getKeyMap());

        mViewModel.confimOrder(request, new ResponseListener<ConfimOrderEntity>() {
            @Override
            public void loadSuccess(ConfimOrderEntity data) {
                if(data.getData()!= null){
                    if(data.getStatus() ==200){
                        ToastUtil.Short(data.getMsg());
                        mBinding.tvOk.setVisibility(View.GONE);
                    }else{
                        ToastUtil.Short(data.getMsg());
                    }

                }

            }

            @Override
            public void loadFailed(String errorCode, String errorMsg) {
                KLog.i("test","确认订单失败");
            }

            @Override
            public void addDisposable(Disposable disposable) {
                addSubscription(disposable);
            }
        });
    }


    /**
     * 取消订单
     */
    private void cancleOrder() {
        ConfimRequest request = new ConfimRequest();
        request.setOrderNo(orderNo);
        request.getKeyMap().put("orderNo",orderNo);
        request.setRequestSign(request.getKeyMap());

        mViewModel.cancelOrder(request, new ResponseListener<BaseResponse>() {
            @Override
            public void loadSuccess(BaseResponse data) {
                if(data.getStatus().equals("200")){
//                    ToastUtil.Short(data.getMsg());
                    mViewModel.isShowPlay.set(false);
                    loadData();
                }else{
                    ToastUtil.Short(data.getMsg());
                }

            }

            @Override
            public void loadFailed(String errorCode, String errorMsg) {
                KLog.i("test","取消订单失败");
            }

            @Override
            public void addDisposable(Disposable disposable) {
                addSubscription(disposable);
            }
        });
    }




    /**
     * 初始化Timer
     */
    public void initTimer() {
        mTimerTask = new TimerTask() {
            @Override
            public void run() {
                if (curTime == 0) {
                    curTime = MAX_TIME;
                } else {
                    curTime -= 1000;
                }
                Message message = new Message();
                message.what = WHAT;
                message.obj = curTime;
                mHandler.sendMessage(message);
            }
        };
        mTimer = new Timer();
    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case WHAT:
                    long sRecLen = (long) msg.obj;
                    //毫秒换成00:00:00格式的方式，自己写的。
                    mViewModel.countdownTime.set(TimeTools.getCountTimeByLong(sRecLen));
                    if (sRecLen <= 0) {
                        mTimer.cancel();
                        curTime = 0;
                        //操作
                        loadData();
                    }
                    break;
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        destroyTimer();
        if (mHandler != null) {
            mHandler.removeMessages(WHAT);
            mHandler = null;
        }

    }

    /**
     * destory上次使用的
     */
    public void destroyTimer() {
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }
        if (mTimerTask != null) {
            mTimerTask.cancel();
            mTimerTask = null;
        }
    }

    @Override
    public void toPlayResule(PlayListEntity.DataBean item,String orderNumbers) {
        KLog.i("test","执行支付操作");
        if(StringUtils.isNotEmpty(orderNumbers)){
            //支付
            IPlay1688Request iPlay1688Request = new IPlay1688Request();
            iPlay1688Request.setOrderNo(orderNumbers);
            iPlay1688Request.setPaymentId(TypeUtils.toString(item.getId()));
//            iPlay1688Request.setShopId("");

            iPlay1688Request.getKeyMap().put("orderNo",orderNumbers);
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



}
