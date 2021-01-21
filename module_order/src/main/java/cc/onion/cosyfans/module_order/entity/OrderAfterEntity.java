package cc.onion.cosyfans.module_order.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.module_order.entity
 * @ClassName: OrderAfterEntity
 * @Description: 售后数据
 * @Author: guobihai
 * @CreateDate: 2019-12-27 15:15
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-27 15:15
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class OrderAfterEntity implements Serializable {
    private static final long serialVersionUID = 5194399469325570431L;


    /**
     * status : 200
     * msg : OK
     * data : {"orderNo":"CTMS2019122700001000156","uploadDomain":"https://api.onionecology.com/fileresource/cos/uploadFiles","downloadPath":"https://onion-images-dev.yangsupplychain.com","timeDifference":0,"freightDots2":"5.90","freight":590,"refundTypes":[{"refundType":1,"name":"Only Refunds"}],"items":[{"subOrderNo":"CTMS2019122700001000156C1","orderItemId":1300147,"itemImage":"https://onion-images-dev.yangsupplychain.com/collect-item-images/20190910/20190910103541101_806.png","specification":"rongliang:240g","itemName":"fanwai-yishijieqianchou pianpiantongnianweifengmishanzhatiao 130g/bao","buyNum":3,"realFee":903,"realFeeDots2":"9.03","canRefundNum":3}]}
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
         * orderNo : CTMS2019122700001000156
         * uploadDomain : https://api.onionecology.com/fileresource/cos/uploadFiles
         * downloadPath : https://onion-images-dev.yangsupplychain.com
         * timeDifference : 0
         * freightDots2 : 5.90
         * freight : 590
         * refundTypes : [{"refundType":1,"name":"Only Refunds"}]
         * items : [{"subOrderNo":"CTMS2019122700001000156C1","orderItemId":1300147,"itemImage":"https://onion-images-dev.yangsupplychain.com/collect-item-images/20190910/20190910103541101_806.png","specification":"rongliang:240g","itemName":"fanwai-yishijieqianchou pianpiantongnianweifengmishanzhatiao 130g/bao","buyNum":3,"realFee":903,"realFeeDots2":"9.03","canRefundNum":3}]
         */

        private String orderNo;
        private String uploadDomain;
        private String downloadPath;
        private int timeDifference;
        private String freightDots2;
        private int freight;
        private List<RefundTypesBean> refundTypes;
        private List<ItemsBean> items;

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        public String getUploadDomain() {
            return uploadDomain;
        }

        public void setUploadDomain(String uploadDomain) {
            this.uploadDomain = uploadDomain;
        }

        public String getDownloadPath() {
            return downloadPath;
        }

        public void setDownloadPath(String downloadPath) {
            this.downloadPath = downloadPath;
        }

        public int getTimeDifference() {
            return timeDifference;
        }

        public void setTimeDifference(int timeDifference) {
            this.timeDifference = timeDifference;
        }

        public String getFreightDots2() {
            return freightDots2;
        }

        public void setFreightDots2(String freightDots2) {
            this.freightDots2 = freightDots2;
        }

        public int getFreight() {
            return freight;
        }

        public void setFreight(int freight) {
            this.freight = freight;
        }

        public List<RefundTypesBean> getRefundTypes() {
            return refundTypes;
        }

        public void setRefundTypes(List<RefundTypesBean> refundTypes) {
            this.refundTypes = refundTypes;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class RefundTypesBean {
            /**
             * refundType : 1
             * name : Only Refunds
             */

            private int refundType;
            private String name;

            public int getRefundType() {
                return refundType;
            }

            public void setRefundType(int refundType) {
                this.refundType = refundType;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class ItemsBean {
            /**
             * subOrderNo : CTMS2019122700001000156C1
             * orderItemId : 1300147
             * itemImage : https://onion-images-dev.yangsupplychain.com/collect-item-images/20190910/20190910103541101_806.png
             * specification : rongliang:240g
             * itemName : fanwai-yishijieqianchou pianpiantongnianweifengmishanzhatiao 130g/bao
             * buyNum : 3
             * realFee : 903
             * realFeeDots2 : 9.03
             * canRefundNum : 3
             */

            private String subOrderNo;
            private int orderItemId;
            private String itemImage;
            private String specification;
            private String itemName;
            private int buyNum;
            private int realFee;
            private String realFeeDots2;
            private int canRefundNum;

            public String getSubOrderNo() {
                return subOrderNo;
            }

            public void setSubOrderNo(String subOrderNo) {
                this.subOrderNo = subOrderNo;
            }

            public int getOrderItemId() {
                return orderItemId;
            }

            public void setOrderItemId(int orderItemId) {
                this.orderItemId = orderItemId;
            }

            public String getItemImage() {
                return itemImage;
            }

            public void setItemImage(String itemImage) {
                this.itemImage = itemImage;
            }

            public String getSpecification() {
                return specification;
            }

            public void setSpecification(String specification) {
                this.specification = specification;
            }

            public String getItemName() {
                return itemName;
            }

            public void setItemName(String itemName) {
                this.itemName = itemName;
            }

            public int getBuyNum() {
                return buyNum;
            }

            public void setBuyNum(int buyNum) {
                this.buyNum = buyNum;
            }

            public int getRealFee() {
                return realFee;
            }

            public void setRealFee(int realFee) {
                this.realFee = realFee;
            }

            public String getRealFeeDots2() {
                return realFeeDots2;
            }

            public void setRealFeeDots2(String realFeeDots2) {
                this.realFeeDots2 = realFeeDots2;
            }

            public int getCanRefundNum() {
                return canRefundNum;
            }

            public void setCanRefundNum(int canRefundNum) {
                this.canRefundNum = canRefundNum;
            }
        }
    }
}
