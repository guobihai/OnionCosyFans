package cc.onion.cosyfans.module_search.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.module_search.entity
 * @ClassName: RecommendEntity
 * @Description: 获取推荐数据
 * @Author: guobihai
 * @CreateDate: 2020-01-08 13:53
 * @UpdateUser: guobihai
 * @UpdateDate: 2020-01-08 13:53
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class RecommendEntity implements Serializable {


    /**
     * status : 200
     * msg : OK
     * data : [{"itemId":1892207,"itemName":"fanwai-壹食解千愁 片片童年味蜂蜜山楂条 130g/包","sellingPrice":"9.03","marketPrice":"11.62","imageSmall":"https://onion-images-dev.yangsupplychain.com/collect-item-images/20190910/20190910103541101_806.png","imageMedium":"https://onion-images-dev.yangsupplychain.com/collect-item-images/20190910/20190910103541101_806.png","imageBig":"https://onion-images-dev.yangsupplychain.com/collect-item-images/20190910/20190910103541101_806.png","hasStock":1,"promotionLabel":null,"couponLabel":null,"discountedPrice":null},{"itemId":126499,"itemName":"贩外商品-FW20190301","sellingPrice":"36.32","marketPrice":"77.61","imageSmall":"https://yangtaodev-1253852034.cosgz.myqcloud.com/collect-item-images/20190301/20190301112655963_599.jpg","imageMedium":"https://yangtaodev-1253852034.cosgz.myqcloud.com/collect-item-images/20190301/20190301112655963_599.jpg","imageBig":"https://yangtaodev-1253852034.cosgz.myqcloud.com/collect-item-images/20190301/20190301112655963_599.jpg","hasStock":1,"promotionLabel":null,"couponLabel":"满499减80","discountedPrice":null},{"itemId":223057,"itemName":"111RYO吕 含光耀护损伤修护洗发水红色 450ml+180ml","sellingPrice":"57.42","marketPrice":"81.93","imageSmall":"https://onion-images-dev.yangsupplychain.com//fmal-item-images/20171104/20171104172638121_203.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com//fmal-item-images/20171104/20171104172638121_203.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com//fmal-item-images/20171104/20171104172638121_203.jpg","hasStock":1,"promotionLabel":null,"couponLabel":null,"discountedPrice":null},{"itemId":226162,"itemName":"SU:M37°呼吸 sweet smile润肤乳 250ml","sellingPrice":"131.80","marketPrice":"183.21","imageSmall":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104170925086_398.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104170925086_398.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104170925086_398.jpg","hasStock":1,"promotionLabel":null,"couponLabel":"","discountedPrice":null},{"itemId":286539,"itemName":"Reen睿嫣 瑞香洗发水 500ml","sellingPrice":"30.65","marketPrice":"42.58","imageSmall":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104183840798_191.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104183840798_191.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104183840798_191.jpg","hasStock":1,"promotionLabel":null,"couponLabel":null,"discountedPrice":null},{"itemId":674054,"itemName":"RYO吕 棕吕防脱发洗发水 500ml","sellingPrice":"103.48","marketPrice":"118.70","imageSmall":"https://onion-images-dev.yangsupplychain.com//fmal-item-images/20171104/20171104145505409_974.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com//fmal-item-images/20171104/20171104145505409_974.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com//fmal-item-images/20171104/20171104145505409_974.jpg","hasStock":1,"promotionLabel":null,"couponLabel":"","discountedPrice":null},{"itemId":402621,"itemName":"LANEIGE兰芝 水库凝肌平衡乳液清爽型Light 120ml","sellingPrice":"126.44","marketPrice":"176.76","imageSmall":"https://onion-images-dev.yangsupplychain.com//fmal-item-images/20171104/20171104150116466_941.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com//fmal-item-images/20171104/20171104150116466_941.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com//fmal-item-images/20171104/20171104150116466_941.jpg","hasStock":1,"promotionLabel":null,"couponLabel":null,"discountedPrice":null},{"itemId":427240,"itemName":"BOOTS博姿 小黄瓜面部磨砂膏 50ml","sellingPrice":"25.87","marketPrice":"36.13","imageSmall":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103175244296_848.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103175244296_848.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103175244296_848.jpg","hasStock":1,"promotionLabel":null,"couponLabel":null,"discountedPrice":null},{"itemId":611836,"itemName":"Nature Republic自然乐园 芦荟舒缓保湿洁面奶 150ml","sellingPrice":"25.94","marketPrice":"36.13","imageSmall":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103155320931_546.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103155320931_546.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103155320931_546.jpg","hasStock":1,"promotionLabel":null,"couponLabel":"","discountedPrice":null},{"itemId":638940,"itemName":"SU:M37°呼吸 惊喜水份爽肤水 170ml","sellingPrice":"191.21","marketPrice":"266.43","imageSmall":"https://onion-images-dev.yangsupplychain.com//fmal-item-images/20171104/20171104170939531_499.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com//fmal-item-images/20171104/20171104170939531_499.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com//fmal-item-images/20171104/20171104170939531_499.jpg","hasStock":1,"promotionLabel":null,"couponLabel":null,"discountedPrice":null},{"itemId":645675,"itemName":"B&amp;B保宁 儿童抗菌洗衣皂 甘菊香 200g*3","sellingPrice":"29.94","marketPrice":"41.29","imageSmall":"https://onion-images-dev.yangsupplychain.com//fmal-item-images/20171104/20171104204001172_364.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com//fmal-item-images/20171104/20171104204001172_364.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com//fmal-item-images/20171104/20171104204001172_364.jpg","hasStock":1,"promotionLabel":null,"couponLabel":null,"discountedPrice":null},{"itemId":646466,"itemName":"SU:M37°呼吸 玫瑰奇迹洁面棒 80ml","sellingPrice":"111.74","marketPrice":"109.67","imageSmall":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104171009114_961.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104171009114_961.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104171009114_961.jpg","hasStock":1,"promotionLabel":null,"couponLabel":null,"discountedPrice":null},{"itemId":692233,"itemName":"Munchkin麦肯齐 儿童洗澡感温 小黄鸭","sellingPrice":"17.36","marketPrice":"23.87","imageSmall":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103174736399_956.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103174736399_956.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103174736399_956.jpg","hasStock":1,"promotionLabel":null,"couponLabel":null,"discountedPrice":null},{"itemId":723215,"itemName":"Healthy Care 葡萄籽胶囊12000mg 300粒","sellingPrice":"112.19","marketPrice":"154.18","imageSmall":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103163458903_954.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103163458903_954.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103163458903_954.jpg","hasStock":1,"promotionLabel":null,"couponLabel":null,"discountedPrice":null},{"itemId":383813,"itemName":"Munchkin麦肯齐 感温变色软勺 4支","sellingPrice":"32.71","marketPrice":"45.16","imageSmall":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104163456206_859.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104163456206_859.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104163456206_859.jpg","hasStock":1,"promotionLabel":null,"couponLabel":null,"discountedPrice":null},{"itemId":557566,"itemName":"Lancome兰蔻 清莹柔肤水(粉水) 400ml","sellingPrice":"236.24","marketPrice":"330.94","imageSmall":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104151040929_214.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104151040929_214.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104151040929_214.jpg","hasStock":1,"promotionLabel":null,"couponLabel":null,"discountedPrice":null},{"itemId":575881,"itemName":"YSL圣罗兰 亮采圆管唇膏12号色粉紅派对 4.5g","sellingPrice":"177.92","marketPrice":"247.72","imageSmall":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104165706014_898.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104165706014_898.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104165706014_898.jpg","hasStock":1,"promotionLabel":null,"couponLabel":null,"discountedPrice":null},{"itemId":575685,"itemName":"YSL圣罗兰 亮采圆管唇膏13号色邂逅巴厘 4.5g","sellingPrice":"177.92","marketPrice":"247.72","imageSmall":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104165713611_599.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104165713611_599.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104165713611_599.jpg","hasStock":1,"promotionLabel":null,"couponLabel":null,"discountedPrice":null},{"itemId":576911,"itemName":"Earth Mama地球妈妈 宝宝护臀膏 60g","sellingPrice":"71.55","marketPrice":"99.35","imageSmall":"https://onion-images-dev.yangsupplychain.com//fmal-item-images/20171104/20171104165738010_491.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com//fmal-item-images/20171104/20171104165738010_491.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com//fmal-item-images/20171104/20171104165738010_491.jpg","hasStock":1,"promotionLabel":null,"couponLabel":null,"discountedPrice":null},{"itemId":611397,"itemName":"Ah huat亚发 白咖啡特浓 15条/包","sellingPrice":"27.68","marketPrice":"38.71","imageSmall":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104144953547_468.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104144953547_468.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104144953547_468.jpg","hasStock":1,"promotionLabel":null,"couponLabel":null,"discountedPrice":null}]
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

        private int itemId;
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
