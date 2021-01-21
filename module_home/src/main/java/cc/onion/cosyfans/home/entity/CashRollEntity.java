package cc.onion.cosyfans.home.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.home.entity
 * @ClassName: CashRollEntity
 * @Description: 现金对话框
 * @Author: guobihai
 * @CreateDate: 2020-01-15 15:17
 * @UpdateUser: guobihai
 * @UpdateDate: 2020-01-15 15:17
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class CashRollEntity implements Serializable {
    private static final long serialVersionUID = 6466297511795386141L;


    /**
     * status : 200
     * msg : OK
     * data : {"couponVOList":[{"id":24215,"activityId":17224,"couponName":"满10000减150","couponExplain":null,"thresholdAmount":"10000.00","couponAmount":"150","validStartTime":"2019.11.13","validEndTime":"2021.05.01","receivedStatus":0,"couponType":1},{"id":21021,"activityId":17224,"couponName":"满500减50","couponExplain":null,"thresholdAmount":"500.00","couponAmount":"50","validStartTime":"2019.11.13","validEndTime":"2021.05.01","receivedStatus":0,"couponType":1}],"effectiveTime":7200,"isLogin":false,"totalCount":0,"totalPages":0}
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
         * couponVOList : [{"id":24215,"activityId":17224,"couponName":"满10000减150","couponExplain":null,"thresholdAmount":"10000.00","couponAmount":"150","validStartTime":"2019.11.13","validEndTime":"2021.05.01","receivedStatus":0,"couponType":1},{"id":21021,"activityId":17224,"couponName":"满500减50","couponExplain":null,"thresholdAmount":"500.00","couponAmount":"50","validStartTime":"2019.11.13","validEndTime":"2021.05.01","receivedStatus":0,"couponType":1}]
         * effectiveTime : 7200
         * isLogin : false
         * totalCount : 0
         * totalPages : 0
         */

        private int effectiveTime;
        private boolean isLogin;
        private int totalCount;
        private int totalPages;
        private List<CouponVOListBean> couponVOList;

        public int getEffectiveTime() {
            return effectiveTime;
        }

        public void setEffectiveTime(int effectiveTime) {
            this.effectiveTime = effectiveTime;
        }

        public boolean isIsLogin() {
            return isLogin;
        }

        public void setIsLogin(boolean isLogin) {
            this.isLogin = isLogin;
        }

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public List<CouponVOListBean> getCouponVOList() {
            return couponVOList;
        }

        public void setCouponVOList(List<CouponVOListBean> couponVOList) {
            this.couponVOList = couponVOList;
        }

        public static class CouponVOListBean {
            /**
             * id : 24215
             * activityId : 17224
             * couponName : 满10000减150
             * couponExplain : null
             * thresholdAmount : 10000.00
             * couponAmount : 150
             * validStartTime : 2019.11.13
             * validEndTime : 2021.05.01
             * receivedStatus : 0
             * couponType : 1
             */

            private int id;
            private int activityId;
            private String couponName;
            private Object couponExplain;
            private String thresholdAmount;
            private String couponAmount;
            private String validStartTime;
            private String validEndTime;
            private int receivedStatus;
            private int couponType;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getActivityId() {
                return activityId;
            }

            public void setActivityId(int activityId) {
                this.activityId = activityId;
            }

            public String getCouponName() {
                return couponName;
            }

            public void setCouponName(String couponName) {
                this.couponName = couponName;
            }

            public Object getCouponExplain() {
                return couponExplain;
            }

            public void setCouponExplain(Object couponExplain) {
                this.couponExplain = couponExplain;
            }

            public String getThresholdAmount() {
                return thresholdAmount;
            }

            public void setThresholdAmount(String thresholdAmount) {
                this.thresholdAmount = thresholdAmount;
            }

            public String getCouponAmount() {
                return couponAmount;
            }

            public void setCouponAmount(String couponAmount) {
                this.couponAmount = couponAmount;
            }

            public String getValidStartTime() {
                return validStartTime;
            }

            public void setValidStartTime(String validStartTime) {
                this.validStartTime = validStartTime;
            }

            public String getValidEndTime() {
                return validEndTime;
            }

            public void setValidEndTime(String validEndTime) {
                this.validEndTime = validEndTime;
            }

            public int getReceivedStatus() {
                return receivedStatus;
            }

            public void setReceivedStatus(int receivedStatus) {
                this.receivedStatus = receivedStatus;
            }

            public int getCouponType() {
                return couponType;
            }

            public void setCouponType(int couponType) {
                this.couponType = couponType;
            }
        }
    }
}
