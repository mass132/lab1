package basic;

public class Boxing {
public static void main(String[] args) {
	int a = 10;
	
	//Boxing
	Integer a1 = new Integer(a);
	Integer a2 = Integer.valueOf(a);
	System.out.println(a1);
	System.out.println(a2);
	//Auto-Boxing
	Integer a3 = a;
	System.out.println(a3);
	
	//UnBoxing
	Integer b = new Integer(20);
	int x = b.intValue();
	System.out.println(x);
	
	//Auto-Unboxing
	int y = b;
	System.out.println(y);
	//Character c = new Character('c');
	System.out.println(Integer.toHexString(15));
	System.out.println(Integer.BYTES);
}
}
