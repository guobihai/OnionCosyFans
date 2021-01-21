package cc.onion.cosyfans.passport.entity;

import cc.onion.cosyfans.base.entity.BaseRequestBean;

/**
 * 登录请求类
 */
public class LoginRequest extends BaseRequestBean {


    /**
     * 用户名
     */
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * 国家区号
     */
    private String nationCode;

    private String imgShopId;

    public String getImgShopId() {
        return imgShopId;
    }

    public void setImgShopId(String imgShopId) {
        this.imgShopId = imgShopId;
    }

    public String getNationCode() {
        return nationCode;
    }

    public void setNationCode(String nationCode) {
        this.nationCode = nationCode;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
