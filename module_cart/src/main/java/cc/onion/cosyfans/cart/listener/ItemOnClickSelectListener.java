package cc.onion.cosyfans.cart.listener;

import cc.onion.cosyfans.cart.entity.response.CartListEntity;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.cart.listener
 * @ClassName: ItemOnClickSelectListener
 * @Description: 点击反馈传送到主界面进行操作
 * @Author: guobihai
 * @CreateDate: 2019-12-14 17:40
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-14 17:40
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface ItemOnClickSelectListener {

    void  setSelectIitem(CartListEntity.DataBean.CartDetailListBean.CartItemDetailDTOListBean childenItem,
                         CartListEntity.DataBean.CartDetailListBean FatherItem);
}
