package cc.onion.cosyfans.module_trade.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.module_trade.entity
 * @ClassName: CashCouponEntity
 * @Description: 现金卷
 * @Author: guobihai
 * @CreateDate: 2019-12-12 14:55
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-12 14:55
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class CashCouponEntity implements Serializable {
    private static final long serialVersionUID = -1475394714706538341L;


    /**
     * status : 200
     * msg : OK
     * data : [{"labelName":"满100减10","startTime":"2019-12-04 18:29:36","endTime":"2019-12-21 18:29:39","couponExplain":"实付金额未达到满减门槛","couponStatus":2,"couponType":3,"couponAmount":"10.00","userCouponId":318320,"couponId":24703,"useStatus":1,"thresholdAmount":"100.00"},{"labelName":"满100减10","startTime":"2019-12-04 18:29:36","endTime":"2019-12-21 18:29:39","couponExplain":"实付金额未达到满减门槛","couponStatus":2,"couponType":3,"couponAmount":"10.00","userCouponId":318445,"couponId":24703,"useStatus":1,"thresholdAmount":"100.00"},{"labelName":"满100减10","startTime":"2019-12-04 18:29:36","endTime":"2019-12-21 18:29:39","couponExplain":"实付金额未达到满减门槛","couponStatus":2,"couponType":3,"couponAmount":"10.00","userCouponId":318662,"couponId":24703,"useStatus":1,"thresholdAmount":"100.00"},{"labelName":"满100减10","startTime":"2019-12-04 18:29:36","endTime":"2019-12-21 18:29:39","couponExplain":"实付金额未达到满减门槛","couponStatus":2,"couponType":3,"couponAmount":"10.00","userCouponId":318878,"couponId":24703,"useStatus":1,"thresholdAmount":"100.00"},{"labelName":"满100减10","startTime":"2019-12-04 18:29:36","endTime":"2019-12-21 18:29:39","couponExplain":"实付金额未达到满减门槛","couponStatus":2,"couponType":3,"couponAmount":"10.00","userCouponId":319195,"couponId":24703,"useStatus":1,"thresholdAmount":"100.00"},{"labelName":"满200减22","startTime":"2019-12-04 18:29:36","endTime":"2019-12-21 18:29:39","couponExplain":"实付金额未达到满减门槛","couponStatus":2,"couponType":3,"couponAmount":"22.00","userCouponId":319257,"couponId":25086,"useStatus":1,"thresholdAmount":"200.00"},{"labelName":"满200减22","startTime":"2019-12-04 18:29:36","endTime":"2019-12-21 18:29:39","couponExplain":"实付金额未达到满减门槛","couponStatus":2,"couponType":3,"couponAmount":"22.00","userCouponId":319349,"couponId":25086,"useStatus":1,"thresholdAmount":"200.00"},{"labelName":"满200减22","startTime":"2019-12-04 18:29:36","endTime":"2019-12-21 18:29:39","couponExplain":"实付金额未达到满减门槛","couponStatus":2,"couponType":3,"couponAmount":"22.00","userCouponId":319511,"couponId":25086,"useStatus":1,"thresholdAmount":"200.00"},{"labelName":"满200减22","startTime":"2019-12-04 18:29:36","endTime":"2019-12-21 18:29:39","couponExplain":"实付金额未达到满减门槛","couponStatus":2,"couponType":3,"couponAmount":"22.00","userCouponId":319641,"couponId":25086,"useStatus":1,"thresholdAmount":"200.00"},{"labelName":"满200减22","startTime":"2019-12-04 18:29:36","endTime":"2019-12-21 18:29:39","couponExplain":"实付金额未达到满减门槛","couponStatus":2,"couponType":3,"couponAmount":"22.00","userCouponId":319893,"couponId":25086,"useStatus":1,"thresholdAmount":"200.00"}]
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
         * labelName : 满100减10
         * startTime : 2019-12-04 18:29:36
         * endTime : 2019-12-21 18:29:39
         * couponExplain : 实付金额未达到满减门槛
         * couponStatus : 2
         * couponType : 3
         * couponAmount : 10.00
         * userCouponId : 318320
         * couponId : 24703
         * useStatus : 1
         * thresholdAmount : 100.00
         */

        private String labelName;
        private String startTime;
        private String endTime;
        private String couponExplain;
        private int couponStatus;
        private int couponType;
        private String couponAmount;
        private int userCouponId;
        private int couponId;
        private int useStatus;
        private String thresholdAmount;
        private  boolean isChoose = false ;

        public DataBean(String labelName) {
            this.labelName = labelName;
        }

        public boolean isChoose() {
            return isChoose;
        }

        public void setChoose(boolean choose) {
            isChoose = choose;
        }

        public String getLabelName() {
            return labelName;
        }

        public void setLabelName(String labelName) {
            this.labelName = labelName;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getCouponExplain() {
            return couponExplain;
        }

        public void setCouponExplain(String couponExplain) {
            this.couponExplain = couponExplain;
        }

        public int getCouponStatus() {
            return couponStatus;
        }

        public void setCouponStatus(int couponStatus) {
            this.couponStatus = couponStatus;
        }

        public int getCouponType() {
            return couponType;
        }

        public void setCouponType(int couponType) {
            this.couponType = couponType;
        }

        public String getCouponAmount() {
            return couponAmount;
        }

        public void setCouponAmount(String couponAmount) {
            this.couponAmount = couponAmount;
        }

        public int getUserCouponId() {
            return userCouponId;
        }

        public void setUserCouponId(int userCouponId) {
            this.userCouponId = userCouponId;
        }

        public int getCouponId() {
            return couponId;
        }

        public void setCouponId(int couponId) {
            this.couponId = couponId;
        }

        public int getUseStatus() {
            return useStatus;
        }

        public void setUseStatus(int useStatus) {
            this.useStatus = useStatus;
        }

        public String getThresholdAmount() {
            return thresholdAmount;
        }

        public void setThresholdAmount(String thresholdAmount) {
            this.thresholdAmount = thresholdAmount;
        }
    }
}
