package string;

public class StringExample1 {
	public static void main(String[] args) {
		String s1 = "Hello";
		String s2 = "Hello";
		String s3 = new String("Hello");
		System.out.println(s1.equals(s2));
		System.out.println(s2 == s1);

		s2 = "Poonam";
		s1.concat(s2);
		System.out.println(s1);
		System.out.println(s1.equals(s2));
		System.out.println(s2 == s1);
		System.out.println(s2 == s3);

		char[] ch = { 'j', 'a', 'v', 'a' };
		byte[] byteArray = { 97, 123, 111, };
		int[] intArray = { 97, 98, 100, 101, 102, 103, 104 };
		System.out.println(new String(ch));
		System.out.println(new String());
		System.out.println(new String(ch, 1, 2));
		System.out.println(new String(byteArray));
		System.out.println(new String(intArray, 1, 5));
		System.out.println(s2.length());
		System.out.println(s2.isEmpty());
		System.out.println(s2.charAt(0));
		String s4 = "ABCD";
		System.out.println(s4.codePointBefore(1));
		System.out.println(s4.codePointAt(1));
		System.out.println(s4.codePointCount(0, 3));

		String s5 = "abcD";
		String s6 = "abABab";

		System.out.println(s4.equalsIgnoreCase(s5));
		System.out.println(s4.compareTo(s5));
		System.out.println(s4.compareToIgnoreCase(s5));
		System.out.println(s4.indexOf("C"));
		System.out.println(s4.indexOf("BC"));
		System.out.println(s4.indexOf("A", 1));
		System.out.println(s6.lastIndexOf("ab"));

		System.out.println(s6.substring(1, 2));
		System.out.println(s6.subSequence(1, 3));

		System.out.println(s6.concat("helo"));

		System.out.println(s5.replace("D", "d"));
		System.out.println(s5.replace("ab", "cd"));
		System.out.println(s6.replaceFirst("ab", "XY"));
		System.out.println(s6.replaceAll("ab", "XY"));

		String s7 = "Hello My Name is Poonam";
		String[] strArray = s7.split(" ");
		System.out.println(strArray[1]);

		strArray = s7.split(" ", 2);
		System.out.println(strArray[1]);
		System.out.println(String.join("=","hello","you"));
		System.out.println(s7.toLowerCase());
		System.out.println(s7.toUpperCase());
		Integer a = 1;
		String b = a.toString();
		System.out.println(b);
		String s8 = s7.intern();
		System.out.println(s8);
		
		/*
		 * StringBuffer sb1 = new StringBuffer("Hello"); StringBuffer sb2 = new
		 * StringBuffer("Hello"); System.out.println(sb1.equals(sb2));
		 * System.out.println(sb2 == sb1); //sb1.append(sb2); System.out.println(sb1);
		 * //System.out.println((new String(sb1)).equals(new String(sb2)));
		 * System.out.println(sb1.toString().equals(sb2.toString()));
		 */

	}

}
