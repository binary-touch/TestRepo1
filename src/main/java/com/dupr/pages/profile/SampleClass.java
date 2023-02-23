package com.dupr.pages.profile;

import static org.testng.Assert.expectThrows;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.testng.Assert;

public class SampleClass {

	public static int minutes() {

		SimpleDateFormat simpleformat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a z");

		simpleformat = new SimpleDateFormat("mm");
		String strMinutes = simpleformat.format(new Date());
		// System.out.println("Minutes format = " + strMinutes);
		String minutesValue = strMinutes.substring(1);

		String minutesFirstValue = strMinutes.substring(0);
		// System.out.println(minutesValue);
		int minutues = Integer.parseInt(minutesValue);
		int minutesFinalValue = 0;

		int lastDate = Integer.parseInt(strMinutes);

		if (minutues == 9) {
			minutesFinalValue = minutues + 6;
		} else if (minutues == 8) {
			minutesFinalValue = minutues + 2;
		} else if (minutues == 7) {
			minutesFinalValue = minutues + 3;
		} else if (minutues == 6) {
			minutesFinalValue = minutues + 4;
		} else if (minutues == 5) {
			minutesFinalValue = minutues + 5;
		} else if (minutues == 4) {
			minutesFinalValue = minutues + 6;
		} else if (minutues == 3) {
			minutesFinalValue = minutues + 2;
		} else if (minutues == 2) {
			minutesFinalValue = minutues + 3;
		} else if (minutues == 1) {
			minutesFinalValue = minutues + 4;
		} else if (minutues == 0) {
			minutesFinalValue = minutues + 5;
		} // System.out.println(minutesFinalValue);

		String minutesValue1 = null;
		for (int i = 0; i < 11; i++) {
			try {
				minutesValue1 = strMinutes.substring(1).replace(String.valueOf(i), "0");
				int minutues1 = Integer.parseInt(minutesValue1);
				if (minutues1 == 0) {

					break;
				}
			} catch (Exception e) {
				expectThrows(null, null);
				// System.out.println();
			}
		}
		String minutesValue2 = strMinutes.substring(0, 1);

		String last = minutesValue2 + minutesValue1;
		int num = Integer.parseInt(last);

		int finalminutesValue = num + minutesFinalValue;

		// System.out.println(finalminutesValue);

		String lastMinutes = String.valueOf(finalminutesValue);
		String firstValue = null;
		String Secondvalue = null;
		String Lastvalue = null;
		String value = null;

		if (lastMinutes.substring(0, 1).contains("5")) {
			if (lastMinutes.substring(1).contains("5")) {
				System.out.println();
			} else if (lastMinutes.substring(1).contains("0")) {
				System.out.println();
			} else {
				value = lastMinutes.substring(0, 1).replace("5", "05");
				String.valueOf(finalminutesValue);
				finalminutesValue = Integer.parseInt(value);
			}
		}

		if (lastMinutes.substring(0, 1).contains("6")) {
			firstValue = lastMinutes.substring(0, 1).replace("6", "0");
			Secondvalue = lastMinutes.substring(1);
			Lastvalue = String.valueOf(firstValue + Secondvalue);
			finalminutesValue = Integer.parseInt(Lastvalue);
		}

		return finalminutesValue;

	}

	public static String lastminutes() {

		SimpleDateFormat simpleformat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a z");

		simpleformat = new SimpleDateFormat("mm");
		String strMinutes = simpleformat.format(new Date());
		// System.out.println("Minutes format = " +strMinutes);
		String minutesValue = strMinutes.substring(1);

		String minutesFirstValue = strMinutes.substring(0);
		// System.out.println(minutesValue);
		int minutues = Integer.parseInt(minutesValue);
		int minutesFinalValue = 0;

		int lastDate = Integer.parseInt(strMinutes);

		if (minutues == 9) {
			minutesFinalValue = minutues + 6;
		} else if (minutues == 8) {
			minutesFinalValue = minutues + 2;
		} else if (minutues == 7) {
			minutesFinalValue = minutues + 3;
		} else if (minutues == 6) {
			minutesFinalValue = minutues + 4;
		} else if (minutues == 5) {
			minutesFinalValue = minutues + 5;
		} else if (minutues == 4) {
			minutesFinalValue = minutues + 6;
		} else if (minutues == 3) {
			minutesFinalValue = minutues + 2;
		} else if (minutues == 2) {
			minutesFinalValue = minutues + 3;
		} else if (minutues == 1) {
			minutesFinalValue = minutues + 4;
		} else if (minutues == 0) {
			minutesFinalValue = minutues + 5;
		} // System.out.println(minutesFinalValue);

		String minutesValue1 = null;
		for (int i = 0; i < 11; i++) {
			try {
				minutesValue1 = strMinutes.substring(1).replace(String.valueOf(i), "0");
				int minutues1 = Integer.parseInt(minutesValue1);
				if (minutues1 == 0) {

					break;
				}
			} catch (Exception e) {
				expectThrows(null, null);
				// System.out.println();
			}
		}
		String minutesValue2 = strMinutes.substring(0, 1);

		String last = minutesValue2 + minutesValue1;
		int num = Integer.parseInt(last);

		int finalminutesValue = num + minutesFinalValue;

		// System.out.println(finalminutesValue);

		String lastMinutes = String.valueOf(finalminutesValue);
		String minsValue = null;

		if (lastMinutes.substring(0, 1).contains("5")) {
			if (lastMinutes.substring(1).contains("5")) {
				System.out.println();
			} else if (lastMinutes.substring(1).contains("0")) {
				System.out.println();
			} else {
				String pattern = "h";
				LocalTime currentHour1 = LocalTime.now();
				String currentHourValue = currentHour1.format(DateTimeFormatter.ofPattern(pattern));
				System.out.println(currentHourValue);
			}
		}

		if (lastMinutes.substring(0, 1).contains("6")) {
			String pattern = "h";

			LocalTime currentHour = LocalTime.now();
			LocalTime futureHour = currentHour.plusHours(1);
			String futureHourValue = futureHour.format(DateTimeFormatter.ofPattern(pattern));
			System.out.println(futureHourValue);
			
		}

		return minsValue;

	}

	public static void main(String args[]) {
		
		System.out.println(minutes());
		System.out.println(lastminutes());
		/*
		 * String pattern = "h"; String pattern1 = "m"; String pattern2 = "a";
		 * 
		 * LocalTime currentMinute = LocalTime.now(); LocalTime futureMinute =
		 * currentMinute.plusMinutes(4);
		 * 
		 * String futureHourValue =
		 * futureMinute.format(DateTimeFormatter.ofPattern(pattern));
		 * System.out.println("futureHourValue:" + futureHourValue);
		 * 
		 * String futureMinuteValue =
		 * futureMinute.format(DateTimeFormatter.ofPattern(pattern1));
		 * System.out.println("futureMinuteValue: " + futureMinuteValue);
		 * 
		 * String futureMeridiemValue =
		 * futureMinute.format(DateTimeFormatter.ofPattern(pattern2));
		 * System.out.println("futureMeridiemValue: " + futureMeridiemValue);
		 */

	}
}
