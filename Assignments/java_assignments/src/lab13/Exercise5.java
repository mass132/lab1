package lab13;

import java.util.Scanner;

interface Fact
{
	void calculate(long num);
}
public class Exercise5 {
	void calculateFact(long num)
	{ long n = num;
	long fact = 1;
		while(n > 0)
		{
			fact *= n;
			n--;
		}
		System.out.println("Factorial of "+num+" is : "+fact);
	}
	static public void main(String[] args) {
		Fact f = new Exercise5()::calculateFact;
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();//int as input
		scan.close();
		f.calculate(input);
	}

}
