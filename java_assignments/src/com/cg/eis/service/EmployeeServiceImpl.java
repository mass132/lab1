package com.cg.eis.service;

import com.cg.eis.bean.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public void findInsuranceScheme(Employee e) {
		double salary = e.getSalary();
		String scheme = "No Scheme";
		String designation = e.getDesignation();
		if (salary > 5000) {
			if (salary < 20000 && designation.equals("System Associate"))
				scheme = "Scheme C";
			else if (salary >= 20000 && salary < 40000 && designation.equals("Programmer"))
				scheme = "Scheme B";
			else if (salary >= 40000 && designation.equals("Manager"))
				scheme = "Scheme A";
		}
		e.setInsuranceScheme(scheme);

	}

	@Override
	public void displayEmployeeDetails(Employee e) {
		System.out.println("Employee Name\t:\t" + e.getName());
		System.out.println("Employee Name\t:\t" + e.getId());
		System.out.println("Employee Salary\t:\t" + e.getSalary());
		System.out.println("Employee Name\t:\t" + e.getDesignation());
		System.out.println("Employee Name\t:\t" + e.getInsuranceScheme());
	}

}
