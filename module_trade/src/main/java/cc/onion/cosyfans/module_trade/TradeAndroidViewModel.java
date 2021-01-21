package cc.onion.cosyfans.module_trade;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.alibaba.android.arouter.launcher.ARouter;
import com.google.gson.Gson;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import cc.onion.cosyfans.base.DoubleUtil;
import cc.onion.cosyfans.base.entity.BaseRequestBean;
import cc.onion.cosyfans.base.entity.BaseResponse;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.network.RetrofitManager;
import cc.onion.cosyfans.base.observer.ResponseObserver;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.MathUtils;
import cc.onion.cosyfans.base.utils.RxUtils;
import cc.onion.cosyfans.base.utils.TypeUtils;
import cc.onion.cosyfans.item.entity.SkuBaseEntity;
import cc.onion.cosyfans.module_trade.api.TradeApi;
import cc.onion.cosyfans.module_trade.dialog.CashCouponDialog;
import cc.onion.cosyfans.module_trade.entity.CartCreateEntity;
import cc.onion.cosyfans.module_trade.entity.CashCouponEntity;
import cc.onion.cosyfans.module_trade.entity.CreateOrderEntity;
import cc.onion.cosyfans.module_trade.entity.PlayRequestEntity;
import cc.onion.cosyfans.module_trade.entity.request.CommitOrderRequest;
import cc.onion.cosyfans.module_trade.entity.request.CreateOrderRequest;
import cc.onion.cosyfans.module_trade.entity.request.IPlay1688Request;
import cc.onion.cosyfans.module_trade.entity.request.ItemCommitEntity;
import cc.onion.cosyfans.module_trade.listener.TradeViewOnClickListener;
import io.reactivex.disposables.Disposable;

/**
 * @author guobihai
 * @version V1.0
 * @Title: AppCommonInfo
 * @Package cc.onion.cosyfans.base.common
 * @date 2019-12-03 14:53
 * @email: anhui-zhuang@msyc.cc
 * @Description: (结算)
 */
public class TradeAndroidViewModel extends AndroidViewModel {

    Activity mContext;
    /**
     * 总价格
     */
    public final ObservableField<String> totalMonery = new ObservableField<>();

    /**
     * address
     */
    public final ObservableField<String> mobile = new ObservableField<>();
    public final ObservableField<String> address = new ObservableField<>();
    public final ObservableField<String> name = new ObservableField<>();

    /**
     * item
     */
    public final ObservableField<String> itemName = new ObservableField<>();
    public final ObservableField<String> itemSku = new ObservableField<>();
    public final ObservableField<String> itemMonery = new ObservableField<>();

    //    	"commodityAmount":"112.60",
    //                "freight":"0.00",
    //                "totalAmount":"112.60",
    //                "totalDiscountPrice":"0.00",
    //                "totalVoucherPrice":"0.00",
    //                "feeConfig":"99.00"
    public final ObservableField<String> commodityAmount = new ObservableField<>();
    public final ObservableField<String> freight = new ObservableField<>();
    public final ObservableField<String> totalAmount = new ObservableField<>();
    public final ObservableField<String> totalAmount2 = new ObservableField<>();
    public final ObservableField<String> totalDiscountPrice = new ObservableField<>();
    public final ObservableField<String> cashPrice = new ObservableField<>();
    public final ObservableField<String> cashPrice1 = new ObservableField<>();
    public final ObservableField<String> totalVoucherPrice = new ObservableField<>();
    public final ObservableField<String> feeConfig = new ObservableField<>();
    public final ObservableField<String> cashCouponId = new ObservableField<>();



    public final ObservableField<Boolean> isShowNullData = new ObservableField<Boolean>(false);
    public final ObservableField<Boolean> isShowAddress = new ObservableField<Boolean>(false);
    /**
     *创建订单对象
     */
    CartCreateEntity.DataBean mCartCareateList;
    TradeViewOnClickListener tradeViewOnClickListener;


    public TradeAndroidViewModel(@NonNull Application application) {
        super(application);
        isShowNullData.set(true);
        isShowAddress.set(false);
    }


    /**
     * 提交订单
     */
    public void commitOrder(){

        if(mCartCareateList != null){
            try {


            CommitOrderRequest request = new CommitOrderRequest();
            request.setTel(mCartCareateList.getTel());
            request.setAddress(mCartCareateList.getAddress());
            request.setAddressIdxCode(TypeUtils.toString(mCartCareateList.getAddressId()));
            request.setUserName(mCartCareateList.getConsignee());
//            request.setCashUserCouponId(mCartCareateList.getUserCouponIdList());
            request.setTel(mCartCareateList.getTel());
                //设置符合接口的json串
                String itemJson = setJsonAttritube();
                request.setOrderItems(itemJson);


            request.getKeyMap().put("address",request.getAddress());
            request.getKeyMap().put("addressIdxCode",request.getAddressIdxCode());
//            request.getKeyMap().put("cashUserCouponId",request.getCashUserCouponId());
            request.getKeyMap().put("tel",request.getTel());
            request.getKeyMap().put("userName",request.getUserName());
            request.getKeyMap().put("orderItems",itemJson);

                request.setRequestSign(request.getKeyMap());

            commitOrder(request, new ResponseListener<CreateOrderEntity>() {
                @Override
                public void loadSuccess(CreateOrderEntity data) {
                    if(data.getData() != null ){
                        KLog.i("test","提交结算界面成功");
                        if(tradeViewOnClickListener != null){
                            tradeViewOnClickListener.toShowPlayDialog(data);
                        }


                    }

                }

                @Override
                public void loadFailed(String errorCode, String errorMsg) {

                    KLog.i("test","提交结算界面失败");
                }

                @Override
                public void addDisposable(Disposable disposable) {
                    addDisposable(disposable);
                }
            });

            }catch (Exception e){
                e.printStackTrace();
            }




        }
    }

