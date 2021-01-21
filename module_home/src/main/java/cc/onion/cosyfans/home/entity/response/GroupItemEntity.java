package cc.onion.cosyfans.home.entity.response;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.home.entity.response
 * @ClassName: GroupItemEntity
 * @Description: 项目分组推荐产品数据
 * @Author: guobihai
 * @CreateDate: 2019-12-25 15:23
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-25 15:23
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class GroupItemEntity implements Serializable {
    private static final long serialVersionUID = 6840112531588685448L;

    /**
     * status : 200
     * msg : OK
     * data : {"data":[{"id":"10049","mainItem":0,"itemId":"29197","itemName":"ISANAyisanuo luhuiyangganjushumintuomaogunzhu 120ml","sellingPrice":"58.06","marketPrice":"77.42","hasStock":1,"imageSmall":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104192503718_765.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104192503718_765.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104192503718_765.jpg","promotionLabel":"24.5% OFF","couponLabel":"RM13 OFF","discountedPrice":"43.84"},{"id":"10050","mainItem":0,"itemId":"127079","itemName":"Beats Powerbeats 3 Wireless Bluetooth In-ear Earphones Noise Cancelling with MIC","sellingPrice":"306.18","marketPrice":"306.18","hasStock":1,"imageSmall":"https://glodimg.chinabrands.cn/pdm-product-pic/Distribution/2019/01/02/source-img/20190102164603_54404.jpg","imageMedium":"https://glodimg.chinabrands.cn/pdm-product-pic/Distribution/2019/01/02/source-img/20190102164603_54404.jpg","imageBig":"https://glodimg.chinabrands.cn/pdm-product-pic/Distribution/2019/01/02/source-img/20190102164603_54404.jpg","promotionLabel":null,"couponLabel":"","discountedPrice":null}],"totalPages":1}
     */

    private int status;
    private String msg;
    private DataBeanX data;

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

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * data : [{"id":"10049","mainItem":0,"itemId":"29197","itemName":"ISANAyisanuo luhuiyangganjushumintuomaogunzhu 120ml","sellingPrice":"58.06","marketPrice":"77.42","hasStock":1,"imageSmall":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104192503718_765.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104192503718_765.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104192503718_765.jpg","promotionLabel":"24.5% OFF","couponLabel":"RM13 OFF","discountedPrice":"43.84"},{"id":"10050","mainItem":0,"itemId":"127079","itemName":"Beats Powerbeats 3 Wireless Bluetooth In-ear Earphones Noise Cancelling with MIC","sellingPrice":"306.18","marketPrice":"306.18","hasStock":1,"imageSmall":"https://glodimg.chinabrands.cn/pdm-product-pic/Distribution/2019/01/02/source-img/20190102164603_54404.jpg","imageMedium":"https://glodimg.chinabrands.cn/pdm-product-pic/Distribution/2019/01/02/source-img/20190102164603_54404.jpg","imageBig":"https://glodimg.chinabrands.cn/pdm-product-pic/Distribution/2019/01/02/source-img/20190102164603_54404.jpg","promotionLabel":null,"couponLabel":"","discountedPrice":null}]
         * totalPages : 1
         */

        private int totalPages;
        private List<DataBean> data;

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * id : 10049
             * mainItem : 0
             * itemId : 29197
             * itemName : ISANAyisanuo luhuiyangganjushumintuomaogunzhu 120ml
             * sellingPrice : 58.06
             * marketPrice : 77.42
             * hasStock : 1
             * imageSmall : https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104192503718_765.jpg
             * imageMedium : https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104192503718_765.jpg
             * imageBig : https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104192503718_765.jpg
             * promotionLabel : 24.5% OFF
             * couponLabel : RM13 OFF
             * discountedPrice : 43.84
             */

            private String id;
            private int mainItem;
            private String itemId;
            private String itemName;
            private String sellingPrice;
            private String marketPrice;
            private int hasStock;
            private String imageSmall;
            private String imageMedium;
            private String imageBig;
            private String promotionLabel;
            private String couponLabel;
            private String discountedPrice;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public int getMainItem() {
                return mainItem;
            }

            public void setMainItem(int mainItem) {
                this.mainItem = mainItem;
            }

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

            public int getHasStock() {
                return hasStock;
            }

            public void setHasStock(int hasStock) {
                this.hasStock = hasStock;
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

            public String getDiscountedPrice() {
                return discountedPrice;
            }

            public void setDiscountedPrice(String discountedPrice) {
                this.discountedPrice = discountedPrice;
            }
        }
    }
}
