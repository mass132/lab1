package exception;
@SuppressWarnings("serial")
class MyException extends Exception{
	private int age;
	public int getAge() {
		return age;
	}
	public MyException(int age)
	{
		this.age = age;
	}
	public String toString() {
		return "You are not allowed to vote";
	}
}

public class ExceptionTest {
	static void validation(int age) throws MyException{
		if(age < 18)
		{
			throw new MyException(age);
		}
		else
		{
			System.out.println("You are allowed to vote");
		}
	}

	public static void main(String[] args) {
		try {
			ExceptionTest.validation(16);
			
		}
		catch (MyException e) {
			//e.printStackTrace();
			System.out.println(e);
		}

	}

}
