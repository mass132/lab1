package exception;

public class ThrowsEx {
	public void hello() throws Exception{
		System.out.println("hello method");
		System.out.println(30/0);
	}

	public static void main(String[] args) {
ThrowsEx ob = new ThrowsEx();
try {
	ob.hello();
	
}
catch(Exception e)
{
	e.printStackTrace();
}
	}

}
