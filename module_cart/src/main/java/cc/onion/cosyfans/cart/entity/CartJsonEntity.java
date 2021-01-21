package cc.onion.cosyfans.cart.entity;

/**
 * @author guobihai
 * @version V1.0
 * @Title: AppCommonInfo
 * @Package cc.onion.cosyfans.base.common
 * @date 2019-12-03 14:53
 * @email: anhui-zhuang@msyc.cc
 * @Description: (添加购物车的json串)
 */
public class CartJsonEntity {



    /**
     *   必须
     *   sku的idx
     */
    int skuId;

    /**
     *   必须
     *  数量
     */
    int amount;


    /**
     *  购物车ID
     *  必须
     */
    int cartId;


    /**
     *  非必须
     *     活动类型(0:无, 1:满件折, 2:优惠券)
     */
    int activityType;


    /**
     * 非必须
     * 关联的活动Id
     */
    int activityId;

    public int getSkuId() {
        return skuId;
    }

    public void setSkuId(int skuId) {
        this.skuId = skuId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getActivityType() {
        return activityType;
    }

    public void setActivityType(int activityType) {
        this.activityType = activityType;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }
}
