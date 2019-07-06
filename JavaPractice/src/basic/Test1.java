package basic;

public class Test1 {
	public static int sub(int val1,int val2)
	{
		return val1 - val2;
	}
	public static int add(int val1,int val2)
	{
		return val1 + val2;
	}
	public int mul()
	{
		int val1 = 3;
		int val2 = 4;
		return val1 * val2;
	}
	public static void main(String[] args) {
		int minus = Test1.sub(3, 4);
		int sum = Test1.add(6, 4);
		Test1 t = new Test1();
		int result = t.mul();
		System.out.println(sum);
		System.out.println(minus);
		System.out.println(result);
	}

}
