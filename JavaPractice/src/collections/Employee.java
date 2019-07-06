package collections;

public class Employee {
	private int empId = 121;
	private String empName = "Suresh";
	private int empSalary = 34242;
	private String empLoc = "Chennai";

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}

	public String getEmpLoc() {
		return empLoc;
	}

	public void setEmpLoc(String empLoc) {
		this.empLoc = empLoc;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[Employee ID : "+empId+", Employee Name : "+ empName +", Employee Location : "+ empLoc + ", Employee Salary : " + empSalary + "]"; 
	}

}
