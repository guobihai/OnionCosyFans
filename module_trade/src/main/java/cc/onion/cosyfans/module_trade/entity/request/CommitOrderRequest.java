package cc.onion.cosyfans.module_trade.entity.request;

import cc.onion.cosyfans.base.entity.BaseRequestBean;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.module_trade.entity.request
 * @ClassName: CommitOrderRequest
 * @Description: 创建订单
 * @Author: guobihai
 * @CreateDate: 2019-12-13 14:02
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-13 14:02
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class CommitOrderRequest extends BaseRequestBean {

    String address;

    String addressIdxCode;

    String cashUserCouponId;

    /**
     * 订单数据
     */
    String orderItems;

    String tel;


    String userName;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressIdxCode() {
        return addressIdxCode;
    }

    public void setAddressIdxCode(String addressIdxCode) {
        this.addressIdxCode = addressIdxCode;
    }

    public String getCashUserCouponId() {
        return cashUserCouponId;
    }

    public void setCashUserCouponId(String cashUserCouponId) {
        this.cashUserCouponId = cashUserCouponId;
    }

    public String getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(String orderItems) {
        this.orderItems = orderItems;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
