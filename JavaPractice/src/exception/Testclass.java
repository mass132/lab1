package exception;

public class Testclass {
int a;
Testclass(int a)
{
	this.a=a;
}
void print()
{
	System.out.println(a);
}
public static void main(String[] args) {
	Testclass a1 = new Testclass(2);
	a1.print();
}
}
