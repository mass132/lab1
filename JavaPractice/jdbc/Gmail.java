package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Gmail {
	public static void register() throws SQLException, ClassNotFoundException
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your username : ");
		String uname = scan.next();
		System.out.println("Enter new password : ");
		String password = scan.next();

		System.out.println("Enter contact number : ");
		String contact = scan.next();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","poonsahu","mypass");
		PreparedStatement st = conn.prepareStatement("insert into gmail values(?,?,?)");
		st.setString(1, uname);
		st.setString(2, password);
		st.setString(3, contact);
		int i = st.executeUpdate();
		if(i == 1)
		{
			System.out.println("Registration successful");
		}
		else {
			System.out.println("Could not register");
		}
		scan.close();
		conn.close();
	}
	public static void login() throws SQLException, ClassNotFoundException
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your username : ");
		String uname = scan.next();
		System.out.println("Enter your password : ");
		String password = scan.next();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","poonsahu","mypass");
		PreparedStatement st = conn.prepareStatement("select uname,password from gmail where uname=? and password=?");
		st.setString(1, uname);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();
		if(rs.next())
		{
			System.out.println("Login success");
		}
		else {
			System.out.println("Invalid username and password");
		}
		scan.close();
		conn.close();
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println("1.\tRegister\n2.\tLoogin");
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		switch(input)
		{
		case 1:
			register();
			break;
		case 2:
			login();
			break;
		default:
			System.out.println("Invalid input");
		}
		scan.close();
		
	}

}
