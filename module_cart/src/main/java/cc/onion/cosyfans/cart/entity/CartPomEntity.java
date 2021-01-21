package cc.onion.cosyfans.cart.entity;

import java.io.Serializable;
import java.util.List;

import cc.onion.cosyfans.item.entity.response.ItemDetailEntity;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.cart.entity
 * @ClassName: CartPomEntity
 * @Description: 折扣列表商品类
 * @Author: guobihai
 * @CreateDate: 2019-12-23 17:16
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-23 17:16
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class CartPomEntity implements Serializable {
    private static final long serialVersionUID = -5333687480343131672L;



        private boolean isLogin;
            private int  totalPages;
            private String levelName;
            private String startTime;
            private String endTime;
            private String discountPrice;
            private String totalPrice;

    public String getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(String discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public List<ItemBean> getItems() {
        return items;
    }

    public void setItems(List<ItemBean> items) {
        this.items = items;
    }

    private List<ItemBean> items;


        public  class ItemBean{


            /**
             * itemId : 153286
             * itemName : Square velvet hot stamping pillowcase
             * sellingPrice : 3.77
             * marketPrice : 3.77
             * imageSmall : https://glodimg.chinabrands.cn/pdm-provider-img/straight-product-img/20181016/T032527/T0325270011/source-img/222240-8393.jpg
             * imageMedium : https://glodimg.chinabrands.cn/pdm-provider-img/straight-product-img/20181016/T032527/T0325270011/source-img/222240-8393.jpg
             * imageBig : https://glodimg.chinabrands.cn/pdm-provider-img/straight-product-img/20181016/T032527/T0325270011/source-img/222240-8393.jpg
             * hasStock : 1
             * promotionLabel :  满5件7.55折
             * couponLabel : 满10000减150
             * skuInfoShowDTO : {"skuOptionNameList":[{"specName":"Color","specId":2080125,"specOptionList":[{"specOptId":4028828,"specOptName":"WHITE"}]},{"specName":"Size","specId":2080208,"specOptionList":[{"specOptId":4028936,"specOptName":"45CM*45CM"}]}],"skuPriceMap":{"4028828^4028936":{"skuId":192597,"marketPrice":"3.77","sellingPrice":"3.77","imageSmall":"","imageMedium":"","imageBig":"","salesProfit":"0","limitCount":0,"minimumLimitCount":0,"stock":249,"itemStatus":1,"isKeyOrder":0,"giftType":0,"profitDetail":{"totalProfit":"0","levelOneSalesProfit":null,"levelOneDevelopmentProfit":null,"levelTwoSalesProfit":null,"levelThreeSalesProfit":null},"discountPrice":"2.85"}}}
             * discountedPrice : 2.85
             */

            private int itemId;
            private String itemName;
            private String sellingPrice;
            private String marketPrice;
            private String imageSmall;
            private String imageMedium;
            private String imageBig;
            private int hasStock;
            private String promotionLabel;
            private String couponLabel;
            private ItemDetailEntity.DataBean.SkuInfoShowDTOBean skuInfoShowDTO;
            private String discountedPrice;

            public int getItemId() {
                return itemId;
            }

            public void setItemId(int itemId) {
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

            public int getHasStock() {
                return hasStock;
            }

            public void setHasStock(int hasStock) {
                this.hasStock = hasStock;
            }

            public String getPromotionLabel() {
                return promotionLabel;
            }

            public void setPromotionLabel(String promotionLabel) {
                this.promotionLabel = promotionLabel;
            }

            public String getCouponLabel() {
                return couponLabel;
            }

            public void setCouponLabel(String couponLabel) {
                this.couponLabel = couponLabel;
            }

            public ItemDetailEntity.DataBean.SkuInfoShowDTOBean getSkuInfoShowDTO() {
                return skuInfoShowDTO;
            }

            public void setSkuInfoShowDTO(ItemDetailEntity.DataBean.SkuInfoShowDTOBean skuInfoShowDTO) {
                this.skuInfoShowDTO = skuInfoShowDTO;
            }

            public String getDiscountedPrice() {
                return discountedPrice;
            }

            public void setDiscountedPrice(String discountedPrice) {
                this.discountedPrice = discountedPrice;
            }
        }
}
