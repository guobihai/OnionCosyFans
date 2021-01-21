package cc.onion.cosyfans.home.entity.response;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.home.entity.response
 * @ClassName: AlumGroupEntity
 * @Description: 专辑类
 * @Author: guobihai
 * @CreateDate: 2019-12-25 15:38
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-25 15:38
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class AlumGroupEntity implements Serializable {
    private static final long serialVersionUID = 5389301236782902726L;


    /**
     * status : 200
     * msg : OK
     * data : {"id":"10213","theme":"zhuanji-3","imageSmall":"https://onion-images-dev.yangsupplychain.com/operation/20181225/20181225160850123_469.png","imageMedium":"https://onion-images-dev.yangsupplychain.com/operation/20181225/20181225160850123_469.png","imageBig":"https://onion-images-dev.yangsupplychain.com/operation/20181225/20181225160850123_469.png","content":"If you describe something or someone as extraordinary,# you mean that\nthey have some extremely good or special quality.\u2014\u2014Collins #If you\ndescribe something or someone as extraordinary, you mean that they have\nsome extremely good or special quality.\u2014\u2014Collins If you describe\nsomething or someone as","tabList":[{"id":"10603","name":"Description2","imageSmall":"https://onion-images-dev.yangsupplychain.com/operation/20181226/20181226181043087_945.png","imageMedium":"https://onion-images-dev.yangsupplychain.com/operation/20181226/20181226181043087_945.png","imageBig":"https://onion-images-dev.yangsupplychain.com/operation/20181226/20181226181043087_945.png","content":"test111","linkUrl":"https://cosyfans-m.factorychain2social.cn/en/category-detail.html?id=10095&itemId=16175&liId=26441"},{"id":"10755","name":"Description1","imageSmall":"https://onion-images-dev.yangsupplychain.com/operation/20181226/20181226181111078_820.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/operation/20181226/20181226181111078_820.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/operation/20181226/20181226181111078_820.jpg","content":"test2","linkUrl":"https://cosyfans-m.factorychain2social.cn/en/category-detail.html?id=10095&itemId=16175&liId=26441"},{"id":"10838","name":"Description3","imageSmall":"","imageMedium":"","imageBig":"","content":"","linkUrl":""},{"id":"11115","name":"Description4","imageSmall":"https://onion-images-dev.yangsupplychain.com/operation/20181226/20181226182351699_950.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/operation/20181226/20181226182351699_950.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/operation/20181226/20181226182351699_950.jpg","content":"","linkUrl":""},{"id":"11374","name":"Description5","imageSmall":"","imageMedium":"","imageBig":"","content":"","linkUrl":""},{"id":"11418","name":"Description6","imageSmall":"","imageMedium":"","imageBig":"","content":"","linkUrl":""},{"id":"11778","name":"Description6","imageSmall":"","imageMedium":"","imageBig":"","content":"","linkUrl":""},{"id":"12067","name":"Description8","imageSmall":"","imageMedium":"","imageBig":"","content":"","linkUrl":""},{"id":"12622","name":"test9","imageSmall":"","imageMedium":"","imageBig":"","content":"","linkUrl":""}]}
     */

    private int status;
    private String msg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 10213
         * theme : zhuanji-3
         * imageSmall : https://onion-images-dev.yangsupplychain.com/operation/20181225/20181225160850123_469.png
         * imageMedium : https://onion-images-dev.yangsupplychain.com/operation/20181225/20181225160850123_469.png
         * imageBig : https://onion-images-dev.yangsupplychain.com/operation/20181225/20181225160850123_469.png
         * content : If you describe something or someone as extraordinary,# you mean that
         they have some extremely good or special quality.——Collins #If you
         describe something or someone as extraordinary, you mean that they have
         some extremely good or special quality.——Collins If you describe
         something or someone as
         * tabList : [{"id":"10603","name":"Description2","imageSmall":"https://onion-images-dev.yangsupplychain.com/operation/20181226/20181226181043087_945.png","imageMedium":"https://onion-images-dev.yangsupplychain.com/operation/20181226/20181226181043087_945.png","imageBig":"https://onion-images-dev.yangsupplychain.com/operation/20181226/20181226181043087_945.png","content":"test111","linkUrl":"https://cosyfans-m.factorychain2social.cn/en/category-detail.html?id=10095&itemId=16175&liId=26441"},{"id":"10755","name":"Description1","imageSmall":"https://onion-images-dev.yangsupplychain.com/operation/20181226/20181226181111078_820.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/operation/20181226/20181226181111078_820.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/operation/20181226/20181226181111078_820.jpg","content":"test2","linkUrl":"https://cosyfans-m.factorychain2social.cn/en/category-detail.html?id=10095&itemId=16175&liId=26441"},{"id":"10838","name":"Description3","imageSmall":"","imageMedium":"","imageBig":"","content":"","linkUrl":""},{"id":"11115","name":"Description4","imageSmall":"https://onion-images-dev.yangsupplychain.com/operation/20181226/20181226182351699_950.jpg","imageMedium":"https://onion-images-dev.yangsupplychain.com/operation/20181226/20181226182351699_950.jpg","imageBig":"https://onion-images-dev.yangsupplychain.com/operation/20181226/20181226182351699_950.jpg","content":"","linkUrl":""},{"id":"11374","name":"Description5","imageSmall":"","imageMedium":"","imageBig":"","content":"","linkUrl":""},{"id":"11418","name":"Description6","imageSmall":"","imageMedium":"","imageBig":"","content":"","linkUrl":""},{"id":"11778","name":"Description6","imageSmall":"","imageMedium":"","imageBig":"","content":"","linkUrl":""},{"id":"12067","name":"Description8","imageSmall":"","imageMedium":"","imageBig":"","content":"","linkUrl":""},{"id":"12622","name":"test9","imageSmall":"","imageMedium":"","imageBig":"","content":"","linkUrl":""}]
         */

        private String id;
        private String theme;
        private String imageSmall;
        private String imageMedium;
        private String imageBig;
        private String content;
        private List<TabListBean> tabList;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTheme() {
            return theme;
        }

        public void setTheme(String theme) {
            this.theme = theme;
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

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public List<TabListBean> getTabList() {
            return tabList;
        }

        public void setTabList(List<TabListBean> tabList) {
            this.tabList = tabList;
        }

        public static class TabListBean {
            /**
             * id : 10603
             * name : Description2
             * imageSmall : https://onion-images-dev.yangsupplychain.com/operation/20181226/20181226181043087_945.png
             * imageMedium : https://onion-images-dev.yangsupplychain.com/operation/20181226/20181226181043087_945.png
             * imageBig : https://onion-images-dev.yangsupplychain.com/operation/20181226/20181226181043087_945.png
             * content : test111
             * linkUrl : https://cosyfans-m.factorychain2social.cn/en/category-detail.html?id=10095&itemId=16175&liId=26441
             */

            private String id;
            private String name;
            private String imageSmall;
            private String imageMedium;
            private String imageBig;
            private String content;
            private String linkUrl;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
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

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getLinkUrl() {
                return linkUrl;
            }

            public void setLinkUrl(String linkUrl) {
                this.linkUrl = linkUrl;
            }
        }
    }
}
