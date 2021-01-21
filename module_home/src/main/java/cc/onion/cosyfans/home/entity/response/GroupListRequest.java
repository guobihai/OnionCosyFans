package cc.onion.cosyfans.home.entity.response;

import cc.onion.cosyfans.base.entity.BaseRequestBean;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.home.entity.response
 * @ClassName: GroupRequest
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2019-12-25 15:40
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-25 15:40
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class GroupListRequest extends BaseRequestBean {

    String albumTabId;
    int pageNum;
    int pageSize;

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

    public String getAlbumTabId() {
        return albumTabId;
    }

    public void setAlbumTabId(String albumTabId) {
        this.albumTabId = albumTabId;
    }
}
