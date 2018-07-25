package com.liyz.common.util;

import com.liyz.common.util.exception.BzException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by lianghaoguan on 2017/10/20.
 */
public class DateUtil {

    private final static Logger logger = LoggerFactory.getLogger(DateUtil.class);

    public static final String YYYYMMDD = "yyyy-MM-dd";

    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static final String DATE_FORMAT_WITH_SECOND = "yyyy-MM-dd HH:mm:ss";

    public static final String begin = " 00:00:00";

    public static final String end = " 23:59:59";

    private static final int FREE_DAYS = 40;// 从预计接车时间当天开始FREE_DAYS天内可免息销售

    private DateUtil() {
        throw new IllegalAccessError("Utility class");
    }

    /**
     * 获取指定月份下第一天的日期
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getMonthFirstDay(String year, String month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Integer.parseInt(year), Integer.parseInt(month) - 1, 1);
        cal.add(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

    /**
     * 获取指定月份下的最后一天的日期
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getMonthLastDay(String year, String month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Integer.parseInt(year), Integer.parseInt(month) - 1, 1);
        cal.add(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 0);
        return cal.getTime();
    }

    /**
     * 把传入的yyyy-MM-dd时间转化为 yyyy-MM-dd 00:00:00
     *
     * @param dateStr
     * @return
     */
    public static Date StringToBeginDate(String dateStr) {
        DateFormat sdf = new SimpleDateFormat(DATE_FORMAT_WITH_SECOND);
        Date date = null;
        try {
            dateStr = dateStr.trim();
            date = sdf.parse(dateStr + begin);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return date;
    }
    /**
     *
     * @Description: 把传入的yyyy-MM-dd时间转化为 yyyy-MM-dd 00:00:00
     * @param dateStr
     * @return String
     * @throws
     * @author YixinCapital -- lizhongxin
     *	       2018年6月12日 下午1:59:07
     */
    public static String toBeginDateStr(String dateStr) {
    	if(StringUtils.isBlank(dateStr) || dateStr.length() != 10) {
    		logger.error("传入的日期字段格式或长度不满足！");
    		return null;
    	}
    	return dateStr + begin;
    }

    /**
     * 把传入的yyyy-MM-dd时间转化为 yyyy-MM-dd 23:59:59
     *
     * @param dateStr
     * @return
     */
    public static Date StringToEndDate(String dateStr) {
        DateFormat sdf = new SimpleDateFormat(DATE_FORMAT_WITH_SECOND);
        Date date = null;
        try {
            dateStr = dateStr.trim();
            date = sdf.parse(dateStr + end);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return date;
    }
    /**
    * 把传入的yyyy-MM-dd时间转化为 yyyy-MM-dd 23:59:59
    *
    * @param dateStr
    * @return
    */
    public static String toEndDateStr(String dateStr) {
    	if(StringUtils.isBlank(dateStr) || dateStr.length() != 10) {
    		logger.error("传入的日期字段格式或长度不满足！");
    		return null;
    	}
    	return dateStr + end;
    }

    /**
     * 传入开始时间，结束时间，最大时间间隔范围，获取符合条件的开始时间。
     *
     * @param beginDate 开始时间 时间格式 yyyy-MM-dd
     * @param endDate 结束时间 时间格式 yyyy-MM-dd
     * @param rangeDays 开始时间与结束时间最大时间范围
     * @return 符合结束时间-开始时间<=rangeDays 的开始时间
     * @author YixinCapital -- lishuaifeng 2018年3月30日 下午3:11:04
     */
    public static Date beginDTByMaxDaysRange(String beginDate, String endDate, int rangeDays) {
        // 开始时间不为空
        if (StringUtils.isNotBlank(beginDate)) {
            return StringToBeginDate(beginDate);
        }
        // 开始时间为空的情况
        if (StringUtils.isBlank(endDate)) {// 结束时间为空
            return addDate(new Date(), -rangeDays);
        } else {// 结束时间不为空
            return addDate(StringToEndDate(endDate), -rangeDays);
        }

    }

    /**
     * 传入开始时间，结束时间，最大时间间隔范围，获取符合条件的结束时间。
     *
     * @param beginDate 开始时间 时间格式 yyyy-MM-dd
     * @param endDate 结束时间 时间格式 yyyy-MM-dd
     * @param rangeDays 开始时间与结束时间最大时间范围
     * @return 符合结束时间-开始时间<=rangeDays 的结束时间
     * @author YixinCapital -- lishuaifeng 2018年3月30日 下午3:11:04
     */
    public static Date endDTByMaxDaysRange(String beginDate, String endDate, int rangeDays) {
        // 结束时间不为空
        if (StringUtils.isNotBlank(endDate)) {
            return StringToBeginDate(endDate);
        }
        // 结束时间为空的情况
        if (StringUtils.isBlank(beginDate)) {// 开始时间为空
            return new Date();
        } else {// 开始时间不为空
            return addDate(StringToEndDate(beginDate), rangeDays);
        }
    }

    /**
     * 传入预计接车时间得到剩余免息天数
     *
     * @param preDate 预计接车时间 不可为null
     * @return 剩余免息天数
     */
    public static int getRemainFreeDays(Date preDate) {
        return daysBetween(new Date(), preDate) + FREE_DAYS;
    }

    public static int compare_date(Date date, Date startDate, Date endDate) {
        if (startDate.getTime() < date.getTime() && endDate.getTime() > date.getTime()) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * 第二个参数比第一个参数日期大则返回1，否则返回0.
     *
     * @param date
     * @param endDate
     * @return
     */
    public static int compare_dates(Date date, Date endDate) {
        if (endDate.getTime() > date.getTime()) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * 返回smdate 与 bdate 之间天数
     *
     * @param smdate
     * @param bdate
     * @return
     * @author YixinCapital -- dujiangying 2016年11月3日 上午11:36:26
     */
    public static int daysBetween(String smdate, String bdate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        int num = 0;
        try {
            cal.setTime(sdf.parse(smdate));
            long time1 = cal.getTimeInMillis();
            cal.setTime(sdf.parse(bdate));
            long time2 = cal.getTimeInMillis();
            long between_days = (time2 - time1) / (1000 * 3600 * 24);
            num = Integer.parseInt(String.valueOf(between_days));
        } catch (ParseException e) {
            logger.error(e.getMessage(), e);
        }
        return num;
    }

    /**
     * 返回date1 与 date2 之间天数
     *
     * @param date1
     * @param date2
     * @return
     * @author YixinCapital -- qinyunfei 2017年11月10日 下午10:43:50
     */
    public static int daysBetween(Date date1, Date date2) {
        int result = 0;
        try {
            Date da1 = getDateWithOutHour(date1);
            Date da2 = getDateWithOutHour(date2);
            Calendar cal = Calendar.getInstance();
            cal.setTime(da1);
            long time1 = cal.getTimeInMillis();
            cal.setTime(da2);
            long time2 = cal.getTimeInMillis();
            long between_days = (time2 - time1) / (1000 * 3600 * 24);
            result = Integer.parseInt(String.valueOf(between_days));
        } catch (ParseException e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * 返回date1 与 date2 之间天数
     *
     * @param date1
     * @param date2
     * @return
     * @author YixinCapital -- qinyunfei 2017年11月10日 下午10:43:50
     */
    public static int hoursBetween(Date date1, Date date2) {
        long between = 0;
        between = (date2.getTime() - date1.getTime());// 得到两者的毫秒数
        long hour = between / (60 * 60 * 1000);
        return Integer.parseInt(String.valueOf(hour));
    }

    /**
     * 获取Date日期yyyy-MM-dd
     *
     * @param date
     * @return
     * @author YixinCapital -- qinyunfei 2017年11月10日 下午10:43:50
     */
    public static Date getDateWithOutHour(Date date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYYMMDD);
        String s = sdf.format(date);
        return sdf.parse(s);
    }

    /**
     *
     * @Description: 获取Date日期yyyy-MM-dd HH:mm:ss
     * @param date
     * @return
     * @throws ParseException Date
     * @throws @author YixinCapital -- mjj 2018年6月5日 上午9:52:22
     */
    public static Date getDateWithOutSecond(Date date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_WITH_SECOND);
        String s = sdf.format(date);
        return sdf.parse(s);
    }

    /**
     * 返回固定时间 加上 固定天数后的时间
     *
     * @param date
     * @param day
     * @return
     * @author lianghaoguan
     * @throws Exception
     */
    public static Date addDate(Date date, int day) {
        Calendar cal = Calendar.getInstance();
        Date da1;
        try {
            da1 = getDateWithOutHour(date);
            cal.setTime(da1);
            cal.add(5, day);
        } catch (ParseException e) {
            logger.error(e.getMessage(), e);
        }
        return cal.getTime();
    }

    /**
     *
     * @Description: 在指定时间上加分钟数
     * @param date
     * @param minute
     * @return Date
     * @throws @author YixinCapital -- yangfei02 2018年5月17日 下午2:15:05
     */
    public static Date addMinuteToDate(Date date, int minute) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, minute);
        return cal.getTime();
    }

    public static String dateToString(Date date, String formatStr) {
        if (date == null) {
            return "";
        }
        DateFormat sdf = new SimpleDateFormat(formatStr);
        return sdf.format(date);
    }

    public static Date StringToDate(String dateStr, String formatStr) {
        DateFormat sdf = new SimpleDateFormat(formatStr);
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return date;
    }

    /**
     * 将yyyy-MM-dd 转为 Date,并抛异常
     *
     * @param dateStr
     * @return
     * @author YixinCapital -- lizhongxin 2018年3月20日 上午10:10:26
     */
    public static Date StringToDate(String dateStr) {
        DateFormat sdf = new SimpleDateFormat(YYYYMMDD);
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BzException(e);
        }
        return date;
    }

    /**
     * 返回yyyy-MM
     *
     * @param date
     * @return
     * @author YixinCapital -- lizhongxin 2018年3月6日 下午10:51:26
     */
    public static String getYearMonthString(Date date) {
        if (date == null) {
            return null;
        }
        DateFormat sdf = new SimpleDateFormat(YYYYMMDD);
        String dateStr = sdf.format(date);
        return dateStr.substring(0, 7);
    }

    public static void main(String[] args) {
    }
}
