package cc.onion.cosyfans.my.entity;

import android.text.TextUtils;

import java.util.List;

/**
 * 商家订单实体类
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.entity.request
 * @ClassName: OrderListEntity
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2020/1/14 14:16
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/14 14:16
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class OrderListEntity {

    /**
     * status : 200
     * msg : OK
     * data : {"totalPages":1,"orderList":[{"id":"1151101","orderNo":"CTMS2019121100001000403","orderStatusCode":6,"orderStatus":"售后","userId":"28125","userName":"mark","tel":"15767708601","address":"addr1,addr2,Kaki Bukit,510000,Perlis,Malaysia","orderSaleFee":"49.04","orderRealFee":"49.04","orderDiscountFee":"0.00","orderCouponFee":"0.00","weight":"0.000","freight":"5.90","tax":"0.00","shopId":"29046","shopName":"","buyerMessage":"","totalNum":2,"orderClassify":20,"displayItemNum":2,"payTime":"2019-12-11 16:25:07","orderTotalFee":"49.04","isPlaceOrderUser":1,"giftType":0,"payRemainTime":0,"createTime":"2019-12-11 16:23:10","isAfterSalesDisplay":null,"delayedReceipt":0,"isDelayedReceiptDisplay":null,"mallRefundStatus":null,"refundNo":"CTD2019121100001000403C3","refundType":"退货","refundIncomeButton":null,"orderItemList":[{"id":"1205471","orderNo":"CTMS2019121100001000403","itemId":"138558","itemNo":"FW201903013","itemName":"fanwaishangpin-FW20190301","barcode":"FW20190301C","unitPrice":"38.71","buyNum":1,"unit":"","saleFee":"38.71","discountFee":"0.00","realFee":"38.71","sharePost":"0.00","goodsWeight":"0.000","specification":"yanse:baise,jianshu:10jian","tax":"0.00","spuId":"126499","stockOccupyId":"O1020191211162309891605926","image":"https://yangtaodev-1253852034.cosgz.myqcloud.com/collect-item-images/20190301/20190301112655963_599.jpg","itemTotalFee":"38.71","mallRefundStatus":null,"refundNo":null,"refundItemStatus":null,"refundItemStatusCode":null},{"id":"1205258","orderNo":"CTMS2019121100001000403","itemId":"29485","itemNo":"1012022620","itemName":"MontagneJeunesse xiangjiaofengmiliangfudanbanmianmo","barcode":"b083800035960","unitPrice":"10.33","buyNum":1,"unit":"","saleFee":"10.33","discountFee":"0.00","realFee":"10.33","sharePost":"0.00","goodsWeight":"0.000","specification":"","tax":"0.00","spuId":"28987","stockOccupyId":"O1020191211162309880709177","image":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104192536591_265.jpg","itemTotalFee":"10.33","mallRefundStatus":null,"refundNo":null,"refundItemStatus":null,"refundItemStatusCode":null}],"subOrderList":null,"isDiscountOrder":1,"timelinessStr":"5-18 days","orderRefundSubOrderNo":"CTMS2019121100001000403C2","cashCouponFee":"0.00"},{"id":"1151930","orderNo":"CTMS2019121100001000403","orderStatusCode":6,"orderStatus":"售后","userId":"28125","userName":"mark","tel":"15767708601","address":"addr1,addr2,Kaki Bukit,510000,Perlis,Malaysia","orderSaleFee":"49.04","orderRealFee":"49.04","orderDiscountFee":"0.00","orderCouponFee":"0.00","weight":"0.000","freight":"5.90","tax":"0.00","shopId":"29046","shopName":"","buyerMessage":"","totalNum":2,"orderClassify":20,"displayItemNum":2,"payTime":"2019-12-11 16:25:07","orderTotalFee":"49.04","isPlaceOrderUser":1,"giftType":0,"payRemainTime":0,"createTime":"2019-12-11 16:23:10","isAfterSalesDisplay":null,"delayedReceipt":0,"isDelayedReceiptDisplay":null,"mallRefundStatus":null,"refundNo":"CTD2019121100001000403C3","refundType":"退款","refundIncomeButton":null,"orderItemList":[{"id":"1205471","orderNo":"CTMS2019121100001000403","itemId":"138558","itemNo":"FW201903013","itemName":"fanwaishangpin-FW20190301","barcode":"FW20190301C","unitPrice":"38.71","buyNum":1,"unit":"","saleFee":"38.71","discountFee":"0.00","realFee":"38.71","sharePost":"0.00","goodsWeight":"0.000","specification":"yanse:baise,jianshu:10jian","tax":"0.00","spuId":"126499","stockOccupyId":"O1020191211162309891605926","image":"https://yangtaodev-1253852034.cosgz.myqcloud.com/collect-item-images/20190301/20190301112655963_599.jpg","itemTotalFee":"38.71","mallRefundStatus":null,"refundNo":null,"refundItemStatus":null,"refundItemStatusCode":null},{"id":"1205258","orderNo":"CTMS2019121100001000403","itemId":"29485","itemNo":"1012022620","itemName":"MontagneJeunesse xiangjiaofengmiliangfudanbanmianmo","barcode":"b083800035960","unitPrice":"10.33","buyNum":1,"unit":"","saleFee":"10.33","discountFee":"0.00","realFee":"10.33","sharePost":"0.00","goodsWeight":"0.000","specification":"","tax":"0.00","spuId":"28987","stockOccupyId":"O1020191211162309880709177","image":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104192536591_265.jpg","itemTotalFee":"10.33","mallRefundStatus":null,"refundNo":null,"refundItemStatus":null,"refundItemStatusCode":null}],"subOrderList":null,"isDiscountOrder":1,"timelinessStr":"5-18 days","orderRefundSubOrderNo":"CTMS2019121100001000403C2","cashCouponFee":"0.00"},{"id":"1153373","orderNo":"CTMS2019121100001000403","orderStatusCode":6,"orderStatus":"售后","userId":"28125","userName":"mark","tel":"15767708601","address":"addr1,addr2,Kaki Bukit,510000,Perlis,Malaysia","orderSaleFee":"49.04","orderRealFee":"49.04","orderDiscountFee":"0.00","orderCouponFee":"0.00","weight":"0.000","freight":"5.90","tax":"0.00","shopId":"29046","shopName":"","buyerMessage":"","totalNum":2,"orderClassify":20,"displayItemNum":2,"payTime":"2019-12-11 16:25:07","orderTotalFee":"49.04","isPlaceOrderUser":1,"giftType":0,"payRemainTime":0,"createTime":"2019-12-11 16:23:10","isAfterSalesDisplay":null,"delayedReceipt":0,"isDelayedReceiptDisplay":null,"mallRefundStatus":null,"refundNo":"CTD2019121100001000403C3","refundType":"退款","refundIncomeButton":null,"orderItemList":[{"id":"1205471","orderNo":"CTMS2019121100001000403","itemId":"138558","itemNo":"FW201903013","itemName":"fanwaishangpin-FW20190301","barcode":"FW20190301C","unitPrice":"38.71","buyNum":1,"unit":"","saleFee":"38.71","discountFee":"0.00","realFee":"38.71","sharePost":"0.00","goodsWeight":"0.000","specification":"yanse:baise,jianshu:10jian","tax":"0.00","spuId":"126499","stockOccupyId":"O1020191211162309891605926","image":"https://yangtaodev-1253852034.cosgz.myqcloud.com/collect-item-images/20190301/20190301112655963_599.jpg","itemTotalFee":"38.71","mallRefundStatus":null,"refundNo":null,"refundItemStatus":null,"refundItemStatusCode":null},{"id":"1205258","orderNo":"CTMS2019121100001000403","itemId":"29485","itemNo":"1012022620","itemName":"MontagneJeunesse xiangjiaofengmiliangfudanbanmianmo","barcode":"b083800035960","unitPrice":"10.33","buyNum":1,"unit":"","saleFee":"10.33","discountFee":"0.00","realFee":"10.33","sharePost":"0.00","goodsWeight":"0.000","specification":"","tax":"0.00","spuId":"28987","stockOccupyId":"O1020191211162309880709177","image":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104192536591_265.jpg","itemTotalFee":"10.33","mallRefundStatus":null,"refundNo":null,"refundItemStatus":null,"refundItemStatusCode":null}],"subOrderList":null,"isDiscountOrder":1,"timelinessStr":"5-18 days","orderRefundSubOrderNo":"CTMS2019121100001000403C2","cashCouponFee":"0.00"},{"id":"1151821","orderNo":"CTMS2019121300001000280","orderStatusCode":6,"orderStatus":"售后","userId":"28125","userName":"mark","tel":"15767708601","address":"addr1,add2,Kaki Bukit,510000,Perlis,Malaysia","orderSaleFee":"212.90","orderRealFee":"212.90","orderDiscountFee":"0.00","orderCouponFee":"0.00","weight":"0.000","freight":"0.00","tax":"0.00","shopId":"29046","shopName":"","buyerMessage":"","totalNum":2,"orderClassify":20,"displayItemNum":2,"payTime":"2019-12-13 10:52:21","orderTotalFee":"212.90","isPlaceOrderUser":1,"giftType":0,"payRemainTime":0,"createTime":"2019-12-13 10:51:02","isAfterSalesDisplay":null,"delayedReceipt":0,"isDelayedReceiptDisplay":null,"mallRefundStatus":null,"refundNo":"CTD2019121300001000280C2","refundType":"退款","refundIncomeButton":null,"orderItemList":[{"id":"1211935","orderNo":"CTMS2019121300001000280","itemId":"29524","itemNo":"1013029820","itemName":"ISANAyisanuo luhuiyangganjushumintuomaogunzhu 120ml","barcode":"4305615496955","unitPrice":"58.06","buyNum":1,"unit":"","saleFee":"58.06","discountFee":"0.00","realFee":"58.06","sharePost":"0.00","goodsWeight":"0.000","specification":"","tax":"0.00","spuId":"29197","stockOccupyId":"O1020191213105101887230625","image":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104192503718_765.jpg","itemTotalFee":"232.24","mallRefundStatus":null,"refundNo":null,"refundItemStatus":null,"refundItemStatusCode":null},{"id":"1212089","orderNo":"CTMS2019121300001000280","itemId":"138558","itemNo":"FW201903013","itemName":"fanwaishangpin-FW20190301","barcode":"FW20190301C","unitPrice":"38.71","buyNum":4,"unit":"","saleFee":"38.71","discountFee":"0.00","realFee":"38.71","sharePost":"0.00","goodsWeight":"0.000","specification":"yanse:baise,jianshu:10jian","tax":"0.00","spuId":"126499","stockOccupyId":"O1020191213105101896119683","image":"https://yangtaodev-1253852034.cosgz.myqcloud.com/collect-item-images/20190301/20190301112655963_599.jpg","itemTotalFee":"154.84","mallRefundStatus":null,"refundNo":null,"refundItemStatus":null,"refundItemStatusCode":null}],"subOrderList":null,"isDiscountOrder":1,"timelinessStr":"5-18 days","orderRefundSubOrderNo":"CTMS2019121300001000280C2","cashCouponFee":"0.00"},{"id":"1153131","orderNo":"CTMS2019121300001000280","orderStatusCode":6,"orderStatus":"售后","userId":"28125","userName":"mark","tel":"15767708601","address":"addr1,add2,Kaki Bukit,510000,Perlis,Malaysia","orderSaleFee":"212.90","orderRealFee":"212.90","orderDiscountFee":"0.00","orderCouponFee":"0.00","weight":"0.000","freight":"0.00","tax":"0.00","shopId":"29046","shopName":"","buyerMessage":"","totalNum":2,"orderClassify":20,"displayItemNum":2,"payTime":"2019-12-13 10:52:21","orderTotalFee":"212.90","isPlaceOrderUser":1,"giftType":0,"payRemainTime":0,"createTime":"2019-12-13 10:51:02","isAfterSalesDisplay":null,"delayedReceipt":0,"isDelayedReceiptDisplay":null,"mallRefundStatus":null,"refundNo":"CTD2019121300001000280C2","refundType":"退货","refundIncomeButton":null,"orderItemList":[{"id":"1211935","orderNo":"CTMS2019121300001000280","itemId":"29524","itemNo":"1013029820","itemName":"ISANAyisanuo luhuiyangganjushumintuomaogunzhu 120ml","barcode":"4305615496955","unitPrice":"58.06","buyNum":1,"unit":"","saleFee":"58.06","discountFee":"0.00","realFee":"58.06","sharePost":"0.00","goodsWeight":"0.000","specification":"","tax":"0.00","spuId":"29197","stockOccupyId":"O1020191213105101887230625","image":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104192503718_765.jpg","itemTotalFee":"232.24","mallRefundStatus":null,"refundNo":null,"refundItemStatus":null,"refundItemStatusCode":null},{"id":"1212089","orderNo":"CTMS2019121300001000280","itemId":"138558","itemNo":"FW201903013","itemName":"fanwaishangpin-FW20190301","barcode":"FW20190301C","unitPrice":"38.71","buyNum":4,"unit":"","saleFee":"38.71","discountFee":"0.00","realFee":"38.71","sharePost":"0.00","goodsWeight":"0.000","specification":"yanse:baise,jianshu:10jian","tax":"0.00","spuId":"126499","stockOccupyId":"O1020191213105101896119683","image":"https://yangtaodev-1253852034.cosgz.myqcloud.com/collect-item-images/20190301/20190301112655963_599.jpg","itemTotalFee":"154.84","mallRefundStatus":null,"refundNo":null,"refundItemStatus":null,"refundItemStatusCode":null}],"subOrderList":null,"isDiscountOrder":1,"timelinessStr":"5-18 days","orderRefundSubOrderNo":"CTMS2019121300001000280C2","cashCouponFee":"0.00"}]}
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
         * totalPages : 1
         * orderList : [{"id":"1151101","orderNo":"CTMS2019121100001000403","orderStatusCode":6,"orderStatus":"售后","userId":"28125","userName":"mark","tel":"15767708601","address":"addr1,addr2,Kaki Bukit,510000,Perlis,Malaysia","orderSaleFee":"49.04","orderRealFee":"49.04","orderDiscountFee":"0.00","orderCouponFee":"0.00","weight":"0.000","freight":"5.90","tax":"0.00","shopId":"29046","shopName":"","buyerMessage":"","totalNum":2,"orderClassify":20,"displayItemNum":2,"payTime":"2019-12-11 16:25:07","orderTotalFee":"49.04","isPlaceOrderUser":1,"giftType":0,"payRemainTime":0,"createTime":"2019-12-11 16:23:10","isAfterSalesDisplay":null,"delayedReceipt":0,"isDelayedReceiptDisplay":null,"mallRefundStatus":null,"refundNo":"CTD2019121100001000403C3","refundType":"退货","refundIncomeButton":null,"orderItemList":[{"id":"1205471","orderNo":"CTMS2019121100001000403","itemId":"138558","itemNo":"FW201903013","itemName":"fanwaishangpin-FW20190301","barcode":"FW20190301C","unitPrice":"38.71","buyNum":1,"unit":"","saleFee":"38.71","discountFee":"0.00","realFee":"38.71","sharePost":"0.00","goodsWeight":"0.000","specification":"yanse:baise,jianshu:10jian","tax":"0.00","spuId":"126499","stockOccupyId":"O1020191211162309891605926","image":"https://yangtaodev-1253852034.cosgz.myqcloud.com/collect-item-images/20190301/20190301112655963_599.jpg","itemTotalFee":"38.71","mallRefundStatus":null,"refundNo":null,"refundItemStatus":null,"refundItemStatusCode":null},{"id":"1205258","orderNo":"CTMS2019121100001000403","itemId":"29485","itemNo":"1012022620","itemName":"MontagneJeunesse xiangjiaofengmiliangfudanbanmianmo","barcode":"b083800035960","unitPrice":"10.33","buyNum":1,"unit":"","saleFee":"10.33","discountFee":"0.00","realFee":"10.33","sharePost":"0.00","goodsWeight":"0.000","specification":"","tax":"0.00","spuId":"28987","stockOccupyId":"O1020191211162309880709177","image":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104192536591_265.jpg","itemTotalFee":"10.33","mallRefundStatus":null,"refundNo":null,"refundItemStatus":null,"refundItemStatusCode":null}],"subOrderList":null,"isDiscountOrder":1,"timelinessStr":"5-18 days","orderRefundSubOrderNo":"CTMS2019121100001000403C2","cashCouponFee":"0.00"},{"id":"1151930","orderNo":"CTMS2019121100001000403","orderStatusCode":6,"orderStatus":"售后","userId":"28125","userName":"mark","tel":"15767708601","address":"addr1,addr2,Kaki Bukit,510000,Perlis,Malaysia","orderSaleFee":"49.04","orderRealFee":"49.04","orderDiscountFee":"0.00","orderCouponFee":"0.00","weight":"0.000","freight":"5.90","tax":"0.00","shopId":"29046","shopName":"","buyerMessage":"","totalNum":2,"orderClassify":20,"displayItemNum":2,"payTime":"2019-12-11 16:25:07","orderTotalFee":"49.04","isPlaceOrderUser":1,"giftType":0,"payRemainTime":0,"createTime":"2019-12-11 16:23:10","isAfterSalesDisplay":null,"delayedReceipt":0,"isDelayedReceiptDisplay":null,"mallRefundStatus":null,"refundNo":"CTD2019121100001000403C3","refundType":"退款","refundIncomeButton":null,"orderItemList":[{"id":"1205471","orderNo":"CTMS2019121100001000403","itemId":"138558","itemNo":"FW201903013","itemName":"fanwaishangpin-FW20190301","barcode":"FW20190301C","unitPrice":"38.71","buyNum":1,"unit":"","saleFee":"38.71","discountFee":"0.00","realFee":"38.71","sharePost":"0.00","goodsWeight":"0.000","specification":"yanse:baise,jianshu:10jian","tax":"0.00","spuId":"126499","stockOccupyId":"O1020191211162309891605926","image":"https://yangtaodev-1253852034.cosgz.myqcloud.com/collect-item-images/20190301/20190301112655963_599.jpg","itemTotalFee":"38.71","mallRefundStatus":null,"refundNo":null,"refundItemStatus":null,"refundItemStatusCode":null},{"id":"1205258","orderNo":"CTMS2019121100001000403","itemId":"29485","itemNo":"1012022620","itemName":"MontagneJeunesse xiangjiaofengmiliangfudanbanmianmo","barcode":"b083800035960","unitPrice":"10.33","buyNum":1,"unit":"","saleFee":"10.33","discountFee":"0.00","realFee":"10.33","sharePost":"0.00","goodsWeight":"0.000","specification":"","tax":"0.00","spuId":"28987","stockOccupyId":"O1020191211162309880709177","image":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104192536591_265.jpg","itemTotalFee":"10.33","mallRefundStatus":null,"refundNo":null,"refundItemStatus":null,"refundItemStatusCode":null}],"subOrderList":null,"isDiscountOrder":1,"timelinessStr":"5-18 days","orderRefundSubOrderNo":"CTMS2019121100001000403C2","cashCouponFee":"0.00"},{"id":"1153373","orderNo":"CTMS2019121100001000403","orderStatusCode":6,"orderStatus":"售后","userId":"28125","userName":"mark","tel":"15767708601","address":"addr1,addr2,Kaki Bukit,510000,Perlis,Malaysia","orderSaleFee":"49.04","orderRealFee":"49.04","orderDiscountFee":"0.00","orderCouponFee":"0.00","weight":"0.000","freight":"5.90","tax":"0.00","shopId":"29046","shopName":"","buyerMessage":"","totalNum":2,"orderClassify":20,"displayItemNum":2,"payTime":"2019-12-11 16:25:07","orderTotalFee":"49.04","isPlaceOrderUser":1,"giftType":0,"payRemainTime":0,"createTime":"2019-12-11 16:23:10","isAfterSalesDisplay":null,"delayedReceipt":0,"isDelayedReceiptDisplay":null,"mallRefundStatus":null,"refundNo":"CTD2019121100001000403C3","refundType":"退款","refundIncomeButton":null,"orderItemList":[{"id":"1205471","orderNo":"CTMS2019121100001000403","itemId":"138558","itemNo":"FW201903013","itemName":"fanwaishangpin-FW20190301","barcode":"FW20190301C","unitPrice":"38.71","buyNum":1,"unit":"","saleFee":"38.71","discountFee":"0.00","realFee":"38.71","sharePost":"0.00","goodsWeight":"0.000","specification":"yanse:baise,jianshu:10jian","tax":"0.00","spuId":"126499","stockOccupyId":"O1020191211162309891605926","image":"https://yangtaodev-1253852034.cosgz.myqcloud.com/collect-item-images/20190301/20190301112655963_599.jpg","itemTotalFee":"38.71","mallRefundStatus":null,"refundNo":null,"refundItemStatus":null,"refundItemStatusCode":null},{"id":"1205258","orderNo":"CTMS2019121100001000403","itemId":"29485","itemNo":"1012022620","itemName":"MontagneJeunesse xiangjiaofengmiliangfudanbanmianmo","barcode":"b083800035960","unitPrice":"10.33","buyNum":1,"unit":"","saleFee":"10.33","discountFee":"0.00","realFee":"10.33","sharePost":"0.00","goodsWeight":"0.000","specification":"","tax":"0.00","spuId":"28987","stockOccupyId":"O1020191211162309880709177","image":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104192536591_265.jpg","itemTotalFee":"10.33","mallRefundStatus":null,"refundNo":null,"refundItemStatus":null,"refundItemStatusCode":null}],"subOrderList":null,"isDiscountOrder":1,"timelinessStr":"5-18 days","orderRefundSubOrderNo":"CTMS2019121100001000403C2","cashCouponFee":"0.00"},{"id":"1151821","orderNo":"CTMS2019121300001000280","orderStatusCode":6,"orderStatus":"售后","userId":"28125","userName":"mark","tel":"15767708601","address":"addr1,add2,Kaki Bukit,510000,Perlis,Malaysia","orderSaleFee":"212.90","orderRealFee":"212.90","orderDiscountFee":"0.00","orderCouponFee":"0.00","weight":"0.000","freight":"0.00","tax":"0.00","shopId":"29046","shopName":"","buyerMessage":"","totalNum":2,"orderClassify":20,"displayItemNum":2,"payTime":"2019-12-13 10:52:21","orderTotalFee":"212.90","isPlaceOrderUser":1,"giftType":0,"payRemainTime":0,"createTime":"2019-12-13 10:51:02","isAfterSalesDisplay":null,"delayedReceipt":0,"isDelayedReceiptDisplay":null,"mallRefundStatus":null,"refundNo":"CTD2019121300001000280C2","refundType":"退款","refundIncomeButton":null,"orderItemList":[{"id":"1211935","orderNo":"CTMS2019121300001000280","itemId":"29524","itemNo":"1013029820","itemName":"ISANAyisanuo luhuiyangganjushumintuomaogunzhu 120ml","barcode":"4305615496955","unitPrice":"58.06","buyNum":1,"unit":"","saleFee":"58.06","discountFee":"0.00","realFee":"58.06","sharePost":"0.00","goodsWeight":"0.000","specification":"","tax":"0.00","spuId":"29197","stockOccupyId":"O1020191213105101887230625","image":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104192503718_765.jpg","itemTotalFee":"232.24","mallRefundStatus":null,"refundNo":null,"refundItemStatus":null,"refundItemStatusCode":null},{"id":"1212089","orderNo":"CTMS2019121300001000280","itemId":"138558","itemNo":"FW201903013","itemName":"fanwaishangpin-FW20190301","barcode":"FW20190301C","unitPrice":"38.71","buyNum":4,"unit":"","saleFee":"38.71","discountFee":"0.00","realFee":"38.71","sharePost":"0.00","goodsWeight":"0.000","specification":"yanse:baise,jianshu:10jian","tax":"0.00","spuId":"126499","stockOccupyId":"O1020191213105101896119683","image":"https://yangtaodev-1253852034.cosgz.myqcloud.com/collect-item-images/20190301/20190301112655963_599.jpg","itemTotalFee":"154.84","mallRefundStatus":null,"refundNo":null,"refundItemStatus":null,"refundItemStatusCode":null}],"subOrderList":null,"isDiscountOrder":1,"timelinessStr":"5-18 days","orderRefundSubOrderNo":"CTMS2019121300001000280C2","cashCouponFee":"0.00"},{"id":"1153131","orderNo":"CTMS2019121300001000280","orderStatusCode":6,"orderStatus":"售后","userId":"28125","userName":"mark","tel":"15767708601","address":"addr1,add2,Kaki Bukit,510000,Perlis,Malaysia","orderSaleFee":"212.90","orderRealFee":"212.90","orderDiscountFee":"0.00","orderCouponFee":"0.00","weight":"0.000","freight":"0.00","tax":"0.00","shopId":"29046","shopName":"","buyerMessage":"","totalNum":2,"orderClassify":20,"displayItemNum":2,"payTime":"2019-12-13 10:52:21","orderTotalFee":"212.90","isPlaceOrderUser":1,"giftType":0,"payRemainTime":0,"createTime":"2019-12-13 10:51:02","isAfterSalesDisplay":null,"delayedReceipt":0,"isDelayedReceiptDisplay":null,"mallRefundStatus":null,"refundNo":"CTD2019121300001000280C2","refundType":"退货","refundIncomeButton":null,"orderItemList":[{"id":"1211935","orderNo":"CTMS2019121300001000280","itemId":"29524","itemNo":"1013029820","itemName":"ISANAyisanuo luhuiyangganjushumintuomaogunzhu 120ml","barcode":"4305615496955","unitPrice":"58.06","buyNum":1,"unit":"","saleFee":"58.06","discountFee":"0.00","realFee":"58.06","sharePost":"0.00","goodsWeight":"0.000","specification":"","tax":"0.00","spuId":"29197","stockOccupyId":"O1020191213105101887230625","image":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104192503718_765.jpg","itemTotalFee":"232.24","mallRefundStatus":null,"refundNo":null,"refundItemStatus":null,"refundItemStatusCode":null},{"id":"1212089","orderNo":"CTMS2019121300001000280","itemId":"138558","itemNo":"FW201903013","itemName":"fanwaishangpin-FW20190301","barcode":"FW20190301C","unitPrice":"38.71","buyNum":4,"unit":"","saleFee":"38.71","discountFee":"0.00","realFee":"38.71","sharePost":"0.00","goodsWeight":"0.000","specification":"yanse:baise,jianshu:10jian","tax":"0.00","spuId":"126499","stockOccupyId":"O1020191213105101896119683","image":"https://yangtaodev-1253852034.cosgz.myqcloud.com/collect-item-images/20190301/20190301112655963_599.jpg","itemTotalFee":"154.84","mallRefundStatus":null,"refundNo":null,"refundItemStatus":null,"refundItemStatusCode":null}],"subOrderList":null,"isDiscountOrder":1,"timelinessStr":"5-18 days","orderRefundSubOrderNo":"CTMS2019121300001000280C2","cashCouponFee":"0.00"}]
         */

        private int totalPages;
        private List<OrderListBean> orderList;

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public List<OrderListBean> getOrderList() {
            return orderList;
        }

        public void setOrderList(List<OrderListBean> orderList) {
            this.orderList = orderList;
        }

        public static class OrderListBean {
            /**
             * id : 1151101
             * orderNo : CTMS2019121100001000403
             * orderStatusCode : 6
             * orderStatus : 售后
             * userId : 28125
             * userName : mark
             * tel : 15767708601
             * address : addr1,addr2,Kaki Bukit,510000,Perlis,Malaysia
             * orderSaleFee : 49.04
             * orderRealFee : 49.04
             * orderDiscountFee : 0.00
             * orderCouponFee : 0.00
             * weight : 0.000
             * freight : 5.90
             * tax : 0.00
             * shopId : 29046
             * shopName :
             * buyerMessage :
             * totalNum : 2
             * orderClassify : 20
             * displayItemNum : 2
             * payTime : 2019-12-11 16:25:07
             * orderTotalFee : 49.04
             * isPlaceOrderUser : 1
             * giftType : 0
             * payRemainTime : 0
             * createTime : 2019-12-11 16:23:10
             * isAfterSalesDisplay : null
             * delayedReceipt : 0
             * isDelayedReceiptDisplay : null
             * mallRefundStatus : null
             * refundNo : CTD2019121100001000403C3
             * refundType : 退货
             * refundIncomeButton : null
             * orderItemList : [{"id":"1205471","orderNo":"CTMS2019121100001000403","itemId":"138558","itemNo":"FW201903013","itemName":"fanwaishangpin-FW20190301","barcode":"FW20190301C","unitPrice":"38.71","buyNum":1,"unit":"","saleFee":"38.71","discountFee":"0.00","realFee":"38.71","sharePost":"0.00","goodsWeight":"0.000","specification":"yanse:baise,jianshu:10jian","tax":"0.00","spuId":"126499","stockOccupyId":"O1020191211162309891605926","image":"https://yangtaodev-1253852034.cosgz.myqcloud.com/collect-item-images/20190301/20190301112655963_599.jpg","itemTotalFee":"38.71","mallRefundStatus":null,"refundNo":null,"refundItemStatus":null,"refundItemStatusCode":null},{"id":"1205258","orderNo":"CTMS2019121100001000403","itemId":"29485","itemNo":"1012022620","itemName":"MontagneJeunesse xiangjiaofengmiliangfudanbanmianmo","barcode":"b083800035960","unitPrice":"10.33","buyNum":1,"unit":"","saleFee":"10.33","discountFee":"0.00","realFee":"10.33","sharePost":"0.00","goodsWeight":"0.000","specification":"","tax":"0.00","spuId":"28987","stockOccupyId":"O1020191211162309880709177","image":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104192536591_265.jpg","itemTotalFee":"10.33","mallRefundStatus":null,"refundNo":null,"refundItemStatus":null,"refundItemStatusCode":null}]
             * subOrderList : null
             * isDiscountOrder : 1
             * timelinessStr : 5-18 days
             * orderRefundSubOrderNo : CTMS2019121100001000403C2
             * cashCouponFee : 0.00
             */

            private String id;
            private String orderNo;
            private int orderStatusCode;
            private String orderStatus;
            private String userId;
            private String userName;
            private String tel;
            private String address;
            private String orderSaleFee;
            private String orderRealFee;
            private String orderDiscountFee;
            private String orderCouponFee;
            private String weight;
            private String freight;
            private String tax;
            private String shopId;
            private String shopName;
            private String buyerMessage;
            private int totalNum;
            private int orderClassify;
            private int displayItemNum;
            private String payTime;
            private String orderTotalFee;
            private int isPlaceOrderUser;
            private int giftType;
            private int payRemainTime;
            private String createTime;
            private Object isAfterSalesDisplay;
            private int delayedReceipt;
            private Object isDelayedReceiptDisplay;
            private Object mallRefundStatus;
            private String refundNo;
            private String refundType;
            private Object refundIncomeButton;
            private Object subOrderList;
            private int isDiscountOrder;
            private String timelinessStr;
            private String orderRefundSubOrderNo;
            private String cashCouponFee;
            private List<OrderItemListBean> orderItemList;
            private boolean isShowMore;//是否显示更多

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getOrderNo() {
                return TextUtils.isEmpty(orderNo)?"":orderNo;
            }

            public void setOrderNo(String orderNo) {
                this.orderNo = orderNo;
            }

            public int getOrderStatusCode() {
                return orderStatusCode;
            }

            public void setOrderStatusCode(int orderStatusCode) {
                this.orderStatusCode = orderStatusCode;
            }

            public String getOrderStatus() {
                return TextUtils.isEmpty(orderStatus)?"":orderStatus;
            }

            public void setOrderStatus(String orderStatus) {
                this.orderStatus = orderStatus;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getUserName() {
                return TextUtils.isEmpty(userName)?"":userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getTel() {
                return tel;
            }

            public void setTel(String tel) {
                this.tel = tel;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getOrderSaleFee() {
                return orderSaleFee;
            }

            public void setOrderSaleFee(String orderSaleFee) {
                this.orderSaleFee = orderSaleFee;
            }

            public String getOrderRealFee() {
                return orderRealFee;
            }

            public void setOrderRealFee(String orderRealFee) {
                this.orderRealFee = orderRealFee;
            }

            public String getOrderDiscountFee() {
                return orderDiscountFee;
            }

            public void setOrderDiscountFee(String orderDiscountFee) {
                this.orderDiscountFee = orderDiscountFee;
            }

            public String getOrderCouponFee() {
                return orderCouponFee;
            }

            public void setOrderCouponFee(String orderCouponFee) {
                this.orderCouponFee = orderCouponFee;
            }

            public String getWeight() {
                return weight;
            }

            public void setWeight(String weight) {
                this.weight = weight;
            }

            public String getFreight() {
                return freight;
            }

            public void setFreight(String freight) {
                this.freight = freight;
            }

            public String getTax() {
                return tax;
            }

            public void setTax(String tax) {
                this.tax = tax;
            }

            public String getShopId() {
                return shopId;
            }

            public void setShopId(String shopId) {
                this.shopId = shopId;
            }

            public String getShopName() {
                return shopName;
            }

            public void setShopName(String shopName) {
                this.shopName = shopName;
            }

            public String getBuyerMessage() {
                return buyerMessage;
            }

            public void setBuyerMessage(String buyerMessage) {
                this.buyerMessage = buyerMessage;
            }

            public int getTotalNum() {
                return totalNum;
            }

            public void setTotalNum(int totalNum) {
                this.totalNum = totalNum;
            }

            public int getOrderClassify() {
                return orderClassify;
            }

            public void setOrderClassify(int orderClassify) {
                this.orderClassify = orderClassify;
            }

            public int getDisplayItemNum() {
                return displayItemNum;
            }

            public void setDisplayItemNum(int displayItemNum) {
                this.displayItemNum = displayItemNum;
            }

            public String getPayTime() {
                return payTime;
            }

            public void setPayTime(String payTime) {
                this.payTime = payTime;
            }

            public String getOrderTotalFee() {
                return TextUtils.isEmpty(orderTotalFee)?"":orderTotalFee;
            }

            public void setOrderTotalFee(String orderTotalFee) {
                this.orderTotalFee = orderTotalFee;
            }

            public int getIsPlaceOrderUser() {
                return isPlaceOrderUser;
            }

            public void setIsPlaceOrderUser(int isPlaceOrderUser) {
                this.isPlaceOrderUser = isPlaceOrderUser;
            }

            public int getGiftType() {
                return giftType;
            }

            public void setGiftType(int giftType) {
                this.giftType = giftType;
            }

            public int getPayRemainTime() {
                return payRemainTime;
            }

            public void setPayRemainTime(int payRemainTime) {
                this.payRemainTime = payRemainTime;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public Object getIsAfterSalesDisplay() {
                return isAfterSalesDisplay;
            }

            public void setIsAfterSalesDisplay(Object isAfterSalesDisplay) {
                this.isAfterSalesDisplay = isAfterSalesDisplay;
            }

            public int getDelayedReceipt() {
                return delayedReceipt;
            }

            public void setDelayedReceipt(int delayedReceipt) {
                this.delayedReceipt = delayedReceipt;
            }

            public Object getIsDelayedReceiptDisplay() {
                return isDelayedReceiptDisplay;
            }

            public void setIsDelayedReceiptDisplay(Object isDelayedReceiptDisplay) {
                this.isDelayedReceiptDisplay = isDelayedReceiptDisplay;
            }

            public Object getMallRefundStatus() {
                return mallRefundStatus;
            }

            public void setMallRefundStatus(Object mallRefundStatus) {
                this.mallRefundStatus = mallRefundStatus;
            }

            public String getRefundNo() {
                return refundNo;
            }

            public void setRefundNo(String refundNo) {
                this.refundNo = refundNo;
            }

            public String getRefundType() {
                return TextUtils.isEmpty(refundType)?"":refundType;
            }

            public void setRefundType(String refundType) {
                this.refundType = refundType;
            }

            public Object getRefundIncomeButton() {
                return refundIncomeButton;
            }

            public void setRefundIncomeButton(Object refundIncomeButton) {
                this.refundIncomeButton = refundIncomeButton;
            }

            public Object getSubOrderList() {
                return subOrderList;
            }

            public void setSubOrderList(Object subOrderList) {
                this.subOrderList = subOrderList;
            }

            public int getIsDiscountOrder() {
                return isDiscountOrder;
            }

            public void setIsDiscountOrder(int isDiscountOrder) {
                this.isDiscountOrder = isDiscountOrder;
            }

            public String getTimelinessStr() {
                return timelinessStr;
            }

            public void setTimelinessStr(String timelinessStr) {
                this.timelinessStr = timelinessStr;
            }

            public String getOrderRefundSubOrderNo() {
                return orderRefundSubOrderNo;
            }

            public void setOrderRefundSubOrderNo(String orderRefundSubOrderNo) {
                this.orderRefundSubOrderNo = orderRefundSubOrderNo;
            }

            public String getCashCouponFee() {
                return cashCouponFee;
            }

            public void setCashCouponFee(String cashCouponFee) {
                this.cashCouponFee = cashCouponFee;
            }

            public List<OrderItemListBean> getOrderItemList() {
                return orderItemList;
            }

            public void setOrderItemList(List<OrderItemListBean> orderItemList) {
                this.orderItemList = orderItemList;
            }

            public boolean isShowMore() {
                return isShowMore;
            }

            public void setShowMore(boolean showMore) {
                isShowMore = showMore;
            }

            public static class OrderItemListBean {
                /**
                 * id : 1205471
                 * orderNo : CTMS2019121100001000403
                 * itemId : 138558
                 * itemNo : FW201903013
                 * itemName : fanwaishangpin-FW20190301
                 * barcode : FW20190301C
                 * unitPrice : 38.71
                 * buyNum : 1
                 * unit :
                 * saleFee : 38.71
                 * discountFee : 0.00
                 * realFee : 38.71
                 * sharePost : 0.00
                 * goodsWeight : 0.000
                 * specification : yanse:baise,jianshu:10jian
                 * tax : 0.00
                 * spuId : 126499
                 * stockOccupyId : O1020191211162309891605926
                 * image : https://yangtaodev-1253852034.cosgz.myqcloud.com/collect-item-images/20190301/20190301112655963_599.jpg
                 * itemTotalFee : 38.71
                 * mallRefundStatus : null
                 * refundNo : null
                 * refundItemStatus : null
                 * refundItemStatusCode : null
                 */

                private String id;
                private String orderNo;
                private String itemId;
                private String itemNo;
                private String itemName;
                private String barcode;
                private String unitPrice;
                private int buyNum;
                private String unit;
                private String saleFee;
                private String discountFee;
                private String realFee;
                private String sharePost;
                private String goodsWeight;
                private String specification;
                private String tax;
                private String spuId;
                private String stockOccupyId;
                private String image;
                private String itemTotalFee;
                private Object mallRefundStatus;
                private Object refundNo;
                private Object refundItemStatus;
                private Object refundItemStatusCode;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getOrderNo() {
                    return orderNo;
                }

                public void setOrderNo(String orderNo) {
                    this.orderNo = orderNo;
                }

                public String getItemId() {
                    return itemId;
                }

                public void setItemId(String itemId) {
                    this.itemId = itemId;
                }

                public String getItemNo() {
                    return itemNo;
                }

                public void setItemNo(String itemNo) {
                    this.itemNo = itemNo;
                }

                public String getItemName() {
                    return itemName;
                }

                public void setItemName(String itemName) {
                    this.itemName = itemName;
                }

                public String getBarcode() {
                    return barcode;
                }

                public void setBarcode(String barcode) {
                    this.barcode = barcode;
                }

                public String getUnitPrice() {
                    return unitPrice;
                }

                public void setUnitPrice(String unitPrice) {
                    this.unitPrice = unitPrice;
                }

                public int getBuyNum() {
                    return buyNum;
                }

                public void setBuyNum(int buyNum) {
                    this.buyNum = buyNum;
                }

                public String getUnit() {
                    return unit;
                }

                public void setUnit(String unit) {
                    this.unit = unit;
                }

                public String getSaleFee() {
                    return TextUtils.isEmpty(saleFee)?"":saleFee;
                }

                public void setSaleFee(String saleFee) {
                    this.saleFee = saleFee;
                }

                public String getDiscountFee() {
                    return discountFee;
                }

                public void setDiscountFee(String discountFee) {
                    this.discountFee = discountFee;
                }

                public String getRealFee() {
                    return realFee;
                }

                public void setRealFee(String realFee) {
                    this.realFee = realFee;
                }

                public String getSharePost() {
                    return sharePost;
                }

                public void setSharePost(String sharePost) {
                    this.sharePost = sharePost;
                }

                public String getGoodsWeight() {
                    return goodsWeight;
                }

                public void setGoodsWeight(String goodsWeight) {
                    this.goodsWeight = goodsWeight;
                }

                public String getSpecification() {
                    return TextUtils.isEmpty(specification)?"":specification;
                }

                public void setSpecification(String specification) {
                    this.specification = specification;
                }

                public String getTax() {
                    return tax;
                }

                public void setTax(String tax) {
                    this.tax = tax;
                }

                public String getSpuId() {
                    return spuId;
                }

                public void setSpuId(String spuId) {
                    this.spuId = spuId;
                }

                public String getStockOccupyId() {
                    return stockOccupyId;
                }

                public void setStockOccupyId(String stockOccupyId) {
                    this.stockOccupyId = stockOccupyId;
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public String getItemTotalFee() {
                    return itemTotalFee;
                }

                public void setItemTotalFee(String itemTotalFee) {
                    this.itemTotalFee = itemTotalFee;
                }

                public Object getMallRefundStatus() {
                    return mallRefundStatus;
                }

                public void setMallRefundStatus(Object mallRefundStatus) {
                    this.mallRefundStatus = mallRefundStatus;
                }

                public Object getRefundNo() {
                    return refundNo;
                }

                public void setRefundNo(Object refundNo) {
                    this.refundNo = refundNo;
                }

                public Object getRefundItemStatus() {
                    return refundItemStatus;
                }

                public void setRefundItemStatus(Object refundItemStatus) {
                    this.refundItemStatus = refundItemStatus;
                }

                public Object getRefundItemStatusCode() {
                    return refundItemStatusCode;
                }

                public void setRefundItemStatusCode(Object refundItemStatusCode) {
                    this.refundItemStatusCode = refundItemStatusCode;
                }
            }
        }
    }
}
