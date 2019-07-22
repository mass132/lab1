package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeModule {

	static Scanner sc = new Scanner(System.in);
	static int deposit_statement;
	static int withdraw_statement;
	static String fromAccount;
	static String toAccount;
	static int transferAmount;
	static String emp_id;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		int close = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// First Step //
		// loading the driver class --> Oracle Class available in --> oracle.jdbc.driver
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// Second Step //
		// Create the connection --> Driver Manager

		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "abc", "abc123");

		while (close == 0) {

			System.out.println("1. Create Account ");
			System.out.println("2. Show Info ");
			System.out.println("3. Update Info");
			System.out.println("4. Delete Info");
			System.out.println("5. Log out");
			System.out.println("Enter your choice :");

			int input = sc.nextInt();

			switch (input) {
			case 1:
				String Q_insert = "insert into EmployeeInfo(emp_id, name, salary, phone_no) values(?, ?, ?, ?)";

				System.out.println("Enter your Employee/Global ID : ");
				int account_no = sc.nextInt();

				System.out.println("Enter Your Name : ");
				String name = sc.next();

				System.out.println("Enter your salary : ");
				int salary = sc.nextInt();

				String phone_no = null;
				boolean phone_result = false;
				while (phone_result == false) {
					System.out.println("Enter your phone no : ");
					phone_no = sc.next();

					if (phone_no.length() == 10) {
						phone_result = true;

					} else {
						System.out.println("Invalid length");
					}
				}

				pstmt = conn.prepareStatement(Q_insert); // create a statement
				pstmt.setInt(1, account_no); // set input parameter 1
				pstmt.setString(2, name); // set input parameter 2
				pstmt.setString(3, phone_no); // set input parameter 3
				pstmt.setInt(4, salary);

				int i = pstmt.executeUpdate(); // execute insert statement
				if (i == 1) {

					System.out.println("**********Account created successfully!**********");
				} else {
					System.out.println("Account creation failed!");
				}

				break;

			case 2:
				String Q_select = "select emp_id,name,salary,phone_no" + " from EmployeeInfo where emp_id = ?";
				pstmt = conn.prepareStatement(Q_select); // create a statement
				System.out.println("Enter your Employee ID : ");
				emp_id = sc.next();

				pstmt.setString(1, emp_id); // set input parameter
				rs = pstmt.executeQuery();
				System.out.println("asda");
				// extract data from the ResultSet
				while (rs.next()) {
					System.out.println("sadas2");
					int empId = rs.getInt(1);
					String empName = rs.getString(2);
					String EmpSalary = rs.getString(3);
					int Empphone_no = rs.getInt(4);

					System.out.println("Your ID : " + empId);
					System.out.println("Your Name : " + empName);
					System.out.println("Your Salary : " + EmpSalary);
					System.out.println("Your Phone No : " + Empphone_no);

				}

				break;

			case 3:
				System.out.println("Enter your Employee ID : ");
				emp_id = sc.next();
				String column_name;
				System.out.println("What you want to update ?\n1. Name\n2. Phone No");
				int choice = sc.nextInt();
				if (choice == 1) {
					column_name = "name";
				} else {
					column_name = "phone_no";
				}
				System.out.println("Enter new value :");
				String newValue = sc.next();

				String Q_update_2 = "update EmployeeInfo set " + column_name + " = ? where emp_id = ? ";
				pstmt = conn.prepareStatement(Q_update_2);

				pstmt.setString(1, newValue);
				pstmt.setString(2, emp_id);
				int update = pstmt.executeUpdate();
				if (update == 1) {
					System.out.println("Info Updated");
				} else {
					System.out.println("Sorry, Something went wrong!!");
				}

				break;
			case 4:

				System.out.println("Enter your Employee ID : ");
				emp_id = sc.next();
				String column_name_2;
				System.out.println("What you want to delete ?\n1. Name\n2. Phone No");
				int choice_2 = sc.nextInt();
				if (choice_2 == 1) {
					column_name_2 = "name";
				} else {
					column_name_2 = "phone_no";
				}

				String Q_delete = "update EmployeeInfo set " + column_name_2 + " = null where emp_id = ?";
				pstmt = conn.prepareStatement(Q_delete);

				pstmt.setString(1, emp_id);
				int update_2 = pstmt.executeUpdate();
				if (update_2 == 1) {
					System.out.println("Info Deleted");
				} else {
					System.out.println("Sorry, Something went wrong!!");
				}

				break;

			case 5:
				System.out.println("You have been successfully logged out");
				System.out.println("Do you want to exit ? press 0 to continue 1 to exit");
				close = sc.nextInt();
				if (close == 0) {
					close = 0;
				} else {
					System.exit(0);
				}

				break;

			default:
				System.out.println("Please enter valid choice!");

				break;

			}
			sc.close();
		}
	}
}