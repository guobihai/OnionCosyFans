package cc.onion.cosyfans.base.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author guobihai
 *
 */
public class StringUtils {

    public static boolean isEmpty(String str) {
        return str == null || str.trim().equals("");
    }


    /**
     * 把字符串内容替换成指定字符串
     * @param contentStr
     * @param fromStr
     * @param toStr
     * @return
     */
    public static String getReplaceAllStr(String contentStr,String fromStr,String toStr) {
        return Pattern.compile(fromStr).matcher(contentStr).replaceAll(toStr);
    }


    /**
     * 复制内容到剪切板
     * @param copyStr
     * @return
     */
    public static boolean copyStr(Context context,String copyStr) {
        try {
            //获取剪贴板管理器
            ClipboardManager cm = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            // 创建普通字符型ClipData
            ClipData mClipData = ClipData.newPlainText("Label", copyStr);
            // 将ClipData内容放到系统剪贴板里。
            cm.setPrimaryClip(mClipData);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 判断字符串是否含有中文
     * @param str
     * @return
     */
    public static boolean isContainChinese(String str) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }


    /**
     * 不以科学计数法显示，并把结果用逗号隔开保留两位小数
     * @param doubleStr
     * @return
     */
    public static String getDoubleFormat(Double doubleStr) {
        if (doubleStr != null) {
            DecimalFormat format = new DecimalFormat("#,##0.00");//不以科学计数法显示，并把结果用逗号隔开保留两位小数
            return format.format(doubleStr);
        }
        return "";
    }


    /**
     * 不以科学计数法显示，正常显示保留两位小数
     * @param doubleStr
     * @return
     */
    public static String getDoubleDecimal(Double doubleStr) {
        if (doubleStr != null) {
            BigDecimal bigDecimal = new BigDecimal(doubleStr);//不以科学计数法显示，正常显示保留两位小数
            return bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        }
        return "";
    }
}
