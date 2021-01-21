package cc.onion.cosyfans.passport.utils;


import java.util.regex.Pattern;

import cc.onion.cosyfans.base.utils.ToastUtil;

/**
 * 字符串检测
 *
 * @Author guobihai
 * @Created 3/15/19
 * @Editor zrh
 * @Edited 3/15/19
 * @Type
 * @Layout
 * @Api
 */
public class StringUtils {

    private static final String isPhone1 = "^1[3456789]\\d{9}$";

    private static final String isPhone2 = "^(86)((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
    // 香港号码
    private static final String isPhone3 = "^([6|9])\\d{7}$";

    // 6-20 位字母+数字 或者特殊符号加数字
    private static final String isPassword = "^((?=.*[a-zA-Z])(?=.*[0-9])|(?=[a-zA-Z])(?=.*[~!@#$%^&*()_+-<>?:\\\"{},./;''\\\\[\\\\]])|(?=.*[0-9])(?=.*[~!@#$%^&*()_+-<>?:\\\"{},./;''\\\\[\\\\]]))[a-zA-Z0-9~!@#$%^&*()_+-<>?:\\\"{},./;''\\\\[\\\\]]{6,20}$";


    public static boolean isEmpty(String str) {
        return str == null || str.equals("");
    }

    public static boolean isPhone(String phone) {
        return getRightPhone(phone) != null;
    }

    /**
     * 严格校验电话号码
     *
     * @param phone
     * @return
     */
    public static boolean isPhoneStrict(String phone) {
        if (!isEmpty(phone)) {
            return Pattern.compile(isPhone1).matcher(phone).matches();
        }

        return false;
    }

    public static boolean isPassword(String password) {

        if (!isEmpty(password)) {
            return Pattern.compile(isPassword).matcher(password).matches();
        }

        return false;
    }

    public static String getRightPhone(String phone) {
        if (phone == null) return null;
        String formatString = phone.replace(" ", "");
        if (isPhoneStrict(formatString)) {
            return formatString;
        }

        return null;
    }

    public static void validatePhone(String phone){
        String rightPhone = getRightPhone(phone);
        if (rightPhone==null){
            ToastUtil.Short("请输入正确手机号");
        }
    }

    public static void validatePassword(String password){
        if (!isPassword(password)){
            ToastUtil.Short("请输入合法密码(6-20位，包含数字 + 字母/特殊符号)");
        }
    }

}
