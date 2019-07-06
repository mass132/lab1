package lab5;

public class Que2 {

	public static void fibRec(int first,int second,int n) {

		System.out.print(first);
		System.out.print("\t");
		if(second > n)
		{
			System.exit(1);
		}
		fibRec(second, (first + second), n);
		
	}
	public static void fibNonRec(int n) {
		// TODO Auto-generated method stub
		int first = 1;
		int second = 1;
		System.out.print(first);
		while(second <= n)
		{System.out.print("\t");
		System.out.print(second);
		int temp = second;
		second += first;
		first = temp;
			
		}
		

	}
	public static void main(String[] args) {
		Que2.fibNonRec(10);
		System.out.println("");
		Que2.fibRec(1,1,10);

	}

}
