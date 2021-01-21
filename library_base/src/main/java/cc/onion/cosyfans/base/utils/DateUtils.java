/*
 *
 */
package cc.onion.cosyfans.base.utils;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.view.TimePickerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import cc.onion.cosyfans.base.interfaces.OnTimeSelectCallback;
import cc.onion.cosyfans.library_base.R;

/**
 * @see org.apache.commons.lang3.time.DateUtils
 *
 * <p>日期工具类
 *
 * @author zhuangAh
 * @version 1.0
 */
public final class DateUtils extends org.apache.commons.lang3.time.DateUtils {

	/** 1周的天数 */
	private static final int DAYS_IN_A_WEEK = 7;

	/** 1季的月数 */
	private static final int MONTHS_IN_A_SEASON = 3;

	/**
	 * 不允许实例化
	 */
	private DateUtils() {
	}

	/**
	 * @return 今天起始秒
	 */
	public static Date getFirstSecondOfToday() {
		return getFirstSecondOfTheDayReturnCalendar(null).getTime();
	}

	/**
	 * @return 今天结束秒
	 */
	public static Date getLastSecondOfToday() {
		// 今天起始秒
		Calendar calendar = getFirstSecondOfTheDayReturnCalendar(null);
		// 加1天
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		// 减1毫秒
		calendar.add(Calendar.MILLISECOND, -1);
		return calendar.getTime();
	}

	/**
	 * @return 本周起始秒
	 */
	public static Date getFirstSecondOfThisWeek() {
		return getFirstSecondOfThisWeekReturnCalendar().getTime();
	}

	/**
	 * @return 本周结束秒
	 */
	public static Date getLastSecondOfThisWeek() {
		// 本周起始秒
		Calendar calendar = getFirstSecondOfThisWeekReturnCalendar();
		// 加1周
		calendar.add(Calendar.DAY_OF_WEEK, DAYS_IN_A_WEEK);
		// 减1毫秒
		calendar.add(Calendar.MILLISECOND, -1);
		return calendar.getTime();
	}

	/**
	 * <p>认为周一为本周第1天
	 *
	 * @return 本周起始秒
	 */
	private static Calendar getFirstSecondOfThisWeekReturnCalendar() {
		// 今天起始秒
		Calendar calendar = getFirstSecondOfTheDayReturnCalendar(null);
		// 减去周
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		calendar.add(Calendar.DAY_OF_WEEK, -dayOfWeek + 2);
		return calendar;
	}

	/**
	 * @return 本月起始秒
	 */
	public static Date getFirstSecondOfThisMonth() {
		return getFirstSecondOfThisMonthReturnCalendar().getTime();
	}

	/**
	 * @return 本月结束秒
	 */
	public static Date getLastSecondOfThisMonth() {
		// 本月起始秒
		Calendar calendar = getFirstSecondOfThisMonthReturnCalendar();
		// 加1月
		calendar.add(Calendar.MONTH, 1);
		// 减1毫秒
		calendar.add(Calendar.MILLISECOND, -1);
		return calendar.getTime();
	}

	/**
	 * 根据日期获取月份的头一秒
	 * @param date
	 * @return
     */
	public static Date getFirstofThisMonthTime(Date date){
		return  getFirstSecondOfThisMonthReturnCalendar(date).getTime();

	}

	/**
	 * @return 根据日期的月结束秒
	 */
	public static Date getLastSecondOfThisMonthTime(Date date) {
		// 本月起始秒
		Calendar calendar = getFirstSecondOfThisMonthReturnCalendar(date);
		// 加1月
		calendar.add(Calendar.MONTH, 1);
		// 减1毫秒
		calendar.add(Calendar.MILLISECOND, -1);
		return calendar.getTime();
	}

	/**
	 * @return 本月起始秒
	 */
	private static Calendar getFirstSecondOfThisMonthReturnCalendar() {
		// 今天起始秒
		Calendar calendar = getFirstSecondOfTheDayReturnCalendar(null);
		// 起始本月的天
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.add(Calendar.DAY_OF_MONTH, -dayOfMonth + 1);
		return calendar;
	}

