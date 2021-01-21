package cc.onion.cosyfans.home.entity.response;

import java.io.Serializable;
import java.util.List;

/**
 * 广告图
 * @author guobihai
 * @email:guobihai@163.com
 *
 */
public class BannerEntity implements Serializable {
    private static final long serialVersionUID = 3358815690594800046L;

    /**
     * id : 21734
     * moduleId : 13965
     * title : 轮播广告3
     * subTitle :
     * zindex : 30
     * adPosition : 1
     * img : https://onion-images-dev.yangsupplychain.com/content/20190831/20190831112639125_667.jpg
     * url : https://cosyfans-item.buykerbuyker.cn/en/detail/3669040534745.html
     * urlType : 0
     * bgSetting : 1
     * titleBg :
     * searchBarBg :
     * mainBg :
     * hotWord :
     * hotWordIsPush : 0
     * specificContent : 0
     * specificSubType : 0
     * seckillBeginTime :
     * seckillHour : 0
     * restartType : 0
     * detailItemVos : []
     * detailIconVos : []
     * detailAlbumVos : []
     */

    private int id;
    private int moduleId;
    private String title;
    private String subTitle;
    private int zindex;
    private int adPosition;
    private String img;
    private String url;
    private int urlType;
    private int bgSetting;
    private String titleBg;
    private String searchBarBg;
    private String mainBg;
    private String hotWord;
    private int hotWordIsPush;
    private int specificContent;
    private int specificSubType;
    private String seckillBeginTime;
    private int seckillHour;
    private int restartType;
    private List<?> detailItemVos;
    private List<?> detailIconVos;
    private List<?> detailAlbumVos;
    private String androidUrl;

    public String getAndroidUrl() {
        return androidUrl;
    }

    public void setAndroidUrl(String androidUrl) {
        this.androidUrl = androidUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public int getZindex() {
        return zindex;
    }

    public void setZindex(int zindex) {
        this.zindex = zindex;
    }

    public int getAdPosition() {
        return adPosition;
    }

    public void setAdPosition(int adPosition) {
        this.adPosition = adPosition;
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

    public int getUrlType() {
        return urlType;
    }

    public void setUrlType(int urlType) {
        this.urlType = urlType;
    }

    public int getBgSetting() {
        return bgSetting;
    }

    public void setBgSetting(int bgSetting) {
        this.bgSetting = bgSetting;
    }

    public String getTitleBg() {
        return titleBg;
    }

    public void setTitleBg(String titleBg) {
        this.titleBg = titleBg;
    }

    public String getSearchBarBg() {
        return searchBarBg;
    }

    public void setSearchBarBg(String searchBarBg) {
        this.searchBarBg = searchBarBg;
    }

    public String getMainBg() {
        return mainBg;
    }

    public void setMainBg(String mainBg) {
        this.mainBg = mainBg;
    }

    public String getHotWord() {
        return hotWord;
    }

    public void setHotWord(String hotWord) {
        this.hotWord = hotWord;
    }

    public int getHotWordIsPush() {
        return hotWordIsPush;
    }

    public void setHotWordIsPush(int hotWordIsPush) {
        this.hotWordIsPush = hotWordIsPush;
    }

    public int getSpecificContent() {
        return specificContent;
    }

    public void setSpecificContent(int specificContent) {
        this.specificContent = specificContent;
    }

    public int getSpecificSubType() {
        return specificSubType;
    }

    public void setSpecificSubType(int specificSubType) {
        this.specificSubType = specificSubType;
    }

    public String getSeckillBeginTime() {
        return seckillBeginTime;
    }

    public void setSeckillBeginTime(String seckillBeginTime) {
        this.seckillBeginTime = seckillBeginTime;
    }

    public int getSeckillHour() {
        return seckillHour;
    }

    public void setSeckillHour(int seckillHour) {
        this.seckillHour = seckillHour;
    }

    public int getRestartType() {
        return restartType;
    }

    public void setRestartType(int restartType) {
        this.restartType = restartType;
    }

    public List<?> getDetailItemVos() {
        return detailItemVos;
    }

    public void setDetailItemVos(List<?> detailItemVos) {
        this.detailItemVos = detailItemVos;
    }

    public List<?> getDetailIconVos() {
        return detailIconVos;
    }

    public void setDetailIconVos(List<?> detailIconVos) {
        this.detailIconVos = detailIconVos;
    }

    public List<?> getDetailAlbumVos() {
        return detailAlbumVos;
    }

    public void setDetailAlbumVos(List<?> detailAlbumVos) {
        this.detailAlbumVos = detailAlbumVos;
    }
}
