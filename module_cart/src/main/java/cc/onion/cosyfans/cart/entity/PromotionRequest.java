package cc.onion.cosyfans.cart.entity;

import cc.onion.cosyfans.base.entity.BaseRequestBean;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.cart.entity
 * @ClassName: PromotionRequest
 * @Description: 购物车折扣请求累
 * @Author: guobihai
 * @CreateDate: 2019-12-23 17:32
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-23 17:32
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class PromotionRequest extends BaseRequestBean {

    String promotionId;

    public String getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(String promotionId) {
        this.promotionId = promotionId;
    }
}