	/**
	 * @return 本月起始秒
	 */
	private static Calendar getFirstSecondOfThisMonthReturnCalendar(Date date) {
		// 今天起始秒
		Calendar calendar = getFirstSecondOfTheDayReturnCalendar(date);
		// 起始本月的天
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.add(Calendar.DAY_OF_MONTH, -dayOfMonth + 1);
		return calendar;
	}

	/**
	 * @return 本季起始秒
	 */
	public static Date getFirstSecondOfThisSeason() {
		return getLastSecondOfThisSeasonReturnCalendar().getTime();
	}

	/**
	 * @return 本季结束秒
	 */
	public static Date getLastSecondOfThisSeason() {
		// 本季起始秒
		Calendar calendar = getLastSecondOfThisSeasonReturnCalendar();
		// 加1季
		calendar.add(Calendar.MONTH, MONTHS_IN_A_SEASON);
		// 减1毫秒
		calendar.add(Calendar.MILLISECOND, -1);
		return calendar.getTime();
	}

	/**
	 * @return 本年结束秒
	 */
	private static Calendar getLastSecondOfThisSeasonReturnCalendar() {
		// 今天起始秒
		Calendar calendar = getFirstSecondOfThisMonthReturnCalendar();
		// 起始本月的天
		int month = calendar.get(Calendar.MONTH);
		calendar.add(Calendar.MONTH, month % MONTHS_IN_A_SEASON);
		return calendar;
	}

	/**
	 * @return 本年起始秒
	 */
	public static Date getFirstSecondOfThisYear() {
		return getFirstSecondOfThisYearReturnCalendar().getTime();
	}

	/**
	 * @return 本年结束秒
	 */
	public static Date getLastSecondOfThisYear() {
		// 本年结束秒
		Calendar calendar = getFirstSecondOfThisYearReturnCalendar();
		// 加1年
		calendar.add(Calendar.YEAR, 1);
		// 减1毫秒
		calendar.add(Calendar.MILLISECOND, -1);
		return calendar.getTime();
	}

	/**
	 * @return 本年结束秒
	 */
	private static Calendar getFirstSecondOfThisYearReturnCalendar() {
		// 今天起始秒
		Calendar calendar = getFirstSecondOfTheDayReturnCalendar(null);
		// 起始本月的天
		int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
		calendar.add(Calendar.DAY_OF_YEAR, -dayOfYear + 1);
		return calendar;
	}

	/**
	 * @return 获取该天的起始秒
	 */
	public static Date getFirstSecondOfTheDay(Date day) {
		return getFirstSecondOfTheDayReturnCalendar(day).getTime();
	}

	/**
	 * @return 获取该天的结束秒
	 */
	public static Date getLastSecondOfTheDay(Date day) {
		Calendar calendar = getFirstSecondOfTheDayReturnCalendar(day);
		// 加1天
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		// 减1毫秒
		calendar.add(Calendar.MILLISECOND, -1);
		return calendar.getTime();
	}

	/**
	 *
	 * @param day
	 * @return 获取昨天的起始秒
     */
	public static Date getStartYearesTheDay(Date day){
		 return  getYearsSecondOfTheDayReturnCalendar(day).getTime();
	}

	/**
	 *
	 * @param day
	 * @return 昨天最后一秒
     */
	public static Date getLastYearesTheDay(Date day){
		Calendar calendar = getYearsSecondOfTheDayReturnCalendar(day);
		// 加1天
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		// 减1毫秒
		calendar.add(Calendar.MILLISECOND, -1);
		return calendar.getTime();
	}

