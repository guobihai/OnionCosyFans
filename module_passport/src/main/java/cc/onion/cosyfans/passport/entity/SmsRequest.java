package cc.onion.cosyfans.passport.entity;

import cc.onion.cosyfans.base.entity.BaseRequestBean;

/**
 * 发送短信请求类
 * @author guobihai
 * @date  2019-11-30
 */
public class SmsRequest extends BaseRequestBean {

   private String phone;

    /**
     * 1:注册 2:忘记密码 3:登陆时绑定手机号 4:设置中心绑定手机号
     */
   private String smsType;

    /**
     * 马来:60 中国:86
     */
   private String nationCode;

    public String getNationCode() {
        return nationCode;
    }

    public void setNationCode(String nationCode) {
        this.nationCode = nationCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSmsType() {
        return smsType;
    }

    public void setSmsType(String smsType) {
        this.smsType = smsType;
    }
}
