package cc.onion.cosyfans.passport.entity;

import java.io.Serializable;

/**
 * @author guobihai
 * @date 2019-11-2 8
 */
public class LoginResponEntity implements Serializable {
    private static final long serialVersionUID = -6449639886648421614L;

    /**
     * user : null
     * token : 83B0E66E7C43C5B41F44F9455B6D6766
     * shopId : null
     * inviteShopIdxCode : 1
     * imgShopIdxCode : null
     * loginFlag : null
     * loginType : 0
     */

    private Object user;
    /**
     * token
     */
    private String token;
    /**
     * 店铺ID
     */
    private String shopId;
    /**
     * 邀请码
     */
    private int inviteShopIdxCode;
    /**
     * 图片分享链接店铺ID
     */
    private String imgShopIdxCode;

    /**
     * 是否第一次登录（0；否;1：是）
     */
    private int loginFlag = 0;
    /**
     * 0账号登录，1facebook 2,google，3weChat
     */
    private int loginType = 0;

    public Object getUser() {
        return user;
    }

    public void setUser(Object user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public int getInviteShopIdxCode() {
        return inviteShopIdxCode;
    }

    public void setInviteShopIdxCode(int inviteShopIdxCode) {
        this.inviteShopIdxCode = inviteShopIdxCode;
    }

    public String getImgShopIdxCode() {
        return imgShopIdxCode;
    }

    public void setImgShopIdxCode(String imgShopIdxCode) {
        this.imgShopIdxCode = imgShopIdxCode;
    }

    public int getLoginFlag() {
        return loginFlag;
    }

    public void setLoginFlag(int loginFlag) {
        this.loginFlag = loginFlag;
    }

    public int getLoginType() {
        return loginType;
    }

    public void setLoginType(int loginType) {
        this.loginType = loginType;
    }
}
