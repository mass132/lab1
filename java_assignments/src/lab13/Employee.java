package lab13;

import java.time.LocalDate;

public class Employee {
	private Integer employeeID;
	private String firstName;
	private String LastName;
	private String email;
	private String phoneNumber;
	private LocalDate hireDate;
	private String designation;
	private Double salary;
	private Integer managerId;
	private Department department;

	// public Employee() {
	// // TODO Auto-generated constructor stub
	// }

	public Employee(Integer employeeID, String firstName, String lastName, String email, String phoneNumber,
			LocalDate hireDate, String designation, Double salary, Integer managerId, Department department) {

		this.employeeID = employeeID;
		this.firstName = firstName;
		LastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.designation = designation;
		this.salary = salary;
		this.managerId = managerId;
		this.department = department;
	}

	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee ID:" + employeeID + ", First Name:" + firstName + ", Last Name:" + LastName + ", Email:"
				+ email + ", Phone Number:" + phoneNumber + ", Hire Date:" + hireDate + ", Designation:" + designation
				+ ", Salary:" + salary + ", Manager Id:" + managerId + ", Department:" + department;
	}

}
