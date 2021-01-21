package cc.onion.cosyfans.cart.api;

import cc.onion.cosyfans.base.entity.BaseRequestBean;
import cc.onion.cosyfans.base.entity.BaseResponse;

import cc.onion.cosyfans.cart.entity.AddCartRequest;
import cc.onion.cosyfans.cart.entity.CartDeleteRequest;
import cc.onion.cosyfans.cart.entity.CartPomEntity;
import cc.onion.cosyfans.cart.entity.CartPomListRequest;
import cc.onion.cosyfans.cart.entity.CartRequest;
import cc.onion.cosyfans.cart.entity.response.ItemEntity;
import cc.onion.cosyfans.cart.entity.PromotionRequest;
import cc.onion.cosyfans.cart.entity.response.CartListEntity;
import cc.onion.cosyfans.cart.entity.response.PomptionListEntity;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 *
 * @author guobihai
 * @date :2019-11-18
 */
public interface CartApi {

    /**
     * 查询购物车
     */
    @POST("/cart/query")
    Observable<CartListEntity> getCartList(@Body CartRequest requestBean);


    /**
     * 加入购物车
     * @param requestBean
     * @return
     */
    @POST("/cart/add")
    Observable<BaseResponse> addCart(@Body AddCartRequest requestBean);


    /**
     * 删除购物车
     * @param requestBean
     * @return
     */
    @POST("/cart/delete")
    Observable<BaseResponse> deleteCart(@Body CartDeleteRequest requestBean);


    /**
     * 更新购物车
     * @param addCartRequest
     * @return
     */
    @POST("/cart/update")
    Observable<BaseResponse> updateCart(@Body AddCartRequest addCartRequest);


    /**
     * 跳转到创建订单
     * @param requestBean
     * @return
     */
    @POST("/cart/gotoCreateOrder")
    Observable<BaseResponse> gotoCreateOrder(@Body BaseRequestBean requestBean);


    /**
     * 显示购物车商品数量
     * @param requestBean
     * @return
     */
    @POST("/cart/showItemAmount")
    Observable<BaseResponse> showItemAmount(@Body BaseRequestBean requestBean);


    /**
     * 购物车优惠券-购物车领取优惠券
     * @param requestBean
     * @return
     */
    @POST("/cart/coupon/getCouponForCart")
    Observable<BaseResponse> getCouponForCart(@Body BaseRequestBean requestBean);


    /**
     * 跳转到创建订单-获取用户优惠券
     * @param requestBean
     * @return
     */
    @POST("/cart/userCoupon")
    Observable<BaseResponse> userCoupon(@Body BaseRequestBean requestBean);


    /**
     * 跳转到创建订单-获取用户现金券
     */
    @POST("/cart/cashCoupon")
    Observable<BaseResponse> cashCoupon(@Body BaseRequestBean requestBean);


    /**
     * 获取推荐产品
     * @param requestBean
     * @return
     */
    @POST("/search/recommendItem")
    Observable<ItemEntity> getRecommendItem(@Body BaseRequestBean requestBean);



    /**
     * 获取折扣请求产品列表
     * @param requestBean
     * @return
     */
    @POST("/item/promotion/list")
    Observable<PomptionListEntity> getPromotionList(@Body CartPomListRequest requestBean);


    /**
     * 获取购物车折扣请求类
     * @param requestBean
     * @return
     */
    @POST("/item/promotion/info")
    Observable<BaseResponse<CartPomEntity>> getPromotionInfo(@Body PromotionRequest requestBean);



}
