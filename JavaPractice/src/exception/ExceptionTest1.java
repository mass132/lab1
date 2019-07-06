package exception;

public class ExceptionTest1 {
	public static void login(String username,String password) throws MyException2
	{
		if(!(username.equals("capgemini") && password.equals("capgemini1")))
		{
			throw new MyException2(username,password);
		}
		else
		{
			System.out.println("Welcome User");
		}
	}

	public static void main(String[] args) throws Exception{
		ExceptionTest1.login("capgemini","capgemini1");

	}

}
