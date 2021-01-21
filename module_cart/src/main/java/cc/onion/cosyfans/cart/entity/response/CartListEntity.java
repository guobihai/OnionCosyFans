package cc.onion.cosyfans.cart.entity.response;

import java.io.Serializable;
import java.util.List;

/**
 * 购物车列表数据
 * @author guobihai
 * @date 2019 --11-25
 */
public class CartListEntity implements Serializable {
    private static final long serialVersionUID = 7758237413428271660L;

    /**
     * status : 200
     * msg : OK
     * data : {"cartDetailList":[{"activityChoice":"1:24160","updateTime":1575533147000,"promotionDetailDTO":{"promotionId":24160,"promotionStatus":2,"promotionType":1,"topLabel":"满1件9.5折","bottomLabel":"满1件9.5折, 满2件9折","promotionLevelDTOList":[{"activityLabel":"满1件9.5折","promotionId":24160,"discountCount":1,"discountRate":"0.95"},{"activityLabel":" 满2件9折","promotionId":24160,"discountCount":2,"discountRate":"0.9"}]},"couponDetailDTO":null,"cartItemDetailDTOList":[{"cartId":135186,"amount":2,"itemId":29197,"skuId":29524,"itemLogoUrl":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104192503718_765.jpg","itemName":"ISANA伊萨娜 芦荟洋甘菊舒敏脱毛滚珠 120ml","skuPrice":"90.00","itemSpecification":"","itemStatus":1,"itemType":10,"limitCount":0,"minimumLimitCount":0,"stock":376,"switchActivityLabelDTOList":[{"activityId":22726,"activityType":1,"switchLabel":"满2件9折, 满5件7.55折"},{"activityId":24160,"activityType":1,"switchLabel":"满1件9.5折, 满2件9折"},{"activityId":20422,"activityType":2,"switchLabel":"满100减5,满200减12"},{"activityId":20729,"activityType":2,"switchLabel":"满100减10"},{"activityId":20952,"activityType":2,"switchLabel":"满120减13"}],"isShowVoucherTab":1},{"cartId":134995,"amount":3,"itemId":27591,"skuId":27400,"itemLogoUrl":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104145854353_849.jpg","itemName":"Lyajin丽雅珍 润面膜 25ml*5","skuPrice":"100.00","itemSpecification":"","itemStatus":1,"itemType":10,"limitCount":0,"minimumLimitCount":0,"stock":383,"switchActivityLabelDTOList":[{"activityId":22726,"activityType":1,"switchLabel":"满2件9折, 满5件7.55折"},{"activityId":24160,"activityType":1,"switchLabel":"满1件9.5折, 满2件9折"},{"activityId":20422,"activityType":2,"switchLabel":"满100减5,满200减12"},{"activityId":20729,"activityType":2,"switchLabel":"满100减10"},{"activityId":20952,"activityType":2,"switchLabel":"满120减13"}],"isShowVoucherTab":1}]},{"activityChoice":"","updateTime":1575533111000,"promotionDetailDTO":null,"couponDetailDTO":null,"cartItemDetailDTOList":[{"cartId":131686,"amount":3,"itemId":1892207,"skuId":3312277,"itemLogoUrl":"https://onion-images-dev.yangsupplychain.com/collect-item-images/20190910/20190910103541101_806.png","itemName":"fanwai-壹食解千愁 片片童年味蜂蜜山楂条 130g/包","skuPrice":"14.00","itemSpecification":"容量:240g","itemStatus":1,"itemType":20,"limitCount":0,"minimumLimitCount":0,"stock":100,"switchActivityLabelDTOList":[],"isShowVoucherTab":0},{"cartId":131765,"amount":2,"itemId":1892207,"skuId":3312167,"itemLogoUrl":"https://onion-images-dev.yangsupplychain.com/collect-item-images/20190910/20190910103541101_806.png","itemName":"fanwai-壹食解千愁 片片童年味蜂蜜山楂条 130g/包","skuPrice":"14.00","itemSpecification":"容量:120g","itemStatus":1,"itemType":20,"limitCount":0,"minimumLimitCount":0,"stock":100,"switchActivityLabelDTOList":[],"isShowVoucherTab":0}]}],"totalPages":1}
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
         * cartDetailList : [{"activityChoice":"1:24160","updateTime":1575533147000,"promotionDetailDTO":{"promotionId":24160,"promotionStatus":2,"promotionType":1,"topLabel":"满1件9.5折","bottomLabel":"满1件9.5折, 满2件9折","promotionLevelDTOList":[{"activityLabel":"满1件9.5折","promotionId":24160,"discountCount":1,"discountRate":"0.95"},{"activityLabel":" 满2件9折","promotionId":24160,"discountCount":2,"discountRate":"0.9"}]},"couponDetailDTO":null,"cartItemDetailDTOList":[{"cartId":135186,"amount":2,"itemId":29197,"skuId":29524,"itemLogoUrl":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104192503718_765.jpg","itemName":"ISANA伊萨娜 芦荟洋甘菊舒敏脱毛滚珠 120ml","skuPrice":"90.00","itemSpecification":"","itemStatus":1,"itemType":10,"limitCount":0,"minimumLimitCount":0,"stock":376,"switchActivityLabelDTOList":[{"activityId":22726,"activityType":1,"switchLabel":"满2件9折, 满5件7.55折"},{"activityId":24160,"activityType":1,"switchLabel":"满1件9.5折, 满2件9折"},{"activityId":20422,"activityType":2,"switchLabel":"满100减5,满200减12"},{"activityId":20729,"activityType":2,"switchLabel":"满100减10"},{"activityId":20952,"activityType":2,"switchLabel":"满120减13"}],"isShowVoucherTab":1},{"cartId":134995,"amount":3,"itemId":27591,"skuId":27400,"itemLogoUrl":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104145854353_849.jpg","itemName":"Lyajin丽雅珍 润面膜 25ml*5","skuPrice":"100.00","itemSpecification":"","itemStatus":1,"itemType":10,"limitCount":0,"minimumLimitCount":0,"stock":383,"switchActivityLabelDTOList":[{"activityId":22726,"activityType":1,"switchLabel":"满2件9折, 满5件7.55折"},{"activityId":24160,"activityType":1,"switchLabel":"满1件9.5折, 满2件9折"},{"activityId":20422,"activityType":2,"switchLabel":"满100减5,满200减12"},{"activityId":20729,"activityType":2,"switchLabel":"满100减10"},{"activityId":20952,"activityType":2,"switchLabel":"满120减13"}],"isShowVoucherTab":1}]},{"activityChoice":"","updateTime":1575533111000,"promotionDetailDTO":null,"couponDetailDTO":null,"cartItemDetailDTOList":[{"cartId":131686,"amount":3,"itemId":1892207,"skuId":3312277,"itemLogoUrl":"https://onion-images-dev.yangsupplychain.com/collect-item-images/20190910/20190910103541101_806.png","itemName":"fanwai-壹食解千愁 片片童年味蜂蜜山楂条 130g/包","skuPrice":"14.00","itemSpecification":"容量:240g","itemStatus":1,"itemType":20,"limitCount":0,"minimumLimitCount":0,"stock":100,"switchActivityLabelDTOList":[],"isShowVoucherTab":0},{"cartId":131765,"amount":2,"itemId":1892207,"skuId":3312167,"itemLogoUrl":"https://onion-images-dev.yangsupplychain.com/collect-item-images/20190910/20190910103541101_806.png","itemName":"fanwai-壹食解千愁 片片童年味蜂蜜山楂条 130g/包","skuPrice":"14.00","itemSpecification":"容量:120g","itemStatus":1,"itemType":20,"limitCount":0,"minimumLimitCount":0,"stock":100,"switchActivityLabelDTOList":[],"isShowVoucherTab":0}]}]
         * totalPages : 1
         */

