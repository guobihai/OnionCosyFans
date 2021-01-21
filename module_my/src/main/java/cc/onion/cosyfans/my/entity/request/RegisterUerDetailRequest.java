package cc.onion.cosyfans.my.entity.request;

import cc.onion.cosyfans.base.entity.BaseRequestBean;

/**
 * 注册统计-用户详情
 *
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.entity.request
 * @ClassName: RegisterUerDetailRequest
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2020/1/17 17:30
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/17 17:30
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class RegisterUerDetailRequest extends BaseRequestBean {
    private String keyword = "";
    private int pageNum;
    private int pageSize;


    public RegisterUerDetailRequest(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.keyword = "";
        this.putKeySign("pageNum", this.pageNum);
        this.putKeySign("pageSize", this.pageSize);
        this.sign();
    }

    public RegisterUerDetailRequest(String keyword, int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.keyword = keyword;
        this.putKeySign("keyword", this.keyword);
        this.putKeySign("pageNum", this.pageNum);
        this.putKeySign("pageSize", this.pageSize);
        this.sign();
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
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
