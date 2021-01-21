package cc.onion.cosyfans.module_order.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.module_order.entity
 * @ClassName: OrderListEntity
 * @Description: 订单列表
 * @Author: guobihai
 * @CreateDate: 2019-12-16 15:54
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-16 15:54
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class OrderListEntity implements Serializable {
    private static final long serialVersionUID = 5871387268348454014L;


    /**
     * status : 200
     * msg :
     * data : [{"id":"1200939","orderNo":"CTMS2019121300001001949","orderStatusCode":5,"orderStatus":"订单关闭","userId":"48441","userName":"test","tel":"15626165038","address":"444,444,Gombak,60,Selangor,Malaysia","orderSaleFee":"225.20","orderRealFee":"203.20","orderDiscountFee":"0.00","orderCouponFee":"0.00","weight":"0.000","freight":"0.00","tax":"0.00","shopId":"1","shopName":"","buyerMessage":"","totalNum":1,"orderClassify":20,"displayItemNum":2,"payTime":"2019-12-13 17:17:06","orderTotalFee":"203.20","isPlaceOrderUser":1,"giftType":0,"payRemainTime":0,"createTime":"2019-12-13 17:17:06","isAfterSalesDisplay":null,"delayedReceipt":0,"isDelayedReceiptDisplay":null,"mallRefundStatus":null,"refundNo":null,"refundType":null,"refundIncomeButton":null,"orderItemList":[{"id":"1222545","orderNo":"CTMS2019121300001001949","itemId":"138370","itemNo":"FW201903012","itemName":"fanwaishangpin-FW20190301","barcode":"FW20190301B","unitPrice":"56.30","buyNum":4,"unit":"","saleFee":"56.30","discountFee":"0.00","realFee":"50.80","sharePost":"0.00","goodsWeight":"0.000","specification":"颜色:黑色,件数:20件","tax":"0.00","spuId":"126499","stockOccupyId":"O1020191213171706786299726","image":"https://yangtaodev-1253852034.cosgz.myqcloud.com/collect-item-images/20190301/20190301112655963_599.jpg","itemTotalFee":"203.20","mallRefundStatus":null,"refundNo":null,"refundItemStatus":null,"refundItemStatusCode":null}],"subOrderList":null,"isDiscountOrder":1,"timelinessStr":"7-18 days","orderRefundSubOrderNo":null,"cashCouponFee":"22.00"},{"id":"1198017","orderNo":"CTMS2019121300001001436","orderStatusCode":5,"orderStatus":"订单关闭","userId":"48441","userName":"test","tel":"15626165038","address":"444,444,Gombak,60,Selangor,Malaysia","orderSaleFee":"356.00","orderRealFee":"334.00","orderDiscountFee":"0.00","orderCouponFee":"0.00","weight":"0.000","freight":"0.00","tax":"0.00","shopId":"1","shopName":"","buyerMessage":"","totalNum":1,"orderClassify":10,"displayItemNum":2,"payTime":"2019-12-13 16:36:51","orderTotalFee":"334.00","isPlaceOrderUser":1,"giftType":0,"payRemainTime":0,"createTime":"2019-12-13 16:36:51","isAfterSalesDisplay":null,"delayedReceipt":0,"isDelayedReceiptDisplay":null,"mallRefundStatus":null,"refundNo":null,"refundType":null,"refundIncomeButton":null,"orderItemList":[{"id":"1219467","orderNo":"CTMS2019121300001001436","itemId":"2307395","itemNo":"4041015720","itemName":"111RYOlv hanguangyaohusunshangxiuhuxifashuihongse 450ml+180ml","barcode":"8809516535035","unitPrice":"89.00","buyNum":4,"unit":"","saleFee":"89.00","discountFee":"0.00","realFee":"83.50","sharePost":"0.00","goodsWeight":"0.000","specification":"","tax":"0.00","spuId":"223057","stockOccupyId":"O1020191213163651466294976","image":"https://onion-images-dev.yangsupplychain.com//fmal-item-images/20171104/20171104172638121_203.jpg","itemTotalFee":"334.00","mallRefundStatus":null,"refundNo":null,"refundItemStatus":null,"refundItemStatusCode":null}],"subOrderList":null,"isDiscountOrder":1,"timelinessStr":"5-18 days","orderRefundSubOrderNo":null,"cashCouponFee":"22.00"},{"id":"1197540","orderNo":"CTMS2019121300001001307","orderStatusCode":5,"orderStatus":"订单关闭","userId":"48441","userName":"test","tel":"15626165038","address":"444,444,Gombak,60,Selangor,Malaysia","orderSaleFee":"56.30","orderRealFee":"56.30","orderDiscountFee":"0.00","orderCouponFee":"0.00","weight":"0.000","freight":"5.90","tax":"0.00","shopId":"1","shopName":"","buyerMessage":"","totalNum":1,"orderClassify":20,"displayItemNum":2,"payTime":"2019-12-13 15:35:11","orderTotalFee":"62.20","isPlaceOrderUser":1,"giftType":0,"payRemainTime":0,"createTime":"2019-12-13 15:35:11","isAfterSalesDisplay":null,"delayedReceipt":0,"isDelayedReceiptDisplay":null,"mallRefundStatus":null,"refundNo":null,"refundType":null,"refundIncomeButton":null,"orderItemList":[{"id":"1219192","orderNo":"CTMS2019121300001001307","itemId":"138130","itemNo":"FW201903011","itemName":"fanwaishangpin-FW20190301","barcode":"FW20190301A","unitPrice":"56.30","buyNum":1,"unit":"","saleFee":"56.30","discountFee":"0.00","realFee":"56.30","sharePost":"0.00","goodsWeight":"0.000","specification":"颜色:黑色,件数:10件","tax":"0.00","spuId":"126499","stockOccupyId":"O1020191213153510794118563","image":"https://yangtaodev-1253852034.cosgz.myqcloud.com/collect-item-images/20190301/20190301112655963_599.jpg","itemTotalFee":"56.30","mallRefundStatus":null,"refundNo":null,"refundItemStatus":null,"refundItemStatusCode":null}],"subOrderList":null,"isDiscountOrder":1,"timelinessStr":"7-18 days","orderRefundSubOrderNo":null,"cashCouponFee":"0.00"},{"id":"1197431","orderNo":"CTMS2019121300001001266","orderStatusCode":5,"orderStatus":"订单关闭","userId":"48441","userName":"test","tel":"15626165038","address":"444,444,Gombak,60,Selangor,Malaysia","orderSaleFee":"145.28","orderRealFee":"135.28","orderDiscountFee":"0.00","orderCouponFee":"0.00","weight":"0.000","freight":"0.00","tax":"0.00","shopId":"1","shopName":"","buyerMessage":"","totalNum":1,"orderClassify":20,"displayItemNum":2,"payTime":"2019-12-13 15:17:48","orderTotalFee":"135.28","isPlaceOrderUser":1,"giftType":0,"payRemainTime":0,"createTime":"2019-12-13 15:17:48","isAfterSalesDisplay":null,"delayedReceipt":0,"isDelayedReceiptDisplay":null,"mallRefundStatus":null,"refundNo":null,"refundType":null,"refundIncomeButton":null,"orderItemList":[{"id":"1218958","orderNo":"CTMS2019121300001001266","itemId":"138130","itemNo":"FW201903011","itemName":"fanwaishangpin-FW20190301","barcode":"FW20190301A","unitPrice":"36.32","buyNum":4,"unit":"","saleFee":"36.32","discountFee":"0.00","realFee":"33.82","sharePost":"0.00","goodsWeight":"0.000","specification":"yanse:heise,jianshu:10jian","tax":"0.00","spuId":"126499","stockOccupyId":"O1020191213151748633399686","image":"https://yangtaodev-1253852034.cosgz.myqcloud.com/collect-item-images/20190301/20190301112655963_599.jpg","itemTotalFee":"135.28","mallRefundStatus":null,"refundNo":null,"refundItemStatus":null,"refundItemStatusCode":null}],"subOrderList":null,"isDiscountOrder":1,"timelinessStr":"7-18 days","orderRefundSubOrderNo":null,"cashCouponFee":"10.00"},{"id":"1196990","orderNo":"CTMS2019121300001001206","orderStatusCode":5,"orderStatus":"订单关闭","userId":"48441","userName":"test","tel":"15626165038","address":"444,444,Gombak,60,Selangor,Malaysia","orderSaleFee":"989.85","orderRealFee":"949.72","orderDiscountFee":"6.13","orderCouponFee":"12.00","weight":"0.000","freight":"0.00","tax":"0.00","shopId":"1","shopName":"","buyerMessage":"","totalNum":3,"orderClassify":20,"displayItemNum":2,"payTime":"2019-12-13 15:14:44","orderTotalFee":"949.72","isPlaceOrderUser":1,"giftType":0,"payRemainTime":0,"createTime":"2019-12-13 15:14:44","isAfterSalesDisplay":null,"delayedReceipt":0,"isDelayedReceiptDisplay":null,"mallRefundStatus":null,"refundNo":null,"refundType":null,"refundIncomeButton":null,"orderItemList":[],"subOrderList":null,"isDiscountOrder":1,"timelinessStr":"","orderRefundSubOrderNo":null,"cashCouponFee":"0.00"},{"id":"1197266","orderNo":"CTMS2019121300001001251","orderStatusCode":5,"orderStatus":"订单关闭","userId":"48441","userName":"test","tel":"15626165038","address":"444,444,Gombak,60,Selangor,Malaysia","orderSaleFee":"989.85","orderRealFee":"989.85","orderDiscountFee":"0.00","orderCouponFee":"0.00","weight":"0.000","freight":"0.00","tax":"0.00","shopId":"1","shopName":"","buyerMessage":"","totalNum":3,"orderClassify":20,"displayItemNum":2,"payTime":"2019-12-13 15:15:22","orderTotalFee":"989.85","isPlaceOrderUser":1,"giftType":0,"payRemainTime":0,"createTime":"2019-12-13 15:15:22","isAfterSalesDisplay":null,"delayedReceipt":0,"isDelayedReceiptDisplay":null,"mallRefundStatus":null,"refundNo":null,"refundType":null,"refundIncomeButton":null,"orderItemList":[],"subOrderList":null,"isDiscountOrder":1,"timelinessStr":"","orderRefundSubOrderNo":null,"cashCouponFee":"0.00"},{"id":"1194883","orderNo":"CTMS2019121300001000878","orderStatusCode":5,"orderStatus":"订单关闭","userId":"48441","userName":"test","tel":"15626165038","address":"444,444,Gombak,60,Selangor,Malaysia","orderSaleFee":"828.22","orderRealFee":"806.22","orderDiscountFee":"0.00","orderCouponFee":"0.00","weight":"0.000","freight":"0.00","tax":"0.00","shopId":"1","shopName":"","buyerMessage":"","totalNum":3,"orderClassify":20,"displayItemNum":2,"payTime":"2019-12-13 14:13:34","orderTotalFee":"806.22","isPlaceOrderUser":1,"giftType":0,"payRemainTime":0,"createTime":"2019-12-13 14:13:34","isAfterSalesDisplay":null,"delayedReceipt":0,"isDelayedReceiptDisplay":null,"mallRefundStatus":null,"refundNo":null,"refundType":null,"refundIncomeButton":null,"orderItemList":[{"id":"1215357","orderNo":"CTMS2019121300001000878","itemId":"2316753","itemNo":"1011034820","itemName":"SU:M37°huxi sweet smilerunfuru 250ml","barcode":"8801051985900","unitPrice":"131.80","buyNum":6,"unit":"","saleFee":"131.80","discountFee":"0.00","realFee":"128.30","sharePost":"0.00","goodsWeight":"0.000","specification":"","tax":"0.00","spuId":"226162","stockOccupyId":"O1020191213141334393768020","image":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104170925086_398.jpg","itemTotalFee":"769.80","mallRefundStatus":null,"refundNo":null,"refundItemStatus":null,"refundItemStatusCode":null},{"id":"1215732","orderNo":"CTMS2019121300001000878","itemId":"3312277","itemNo":"FW-OBM-20190910012","itemName":"fanwai-yishijieqianchou pianpiantongnianweifengmishanzhatiao 130g/bao","barcode":"FW-OBM-2019091001B","unitPrice":"9.03","buyNum":3,"unit":"","saleFee":"9.03","discountFee":"0.00","realFee":"8.80","sharePost":"0.00","goodsWeight":"0.000","specification":"rongliang:240g","tax":"0.00","spuId":"1892207","stockOccupyId":"O1020191213141334402555255","image":"https://onion-images-dev.yangsupplychain.com/collect-item-images/20190910/20190910103541101_806.png","itemTotalFee":"26.40","mallRefundStatus":null,"refundNo":null,"refundItemStatus":null,"refundItemStatusCode":null},{"id":"1215624","orderNo":"CTMS2019121300001000878","itemId":"29485","itemNo":"1012022620","itemName":"MontagneJeunesse xiangjiaofengmiliangfudanbanmianmo","barcode":"b083800035960","unitPrice":"10.33","buyNum":1,"unit":"","saleFee":"10.33","discountFee":"0.00","realFee":"10.02","sharePost":"0.00","goodsWeight":"0.000","specification":"","tax":"0.00","spuId":"28987","stockOccupyId":"O1020191213141334410522984","image":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104192536591_265.jpg","itemTotalFee":"10.02","mallRefundStatus":null,"refundNo":null,"refundItemStatus":null,"refundItemStatusCode":null}],"subOrderList":null,"isDiscountOrder":1,"timelinessStr":"5-18 days","orderRefundSubOrderNo":null,"cashCouponFee":"22.00"},{"id":"1194559","orderNo":"CTMS2019121300001000864","orderStatusCode":5,"orderStatus":"订单关闭","userId":"48441","userName":"test","tel":"15626165038","address":"444,444,Gombak,60,Selangor,Malaysia","orderSaleFee":"356.00","orderRealFee":"334.00","orderDiscountFee":"0.00","orderCouponFee":"0.00","weight":"0.000","freight":"0.00","tax":"0.00","shopId":"1","shopName":"","buyerMessage":"","totalNum":1,"orderClassify":10,"displayItemNum":2,"payTime":"2019-12-13 13:59:55","orderTotalFee":"334.00","isPlaceOrderUser":1,"giftType":0,"payRemainTime":0,"createTime":"2019-12-13 13:59:55","isAfterSalesDisplay":null,"delayedReceipt":0,"isDelayedReceiptDisplay":null,"mallRefundStatus":null,"refundNo":null,"refundType":null,"refundIncomeButton":null,"orderItemList":[{"id":"1215082","orderNo":"CTMS2019121300001000864","itemId":"2307395","itemNo":"4041015720","itemName":"111RYOlv hanguangyaohusunshangxiuhuxifashuihongse 450ml+180ml","barcode":"8809516535035","unitPrice":"89.00","buyNum":4,"unit":"","saleFee":"89.00","discountFee":"0.00","realFee":"83.50","sharePost":"0.00","goodsWeight":"0.000","specification":"","tax":"0.00","spuId":"223057","stockOccupyId":"O1020191213135955435615939","image":"https://onion-images-dev.yangsupplychain.com//fmal-item-images/20171104/20171104172638121_203.jpg","itemTotalFee":"334.00","mallRefundStatus":null,"refundNo":null,"refundItemStatus":null,"refundItemStatusCode":null}],"subOrderList":null,"isDiscountOrder":1,"timelinessStr":"5-18 days","orderRefundSubOrderNo":null,"cashCouponFee":"22.00"},{"id":"1194377","orderNo":"CTMS2019121300001000830","orderStatusCode":5,"orderStatus":"订单关闭","userId":"48441","userName":"test","tel":"15626165038","address":"444,444,Gombak,60,Selangor,Malaysia","orderSaleFee":"614.00","orderRealFee":"532.00","orderDiscountFee":"60.00","orderCouponFee":"0.00","weight":"0.000","freight":"0.00","tax":"0.00","shopId":"1","shopName":"","buyerMessage":"","totalNum":2,"orderClassify":10,"displayItemNum":2,"payTime":"2019-12-13 13:53:05","orderTotalFee":"532.00","isPlaceOrderUser":1,"giftType":0,"payRemainTime":0,"createTime":"2019-12-13 13:53:05","isAfterSalesDisplay":null,"delayedReceipt":0,"isDelayedReceiptDisplay":null,"mallRefundStatus":null,"refundNo":null,"refundType":null,"refundIncomeButton":null,"orderItemList":[{"id":"1214798","orderNo":"CTMS2019121300001000830","itemId":"23763","itemNo":"1012030840","itemName":"【tehuizhuang】Nonkumaxiaoxionghongwaixianfareyantie 2dui","barcode":"2017061200108","unitPrice":"300.00","buyNum":2,"unit":"","saleFee":"300.00","discountFee":"30.00","realFee":"259.26","sharePost":"0.00","goodsWeight":"0.000","specification":"","tax":"0.00","spuId":"24198","stockOccupyId":"O1020191213135304720230235","image":"https://yangtaodev-1253852034.cosgz.myqcloud.com/fmal-item-images/20171104/20171104204745165_401.jpg","itemTotalFee":"518.52","mallRefundStatus":null,"refundNo":null,"refundItemStatus":null,"refundItemStatusCode":null},{"id":"1214636","orderNo":"CTMS2019121300001000830","itemId":"3312167","itemNo":"FW-OBM-20190910011","itemName":"fanwai-yishijieqianchou pianpiantongnianweifengmishanzhatiao 130g/bao","barcode":"FW-OBM-2019091001A","unitPrice":"14.00","buyNum":1,"unit":"","saleFee":"14.00","discountFee":"0.00","realFee":"13.48","sharePost":"0.00","goodsWeight":"0.000","specification":"容量:120g","tax":"0.00","spuId":"1892207","stockOccupyId":"O1020191213135304731252483","image":"https://onion-images-dev.yangsupplychain.com/collect-item-images/20190910/20190910103541101_806.png","itemTotalFee":"13.48","mallRefundStatus":null,"refundNo":null,"refundItemStatus":null,"refundItemStatusCode":null}],"subOrderList":null,"isDiscountOrder":1,"timelinessStr":"5-18 days","orderRefundSubOrderNo":null,"cashCouponFee":"22.00"},{"id":"1187781","orderNo":"CTMS2019121200001000332","orderStatusCode":5,"orderStatus":"订单关闭","userId":"48441","userName":"test","tel":"15626165038","address":"444,444,Gombak,60,Selangor,Malaysia","orderSaleFee":"530.92","orderRealFee":"508.92","orderDiscountFee":"0.00","orderCouponFee":"0.00","weight":"0.000","freight":"0.00","tax":"0.00","shopId":"1","shopName":"","buyerMessage":"","totalNum":2,"orderClassify":20,"displayItemNum":2,"payTime":"2019-12-12 17:08:53","orderTotalFee":"508.92","isPlaceOrderUser":1,"giftType":0,"payRemainTime":0,"createTime":"2019-12-12 17:08:53","isAfterSalesDisplay":null,"delayedReceipt":0,"isDelayedReceiptDisplay":null,"mallRefundStatus":null,"refundNo":null,"refundType":null,"refundIncomeButton":null,"orderItemList":[{"id":"1208588","orderNo":"CTMS2019121200001000332","itemId":"138130","itemNo":"FW201903011","itemName":"fanwaishangpin-FW20190301","barcode":"FW20190301A","unitPrice":"56.30","buyNum":1,"unit":"","saleFee":"56.30","discountFee":"0.00","realFee":"53.97","sharePost":"0.00","goodsWeight":"0.000","specification":"颜色:黑色,件数:10件","tax":"0.00","spuId":"126499","stockOccupyId":"O1020191212170852992324165","image":"https://yangtaodev-1253852034.cosgz.myqcloud.com/collect-item-images/20190301/20190301112655963_599.jpg","itemTotalFee":"53.97","mallRefundStatus":null,"refundNo":null,"refundItemStatus":null,"refundItemStatusCode":null},{"id":"1208217","orderNo":"CTMS2019121200001000332","itemId":"139292","itemNo":"396405801","itemName":"Beats Powerbeats 3 Wireless Bluetooth In-ear Earphones Noise Cancelling with MIC","barcode":"EHAITUT7V","unitPrice":"474.62","buyNum":1,"unit":"","saleFee":"474.62","discountFee":"0.00","realFee":"454.95","sharePost":"0.00","goodsWeight":"0.000","specification":"Color:BLACK","tax":"0.00","spuId":"127079","stockOccupyId":"O1020191212170852983437014","image":"https://glodimg.chinabrands.cn/pdm-product-pic/Distribution/2019/01/02/source-img/20190102164603_54404.jpg","itemTotalFee":"454.95","mallRefundStatus":null,"refundNo":null,"refundItemStatus":null,"refundItemStatusCode":null}],"subOrderList":null,"isDiscountOrder":1,"timelinessStr":"7-18 days","orderRefundSubOrderNo":null,"cashCouponFee":"22.00"}]
     * pageNum : 1
     * totalPages : 2
     * pageSize : 10
     * totalCounts : 14
     * hasNextPage : true
     * hasPrePage : false
     * nextPage : 2
     * prePage : 1
     * startTime : null
     * endTime : null
     * firstPage : true
     * lastPage : false
     */

    private int status;
    private String msg;
    private int pageNum;
    private int totalPages;
    private int pageSize;
    private int totalCounts;
    private boolean hasNextPage;
    private boolean hasPrePage;
    private int nextPage;
    private int prePage;
    private Object startTime;
    private Object endTime;
    private boolean firstPage;
    private boolean lastPage;
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

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCounts() {
        return totalCounts;
    }

    public void setTotalCounts(int totalCounts) {
        this.totalCounts = totalCounts;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public boolean isHasPrePage() {
        return hasPrePage;
    }

    public void setHasPrePage(boolean hasPrePage) {
        this.hasPrePage = hasPrePage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getPrePage() {
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public Object getStartTime() {
        return startTime;
    }

    public void setStartTime(Object startTime) {
        this.startTime = startTime;
    }

    public Object getEndTime() {
        return endTime;
    }

    public void setEndTime(Object endTime) {
        this.endTime = endTime;
    }

    public boolean isFirstPage() {
        return firstPage;
    }

    public void setFirstPage(boolean firstPage) {
        this.firstPage = firstPage;
    }

    public boolean isLastPage() {
        return lastPage;
    }

    public void setLastPage(boolean lastPage) {
        this.lastPage = lastPage;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1200939
         * orderNo : CTMS2019121300001001949
         * orderStatusCode : 5
         * orderStatus : 订单关闭
         * userId : 48441
         * userName : test
         * tel : 15626165038
         * address : 444,444,Gombak,60,Selangor,Malaysia
         * orderSaleFee : 225.20
         * orderRealFee : 203.20
         * orderDiscountFee : 0.00
         * orderCouponFee : 0.00
         * weight : 0.000
         * freight : 0.00
         * tax : 0.00
         * shopId : 1
         * shopName :
         * buyerMessage :
         * totalNum : 1
         * orderClassify : 20
         * displayItemNum : 2
         * payTime : 2019-12-13 17:17:06
         * orderTotalFee : 203.20
         * isPlaceOrderUser : 1
         * giftType : 0
         * payRemainTime : 0
         * createTime : 2019-12-13 17:17:06
         * isAfterSalesDisplay : null
         * delayedReceipt : 0
         * isDelayedReceiptDisplay : null
         * mallRefundStatus : null
         * refundNo : null
         * refundType : null
         * refundIncomeButton : null
         * orderItemList : [{"id":"1222545","orderNo":"CTMS2019121300001001949","itemId":"138370","itemNo":"FW201903012","itemName":"fanwaishangpin-FW20190301","barcode":"FW20190301B","unitPrice":"56.30","buyNum":4,"unit":"","saleFee":"56.30","discountFee":"0.00","realFee":"50.80","sharePost":"0.00","goodsWeight":"0.000","specification":"颜色:黑色,件数:20件","tax":"0.00","spuId":"126499","stockOccupyId":"O1020191213171706786299726","image":"https://yangtaodev-1253852034.cosgz.myqcloud.com/collect-item-images/20190301/20190301112655963_599.jpg","itemTotalFee":"203.20","mallRefundStatus":null,"refundNo":null,"refundItemStatus":null,"refundItemStatusCode":null}]
         * subOrderList : null
         * isDiscountOrder : 1
         * timelinessStr : 7-18 days
         * orderRefundSubOrderNo : null
         * cashCouponFee : 22.00
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
        private Object refundNo;
        private Object refundType;
        private Object refundIncomeButton;
        private Object subOrderList;
        private int isDiscountOrder;
        private String timelinessStr;
        private Object orderRefundSubOrderNo;
        private String cashCouponFee;
        private List<OrderItemListBean> orderItemList;

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

        public int getOrderStatusCode() {
            return orderStatusCode;
        }

        public void setOrderStatusCode(int orderStatusCode) {
            this.orderStatusCode = orderStatusCode;
        }

        public String getOrderStatus() {
            return orderStatus;
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
            return userName;
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
            return orderTotalFee;
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

        public Object getRefundNo() {
            return refundNo;
        }

        public void setRefundNo(Object refundNo) {
            this.refundNo = refundNo;
        }

        public Object getRefundType() {
            return refundType;
        }

        public void setRefundType(Object refundType) {
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

        public Object getOrderRefundSubOrderNo() {
            return orderRefundSubOrderNo;
        }

        public void setOrderRefundSubOrderNo(Object orderRefundSubOrderNo) {
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

        public static class OrderItemListBean {
            /**
             * id : 1222545
             * orderNo : CTMS2019121300001001949
             * itemId : 138370
             * itemNo : FW201903012
             * itemName : fanwaishangpin-FW20190301
             * barcode : FW20190301B
             * unitPrice : 56.30
             * buyNum : 4
             * unit :
             * saleFee : 56.30
             * discountFee : 0.00
             * realFee : 50.80
             * sharePost : 0.00
             * goodsWeight : 0.000
             * specification : 颜色:黑色,件数:20件
             * tax : 0.00
             * spuId : 126499
             * stockOccupyId : O1020191213171706786299726
             * image : https://yangtaodev-1253852034.cosgz.myqcloud.com/collect-item-images/20190301/20190301112655963_599.jpg
             * itemTotalFee : 203.20
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
                return saleFee;
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
                return specification;
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