        private int totalPages;
        private List<CartDetailListBean> cartDetailList;

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public List<CartDetailListBean> getCartDetailList() {
            return cartDetailList;
        }

        public void setCartDetailList(List<CartDetailListBean> cartDetailList) {
            this.cartDetailList = cartDetailList;
        }

        public static class CartDetailListBean {
            /**
             * activityChoice : 1:24160
             * updateTime : 1575533147000
             * promotionDetailDTO : {"promotionId":24160,"promotionStatus":2,"promotionType":1,"topLabel":"满1件9.5折","bottomLabel":"满1件9.5折, 满2件9折","promotionLevelDTOList":[{"activityLabel":"满1件9.5折","promotionId":24160,"discountCount":1,"discountRate":"0.95"},{"activityLabel":" 满2件9折","promotionId":24160,"discountCount":2,"discountRate":"0.9"}]}
             * couponDetailDTO : null
             * cartItemDetailDTOList : [{"cartId":135186,"amount":2,"itemId":29197,"skuId":29524,"itemLogoUrl":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104192503718_765.jpg","itemName":"ISANA伊萨娜 芦荟洋甘菊舒敏脱毛滚珠 120ml","skuPrice":"90.00","itemSpecification":"","itemStatus":1,"itemType":10,"limitCount":0,"minimumLimitCount":0,"stock":376,"switchActivityLabelDTOList":[{"activityId":22726,"activityType":1,"switchLabel":"满2件9折, 满5件7.55折"},{"activityId":24160,"activityType":1,"switchLabel":"满1件9.5折, 满2件9折"},{"activityId":20422,"activityType":2,"switchLabel":"满100减5,满200减12"},{"activityId":20729,"activityType":2,"switchLabel":"满100减10"},{"activityId":20952,"activityType":2,"switchLabel":"满120减13"}],"isShowVoucherTab":1},{"cartId":134995,"amount":3,"itemId":27591,"skuId":27400,"itemLogoUrl":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104145854353_849.jpg","itemName":"Lyajin丽雅珍 润面膜 25ml*5","skuPrice":"100.00","itemSpecification":"","itemStatus":1,"itemType":10,"limitCount":0,"minimumLimitCount":0,"stock":383,"switchActivityLabelDTOList":[{"activityId":22726,"activityType":1,"switchLabel":"满2件9折, 满5件7.55折"},{"activityId":24160,"activityType":1,"switchLabel":"满1件9.5折, 满2件9折"},{"activityId":20422,"activityType":2,"switchLabel":"满100减5,满200减12"},{"activityId":20729,"activityType":2,"switchLabel":"满100减10"},{"activityId":20952,"activityType":2,"switchLabel":"满120减13"}],"isShowVoucherTab":1}]
             */

