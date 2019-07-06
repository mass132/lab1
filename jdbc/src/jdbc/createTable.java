package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class createTable {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "poonsahu", "mypass");
		Statement stmt = conn.createStatement();
		// boolean b = stmt.execute("create table dontsleep1(id number(10),name
		// varchar2(10))");
		// System.out.println("Table created "+!b);
		// int n = stmt.executeUpdate("insert into emp values(7800, 'KING', 'PRESIDENT',
		// null,to_date('17-11-1981','dd-mm-yyyy'),5000, null, 10)");
		// System.out.println(n +" rows inserted. ");
		ResultSet rs = stmt.executeQuery("select * from emp");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+ " " + rs.getString("ename") +" " + rs.getString("job"));
		}

		conn.close();
	}

}
