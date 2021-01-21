package cc.onion.cosyfans.home.entity.response;

import java.io.Serializable;

public class DetailAlbumVosEntity implements Serializable {
    private static final long serialVersionUID = -563815675663381430L;

        private String id;
        private String albumId;
        private String sort;
        private String mainItem;
        private String img;

        private String theme;
        private int urlType;
        private int androidUrl;
         private String url;

    public int getUrlType() {
        return urlType;
    }

    public void setUrlType(int urlType) {
        this.urlType = urlType;
    }

    public int getAndroidUrl() {
        return androidUrl;
    }

    public void setAndroidUrl(int androidUrl) {
        this.androidUrl = androidUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getMainItem() {
        return mainItem;
    }

    public void setMainItem(String mainItem) {
        this.mainItem = mainItem;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