            private String activityChoice;
            private long updateTime;
            private PromotionDetailDTOBean promotionDetailDTO;
            private Object couponDetailDTO;
            private List<CartItemDetailDTOListBean> cartItemDetailDTOList;
            private boolean isGroupCheck =false;


            public boolean isGroupCheck() {
                return isGroupCheck;
            }

            public void setGroupCheck(boolean groupCheck) {
                isGroupCheck = groupCheck;
            }

            public String getActivityChoice() {
                return activityChoice;
            }

            public void setActivityChoice(String activityChoice) {
                this.activityChoice = activityChoice;
            }

            public long getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(long updateTime) {
                this.updateTime = updateTime;
            }

            public PromotionDetailDTOBean getPromotionDetailDTO() {
                return promotionDetailDTO;
            }

            public void setPromotionDetailDTO(PromotionDetailDTOBean promotionDetailDTO) {
                this.promotionDetailDTO = promotionDetailDTO;
            }

            public Object getCouponDetailDTO() {
                return couponDetailDTO;
            }

            public void setCouponDetailDTO(Object couponDetailDTO) {
                this.couponDetailDTO = couponDetailDTO;
            }

            public List<CartItemDetailDTOListBean> getCartItemDetailDTOList() {
                return cartItemDetailDTOList;
            }

            public void setCartItemDetailDTOList(List<CartItemDetailDTOListBean> cartItemDetailDTOList) {
                this.cartItemDetailDTOList = cartItemDetailDTOList;
            }

