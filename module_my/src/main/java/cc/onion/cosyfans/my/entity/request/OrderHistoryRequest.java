package cc.onion.cosyfans.my.entity.request;

import cc.onion.cosyfans.base.entity.BaseRequestBean;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.entity.request
 * @ClassName: OrderHistoryRequest
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2020/1/14 14:36
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/14 14:36
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class OrderHistoryRequest extends BaseRequestBean {
    public static final int ORDER_UNPAID = 1;//待付款
    public static final int ORDER_DELIVERING= 2;//代收货
    public static final int ORDER_COMPLETE = 3;//已完成
    public static final int ORDER_RETURNING= 6;//退货退款
    public static final int ORDER_RETURN= 7;//退货退款已完成

    private String orderNo;
    private String orderStatus;//待付款 1  代收货 2  已完成 3  退货/退款 6  退货退款已完成 7
    private int pageNum =1;//页码
    private int pageSize =10;//每页大小

    public OrderHistoryRequest(int pageNum, int pageSize,String status) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.orderNo = "";
        this.orderStatus = status;
        this.putKeySign("orderNo",this.orderNo);
        this.putKeySign("pageNum",this.pageNum);
        this.putKeySign("pageSize",this.pageSize);
        this.putKeySign("orderStatus",this.orderStatus);
        this.sign();
    }

    public OrderHistoryRequest(int pageNum, int pageSize,String orderNo,String status) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.orderNo = orderNo;
        this.orderStatus = status;
        this.putKeySign("orderNo",this.orderNo);
        this.putKeySign("pageNum",this.pageNum);
        this.putKeySign("pageSize",this.pageSize);
        this.putKeySign("orderStatus",this.orderStatus);
        this.sign();
    }

    /**
     * 获取全部的订单
     * @return
     */
    public static OrderHistoryRequest getAllOrderRequest(int pageNum,int pageSize){
        return new OrderHistoryRequest(pageNum,pageSize,"");
    }
    /**
     * 获取待付款订单
     * @return
     */
    public static OrderHistoryRequest getUnPaidOrderRequest(int pageNum,int pageSize){
        return new OrderHistoryRequest(pageNum,pageSize,"1");
    }

    /**
     * 获取待收货订单
     * @return
     */
    public static OrderHistoryRequest getDeliveringOrderRequest(int pageNum,int pageSize){
        return new OrderHistoryRequest(pageNum,pageSize,"2");
    }

    /**
     * 获取已完成订单
     * @return
     */
    public static OrderHistoryRequest getCompletedOrderRequest(int pageNum,int pageSize){
        return new OrderHistoryRequest(pageNum,pageSize,"3");
    }

    /**
     * 获取退货、退款订单
     * @return
     */
    public static OrderHistoryRequest getReturnOrderRequest(int pageNum,int pageSize){
        return new OrderHistoryRequest(pageNum,pageSize,"7");
    }
    /**
     * 搜索订单信息
     * @return
     */
    public static OrderHistoryRequest getSearchOrderRequest(String orderNo,String orderStatus,int pageNum,int pageSize){
        return new OrderHistoryRequest(pageNum,pageSize,orderNo,orderStatus);
    }


    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
