package cc.onion.cosyfans.item.entity;

import java.io.Serializable;

/**
 * @author guobihai
 * @email :guobihai@163.com
 */
public class PhotoModel implements Serializable {
    private static final long serialVersionUID = 1061383073513944736L;

    private String imgUrl;
    private String titleTag;
    private String other1;
    private String other2;

    public PhotoModel(String imgUrl, String titleTag, String other1, String other2) {
        this.imgUrl = imgUrl;
        this.titleTag = titleTag;
        this.other1 = other1;
        this.other2 = other2;
    }

    public PhotoModel(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitleTag() {
        return titleTag;
    }

    public void setTitleTag(String titleTag) {
        this.titleTag = titleTag;
    }

    public String getOther1() {
        return other1;
    }

    public void setOther1(String other1) {
        this.other1 = other1;
    }

    public String getOther2() {
        return other2;
    }

    public void setOther2(String other2) {
        this.other2 = other2;
    }
}
