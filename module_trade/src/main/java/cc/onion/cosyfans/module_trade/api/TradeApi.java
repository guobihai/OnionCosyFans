package cc.onion.cosyfans.module_trade.api;

import cc.onion.cosyfans.base.entity.BaseRequestBean;
import cc.onion.cosyfans.base.entity.BaseResponse;
import cc.onion.cosyfans.cart.entity.CartRequest;
import cc.onion.cosyfans.cart.entity.response.CartListEntity;
import cc.onion.cosyfans.module_trade.entity.CartCreateEntity;
import cc.onion.cosyfans.module_trade.entity.CashCouponEntity;
import cc.onion.cosyfans.module_trade.entity.CreateOrderEntity;
import cc.onion.cosyfans.module_trade.entity.PlayListEntity;
import cc.onion.cosyfans.module_trade.entity.PlayRequestEntity;
import cc.onion.cosyfans.module_trade.entity.request.CommitOrderRequest;
import cc.onion.cosyfans.module_trade.entity.request.CreateOrderRequest;
import cc.onion.cosyfans.module_trade.entity.request.IPlay1688Request;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 *
 * @author guobihai
 * @date :2019-11-18
 */
public interface TradeApi {

    /**
     * 查询购物车
     */
    @POST("/cart/gotoCreateOrder")
    Observable<CartCreateEntity> gotoCreateOrder(@Body CreateOrderRequest requestBean);


    /**
     * 领取现金卷
     * @param requestBean
     * @return
     */
    @POST("/cart/cashCoupon")
    Observable<CashCouponEntity> getCashCoupon(@Body BaseRequestBean requestBean);


    /**
     * 获取优惠券
     * @param requestBean
     * @return
     */
    @POST("/cart/userCoupon")
    Observable<CartListEntity> getserCoupon(@Body CartRequest requestBean);


    /**
     * 提交订单数据
     * @param requestBean
     * @return
     */
    @POST("/order/create")
    Observable<CreateOrderEntity> createOrder(@Body CommitOrderRequest requestBean);


    /**
     * 获取支付列表
     * @param requestBean
     * @return
     */
    @POST("/transaction/pay/getPaymentList")
    Observable<PlayListEntity> getPaymentList(@Body BaseRequestBean requestBean);


    /**
     * 获取对接1688支付所需要的参数
     * @param requestBean
     * @return
     */
    @POST("/transaction/pay/doPay")
    Observable<PlayRequestEntity> doPlay1688(@Body IPlay1688Request requestBean);





}
