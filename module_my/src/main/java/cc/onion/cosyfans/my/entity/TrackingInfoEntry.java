package cc.onion.cosyfans.my.entity;

import android.text.TextUtils;

import java.util.List;

/**
 * 查看物流- 商品订单列表
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.entity
 * @ClassName: TrackingInfoEntry
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2020/1/16 11:57
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/16 11:57
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class TrackingInfoEntry {

    /**
     * status : 200
     * msg : OK
     * data : [{"subOrderItemImageList":[{"itemImage":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103174450519_597.jpg"},{"itemImage":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103153205534_539.jpg"},{"itemImage":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103154202025_305.jpg"},{"itemImage":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104200751579_224.jpg"}],"subOrderNo":"CTMS2019121100001000498C1","orderStatus":3}]
     */

    private int status;
    private String msg;
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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * subOrderItemImageList : [{"itemImage":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103174450519_597.jpg"},{"itemImage":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103153205534_539.jpg"},{"itemImage":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103154202025_305.jpg"},{"itemImage":"https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171104/20171104200751579_224.jpg"}]
         * subOrderNo : CTMS2019121100001000498C1
         * orderStatus : 3
         */

        private String subOrderNo;
        private int orderStatus;
        private List<SubOrderItemImageListBean> subOrderItemImageList;

        public String getSubOrderNo() {
            return TextUtils.isEmpty(subOrderNo)?"":subOrderNo;
        }

        public void setSubOrderNo(String subOrderNo) {
            this.subOrderNo = subOrderNo;
        }

        public int getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(int orderStatus) {
            this.orderStatus = orderStatus;
        }

        public List<SubOrderItemImageListBean> getSubOrderItemImageList() {
            return subOrderItemImageList;
        }

        public void setSubOrderItemImageList(List<SubOrderItemImageListBean> subOrderItemImageList) {
            this.subOrderItemImageList = subOrderItemImageList;
        }

        public static class SubOrderItemImageListBean {
            /**
             * itemImage : https://onion-images-dev.yangsupplychain.com/fmal-item-images/20171103/20171103174450519_597.jpg
             */

            private String itemImage;

            public String getItemImage() {
                return itemImage;
            }

            public void setItemImage(String itemImage) {
                this.itemImage = itemImage;
            }
        }
    }
}
