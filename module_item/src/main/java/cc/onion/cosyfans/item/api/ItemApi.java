package cc.onion.cosyfans.item.api;

import cc.onion.cosyfans.base.entity.BaseRequestBean;
import cc.onion.cosyfans.base.entity.BaseResponse;
import cc.onion.cosyfans.item.entity.AddCartRequest;
import cc.onion.cosyfans.item.entity.CouponRequest;
import cc.onion.cosyfans.item.entity.ItemDetailRequest;
import cc.onion.cosyfans.item.entity.response.CouponListEntity;
import cc.onion.cosyfans.item.entity.response.ItemDetailEntity;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 *
 * @author guobihai
 * @date :2019-11-18
 */
public interface ItemApi {

    /**
     * 获取是否有版本号
     */
    @POST("/item/detail")
    Observable<ItemDetailEntity> getItemDetail(@Body ItemDetailRequest requestBean);




    @POST("/marketingx/coupon/getCouponListForItem")
    Observable<BaseResponse<CouponListEntity>> getCouponListForItem(@Body CouponRequest requestBean);



    /**
     * 加入购物车
     * @param requestBean
     * @return
     */
    @POST("/cart/add")
    Observable<BaseResponse> addCart(@Body AddCartRequest requestBean);


    /**
     * 获取购物车数量
     * @param requestBean
     * @return
     */
    @POST("/cart/showItemAmount")
    Observable<BaseResponse> getCatAmount(@Body BaseRequestBean requestBean);

}