	/**
	 * 如果day == null，则默认为今天
	 *
	 * @return 获取该天的起始秒
	 */
	private static Calendar getFirstSecondOfTheDayReturnCalendar(Date day) {
		Calendar calendar = Calendar.getInstance();
		if (day != null) {
			calendar.setTime(day);

		}
		// 当前时间的时、分、秒、毫秒
		int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		int millisecond = calendar.get(Calendar.MILLISECOND);
		// 减去时、分、秒、毫秒
		calendar.add(Calendar.HOUR_OF_DAY, -hourOfDay);
		calendar.add(Calendar.MINUTE, -minute);
		calendar.add(Calendar.SECOND, -second);
		calendar.add(Calendar.MILLISECOND, -millisecond);
		return calendar;
	}
	/**
	 *
	 * @return 获取昨天的起始秒
	 */
	private static Calendar getYearsSecondOfTheDayReturnCalendar(Date day) {
		Calendar calendar = Calendar.getInstance();
		if (day != null) {
			calendar.setTime(day);
			calendar.add(calendar.DATE, -1);//把日期往后增加一天.整数往后推,负数往前移动

		}

		// 当前时间的时、分、秒、毫秒
		int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		int millisecond = calendar.get(Calendar.MILLISECOND);
		// 减去时、分、秒、毫秒
		calendar.add(Calendar.HOUR_OF_DAY, -hourOfDay);
		calendar.add(Calendar.MINUTE, -minute);
		calendar.add(Calendar.SECOND, -second);
		calendar.add(Calendar.MILLISECOND, -millisecond);
		return calendar;
	}


	/**
	 * 获取前一天的日期
	 * @param day
	 * @return
	 */
	public static Calendar getTomorrowDay(Date day, int dayCount) {
		Calendar calendar = Calendar.getInstance();
		if (day != null) {
			calendar.setTime(day);
			calendar.add(calendar.DATE,  -dayCount);//

		}
		return calendar;
	}



	/**
	 * 获取七天内的数据，当天日期往前推
	 * @param day
	 * @return
     */
	public static Calendar getWeekSecondOfTheDayReturnCalendar(Date day, int count) {
		Calendar calendar = Calendar.getInstance();
		if (day != null) {
			calendar.setTime(day);
			calendar.add(calendar.DATE, count);//把日期往后增加一天.整数往后推,负数往前移动

		}
		// 当前时间的时、分、秒、毫秒
		int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		int millisecond = calendar.get(Calendar.MILLISECOND);
		// 减去时、分、秒、毫秒
		calendar.add(Calendar.HOUR_OF_DAY, -hourOfDay);
		calendar.add(Calendar.MINUTE, -minute);
		calendar.add(Calendar.SECOND, -second);
		calendar.add(Calendar.MILLISECOND, -millisecond);
		return calendar;
	}

	/**
	 * @return 本周起始秒
	 */
	public static Date getWeekFristSecondOfThis(Date date, int count) {
		return getWeekSecondOfTheDayReturnCalendar(date,count).getTime();
	}


	/**
	 *
	 * @param day
	 * @return 获取月份的每一天的起始秒
	 */
	public static Date getStartMonthEveryTheDay(Date day, int i ){
		return  getMonthCountOfTheDayReturnCalendar(day, i).getTime();
	}



	/**
	 * 获取月份的每一天的第一秒钟
	 * @param day
	 * @param i
     * @return
     */
	public  static Calendar getMonthCountOfTheDayReturnCalendar(Date day, int i) {
		Calendar calendar = Calendar.getInstance();
		if (day != null) {
			calendar.setTime(day);
			calendar.add(calendar.DATE, i);//把日期往后增加一天.整数往后推,负数往前移动

		}
		// 当前时间的时、分、秒、毫秒
		int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		int millisecond = calendar.get(Calendar.MILLISECOND);
		// 减去时、分、秒、毫秒
		calendar.add(Calendar.HOUR_OF_DAY, -hourOfDay);
		calendar.add(Calendar.MINUTE, -minute);
		calendar.add(Calendar.SECOND, -second);
		calendar.add(Calendar.MILLISECOND, -millisecond);
		return calendar;
	}


	/*
	 * 获取当前时间
	 */
	public static Date getDate() {
		return new Date();
	}

