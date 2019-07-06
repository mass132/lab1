package lab8;

import java.text.ParseException;
import java.time.Duration;
import java.util.Calendar;
import java.util.StringTokenizer;

public class Que6 {
	/*
	 * Create a method to accept date and print the duration in days, months and
	 * years with regards to current system date.
	 */
	public static void getDuration(String dateString) throws ParseException {
		StringTokenizer st = new StringTokenizer(dateString, "/");
		int day = Integer.parseInt(st.nextToken());
		int month = Integer.parseInt(st.nextToken());
		int year = Integer.parseInt(st.nextToken());
		Calendar today = Calendar.getInstance();
		Calendar date = new Calendar.Builder().setDate(year, month, day).build();
		long todayDate = today.getTimeInMillis();
		long givenDate = date.getTimeInMillis();
		long diff = todayDate - givenDate;
		long days = Duration.ofMillis(diff).toDays();
		long years = days / 365;
		days = days % 365;
		long months = days / 30;
		days = days % 30;
		System.out.println("Duration is : ");
		System.out.print(years + " years, ");
		System.out.print(months + " months, ");
		System.out.print(days + " days ");
	}

	public static void main(String[] args) throws ParseException {
		Que6.getDuration("24/12/1997");

	}

}
