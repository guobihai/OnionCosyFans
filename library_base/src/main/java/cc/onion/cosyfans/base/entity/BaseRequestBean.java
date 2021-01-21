package cc.onion.cosyfans.base.entity;

import android.support.annotation.Keep;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import cc.onion.cosyfans.base.config.AppBaseConfig;
import cc.onion.cosyfans.base.utils.DateFormatUtils;
import cc.onion.cosyfans.base.utils.KLog;
import cc.onion.cosyfans.base.utils.MsOnionSecuritySignUtils;
import cc.onion.cosyfans.base.utils.TypeUtils;

/**
 * 接口统一请求参数，所有的请求Body类必须要继承
 * @author anhuifxi
 * @email:guobihai@163.com
 *
 */
public   class BaseRequestBean  {

    Map<String,Object> keyMap = new HashMap<>();


    //api版本
    public String apiv;

    //    平台注册的appId
    public String appId;

    //平台注册的appKey
    public String appKey;

    // 如: cn:中国, hk:中国香港, usa:美国
    public String language;

    //    时间戳，格式：yyyyMMddHHmmss
    public String timestamp;
    //商铺id
    public String shopid;
    public String sign;

    public BaseRequestBean() {
        AppBaseConfig.Config config = AppBaseConfig.get().getConfig();
        this.apiv = config.getApiv();
        this.appId = config.getAppId();
        this.appKey = config.getAppKey();
        this.language = config.getLanguageType();
        this.timestamp = TypeUtils.toLong(DateFormatUtils.format(new Date(), DateFormatUtils.YYYYMMMMDDHHMMSS)).toString();
    }



    /**
     * 获取精确到秒的时间戳
     * @param date
     * @return
     */
    public static int getSecondTimestampTwo(Date date){
        if (null == date) {
            return 0;
        }
        String timestamp = String.valueOf(date.getTime()/1000);
        return Integer.valueOf(timestamp);
    }


    public void setRequestSign(Map<String,Object> request){
        try {
            AppBaseConfig.Config config = AppBaseConfig.get().getConfig();
            //生成秘钥
            keyMap.put("apiv",getApiv());
            keyMap.put("appId",getAppId());
            keyMap.put("appKey",getAppKey());
            keyMap.put("timestamp",timestamp);
            keyMap.put("language",getLanguage());
            this.sign = MsOnionSecuritySignUtils.sign(keyMap,config.getKey());
            request.clear();
            keyMap = null;

        }catch (Exception e){
            KLog.i("test","接口请求基础参数错误堆栈如下：~~~~~~");
            e.printStackTrace();
        }
    }

    public BaseRequestBean(String apiv, String appId, String appKey, String language, String timestamp, String shopId, String sign) {
        this.apiv = apiv;
        this.appId = appId;
        this.appKey = appKey;
        this.language = language;
        this.timestamp = timestamp;
        this.shopid = shopId;
        this.sign = sign;
    }

    public String getApiv() {
        return apiv;
    }

    public void setApiv(String apiv) {
        this.apiv = apiv;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getShopId() {
        return shopid;
    }

    public void setShopId(String shopId) {
        this.shopid = shopId;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Map<String, Object> getKeyMap() {
        return keyMap;
    }

    public void setKeyMap(Map<String, Object> keyMap) {
        this.keyMap = keyMap;
    }

    public void putKeySign(String key,Object value){
        this.keyMap.put(key,value);
    }

    public String getShopid() {
        return shopid;
    }

    public void setShopid(String shopid) {
        this.shopid = shopid;
    }

    /**
     * 签名，手动调用
     */
    public void sign(){
        setRequestSign(getKeyMap());
    }
}

