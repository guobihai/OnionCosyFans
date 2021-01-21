package cc.onion.cosyfans.item.entity.response;

import java.io.Serializable;

/**
 * @author guobihai
 * @date 2019 -12- 9
 */
public class DetailItemEntity implements Serializable {
    private static final long serialVersionUID = -4559706217870233107L;

    /**
     * key : 适用肤质/人群
     * value : 所有人
     * imageSmall :
     * imageMedium :
     * imageBig :
     */

    private String key;
    private String value;
    private String imageSmall;
    private String imageMedium;
    private String imageBig;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getImageSmall() {
        return imageSmall;
    }

    public void setImageSmall(String imageSmall) {
        this.imageSmall = imageSmall;
    }

    public String getImageMedium() {
        return imageMedium;
    }

    public void setImageMedium(String imageMedium) {
        this.imageMedium = imageMedium;
    }

    public String getImageBig() {
        return imageBig;
    }

    public void setImageBig(String imageBig) {
        this.imageBig = imageBig;
    }
}
