package cc.onion.cosyfans.my.entity;

import android.text.TextUtils;

/**
 * 商家中心-注册统计
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.entity
 * @ClassName: RegisterCosyTypeEntry
 * @Description: java类作用描述
 * @Author: 唐朝
 * @CreateDate: 2020/1/17 10:10
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/17 10:10
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class RegisterCosyTypeEntry {

    /**
     * status : 200
     * msg : OK
     * data : {"directCd":0,"refundCount":"0.00","customerUnitPrice":"0.00","totalEarnings":"148.81","refundEarnings":"0.00","level":20,"registerCount":0,"orderCount":9,"billingCount":0,"indirectCd":0,"retailCount":"1473.81"}
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
         * directCd : 0 直拓CD
         * refundCount : 0.00 退款总额
         * customerUnitPrice : 0.00 客单价
         * totalEarnings : 148.81 累计收益
         * refundEarnings : 0.00 退款收益
         * level : 20  会员类型: 10: Cosy Friend、15:Pre-Cosy Discoveries，20: Cosy Discoveries、30: Cosy Partner、40: Cosy Globalist
         * registerCount : 0 注册用户
         * orderCount : 9 订单数量
         * billingCount : 0 下单用户
         * indirectCd : 0 间拓CD
         * retailCount : 1473.81  零售总额
         */

        private int directCd;
        private String refundCount;
        private String customerUnitPrice;
        private String totalEarnings;
        private String refundEarnings;
        private int level;
        private int registerCount;
        private int orderCount;
        private int billingCount;
        private int indirectCd;
        private String retailCount;

        public int getDirectCd() {
            return directCd;
        }

        public void setDirectCd(int directCd) {
            this.directCd = directCd;
        }

        public String getRefundCount() {
            return TextUtils.isEmpty(refundCount)?"":refundCount;
        }

        public void setRefundCount(String refundCount) {
            this.refundCount = refundCount;
        }

        public String getCustomerUnitPrice() {
            return TextUtils.isEmpty(customerUnitPrice)?"":customerUnitPrice;
        }

        public void setCustomerUnitPrice(String customerUnitPrice) {
            this.customerUnitPrice = customerUnitPrice;
        }

        public String getTotalEarnings() {
            return TextUtils.isEmpty(totalEarnings)?"":totalEarnings;
        }

        public void setTotalEarnings(String totalEarnings) {
            this.totalEarnings = totalEarnings;
        }

        public String getRefundEarnings() {
            return TextUtils.isEmpty(refundEarnings)?"":refundEarnings;
        }

        public void setRefundEarnings(String refundEarnings) {
            this.refundEarnings = refundEarnings;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public int getRegisterCount() {
            return registerCount;
        }

        public void setRegisterCount(int registerCount) {
            this.registerCount = registerCount;
        }

        public int getOrderCount() {
            return orderCount;
        }

        public void setOrderCount(int orderCount) {
            this.orderCount = orderCount;
        }

        public int getBillingCount() {
            return billingCount;
        }

        public void setBillingCount(int billingCount) {
            this.billingCount = billingCount;
        }

        public int getIndirectCd() {
            return indirectCd;
        }

        public void setIndirectCd(int indirectCd) {
            this.indirectCd = indirectCd;
        }

        public String getRetailCount() {
            return TextUtils.isEmpty(retailCount)?"":retailCount;
        }

        public void setRetailCount(String retailCount) {
            this.retailCount = retailCount;
        }
    }
}
