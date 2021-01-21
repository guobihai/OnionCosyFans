package cc.onion.cosyfans.cart.listener;

import java.util.List;

import cc.onion.cosyfans.cart.entity.response.CartListEntity;

/**
 * @author guobihai
 * @version V1.0
 * @Title: AppCommonInfo
 * @Package cc.onion.cosyfans.base.common
 * @date 2019-12-03 14:53
 * @email: anhui-zhuang@msyc.cc
 * @Description: ()
 */
public interface ItemCheckOnlickListener {


    void addChildenItem(List<CartListEntity.DataBean.CartDetailListBean.CartItemDetailDTOListBean> currentChildenList);

    void removerChildenItem();

}
