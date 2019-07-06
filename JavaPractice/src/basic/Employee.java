package basic;
public class Employee
{
	public static void main(String args[])
	{
		if(args.length > 0)
		{
			int empId = Integer.parseInt(args[0]);
			String empName = args[1];
			int empSalary = Integer.parseInt(args[2]);
			String empLoc = args[3];
			System.out.print("Employee ID : ");
			System.out.println(empId);
			System.out.print("Employee Name : ");
			System.out.println(empName);
			System.out.print("Employee Salary : ");
			System.out.println(empSalary);
			System.out.print("Employee Location : ");
			System.out.println(empLoc);
		}
	}
	public static void Main1()
	{
		System.out.println("Hello from Employee class");
	}
}