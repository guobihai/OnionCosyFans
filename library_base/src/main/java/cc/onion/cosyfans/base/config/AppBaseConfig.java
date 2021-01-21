package cc.onion.cosyfans.base.config;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * APP的基础配置(域名等)
 *
 * @author guobihai
 * @created 2019-07-02
 */
public class AppBaseConfig {

    private static AppBaseConfig mBaseConfig;
    private Application mApplication;
    private Config mConfig;

    private static SharedPreferences sharedPreferences;

    public static AppBaseConfig get() {
        if (mBaseConfig == null) {
            mBaseConfig = new AppBaseConfig();
        }

        return mBaseConfig;
    }

    public void init(Application application, Config config) {
        this.mApplication = application;
        this.mConfig = config;
        sharedPreferences = application.getSharedPreferences("config", Context.MODE_PRIVATE);
    }

    public void saveString(String key, String value) {
        sharedPreferences.edit().putString(key, value).apply();
    }

    public String loadString(String key) {
        return sharedPreferences.getString(key, null);
    }


    public static class Config {
        private int versionCode; // 版本号
        private String versionName; // 版本名
        private String applicationId; // 应用ID

        private boolean debug; // 是否为debug模式
        private String baseUrl; // 边缘服务API Host
        //根据网站生成的签名数据
        private String apiv;//api版本
        private String appId;//appId
        private String appKey;//appKey
        private String key; //key
        private String devPlatformId; //devPlatformId
        private  String languageType = "en";


        public Config() {

        }

        public Config(int versionCode, String versionName, String applicationId, boolean debug, String baseUrl) {
            this.versionCode = versionCode;
            this.versionName = versionName;
            this.applicationId = applicationId;
            this.debug = debug;
            this.baseUrl = baseUrl;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
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

        public String getDevPlatformId() {
            return devPlatformId;
        }

        public void setDevPlatformId(String devPlatformId) {
            this.devPlatformId = devPlatformId;
        }

        public int getVersionCode() {
            return versionCode;
        }

        public void setVersionCode(int versionCode) {
            this.versionCode = versionCode;
        }

        public String getVersionName() {
            return versionName;
        }

        public void setVersionName(String versionName) {
            this.versionName = versionName;
        }

        public String getApplicationId() {
            return applicationId;
        }

        public void setApplicationId(String applicationId) {
            this.applicationId = applicationId;
        }

        public boolean isDebug() {
            return debug;
        }

        public void setDebug(boolean debug) {
            this.debug = debug;
        }

        public String getBaseUrl() {
            return baseUrl;
        }

        public void setBaseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
        }

        public String getLanguageType() {
            return languageType;
        }

        public void setLanguageType(String languageType) {
            this.languageType = languageType;
        }
    }

    public Config getConfig() {
        return mConfig;
    }

    public void setConfig(Config mConfig) {
        this.mConfig = mConfig;
    }


    public Application getApplication() {
        return mApplication;
    }

}
