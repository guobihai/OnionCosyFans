package cc.onion.cosyfans.home.entity.response;

/**
 * @author guobihai
 * @date  2019 - 11-15
 */
public class DetailItemEntity {


    /**
     * id : 100013960
     * itemId : 29197
     * itemDetailUrl :
     * sort : 0
     * mainItem : 0
     * itemName : ISANA伊萨娜 芦荟洋甘菊舒敏脱毛滚�� 120ml
     * sellingPrice : 58.06
     * marketPrice : 81.93
     * hasStock : 1
     * imageSmall : https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104192503718_765.jpg
     * imageMedium : https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104192503718_765.jpg
     * imageBig : https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104192503718_765.jpg
     * promotionLabel : 满5件7.55折
     * discountedPrice : 43.84
     * couponLabel :
     */

    private int id;
    private int itemId;
    private String itemDetailUrl;
    private int sort;
    private int mainItem;
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
    private String iosUrl;
    private String androidUrl;
    private String url;
    private int urlType;

    public int getUrlType() {
        return urlType;
    }

    public void setUrlType(int urlType) {
        this.urlType = urlType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIosUrl() {
        return iosUrl;
    }

    public void setIosUrl(String iosUrl) {
        this.iosUrl = iosUrl;
    }

    public String getAndroidUrl() {
        return androidUrl;
    }

    public void setAndroidUrl(String androidUrl) {
        this.androidUrl = androidUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemDetailUrl() {
        return itemDetailUrl;
    }

    public void setItemDetailUrl(String itemDetailUrl) {
        this.itemDetailUrl = itemDetailUrl;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getMainItem() {
        return mainItem;
    }

    public void setMainItem(int mainItem) {
        this.mainItem = mainItem;
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
