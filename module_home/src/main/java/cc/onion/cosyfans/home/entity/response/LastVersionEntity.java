package cc.onion.cosyfans.home.entity.response;

import java.io.Serializable;

/**
 * @author guobihai
 * @date 2019-11-12
 */
public class LastVersionEntity implements Serializable {

    private static final long serialVersionUID = 2516883801845178138L;
    /**
     * hasVersion : true
     * jsVersion : 20190926144312673
     * versionNo : V-1.0.0
     * updateContent :
     * url :
     * updateIndex : 0
     * forceUpdate : 0
     */

    private boolean hasVersion;
    private String jsVersion;
    private String versionNo;
    private String updateContent;
    private String url;
    private int updateIndex;
    private int forceUpdate;

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

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    public String getUpdateContent() {
        return updateContent;
    }

    public void setUpdateContent(String updateContent) {
        this.updateContent = updateContent;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getUpdateIndex() {
        return updateIndex;
    }

    public void setUpdateIndex(int updateIndex) {
        this.updateIndex = updateIndex;
    }

    public int getForceUpdate() {
        return forceUpdate;
    }

    public void setForceUpdate(int forceUpdate) {
        this.forceUpdate = forceUpdate;
    }
}
