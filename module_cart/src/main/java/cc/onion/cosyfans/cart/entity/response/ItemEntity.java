package cc.onion.cosyfans.cart.entity.response;

import java.io.Serializable;
import java.util.List;

/**
 * item基础类型
 * @author guobihai
 * @date 2019 -12- 02
 */
public class ItemEntity implements Serializable {

    private static final long serialVersionUID = -4125448546533946500L;

    /**
     * status : 200
     * msg : OK
     * data : [{"itemId":1892207,"itemName":"fanwai-壹食解千愁 片片童年味蜂蜜山楂条 130g/包","sellingPrice":"9.03","marketPrice":"11.62","imageSmall":"https://onion-images-dev.yangsupplychain.com/collect-item-images/20190910/20190910103541101_806.png","imageMedium":"https://onion-images-dev.yangsupplychain.com/collect-item-images/20190910/20190910103541101_806.png","imageBig":"https://onion-images-dev.yangsupplychain.com/collect-item-images/20190910/20190910103541101_806.png","hasStock":1,"promotionLabel":null,"couponLabel":null,"discountedPrice":null},{"itemId":126499,"itemName":"贩外商品-FW20190301","sellingPrice":"36.32","marketPrice":"77.61","imageSmall":"https://yangtaodev-1253852034.cosgz.myqcloud.com/collect-item-images/20190301/20190301112655963_599.jpg","imageMedium":"https://yangtaodev-1253852034.cosgz.myqcloud.com/collect-item-images/20190301/20190301112655963_599.jpg","imageBig":"https://yangtaodev-1253852034.cosgz.myqcloud.com/collect-item-images/20190301/20190301112655963_599.jpg","hasStock":1,"promotionLabel":null,"couponLabel":"","discountedPrice":null},{"itemId":226162,"itemName":"SU:M37°呼吸 sweet smile润肤乳 250ml","sellingPrice":"131.80","marketPrice":"183.21","imageSmall":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104170925086_398.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104170925086_398.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104170925086_398.jpg","hasStock":1,"promotionLabel":null,"couponLabel":"","discountedPrice":null},{"itemId":286539,"itemName":"Reen睿嫣 瑞香洗发水 500ml","sellingPrice":"30.65","marketPrice":"42.58","imageSmall":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104183840798_191.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104183840798_191.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104183840798_191.jpg","hasStock":1,"promotionLabel":null,"couponLabel":null,"discountedPrice":null},{"itemId":674054,"itemName":"RYO吕 棕吕防脱发洗发水 500ml","sellingPrice":"38.97","marketPrice":"54.19","imageSmall":"https://onion-images-dev.yangsupplychain.com//fmal-item-images/20171104/20171104145505409_974.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com//fmal-item-images/20171104/20171104145505409_974.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com//fmal-item-images/20171104/20171104145505409_974.jpg","hasStock":1,"promotionLabel":null,"couponLabel":null,"discountedPrice":null},{"itemId":402621,"itemName":"LANEIGE兰芝 水库凝肌平衡乳液清爽型Light 120ml","sellingPrice":"126.44","marketPrice":"176.76","imageSmall":"https://onion-images-dev.yangsupplychain.com//fmal-item-images/20171104/20171104150116466_941.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com//fmal-item-images/20171104/20171104150116466_941.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com//fmal-item-images/20171104/20171104150116466_941.jpg","hasStock":1,"promotionLabel":null,"couponLabel":null,"discountedPrice":null},{"itemId":427240,"itemName":"BOOTS博姿 小黄瓜面部磨砂膏 50ml","sellingPrice":"25.87","marketPrice":"36.13","imageSmall":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103175244296_848.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103175244296_848.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103175244296_848.jpg","hasStock":1,"promotionLabel":null,"couponLabel":null,"discountedPrice":null},{"itemId":431676,"itemName":"it's skin伊思 晶钻红参蜗牛乳液 140ml","sellingPrice":"125.48","marketPrice":"174.18","imageSmall":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103172336241_306.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103172336241_306.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103172336241_306.jpg","hasStock":1,"promotionLabel":null,"couponLabel":null,"discountedPrice":null},{"itemId":432191,"itemName":"Dr.Jart+蒂佳婷 V7维他命亮白洁面泡沫 100ml","sellingPrice":"82.90","marketPrice":"115.48","imageSmall":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103172443222_913.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103172443222_913.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103172443222_913.jpg","hasStock":1,"promotionLabel":null,"couponLabel":null,"discountedPrice":null},{"itemId":498632,"itemName":"LG  SOFY贵爱娘 卫生巾中25cm 18片【有护翼】","sellingPrice":"19.10","marketPrice":"26.45","imageSmall":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103162852851_142.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103162852851_142.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103162852851_142.jpg","hasStock":1,"promotionLabel":null,"couponLabel":null,"discountedPrice":null},{"itemId":498978,"itemName":"LG  SOFY贵爱娘 卫生巾夜用33cm 12片【有护翼】","sellingPrice":"21.94","marketPrice":"30.32","imageSmall":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103162912716_986.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103162912716_986.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103162912716_986.jpg","hasStock":1,"promotionLabel":null,"couponLabel":null,"discountedPrice":null},{"itemId":499283,"itemName":"LG  SOFY贵爱娘 卫生巾大29cm 18片【有护翼】","sellingPrice":"23.10","marketPrice":"32.26","imageSmall":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103162901268_341.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103162901268_341.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103162901268_341.jpg","hasStock":1,"promotionLabel":null,"couponLabel":null,"discountedPrice":null},{"itemId":474338,"itemName":"【两包装】KAO花王 纸尿裤新生儿(NB) 96片","sellingPrice":"156.05","marketPrice":"238.69","imageSmall":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104184423239_432.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104184423239_432.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104184423239_432.jpg","hasStock":1,"promotionLabel":null,"couponLabel":null,"discountedPrice":null},{"itemId":479268,"itemName":"【两包装】KAO花王 拉拉裤男女通用 XL44（12~22kg）","sellingPrice":"169.09","marketPrice":"238.69","imageSmall":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104184854898_196.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104184854898_196.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104184854898_196.jpg","hasStock":1,"promotionLabel":null,"couponLabel":null,"discountedPrice":null},{"itemId":479821,"itemName":"【两包装】Pampers帮宝适 绿帮婴儿纸尿裤大号L 54片","sellingPrice":"136.51","marketPrice":"192.89","imageSmall":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104184935463_955.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104184935463_955.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104184935463_955.jpg","hasStock":1,"promotionLabel":null,"couponLabel":null,"discountedPrice":null},{"itemId":560097,"itemName":"MiseenScene美妆仙 天然植物染发膏6N-巧克力棕 30ml","sellingPrice":"39.42","marketPrice":"54.19","imageSmall":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104151419761_557.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104151419761_557.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104151419761_557.jpg","hasStock":1,"promotionLabel":null,"couponLabel":null,"discountedPrice":null},{"itemId":566114,"itemName":"Amore爱茉莉 Happybath玫瑰精华亮白沐浴露 500g","sellingPrice":"30.65","marketPrice":"42.58","imageSmall":"https://onion-images-dev.yangsupplychain.com//fmal-item-images/20171104/20171104164521251_893.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com//fmal-item-images/20171104/20171104164521251_893.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com//fmal-item-images/20171104/20171104164521251_893.jpg","hasStock":1,"promotionLabel":null,"couponLabel":null,"discountedPrice":null},{"itemId":567020,"itemName":"Amore爱茉莉 Happybath棉花香水保湿沐浴露 500g","sellingPrice":"30.65","marketPrice":"42.58","imageSmall":"https://onion-images-dev.yangsupplychain.com//fmal-item-images/20171104/20171104164529965_169.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com//fmal-item-images/20171104/20171104164529965_169.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com//fmal-item-images/20171104/20171104164529965_169.jpg","hasStock":1,"promotionLabel":null,"couponLabel":null,"discountedPrice":null},{"itemId":611836,"itemName":"Nature Republic自然乐园 芦荟舒缓保湿洁面奶 150ml","sellingPrice":"25.94","marketPrice":"36.13","imageSmall":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103155320931_546.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103155320931_546.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103155320931_546.jpg","hasStock":1,"promotionLabel":null,"couponLabel":null,"discountedPrice":null},{"itemId":638940,"itemName":"SU:M37°呼吸 惊喜水份爽肤水 170ml","sellingPrice":"191.21","marketPrice":"266.43","imageSmall":"https://onion-images-dev.yangsupplychain.com//fmal-item-images/20171104/20171104170939531_499.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com//fmal-item-images/20171104/20171104170939531_499.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com//fmal-item-images/20171104/20171104170939531_499.jpg","hasStock":1,"promotionLabel":null,"couponLabel":null,"discountedPrice":null}]
     */

