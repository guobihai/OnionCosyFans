package cc.onion.cosyfans.my.api;

import java.util.Map;

import cc.onion.cosyfans.base.entity.BaseRequestBean;
import cc.onion.cosyfans.base.entity.BaseResponse;
import cc.onion.cosyfans.my.entity.AddressListEntity;
import cc.onion.cosyfans.my.entity.OrderInComeEntry;
import cc.onion.cosyfans.my.entity.OrderListEntity;
import cc.onion.cosyfans.my.entity.RegisterCosyTypeEntry;
import cc.onion.cosyfans.my.entity.RegisterUserDetailEntry;
import cc.onion.cosyfans.my.entity.TrackingDetailEntry;
import cc.onion.cosyfans.my.entity.TrackingInfoEntry;
import cc.onion.cosyfans.my.entity.UserStatisticsDetails;
import cc.onion.cosyfans.my.entity.request.EdMerchantInfo;
import cc.onion.cosyfans.my.entity.MerchantInfo;
import cc.onion.cosyfans.my.entity.MineEntity;
import cc.onion.cosyfans.my.entity.ResMerchantInfo;
import cc.onion.cosyfans.my.entity.request.AddressRequest;
import cc.onion.cosyfans.my.entity.request.OrderHistoryRequest;
import cc.onion.cosyfans.my.entity.request.OrderInComeRequest;
import cc.onion.cosyfans.my.entity.request.RegisterUerDetailRequest;
import cc.onion.cosyfans.my.entity.request.RegisterUserRequest;
import cc.onion.cosyfans.my.entity.request.StatisticUerDetailRequest;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.api
 * @ClassName: MyApi
 * @Description: APi
 * @Author: guobihai
 * @CreateDate: 2019-12-11 15:09
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-11 15:09
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface MyApi {


    /**
     * 查询购物车
     */
    @POST("/user/detail/shippingAddress/list")
    Observable<AddressListEntity> getAddressList(@Body AddressRequest requestBean);


    /**
     * 个人中心首页
     * @param requestBean
     * @return
     */
    @POST("/user/detail/getUserCenter")
    Observable<MineEntity> getUserCenter(@Body BaseRequestBean requestBean);


    /**
     * 退出
     * @param requestBean
     * @return
     */
    @POST("/user/detail/logOut")
    Observable<BaseResponse> logOut(@Body BaseRequestBean requestBean);

    /**
     * 获取商家店铺信息
     * @param requestBean
     * @return
     */
    @POST("/store/detail")
    Observable<MerchantInfo>getMerchantCenterInfo(@Body BaseRequestBean requestBean);

    /**
     * 查询门店信息
     * @param baseRequestBean
     * @return
     */
    @POST("/store/queryShopById")
    Observable<ResMerchantInfo>queryShopInfo(@Body BaseRequestBean baseRequestBean);

    /**
     * 编辑门店信息
     * @param edMerchantInfo
     * @return
     */
    @POST("/store/updateShop")
    Observable<Map<String,Object>>updateShopInfo(@Body EdMerchantInfo edMerchantInfo);


    //商家中心-我的订单
    @POST("/store/order/paging")
    Observable<OrderListEntity> queryHistoryListOrdersInfo(@Body OrderHistoryRequest historyRequest);


    //商家待收货 订单收益
    @POST("/store/order/income")
    Observable<OrderInComeEntry>queryOrderInComeInfo(@Body OrderInComeRequest orderInComeRequest);

    //查询物流 商品列表
    @POST("/store/order/Logistics")
    Observable<TrackingInfoEntry> queryTrakingInfo(@Body OrderInComeRequest orderInComeRequest);

    //查询物流 刻度
    @POST("/store/logistics/tracking")
    Observable<TrackingDetailEntry> queryTrakingDetailInfo(@Body OrderInComeRequest orderInComeRequest);


    //查询用户注册统计信息
    @POST("/store/queryUserStatistics")
    Observable<RegisterCosyTypeEntry> queryRegisterUserInfo(@Body RegisterUserRequest registerUserRequest);

    //查询用户注册统计 -用户详细列表
    @POST("/store/getUserDetails")
    Observable<RegisterUserDetailEntry> queryRegisterUserDetailInfo(@Body RegisterUerDetailRequest registerUerDetailRequest);

    //注册用户统计-用户订单详情
    @POST("/store/queryUserStatisticsDetails")
    Observable<UserStatisticsDetails> queryUserStatisticsDetails(@Body StatisticUerDetailRequest registerUerDetailRequest);
}
