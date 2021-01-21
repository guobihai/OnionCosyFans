package cc.onion.cosyfans.passport.entity;

import cc.onion.cosyfans.base.entity.BaseRequestBean;

/**
 * 找回密码下一步
 * @author anhuifx
 * @email:guobihai@163.com
 *
 */
public class NextVerificationPasswordRequest extends BaseRequestBean {


    /**
     *  手机号:phone;邮箱:email
     */
    private String  accountType;


    /**
     * 验证码
     */
    private String verifyCode;



    private String phone;


    private String  email;


    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


