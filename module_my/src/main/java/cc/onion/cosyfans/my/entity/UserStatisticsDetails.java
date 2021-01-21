package cc.onion.cosyfans.my.entity;

/**
 * 注册用户统计-用户订单详情
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.entity
 * @ClassName: UserStatisticsDetails
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2020/1/17 18:17
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/17 18:17
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class UserStatisticsDetails {

    /**
     * status : 200
     * msg : OK
     * data : {"refundCount":"0.00","totalEarnings":"0.00","customerUnitPrice":"0.00","orderCount":0,"retailCount":"0.00"}
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
         * refundCount : 0.00
         * totalEarnings : 0.00
         * customerUnitPrice : 0.00
         * orderCount : 0
         * retailCount : 0.00
         */

        private String refundCount;
        private String totalEarnings;
        private String customerUnitPrice;
        private int orderCount;
        private String retailCount;

        public String getRefundCount() {
            return refundCount;
        }

        public void setRefundCount(String refundCount) {
            this.refundCount = refundCount;
        }

        public String getTotalEarnings() {
            return totalEarnings;
        }

        public void setTotalEarnings(String totalEarnings) {
            this.totalEarnings = totalEarnings;
        }

        public String getCustomerUnitPrice() {
            return customerUnitPrice;
        }

        public void setCustomerUnitPrice(String customerUnitPrice) {
            this.customerUnitPrice = customerUnitPrice;
        }

        public int getOrderCount() {
            return orderCount;
        }

        public void setOrderCount(int orderCount) {
            this.orderCount = orderCount;
        }

        public String getRetailCount() {
            return retailCount;
        }

        public void setRetailCount(String retailCount) {
            this.retailCount = retailCount;
        }
    }
}
