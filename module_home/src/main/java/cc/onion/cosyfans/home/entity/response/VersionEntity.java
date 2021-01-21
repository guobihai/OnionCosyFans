package cc.onion.cosyfans.home.entity.response;

import java.io.Serializable;

/**
 * @author  guobihai
 * @date 2019 - 11-12
 */
public class VersionEntity implements Serializable {

    private static final long serialVersionUID = -4556361827057976637L;
    /**
     * hasVersion : true
     * jsVersion : 20190926144312673
     * versionNo : null
     * updateContent : null
     * url : null
     * updateIndex : null
     * forceUpdate : null
     */

    private boolean hasVersion;
    private String jsVersion;
    private Object versionNo;
    private Object updateContent;
    private Object url;
    private Object updateIndex;
    private Object forceUpdate;

    public boolean isHasVersion() {
        return hasVersion;
    }

    public void setHasVersion(boolean hasVersion) {
        this.hasVersion = hasVersion;
    }

    public String getJsVersion() {
        return jsVersion;
    }

    public void setJsVersion(String jsVersion) {
        this.jsVersion = jsVersion;
    }

    public Object getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(Object versionNo) {
        this.versionNo = versionNo;
    }

    public Object getUpdateContent() {
        return updateContent;
    }

    public void setUpdateContent(Object updateContent) {
        this.updateContent = updateContent;
    }

    public Object getUrl() {
        return url;
    }

    public void setUrl(Object url) {
        this.url = url;
    }

    public Object getUpdateIndex() {
        return updateIndex;
    }

    public void setUpdateIndex(Object updateIndex) {
        this.updateIndex = updateIndex;
    }

    public Object getForceUpdate() {
        return forceUpdate;
    }

    public void setForceUpdate(Object forceUpdate) {
        this.forceUpdate = forceUpdate;
    }
}
