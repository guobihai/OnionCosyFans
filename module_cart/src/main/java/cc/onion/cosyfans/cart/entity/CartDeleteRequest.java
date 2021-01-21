package cc.onion.cosyfans.cart.entity;

import java.util.List;

import cc.onion.cosyfans.base.entity.BaseRequestBean;


/**
 * @author guobihai
 * @version V1.0
 * @Title: CartDeleteRequest
 * @Package cc.onion.cosyfans.cart.entity
 * @date 2019-12-03 14:53
 * @email: anhui-zhuang@msyc.cc
 * @Description: (删除购物车请求类)
 */
public class CartDeleteRequest extends BaseRequestBean {

    /**
     * 删除购物车数组，json
     * Number
     */
    List<Integer> cartIds;

    public List<Integer> getCartIds() {
        return cartIds;
    }

    public void setCartIds(List<Integer> cartIds) {
        this.cartIds = cartIds;
    }
}
