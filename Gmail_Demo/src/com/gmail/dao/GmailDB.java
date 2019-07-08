package com.gmail.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GmailDB {
	private static final String dbUsername = "poonsahu";
	private static final String dbPassword = "mypass";
	private static final String dbClassName = "oracle.jdbc.driver.OracleDriver";
	private static final String dbAPI = "jdbc:oracle:thin:@localhost:1521:xe";

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(dbClassName);
		Connection conn = DriverManager.getConnection(dbAPI, dbUsername, dbPassword);
		return conn;

	}

}
