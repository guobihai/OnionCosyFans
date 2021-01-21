package cc.onion.cosyfans.my.entity;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextUtils;

import java.io.Serializable;

import cc.onion.cosyfans.base.utils.StringUtils;
import cc.onion.cosyfans.module_my.BR;

/** 
* 
* @ProjectName: Onion-CosyFans
* @Package: cc.onion.cosyfans.my.entity
* @ClassName: MerchantInfo
* @Description: java类作用描述 
* @Author: guobihai
* @CreateDate: 2020/1/10 20:26
* @UpdateUser: guobihai
* @UpdateDate: 2020/1/10 20:26
* @UpdateRemark: 更新说明
* @Version: 1.0
*/
public class MerchantInfo  implements Serializable {

    /**
     * status : 200
     * msg : OK
     * data : {"name":"1576770860","logoUrl":"https://onion-images-dev.yangsupplychain.com/20191218/20191218182106972_702.png","createTime":1553433925000,"userLevel":"探索者会员","storeStatus":"","invitationCode":"8237VV","directNum":"0/1","indirectNum":"0/1","shopId":29046,"allSale":"1473.81","todaySale":"0.00","monthSale":"0.00","allIncome":"148.81","todayIncome":"0.00","teamIncome":"0.00","inviteIncome":"0.00","allOrder":9,"todayOrder":0,"isShowNum":true,"hasTeamIncome":false,"isPreCD":"0","level":20}
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
         * name : 1576770860
         * logoUrl : https://onion-images-dev.yangsupplychain.com/20191218/20191218182106972_702.png
         * createTime : 1553433925000
         * userLevel : 探索者会员
         * storeStatus :
         * invitationCode : 8237VV
         * directNum : 0/1
         * indirectNum : 0/1
         * shopId : 29046
         * allSale : 1473.81
         * todaySale : 0.00
         * monthSale : 0.00
         * allIncome : 148.81
         * todayIncome : 0.00
         * teamIncome : 0.00
         * inviteIncome : 0.00
         * allOrder : 9
         * todayOrder : 0
         * isShowNum : true
         * hasTeamIncome : false
         * isPreCD : 0
         * level : 20
         */

        private String name;
        private String logoUrl;
        private long createTime;
        private String userLevel;
        private String storeStatus;
        private String invitationCode;
        private String directNum;
        private String indirectNum;
        private int shopId;
        private String allSale;
        private String todaySale;
        private String monthSale;
        private String allIncome;
        private String todayIncome;
        private String teamIncome;
        private String inviteIncome;
        private int allOrder;
        private int todayOrder;
        private boolean isShowNum;
        private boolean hasTeamIncome;
        private String isPreCD;
        private int level;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLogoUrl() {
            return TextUtils.isEmpty(logoUrl)?"":logoUrl;
        }

        public void setLogoUrl(String logoUrl) {
            this.logoUrl = logoUrl;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getUserLevel() {
            return TextUtils.isEmpty(userLevel)?"":userLevel;
        }

        public void setUserLevel(String userLevel) {
            this.userLevel = userLevel;
        }

        public String getStoreStatus() {
            return storeStatus;
        }

        public void setStoreStatus(String storeStatus) {
            this.storeStatus = storeStatus;
        }

        public String getInvitationCode() {
            return TextUtils.isEmpty(invitationCode)?"":invitationCode;
        }

        public void setInvitationCode(String invitationCode) {
            this.invitationCode = invitationCode;
        }

        public String getDirectNum() {
            return directNum;
        }

        public void setDirectNum(String directNum) {
            this.directNum = directNum;
        }

        public String getIndirectNum() {
            return indirectNum;
        }

        public void setIndirectNum(String indirectNum) {
            this.indirectNum = indirectNum;
        }

        public int getShopId() {
            return shopId;
        }

        public void setShopId(int shopId) {
            this.shopId = shopId;
        }

        public String getAllSale() {
            return TextUtils.isEmpty(allSale)?"":allSale;
        }

        public void setAllSale(String allSale) {
            this.allSale = allSale;
        }

        public String getTodaySale() {
            return todaySale;
        }

        public void setTodaySale(String todaySale) {
            this.todaySale = todaySale;
        }

        public String getMonthSale() {
            return monthSale;
        }

        public void setMonthSale(String monthSale) {
            this.monthSale = monthSale;
        }

        public String getAllIncome() {
            return TextUtils.isEmpty(allIncome)?"":allIncome;
        }

        public void setAllIncome(String allIncome) {
            this.allIncome = allIncome;
        }

        public String getTodayIncome() {
            return todayIncome;
        }

        public void setTodayIncome(String todayIncome) {
            this.todayIncome = todayIncome;
        }

        public String getTeamIncome() {
            return teamIncome;
        }

        public void setTeamIncome(String teamIncome) {
            this.teamIncome = teamIncome;
        }

        public String getInviteIncome() {
            return inviteIncome;
        }

        public void setInviteIncome(String inviteIncome) {
            this.inviteIncome = inviteIncome;
        }

        public int getAllOrder() {
            return allOrder;
        }

        public void setAllOrder(int allOrder) {
            this.allOrder = allOrder;
        }

        public int getTodayOrder() {
            return todayOrder;
        }

        public void setTodayOrder(int todayOrder) {
            this.todayOrder = todayOrder;
        }

        public boolean isIsShowNum() {
            return isShowNum;
        }

        public void setIsShowNum(boolean isShowNum) {
            this.isShowNum = isShowNum;
        }

        public boolean isHasTeamIncome() {
            return hasTeamIncome;
        }

        public void setHasTeamIncome(boolean hasTeamIncome) {
            this.hasTeamIncome = hasTeamIncome;
        }

        public String getIsPreCD() {
            return TextUtils.isEmpty(isPreCD)?"0":isPreCD;
        }

        public void setIsPreCD(String isPreCD) {
            this.isPreCD = isPreCD;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }
    }
}
