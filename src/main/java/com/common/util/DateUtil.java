package com.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static SimpleDateFormat YYMMDDHHMM = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	public static SimpleDateFormat YYMMDDHHMMSS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static SimpleDateFormat HHMMSS = new SimpleDateFormat("HH:mm:ss");
	
	public static Date formatStringToDate(String date, SimpleDateFormat sdf) {
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static String formatDateToString(Date date, SimpleDateFormat sdf) {
		return sdf.format(date);
	}
	
	/**
	 * 获取当前时间时间戳精确到分
	 * @return
	 */
	public static long getNowMinuteTime(){
		long time = System.currentTimeMillis();
		return time / 60000 * 60000;
	}

}
