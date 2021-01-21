package cc.onion.cosyfans.item.entity;

import cc.onion.cosyfans.base.entity.BaseRequestBean;

/**
 * 商品详情请求
 */
public class ItemDetailRequest extends BaseRequestBean {

    String itemId;
    //如果gift =1，他就是礼包，反之gift=0就是正常商品
//    String gift;


    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }


}