            public static class PromotionDetailDTOBean {
                /**
                 * promotionId : 24160
                 * promotionStatus : 2
                 * promotionType : 1
                 * topLabel : 满1件9.5折
                 * bottomLabel : 满1件9.5折, 满2件9折
                 * promotionLevelDTOList : [{"activityLabel":"满1件9.5折","promotionId":24160,"discountCount":1,"discountRate":"0.95"},{"activityLabel":" 满2件9折","promotionId":24160,"discountCount":2,"discountRate":"0.9"}]
                 */

                private int promotionId;
                private int promotionStatus;
                private int promotionType;
                private String topLabel;
                private String bottomLabel;
                private List<PromotionLevelDTOListBean> promotionLevelDTOList;

                public int getPromotionId() {
                    return promotionId;
                }

                public void setPromotionId(int promotionId) {
                    this.promotionId = promotionId;
                }

                public int getPromotionStatus() {
                    return promotionStatus;
                }

                public void setPromotionStatus(int promotionStatus) {
                    this.promotionStatus = promotionStatus;
                }

                public int getPromotionType() {
                    return promotionType;
                }

                public void setPromotionType(int promotionType) {
                    this.promotionType = promotionType;
                }

                public String getTopLabel() {
                    return topLabel;
                }

                public void setTopLabel(String topLabel) {
                    this.topLabel = topLabel;
                }

                public String getBottomLabel() {
                    return bottomLabel;
                }

                public void setBottomLabel(String bottomLabel) {
                    this.bottomLabel = bottomLabel;
                }

                public List<PromotionLevelDTOListBean> getPromotionLevelDTOList() {
                    return promotionLevelDTOList;
                }

                public void setPromotionLevelDTOList(List<PromotionLevelDTOListBean> promotionLevelDTOList) {
                    this.promotionLevelDTOList = promotionLevelDTOList;
                }

                public static class PromotionLevelDTOListBean {
                    /**
                     * activityLabel : 满1件9.5折
                     * promotionId : 24160
                     * discountCount : 1
                     * discountRate : 0.95
                     */

                    private String activityLabel;
                    private int promotionId;
                    private int discountCount;
                    private String discountRate;

                    public String getActivityLabel() {
                        return activityLabel;
                    }

                    public void setActivityLabel(String activityLabel) {
                        this.activityLabel = activityLabel;
                    }

                    public int getPromotionId() {
                        return promotionId;
                    }

                    public void setPromotionId(int promotionId) {
                        this.promotionId = promotionId;
                    }

                    public int getDiscountCount() {
                        return discountCount;
                    }

                    public void setDiscountCount(int discountCount) {
                        this.discountCount = discountCount;
                    }

                    public String getDiscountRate() {
                        return discountRate;
                    }

                    public void setDiscountRate(String discountRate) {
                        this.discountRate = discountRate;
                    }
                }
            }

            public static class CartItemDetailDTOListBean {
                /**
                 * cartId : 135186
                 * amount : 2
                 * itemId : 29197
                 * skuId : 29524
                 * itemLogoUrl : https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104192503718_765.jpg
                 * itemName : ISANA伊萨娜 芦荟洋甘菊舒敏脱毛滚珠 120ml
                 * skuPrice : 90.00
                 * itemSpecification :
                 * itemStatus : 1
                 * itemType : 10
                 * limitCount : 0
                 * minimumLimitCount : 0
                 * stock : 376
                 * switchActivityLabelDTOList : [{"activityId":22726,"activityType":1,"switchLabel":"满2件9折, 满5件7.55折"},{"activityId":24160,"activityType":1,"switchLabel":"满1件9.5折, 满2件9折"},{"activityId":20422,"activityType":2,"switchLabel":"满100减5,满200减12"},{"activityId":20729,"activityType":2,"switchLabel":"满100减10"},{"activityId":20952,"activityType":2,"switchLabel":"满120减13"}]
                 * isShowVoucherTab : 1
                 */

                private int cartId;
                private String amount;
                private int itemId;
                private int skuId;
                private String itemLogoUrl;
                private String itemName;
                private String skuPrice;
                private String itemSpecification;
                private int itemStatus;
                private int itemType;
                private int limitCount;
                private int minimumLimitCount;
                private int stock;
                private int isShowVoucherTab;
                private List<SwitchActivityLabelDTOListBean> switchActivityLabelDTOList;

