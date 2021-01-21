package cc.onion.cosyfans.base.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * app版本工具类
 *
 * @Author guobihai
 * @Created 6/19/19
 * @Editor zrh
 * @Edited 6/19/19
 * @Type
 * @Layout
 * @Api
 */
public class AppVersionUtil {

    /**
     * 获取app当前版本
     *
     * @param context
     * @return
     */
    public static String getVersion(Context context) {
        String version = "1.0.0";
        PackageManager pm = context.getPackageManager();
        try {
            PackageInfo info = pm.getPackageInfo(context.getPackageName(), 0);
            if (info != null) {
                version = info.versionName;
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return version;
    }

    /**
     * 获取app当前版本Code
     *
     * @param context
     * @return
     */
    public static int getVersionCode(Context context) {
        int versionCode = 0;
        PackageManager pm = context.getPackageManager();
        try {
            PackageInfo info = pm.getPackageInfo(context.getPackageName(), 0);
            if (info != null) {
                versionCode = info.versionCode;
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }

    /**
     * 格式化版本号
     *
     * @param version
     * @return
     */
    private static int[] parseVersion(String version) {
        String[] versions = version.split("\\.");
        int[] a = new int[versions.length];
        for (int i = 0; i < versions.length; i++) {
            a[i] = Integer.parseInt(versions[i]);
        }
        return a;
    }

    /**
     * 根据VersioName判断是否需要更新
     *
     * @param context
     * @param version 服务器版本
     * @return
     */
    public static boolean needUpdate(Context context, String version) {

        if (version == null) {
            return false;
        }

        version = version.substring(1);

        try {
            String lv = getVersion(context);
            int[] localVersion = parseVersion(lv);
            int[] remoteVersion = parseVersion(version);

            for (int i = 0; i < localVersion.length; i++) {
                if (localVersion[i] > remoteVersion[i]) {
                    return false;
                }
                if (localVersion[i] < remoteVersion[i]) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    /**
     * 根据VersionCode判断是否需要更新
     *
     * @param context
     * @param code
     */
    public static boolean needUpdate(Context context, int code) {
        int localVersionCode = getVersionCode(context);
        return code > localVersionCode;
    }
}
