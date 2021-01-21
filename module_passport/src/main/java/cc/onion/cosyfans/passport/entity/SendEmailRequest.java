package cc.onion.cosyfans.passport.entity;

import cc.onion.cosyfans.base.entity.BaseRequestBean;

/**
 * 邮件发送
 * @author guobihai
 * @date 2019 -11-30
 */
public class SendEmailRequest extends BaseRequestBean {

    /**
     * 邮件发送
     */
    private String email;


    /**
     *     邮件类型 1:找回密码
     */
    private String  emailType  = "1";

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailType() {
        return emailType;
    }

    public void setEmailType(String emailType) {
        this.emailType = emailType;
    }
}
