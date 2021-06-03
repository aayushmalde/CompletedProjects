/** * Homework 3
*Malde Aayush, asm7yaq
* Sources: TA office hours 
* Big Java book , ... 
*/

import java.text.SimpleDateFormat;

public class DateLibrary {

	/**
	 * This method evaluates a string to make sure the format of the date is "YYYY-MM_DD"
	 * 
	 * @param date : This is a string of a calendar date
	 * @return boolean : This tells you whether date followed the format
	 */
	public static boolean isValidDateFormat(String date) {
		// Check Length
		if (date.length() != 10) {
			return false;
		}
		// Check if digit
		for (int i = 0; i < 4; i++) {
			if (!Character.isDigit(date.charAt(i))) {
				return false;
			}
		}
		for (int i = 5; i < 7; i++) {
			if (!Character.isDigit(date.charAt(i))) {
				return false;
			}
		}
		for (int i = 8; i < 10; i++) {
			if (!Character.isDigit(date.charAt(i))) {
				return false;
			}
		}
		// Check hyphens
		if (date.charAt(4) != '-' || date.charAt(7) != '-') {
			return false;
		}
		return true;
	}
	/**
	 * This method returns the year from the string given (date)
	 * 
	 * @param date : This is a string of a date
	 * @return int : This tells you the 4-digit year from date
	 */
	public static int getYear(String date) {
		if (isValidDateFormat(date) == false) {
			return -1;
		}
		String temp = date.substring(0, 4);
		int x = Integer.parseInt(temp);
		if (x > 9999 || x < 1) {
			return -1;
		}
		return x;
	}
	/**
	 * This method returns the month from the string given (date)
	 * 
	 * @param date : This is a string of a date
	 * @return int : This tells you the 2-digit month from date
	 */
	public static int getMonth(String date) {
		if (isValidDateFormat(date) == false) {
			return -1;
		}
		String temp = date.substring(5, 7);
		int x = Integer.parseInt(temp);
		if (x > 12 || x < 1) {
			return -1;
		}
		return x;
	}
	/**
	 * This method returns the day from the string given (date)
	 * 
	 * @param date : This is a string of a date
	 * @return int : This tells you the 2-digit day from date
	 */
	public static int getDay(String date) {
		if (isValidDateFormat(date) == false) {
			return -1;
		}
		String temp = date.substring(8, 10);
		int x = Integer.parseInt(temp);
		if (x > 31 || x < 1) {
			return -1;
		}
		return x;
	}
	/**
	 * This method lets you know if a year is a leap year
	 * 
	 * @param year : This is a int of a 4-digit year
	 * @return boolean : This tells you if the year is a leap year
	 * - true if it is, false if it is not
	 */
	public static boolean isLeapYear(int year) {
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					return true;
				}
				return false;
			}
			return true;
		}
		return false;
	}
	/**
	 * This method checks the calendar to determine if the string given (date) is an
	 * actual date
	 * 
	 * @param date : This is a string of a date
	 * @return boolean : True means String date is a valid date, false means it is not
	 */
	public static boolean isValidDate(String date) {
		SimpleDateFormat dat = new SimpleDateFormat("yyyy-MM-dd");
		dat.setLenient(false);
		try {
			if (isValidDateFormat(date)) {
				dat.parse(date);
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	/**
	 * This method tells you which date comes first
	 * 
	 * @param date1 : This is a string of a date
	 * @param date2 : This is a string of a date
	 * @return int : This tells you the order of the date (0 if dates are not valid)
	 */
	public static int compare(String date1, String date2) {
		if (isValidDate(date1) == true && isValidDate(date2) == true) {
			return date1.compareTo(date2);
		}
		return 0;
	}
	
	public static void main(String[] Args) {
		System.out.println(isValidDateFormat("545"));
		System.out.println(isValidDateFormat("1234-56-78"));
		System.out.println(getYear("0000-56-78"));
		System.out.println(getYear("1200-56-78"));
		System.out.println(getMonth("0023-02-78"));
		System.out.println(getMonth("1200-56-78"));
		System.out.println(getDay("0000-56-18"));
		System.out.println(getDay("1200-56-78"));
		System.out.println(isLeapYear(2000));
		System.out.println(isLeapYear(3257));
		System.out.println(isValidDate("5450-12-45"));
		System.out.println(isValidDate("1234-06-08"));
		System.out.println(compare("2001-06-04", "1234-12-07"));
		System.out.println(compare("2001-05-23", "2004-06-18"));

	}

}
