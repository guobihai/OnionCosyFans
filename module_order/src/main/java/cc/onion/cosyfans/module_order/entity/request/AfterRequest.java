package cc.onion.cosyfans.module_order.entity.request;

import cc.onion.cosyfans.base.entity.BaseRequestBean;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.module_order.entity.request
 * @ClassName: AfterRequest
 * @Description: 售后订单数据
 * @Author: guobihai
 * @CreateDate: 2019-12-27 15:13
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-27 15:13
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class AfterRequest extends BaseRequestBean {

    String orderNo;

    /**
     * 订单商品项ID集合，多个以,隔开
     */
    String orderItemIds;

    /**
     * 时间差（0:整单售后，1：单个售后）
     */
    String timeDifference;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderItemIds() {
        return orderItemIds;
    }

    public void setOrderItemIds(String orderItemIds) {
        this.orderItemIds = orderItemIds;
    }

    public String getTimeDifference() {
        return timeDifference;
    }

    public void setTimeDifference(String timeDifference) {
        this.timeDifference = timeDifference;
    }
}
