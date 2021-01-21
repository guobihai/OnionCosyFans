package cc.onion.cosyfans.cart.listener;

import cc.onion.cosyfans.cart.entity.response.CartListEntity;

/**
 * @author guobihai
 * @version V1.0
 * @Title: AppCommonInfo
 * @Package cc.onion.cosyfans.base.common
 * @date 2019-12-03 14:53
 * @email: anhui-zhuang@msyc.cc
 * @Description: (折扣监听事件)
 */
public interface PromotionCheckItemListener {

    void checkItem(CartListEntity.DataBean.CartDetailListBean.CartItemDetailDTOListBean.SwitchActivityLabelDTOListBean item);

    void notifyDataSetChangedView();


    /**
     * 删除Iitem
     */
    void deleteChildenIitem();
}
