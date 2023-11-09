package com.query;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Test {

	public static Date addMinutesToDate(int minutes, Date beforeTime) {
		final long ONE_MINUTE_IN_MILLIS = 60000;
		long curTimeInMs = beforeTime.getTime();
		Date afterAddingMins = new Date(curTimeInMs - (minutes * ONE_MINUTE_IN_MILLIS));
		return afterAddingMins;
	}

	/**
	 * @param args
	 */
//	public static void main(String[] args) {
//		Date lastUpdateTimestamp = null;
//		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.ENGLISH);
//		Date currentTimestamp = new Date();
//		try {
//			System.out.println(new Date(currentTimestamp.getTime()));
//			System.out.println(new Date(DATE_FORMAT.parse("2023-01-14 00:00:00").getTime()));
//			System.out.println(new Date(currentTimestamp.getTime()-DATE_FORMAT.parse("2016-06-14 00:00:00").getTime()));
//			lastUpdateTimestamp = new Date(currentTimestamp.getTime());
//		} catch (Exception e) {
//			lastUpdateTimestamp = new Date(currentTimestamp.getTime() - 120 * 24 * 3600 * 1000l);
//		}
//		System.out.println(lastUpdateTimestamp);
//		System.out.println(DATE_FORMAT.format(lastUpdateTimestamp));
//		Date newDate = addMinutesToDate(30, lastUpdateTimestamp);
//		System.out.println(DATE_FORMAT.format(newDate));
//
//	}
}
