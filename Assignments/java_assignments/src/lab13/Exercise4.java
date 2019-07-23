package lab13;

import java.util.Scanner;

@FunctionalInterface
interface ReferenceInterface
{
	MethodReference testMethod(int sampleData);
}
class MethodReference
{
	private int sampleData;

	MethodReference(int sampleData) {
		super();
		this.sampleData = sampleData;
		System.out.println(sampleData);
	}

	public int getSampleData() {
		return sampleData;
	}

	public void setSampleData(int sampleData) {
		this.sampleData = sampleData;
	}
}
public class Exercise4 {
	public static void main(String[] args) {
		ReferenceInterface object = MethodReference::new;
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();//int as input
		scan.close();
		object.testMethod(input);
		
	}

}
