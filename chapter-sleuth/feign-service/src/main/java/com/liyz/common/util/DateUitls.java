package com.liyz.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期相关的工具类 Package : com.liyz.common.ssp.application.test.utils
 *
 *
 */
public class DateUitls
{

	private DateUitls() {
	}

	private final static Logger logger = LoggerFactory.getLogger(DateUitls.class);

	/**
	 * 把字符串转成日期，字符串格式为yyyy-MM-dd HH:mm:ss
	 *
	 * @param dateString
	 * @return
	 * @author YixinCapital -- bufeng 2016年4月12日 上午10:07:08
	 */
	public static Date strToDate(String dateString) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(dateString);
		} catch (ParseException e) {
			logger.error(e.getMessage(), e);
		}
		return date;
	}

	/**
	 * 把字符串转成日期，字符串格式为yyyy-MM-dd HH:mm:ss
	 *
	 * @param dateString
	 * @return
	 * @author YixinCapital -- bufeng 2016年4月12日 上午10:07:08
	 */
	public static String dateToStr(Date date) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = null;
		try {
			str = sdf.format(date);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return str;
	}

	/**
	 * 把字符串转成日期，字符串格式为yyyy-MM-dd HH:mm:ss
	 *
	 * @param dateString
	 * @return
	 * @author YixinCapital -- bufeng 2016年4月12日 上午10:07:08
	 */
	public static String dateToStr(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String str = null;
		try {
			str = sdf.format(date);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return str;
	}

	/**
	 * 获取下一天
	 *
	 * @param today
	 * @return
	 * @author YixinCapital -- sfei 2016年4月21日 下午4:21:24
	 */
	public static Date getNextDay(Date today) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		cal.add(Calendar.DATE, 1);

		return cal.getTime();
	}

	/**
	 * 获取30天后
	 *
	 * @param today
	 * @return
	 * @author YixinCapital -- sfei 2016年4月21日 下午4:21:24
	 */
	public static Date getOneMonthDay(Date today) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		cal.add(Calendar.DATE, 30);

		return cal.getTime();
	}

	/**
	 * 获取几分钟后或前的时间
	 *
	 * @param now
	 * @param minute
	 * @return
	 * @author YixinCapital -- yinx 2016年9月1日 下午7:51:26
	 */
	public static Date getMinute(Date now, int minute) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.add(Calendar.MINUTE, minute);

		return cal.getTime();
	}
}
