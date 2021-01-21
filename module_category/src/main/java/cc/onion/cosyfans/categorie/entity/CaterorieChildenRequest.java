package cc.onion.cosyfans.categorie.entity;

import cc.onion.cosyfans.base.entity.BaseRequestBean;


/**
 * @author guobihai
 * @email:guobihai@163.com
 */
public class CaterorieChildenRequest extends BaseRequestBean {

    int pageNum;
    int pageSize;
    int categoryId;
//    int sort;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

//    public int getSort() {
//        return sort;
//    }
//
//    public void setSort(int sort) {
//        this.sort = sort;
//    }
}
