package lab8;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Que6 {
	/*
	 * Create a method to accept date and print the duration in days, months and
	 * years with regards to current system date.
	 */
	public static void getDuration(String dateString) throws ParseException { 
		/*
		 * Accepts date in DD/MM/YYYY format
		 */
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(dateString,dtf);
		LocalDate today = LocalDate.now();
		Period period = Period.between(date, today);
		System.out.print("Duration is "+ period.getYears()+" years, "+
		period.getMonths()+" months, "+period.getDays()+" days");
	}

	public static void main(String[] args) throws ParseException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter date in \"DD/MM/YYYY\" format eg. 25/08/2018.");
		String dob = scan.nextLine();
		Que6.getDuration(dob);
		scan.close();

	}

}
