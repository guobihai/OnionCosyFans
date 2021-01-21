/*
 * 
 */
package cc.onion.cosyfans.base.utils;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.FastDateFormat;

import java.util.Date;

/**
 * @see org.apache.commons.lang3.time.DateFormatUtils
 * 
 * @author zhuangAH
 * @version 1.0
 */
public final class DateFormatUtils extends org.apache.commons.lang3.time.DateFormatUtils {
	
	/** 默认值 */
	private static final String DEFAULT_VALUE = StringUtils.EMPTY;
	
	/** 默认格式yyyy-MM-dd */
	public static final FastDateFormat DEFAULT_FORMAT = ISO_DATE_FORMAT;
	
	/** 常用格式 */
	public static final FastDateFormat USUAL_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd HH:mm");
	
	public static final FastDateFormat FORMAT_DATE = FastDateFormat.getInstance("yyyy-MM-dd");
	public static final FastDateFormat FORMAT_DATE_MONTH = FastDateFormat.getInstance("MM-dd");
	
	/** 年-月-日 时:分:秒.毫秒  yyyy-MM-dd-HH-mm-ss-ff.zzz */
	public static final FastDateFormat FILE_NAME_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd-HH-mm-ss");

	/** 年-月-日 时:分:秒.毫秒  yyyy-MM-dd-HH-mm-ss-ff.zzz */
	public static final FastDateFormat PRINT_TIME_NAME_FORMAT = FastDateFormat.getInstance("yyyy/MM/dd HH:mm:ss");
	/** 年-月-日 时:分:秒.毫秒  yyyy-MM-dd-HH */
	public static final FastDateFormat PRINT_TIME_NAME_FORMAT_ALL = FastDateFormat.getInstance("yyyy/MM/dd");
	/** 时间格式 */
	public static final FastDateFormat TIME_FORMAT = FastDateFormat.getInstance("HH:mm");
	/**月日格式**/
	public static final FastDateFormat MONTH_DAY = FastDateFormat.getInstance("MM/dd");

	public static final FastDateFormat YEARES_MONTH = FastDateFormat.getInstance("yyyy-MM");

	public static final FastDateFormat YYYYMMMMDDHHMMSS = FastDateFormat.getInstance("yyyyMMddHHmmss");

	/**
	 * 不允许实例化
	 */
	private DateFormatUtils() {
	}
	
	/**
	 * 格式化日期
	 * 
	 * @param date 日期
	 * @return
	 */
	public static String format(final Date date) {
		return format(date, DEFAULT_VALUE);
	}
	
	/**
	 * 格式化日期
	 * 
	 * @param date 日期
	 * @param defaultValue 默认值
	 * @return
	 */
	public static String format(final Date date, final String defaultValue) {
		if (date == null) {
			return defaultValue;
		}
		
		return DEFAULT_FORMAT.format(date);
	}
	
	/**
	 * 格式化日期
	 * 
	 * @param date 日期
	 * @param format 格式
	 * @return
	 */
	public static String format(final Date date, final FastDateFormat format) {
		return format(date, DEFAULT_VALUE, format);
	}

	/**
	 * 格式化日期
	 *
	 * @param date 日期
	 * @param format 格式
	 * @return
	 */
	public static String formatOrderDate(final Date date) {
		return format(date, DEFAULT_VALUE, FORMAT_DATE);
	}
	
	/**
	 * 格式化日期
	 * 
	 * @param date 日期
	 * @param defaultValue 默认值
	 * @param format 格式
	 * @return
	 */
	public static String format(final Date date, final String defaultValue, final String format) {
		if (date == null) {
			return defaultValue;
		}
		
		return FastDateFormat.getInstance(format).format(date);
	}
	
	/**
	 * 格式化日期
	 * 
	 * @param date 日期
	 * @param defaultValue 默认值
	 * @param format 格式
	 * @return
	 */
	public static String format(final Date date, final String defaultValue, final FastDateFormat format) {
		if (date == null) {
			return defaultValue;
		}
		
		return format.format(date);
	}
	
	/**
	 * 格式化日期
	 * 
	 * @param date 日期
	 * @param defaultValue 默认值
	 * @return
	 */
	public static String format(final Date date, final Date defaultDate) {
		return DEFAULT_FORMAT.format(date == null ? defaultDate : date);
	}
	
	/**
	 * 格式化日期
	 * 
	 * @param date 日期
	 * @param defaultValue 默认值
	 * @param format 格式
	 * @return
	 */
	public static String format(final Date date, final Date defaultDate, final String format) {
		return FastDateFormat.getInstance(format).format(date == null ? defaultDate : date);
	}
	
	/**
	 * 格式化日期
	 * 
	 * @param date 日期
	 * @param defaultValue 默认值
	 * @param format 格式
	 * @return
	 */
	public static String format(final Date date, final Date defaultDate, final FastDateFormat format) {
		return format.format(date == null ? defaultDate : date);
	}
	
	/**
	 * 格式化日期
	 * 
	 * @param date 日期
	 * @return
	 */
	public static String format(final long date) {
		return format(date, DEFAULT_VALUE);
	}
	
	/**
	 * 格式化日期
	 * 
	 * @param date 日期
	 * @param format 格式
	 * @return
	 */
	public static String format(final long date, final FastDateFormat format) {
		return format(date, DEFAULT_VALUE, format);
	}
	
	/**
	 * 格式化日期
	 * 
	 * @param date 日期
	 * @param defaultValue 默认值
	 * @return
	 */
	public static String format(final long date, final String defaultValue) {
		if (date <= 0) {
			return defaultValue;
		}
		
		return DEFAULT_FORMAT.format(date);
	}
	
	/**
	 * 格式化日期
	 * 
	 * @param date 日期
	 * @param defaultValue 默认值
	 * @param format 格式
	 * @return
	 */
	public static String format(final long date, final String defaultValue, final FastDateFormat format) {
		if (date <= 0) {
			return defaultValue;
		}
		
		return format.format(date);
	}
	
	/**
	 * 格式化日期
	 * 
	 * @param date 日期
	 * @param defaultValue 默认值
	 * @param format 格式
	 * @return
	 */
	public static String format(final long date, final String defaultValue, final String format) {
		if (date <= 0) {
			return defaultValue;
		}
		
		return FastDateFormat.getInstance(format).format(date);
	}
	
	/**
	 * 格式化日期
	 * 
	 * @param date 日期
	 * @param defaultValue 默认值
	 * @return
	 */
	public static String format(final long date, final long defaultDate) {
		return DEFAULT_FORMAT.format(date <= 0 ? defaultDate : date);
	}
	
	/**
	 * 格式化日期
	 * 
	 * @param date 日期
	 * @param defaultValue 默认值
	 * @param format 格式
	 * @return
	 */
	public static String format(final long date, final long defaultDate, final String format) {
		return FastDateFormat.getInstance(format).format(date <= 0 ? defaultDate : date);
	}
	
	/**
	 * 格式化日期
	 * 
	 * @param date 日期
	 * @param defaultValue 默认值
	 * @param format 格式
	 * @return
	 */
	public static String format(final long date, final long defaultDate, final FastDateFormat format) {
		return format.format(date <= 0 ? defaultDate : date);
	}
	
}
