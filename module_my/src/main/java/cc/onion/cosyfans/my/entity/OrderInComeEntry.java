package cc.onion.cosyfans.my.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

/**
 * 商家中心-我的订单-我的收益
 *
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.entity
 * @ClassName: OrderInComeEntry
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2020/1/15 14:59
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/15 14:59
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class OrderInComeEntry {

    /**
     * status : 200
     * msg : OK
     * data : {"orderIncomeDTOList":[{"itemName":"fanwaishangpin-FW20190301","realFee":"36.32","itemNum":3},{"itemName":"fanwaishangpin-FW20190301","realFee":"38.71","itemNum":3}],"refundNo":null,"userName":"15767708601","orderTime":"2019-12-13 10:53:58","gradeIncomeMap":{"Level 1 sales profit":"45.80"}}
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
         * orderIncomeDTOList : [{"itemName":"fanwaishangpin-FW20190301","realFee":"36.32","itemNum":3},{"itemName":"fanwaishangpin-FW20190301","realFee":"38.71","itemNum":3}]
         * refundNo : null
         * userName : 15767708601
         * orderTime : 2019-12-13 10:53:58
         * gradeIncomeMap : {"Level 1 sales profit":"45.80"}
         */

        private Object refundNo;
        private String userName;
        private String orderTime;
        private Map<String, String> gradeIncomeMap;
        private List<OrderIncomeDTOListBean> orderIncomeDTOList;

        public Object getRefundNo() {
            return refundNo;
        }

        public void setRefundNo(Object refundNo) {
            this.refundNo = refundNo;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getOrderTime() {
            return orderTime;
        }

        public void setOrderTime(String orderTime) {
            this.orderTime = orderTime;
        }

        public Map<String, String> getGradeIncomeMap() {
            return gradeIncomeMap;
        }

        public void setGradeIncomeMap(Map<String, String> gradeIncomeMap) {
            this.gradeIncomeMap = gradeIncomeMap;
        }

        public List<OrderIncomeDTOListBean> getOrderIncomeDTOList() {
            return orderIncomeDTOList;
        }

        public void setOrderIncomeDTOList(List<OrderIncomeDTOListBean> orderIncomeDTOList) {
            this.orderIncomeDTOList = orderIncomeDTOList;
        }


        public static class OrderIncomeDTOListBean {
            /**
             * itemName : fanwaishangpin-FW20190301
             * realFee : 36.32
             * itemNum : 3
             */

            private String itemName;
            private String realFee;
            private int itemNum;

            public String getItemName() {
                return itemName;
            }

            public void setItemName(String itemName) {
                this.itemName = itemName;
            }

            public String getRealFee() {
                return realFee;
            }

            public void setRealFee(String realFee) {
                this.realFee = realFee;
            }

            public int getItemNum() {
                return itemNum;
            }

            public void setItemNum(int itemNum) {
                this.itemNum = itemNum;
            }
        }
    }
}
