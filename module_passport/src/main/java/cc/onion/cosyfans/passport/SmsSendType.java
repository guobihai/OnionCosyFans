package cc.onion.cosyfans.passport;

/**
 * 发送短信类型
 */
public interface SmsSendType {

//    1:注册 2:忘记密码 3:登陆时绑定手机号 4:设置中心绑定手机号

    int MSG_REGISTER = 1;


    int MSG_FORGET = 2;

    int MSG_BING_MOBILE = 3;

    int MSG_SETTING = 4;

}
