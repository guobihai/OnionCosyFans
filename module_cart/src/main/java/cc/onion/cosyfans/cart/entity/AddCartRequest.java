package cc.onion.cosyfans.cart.entity;

import cc.onion.cosyfans.base.entity.BaseRequestBean;

/**
 * @author guobihai
 * @version V1.0
 * @Title: AppCommonInfo
 * @Package cc.onion.cosyfans.base.common
 * @date 2019-12-03 14:53
 * @email: anhui-zhuang@msyc.cc
 * @Description: 添加购物车请求类)
 */
public class AddCartRequest extends BaseRequestBean {

    String cart;

    /**
     * 需要提交的JSON串数据
     */
    CartJsonEntity cartJsonEntity;

    public String getCart() {
        return cart;
    }

    public void setCart(String cart) {
        this.cart = cart;
    }

    public CartJsonEntity getCartJsonEntity() {
        return cartJsonEntity;
    }

    public void setCartJsonEntity(CartJsonEntity cartJsonEntity) {
        this.cartJsonEntity = cartJsonEntity;
    }
}
