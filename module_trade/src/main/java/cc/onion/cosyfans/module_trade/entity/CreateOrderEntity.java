package cc.onion.cosyfans.module_trade.entity;

import java.io.Serializable;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.module_trade.entity
 * @ClassName: CreateOrderEntity
 * @Description: 创建订单相应类
 * @Author: guobihai
 * @CreateDate: 2019-12-13 14:01
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-13 14:01
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class CreateOrderEntity implements Serializable {
    private static final long serialVersionUID = -8622691828823639623L;


    /**
     * status : 200
     * msg : OK
     * data : {"orderNo":"CTMS2019121300001000864","countDown":2399537}
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
         * orderNo : CTMS2019121300001000864
         * countDown : 2399537
         */

        private String orderNo;
        private int countDown;

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        public int getCountDown() {
            return countDown;
        }

        public void setCountDown(int countDown) {
            this.countDown = countDown;
        }
    }
}
