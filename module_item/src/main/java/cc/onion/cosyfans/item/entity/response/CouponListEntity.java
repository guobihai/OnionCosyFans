package cc.onion.cosyfans.item.entity.response;

import java.io.Serializable;
import java.util.List;

/**
 * 优惠券实体类
 * @author guobihai
 * @email:guobihai@163.com
 */
public class CouponListEntity implements Serializable {


    /**
     * recvList : []
     * unRecvList : [{"id":21021,"activityId":17224,"couponName":"满500减50","couponExplain":"别动这个活动！！！","thresholdAmount":"500","couponAmount":"50","validStartTime":"2019.11.13","validEndTime":"2021.05.01","receivedStatus":0,"couponType":1},{"id":24215,"activityId":17224,"couponName":"满10000减150","couponExplain":"别动这个活动！！！","thresholdAmount":"10000","couponAmount":"150","validStartTime":"2019.11.13","validEndTime":"2021.05.01","receivedStatus":0,"couponType":1}]
     * loginStatus : false
     */

    private boolean loginStatus;
    private List<UnRecvListBean> recvList;
    private List<UnRecvListBean> unRecvList;

    public boolean isLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    public List<UnRecvListBean> getRecvList() {
        return recvList;
    }

    public void setRecvList(List<UnRecvListBean> recvList) {
        this.recvList = recvList;
    }

    public List<UnRecvListBean> getUnRecvList() {
        return unRecvList;
    }

    public void setUnRecvList(List<UnRecvListBean> unRecvList) {
        this.unRecvList = unRecvList;
    }

    public static class UnRecvListBean {
        /**
         * id : 21021
         * activityId : 17224
         * couponName : 满500减50
         * couponExplain : 别动这个活动！！！
         * thresholdAmount : 500
         * couponAmount : 50
         * validStartTime : 2019.11.13
         * validEndTime : 2021.05.01
         * receivedStatus : 0
         * couponType : 1
         */

        private int id;
        private int activityId;
        private String couponName;
        private String couponExplain;
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

        public String getCouponExplain() {
            return couponExplain;
        }

        public void setCouponExplain(String couponExplain) {
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
