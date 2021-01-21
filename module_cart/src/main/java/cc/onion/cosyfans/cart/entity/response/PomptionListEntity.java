package cc.onion.cosyfans.cart.entity.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.cart.entity.response
 * @ClassName: PomptionListEntity
 * @Description: 折扣列表数据类
 * @Author: guobihai
 * @CreateDate: 2019-12-24 10:58
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-24 10:58
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class PomptionListEntity implements Serializable {
    private static final long serialVersionUID = 4572043411237467323L;


    /**
     * status : 200
     * msg : OK
     * data : {"isLogin":true,"totalPages":6,"levelName":"满1件9.5折, 满2件9折","startTime":"2019-12-05 10:30:04","endTime":"2020-01-11 10:30:06","items":[{"itemId":27591,"itemName":"Lyajin丽雅珍 润面膜 25ml*5","sellingPrice":"64.51","marketPrice":"129.02","imageSmall":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104145854353_849.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104145854353_849.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104145854353_849.jpg","hasStock":1,"promotionLabel":" 满2件9折","couponLabel":"满120减13","skuInfoShowDTO":{"skuOptionNameList":null,"skuPriceMap":{"0":{"skuId":27400,"marketPrice":"129.02","sellingPrice":"64.51","imageSmall":"","imageMedium":"","imageBig":"","salesProfit":"0","limitCount":0,"minimumLimitCount":0,"stock":389,"itemStatus":1,"isKeyOrder":0,"giftType":0,"profitDetail":{"totalProfit":"0","levelOneSalesProfit":null,"levelOneDevelopmentProfit":null,"levelTwoSalesProfit":null,"levelThreeSalesProfit":null},"discountPrice":"48.71"}}},"discountedPrice":"58.06"},{"itemId":27825,"itemName":"Too Cool For School 鸡蛋摩丝洁面泡沫 150g","sellingPrice":"50.97","marketPrice":"72.90","imageSmall":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103155337138_836.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103155337138_836.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103155337138_836.jpg","hasStock":0,"promotionLabel":" 满2件9折","couponLabel":"满200减12","skuInfoShowDTO":{"skuOptionNameList":null,"skuPriceMap":{"0":{"skuId":27985,"marketPrice":"72.90","sellingPrice":"50.97","imageSmall":"","imageMedium":"","imageBig":"","salesProfit":"0","limitCount":0,"minimumLimitCount":0,"stock":0,"itemStatus":1,"isKeyOrder":0,"giftType":0,"profitDetail":{"totalProfit":"0","levelOneSalesProfit":null,"levelOneDevelopmentProfit":null,"levelTwoSalesProfit":null,"levelThreeSalesProfit":null},"discountPrice":"38.48"}}},"discountedPrice":"45.87"},{"itemId":29197,"itemName":"ISANA伊萨娜 芦荟洋甘菊舒敏脱毛滚珠 120ml","sellingPrice":"58.06","marketPrice":"77.42","imageSmall":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104192503718_765.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104192503718_765.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104192503718_765.jpg","hasStock":1,"promotionLabel":" 满2件9折","couponLabel":"满120减13","skuInfoShowDTO":{"skuOptionNameList":null,"skuPriceMap":{"0":{"skuId":29524,"marketPrice":"77.42","sellingPrice":"58.06","imageSmall":"","imageMedium":"","imageBig":"","salesProfit":"0","limitCount":0,"minimumLimitCount":0,"stock":386,"itemStatus":1,"isKeyOrder":0,"giftType":0,"profitDetail":{"totalProfit":"0","levelOneSalesProfit":null,"levelOneDevelopmentProfit":null,"levelTwoSalesProfit":null,"levelThreeSalesProfit":null},"discountPrice":"43.84"}}},"discountedPrice":"52.25"},{"itemId":28637,"itemName":"AHC 高浓度B5玻尿酸精华液面膜二代 5片","sellingPrice":"161.28","marketPrice":"165.15","imageSmall":"https://yangtaodev-1253852034.cosgz.myqcloud.com/fmal-item-images/20171104/20171104165253715_757.jpg","imageMedium":"https://yangtaodev-1253852034.cosgz.myqcloud.com/fmal-item-images/20171104/20171104165253715_757.jpg","imageBig":"https://yangtaodev-1253852034.cosgz.myqcloud.com/fmal-item-images/20171104/20171104165253715_757.jpg","hasStock":1,"promotionLabel":" 满2件9折","couponLabel":"满120减13","skuInfoShowDTO":{"skuOptionNameList":null,"skuPriceMap":{"0":{"skuId":28919,"marketPrice":"165.15","sellingPrice":"161.28","imageSmall":"","imageMedium":"","imageBig":"","salesProfit":"0","limitCount":1,"minimumLimitCount":1,"stock":386,"itemStatus":1,"isKeyOrder":0,"giftType":0,"profitDetail":{"totalProfit":"0","levelOneSalesProfit":null,"levelOneDevelopmentProfit":null,"levelTwoSalesProfit":null,"levelThreeSalesProfit":null},"discountPrice":"121.77"}}},"discountedPrice":"145.15"},{"itemId":27762,"itemName":"SU:M37°呼吸 焕肤精华洁肤泡沫 245ml","sellingPrice":"116.12","marketPrice":"168.38","imageSmall":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104170931422_835.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104170931422_835.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104170931422_835.jpg","hasStock":1,"promotionLabel":" 满2件9折","couponLabel":"满120减13","skuInfoShowDTO":{"skuOptionNameList":null,"skuPriceMap":{"0":{"skuId":27610,"marketPrice":"168.38","sellingPrice":"116.12","imageSmall":"","imageMedium":"","imageBig":"","salesProfit":"0","limitCount":0,"minimumLimitCount":0,"stock":389,"itemStatus":1,"isKeyOrder":0,"giftType":0,"profitDetail":{"totalProfit":"0","levelOneSalesProfit":null,"levelOneDevelopmentProfit":null,"levelTwoSalesProfit":null,"levelThreeSalesProfit":null},"discountPrice":"87.67"}}},"discountedPrice":"104.51"},{"itemId":757695,"itemName":"【两包装】GOO.N大王 拉拉裤男 XL38(12~20kg)","sellingPrice":"136.69","marketPrice":"192.89","imageSmall":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/3398/3031005840/20180223/20180223165718575_833.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/3398/3031005840/20180223/20180223165718575_833.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/3398/3031005840/20180223/20180223165718575_833.jpg","hasStock":1,"promotionLabel":" 满2件9折","couponLabel":"","skuInfoShowDTO":{"skuOptionNameList":null,"skuPriceMap":{"0":{"skuId":2847208,"marketPrice":"192.89","sellingPrice":"136.69","imageSmall":"","imageMedium":"","imageBig":"","salesProfit":"0","limitCount":0,"minimumLimitCount":0,"stock":388,"itemStatus":1,"isKeyOrder":1,"giftType":0,"profitDetail":{"totalProfit":"0","levelOneSalesProfit":null,"levelOneDevelopmentProfit":null,"levelTwoSalesProfit":null,"levelThreeSalesProfit":null},"discountPrice":"123.02"}}},"discountedPrice":"123.02"},{"itemId":648503,"itemName":"【两包装】KAO花王 纸尿裤 M68","sellingPrice":"170.05","marketPrice":"238.69","imageSmall":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104184802747_715.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104184802747_715.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104184802747_715.jpg","hasStock":0,"promotionLabel":" 满2件9折","couponLabel":"","skuInfoShowDTO":{"skuOptionNameList":null,"skuPriceMap":{"0":{"skuId":2740178,"marketPrice":"238.69","sellingPrice":"170.05","imageSmall":"","imageMedium":"","imageBig":"","salesProfit":"0","limitCount":0,"minimumLimitCount":0,"stock":0,"itemStatus":1,"isKeyOrder":1,"giftType":0,"profitDetail":{"totalProfit":"0","levelOneSalesProfit":null,"levelOneDevelopmentProfit":null,"levelTwoSalesProfit":null,"levelThreeSalesProfit":null},"discountPrice":"153.05"}}},"discountedPrice":"153.05"},{"itemId":639089,"itemName":"【两包装】GOO.N大王 拉拉裤男 L44(9~14kg)","sellingPrice":"142.12","marketPrice":"192.89","imageSmall":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104184841022_443.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104184841022_443.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104184841022_443.jpg","hasStock":0,"promotionLabel":" 满2件9折","couponLabel":"","skuInfoShowDTO":{"skuOptionNameList":null,"skuPriceMap":{"0":{"skuId":2729522,"marketPrice":"192.89","sellingPrice":"142.12","imageSmall":"","imageMedium":"","imageBig":"","salesProfit":"0","limitCount":0,"minimumLimitCount":0,"stock":0,"itemStatus":1,"isKeyOrder":1,"giftType":0,"profitDetail":{"totalProfit":"0","levelOneSalesProfit":null,"levelOneDevelopmentProfit":null,"levelTwoSalesProfit":null,"levelThreeSalesProfit":null},"discountPrice":"127.91"}}},"discountedPrice":"127.91"},{"itemId":332752,"itemName":"Longchamp珑骧 长柄小号折叠包军绿色 28*25*14cm","sellingPrice":"515.44","marketPrice":"736.06","imageSmall":"https://onion-images-dev.yangsupplychain.com//fmal-item-images/20171104/20171104183828650_668.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com//fmal-item-images/20171104/20171104183828650_668.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com//fmal-item-images/20171104/20171104183828650_668.jpg","hasStock":0,"promotionLabel":" 满2件9折","couponLabel":"","skuInfoShowDTO":{"skuOptionNameList":null,"skuPriceMap":{"0":{"skuId":2424573,"marketPrice":"736.06","sellingPrice":"515.44","imageSmall":"","imageMedium":"","imageBig":"","salesProfit":"0","limitCount":0,"minimumLimitCount":0,"stock":0,"itemStatus":1,"isKeyOrder":0,"giftType":0,"profitDetail":{"totalProfit":"0","levelOneSalesProfit":null,"levelOneDevelopmentProfit":null,"levelTwoSalesProfit":null,"levelThreeSalesProfit":null},"discountPrice":"463.90"}}},"discountedPrice":"463.90"},{"itemId":25608,"itemName":"Clarins娇韵诗 瞬间眼部卸妆液30ml+温和清洁乳100ml(混/油)+清新爽肤水100ml(","sellingPrice":"100.64","marketPrice":"143.86","imageSmall":"https://yangtaodev-1253852034.cosgz.myqcloud.com/fmal-item-images/20171104/20171104172356092_920.jpg","imageMedium":"https://yangtaodev-1253852034.cosgz.myqcloud.com/fmal-item-images/20171104/20171104172356092_920.jpg","imageBig":"https://yangtaodev-1253852034.cosgz.myqcloud.com/fmal-item-images/20171104/20171104172356092_920.jpg","hasStock":1,"promotionLabel":" 满2件9折","couponLabel":"满120减13","skuInfoShowDTO":{"skuOptionNameList":null,"skuPriceMap":{"0":{"skuId":25898,"marketPrice":"143.86","sellingPrice":"100.64","imageSmall":"","imageMedium":"","imageBig":"","salesProfit":"0","limitCount":0,"minimumLimitCount":0,"stock":389,"itemStatus":1,"isKeyOrder":0,"giftType":0,"profitDetail":{"totalProfit":"0","levelOneSalesProfit":null,"levelOneDevelopmentProfit":null,"levelTwoSalesProfit":null,"levelThreeSalesProfit":null},"discountPrice":"80.51"}}},"discountedPrice":"90.58"}]}
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
         * isLogin : true
         * totalPages : 6
         * levelName : 满1件9.5折, 满2件9折
         * startTime : 2019-12-05 10:30:04
         * endTime : 2020-01-11 10:30:06
         * items : [{"itemId":27591,"itemName":"Lyajin丽雅珍 润面膜 25ml*5","sellingPrice":"64.51","marketPrice":"129.02","imageSmall":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104145854353_849.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104145854353_849.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104145854353_849.jpg","hasStock":1,"promotionLabel":" 满2件9折","couponLabel":"满120减13","skuInfoShowDTO":{"skuOptionNameList":null,"skuPriceMap":{"0":{"skuId":27400,"marketPrice":"129.02","sellingPrice":"64.51","imageSmall":"","imageMedium":"","imageBig":"","salesProfit":"0","limitCount":0,"minimumLimitCount":0,"stock":389,"itemStatus":1,"isKeyOrder":0,"giftType":0,"profitDetail":{"totalProfit":"0","levelOneSalesProfit":null,"levelOneDevelopmentProfit":null,"levelTwoSalesProfit":null,"levelThreeSalesProfit":null},"discountPrice":"48.71"}}},"discountedPrice":"58.06"},{"itemId":27825,"itemName":"Too Cool For School 鸡蛋摩丝洁面泡沫 150g","sellingPrice":"50.97","marketPrice":"72.90","imageSmall":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103155337138_836.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103155337138_836.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103155337138_836.jpg","hasStock":0,"promotionLabel":" 满2件9折","couponLabel":"满200减12","skuInfoShowDTO":{"skuOptionNameList":null,"skuPriceMap":{"0":{"skuId":27985,"marketPrice":"72.90","sellingPrice":"50.97","imageSmall":"","imageMedium":"","imageBig":"","salesProfit":"0","limitCount":0,"minimumLimitCount":0,"stock":0,"itemStatus":1,"isKeyOrder":0,"giftType":0,"profitDetail":{"totalProfit":"0","levelOneSalesProfit":null,"levelOneDevelopmentProfit":null,"levelTwoSalesProfit":null,"levelThreeSalesProfit":null},"discountPrice":"38.48"}}},"discountedPrice":"45.87"},{"itemId":29197,"itemName":"ISANA伊萨娜 芦荟洋甘菊舒敏脱毛滚珠 120ml","sellingPrice":"58.06","marketPrice":"77.42","imageSmall":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104192503718_765.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104192503718_765.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104192503718_765.jpg","hasStock":1,"promotionLabel":" 满2件9折","couponLabel":"满120减13","skuInfoShowDTO":{"skuOptionNameList":null,"skuPriceMap":{"0":{"skuId":29524,"marketPrice":"77.42","sellingPrice":"58.06","imageSmall":"","imageMedium":"","imageBig":"","salesProfit":"0","limitCount":0,"minimumLimitCount":0,"stock":386,"itemStatus":1,"isKeyOrder":0,"giftType":0,"profitDetail":{"totalProfit":"0","levelOneSalesProfit":null,"levelOneDevelopmentProfit":null,"levelTwoSalesProfit":null,"levelThreeSalesProfit":null},"discountPrice":"43.84"}}},"discountedPrice":"52.25"},{"itemId":28637,"itemName":"AHC 高浓度B5玻尿酸精华液面膜二代 5片","sellingPrice":"161.28","marketPrice":"165.15","imageSmall":"https://yangtaodev-1253852034.cosgz.myqcloud.com/fmal-item-images/20171104/20171104165253715_757.jpg","imageMedium":"https://yangtaodev-1253852034.cosgz.myqcloud.com/fmal-item-images/20171104/20171104165253715_757.jpg","imageBig":"https://yangtaodev-1253852034.cosgz.myqcloud.com/fmal-item-images/20171104/20171104165253715_757.jpg","hasStock":1,"promotionLabel":" 满2件9折","couponLabel":"满120减13","skuInfoShowDTO":{"skuOptionNameList":null,"skuPriceMap":{"0":{"skuId":28919,"marketPrice":"165.15","sellingPrice":"161.28","imageSmall":"","imageMedium":"","imageBig":"","salesProfit":"0","limitCount":1,"minimumLimitCount":1,"stock":386,"itemStatus":1,"isKeyOrder":0,"giftType":0,"profitDetail":{"totalProfit":"0","levelOneSalesProfit":null,"levelOneDevelopmentProfit":null,"levelTwoSalesProfit":null,"levelThreeSalesProfit":null},"discountPrice":"121.77"}}},"discountedPrice":"145.15"},{"itemId":27762,"itemName":"SU:M37°呼吸 焕肤精华洁肤泡沫 245ml","sellingPrice":"116.12","marketPrice":"168.38","imageSmall":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104170931422_835.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104170931422_835.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104170931422_835.jpg","hasStock":1,"promotionLabel":" 满2件9折","couponLabel":"满120减13","skuInfoShowDTO":{"skuOptionNameList":null,"skuPriceMap":{"0":{"skuId":27610,"marketPrice":"168.38","sellingPrice":"116.12","imageSmall":"","imageMedium":"","imageBig":"","salesProfit":"0","limitCount":0,"minimumLimitCount":0,"stock":389,"itemStatus":1,"isKeyOrder":0,"giftType":0,"profitDetail":{"totalProfit":"0","levelOneSalesProfit":null,"levelOneDevelopmentProfit":null,"levelTwoSalesProfit":null,"levelThreeSalesProfit":null},"discountPrice":"87.67"}}},"discountedPrice":"104.51"},{"itemId":757695,"itemName":"【两包装】GOO.N大王 拉拉裤男 XL38(12~20kg)","sellingPrice":"136.69","marketPrice":"192.89","imageSmall":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/3398/3031005840/20180223/20180223165718575_833.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/3398/3031005840/20180223/20180223165718575_833.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/3398/3031005840/20180223/20180223165718575_833.jpg","hasStock":1,"promotionLabel":" 满2件9折","couponLabel":"","skuInfoShowDTO":{"skuOptionNameList":null,"skuPriceMap":{"0":{"skuId":2847208,"marketPrice":"192.89","sellingPrice":"136.69","imageSmall":"","imageMedium":"","imageBig":"","salesProfit":"0","limitCount":0,"minimumLimitCount":0,"stock":388,"itemStatus":1,"isKeyOrder":1,"giftType":0,"profitDetail":{"totalProfit":"0","levelOneSalesProfit":null,"levelOneDevelopmentProfit":null,"levelTwoSalesProfit":null,"levelThreeSalesProfit":null},"discountPrice":"123.02"}}},"discountedPrice":"123.02"},{"itemId":648503,"itemName":"【两包装】KAO花王 纸尿裤 M68","sellingPrice":"170.05","marketPrice":"238.69","imageSmall":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104184802747_715.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104184802747_715.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104184802747_715.jpg","hasStock":0,"promotionLabel":" 满2件9折","couponLabel":"","skuInfoShowDTO":{"skuOptionNameList":null,"skuPriceMap":{"0":{"skuId":2740178,"marketPrice":"238.69","sellingPrice":"170.05","imageSmall":"","imageMedium":"","imageBig":"","salesProfit":"0","limitCount":0,"minimumLimitCount":0,"stock":0,"itemStatus":1,"isKeyOrder":1,"giftType":0,"profitDetail":{"totalProfit":"0","levelOneSalesProfit":null,"levelOneDevelopmentProfit":null,"levelTwoSalesProfit":null,"levelThreeSalesProfit":null},"discountPrice":"153.05"}}},"discountedPrice":"153.05"},{"itemId":639089,"itemName":"【两包装】GOO.N大王 拉拉裤男 L44(9~14kg)","sellingPrice":"142.12","marketPrice":"192.89","imageSmall":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104184841022_443.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104184841022_443.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104184841022_443.jpg","hasStock":0,"promotionLabel":" 满2件9折","couponLabel":"","skuInfoShowDTO":{"skuOptionNameList":null,"skuPriceMap":{"0":{"skuId":2729522,"marketPrice":"192.89","sellingPrice":"142.12","imageSmall":"","imageMedium":"","imageBig":"","salesProfit":"0","limitCount":0,"minimumLimitCount":0,"stock":0,"itemStatus":1,"isKeyOrder":1,"giftType":0,"profitDetail":{"totalProfit":"0","levelOneSalesProfit":null,"levelOneDevelopmentProfit":null,"levelTwoSalesProfit":null,"levelThreeSalesProfit":null},"discountPrice":"127.91"}}},"discountedPrice":"127.91"},{"itemId":332752,"itemName":"Longchamp珑骧 长柄小号折叠包军绿色 28*25*14cm","sellingPrice":"515.44","marketPrice":"736.06","imageSmall":"https://onion-images-dev.yangsupplychain.com//fmal-item-images/20171104/20171104183828650_668.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com//fmal-item-images/20171104/20171104183828650_668.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com//fmal-item-images/20171104/20171104183828650_668.jpg","hasStock":0,"promotionLabel":" 满2件9折","couponLabel":"","skuInfoShowDTO":{"skuOptionNameList":null,"skuPriceMap":{"0":{"skuId":2424573,"marketPrice":"736.06","sellingPrice":"515.44","imageSmall":"","imageMedium":"","imageBig":"","salesProfit":"0","limitCount":0,"minimumLimitCount":0,"stock":0,"itemStatus":1,"isKeyOrder":0,"giftType":0,"profitDetail":{"totalProfit":"0","levelOneSalesProfit":null,"levelOneDevelopmentProfit":null,"levelTwoSalesProfit":null,"levelThreeSalesProfit":null},"discountPrice":"463.90"}}},"discountedPrice":"463.90"},{"itemId":25608,"itemName":"Clarins娇韵诗 瞬间眼部卸妆液30ml+温和清洁乳100ml(混/油)+清新爽肤水100ml(","sellingPrice":"100.64","marketPrice":"143.86","imageSmall":"https://yangtaodev-1253852034.cosgz.myqcloud.com/fmal-item-images/20171104/20171104172356092_920.jpg","imageMedium":"https://yangtaodev-1253852034.cosgz.myqcloud.com/fmal-item-images/20171104/20171104172356092_920.jpg","imageBig":"https://yangtaodev-1253852034.cosgz.myqcloud.com/fmal-item-images/20171104/20171104172356092_920.jpg","hasStock":1,"promotionLabel":" 满2件9折","couponLabel":"满120减13","skuInfoShowDTO":{"skuOptionNameList":null,"skuPriceMap":{"0":{"skuId":25898,"marketPrice":"143.86","sellingPrice":"100.64","imageSmall":"","imageMedium":"","imageBig":"","salesProfit":"0","limitCount":0,"minimumLimitCount":0,"stock":389,"itemStatus":1,"isKeyOrder":0,"giftType":0,"profitDetail":{"totalProfit":"0","levelOneSalesProfit":null,"levelOneDevelopmentProfit":null,"levelTwoSalesProfit":null,"levelThreeSalesProfit":null},"discountPrice":"80.51"}}},"discountedPrice":"90.58"}]
         */

        private boolean isLogin;
        private int totalPages;
        private String levelName;
        private String startTime;
        private String endTime;
        private List<ItemsBean> items;

        public boolean isIsLogin() {
            return isLogin;
        }

        public void setIsLogin(boolean isLogin) {
            this.isLogin = isLogin;
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

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            /**
             * itemId : 27591
             * itemName : Lyajin丽雅珍 润面膜 25ml*5
             * sellingPrice : 64.51
             * marketPrice : 129.02
             * imageSmall : https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104145854353_849.jpg
             * imageMedium : https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104145854353_849.jpg
             * imageBig : https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104145854353_849.jpg
             * hasStock : 1
             * promotionLabel :  满2件9折
             * couponLabel : 满120减13
             * skuInfoShowDTO : {"skuOptionNameList":null,"skuPriceMap":{"0":{"skuId":27400,"marketPrice":"129.02","sellingPrice":"64.51","imageSmall":"","imageMedium":"","imageBig":"","salesProfit":"0","limitCount":0,"minimumLimitCount":0,"stock":389,"itemStatus":1,"isKeyOrder":0,"giftType":0,"profitDetail":{"totalProfit":"0","levelOneSalesProfit":null,"levelOneDevelopmentProfit":null,"levelTwoSalesProfit":null,"levelThreeSalesProfit":null},"discountPrice":"48.71"}}}
             * discountedPrice : 58.06
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
            private SkuInfoShowDTOBean skuInfoShowDTO;
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

            public SkuInfoShowDTOBean getSkuInfoShowDTO() {
                return skuInfoShowDTO;
            }

            public void setSkuInfoShowDTO(SkuInfoShowDTOBean skuInfoShowDTO) {
                this.skuInfoShowDTO = skuInfoShowDTO;
            }

            public String getDiscountedPrice() {
                return discountedPrice;
            }

            public void setDiscountedPrice(String discountedPrice) {
                this.discountedPrice = discountedPrice;
            }

            public static class SkuInfoShowDTOBean {
                /**
                 * skuOptionNameList : null
                 * skuPriceMap : {"0":{"skuId":27400,"marketPrice":"129.02","sellingPrice":"64.51","imageSmall":"","imageMedium":"","imageBig":"","salesProfit":"0","limitCount":0,"minimumLimitCount":0,"stock":389,"itemStatus":1,"isKeyOrder":0,"giftType":0,"profitDetail":{"totalProfit":"0","levelOneSalesProfit":null,"levelOneDevelopmentProfit":null,"levelTwoSalesProfit":null,"levelThreeSalesProfit":null},"discountPrice":"48.71"}}
                 */

                private Object skuOptionNameList;
                private SkuPriceMapBean skuPriceMap;

                public Object getSkuOptionNameList() {
                    return skuOptionNameList;
                }

                public void setSkuOptionNameList(Object skuOptionNameList) {
                    this.skuOptionNameList = skuOptionNameList;
                }

                public SkuPriceMapBean getSkuPriceMap() {
                    return skuPriceMap;
                }

                public void setSkuPriceMap(SkuPriceMapBean skuPriceMap) {
                    this.skuPriceMap = skuPriceMap;
                }

                public static class SkuPriceMapBean {
                    /**
                     * 0 : {"skuId":27400,"marketPrice":"129.02","sellingPrice":"64.51","imageSmall":"","imageMedium":"","imageBig":"","salesProfit":"0","limitCount":0,"minimumLimitCount":0,"stock":389,"itemStatus":1,"isKeyOrder":0,"giftType":0,"profitDetail":{"totalProfit":"0","levelOneSalesProfit":null,"levelOneDevelopmentProfit":null,"levelTwoSalesProfit":null,"levelThreeSalesProfit":null},"discountPrice":"48.71"}
                     */

                    @SerializedName("0")
                    private _$0Bean _$0;

                    public _$0Bean get_$0() {
                        return _$0;
                    }

                    public void set_$0(_$0Bean _$0) {
                        this._$0 = _$0;
                    }

                    public static class _$0Bean {
                        /**
                         * skuId : 27400
                         * marketPrice : 129.02
                         * sellingPrice : 64.51
                         * imageSmall :
                         * imageMedium :
                         * imageBig :
                         * salesProfit : 0
                         * limitCount : 0
                         * minimumLimitCount : 0
                         * stock : 389
                         * itemStatus : 1
                         * isKeyOrder : 0
                         * giftType : 0
                         * profitDetail : {"totalProfit":"0","levelOneSalesProfit":null,"levelOneDevelopmentProfit":null,"levelTwoSalesProfit":null,"levelThreeSalesProfit":null}
                         * discountPrice : 48.71
                         */

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
                        private ProfitDetailBean profitDetail;
                        private String discountPrice;

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

                        public ProfitDetailBean getProfitDetail() {
                            return profitDetail;
                        }

                        public void setProfitDetail(ProfitDetailBean profitDetail) {
                            this.profitDetail = profitDetail;
                        }

                        public String getDiscountPrice() {
                            return discountPrice;
                        }

                        public void setDiscountPrice(String discountPrice) {
                            this.discountPrice = discountPrice;
                        }

                        public static class ProfitDetailBean {
                            /**
                             * totalProfit : 0
                             * levelOneSalesProfit : null
                             * levelOneDevelopmentProfit : null
                             * levelTwoSalesProfit : null
                             * levelThreeSalesProfit : null
                             */

                            private String totalProfit;
                            private Object levelOneSalesProfit;
                            private Object levelOneDevelopmentProfit;
                            private Object levelTwoSalesProfit;
                            private Object levelThreeSalesProfit;

                            public String getTotalProfit() {
                                return totalProfit;
                            }

                            public void setTotalProfit(String totalProfit) {
                                this.totalProfit = totalProfit;
                            }

                            public Object getLevelOneSalesProfit() {
                                return levelOneSalesProfit;
                            }

                            public void setLevelOneSalesProfit(Object levelOneSalesProfit) {
                                this.levelOneSalesProfit = levelOneSalesProfit;
                            }

                            public Object getLevelOneDevelopmentProfit() {
                                return levelOneDevelopmentProfit;
                            }

                            public void setLevelOneDevelopmentProfit(Object levelOneDevelopmentProfit) {
                                this.levelOneDevelopmentProfit = levelOneDevelopmentProfit;
                            }

                            public Object getLevelTwoSalesProfit() {
                                return levelTwoSalesProfit;
                            }

                            public void setLevelTwoSalesProfit(Object levelTwoSalesProfit) {
                                this.levelTwoSalesProfit = levelTwoSalesProfit;
                            }

                            public Object getLevelThreeSalesProfit() {
                                return levelThreeSalesProfit;
                            }

                            public void setLevelThreeSalesProfit(Object levelThreeSalesProfit) {
                                this.levelThreeSalesProfit = levelThreeSalesProfit;
                            }
                        }
                    }
                }
            }
        }
    }
}
