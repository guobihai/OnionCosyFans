package cc.onion.cosyfans.categorie.entity.responer;

import java.io.Serializable;

/**
 * @author guobihai
 *
 */
public class ChildNodesEntity implements Serializable {
    private static final long serialVersionUID = 5229313809272817311L;


    /**
     * id : 1022873
     * categoryName : bushui
     * categoryNameI18n : null
     * imageSamll :
     * targetUrl :
     * childNodes : null
     */

    private int id;
    private String categoryName;
    private Object categoryNameI18n;
    private String imageSamll;
    private String targetUrl;
    private Object childNodes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Object getCategoryNameI18n() {
        return categoryNameI18n;
    }

    public void setCategoryNameI18n(Object categoryNameI18n) {
        this.categoryNameI18n = categoryNameI18n;
    }

    public String getImageSamll() {
        return imageSamll;
    }

    public void setImageSamll(String imageSamll) {
        this.imageSamll = imageSamll;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public Object getChildNodes() {
        return childNodes;
    }

    public void setChildNodes(Object childNodes) {
        this.childNodes = childNodes;
    }
}
