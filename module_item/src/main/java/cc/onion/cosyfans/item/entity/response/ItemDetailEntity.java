package cc.onion.cosyfans.item.entity.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import cc.onion.cosyfans.item.entity.CFCouponDTO;

/**
 * 商品详情
 * @author guobihai
 * @eamail:guobihai@163.com
 */
public class ItemDetailEntity implements Serializable {

    /**
     * status : 200
     * msg : OK
     * data : {"itemBaseInfoDTO":{"name":"36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool","shopId":null,"itemId":"146632","itemType":20,"sellingPriceRange":"34.90","marketPriceRange":"34.90","swiperList":[{"imageSmall":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_18065.jpg","imageMedium":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_18065.jpg","imageBig":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_18065.jpg"},{"imageSmall":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2016/08/17/source-img/20160817112510_13938.jpg","imageMedium":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2016/08/17/source-img/20160817112510_13938.jpg","imageBig":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2016/08/17/source-img/20160817112510_13938.jpg"},{"imageSmall":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_18065.jpg","imageMedium":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_18065.jpg","imageBig":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_18065.jpg"},{"imageSmall":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_99706.jpg","imageMedium":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_99706.jpg","imageBig":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_99706.jpg"},{"imageSmall":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_21046.jpg","imageMedium":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_21046.jpg","imageBig":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_21046.jpg"},{"imageSmall":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_20800.jpg","imageMedium":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_20800.jpg","imageBig":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_20800.jpg"},{"imageSmall":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_93301.jpg","imageMedium":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_93301.jpg","imageBig":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_93301.jpg"},{"imageSmall":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_26973.jpg","imageMedium":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_26973.jpg","imageBig":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_26973.jpg"},{"imageSmall":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_31968.JPG","imageMedium":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_31968.JPG","imageBig":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_31968.JPG"},{"imageSmall":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164115_86469.JPG","imageMedium":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164115_86469.JPG","imageBig":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164115_86469.JPG"},{"imageSmall":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2016/08/17/source-img/20160817112512_77450.JPG","imageMedium":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2016/08/17/source-img/20160817112512_77450.JPG","imageBig":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2016/08/17/source-img/20160817112512_77450.JPG"},{"imageSmall":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2016/08/17/source-img/20160817112521_16138.jpg","imageMedium":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2016/08/17/source-img/20160817112521_16138.jpg","imageBig":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2016/08/17/source-img/20160817112521_16138.jpg"}],"disabled":false,"itemDesc":"<link type=\"text/css\" rel=\"stylesheet\" href=\"https://css.chinabrands.cn/css/S2.css\"><div class=\"xxkkk\">\n<div>  <\/div><div class=\"xxkkk2\"><p><br><b>36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool<\/b><br><b>Main Features:<\/b><br>\u2022 <B>Infrared detecting technology<\/B>, non-contact, safer and healthier<br>\u2022 <B>0.5S fast measurement<\/B> <br>\u2022<B> Clear LCD screen<\/B>  and <B> high-temperature alarm function<\/B> <br>\u2022 <B>Measured distance: 5 - 10cm<\/B> <br>\u2022 <B>The temperature measuring range:<\/B>  Fahrenheit degrees Celsius (20 - 120) / degrees Celsius (30 - 50)<br>\u2022 Perfect for body temperature measurement, skin, forehead, armpit, palm, etc..<br>\u2022 Powered by 2 x AAA battery (not included)  <\/div>\n<div class=\"xkclear\"><\/div><div class=\"xxkkk\">\n    <div class=\"xxkkk20\">\n            <strong>Model:<\/strong> HT - 668   <br />             <strong>Type:<\/strong> Non-contact Infrared Thermometer  <br />             <strong>Powered by:<\/strong> 2 x AAA Battery (not included) <br />             <strong>Operating Humidity:<\/strong> Less than or equal to 85pct  <br />             <strong>Operating Temperature Range :<\/strong> 0 - 40 degree         \n    <\/div>\n      <div class=\"xxkkk20\">\n            <div style=\"display:none;\">0.237<\/div>             <strong>Package weight:<\/strong> 0.273 kg <br />             <strong>Product size (L x W x H):<\/strong> 18.00 x 9.80 x 4.00 cm / 7.09 x 3.86 x 1.57 inches <br />             <strong>Package size (L x W x H):<\/strong> 17.50 x 11.80 x 6.50 cm / 6.89 x 4.65 x 2.56 inches         \n    <\/div>\n      <div class=\"xxkkk20\">\n            <strong>Package Contents:<\/strong> 1 x 36 Degree HT - 668 Infrared Thermometer, 1 x English User Manual         \n    <\/div>\n    \n<\/div>\n<div class=\"xkclear\"><\/div>\n\n\n\n\n\n    <div id=\"ext_statement\">\n                    <div class=\"xxkkk1\"><\/div>\n            <div class=\"xxKKK2\">Please Note:<br />\r\nDue to possible physical differences between different monitors (e.g. models, settings, color gamut, panel type, screen glare, etc), the product photography is illustrative only and may not precisely reflect the actual color of the item received.<\/div>\n            <div class=\"xkclear\"><\/div>\n         \n    <\/div>\n    <div class=\"xkclear\"><\/div>\n\n\n<div id=\"product_images\" class=\"xktutu\"><div class=\"self-adaption\"><img alt=\"36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool\" src=\"https://des.chinabrands.cn/uploads/pdm-desc-pic/Electronic/image/2017/02/27/20170227132358_74473.jpg\" title=\"36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool\" style=\"max-width: 1000px;\"/><\/div><div class=\"self-adaption\"><img alt=\"36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool\" src=\"https://des.chinabrands.cn/uploads/pdm-desc-pic/Electronic/image/2017/02/27/20170227132358_35907.jpg\" title=\"36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool\" style=\"max-width:1000px\"/><\/div><div class=\"self-adaption\"><img alt=\"36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool\" src=\"https://des.chinabrands.cn/uploads/pdm-desc-pic/Electronic/image/2017/02/27/20170227132358_23754.jpg\" title=\"36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool\" style=\"max-width:1000px\"/><\/div><div class=\"self-adaption\"><img alt=\"36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool\" src=\"https://des.chinabrands.cn/uploads/pdm-desc-pic/Electronic/image/2017/02/27/20170227132358_75647.jpg\" title=\"36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool\" style=\"max-width:1000px\"/><\/div><div class=\"self-adaption\"><img alt=\"36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool\" src=\"https://des.chinabrands.cn/uploads/pdm-desc-pic/Electronic/image/2017/02/27/20170227132358_59911.jpg\" title=\"36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool\" style=\"max-width:1000px\"/><\/div><div class=\"self-adaption\"><img alt=\"36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool\" src=\"https://des.chinabrands.cn/uploads/pdm-desc-pic/Electronic/image/2017/02/27/20170227132358_46777.jpg\" title=\"36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool\" style=\"max-width:1000px\"/><\/div><div class=\"self-adaption\"><img src=\"https://des.chinabrands.cn/uploads/pdm-desc-pic/Electronic/image/2017/02/27/1488184722301583.jpg\" title=\"36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool\" style=\"max-width:1000px\" alt=\"36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool\" /><\/div><\/div><\/div>","itemDescFlag":1,"timeliness":"7-18 days"},"itemAttributeDTOList":[],"skuInfoShowDTO":{"skuOptionNameList":[{"specName":"Color","specId":2090257,"specOptionList":[{"specOptId":4045392,"specOptName":"WHITE AND PURPLE"}]}],"skuPriceMap":{"4045392":{"skuId":181660,"marketPrice":"34.90","sellingPrice":"34.90","imageSmall":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2016/08/17/source-img/20160817112510_13938.jpg","imageMedium":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2016/08/17/source-img/20160817112510_13938.jpg","imageBig":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2016/08/17/source-img/20160817112510_13938.jpg","salesProfit":"0.00","limitCount":0,"minimumLimitCount":0,"stock":0,"itemStatus":1,"isKeyOrder":0,"giftType":0,"profitDetail":null,"discountPrice":""}}},"itemDetailPromotionLevelDTO":{"promotionLabel":null,"cfPromotionLevelDTOS":[]},"cfCouponDTO":null}
     */

