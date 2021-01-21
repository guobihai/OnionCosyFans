package cc.onion.cosyfans.my.entity.request;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.entity.request
 * @ClassName: OrderDetailEntity
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2019-12-13 18:00
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-13 18:00
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class OrderDetailEntity implements Serializable {
    private static final long serialVersionUID = 7216570275420410196L;

    /**
     * status : 200
     * msg : OK
     * data : {"id":"1197540","orderNo":"CTMS2019121300001001307","orderStatusCode":1,"orderStatus":"待支付","userId":"48441","userName":"test","tel":"15626165038","address":"444,444,Gombak,60,Selangor,Malaysia","orderSaleFee":"56.30","orderRealFee":"56.30","orderDiscountFee":"0.00","orderCouponFee":"0.00","weight":"0.000","freight":"5.90","tax":"0.00","shopId":"1","shopName":"","buyerMessage":"","totalNum":1,"orderClassify":20,"displayItemNum":2,"payTime":"2019-12-13 15:35:11","orderTotalFee":"62.20","isPlaceOrderUser":1,"giftType":0,"payRemainTime":0,"createTime":"2019-12-13 15:35:11","isAfterSalesDisplay":0,"delayedReceipt":0,"isDelayedReceiptDisplay":0,"mallRefundStatus":null,"refundNo":null,"refundType":null,"refundIncomeButton":null,"orderItemList":[{"id":"1219192","orderNo":"CTMS2019121300001001307","itemId":"138130","itemNo":"FW201903011","itemName":"fanwaishangpin-FW20190301","barcode":"FW20190301A","unitPrice":"56.30","buyNum":1,"unit":"","saleFee":"56.30","discountFee":"0.00","realFee":"56.30","sharePost":"0.00","goodsWeight":"0.000","specification":"颜色:黑色,件数:10件","tax":"0.00","spuId":"126499","stockOccupyId":"O1020191213153510794118563","image":"https://yangtaodev-1253852034.cosgz.myqcloud.com/collect-item-images/20190301/20190301112655963_599.jpg","itemTotalFee":"56.30","mallRefundStatus":null,"refundNo":null,"refundItemStatus":null,"refundItemStatusCode":null}],"subOrderList":[{"id":"1201360","orderNo":"CTMS2019121300001001307C1","orderStatusCode":1,"orderStatus":"待支付","userId":"48441","userName":"test","tel":"15626165038","address":"444,444,Gombak,60,Selangor,Malaysia","orderSaleFee":"56.30","orderRealFee":"56.30","orderDiscountFee":"0.00","orderCouponFee":"0.00","weight":"0.000","freight":"5.90","tax":"0.00","shopId":"1","shopName":"","buyerMessage":"","totalNum":0,"orderClassify":20,"displayItemNum":2,"payTime":"2019-12-13 15:35:11","orderTotalFee":"62.20","isPlaceOrderUser":1,"giftType":0,"payRemainTime":0,"createTime":"2019-12-13 15:35:11","logisticsTime":"","logisticsNo":"","isAfterSalesDisplay":0,"isConfirmDisplay":0,"orderItemList":[{"id":"1219192","orderNo":"CTMS2019121300001001307","itemId":"138130","itemNo":"FW201903011","itemName":"fanwaishangpin-FW20190301","barcode":"FW20190301A","unitPrice":"56.30","buyNum":1,"unit":"","saleFee":"56.30","discountFee":"0.00","realFee":"56.30","sharePost":"0.00","goodsWeight":"0.000","specification":"颜色:黑色,件数:10件","tax":"0.00","spuId":"126499","stockOccupyId":"O1020191213153510794118563","image":"https://yangtaodev-1253852034.cosgz.myqcloud.com/collect-item-images/20190301/20190301112655963_599.jpg","itemTotalFee":"56.30","mallRefundStatus":null,"refundNo":null,"refundItemStatus":"","refundItemStatusCode":0}]}],"isDiscountOrder":1,"timelinessStr":"7-18 days","orderRefundSubOrderNo":null,"cashCouponFee":"0.00"}
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
         * id : 1197540
         * orderNo : CTMS2019121300001001307
         * orderStatusCode : 1
         * orderStatus : 待支付
         * userId : 48441
         * userName : test
         * tel : 15626165038
         * address : 444,444,Gombak,60,Selangor,Malaysia
         * orderSaleFee : 56.30
         * orderRealFee : 56.30
         * orderDiscountFee : 0.00
         * orderCouponFee : 0.00
         * weight : 0.000
         * freight : 5.90
         * tax : 0.00
         * shopId : 1
         * shopName :
         * buyerMessage :
         * totalNum : 1
         * orderClassify : 20
         * displayItemNum : 2
         * payTime : 2019-12-13 15:35:11
         * orderTotalFee : 62.20
         * isPlaceOrderUser : 1
         * giftType : 0
         * payRemainTime : 0
         * createTime : 2019-12-13 15:35:11
         * isAfterSalesDisplay : 0
         * delayedReceipt : 0
         * isDelayedReceiptDisplay : 0
         * mallRefundStatus : null
         * refundNo : null
         * refundType : null
         * refundIncomeButton : null
         * orderItemList : [{"id":"1219192","orderNo":"CTMS2019121300001001307","itemId":"138130","itemNo":"FW201903011","itemName":"fanwaishangpin-FW20190301","barcode":"FW20190301A","unitPrice":"56.30","buyNum":1,"unit":"","saleFee":"56.30","discountFee":"0.00","realFee":"56.30","sharePost":"0.00","goodsWeight":"0.000","specification":"颜色:黑色,件数:10件","tax":"0.00","spuId":"126499","stockOccupyId":"O1020191213153510794118563","image":"https://yangtaodev-1253852034.cosgz.myqcloud.com/collect-item-images/20190301/20190301112655963_599.jpg","itemTotalFee":"56.30","mallRefundStatus":null,"refundNo":null,"refundItemStatus":null,"refundItemStatusCode":null}]
         * subOrderList : [{"id":"1201360","orderNo":"CTMS2019121300001001307C1","orderStatusCode":1,"orderStatus":"待支付","userId":"48441","userName":"test","tel":"15626165038","address":"444,444,Gombak,60,Selangor,Malaysia","orderSaleFee":"56.30","orderRealFee":"56.30","orderDiscountFee":"0.00","orderCouponFee":"0.00","weight":"0.000","freight":"5.90","tax":"0.00","shopId":"1","shopName":"","buyerMessage":"","totalNum":0,"orderClassify":20,"displayItemNum":2,"payTime":"2019-12-13 15:35:11","orderTotalFee":"62.20","isPlaceOrderUser":1,"giftType":0,"payRemainTime":0,"createTime":"2019-12-13 15:35:11","logisticsTime":"","logisticsNo":"","isAfterSalesDisplay":0,"isConfirmDisplay":0,"orderItemList":[{"id":"1219192","orderNo":"CTMS2019121300001001307","itemId":"138130","itemNo":"FW201903011","itemName":"fanwaishangpin-FW20190301","barcode":"FW20190301A","unitPrice":"56.30","buyNum":1,"unit":"","saleFee":"56.30","discountFee":"0.00","realFee":"56.30","sharePost":"0.00","goodsWeight":"0.000","specification":"颜色:黑色,件数:10件","tax":"0.00","spuId":"126499","stockOccupyId":"O1020191213153510794118563","image":"https://yangtaodev-1253852034.cosgz.myqcloud.com/collect-item-images/20190301/20190301112655963_599.jpg","itemTotalFee":"56.30","mallRefundStatus":null,"refundNo":null,"refundItemStatus":"","refundItemStatusCode":0}]}]
         * isDiscountOrder : 1
         * timelinessStr : 7-18 days
         * orderRefundSubOrderNo : null
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
        private int isAfterSalesDisplay;
        private int delayedReceipt;
        private int isDelayedReceiptDisplay;
        private Object mallRefundStatus;
        private Object refundNo;
        private Object refundType;
        private Object refundIncomeButton;
        private int isDiscountOrder;
        private String timelinessStr;
        private Object orderRefundSubOrderNo;
        private String cashCouponFee;
        private List<OrderItemListBean> orderItemList;
        private List<SubOrderListBean> subOrderList;

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

        public int getIsAfterSalesDisplay() {
            return isAfterSalesDisplay;
        }

        public void setIsAfterSalesDisplay(int isAfterSalesDisplay) {
            this.isAfterSalesDisplay = isAfterSalesDisplay;
        }

        public int getDelayedReceipt() {
            return delayedReceipt;
        }

        public void setDelayedReceipt(int delayedReceipt) {
            this.delayedReceipt = delayedReceipt;
        }

        public int getIsDelayedReceiptDisplay() {
            return isDelayedReceiptDisplay;
        }

        public void setIsDelayedReceiptDisplay(int isDelayedReceiptDisplay) {
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

        public List<SubOrderListBean> getSubOrderList() {
            return subOrderList;
        }

        public void setSubOrderList(List<SubOrderListBean> subOrderList) {
            this.subOrderList = subOrderList;
        }

        public static class OrderItemListBean {
            /**
             * id : 1219192
             * orderNo : CTMS2019121300001001307
             * itemId : 138130
             * itemNo : FW201903011
             * itemName : fanwaishangpin-FW20190301
             * barcode : FW20190301A
             * unitPrice : 56.30
             * buyNum : 1
             * unit :
             * saleFee : 56.30
             * discountFee : 0.00
             * realFee : 56.30
             * sharePost : 0.00
             * goodsWeight : 0.000
             * specification : 颜色:黑色,件数:10件
             * tax : 0.00
             * spuId : 126499
             * stockOccupyId : O1020191213153510794118563
             * image : https://yangtaodev-1253852034.cosgz.myqcloud.com/collect-item-images/20190301/20190301112655963_599.jpg
             * itemTotalFee : 56.30
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

        public static class SubOrderListBean {
            /**
             * id : 1201360
             * orderNo : CTMS2019121300001001307C1
             * orderStatusCode : 1
             * orderStatus : 待支付
             * userId : 48441
             * userName : test
             * tel : 15626165038
             * address : 444,444,Gombak,60,Selangor,Malaysia
             * orderSaleFee : 56.30
             * orderRealFee : 56.30
             * orderDiscountFee : 0.00
             * orderCouponFee : 0.00
             * weight : 0.000
             * freight : 5.90
             * tax : 0.00
             * shopId : 1
             * shopName :
             * buyerMessage :
             * totalNum : 0
             * orderClassify : 20
             * displayItemNum : 2
             * payTime : 2019-12-13 15:35:11
             * orderTotalFee : 62.20
             * isPlaceOrderUser : 1
             * giftType : 0
             * payRemainTime : 0
             * createTime : 2019-12-13 15:35:11
             * logisticsTime :
             * logisticsNo :
             * isAfterSalesDisplay : 0
             * isConfirmDisplay : 0
             * orderItemList : [{"id":"1219192","orderNo":"CTMS2019121300001001307","itemId":"138130","itemNo":"FW201903011","itemName":"fanwaishangpin-FW20190301","barcode":"FW20190301A","unitPrice":"56.30","buyNum":1,"unit":"","saleFee":"56.30","discountFee":"0.00","realFee":"56.30","sharePost":"0.00","goodsWeight":"0.000","specification":"颜色:黑色,件数:10件","tax":"0.00","spuId":"126499","stockOccupyId":"O1020191213153510794118563","image":"https://yangtaodev-1253852034.cosgz.myqcloud.com/collect-item-images/20190301/20190301112655963_599.jpg","itemTotalFee":"56.30","mallRefundStatus":null,"refundNo":null,"refundItemStatus":"","refundItemStatusCode":0}]
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
            private String logisticsTime;
            private String logisticsNo;
            private int isAfterSalesDisplay;
            private int isConfirmDisplay;
            private List<OrderItemListBeanX> orderItemList;

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

            public String getLogisticsTime() {
                return logisticsTime;
            }

            public void setLogisticsTime(String logisticsTime) {
                this.logisticsTime = logisticsTime;
            }

            public String getLogisticsNo() {
                return logisticsNo;
            }

            public void setLogisticsNo(String logisticsNo) {
                this.logisticsNo = logisticsNo;
            }

            public int getIsAfterSalesDisplay() {
                return isAfterSalesDisplay;
            }

            public void setIsAfterSalesDisplay(int isAfterSalesDisplay) {
                this.isAfterSalesDisplay = isAfterSalesDisplay;
            }

            public int getIsConfirmDisplay() {
                return isConfirmDisplay;
            }

            public void setIsConfirmDisplay(int isConfirmDisplay) {
                this.isConfirmDisplay = isConfirmDisplay;
            }

            public List<OrderItemListBeanX> getOrderItemList() {
                return orderItemList;
            }

            public void setOrderItemList(List<OrderItemListBeanX> orderItemList) {
                this.orderItemList = orderItemList;
            }

            public static class OrderItemListBeanX {
                /**
                 * id : 1219192
                 * orderNo : CTMS2019121300001001307
                 * itemId : 138130
                 * itemNo : FW201903011
                 * itemName : fanwaishangpin-FW20190301
                 * barcode : FW20190301A
                 * unitPrice : 56.30
                 * buyNum : 1
                 * unit :
                 * saleFee : 56.30
                 * discountFee : 0.00
                 * realFee : 56.30
                 * sharePost : 0.00
                 * goodsWeight : 0.000
                 * specification : 颜色:黑色,件数:10件
                 * tax : 0.00
                 * spuId : 126499
                 * stockOccupyId : O1020191213153510794118563
                 * image : https://yangtaodev-1253852034.cosgz.myqcloud.com/collect-item-images/20190301/20190301112655963_599.jpg
                 * itemTotalFee : 56.30
                 * mallRefundStatus : null
                 * refundNo : null
                 * refundItemStatus :
                 * refundItemStatusCode : 0
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
                private String refundItemStatus;
                private int refundItemStatusCode;

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

                public String getRefundItemStatus() {
                    return refundItemStatus;
                }

                public void setRefundItemStatus(String refundItemStatus) {
                    this.refundItemStatus = refundItemStatus;
                }

                public int getRefundItemStatusCode() {
                    return refundItemStatusCode;
                }

                public void setRefundItemStatusCode(int refundItemStatusCode) {
                    this.refundItemStatusCode = refundItemStatusCode;
                }
            }
        }
    }
}
