package cc.onion.cosyfans.main.entity;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.main.entity
 * @ClassName: ItemAmonutEntity
 * @Description: 购物车加购数量
 * @Author: guobihai
 * @CreateDate: 2020-01-11 14:05
 * @UpdateUser: guobihai
 * @UpdateDate: 2020-01-11 14:05
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ItemAmonutEntity {


    /**
     * status : 200
     * msg : OK
     * data : 2
     */

    private int status;
    private String msg;
    private int data;

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

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
