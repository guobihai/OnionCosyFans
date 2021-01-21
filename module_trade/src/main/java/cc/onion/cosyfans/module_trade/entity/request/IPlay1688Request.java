package cc.onion.cosyfans.module_trade.entity.request;

import cc.onion.cosyfans.base.entity.BaseRequestBean;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.module_trade.entity.request
 * @ClassName: IPlay1688Request
 * @Description: 1688对接支付请求对象
 * @Author: guobihai
 * @CreateDate: 2019-12-26 11:47
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-26 11:47
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class IPlay1688Request extends BaseRequestBean {

//    必须 支付方式id
   private String  paymentId;


    /**
     *   订单号
     *   必须
     */
    private String orderNo;


    /**
     * 店铺ID
     * 非必须
     */
    private String shopId;

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    @Override
    public String getShopId() {
        return shopId;
    }

    @Override
    public void setShopId(String shopId) {
        this.shopId = shopId;
    }
}
