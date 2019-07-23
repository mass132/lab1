package lab14.com.cg.eis.service;

import lab14.com.cg.eis.bean.Employee;

public class EmployeeService implements EmployeeServiceI  {
		
		Employee emp = new Employee();
		public void setUserInformation(int empId, String empName, int empSalary, String empDesignation) {
			emp.setEmpId(empId);
			emp.setEmpName(empName);
			emp.setEmpSalary(empSalary);
			emp.setEmpDesignation(empDesignation);
		}
		
		public String findInsuranceScheme(int empSalary,String empDesignation) {
			
			if(empSalary > 5000 && empSalary < 20000 && empDesignation.equals("System Associate")) {
				emp.setEmpInsuranceScheme("Scheme c");
			}
			else if(empSalary >= 20000 && empSalary < 40000 && empDesignation.equals("Programmer")) {
				emp.setEmpInsuranceScheme("Scheme B");
			}
			else if(empSalary >= 40000 && empDesignation.equals("Manager")) {
				emp.setEmpInsuranceScheme("Scheme A");
			}
			else if(empSalary < 5000 && empDesignation.equals("Clerk")) {
				emp.setEmpInsuranceScheme("No Scheme");
			}
			else {
				return "Insurance cannot fetch ,you provide wrong input";
			}
			
			return emp.getEmpInsuranceScheme();
			
		}
		public String getUserData() {
	
			String scheme = findInsuranceScheme(emp.getEmpSalary(), emp.getEmpDesignation());
			return "employee id = "+emp.getEmpId()+"\nemployee name = "+
			emp.getEmpName()+"\nemployee designation = "+emp.getEmpDesignation()+
			"\nemployee salary = "+emp.getEmpSalary()+"\nemployee insurance scheme = "+scheme;
		}

	}
