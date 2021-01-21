package cc.onion.cosyfans.base.utils;

import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @Author guobihai
 * @Created 2019/4/12
 * @Editor lyy
 * @Edited 2019/4/12
 * @Type
 * @Layout
 * @Api
 */
public class TimeUtil {

    private static SimpleDateFormat sDateFormat;

    /**
     * 时间戳转日期
     *
     * @param time    时间戳
     * @param pattern 转换后的格式，例如(yyyy-MM-dd HH:mm:ss)
     */
    public static String longToDate(long time, String pattern) {
        if (time == 0) {
            return "0";
        } else {
            if (String.valueOf(time).length() == 10) {
                time = time * 1000L;
            }
        }
        sDateFormat = new SimpleDateFormat(pattern);
        return sDateFormat.format(new Date(time));
    }

    /**
     * 时间戳转日期
     *
     * @param time 时间戳
     */
    public static String longToDate(long time) {
        return longToDate(time, "yyyy-MM-dd HH:mm");
    }

    /**
     * 时间戳转日期
     *
     * @param time 时间戳
     * @return 字符串 yyyy-MM-dd HH:mm:ss
     */
    public static String longToDateStr(long time) {
        return longToDate(time, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 13位时间戳转日期 可自定义需要的格式(yyyy-MM-dd HH:mm:ss)
     *
     * @param time
     * @return
     */
    public static String timeStampDate(String time, String pattern) {
        if (TextUtils.isEmpty(time)) {
            return "";
        }
        Long timeLong = Long.parseLong(time);
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);//要转换的时间格式
        Date date;
        try {
            date = sdf.parse(sdf.format(timeLong));
            return sdf.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 13位时间戳转日期 例：1556177448120 (2019-04-25)
     *
     * @param time
     * @return
     */
    public static String timeStamp2Date(String time) {
        if (TextUtils.isEmpty(time)) {
            return "";
        }
        Long timeLong = Long.parseLong(time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//要转换的时间格式
        Date date;
        try {
            date = sdf.parse(sdf.format(timeLong));
            return sdf.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 将日期转换为13位时间戳 例：2019-04-25 15:50:30
     */
    public static String dateToStamp(String time) {
        if (TextUtils.isEmpty(time)) {
            return "";
        }
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date;
        try {
            date = simpleDateFormat.parse(time);
            long ts = date.getTime();
            res = String.valueOf(ts);
            return res;
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }

    }

    /**
     * 将日期转换为13位时间戳 例：2019-04-25 15:50:30
     */
    public static String dateToStamp(String time, String pattern) {
        if (TextUtils.isEmpty(time)) {
            return "";
        }
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date;
        try {
            date = simpleDateFormat.parse(time);
            long ts = date.getTime();
            res = String.valueOf(ts);
            return res;
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }

    }

    /**
     * 日期转时间戳
     *
     * @param time    时间字符串
     * @param pattern 格式，例如(yyyy-mm-dd)
     * @return 根据time转换的时间戳
     */
    public static long dateToLong(String time, String pattern) {
        try {
            if (TextUtils.isEmpty(time)) {
                return 0;
            }
            Calendar calendar = Calendar.getInstance();
            sDateFormat = new SimpleDateFormat(pattern);
            Date date = sDateFormat.parse(time);
            calendar.setTime(date);
            return calendar.getTimeInMillis();
        } catch (ParseException e) {
            return 0;
        }
    }

    /**
     * 获取系统当前时间，格式可选择
     *
     * @param pattern 时间格式，例如(yyyy-MM-dd HH:mm:ss)
     */
    public static String getCurrentTime(String pattern) {
        if (TextUtils.isEmpty(pattern)) {
            return "";
        }
        Date date = new Date();
        sDateFormat = new SimpleDateFormat(pattern, Locale.getDefault());
        return sDateFormat.format(date);
    }

    public static String getTimeStr(long time, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(time);
    }

    public static String getTimeStr(long time) {
        return getTimeStr(time, "yyyy-MM-dd HH:mm");
    }

    /**
     * 获取多少天以后的日期
     *
     * @param time    开始时间时间戳
     * @param day     多少天
     * @param pattern 时间格式，例如(yyyy-MM-dd HH:mm:ss)
     */
    public static String getExpectData(long time, int day, String pattern) {
        long lData = day * (24 * 3600 * 1000l);
        long resultData = time + lData;

        return getTimeStr(resultData, pattern);
    }

    /**
     * 获取前n天日期、后n天日期
     *
     * @param distanceDay 前几天 如获取前7天日期则传-7即可；如果后7天则传7
     * @return
     */
    public static String getOldDate(int distanceDay) {
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = new Date();
        Calendar date = Calendar.getInstance();
        date.setTime(beginDate);
        date.set(Calendar.DATE, date.get(Calendar.DATE) + distanceDay);
        Date endDate = null;
        try {
            endDate = dft.parse(dft.format(date.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        KLog.d("前7天==" + dft.format(endDate));
        return dft.format(endDate);
    }

    /**
     * 获取两个日期相差的天数
     */
    public static long getDifferDay(long endTime, long startTime) {
        if (startTime == 0 || endTime == 0) {
            return 0;
        }
        long time = endTime - startTime;
        long day = time / (24 * 3600 * 1000l);

        return day;
    }

    /**
     * 格式化时间
     *
     * @param date
     * @return
     */
    public static String formatTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    /**
     * 比较两个时间的大小,如果开始时间大于结束时间，则返回true
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return
     */
    public static boolean compareTimes(String startTime, String endTime) {
        if (!TextUtils.isEmpty(startTime) && !TextUtils.isEmpty(endTime)) {
            long start = dateToLong(startTime, "yyyy-MM-dd");
            long end = dateToLong(endTime, "yyyy-MM-dd");
            if (start > end) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
