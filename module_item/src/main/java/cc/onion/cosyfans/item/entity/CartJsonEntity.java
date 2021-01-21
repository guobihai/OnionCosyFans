package cc.onion.cosyfans.item.entity;

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
    String skuId;

    /**
     *   必须
     *  数量
     */
    String amount;


    /**
     *  spu的的idxCode
     *  必须
     */
    String itemId;


    /**
     *  非必须
     *     活动类型(0:无, 1:满件折, 2:优惠券)
     */
    String activityType;


    /**
     * 非必须
     * 关联的活动Id
     */
    String activityId;


    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }
}
