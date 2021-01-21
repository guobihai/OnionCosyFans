package cc.onion.cosyfans.my.entity;

import java.io.Serializable;

/**
 * @ProjectName: Onion-CosyFans
 * @Package: cc.onion.cosyfans.my.entity
 * @ClassName: MineEntity
 * @Description: mine界面
 * @Author: guobihai
 * @CreateDate: 2019-12-18 10:51
 * @UpdateUser: guobihai
 * @UpdateDate: 2019-12-18 10:51
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class MineEntity implements Serializable {
    private static final long serialVersionUID = -2045927851649744843L;


    /**
     * status : 200
     * msg : OK
     * data : {"userId":48441,"headPortrait":null,"name":"mask123","downloadPath":"https://onion-images-dev.yangsupplychain.com","unpaid":0,"delivering":0,"afterSale":0,"isStore":false,"isCosyDiscoveries":false,"isCosyPartner":false,"isCanByCosyDiscoveries":true,"isCanByCosyPartner":true,"wall":null,"couponCount":20,"inviteImage":"https://onion-images-dev.yangsupplychain.com/operation/20191029/20191029102724803_990.png","inviteUrl":"https://cosyfans-my.factorychain2social.cn/en/invite-new-friends.html?shopId=1","inviteStatus":1,"canPublishMoment":0,"canViewMoment":1}
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
         * userId : 48441
         * headPortrait : null
         * name : mask123
         * downloadPath : https://onion-images-dev.yangsupplychain.com
         * unpaid : 0
         * delivering : 0
         * afterSale : 0
         * isStore : false
         * isCosyDiscoveries : false
         * isCosyPartner : false
         * isCanByCosyDiscoveries : true
         * isCanByCosyPartner : true
         * wall : null
         * couponCount : 20
         * inviteImage : https://onion-images-dev.yangsupplychain.com/operation/20191029/20191029102724803_990.png
         * inviteUrl : https://cosyfans-my.factorychain2social.cn/en/invite-new-friends.html?shopId=1
         * inviteStatus : 1
         * canPublishMoment : 0
         * canViewMoment : 1
         */

        private int userId;
        private Object headPortrait;
        private String name;
        private String downloadPath;
        private int unpaid;
        private int delivering;
        private int afterSale;
        private boolean isStore;
        private boolean isCosyDiscoveries;
        private boolean isCosyPartner;
        private boolean isCanByCosyDiscoveries;
        private boolean isCanByCosyPartner;
        private Object wall;
        private int couponCount;
        private String inviteImage;
        private String inviteUrl;
        private int inviteStatus;
        private int canPublishMoment;
        private int canViewMoment;

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public Object getHeadPortrait() {
            return headPortrait;
        }

        public void setHeadPortrait(Object headPortrait) {
            this.headPortrait = headPortrait;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDownloadPath() {
            return downloadPath;
        }

        public void setDownloadPath(String downloadPath) {
            this.downloadPath = downloadPath;
        }

        public int getUnpaid() {
            return unpaid;
        }

        public void setUnpaid(int unpaid) {
            this.unpaid = unpaid;
        }

        public int getDelivering() {
            return delivering;
        }

        public void setDelivering(int delivering) {
            this.delivering = delivering;
        }

        public int getAfterSale() {
            return afterSale;
        }

        public void setAfterSale(int afterSale) {
            this.afterSale = afterSale;
        }

        public boolean isIsStore() {
            return isStore;
        }

        public void setIsStore(boolean isStore) {
            this.isStore = isStore;
        }

        public boolean isIsCosyDiscoveries() {
            return isCosyDiscoveries;
        }

        public void setIsCosyDiscoveries(boolean isCosyDiscoveries) {
            this.isCosyDiscoveries = isCosyDiscoveries;
        }

        public boolean isIsCosyPartner() {
            return isCosyPartner;
        }

        public void setIsCosyPartner(boolean isCosyPartner) {
            this.isCosyPartner = isCosyPartner;
        }

        public boolean isIsCanByCosyDiscoveries() {
            return isCanByCosyDiscoveries;
        }

        public void setIsCanByCosyDiscoveries(boolean isCanByCosyDiscoveries) {
            this.isCanByCosyDiscoveries = isCanByCosyDiscoveries;
        }

        public boolean isIsCanByCosyPartner() {
            return isCanByCosyPartner;
        }

        public void setIsCanByCosyPartner(boolean isCanByCosyPartner) {
            this.isCanByCosyPartner = isCanByCosyPartner;
        }

        public Object getWall() {
            return wall;
        }

        public void setWall(Object wall) {
            this.wall = wall;
        }

        public int getCouponCount() {
            return couponCount;
        }

        public void setCouponCount(int couponCount) {
            this.couponCount = couponCount;
        }

        public String getInviteImage() {
            return inviteImage;
        }

        public void setInviteImage(String inviteImage) {
            this.inviteImage = inviteImage;
        }

        public String getInviteUrl() {
            return inviteUrl;
        }

        public void setInviteUrl(String inviteUrl) {
            this.inviteUrl = inviteUrl;
        }

        public int getInviteStatus() {
            return inviteStatus;
        }

        public void setInviteStatus(int inviteStatus) {
            this.inviteStatus = inviteStatus;
        }

        public int getCanPublishMoment() {
            return canPublishMoment;
        }

        public void setCanPublishMoment(int canPublishMoment) {
            this.canPublishMoment = canPublishMoment;
        }

        public int getCanViewMoment() {
            return canViewMoment;
        }

        public void setCanViewMoment(int canViewMoment) {
            this.canViewMoment = canViewMoment;
        }
    }
}
