package exception;

public class ExceptionEx1 {

	public static void main(String[] args) {
int[] arr = new int[5];
	try {
	arr[5] = 6;

	}
	catch(ArrayIndexOutOfBoundsException e)
	{
		
		//e.printStackTrace();
		System.out.println(e);
		//System.out.println(e.getMessage());
	}
	System.out.println("rest of the code");
}
}
