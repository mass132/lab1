package java8_features;

import java.util.ArrayList;
import java.util.function.BiConsumer;

public class BiConsumerEx {

	public static void main(String[] args) {
		BiConsumer<Employee1, Double> incSal = (empObj,sal)->empObj.eSal +=sal;
		ArrayList<Employee1> al = new ArrayList<Employee1>();
		Employee1 emp1 = new Employee1("poonam", 5000);
		Employee1 emp2 = new Employee1("ram", 6000);
		Employee1 emp3 = new Employee1("raj", 8000);
		al.add(emp1);
		al.add(emp2);
		al.add(emp3);
		for(Employee1 e : al)
		{
			incSal.accept(e, 10.0);
		}
		System.out.println(al);
	}

}
class Employee1
{
	String eName;
	double eSal;
	Employee1(String eName,double eSal)
	{
		this.eName = eName;
		this.eSal = eSal;
		
	}
	@Override
	public String toString() {
		return "Employee1 [eName=" + eName + ", eSal=" + eSal + "]\n";
	}
	
}