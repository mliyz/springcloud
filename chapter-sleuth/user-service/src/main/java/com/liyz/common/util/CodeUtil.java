package com.liyz.common.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeUtil {

	private final static Logger logger = LoggerFactory.getLogger(CodeUtil.class);

	private CodeUtil() {
		throw new IllegalAccessError("Utility class");
	}

	private static String count = "0000";
	private static String dateValue = "20131115";

	/**
	 * 产生流水号
	 */
	public synchronized static String getMoveOrderNo() {
		long No = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String nowdate = sdf.format(new Date());
		No = Long.parseLong(nowdate);
		if (!(String.valueOf(No)).equals(dateValue)) {
			count = "0000";
			dateValue = String.valueOf(No);
		}
		String num = String.valueOf(No);
		num += getNo(count);
		// num = "CB" + num;
		return num;
	}

	/**
	 * 获取撤展单序列号
	 */
	public synchronized static String getMoveOrderNo(String serialNum) {
		String nyr = StringUtils.substring(serialNum, 2, 10); // 获取年月日字符串
		String countV = StringUtils.substring(serialNum, 10); // 获取流水号
		if (Integer.valueOf(countV) > Integer.valueOf(count)) {
			dateValue = nyr;
			count = String.valueOf(countV);
		}
		return getMoveOrderNo();
	}

	/**
	 * 返回当天的订单数+1
	 */
	public static String getNo(String s) {
		String rs = s;
		int i = Integer.parseInt(rs);
		i += 1;
		rs = "" + i;
		for (int j = rs.length(); j < 4; j++) {
			rs = "0" + rs;
		}
		count = rs;
		return rs;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(getMoveOrderNo());
		}
	}
	/**
	 * 利用正则表达式判断字符串是否是数字
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str){
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if( !isNum.matches() ){
			return false;
		}
		return true;
	}
	
	/**
	 * 根据需求获取相应位数的随机数字
	 * @Title: getRandomDigit
	 * @param digit 产生随机数字的位数
	 * @return
	 * @author yangfei02
	 * @date 2018年5月16日 上午10:22:22
	 */
	public static String getRandomDigit(Integer digit){
		String sources = "0123456789"; // 限制从0到9数字中产生随机数
	    Random rand = new Random();
	    StringBuilder random = new StringBuilder();
	    for (int j = 0; j < digit; j++)
	    {
	    	random.append(sources.charAt(rand.nextInt(9)) + "");
	    }
	    return random.toString();
	}

}
