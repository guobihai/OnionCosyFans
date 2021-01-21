package cc.onion.cosyfans.module_trade.entity.request;

import java.io.Serializable;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.module_trade.entity.request
 * @ClassName: ItemCommitEntity
 * @Description: 提交参数实体类
 * @Author: guobihai
 * @CreateDate: 2019-12-13 14:31
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-13 14:31
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ItemCommitEntity implements Serializable {
    private static final long serialVersionUID = -7225391489382697067L;
    /**
     * skuId : 2316753
     * amount : 6
     * realFee : 131.8
     * promotionId : 0
     * userCouponId : 0
     */

    private int skuId;
    private int amount;
    private String realFee;
    private int promotionId;
    private int userCouponId;


    public ItemCommitEntity(int skuId, int amount, String realFee, int promotionId, int userCouponId) {
        this.skuId = skuId;
        this.amount = amount;
        this.realFee = realFee;
        this.promotionId = promotionId;
        this.userCouponId = userCouponId;
    }

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

    public String getRealFee() {
        return realFee;
    }

    public void setRealFee(String realFee) {
        this.realFee = realFee;
    }

    public int getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(int promotionId) {
        this.promotionId = promotionId;
    }

    public int getUserCouponId() {
        return userCouponId;
    }

    public void setUserCouponId(int userCouponId) {
        this.userCouponId = userCouponId;
    }

//    [{'skuId': 2316753,'amount': 6,'realFee': 131.80,'promotionId': 0,'userCouponId': 0}

}