                /**
                 * 是否被勾选
                 * @return
                 */
                public boolean isCHeck = false;

                /**
                 * 判断是否是子view操作数据还是父类
                 */
                public boolean isChildenOnCLick = false;

                public boolean isChildenOnCLick() {
                    return isChildenOnCLick;
                }

                public void setChildenOnCLick(boolean childenOnCLick) {
                    isChildenOnCLick = childenOnCLick;
                }

                public boolean isCHeck() {
                    return isCHeck;
                }

                public void setCHeck(boolean CHeck) {
                    isCHeck = CHeck;
                }


                public int getCartId() {
                    return cartId;
                }

                public void setCartId(int cartId) {
                    this.cartId = cartId;
                }

                public String getAmount() {
                    return amount;
                }

                public void setAmount(String amount) {
                    this.amount = amount;
                }

                public int getItemId() {
                    return itemId;
                }

                public void setItemId(int itemId) {
                    this.itemId = itemId;
                }

                public int getSkuId() {
                    return skuId;
                }

                public void setSkuId(int skuId) {
                    this.skuId = skuId;
                }

                public String getItemLogoUrl() {
                    return itemLogoUrl;
                }

                public void setItemLogoUrl(String itemLogoUrl) {
                    this.itemLogoUrl = itemLogoUrl;
                }

                public String getItemName() {
                    return itemName;
                }

                public void setItemName(String itemName) {
                    this.itemName = itemName;
                }

                public String getSkuPrice() {
                    return skuPrice;
                }

                public void setSkuPrice(String skuPrice) {
                    this.skuPrice = skuPrice;
                }

                public String getItemSpecification() {
                    return itemSpecification;
                }

                public void setItemSpecification(String itemSpecification) {
                    this.itemSpecification = itemSpecification;
                }

                public int getItemStatus() {
                    return itemStatus;
                }

                public void setItemStatus(int itemStatus) {
                    this.itemStatus = itemStatus;
                }

                public int getItemType() {
                    return itemType;
                }

                public void setItemType(int itemType) {
                    this.itemType = itemType;
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

                public int getIsShowVoucherTab() {
                    return isShowVoucherTab;
                }

                public void setIsShowVoucherTab(int isShowVoucherTab) {
                    this.isShowVoucherTab = isShowVoucherTab;
                }

                public List<SwitchActivityLabelDTOListBean> getSwitchActivityLabelDTOList() {
                    return switchActivityLabelDTOList;
                }

                public void setSwitchActivityLabelDTOList(List<SwitchActivityLabelDTOListBean> switchActivityLabelDTOList) {
                    this.switchActivityLabelDTOList = switchActivityLabelDTOList;
                }

                public static class SwitchActivityLabelDTOListBean {
                    /**
                     * activityId : 22726
                     * activityType : 1
                     * switchLabel : 满2件9折, 满5件7.55折
                     */

                    private int activityId;
                    private int activityType;
                    private String switchLabel;

                    /**
                     * 是否被勾选
                     * @return
                     */
                    public boolean isCHeck = false;

                    public boolean isCHeck() {
                        return isCHeck;
                    }

                    public void setCHeck(boolean CHeck) {
                        isCHeck = CHeck;
                    }

                    public SwitchActivityLabelDTOListBean(int activityId, int activityType, String switchLabel) {
                        this.activityId = activityId;
                        this.activityType = activityType;
                        this.switchLabel = switchLabel;
                    }

                    public int getActivityId() {
                        return activityId;
                    }

                    public void setActivityId(int activityId) {
                        this.activityId = activityId;
                    }

                    public int getActivityType() {
                        return activityType;
                    }

                    public void setActivityType(int activityType) {
                        this.activityType = activityType;
                    }

                    public String getSwitchLabel() {
                        return switchLabel;
                    }

                    public void setSwitchLabel(String switchLabel) {
                        this.switchLabel = switchLabel;
                    }
                }
            }
        }
    }
}
