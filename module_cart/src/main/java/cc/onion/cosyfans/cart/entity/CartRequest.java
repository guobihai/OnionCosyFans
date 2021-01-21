package cc.onion.cosyfans.cart.entity;

import cc.onion.cosyfans.base.entity.BaseRequestBean;

/**
 * 购物车
 * @author guobihai
 * @date 2019-11-25
 */
public class CartRequest extends BaseRequestBean {

    private String pageNum;
      private String pageSize;

    public String getPageNum() {
        return pageNum;
    }

    public void setPageNum(String pageNum) {
        this.pageNum = pageNum;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }
}
