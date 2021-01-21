package cc.onion.cosyfans.module_order.entity;

import cc.onion.cosyfans.base.entity.BaseRequestBean;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.module_order.entity
 * @ClassName: OrderListRequest
 * @Description: 订单列表请求类
 * @Author: guobihai
 * @CreateDate: 2019-12-16 15:55
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-16 15:55
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class OrderListRequest extends BaseRequestBean {

    /**
     *  非必须
     * 订单号
     */
    private String orderNo;

    /**
     *   非必须
     *  订单状态
     */
    private String orderStatus;

    private int pageNum;

    private int  pageSize;

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