	/**
	 * 根据日期获取当前月的天数
	 *
	 * @param startDate
	 * @return
	 */
	public static int getMaxDayCount(Date startDate) {
		Calendar calendar = new GregorianCalendar();
		calendar.clear();
		calendar.setTime(startDate); //放入你的日期
		int maximum = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		return maximum;
	}
	public static Date format(String stringDate, String moudle){
		SimpleDateFormat sdf = new SimpleDateFormat(moudle);
		Date date = null;
		try {
			date = sdf.parse(stringDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}


	private final static SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
	private final static SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");;
	/**
	 * 当前季度的开始时间，即2012-01-1 00:00:00
	 *jll
	 * @return
	 */
	public static Date getCurrentQuarterStartTime() {
		Calendar c = Calendar.getInstance();
		int currentMonth = c.get(Calendar.MONTH) + 1;
		Date now = null;
		try {
			if (currentMonth >= 1 && currentMonth <= 3)
				c.set(Calendar.MONTH, 0);
			else if (currentMonth >= 4 && currentMonth <= 6)
				c.set(Calendar.MONTH, 3);
			else if (currentMonth >= 7 && currentMonth <= 9)
				c.set(Calendar.MONTH, 6);
			else if (currentMonth >= 10 && currentMonth <= 12)
				c.set(Calendar.MONTH, 9);
			c.set(Calendar.DATE, 1);
			now = longSdf.parse(shortSdf.format(c.getTime()) + " 00:00:00");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}
	/**
	 * 当前季度的结束时间，即2012-03-31 23:59:59
	 *jll
	 * @return
	 */
	public static Date getCurrentQuarterEndTime() {
		Calendar c = Calendar.getInstance();
		int currentMonth = c.get(Calendar.MONTH) + 1;
		Date now = null;
		try {
			if (currentMonth >= 1 && currentMonth <= 3) {
				c.set(Calendar.MONTH, 2);
				c.set(Calendar.DATE, 31);
			} else if (currentMonth >= 4 && currentMonth <= 6) {
				c.set(Calendar.MONTH, 5);
				c.set(Calendar.DATE, 30);
			} else if (currentMonth >= 7 && currentMonth <= 9) {
				c.set(Calendar.MONTH, 8);
				c.set(Calendar.DATE, 30);
			} else if (currentMonth >= 10 && currentMonth <= 12) {
				c.set(Calendar.MONTH, 11);
				c.set(Calendar.DATE, 31);
			}
			now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}



	/**
	 *根據日期獲得星期
	 * @authorＱＣ班長
	 * @param sDate yyyy-MM-dd
	 * @return當前日期是星期幾
	 */
	public static String getFullDateWeekTime(String sDate){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );
			Date date=sdf.parse(sDate);
			SimpleDateFormat format = new SimpleDateFormat( "EEEE" );
			return format.format(date);
		} catch (Exception ex){
			System. out .println( "TimeUtil getFullDateWeekTime Error:" +ex.getMessage());
			return "" ;
		}
	}


	/**
	 * 时间选择器 精确到时间
	 * @param activity
	 * @param onTimeSelectListener
	 */
	public static TimePickerView showTimePicker(Activity activity, boolean isCurrentTm, OnTimeSelectCallback onTimeSelectListener) {
		TimePickerView pickerViewTime;
		Calendar selectedDate = Calendar.getInstance();// 系统当前时间
		Calendar startDate = Calendar.getInstance();
		startDate.set(1970, 1, 1);
		Calendar endDate = Calendar.getInstance();
		if (isCurrentTm) endDate.setTime(getDate());
			else endDate.set(2037, 2, 28);

        pickerViewTime = new TimePickerBuilder(activity, (date, view)->{
					onTimeSelectListener.onTimeSelect(date,view);
				})
				.setLayoutRes(R.layout.base_picker_custom, v -> {

					// 获取自定义布局里面的控件
					TextView tvTitle = v.findViewById(R.id.tv_picker_title); // 标题文本
					View vok = v.findViewById(R.id.rl_picker_ok); // 确定
					vok.setOnClickListener(v1 -> {

                        onTimeSelectListener.clickConfirmButton();

//						pickerViewTime.returnData();
//						pickerViewTime.dismiss();
					});
				})
				.setDate(selectedDate)
				.setRangDate(startDate, endDate)
				.setType(new boolean[]{true, true, true, true, true, false})
				.setLabel("年", "月", "日", "时", "分", "")
				// 设置滚轮文字大小
				.setContentTextSize(16)
				// 设置选中文字颜色
				.setTextColorCenter(ContextCompat.getColor(activity, R.color.theme))
				// 设置未选中文字颜色
				.setTextColorOut(ContextCompat.getColor(activity, R.color.light_grey))
				// 解决PickerView被虚拟按键遮挡的问题
				.setDecorView(activity.getWindow().getDecorView().findViewById(android.R.id.content))
                .build();

        pickerViewTime.show();

		return pickerViewTime;
	}

}
