package cc.onion.cosyfans.base.appinfo;

import android.content.Context;
import android.os.Build;


import java.util.Locale;

import cc.onion.cosyfans.base.utils.AppVersionUtil;

/**
 * @Author guobihai
 * @Created 6/21/19
 * @Editor zrh
 * @Edited 6/21/19
 * @Type
 * @Layout
 * @Api
 */
public class AppInfoManager {

    // 服务器返回最新的app版本信息
    private static AppVersion appInfo;
    private static String userAgent;//YJYZERP/1.0.0 (HUAWEI_NXT-AL10; Android 7.0; zh_CN)

    private AppInfoManager() {
    }

    public static AppVersion getLastestAppInfo() {
        return appInfo;
    }

    public static void setLastestAppInfo(AppVersion appInfo) {
        if (appInfo != null)
            AppInfoManager.appInfo = appInfo;
    }

    /**
     * 获取请求使用的useragent
     *
     * @param context
     * @return
     */
    public static String getUserAgent(Context context) {
        if (userAgent == null) {
            StringBuilder stringBuilder = new StringBuilder("YJYZERP");
            String appVersion = AppVersionUtil.getVersion(context);
            String systemVersion = getSystemVersion();
            String systemModel = getSystemModel();
            String language = "zh_CN";
            stringBuilder.append("/")
                    .append(appVersion)
                    .append(" (")
                    .append(systemModel).append("; ")
                    .append("Android ").append(systemVersion).append("; ")
                    .append(language)
                    .append(")");
            userAgent = stringBuilder.toString();
        }

        return userAgent;
    }

    /**
     * 获取系统版本
     *
     * @return 7.0
     */
    public static String getSystemVersion() {
        return Build.VERSION.RELEASE;
    }

    /**
     * 获取手机型号
     *
     * @return HUAWEI_NXT-AL10
     */
    public static String getSystemModel() {
        return Build.MODEL;
    }

    /**
     * 获取语言
     *
     * @return zh_CN
     */
    public static String getSystemLanguage() {
        return Locale.getDefault().getLanguage();
    }
}
