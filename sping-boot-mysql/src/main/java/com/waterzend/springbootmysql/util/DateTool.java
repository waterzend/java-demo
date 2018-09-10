package com.waterzend.springbootmysql.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


public class DateTool {

    // 日志对象
    private static final Log log = LogFactory.getLog(DateTool.class);

    // 日期格式化对象,日期型（yyyy-MM-dd）
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    // 日期时间格式化对象,日期时间型（yyyy-MM-dd HH:mm:ss）
    private static final SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final SimpleDateFormat dateTimeFormat_B = new SimpleDateFormat("yyyyMMddHHmmss");

    /**
     * 日期格式:yyyy-mm-dd<br>
     * 例如:2005-11-02
     */
    public final static String DATE_PATTERN_LINE = "yyyy-MM-dd";

    /**
     * 日期格式:yyyy/mm/dd<br>
     * 例如:2005/11/02
     */
    public final static String DATE_PATTERN_BIAS = "yyyy/MM/dd";

    /**
     * 日期格式:yyyymmdd<br>
     * 例如:20051102
     */
    public final static String DATE_PATTERN_NOCHAR = "yyyyMMdd";
    /**
     * 日期时间格式(24小时制):yyyy-mm-dd HH:mm:ss<br>
     * 例如:2005-11-02 23:01:01
     */
    public final static String DATETIME24_PATTERN_LINE = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期时间格式(12小时制):yyyy-mm-dd hh:mm:ss<br>
     * 例如:2005-11-02 11:01:01
     */
    public final static String DATETIME12_PATTERN_LINE = "yyyy-MM-dd hh:mm:ss";

    /**
     * 日期时间格式(24小时制):yyyy/mm/dd HH:mm:ss<br>
     * 例如:2005/11/02 23:01:01
     */
    public final static String DATETIME24_PATTERN_BIAS = "yyyy/MM/dd HH:mm:ss";

    /**
     * 日期时间格式(12小时制):yyyy/mm/dd hh:mm:ss<br>
     * 例如:2005/11/02 11:01:01
     */
    public final static String DATETIME12_PATTERN_BIAS = "yyyy/MM/dd hh:mm:ss";
    /**
     * 日期时间格式(24小时制):yyyymmddHHmmss<br>
     * 例如:20151102230101
     */
    public final static String DATETIME24_PATTERN_BIAS_B = "yyyyMMddHHmmss";

    // 静态初始化时区
    static {
        // 中国时区
        TimeZone tzChina = TimeZone.getTimeZone("Asia/Chongqing");
        DateTool.dateTimeFormat.setTimeZone(tzChina);
    }

    /**
     * 根据指定的格式化模式,格式化日历数据<br>
     * 默认使用yyyy-MM-dd HH:mm:ss
     *
     * @param now 给定日期
     * @return 被格式化后的字符串
     */
    public static String formatDate(java.util.Calendar now) {
        return formatDate(now, DATETIME24_PATTERN_LINE);
    }

    /**
     * 根据指定的格式化模式,格式化日历数据<br>
     * 如果格式化模式为null或者为空,则默认使用yyyy-MM-dd HH:mm:ss
     *
     * @param now            给定日期
     * @param formatePattern 格式化模式
     * @return 被格式化后的字符串<br>
     */
    public static String formatDate(java.util.Calendar now, String formatePattern) {
        if (now == null) {
            return null;
        }
        if (formatePattern == null || formatePattern.trim().length() <= 0) {
            formatePattern = DATETIME24_PATTERN_LINE;
        }
        java.util.Date tempDate = now.getTime();
        SimpleDateFormat dateFormate = new SimpleDateFormat(formatePattern);
        return dateFormate.format(tempDate);
    }

    /**
     * 将java.util.Date数据转换为指定格式的字符串<br>
     * 如果格式化模式为null或者为空,则默认使用yyyy-MM-dd HH:mm:ss
     *
     * @param date           java.util.Date类型数据
     * @param formatePattern 指定的日期格式化模式
     * @return 格式化后的日期的字符串形式<br>
     */
    public static String formatDate(java.util.Date date, String formatePattern) {
        if (formatePattern == null || formatePattern.trim().length() <= 0) {
            formatePattern = DATETIME24_PATTERN_LINE;
        }
        if (date == null) {
            return "";
        } else {
            SimpleDateFormat dateFormate = new SimpleDateFormat(formatePattern);
            return dateFormate.format(date);
        }
    }

