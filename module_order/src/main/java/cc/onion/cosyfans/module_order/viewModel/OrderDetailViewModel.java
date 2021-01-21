package cc.onion.cosyfans.module_order.viewModel;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.alibaba.android.arouter.launcher.ARouter;

import java.util.List;

import cc.onion.cosyfans.base.entity.BaseRequestBean;
import cc.onion.cosyfans.base.entity.BaseResponse;
import cc.onion.cosyfans.base.interfaces.ResponseListener;
import cc.onion.cosyfans.base.network.RetrofitManager;
import cc.onion.cosyfans.base.observer.ResponseObserver;
import cc.onion.cosyfans.base.router.RouterPath;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.RxUtils;
import cc.onion.cosyfans.item.entity.SkuBaseEntity;
import cc.onion.cosyfans.module_order.api.OrderApi;
import cc.onion.cosyfans.module_order.entity.ConfimOrderEntity;
import cc.onion.cosyfans.module_order.entity.OrderAfterEntity;
import cc.onion.cosyfans.module_order.entity.OrderDetailEntity;
import cc.onion.cosyfans.module_order.entity.OrderRequest;
import cc.onion.cosyfans.module_order.entity.request.ConfimRequest;
import cc.onion.cosyfans.module_trade.api.TradeApi;
import cc.onion.cosyfans.module_trade.dialog.CashCouponDialog;
import cc.onion.cosyfans.module_trade.entity.CartCreateEntity;
import cc.onion.cosyfans.module_trade.entity.CashCouponEntity;
import cc.onion.cosyfans.module_trade.entity.PlayListEntity;
import cc.onion.cosyfans.module_trade.entity.PlayRequestEntity;
import cc.onion.cosyfans.module_trade.entity.request.CreateOrderRequest;
import cc.onion.cosyfans.module_trade.entity.request.IPlay1688Request;
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
public class OrderDetailViewModel extends AndroidViewModel {

    Activity mContext;

    public final ObservableField<String> orderNumber = new ObservableField<>();
    public final ObservableField<String> orderTime = new ObservableField<>();
    /**
     * 倒计时
     */
    public final ObservableField<String> countdownTime = new ObservableField<>("00:00:00");


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
    public final ObservableField<String> totalVoucherPrice = new ObservableField<>();
    public final ObservableField<String> feeConfig = new ObservableField<>();

    //time
    public final ObservableField<String> createTime = new ObservableField<>();
    //play time
    public final ObservableField<String> playTime = new ObservableField<>();

    public final ObservableField<Boolean> isShowNullData = new ObservableField<Boolean>(false);
    public final ObservableField<Boolean> isShowAddress = new ObservableField<Boolean>(false);

    //显示物流
    public final ObservableField<Boolean> isShowLogsic = new ObservableField<Boolean>(false);
    public final ObservableField<Boolean> isShowPlay = new ObservableField<Boolean>(false);






    public OrderDetailViewModel(@NonNull Application application) {
        super(application);
        isShowNullData.set(true);
        isShowAddress.set(false);
    }


    /**
     * 提交订单
     */
    public void commitOrder(){

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
                        CashCouponDialog cashCouponDialog = new CashCouponDialog(getmContext(),data.getData(), totalAmount2.get(), totalAmount2.get());
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

    }


    /**
     * 获取订单详情界面内容
     * @param request
     * @param listener
     */
    public void getOrderDetail(OrderRequest request , ResponseListener<OrderDetailEntity> listener){
        RetrofitManager
                .createToken(OrderApi.class)
                .getOrderDetail(request)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<OrderDetailEntity>() {
                    @Override
                    public void onSuccess(OrderDetailEntity data) {
                        listener.loadSuccess(data);

                    }

                    @Override
                    public void onError(String code, String msg) {
                        listener.loadFailed(code, msg);
                    }
                });
    }


    /**
     * 确认订单
     * @param request
     * @param listener
     */
    public void confimOrder(ConfimRequest request , ResponseListener<ConfimOrderEntity> listener){
        RetrofitManager
                .createToken(OrderApi.class)
                .confirmOrder(request)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<ConfimOrderEntity>() {
                    @Override
                    public void onSuccess(ConfimOrderEntity data) {
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
     * 取消订单
     * @param request
     * @param listener
     */
    public void cancelOrder(ConfimRequest request,ResponseListener<BaseResponse> listener){
                RetrofitManager
                .createToken(OrderApi.class)
                .cancelOrder(request)
                .compose(RxUtils.schedulersTransformer())
                .subscribe(new ResponseObserver<BaseResponse>() {
                    @Override
                    public void onSuccess(BaseResponse data) {
                        listener.loadSuccess(data);

                    }

                    @Override
                    public void onError(String code, String msg) {
                        listener.loadFailed(code, msg);
                    }
                });
    }

}
