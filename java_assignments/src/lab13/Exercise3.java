package lab13;

import java.util.function.BiPredicate;

public class Exercise3 {

	public static boolean validate(String user, String pass)
	{
		BiPredicate<String, String> account = (username,password) -> username == "admin" && password == "admin";
		return account.test(user, pass);
	}
	public static void main(String[] args) {
		
		System.out.println(Exercise3.validate("poonam", "admin"));
		System.out.println(Exercise3.validate("admin", "admin"));

	}

}
