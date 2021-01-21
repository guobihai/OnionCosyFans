package cc.onion.cosyfans.categorie.entity.responer;

import java.io.Serializable;
import java.util.List;

/**
 * 分类列表界面
 * @author guobihai
 * @date 2019-11-19
 */
public class CategorieListEntity implements Serializable {
    private static final long serialVersionUID = -3740131318957586024L;

    /**
     * status : 200
     * msg : 成功
     * data : [{"itemId":226162,"itemName":"SU:M37°huxi sweet smilerunfuru 250ml","sellingPrice":"131.80","marketPrice":"183.21","imageSmall":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104170925086_398.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104170925086_398.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104170925086_398.jpg","hasStock":1,"promotionLabel":null,"couponLabel":"","discountedPrice":null}]
     * pageNum : 1
     * totalPages : 1
     * pageSize : 10
     * totalCounts : 1
     * hasNextPage : false
     * hasPrePage : false
     * nextPage : 1
     * prePage : 1
     * startTime : null
     * endTime : null
     * firstPage : true
     * lastPage : true
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
         * itemId : 226162
         * itemName : SU:M37°huxi sweet smilerunfuru 250ml
         * sellingPrice : 131.80
         * marketPrice : 183.21
         * imageSmall : https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104170925086_398.jpg
         * imageMedium : https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104170925086_398.jpg
         * imageBig : https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104170925086_398.jpg
         * hasStock : 1
         * promotionLabel : null
         * couponLabel :
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
        private String promotionLabel;
        private String couponLabel;
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


        public String getCouponLabel() {
            return couponLabel;
        }

        public void setCouponLabel(String couponLabel) {
            this.couponLabel = couponLabel;
        }

        public String getDiscountedPrice() {
            return discountedPrice;
        }

        public void setPromotionLabel(String promotionLabel) {
            this.promotionLabel = promotionLabel;
        }

        public void setDiscountedPrice(String discountedPrice) {
            this.discountedPrice = discountedPrice;
        }
    }
}