    private int status;
    private String msg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * itemBaseInfoDTO : {"name":"36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool","shopId":null,"itemId":"146632","itemType":20,"sellingPriceRange":"34.90","marketPriceRange":"34.90","swiperList":[{"imageSmall":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_18065.jpg","imageMedium":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_18065.jpg","imageBig":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_18065.jpg"},{"imageSmall":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2016/08/17/source-img/20160817112510_13938.jpg","imageMedium":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2016/08/17/source-img/20160817112510_13938.jpg","imageBig":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2016/08/17/source-img/20160817112510_13938.jpg"},{"imageSmall":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_18065.jpg","imageMedium":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_18065.jpg","imageBig":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_18065.jpg"},{"imageSmall":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_99706.jpg","imageMedium":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_99706.jpg","imageBig":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_99706.jpg"},{"imageSmall":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_21046.jpg","imageMedium":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_21046.jpg","imageBig":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_21046.jpg"},{"imageSmall":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_20800.jpg","imageMedium":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_20800.jpg","imageBig":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_20800.jpg"},{"imageSmall":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_93301.jpg","imageMedium":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_93301.jpg","imageBig":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_93301.jpg"},{"imageSmall":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_26973.jpg","imageMedium":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_26973.jpg","imageBig":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_26973.jpg"},{"imageSmall":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_31968.JPG","imageMedium":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_31968.JPG","imageBig":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_31968.JPG"},{"imageSmall":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164115_86469.JPG","imageMedium":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164115_86469.JPG","imageBig":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164115_86469.JPG"},{"imageSmall":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2016/08/17/source-img/20160817112512_77450.JPG","imageMedium":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2016/08/17/source-img/20160817112512_77450.JPG","imageBig":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2016/08/17/source-img/20160817112512_77450.JPG"},{"imageSmall":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2016/08/17/source-img/20160817112521_16138.jpg","imageMedium":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2016/08/17/source-img/20160817112521_16138.jpg","imageBig":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2016/08/17/source-img/20160817112521_16138.jpg"}],"disabled":false,"itemDesc":"<link type=\"text/css\" rel=\"stylesheet\" href=\"https://css.chinabrands.cn/css/S2.css\"><div class=\"xxkkk\">\n<div>  <\/div><div class=\"xxkkk2\"><p><br><b>36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool<\/b><br><b>Main Features:<\/b><br>\u2022 <B>Infrared detecting technology<\/B>, non-contact, safer and healthier<br>\u2022 <B>0.5S fast measurement<\/B> <br>\u2022<B> Clear LCD screen<\/B>  and <B> high-temperature alarm function<\/B> <br>\u2022 <B>Measured distance: 5 - 10cm<\/B> <br>\u2022 <B>The temperature measuring range:<\/B>  Fahrenheit degrees Celsius (20 - 120) / degrees Celsius (30 - 50)<br>\u2022 Perfect for body temperature measurement, skin, forehead, armpit, palm, etc..<br>\u2022 Powered by 2 x AAA battery (not included)  <\/div>\n<div class=\"xkclear\"><\/div><div class=\"xxkkk\">\n    <div class=\"xxkkk20\">\n            <strong>Model:<\/strong> HT - 668   <br />             <strong>Type:<\/strong> Non-contact Infrared Thermometer  <br />             <strong>Powered by:<\/strong> 2 x AAA Battery (not included) <br />             <strong>Operating Humidity:<\/strong> Less than or equal to 85pct  <br />             <strong>Operating Temperature Range :<\/strong> 0 - 40 degree         \n    <\/div>\n      <div class=\"xxkkk20\">\n            <div style=\"display:none;\">0.237<\/div>             <strong>Package weight:<\/strong> 0.273 kg <br />             <strong>Product size (L x W x H):<\/strong> 18.00 x 9.80 x 4.00 cm / 7.09 x 3.86 x 1.57 inches <br />             <strong>Package size (L x W x H):<\/strong> 17.50 x 11.80 x 6.50 cm / 6.89 x 4.65 x 2.56 inches         \n    <\/div>\n      <div class=\"xxkkk20\">\n            <strong>Package Contents:<\/strong> 1 x 36 Degree HT - 668 Infrared Thermometer, 1 x English User Manual         \n    <\/div>\n    \n<\/div>\n<div class=\"xkclear\"><\/div>\n\n\n\n\n\n    <div id=\"ext_statement\">\n                    <div class=\"xxkkk1\"><\/div>\n            <div class=\"xxKKK2\">Please Note:<br />\r\nDue to possible physical differences between different monitors (e.g. models, settings, color gamut, panel type, screen glare, etc), the product photography is illustrative only and may not precisely reflect the actual color of the item received.<\/div>\n            <div class=\"xkclear\"><\/div>\n         \n    <\/div>\n    <div class=\"xkclear\"><\/div>\n\n\n<div id=\"product_images\" class=\"xktutu\"><div class=\"self-adaption\"><img alt=\"36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool\" src=\"https://des.chinabrands.cn/uploads/pdm-desc-pic/Electronic/image/2017/02/27/20170227132358_74473.jpg\" title=\"36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool\" style=\"max-width: 1000px;\"/><\/div><div class=\"self-adaption\"><img alt=\"36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool\" src=\"https://des.chinabrands.cn/uploads/pdm-desc-pic/Electronic/image/2017/02/27/20170227132358_35907.jpg\" title=\"36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool\" style=\"max-width:1000px\"/><\/div><div class=\"self-adaption\"><img alt=\"36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool\" src=\"https://des.chinabrands.cn/uploads/pdm-desc-pic/Electronic/image/2017/02/27/20170227132358_23754.jpg\" title=\"36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool\" style=\"max-width:1000px\"/><\/div><div class=\"self-adaption\"><img alt=\"36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool\" src=\"https://des.chinabrands.cn/uploads/pdm-desc-pic/Electronic/image/2017/02/27/20170227132358_75647.jpg\" title=\"36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool\" style=\"max-width:1000px\"/><\/div><div class=\"self-adaption\"><img alt=\"36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool\" src=\"https://des.chinabrands.cn/uploads/pdm-desc-pic/Electronic/image/2017/02/27/20170227132358_59911.jpg\" title=\"36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool\" style=\"max-width:1000px\"/><\/div><div class=\"self-adaption\"><img alt=\"36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool\" src=\"https://des.chinabrands.cn/uploads/pdm-desc-pic/Electronic/image/2017/02/27/20170227132358_46777.jpg\" title=\"36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool\" style=\"max-width:1000px\"/><\/div><div class=\"self-adaption\"><img src=\"https://des.chinabrands.cn/uploads/pdm-desc-pic/Electronic/image/2017/02/27/1488184722301583.jpg\" title=\"36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool\" style=\"max-width:1000px\" alt=\"36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool\" /><\/div><\/div><\/div>","itemDescFlag":1,"timeliness":"7-18 days"}
         * itemAttributeDTOList : []
         * skuInfoShowDTO : {"skuOptionNameList":[{"specName":"Color","specId":2090257,"specOptionList":[{"specOptId":4045392,"specOptName":"WHITE AND PURPLE"}]}],"skuPriceMap":{"4045392":{"skuId":181660,"marketPrice":"34.90","sellingPrice":"34.90","imageSmall":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2016/08/17/source-img/20160817112510_13938.jpg","imageMedium":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2016/08/17/source-img/20160817112510_13938.jpg","imageBig":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2016/08/17/source-img/20160817112510_13938.jpg","salesProfit":"0.00","limitCount":0,"minimumLimitCount":0,"stock":0,"itemStatus":1,"isKeyOrder":0,"giftType":0,"profitDetail":null,"discountPrice":""}}}
         * itemDetailPromotionLevelDTO : {"promotionLabel":null,"cfPromotionLevelDTOS":[]}
         * cfCouponDTO : null
         */

        private ItemBaseInfoDTOBean itemBaseInfoDTO;
        private SkuInfoShowDTOBean skuInfoShowDTO;
        private ItemDetailPromotionLevelDTOBean itemDetailPromotionLevelDTO;
        private CFCouponDTO cfCouponDTO;
        private List<DetailItemEntity> itemAttributeDTOList;

        public ItemBaseInfoDTOBean getItemBaseInfoDTO() {
            return itemBaseInfoDTO;
        }

        public void setItemBaseInfoDTO(ItemBaseInfoDTOBean itemBaseInfoDTO) {
            this.itemBaseInfoDTO = itemBaseInfoDTO;
        }

        public SkuInfoShowDTOBean getSkuInfoShowDTO() {
            return skuInfoShowDTO;
        }

        public void setSkuInfoShowDTO(SkuInfoShowDTOBean skuInfoShowDTO) {
            this.skuInfoShowDTO = skuInfoShowDTO;
        }

        public ItemDetailPromotionLevelDTOBean getItemDetailPromotionLevelDTO() {
            return itemDetailPromotionLevelDTO;
        }

        public void setItemDetailPromotionLevelDTO(ItemDetailPromotionLevelDTOBean itemDetailPromotionLevelDTO) {
            this.itemDetailPromotionLevelDTO = itemDetailPromotionLevelDTO;
        }

        public CFCouponDTO getCfCouponDTO() {
            return cfCouponDTO;
        }

        public void setCfCouponDTO(CFCouponDTO cfCouponDTO) {
            this.cfCouponDTO = cfCouponDTO;
        }

        public List<DetailItemEntity> getItemAttributeDTOList() {
            return itemAttributeDTOList;
        }

        public void setItemAttributeDTOList(List<DetailItemEntity> itemAttributeDTOList) {
            this.itemAttributeDTOList = itemAttributeDTOList;
        }

        public static class ItemBaseInfoDTOBean {
            /**
             * name : 36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool
             * shopId : null
             * itemId : 146632
             * itemType : 20
             * sellingPriceRange : 34.90
             * marketPriceRange : 34.90
             * swiperList : [{"imageSmall":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_18065.jpg","imageMedium":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_18065.jpg","imageBig":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_18065.jpg"},{"imageSmall":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2016/08/17/source-img/20160817112510_13938.jpg","imageMedium":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2016/08/17/source-img/20160817112510_13938.jpg","imageBig":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2016/08/17/source-img/20160817112510_13938.jpg"},{"imageSmall":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_18065.jpg","imageMedium":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_18065.jpg","imageBig":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_18065.jpg"},{"imageSmall":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_99706.jpg","imageMedium":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_99706.jpg","imageBig":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_99706.jpg"},{"imageSmall":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_21046.jpg","imageMedium":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_21046.jpg","imageBig":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_21046.jpg"},{"imageSmall":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_20800.jpg","imageMedium":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_20800.jpg","imageBig":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_20800.jpg"},{"imageSmall":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_93301.jpg","imageMedium":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_93301.jpg","imageBig":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_93301.jpg"},{"imageSmall":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_26973.jpg","imageMedium":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_26973.jpg","imageBig":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_26973.jpg"},{"imageSmall":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_31968.JPG","imageMedium":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_31968.JPG","imageBig":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_31968.JPG"},{"imageSmall":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164115_86469.JPG","imageMedium":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164115_86469.JPG","imageBig":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164115_86469.JPG"},{"imageSmall":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2016/08/17/source-img/20160817112512_77450.JPG","imageMedium":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2016/08/17/source-img/20160817112512_77450.JPG","imageBig":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2016/08/17/source-img/20160817112512_77450.JPG"},{"imageSmall":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2016/08/17/source-img/20160817112521_16138.jpg","imageMedium":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2016/08/17/source-img/20160817112521_16138.jpg","imageBig":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2016/08/17/source-img/20160817112521_16138.jpg"}]
             * disabled : false
             * itemDesc : <link type="text/css" rel="stylesheet" href="https://css.chinabrands.cn/css/S2.css"><div class="xxkkk">
             <div>  </div><div class="xxkkk2"><p><br><b>36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool</b><br><b>Main Features:</b><br>• <B>Infrared detecting technology</B>, non-contact, safer and healthier<br>• <B>0.5S fast measurement</B> <br>•<B> Clear LCD screen</B>  and <B> high-temperature alarm function</B> <br>• <B>Measured distance: 5 - 10cm</B> <br>• <B>The temperature measuring range:</B>  Fahrenheit degrees Celsius (20 - 120) / degrees Celsius (30 - 50)<br>• Perfect for body temperature measurement, skin, forehead, armpit, palm, etc..<br>• Powered by 2 x AAA battery (not included)  </div>
             <div class="xkclear"></div><div class="xxkkk">
             <div class="xxkkk20">
             <strong>Model:</strong> HT - 668   <br />             <strong>Type:</strong> Non-contact Infrared Thermometer  <br />             <strong>Powered by:</strong> 2 x AAA Battery (not included) <br />             <strong>Operating Humidity:</strong> Less than or equal to 85pct  <br />             <strong>Operating Temperature Range :</strong> 0 - 40 degree
             </div>
             <div class="xxkkk20">
             <div style="display:none;">0.237</div>             <strong>Package weight:</strong> 0.273 kg <br />             <strong>Product size (L x W x H):</strong> 18.00 x 9.80 x 4.00 cm / 7.09 x 3.86 x 1.57 inches <br />             <strong>Package size (L x W x H):</strong> 17.50 x 11.80 x 6.50 cm / 6.89 x 4.65 x 2.56 inches
             </div>
             <div class="xxkkk20">
             <strong>Package Contents:</strong> 1 x 36 Degree HT - 668 Infrared Thermometer, 1 x English User Manual
             </div>

             </div>
             <div class="xkclear"></div>





             <div id="ext_statement">
             <div class="xxkkk1"></div>
             <div class="xxKKK2">Please Note:<br />
             Due to possible physical differences between different monitors (e.g. models, settings, color gamut, panel type, screen glare, etc), the product photography is illustrative only and may not precisely reflect the actual color of the item received.</div>
             <div class="xkclear"></div>

             </div>
             <div class="xkclear"></div>


             <div id="product_images" class="xktutu"><div class="self-adaption"><img alt="36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool" src="https://des.chinabrands.cn/uploads/pdm-desc-pic/Electronic/image/2017/02/27/20170227132358_74473.jpg" title="36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool" style="max-width: 1000px;"/></div><div class="self-adaption"><img alt="36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool" src="https://des.chinabrands.cn/uploads/pdm-desc-pic/Electronic/image/2017/02/27/20170227132358_35907.jpg" title="36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool" style="max-width:1000px"/></div><div class="self-adaption"><img alt="36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool" src="https://des.chinabrands.cn/uploads/pdm-desc-pic/Electronic/image/2017/02/27/20170227132358_23754.jpg" title="36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool" style="max-width:1000px"/></div><div class="self-adaption"><img alt="36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool" src="https://des.chinabrands.cn/uploads/pdm-desc-pic/Electronic/image/2017/02/27/20170227132358_75647.jpg" title="36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool" style="max-width:1000px"/></div><div class="self-adaption"><img alt="36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool" src="https://des.chinabrands.cn/uploads/pdm-desc-pic/Electronic/image/2017/02/27/20170227132358_59911.jpg" title="36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool" style="max-width:1000px"/></div><div class="self-adaption"><img alt="36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool" src="https://des.chinabrands.cn/uploads/pdm-desc-pic/Electronic/image/2017/02/27/20170227132358_46777.jpg" title="36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool" style="max-width:1000px"/></div><div class="self-adaption"><img src="https://des.chinabrands.cn/uploads/pdm-desc-pic/Electronic/image/2017/02/27/1488184722301583.jpg" title="36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool" style="max-width:1000px" alt="36 Degree HT - 668 Non-contact Infrared Thermometer Forehead IR Body Temperature Measuring Tool" /></div></div></div>
             * itemDescFlag : 1
             * timeliness : 7-18 days
             */

            private String name;
            private Object shopId;
            private String itemId;
            private int itemType;
            private String sellingPriceRange;
            private String marketPriceRange;
            private boolean disabled;
            private String itemDesc;
            private int itemDescFlag;
            private String timeliness;
            private List<SwiperListBean> swiperList;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Object getShopId() {
                return shopId;
            }

            public void setShopId(Object shopId) {
                this.shopId = shopId;
            }

            public String getItemId() {
                return itemId;
            }

            public void setItemId(String itemId) {
                this.itemId = itemId;
            }

            public int getItemType() {
                return itemType;
            }

            public void setItemType(int itemType) {
                this.itemType = itemType;
            }

            public String getSellingPriceRange() {
                return sellingPriceRange;
            }

            public void setSellingPriceRange(String sellingPriceRange) {
                this.sellingPriceRange = sellingPriceRange;
            }

            public String getMarketPriceRange() {
                return marketPriceRange;
            }

            public void setMarketPriceRange(String marketPriceRange) {
                this.marketPriceRange = marketPriceRange;
            }

            public boolean isDisabled() {
                return disabled;
            }

            public void setDisabled(boolean disabled) {
                this.disabled = disabled;
            }

            public String getItemDesc() {
                return itemDesc;
            }

            public void setItemDesc(String itemDesc) {
                this.itemDesc = itemDesc;
            }

            public int getItemDescFlag() {
                return itemDescFlag;
            }

            public void setItemDescFlag(int itemDescFlag) {
                this.itemDescFlag = itemDescFlag;
            }

            public String getTimeliness() {
                return timeliness;
            }

            public void setTimeliness(String timeliness) {
                this.timeliness = timeliness;
            }

            public List<SwiperListBean> getSwiperList() {
                return swiperList;
            }

            public void setSwiperList(List<SwiperListBean> swiperList) {
                this.swiperList = swiperList;
            }

            public static class SwiperListBean {
                /**
                 * imageSmall : https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_18065.jpg
                 * imageMedium : https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_18065.jpg
                 * imageBig : https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2017/02/27/source-img/20170227164114_18065.jpg
                 */

                private String imageSmall;
                private String imageMedium;
                private String imageBig;

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
            }
        }

        public static class SkuInfoShowDTOBean {
            /**
             * skuOptionNameList : [{"specName":"Color","specId":2090257,"specOptionList":[{"specOptId":4045392,"specOptName":"WHITE AND PURPLE"}]}]
             * skuPriceMap : {"4045392":{"skuId":181660,"marketPrice":"34.90","sellingPrice":"34.90","imageSmall":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2016/08/17/source-img/20160817112510_13938.jpg","imageMedium":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2016/08/17/source-img/20160817112510_13938.jpg","imageBig":"https://glodimg.chinabrands.cn/pdm-product-pic/Electronic/2016/08/17/source-img/20160817112510_13938.jpg","salesProfit":"0.00","limitCount":0,"minimumLimitCount":0,"stock":0,"itemStatus":1,"isKeyOrder":0,"giftType":0,"profitDetail":null,"discountPrice":""}}
             */

            private Object skuPriceMap;
            private List<SkuOptionNameListBean> skuOptionNameList;


            public List<SkuOptionNameListBean> getSkuOptionNameList() {
                return skuOptionNameList;
            }

            public void setSkuOptionNameList(List<SkuOptionNameListBean> skuOptionNameList) {
                this.skuOptionNameList = skuOptionNameList;
            }

            public Object getSkuPriceMap() {
                return skuPriceMap;
            }

            public void setSkuPriceMap(Object skuPriceMap) {
                this.skuPriceMap = skuPriceMap;
            }

            public static class SkuOptionNameListBean {
                /**
                 * specName : Color
                 * specId : 2090257
                 * specOptionList : [{"specOptId":4045392,"specOptName":"WHITE AND PURPLE"}]
                 */

                private String specName;
                private int specId;
                private List<SpecOptionListBean> specOptionList;

                public SkuOptionNameListBean(String specName, int specId) {
                    this.specName = specName;
                    this.specId = specId;
                }

                public String getSpecName() {
                    return specName;
                }

                public void setSpecName(String specName) {
                    this.specName = specName;
                }

                public int getSpecId() {
                    return specId;
                }

                public void setSpecId(int specId) {
                    this.specId = specId;
                }

                public List<SpecOptionListBean> getSpecOptionList() {
                    return specOptionList;
                }

                public void setSpecOptionList(List<SpecOptionListBean> specOptionList) {
                    this.specOptionList = specOptionList;
                }

                public static class SpecOptionListBean {
                    /**
                     * specOptId : 4045392
                     * specOptName : WHITE AND PURPLE
                     */

                    private int specOptId;
                    private String specOptName;
                    private  boolean isSelect;
                    private  boolean isNull = false;

                    public boolean isNull() {
                        return isNull;
                    }

                    public void setNull(boolean aNull) {
                        isNull = aNull;
                    }

                    public SpecOptionListBean(int specOptId, String specOptName, boolean isSelect) {
                        this.specOptId = specOptId;
                        this.specOptName = specOptName;
                        this.isSelect = isSelect;
                    }

                    public boolean isSelect() {
                        return isSelect;
                    }

                    public void setSelect(boolean select) {
                        isSelect = select;
                    }

                    public int getSpecOptId() {
                        return specOptId;
                    }

                    public void setSpecOptId(int specOptId) {
                        this.specOptId = specOptId;
                    }

                    public String getSpecOptName() {
                        return specOptName;
                    }

                    public void setSpecOptName(String specOptName) {
                        this.specOptName = specOptName;
                    }
                }
            }
        }

        public static class ItemDetailPromotionLevelDTOBean {


            /**
             * promotionLabel : 满5件7.5折, 满5件8折, 满2件9折...
             * cfPromotionLevelDTOS : [{"promotionLabel":"Buy 2 get 5% off, Buy 5 get 20% off","promotionId":16771},{"promotionLabel":"Buy 2 get 10% off, Buy 5 get 24.5% off","promotionId":16878}]
             */

            private String promotionLabel;
            private List<CfPromotionLevelDTOSBean> cfPromotionLevelDTOS;

            public String getPromotionLabel() {
                return promotionLabel;
            }

            public void setPromotionLabel(String promotionLabel) {
                this.promotionLabel = promotionLabel;
            }

            public List<CfPromotionLevelDTOSBean> getCfPromotionLevelDTOS() {
                return cfPromotionLevelDTOS;
            }

            public void setCfPromotionLevelDTOS(List<CfPromotionLevelDTOSBean> cfPromotionLevelDTOS) {
                this.cfPromotionLevelDTOS = cfPromotionLevelDTOS;
            }

            public static class CfPromotionLevelDTOSBean {
                /**
                 * promotionLabel : Buy 2 get 5% off, Buy 5 get 20% off
                 * promotionId : 16771
                 */

                private String promotionLabel;
                private int promotionId;

                public String getPromotionLabel() {
                    return promotionLabel;
                }

                public void setPromotionLabel(String promotionLabel) {
                    this.promotionLabel = promotionLabel;
                }

                public int getPromotionId() {
                    return promotionId;
                }

                public void setPromotionId(int promotionId) {
                    this.promotionId = promotionId;
                }
            }

        }
    }
}