    private int status;
    private String msg;
    private List<DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * itemId : 1892207
         * itemName : fanwai-壹食解千愁 片片童年味蜂蜜山楂条 130g/包
         * sellingPrice : 9.03
         * marketPrice : 11.62
         * imageSmall : https://onion-images-dev.yangsupplychain.com/collect-item-images/20190910/20190910103541101_806.png
         * imageMedium : https://onion-images-dev.yangsupplychain.com/collect-item-images/20190910/20190910103541101_806.png
         * imageBig : https://onion-images-dev.yangsupplychain.com/collect-item-images/20190910/20190910103541101_806.png
         * hasStock : 1
         * promotionLabel : null
         * couponLabel : null
         * discountedPrice : null
         */

        private String itemId;
        private String itemName;
        private String sellingPrice;
        private String marketPrice;
        private String imageSmall;
        private String imageMedium;
        private String imageBig;
        private int hasStock;
        private Object promotionLabel;
        private Object couponLabel;
        private Object discountedPrice;

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

        public Object getPromotionLabel() {
            return promotionLabel;
        }

        public void setPromotionLabel(Object promotionLabel) {
            this.promotionLabel = promotionLabel;
        }

        public Object getCouponLabel() {
            return couponLabel;
        }

        public void setCouponLabel(Object couponLabel) {
            this.couponLabel = couponLabel;
        }

        public Object getDiscountedPrice() {
            return discountedPrice;
        }

        public void setDiscountedPrice(Object discountedPrice) {
            this.discountedPrice = discountedPrice;
        }
    }
}
