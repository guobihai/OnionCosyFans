package cc.onion.cosyfans.cart.entity.response;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.cart.entity.response
 * @ClassName: ItemsBean
 * @Description: 统一的itembean数据对象
 * @Author: guobihai
 * @CreateDate: 2019-12-24 15:23
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-24 15:23
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ItemsBean implements Serializable {
    private static final long serialVersionUID = -9092536638156697586L;
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

