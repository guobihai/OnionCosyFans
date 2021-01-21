package cc.onion.cosyfans.my.entity.request;

import java.io.Serializable;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.entity.request
 * @ClassName: OrderRequest
 * @Description: 订单请求API类
 * @Author: guobihai
 * @CreateDate: 2019-12-13 17:59
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-13 17:59
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class OrderRequest implements Serializable {
    private static final long serialVersionUID = -4807609405039113307L;
    String orderNo;
//    请求角色 1：会员，2：店铺
    int role;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
