package cc.onion.cosyfans.module_order.entity;

import cc.onion.cosyfans.base.entity.BaseRequestBean;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.module_order.entity
 * @ClassName: OderReturnListRequest
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2019-12-31 16:06
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-31 16:06
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class OderReturnListRequest extends BaseRequestBean {

//    orderNo: ""
//    refundNo: ""
//    pageNum: 1
//    pageSize: 10

    private String orderNo;
    private String refundNo;

    private int pageNum;
    private int pageSize;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getRefundNo() {
        return refundNo;
    }

    public void setRefundNo(String refundNo) {
        this.refundNo = refundNo;
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
