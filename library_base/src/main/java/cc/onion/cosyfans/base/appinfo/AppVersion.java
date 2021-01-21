package cc.onion.cosyfans.base.appinfo;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.base.appinfo
 * @ClassName: AppVersion
 * @Description: App版本号
 * @Author: guobihai
 * @CreateDate: 2020-01-11 14:52
 * @UpdateUser: guobihai
 * @UpdateDate: 2020-01-11 14:52
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class AppVersion {


    public AppVersion(boolean hasVersion, String jsVersion, String versionNo, String updateContent, String url, String updateIndex, String forceUpdate) {
        this.hasVersion = hasVersion;
        this.jsVersion = jsVersion;
        this.versionNo = versionNo;
        this.updateContent = updateContent;
        this.url = url;
        this.updateIndex = updateIndex;
        this.forceUpdate = forceUpdate;
    }

    private boolean hasVersion;
    private String jsVersion;
    private String versionNo;
    private String updateContent;
    private String url;
    private String updateIndex;
    private String forceUpdate;


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

    public String getUpdateIndex() {
        return updateIndex;
    }

    public void setUpdateIndex(String updateIndex) {
        this.updateIndex = updateIndex;
    }

    public String getForceUpdate() {
        return forceUpdate;
    }

    public void setForceUpdate(String forceUpdate) {
        this.forceUpdate = forceUpdate;
    }
}
