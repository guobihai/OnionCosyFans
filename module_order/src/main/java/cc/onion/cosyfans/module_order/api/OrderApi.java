package cc.onion.cosyfans.module_order.api;

import cc.onion.cosyfans.base.entity.BaseResponse;
import cc.onion.cosyfans.module_order.entity.ConfimOrderEntity;
import cc.onion.cosyfans.module_order.entity.OderReturnListRequest;
import cc.onion.cosyfans.module_order.entity.OrderAfterEntity;
import cc.onion.cosyfans.module_order.entity.OrderDetailEntity;
import cc.onion.cosyfans.module_order.entity.OrderListEntity;
import cc.onion.cosyfans.module_order.entity.OrderListRequest;
import cc.onion.cosyfans.module_order.entity.OrderRequest;
import cc.onion.cosyfans.module_order.entity.request.AfterRequest;
import cc.onion.cosyfans.module_order.entity.request.ConfimRequest;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.api
 * @ClassName: MyApi
 * @Description: 订单模块API业务
 * @Author: guobihai
 * @CreateDate: 2019-12-11 15:09
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-11 15:09
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface OrderApi {


    /**
     * 查询购物车
     */
    @POST("/order/detail")
    Observable<OrderDetailEntity> getOrderDetail(@Body OrderRequest requestBean);


    @POST("/user/order/paging")
    Observable<OrderListEntity> getOrderList(@Body OrderListRequest requestBean);


    /**
     * 售后订单列表
     * @param requestBean
     * @return
     */
    @POST("/order/refund/list")
    Observable<OrderListEntity> getRefundList(@Body OderReturnListRequest requestBean);


    /**
     * 售后订单
     * @param requestBean
     * @return
     */
    @POST("/order/refund/getApplyPage")
    Observable<OrderAfterEntity> getApplyPage(@Body AfterRequest requestBean);


    /**
     * 确认订单
     * @param requestBean
     * @return
     */
    @POST("/order/confirm")
    Observable<ConfimOrderEntity> confirmOrder(@Body ConfimRequest requestBean);


    /**
     * 取消订单
     * @param requestBean
     * @return
     */
    @POST("/order/cancel")
    Observable<BaseResponse> cancelOrder(@Body ConfimRequest requestBean);




}