    /**
     * 将java.util.Date数据转换为指定格式的字符串<br>
     * 如果格式化模式为null或者为空,则默认使用yyyy-MM-dd HH:mm:ss
     *
     * @param date java.util.Date类型数据
     * @return 格式化后的日期的字符串形式<br>
     */
    public static String formatDateTime(java.util.Date date) {
        return formatDate(date, DATETIME24_PATTERN_LINE);
    }

    /**
     * 将java.util.Date数据转换为指定格式的字符串<br>
     * 如果格式化模式为null或者为空,则默认使用yyyy-MM-dd
     *
     * @param date java.util.Date类型数据
     * @return 格式化后的日期的字符串形式<br>
     */
    public static String formatDate(java.util.Date date) {
        return formatDate(date, DATE_PATTERN_LINE);
    }

    /**
     * 将代表日期的长整形数值转换为yyyy-MM-dd HH:mm:ss格式的字符串<br>
     *
     * @param datetime 需要转换的日期的长整形数值
     * @return 格式化后的日期字符串
     */
    public static String formatDate(long datetime) {
        return formatDate(datetime, DATETIME24_PATTERN_LINE);
    }

    /**
     * 将代表日期的字符串转换yyyy-MM-dd HH:mm:ss格式的字符串
     *
     * @param datetime 需要转换的日期
     * @return 格式化后的日期字符串
     */
    public static String formate(String datetime) {
        return formatDate(datetime, DATETIME24_PATTERN_LINE);
    }

    /**
     * 将代表日期的字符串转换yyyy-MM-dd格式的字符串
     *
     * @param datetime 需要转换的日期
     * @return 格式化后的日期字符串
     */
    public static String formatDate(String datetime) {
        return formatDate(datetime, DATE_PATTERN_LINE);
    }

    /**
     * 将代表日期的字符串转换未指定格式的字符串<br>
     * 如果格式化模式为null或者为空,则默认使用yyyy-MM-dd HH:mm:ss
     *
     * @param datetime       需要转换的日期的字符串
     * @param formatePattern 指定的日期格式
     * @return 格式化后的日期字符串
     */
    public static String formatDate(String datetime, String formatePattern) {
        if (datetime == null || datetime.trim().length() <= 0) {
            return "";
        }
        try {
            Date date = parseDate(datetime);
            return formatDate(date, formatePattern);
        } catch (Exception ex) {
            log.error("日期转换失败:", ex);
            throw new RuntimeException("日期转换失败:", ex);
        }
    }

    /**
     * 将代表日期的长整形数值转换为y指定格式的字符串<br>
     * 如果格式化模式为null或者为空,则默认使用yyyy-MM-dd HH:mm:ss
     *
     * @param datetime       需要转换的日期的长整形数值
     * @param formatePattern 指定的日期格式
     * @return 格式化后的日期字符串
     */
    public static String formatDate(long datetime, String formatePattern) {
        if (datetime <= 0) {
            return "";
        }
        try {
            Date date = new Date(datetime);
            return formatDate(date, formatePattern);
        } catch (Exception ex) {
            log.error("日期转换失败:", ex);
            throw new RuntimeException("日期转换失败:", ex);
        }
    }

    /**
     * 将java.sql.Date数据转换为指定格式的字符串<br>
     * 默认使用yyyy-MM-dd HH:mm:ss
     *
     * @param date java.sql.Date类型数据
     * @return 格式化后的日期的字符串形式<br>
     */
    public static String formatDate(java.sql.Date date) {
        return formatDate(toUtilDate(date));
    }

    /**
     * 将java.sql.Date转换为java.util.Date数据类型
     *
     * @param date 需要转换的java.sql.Date数据
     * @return 转换后的java.util.Date数据
     */
    public static java.util.Date toUtilDate(java.sql.Date date) {
        if (date == null) {
            return null;
        } else {
            return new java.util.Date(date.getTime());
        }
    }

