package cc.onion.cosyfans.main.event;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.main.event
 * @ClassName: CartCount
 * @Description: 购物车数量
 * @Author: guobihai
 * @CreateDate: 2020-01-11 10:17
 * @UpdateUser: guobihai
 * @UpdateDate: 2020-01-11 10:17
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class CartCount {

    int count;

    public CartCount(int data) {
        this.count = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
