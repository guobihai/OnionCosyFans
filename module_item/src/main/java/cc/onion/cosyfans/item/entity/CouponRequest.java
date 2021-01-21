package cc.onion.cosyfans.item.entity;

import cc.onion.cosyfans.base.entity.BaseRequestBean;


/**
 * 优惠券请求累
 * @author guobihai
 * @date 2019-11-22
 */
public class CouponRequest extends BaseRequestBean {

    String itemIdStr;

    public String getItemIdStr() {
        return itemIdStr;
    }

    public void setItemIdStr(String itemIdStr) {
        this.itemIdStr = itemIdStr;
    }
}
