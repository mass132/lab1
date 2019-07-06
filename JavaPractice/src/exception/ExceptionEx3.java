package exception;

public class ExceptionEx3 {

	public static void main(String[] args) {
		try {
			//int a[] = new int[5];
			//a[5] =30/2;
			//String s = null;
			//String s = "ibm";
			//int x = Integer.parseInt(s);
			//System.out.println(s.length());
			
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			e.printStackTrace();
		}
		catch(ArithmeticException e)
		{
			e.printStackTrace();
		}
		catch(NumberFormatException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			System.out.println("Finally block");
		}
	}

}
