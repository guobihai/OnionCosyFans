package cc.onion.cosyfans.home.entity.response;

import java.io.Serializable;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.home.entity.response
 * @ClassName: DetailItemVosEntity
 * @Description: 商品详情数据
 * @Author: guobihai
 * @CreateDate: 2020-01-14 19:55
 * @UpdateUser: guobihai
 * @UpdateDate: 2020-01-14 19:55
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class DetailItemVosEntity implements Serializable {
    private static final long serialVersionUID = 8969193881525903610L;
    /**
     * 商品id
     */
    private  String  itemId;


    private String itemName;
    private String sellingPrice;
    private String marketPrice;
    private int hasStock;
    private String imageSmall;
    private String imageMedium;
    private String imageBig;

    private String promotionLabel;
    private String discountedPrice;
    private String couponLabel;


    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(String sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(String marketPrice) {
        this.marketPrice = marketPrice;
    }

    public int getHasStock() {
        return hasStock;
    }

    public void setHasStock(int hasStock) {
        this.hasStock = hasStock;
    }

    public String getImageSmall() {
        return imageSmall;
    }

    public void setImageSmall(String imageSmall) {
        this.imageSmall = imageSmall;
    }

    public String getImageMedium() {
        return imageMedium;
    }

    public void setImageMedium(String imageMedium) {
        this.imageMedium = imageMedium;
    }

    public String getImageBig() {
        return imageBig;
    }

    public void setImageBig(String imageBig) {
        this.imageBig = imageBig;
    }

    public String getPromotionLabel() {
        return promotionLabel;
    }

    public void setPromotionLabel(String promotionLabel) {
        this.promotionLabel = promotionLabel;
    }

    public String getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(String discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public String getCouponLabel() {
        return couponLabel;
    }

    public void setCouponLabel(String couponLabel) {
        this.couponLabel = couponLabel;
    }
}
