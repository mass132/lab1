package test;

import java.util.UUID;

public class Main {
	private boolean validateMobile(String mobile)
	{
		return mobile.matches("^[1-9][0-9]{9}$");
	}
	private boolean validateDate(String date)
	{
	        String regex = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
	        return date.matches(regex);
	}
public static void main(String args[])
{
System.out.println(new Main().validateMobile("7008731815"));	
System.out.println(new Main().validateDate("24/04/2018"));
String uniqueID = UUID.randomUUID().toString();
System.out.println(uniqueID);
}

}
