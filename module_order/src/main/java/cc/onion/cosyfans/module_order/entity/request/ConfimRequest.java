package cc.onion.cosyfans.module_order.entity.request;

import cc.onion.cosyfans.base.entity.BaseRequestBean;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.module_order.entity.request
 * @ClassName: ConfimRequest
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2019-12-27 17:57
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-27 17:57
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ConfimRequest extends BaseRequestBean {
    String orderNo;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
