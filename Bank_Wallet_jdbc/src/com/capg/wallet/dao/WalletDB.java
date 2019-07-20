package com.capg.wallet.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class WalletDB {
	private static final String DB_SERVER = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "poonsahu";
	private static final String PASSWORD = "mypass";

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(DB_SERVER, USERNAME, PASSWORD);
		return conn;
	}

	static {
		Connection conn;
		Statement stmt = null;
		ResultSet result = null;
		DatabaseMetaData dbm = null;
		try {
			conn = getConnection();
			dbm = conn.getMetaData();
			result = dbm.getTables(null, null, "bank_wallet_account", null);
			if (!result.next()) {
				stmt = conn.createStatement();
				stmt.execute(
						"CREATE TABLE bank_wallet_account(accnum varchar2(13) primary key,name varchar2(20),mobile varchar2(10),balance number(10,3),dob varchar2(30),password varchar2(15))");
			}
			result = dbm.getTables(null, null, "bank_wallet_transaction", null);
			if (!result.next()) {
				stmt = conn.createStatement();
				stmt.execute(
						"CREATE TABLE bank_wallet_transaction(id varchar2(8) primary key,time varchar2(30),accfrom varchar2(13),accto varchar2(13),amount number(10,3),balance number(10,3),remark varchar2(15))");
			}
			conn.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Could not load the jdbc driver. Please try again!");
		} catch (SQLException e) {

		}

	}

}