    /**
     * 设置符合接口的json串
     * @return
     */
    private String setJsonAttritube() {
        //                "[{'skuId': 230000,'amount': 1,'realFee': 29.77,'promotionId': 0,'userCouponId': 0}]"

        List<ItemCommitEntity> newItemCommitList = new ArrayList<>();
        String itemJson = null;
        if(mCartCareateList.getItemDetails() != null  && mCartCareateList.getItemDetails().size() >0){
            for (CartCreateEntity.DataBean.ItemDetailsBean model:  mCartCareateList.getItemDetails()) {
//                    int skuId, int amount, double realFee, int promotionId, int userCouponId
                BigDecimal itemStr = new BigDecimal("100");
                BigDecimal itemPrice = new BigDecimal(model.getItemPrice());

                Double mulDouble = DoubleUtil.mul(model.getItemPrice(), new Double(100));
                BigDecimal itemTotalMonery = MathUtils.multiply(itemStr).multiply(itemPrice);
                String reelPrice = TypeUtils.toString(itemTotalMonery);
                reelPrice =  MathUtils.formatNumbers(reelPrice);
                KLog.i("test","真实价格："+reelPrice);

                newItemCommitList.add(new ItemCommitEntity(model.getSkuId(),model.getAmount(), reelPrice,model.getPromotionId(),model.getUserCouponId()));
            }
//
            if(newItemCommitList != null && newItemCommitList.size() >0){
                Gson gson = new Gson();
                itemJson = gson.toJson((newItemCommitList));
                itemJson = itemJson.replaceAll("\"","\'");
                KLog.i("test","打印Json串:"+itemJson);
            }

        }
        return itemJson;
    }


    /**
     * 添加地址
     */
    public void addAdddress(){
        ARouter.getInstance().build(RouterPath.MyCosy.ROUTE_MIME_ADDRESS_LIST)
                .greenChannel()
                .navigation();
    }


    public Activity getmContext() {
        return mContext;
    }

    public void setmContext(Activity mContext) {
        this.mContext = mContext;
    }

    /**
     * 获取地址列表
     * @param request
     * @param listener
     */
    public void gotoCreateOrder(CreateOrderRequest request, ResponseListener<CartCreateEntity> listener){
        RetrofitManager
                .createToken(TradeApi.class)
                .gotoCreateOrder(request)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<CartCreateEntity>() {
                    @Override
                    public void onSuccess(CartCreateEntity data) {
                        listener.loadSuccess(data);

                    }

                    @Override
                    public void onError(String code, String msg) {
                        listener.loadFailed(code, msg);
                    }
                });
    }


    /**
     * 获取现金优惠券
     * @param requestBean
     * @param listener
     */
    public void getCashCoupon(BaseRequestBean requestBean,ResponseListener<CashCouponEntity> listener){
        RetrofitManager
                .createToken(TradeApi.class)
                .getCashCoupon(requestBean)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<CashCouponEntity>() {
                    @Override
                    public void onSuccess(CashCouponEntity data) {
                        listener.loadSuccess(data);

                    }

                    @Override
                    public void onError(String code, String msg) {
                        listener.loadFailed(code, msg);
                    }
                });
    }


    /**
     * 打开现金卷
     */
    public void openCasch(){
        BaseRequestBean requestBean = new BaseRequestBean();
        requestBean.sign();
            getCashCoupon(requestBean, new ResponseListener<CashCouponEntity>() {
                @Override
                public void loadSuccess(CashCouponEntity data) {
                    if(data.getData() != null && data.getData().size() >0){
                        CashCouponDialog cashCouponDialog = new CashCouponDialog(getmContext(),data.getData(),totalAmount2.get(),cashCouponId.get());
                        cashCouponDialog.show();
                    }


                }

                @Override
                public void loadFailed(String errorCode, String errorMsg) {
                    KLog.i("test","加载数据失败");
                }

                @Override
                public void addDisposable(Disposable disposable) {
                    addDisposable(disposable);
                }
            });
//

    }



    /**
     * 创建，提交参数
     * @param requestBean
     * @param listener
     */
    public void commitOrder(CommitOrderRequest requestBean, ResponseListener<CreateOrderEntity> listener){
        RetrofitManager
                .createToken(TradeApi.class)
                .createOrder(requestBean)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<CreateOrderEntity>() {
                    @Override
                    public void onSuccess(CreateOrderEntity data) {
                        listener.loadSuccess(data);

                    }

                    @Override
                    public void onError(String code, String msg) {
                        listener.loadFailed(code, msg);
                    }
                });
    }


    /**
     * 对接play1688返回相应对应参数
     * @param requestBean
     * @param listener
     */
    public void doPlay1688(IPlay1688Request requestBean, ResponseListener<PlayRequestEntity> listener){
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





    public CartCreateEntity.DataBean getmCartCareateList() {
        return mCartCareateList;
    }

    public void setmCartCareateList(CartCreateEntity.DataBean mCartCareateList) {
        this.mCartCareateList = mCartCareateList;
    }

    public TradeViewOnClickListener getTradeViewOnClickListener() {
        return tradeViewOnClickListener;
    }

    public void setTradeViewOnClickListener(TradeViewOnClickListener tradeViewOnClickListener) {
        this.tradeViewOnClickListener = tradeViewOnClickListener;
    }
}
