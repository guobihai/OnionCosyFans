package cc.onion.cosyfans.home.entity.response;

import cc.onion.cosyfans.base.entity.BaseRequestBean;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.home.entity.response
 * @ClassName: AlbumRequest
 * @Description: java类作用描述
 * @Author: guobihai
 * @CreateDate: 2019-12-25 15:40
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-25 15:40
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class AlbumRequest extends BaseRequestBean {

    private String albumId;

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }
}
