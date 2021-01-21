package cc.onion.cosyfans.home.entity.response;

import android.view.View;
import android.widget.ImageView;

import com.wihaohao.PageGridView;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.List;

import cc.onion.cosyfans.base.BaseBindingAdapter;
import cc.onion.cosyfans.home.entity.response.DetailIconVos;

/**
 * 宫格广告位
 */
public class AdvertEntity implements Serializable {
    private static final long serialVersionUID = -2854951276462565788L;


    /**
     * status : 200
     * msg : OK
     * data : [{"id":29509,"moduleId":14555,"title":"宫格广告位","subTitle":"","zindex":2,"adPosition":1,"img":"https://onion-images-dev.yangsupplychain.com/content/20190910/20190910143206390_504.png","url":"https://cosyfans-m.factorychain2social.cn/en/category.html","urlType":0,"bgSetting":1,"titleBg":"","searchBarBg":"","mainBg":"","hotWord":"","hotWordIsPush":0,"specificContent":0,"specificSubType":0,"seckillBeginTime":"","seckillHour":0,"restartType":0,"detailItemVos":[],"detailIconVos":[],"detailAlbumVos":[]},{"id":17279,"moduleId":14555,"title":"宫格广告2","subTitle":"","zindex":2,"adPosition":2,"img":"https://onion-images-dev.yangsupplychain.com/content/20190910/20190910172906213_301.png","url":"https://cosyfans-item.buykerbuyker.cn/en/detail/3669040534745.html","urlType":0,"bgSetting":1,"titleBg":"","searchBarBg":"","mainBg":"","hotWord":"","hotWordIsPush":0,"specificContent":0,"specificSubType":0,"seckillBeginTime":"","seckillHour":0,"restartType":0,"detailItemVos":[],"detailIconVos":[],"detailAlbumVos":[]},{"id":17403,"moduleId":14555,"title":"宫格广告3","subTitle":"","zindex":3,"adPosition":3,"img":"https://onion-images-dev.yangsupplychain.com/content/20190830/20190830140957239_132.jpg","url":"https://cosyfans-item.buykerbuyker.cn/en/detail/3669040534745.html","urlType":0,"bgSetting":1,"titleBg":"","searchBarBg":"","mainBg":"","hotWord":"","hotWordIsPush":0,"specificContent":0,"specificSubType":0,"seckillBeginTime":"","seckillHour":0,"restartType":0,"detailItemVos":[],"detailIconVos":[],"detailAlbumVos":[]},{"id":17746,"moduleId":14555,"title":"宫格广告4","subTitle":"","zindex":4,"adPosition":4,"img":"https://onion-images-dev.yangsupplychain.com/content/20190830/20190830141021733_890.jpg","url":"https://cosyfans-item.buykerbuyker.cn/en/detail/3669040534745.html","urlType":0,"bgSetting":1,"titleBg":"","searchBarBg":"","mainBg":"","hotWord":"","hotWordIsPush":0,"specificContent":0,"specificSubType":0,"seckillBeginTime":"","seckillHour":0,"restartType":0,"detailItemVos":[],"detailIconVos":[],"detailAlbumVos":[]},{"id":17836,"moduleId":14555,"title":"宫格广告5","subTitle":"","zindex":5,"adPosition":5,"img":"https://onion-images-dev.yangsupplychain.com/content/20190830/20190830141045786_463.jpg","url":"https://cosyfans-item.buykerbuyker.cn/en/detail/3669040534745.html","urlType":0,"bgSetting":1,"titleBg":"","searchBarBg":"","mainBg":"","hotWord":"","hotWordIsPush":0,"specificContent":0,"specificSubType":0,"seckillBeginTime":"","seckillHour":0,"restartType":0,"detailItemVos":[],"detailIconVos":[],"detailAlbumVos":[]}]
     */

    private int status;
    private String msg;
    private List<DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean  implements  PageGridView.ItemModel{
        /**
         * id : 29509
         * moduleId : 14555
         * title : 宫格广告位
         * subTitle :
         * zindex : 2
         * adPosition : 1
         * img : https://onion-images-dev.yangsupplychain.com/content/20190910/20190910143206390_504.png
         * url : https://cosyfans-m.factorychain2social.cn/en/category.html
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
        private List<DetailItemEntity> detailItemVos;
        private List<DetailIconVos> detailIconVos;
        private List<DetailAlbumVosEntity> detailAlbumVos;
        private String androidUrl;
        private String iosUrl;


        public String getAndroidUrl() {
            return androidUrl;
        }

        public void setAndroidUrl(String androidUrl) {
            this.androidUrl = androidUrl;
        }

        public String getIosUrl() {
            return iosUrl;
        }

        public void setIosUrl(String iosUrl) {
            this.iosUrl = iosUrl;
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

        public List<DetailItemEntity> getDetailItemVos() {
            return detailItemVos;
        }

        public void setDetailItemVos(List<DetailItemEntity> detailItemVos) {
            this.detailItemVos = detailItemVos;
        }

        public List<DetailIconVos> getDetailIconVos() {
            return detailIconVos;
        }

        public void setDetailIconVos(List<DetailIconVos> detailIconVos) {
            this.detailIconVos = detailIconVos;
        }

        public List<DetailAlbumVosEntity> getDetailAlbumVos() {
            return detailAlbumVos;
        }

        public void setDetailAlbumVos(List<DetailAlbumVosEntity> detailAlbumVos) {
            this.detailAlbumVos = detailAlbumVos;
        }

        @Override
        public String getItemName() {

            return title;
        }

        @Override
        public void setIcon(ImageView imageView) {
            if(StringUtils.isNotEmpty(img)){
                BaseBindingAdapter.loadAvatarIcon(imageView,img);
            }

        }

        @Override
        public void setItemView(View itemView) {

        }
    }
}
