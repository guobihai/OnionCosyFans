package cc.onion.cosyfans.home.api;

import cc.onion.cosyfans.base.entity.BaseListResponse;
import cc.onion.cosyfans.base.entity.BaseRequestBean;
import cc.onion.cosyfans.base.entity.BaseResponse;
import cc.onion.cosyfans.home.entity.CashRequest;
import cc.onion.cosyfans.home.entity.CashRollEntity;
import cc.onion.cosyfans.home.entity.ItemDetailEntity;
import cc.onion.cosyfans.home.entity.response.AdvertEntity;
import cc.onion.cosyfans.home.entity.ContextModelRequest;
import cc.onion.cosyfans.home.entity.HomeGetAllModelRequest;
import cc.onion.cosyfans.home.entity.response.AlbumRequest;
import cc.onion.cosyfans.home.entity.response.AlumGroupEntity;
import cc.onion.cosyfans.home.entity.response.GroupItemEntity;
import cc.onion.cosyfans.home.entity.response.GroupListRequest;
import cc.onion.cosyfans.home.entity.response.GroupRequest;
import cc.onion.cosyfans.home.entity.response.HomeAllModel;
import cc.onion.cosyfans.home.entity.response.LastVersionEntity;
import cc.onion.cosyfans.home.entity.response.TableDetailEntity;
import cc.onion.cosyfans.home.entity.response.TableEntity;
import cc.onion.cosyfans.home.entity.response.VersionEntity;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 首页API
 * @author guobihai
 * @email:guobihai@163.com
 */
public interface HomeApiServer {

//
//    /**
//     * 请求经纪人列表
//     * 当前登录可见最大范围: /erp.settings.api/agent/datarangelist
//     * 全公司范围，用于选择速资方: /erp.settings.api/agent/list
//     */
//    @GET
//    Observable<BaseResponse<HouseMarkSelectAgentData>> requestAgentList(@Url String url,
//                                                                        @Query("pageNo") int pageNo,
//                                                                        @Query("pageSize") int pageSize,
//                                                                        @Query("nameOrPhone") String key
//    );

    /**
     * 获取是否有版本号
     */
    @POST("/content/getVersion")
    Observable<BaseResponse<VersionEntity>> getHomeVersion(@Body BaseRequestBean requestBean);


    /**
     * 获取所有模块
     * @param requestBean
     * @return
     */
    @POST("/content/module/getAllModule")
    Observable<BaseResponse<HomeAllModel>> getHomeAllModule(@Body HomeGetAllModelRequest requestBean);



    /**
     * 获取模块内容
     * @param requestBean
     * @return
     */
    @POST("/content/module/getModuleDetail")
    Observable<AdvertEntity> getHomeModuleDetail(@Body ContextModelRequest requestBean);


    /**
     * 获取信息流Tab
     * @param requestBean
     * @return
     */
    @POST("/content/module/flowTab/get")
    Observable<TableEntity> getHomeFlowTab(@Body ContextModelRequest requestBean);

    /**
     * 获取标签页信息内容
     * @param requestBean
     * @return
     */
    @POST("/content/module/flowTab/detail/get")
    Observable<TableDetailEntity> getHomeFlowTabDetail(@Body ItemDetailEntity requestBean);

    /**
     * 获取最新版本
     * @param requestBean
     * @return
     */
    @POST("/content/version/getLatestVersion")
    Observable<BaseResponse<LastVersionEntity>> getHomeLatestVersion(@Body BaseRequestBean requestBean);


    /***
     * 获取分组商品分组数据
     * @param requestBean
     * @return
     */
    @POST("/operation/album/item/get")
    Observable<GroupItemEntity> getGroupItem(@Body GroupListRequest requestBean);


    /**
     * 获取热销产品数据
     * @param requestBean
     * @return
     */
    @POST("/operation/album/item/hot")
    Observable<GroupItemEntity> getGroupHotItem(@Body GroupRequest requestBean);


    /**
     * 获取商品专辑界面数据
     * @param requestBean
     * @return
     */
    @POST("/operation/album")
    Observable<AlumGroupEntity> getAlbumData(@Body AlbumRequest requestBean);


    /**
     * 获取现金优惠券
     * @param requestBean
     * @return
     */
    @POST("/marketingx/coupon/popup")
    Observable<CashRollEntity> getCouponList(@Body CashRequest requestBean);
}
