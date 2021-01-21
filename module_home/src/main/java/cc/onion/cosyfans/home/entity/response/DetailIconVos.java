package cc.onion.cosyfans.home.entity.response;

public class DetailIconVos {


    /**
     * id : 14462
     * img : https://onion-images-dev.yangsupplychain.com/content/20190910/20190910150834498_737.png
     * url : https://weex-m.cosyfans.com/en/special-topic.html?albumId=1915375
     * zindex : 3
     */

    private int id;
    private String img;
    private String url;
    private int zindex;
    private int urlType;
    private int androidUrl;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getZindex() {
        return zindex;
    }

    public void setZindex(int zindex) {
        this.zindex = zindex;
    }
}
