package lab5;

@SuppressWarnings("serial")
class MyException extends Exception{
	private int age;
	public int getAge() {
		return age;
	}
	public MyException(int age)
	{
		super(String.valueOf(age));
		this.age = age;
	}
	public String toString() {
		return ("You're age should 15 years to access this page and you are "+age);
	}
}

public class Que5Exception {
	static void validate(int age) throws MyException{
		if(age < 15)
		{
			throw new MyException(age);
		}
		else
		{
			System.out.println("Welcome user");
		}
	}

	public static void main(String[] args) {
		try {
			Que5Exception.validate(14);
			
		}
		catch (MyException e) {
			//e.printStackTrace();
			System.out.println(e);
		}

	}

}
