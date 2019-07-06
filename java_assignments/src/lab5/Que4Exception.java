package lab5;

import java.util.Scanner;

@SuppressWarnings("serial")
class MyUserException extends Exception{
	private String fName;
	private String lName;
	public String getfName() {
		return fName;
	}
	public String getlName() {
		return lName;
	}
	public MyUserException (String fName,String lName)
	{
		super();
		this.fName = fName;
		this.lName = lName;
	}
	public String toString() {
		return ("Please Enter a valid name");
	}
}

public class Que4Exception {
	static void validateName(String fName,String lName) throws MyUserException{
		if(fName.isEmpty() || lName.isEmpty() )
		{
			throw new MyUserException(fName,lName);
		}
		else
		{
			System.out.println("Hello "+fName+" "+lName);
		}
	}

	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(System.in);
			String fName = scan.nextLine();
			String lName = scan.nextLine();
			scan.close();
			Que4Exception.validateName(fName,lName);
			
		}
		catch (MyUserException e) {
			//e.printStackTrace();
			System.out.println(e);
		}

	}

}
