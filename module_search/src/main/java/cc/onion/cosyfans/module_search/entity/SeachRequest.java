package cc.onion.cosyfans.module_search.entity;

import cc.onion.cosyfans.base.entity.BaseRequestBean;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.module_search.entity
 * @ClassName: SeachRequest
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2020-01-06 10:37
 * @UpdateUser: guobihai
 * @UpdateDate: 2020-01-06 10:37
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class SeachRequest extends BaseRequestBean {

    /**
     * 搜索数据
     */
    String q;

    String pageNum;
    String pageSize;

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

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }
}
