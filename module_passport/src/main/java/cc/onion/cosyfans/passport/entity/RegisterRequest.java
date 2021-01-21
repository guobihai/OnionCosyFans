package cc.onion.cosyfans.passport.entity;

import cc.onion.cosyfans.base.entity.BaseRequestBean;

/**
 * 注册参数
 * @author  guobihai
 * @date 2019 -12 -02
 */
public class RegisterRequest extends BaseRequestBean {

    /***
     * 手机号码
     *
     */
    private  String phone;
    /**
     * 密码
     */
    private String password;

    /**
     * name
     */
    private String name;

    /**
     * 验证码
     * verifyCode
     */
    private  String verifyCode;


    /**
     *  必须
     *     国际区号:中国86  马来西亚60
     */
    private String nationCode;


    /**
     * 邀请码
     * inviteCode
     */
    private String inviteCode;

    /**
     *     会员id，被谁邀
     */
    private String inviteUserIdxCode;


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getNationCode() {
        return nationCode;
    }

    public void setNationCode(String nationCode) {
        this.nationCode = nationCode;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public String getInviteUserIdxCode() {
        return inviteUserIdxCode;
    }

    public void setInviteUserIdxCode(String inviteUserIdxCode) {
        this.inviteUserIdxCode = inviteUserIdxCode;
    }
}
