package exception;

@SuppressWarnings("serial")
public class MyException2 extends Exception {
	@SuppressWarnings("unused")
	private String username,password;
	public MyException2(String username,String password)
	{
		this.username = username;
		this.password = password;
	}
	public String toString()
	{
		return "Invalid Credentials";
	}
}
