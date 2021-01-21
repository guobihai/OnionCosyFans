package cc.onion.cosyfans.item.entity;

import java.io.Serializable;

/**
 * @author guobihai
 * @date 2019 - 10 -16
 */
public class SkuBaseEntity implements Serializable {


    private static final long serialVersionUID = 3581437941053917806L;

    /**
     * skuId : 138370
     * marketPrice : 77.61
     * sellingPrice : 36.32
     * imageSmall :
     * imageMedium :
     * imageBig :
     * salesProfit : 0.00
     * limitCount : 8
     * minimumLimitCount : 1
     * stock : 41234
     * itemStatus : 1
     * isKeyOrder : 0
     * giftType : 0
     * discountPrice :
     */

    /**
     * sku key Name
     */
    private String SkuKeyName;
    private int skuId;
    private String marketPrice;
    private String sellingPrice;
    private String imageSmall;
    private String imageMedium;
    private String imageBig;
    private String salesProfit;
    private int limitCount;
    private int minimumLimitCount;
    private int stock;
    private int itemStatus;
    private int isKeyOrder;
    private int giftType;
    private String discountPrice;

    public String getSkuKeyName() {
        return SkuKeyName;
    }

    public void setSkuKeyName(String skuKeyName) {
        SkuKeyName = skuKeyName;
    }

    public int getSkuId() {
        return skuId;
    }

    public void setSkuId(int skuId) {
        this.skuId = skuId;
    }

    public String getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(String marketPrice) {
        this.marketPrice = marketPrice;
    }

    public String getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(String sellingPrice) {
        this.sellingPrice = sellingPrice;
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

    public String getSalesProfit() {
        return salesProfit;
    }

    public void setSalesProfit(String salesProfit) {
        this.salesProfit = salesProfit;
    }

    public int getLimitCount() {
        return limitCount;
    }

    public void setLimitCount(int limitCount) {
        this.limitCount = limitCount;
    }

    public int getMinimumLimitCount() {
        return minimumLimitCount;
    }

    public void setMinimumLimitCount(int minimumLimitCount) {
        this.minimumLimitCount = minimumLimitCount;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(int itemStatus) {
        this.itemStatus = itemStatus;
    }

    public int getIsKeyOrder() {
        return isKeyOrder;
    }

    public void setIsKeyOrder(int isKeyOrder) {
        this.isKeyOrder = isKeyOrder;
    }

    public int getGiftType() {
        return giftType;
    }

    public void setGiftType(int giftType) {
        this.giftType = giftType;
    }

    public String getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(String discountPrice) {
        this.discountPrice = discountPrice;
    }
}
