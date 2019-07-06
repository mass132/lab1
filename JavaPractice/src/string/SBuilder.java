package string;

public class SBuilder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder("Hello");
		System.out.println(sb);
		sb.append(55);
		System.out.println(sb);
		char[] charArray = { 'a', 'b', 'c' };
		sb.append(charArray, 0, 2);
		System.out.println(sb);
		sb.delete(0, 2);
		System.out.println(sb);
		sb.insert(0, "He");
		System.out.println(sb);
		sb.reverse();
		System.out.println(sb);
		sb.setLength(1000);
		sb.append(34);
		System.out.println(sb);
		StringBuffer sb1 = new StringBuffer();
		sb1.append(1);
	}

}
