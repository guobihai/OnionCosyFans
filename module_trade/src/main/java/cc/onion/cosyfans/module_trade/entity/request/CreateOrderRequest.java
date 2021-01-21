package cc.onion.cosyfans.module_trade.entity.request;

import cc.onion.cosyfans.base.entity.BaseRequestBean;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.module_trade.entity.request
 * @ClassName: CreateOrderRequest
 * @Description: 创建购物车订单请求类
 * @Author: guobihai
 * @CreateDate: 2019-12-11 17:50
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-11 17:50
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class CreateOrderRequest extends BaseRequestBean {

    /**
     * 地址串
     */
    private  String addressId;

    /**
     * 购物车串
     */
    private String cartIds;

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getCartIds() {
        return cartIds;
    }

    public void setCartIds(String cartIds) {
        this.cartIds = cartIds;
    }
}
