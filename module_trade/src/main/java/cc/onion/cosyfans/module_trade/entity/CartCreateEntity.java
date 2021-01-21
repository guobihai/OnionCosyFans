package cc.onion.cosyfans.module_trade.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.module_trade.entity
 * @ClassName: CartCreateEntity
 * @Description: 创建订单
 * @Author: guobihai
 * @CreateDate: 2019-12-11 17:53
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-11 17:53
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class CartCreateEntity implements Serializable {
    private static final long serialVersionUID = -902054001951431548L;


    /**
     * status : 200
     * msg : OK
     * data : {"addressId":32601,"consignee":"test","tel":"15626165038","address":"444,444,Gombak,60,Selangor,Malaysia","commodityAmount":"56.30","freight":"5.90","totalAmount":"62.20","totalDiscountPrice":"0.00","totalVoucherPrice":"0.00","feeConfig":"99.00","itemDetails":[{"skuId":138130,"itemName":"贩外商品-FW20190301","itemPrice":"56.30","amount":1,"itemSpecification":"颜色:黑色,件数:10件","itemLogoUrl":"https://yangtaodev-1253852034.cosgz.myqcloud.com/collect-item-images/20190301/20190301112655963_599.jpg","discountPrice":0,"voucherPrice":0,"itemId":126499,"promotionId":0,"couponId":0,"userCouponId":0}],"userCouponIdList":[],"cashCouponId":null,"overlayItemPrice":"{}","cashPrice":null}
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
         * addressId : 32601
         * consignee : test
         * tel : 15626165038
         * address : 444,444,Gombak,60,Selangor,Malaysia
         * commodityAmount : 56.30
         * freight : 5.90
         * totalAmount : 62.20
         * totalDiscountPrice : 0.00
         * totalVoucherPrice : 0.00
         * feeConfig : 99.00
         * itemDetails : [{"skuId":138130,"itemName":"贩外商品-FW20190301","itemPrice":"56.30","amount":1,"itemSpecification":"颜色:黑色,件数:10件","itemLogoUrl":"https://yangtaodev-1253852034.cosgz.myqcloud.com/collect-item-images/20190301/20190301112655963_599.jpg","discountPrice":0,"voucherPrice":0,"itemId":126499,"promotionId":0,"couponId":0,"userCouponId":0}]
         * userCouponIdList : []
         * cashCouponId : null
         * overlayItemPrice : {}
         * cashPrice : null
         */

        private int addressId;
        private String consignee;
        private String tel;
        private String address;
        private String commodityAmount;
        private String freight;
        private String totalAmount;
        private String totalDiscountPrice;
        private String totalVoucherPrice;
        private String feeConfig;
        private String cashCouponId;
        private String overlayItemPrice;
        private String cashPrice;
        private List<ItemDetailsBean> itemDetails;
        private List<?> userCouponIdList;

        public int getAddressId() {
            return addressId;
        }

        public void setAddressId(int addressId) {
            this.addressId = addressId;
        }

        public String getConsignee() {
            return consignee;
        }

        public void setConsignee(String consignee) {
            this.consignee = consignee;
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

        public String getCommodityAmount() {
            return commodityAmount;
        }

        public void setCommodityAmount(String commodityAmount) {
            this.commodityAmount = commodityAmount;
        }

        public String getFreight() {
            return freight;
        }

        public void setFreight(String freight) {
            this.freight = freight;
        }

        public String getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(String totalAmount) {
            this.totalAmount = totalAmount;
        }

        public String getTotalDiscountPrice() {
            return totalDiscountPrice;
        }

        public void setTotalDiscountPrice(String totalDiscountPrice) {
            this.totalDiscountPrice = totalDiscountPrice;
        }

        public String getTotalVoucherPrice() {
            return totalVoucherPrice;
        }

        public void setTotalVoucherPrice(String totalVoucherPrice) {
            this.totalVoucherPrice = totalVoucherPrice;
        }

        public String getFeeConfig() {
            return feeConfig;
        }

        public void setFeeConfig(String feeConfig) {
            this.feeConfig = feeConfig;
        }

        public String getCashCouponId() {
            return cashCouponId;
        }

        public void setCashCouponId(String cashCouponId) {
            this.cashCouponId = cashCouponId;
        }

        public String getOverlayItemPrice() {
            return overlayItemPrice;
        }

        public void setOverlayItemPrice(String overlayItemPrice) {
            this.overlayItemPrice = overlayItemPrice;
        }

        public String getCashPrice() {
            return cashPrice;
        }

        public void setCashPrice(String cashPrice) {
            this.cashPrice = cashPrice;
        }

        public List<ItemDetailsBean> getItemDetails() {
            return itemDetails;
        }

        public void setItemDetails(List<ItemDetailsBean> itemDetails) {
            this.itemDetails = itemDetails;
        }

        public List<?> getUserCouponIdList() {
            return userCouponIdList;
        }

        public void setUserCouponIdList(List<?> userCouponIdList) {
            this.userCouponIdList = userCouponIdList;
        }

        public static class ItemDetailsBean {
            /**
             * skuId : 138130
             * itemName : 贩外商品-FW20190301
             * itemPrice : 56.30
             * amount : 1
             * itemSpecification : 颜色:黑色,件数:10件
             * itemLogoUrl : https://yangtaodev-1253852034.cosgz.myqcloud.com/collect-item-images/20190301/20190301112655963_599.jpg
             * discountPrice : 0
             * voucherPrice : 0
             * itemId : 126499
             * promotionId : 0
             * couponId : 0
             * userCouponId : 0
             */

            private int skuId;
            private String itemName;
            private double itemPrice;
            private int amount;
            private String itemSpecification;
            private String itemLogoUrl;
            private int discountPrice;
            private int voucherPrice;
            private int itemId;
            private int promotionId;
            private int couponId;
            private int userCouponId;

            public int getSkuId() {
                return skuId;
            }

            public void setSkuId(int skuId) {
                this.skuId = skuId;
            }

            public String getItemName() {
                return itemName;
            }

            public void setItemName(String itemName) {
                this.itemName = itemName;
            }

            public double getItemPrice() {
                return itemPrice;
            }

            public void setItemPrice(double itemPrice) {
                this.itemPrice = itemPrice;
            }

            public int getAmount() {
                return amount;
            }

            public void setAmount(int amount) {
                this.amount = amount;
            }

            public String getItemSpecification() {
                return itemSpecification;
            }

            public void setItemSpecification(String itemSpecification) {
                this.itemSpecification = itemSpecification;
            }

            public String getItemLogoUrl() {
                return itemLogoUrl;
            }

            public void setItemLogoUrl(String itemLogoUrl) {
                this.itemLogoUrl = itemLogoUrl;
            }

            public int getDiscountPrice() {
                return discountPrice;
            }

            public void setDiscountPrice(int discountPrice) {
                this.discountPrice = discountPrice;
            }

            public int getVoucherPrice() {
                return voucherPrice;
            }

            public void setVoucherPrice(int voucherPrice) {
                this.voucherPrice = voucherPrice;
            }

            public int getItemId() {
                return itemId;
            }

            public void setItemId(int itemId) {
                this.itemId = itemId;
            }

            public int getPromotionId() {
                return promotionId;
            }

            public void setPromotionId(int promotionId) {
                this.promotionId = promotionId;
            }

            public int getCouponId() {
                return couponId;
            }

            public void setCouponId(int couponId) {
                this.couponId = couponId;
            }

            public int getUserCouponId() {
                return userCouponId;
            }

            public void setUserCouponId(int userCouponId) {
                this.userCouponId = userCouponId;
            }
        }
    }
}
