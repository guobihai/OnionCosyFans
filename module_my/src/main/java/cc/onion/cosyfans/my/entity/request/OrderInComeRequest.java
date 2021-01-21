package cc.onion.cosyfans.my.entity.request;

import cc.onion.cosyfans.base.entity.BaseRequestBean;

/**
 * 我的收益请求体
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.entity.request
 * @ClassName: OrderInComeRequest
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2020/1/15 15:09
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/15 15:09
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class OrderInComeRequest extends BaseRequestBean {
    String orderNo;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
