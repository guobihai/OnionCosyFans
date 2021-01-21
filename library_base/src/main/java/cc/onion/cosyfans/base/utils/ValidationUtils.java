/*
 * 
 */
package cc.onion.cosyfans.base.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

/**
 * Utils - 校验
 * 
 * @author guobihai
 * @version 1.0
 */
public final class ValidationUtils {

	/** 手机号码正则表达式 */
//	private static final Pattern MOBILE_PATTERN = Pattern.compile("^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$");
	private static final Pattern MOBILE_PATTERN = Pattern.compile("^(\\d{11}|0{2}\\d{11})$");

	/** 邮箱正则表达式 */
	private static final Pattern EMAIL_PATTERN = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

	//标题正则

	private static final Pattern TITLE_TAG = Pattern.compile("^[a-zA-Z0-9\\s\\u4e00-\\u9fa5]+$");
	/**
	 * 不允许实例化
	 */
	private ValidationUtils() {
	}
	
	/**
	 * 校验是否为合法手机号码
	 * 
	 * @param mobile 手机号码
	 * @return
	 */
	public static boolean isMobile(String mobile) {
		if (StringUtils.isBlank(mobile)) {
			return false;
		}

		//判断由多位数字
		if(mobile.length() == 12){
			return false;
		}
		
		return MOBILE_PATTERN.matcher(mobile).matches();
	}

	/**
	 * 检查标题是否合法
	 * @param title
	 * @return
	 */
	public static boolean checkTitle(String title) {
		if (StringUtils.isBlank(title)) {
			return false;
		}

		return TITLE_TAG.matcher(title).matches();
	}

	/**
	 * 校验是否为合法邮箱
	 * 
	 * @param email 邮箱
	 * @return
	 */
	public static boolean isEmail(String email) {
		if (StringUtils.isBlank(email)) {
			return false;
		}
		
		return EMAIL_PATTERN.matcher(email).matches();
	}
	
}
