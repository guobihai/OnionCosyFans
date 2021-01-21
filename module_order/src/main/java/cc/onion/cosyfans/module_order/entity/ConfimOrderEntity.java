package cc.onion.cosyfans.module_order.entity;

import java.io.Serializable;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.module_order.entity
 * @ClassName: ConfimOrderEntity
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2019-12-27 17:56
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-27 17:56
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ConfimOrderEntity implements Serializable {
    private static final long serialVersionUID = 4751323177933012945L;

    /**
     * status : 705
     * msg : Can not confirm the order in unpaid
     * data : null
     */

    private int status;
    private String msg;
    private Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