    /**
     * 得到当前系统日期时间 yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static java.util.Date getCurrentTime() {
        return new java.util.Date(System.currentTimeMillis());
    }

    /**
     * 得到当前系统日期
     *
     * @return 得到系统当前日期 yyyy-MM-dd
     */
    public static java.util.Date getCurrentDate() {
        return parseDate(formatDate(getCurrentTime()));
    }

    /**
     * 得到当前系统日期字符串
     *
     * @return 得到系统当前日期 yyyy-MM-dd
     */
    public static java.lang.String getCurrentDateStr() {
        return formatDate(getCurrentTime(), DATE_PATTERN_LINE);
    }

    /**
     * 根据指定的格式，获取当前系统日期字符串
     *
     * @param pattern 字符串格式
     * @return 得到系统当前日期
     */
    public static java.lang.String getCurrentDateStr(String pattern) {
        return formatDate(getCurrentTime(), pattern);
    }

    /**
     * 得到当前系统时间字符串
     *
     * @return 得到系统当前日期 yyyy-MM-dd HH:mm:ss
     */
    public static String getCurrentTimeStr() {
        return formatDate(getCurrentTime(), DATETIME24_PATTERN_LINE);
    }

    /**
     * 将字符串转化为日期型数据<br>
     * 字符串必须是yyyy-MM-dd格式
     *
     * @param src 日期数据字符串
     * @return java.util.Date型日期类型数据
     */
    public static java.util.Date parseDate(String src) {
        if (src == null || src.trim().length() <= 0) {
            return null;
        }
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.parse(src);
        } catch (Exception pe) {
            throw new RuntimeException(pe);
        }
    }

    public static Date parseDate(String src, String formate) {
        if (src == null || src.trim().length() <= 0) {
            return null;
        }
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(formate);
            return dateFormat.parse(src);
        } catch (Exception pe) {
            throw new RuntimeException(pe);
        }
    }

    /**
     * 将字符串转化为日期型数据<br>
     * 字符串必须是yyyy-MM-dd HH:mm:ss格式
     *
     * @param src 日期数据字符串
     * @return java.util.Date型日期时间型数据
     */
    public static java.util.Date parseDateTime(String src) {
        try {
            SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return dateTimeFormat.parse(src);
        } catch (Exception pe) {
            throw new RuntimeException(pe);
        }
    }

    /**
     * 解析Date，字符串必须是yyyy-MM-dd HH:mm:ss格式
     *
     * @param src 日期数据字符串
     * @return
     */
    public static Date parseAllDate(String src) {
        try {
            if (src == null || src.equals(""))
                return null;
            if (src.length() == 10) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                return dateFormat.parse(src);
            } else if (src.length() == 14) {
                SimpleDateFormat dateTimeFormat_B = new SimpleDateFormat("yyyyMMddHHmmss");
                return dateTimeFormat_B.parse(src);
            } else if (src.length() == 19) {
                SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                return dateTimeFormat.parse(src);
            } else if (src.length() > 19) {
                SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                src = src.substring(0, 19);
                return dateTimeFormat.parse(src);
            } else {
                throw new RuntimeException("长度不符。日期格式为:yyyy-mm-dd:,时间格式为:yyyy-mm-dd hh:mi:ss");
            }

        } catch (Exception pe) {
            throw new RuntimeException(pe);
        }
    }

    /**
     * 解析Date，判断是否符合date
     *
     * @param src 日期数据字符串
     * @return
     */
    public static boolean isDateStr(String src) {
        try {
            if (src == null || src.equals(""))
                return false;
            src = src.trim();
            if (src.length() == 10) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dateFormat.parse(src);
                return true;
            } else if (src.length() == 14) {
                SimpleDateFormat dateTimeFormat_B = new SimpleDateFormat("yyyyMMddHHmmss");
                dateTimeFormat_B.parse(src);
                return true;
            } else if (src.length() == 19) {
                SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                dateTimeFormat.parse(src);
                return true;
            } else if (src.length() > 19) {
                src = src.substring(0, 19);
                SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                dateTimeFormat.parse(src);
                return true;
            } else {
                return false;
            }
        } catch (Exception pe) {
            return false;
        }
    }

    /**
     * 将java.util.Date转换为java.sql.Date数据类型
     *
     * @param date 需要转换的java.util.Date数据
     * @return 转换后的java.sql.Date数据
     */
    public static java.sql.Date toSqlDate(java.util.Date date) {
        if (date == null) {
            return null;
        } else {
            return new java.sql.Date(date.getTime());
        }
    }

    /**
     * 得到指定年月的最后一天
     *
     * @param year  指定年
     * @param month 指定月
     * @return 指定年月的最后一天
     */
    public static java.util.Date getMonthLastDay(int year, int month) {
        if (month >= 1 && month <= 12) {
            Calendar lCal = Calendar.getInstance();
            lCal.set(year, month, 1);
            lCal.add(Calendar.DATE, -1);
            return lCal.getTime();
        } else {
            throw new RuntimeException("月份传入错误必须介于1和12之间");
        }
    }

    /**
     * 得到指定年月的第一天
     *
     * @param year  指定年
     * @param month 指定月
     * @return 指定年月的第一天
     */
    @SuppressWarnings("deprecation")
    public static java.util.Date getMonthFirstDay(int year, int month) {
        if (month >= 1 && month <= 12) {
            return new Date(year - 1900, month - 1, 1, 0, 0, 0);
        } else {
            throw new RuntimeException("月份传入错误必须介于1和12之间");
        }
    }

    /**
     * 得到指定年月的最后一天的最后小时分秒
     *
     * @param year  指定年
     * @param month 指定月
     * @return 年月的最后一天的最后小时分秒
     */
    public static java.util.Date getMonthLastDatetime(int year, int month) {
        if (month >= 1 && month <= 12) {
            Calendar lCal = Calendar.getInstance();
            lCal.set(year, month, 1, 23, 59, 59);
            lCal.add(Calendar.DATE, -1);
            return lCal.getTime();
        } else {
            throw new RuntimeException("月份传入错误必须介于1和12之间");
        }
    }

    public static Date getDateAfter(String sdate, int day) {
        Date date = parseDate(sdate);

        if (date != null) {
            Calendar lCal = Calendar.getInstance();
            lCal.setTime(date);
            lCal.add(Calendar.DAY_OF_MONTH, day);
            return lCal.getTime();
        } else {
            return new Date();
        }
    }

    /**
     * 得到指定年月的第一天的开始小时分秒
     *
     * @param year  指定年
     * @param month 指定月
     * @return 年月的第一天的开始小时分秒
     */
    @SuppressWarnings("deprecation")
    public static java.util.Date getMonthFirstDatetime(int year, int month) {
        if (month >= 1 && month <= 12) {
            return new Date(year - 1900, month - 1, 1, 0, 0, 0);
        } else {
            throw new RuntimeException("月份传入错误必须介于1和12之间");
        }
    }

    /**
     * 得到指定日期所在周的指定星期几的日期
     *
     * @param date      指定日期
     * @param dayOfWeek 指定星期几
     * @return 指定星期几的日期
     */
    public static Date getDateOfWeek(Date date, int dayOfWeek) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, dayOfWeek);
        return c.getTime();
    }

    /**
     * 得到指定日期为当前年的第几周
     *
     * @param date 指定日期
     * @return 当前年的第几周
     */
    public static int getWeekOfYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 得到指定年的第几周的第一天日期
     *
     * @param year  指定年
     * @param nWeek 第几周
     * @return 第一天日期
     */
    public static Date getWeekOfFirstDate(int year, int nWeek) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.WEEK_OF_YEAR, nWeek);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek());
        return c.getTime();
    }

    /**
     * 得到指定年的第几周的最后一天日期
     *
     * @param year  指定年
     * @param nWeek 第几周
     * @return 最后一天日期
     */
    public static Date getWeekOfLastDate(int year, int nWeek) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.WEEK_OF_YEAR, nWeek);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6);
        return c.getTime();
    }

    /**
     * 得到当前年
     *
     * @return 当前年
     */
    public static int getCurrentYear() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.YEAR);
    }

    /**
     * 得到当前月<br>
     * 0:一月;1:二月;....;11:十二月
     *
     * @return 当前月
     */
    public static int getCurrentMonth() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.MONTH);
    }

    /**
     * 得到当前小时
     *
     * @return 当前小时(24小时制)
     */
    public static int getCurrentHOUR() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * @描述：得到几天前的日期
     * @作者：co-hexin001
     */
    public static Date getDateBefore(Date d, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
        return now.getTime();
    }

    /**
     * @描述：得到几天后的日期
     * @作者：co-hexin001
     */
    public static Date getDateAfter(Date d, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
        return now.getTime();
    }

    /**
     * @描述：得到几月后的日期
     * @作者：co-hexin001
     */
    public static Date getDateAfterMonth(Date d, int month) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.MONTH, now.get(Calendar.MONTH) + month);//+ 1
        return now.getTime();
    }

    /**
     * 根据指定的格式化模式,格式化日历数据<br>
     * 如果格式化模式为null或者为空,则默认使用yyyy-MM-dd HH:mm:ss
     *
     * @param now            给定日期
     * @param day            给定日期的前几天
     * @param formatePattern 格式化模式
     * @return 被格式化后的字符串<br>
     */
    public static String formatDateBefore(java.util.Calendar now, int day, String formatePattern) {
        if (now == null) {
            return null;
        }
        if (formatePattern == null || formatePattern.trim().length() <= 0) {
            formatePattern = DATETIME24_PATTERN_LINE;
        }
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
        java.util.Date tempDate = now.getTime();
        SimpleDateFormat dateFormate = new SimpleDateFormat(formatePattern);
        return dateFormate.format(tempDate);
    }

    /**
     * 根据指定的格式化模式,格式化日历数据<br>
     * 如果格式化模式为null或者为空,则默认使用yyyy-MM-dd HH:mm:ss
     *
     * @param now            给定日期
     * @param day            给定日期的前几天
     * @param formatePattern 格式化模式
     * @return 被格式化后的字符串<br>
     */
    public static String formatDateAfter(java.util.Calendar now, int day, String formatePattern) {
        if (now == null) {
            return null;
        }
        if (formatePattern == null || formatePattern.trim().length() <= 0) {
            formatePattern = DATETIME24_PATTERN_LINE;
        }
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
        java.util.Date tempDate = now.getTime();
        SimpleDateFormat dateFormate = new SimpleDateFormat(formatePattern);
        return dateFormate.format(tempDate);
    }

    public static boolean compareDate(int min, int max) {
        long current = System.currentTimeMillis();
        Calendar calMin = Calendar.getInstance();
        Calendar calMax = Calendar.getInstance();
        calMin.set(Calendar.DAY_OF_MONTH, min);
        calMax.set(Calendar.DAY_OF_MONTH, max + 1);
        Date dtmin = parseDate(formatDate(calMin.getTime()));
        Date dtmax = parseDate(formatDate(calMax.getTime()));
        return dtmin.getTime() <= current && current < dtmax.getTime();
    }

    public static int getSecondTimestamp() {
        return Long.valueOf(new Date().getTime() / 1000).intValue();
    }

    /**
     * 获取当前时间秒
     *
     * @return
     */
    public static int getCurrentTimeSpan() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    /**
     * 获取当天开始时间戳秒
     *
     * @return
     */
    public static int getTodayStartTimeSpan() {
        Calendar lCal = Calendar.getInstance();
        lCal.set(Calendar.HOUR_OF_DAY, 0);
        lCal.set(Calendar.MINUTE, 0);
        lCal.set(Calendar.SECOND, 0);
        lCal.set(Calendar.MILLISECOND, 0);
        return (int) (lCal.getTimeInMillis() / 1000);
    }

    public static void main(String[] args) {
        System.out.println(getDateAfterMonth(new Date(), -2));
        System.out.println(formatDate(1483144200000l));
        System.out.println(formatDate(1483113600000l));
        System.out.println(parseDate("2017-05-01").getTime() / 1000);
        System.out.println(parseDate("2017-05-02").getTime() / 1000);
        System.out.println(isDateStr("2017-05-02 17:01:00"));

    }

}
