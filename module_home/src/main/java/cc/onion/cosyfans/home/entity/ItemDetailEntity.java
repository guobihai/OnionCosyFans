package cc.onion.cosyfans.home.entity;

import java.io.Serializable;

import cc.onion.cosyfans.base.entity.BaseRequestBean;

/**
 * 信息流对象
 * @author guobihai
 * @date 2019-11-15
 */
public class ItemDetailEntity extends BaseRequestBean {

    private String flowTabId;
    private int pageNum;
    private int pageSize;

    public String getFlowTabId() {
        return flowTabId;
    }

    public void setFlowTabId(String flowTabId) {
        this.flowTabId = flowTabId;
    }

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
}
