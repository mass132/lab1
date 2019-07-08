package com.gmail.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.gmail.beans.UserBean;

public class GmailDAO implements GmailDaoInterface {

	@Override
	public int addUser(UserBean userBean) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = GmailDB.getConnection();
			String ins_str = "insert into user1 values(?,?,?,?,?)";
			stmt = conn.prepareStatement(ins_str);
			stmt.setString(1, userBean.getUsername());
			stmt.setString(2, userBean.getPassword());
			stmt.setString(3, userBean.getMobile());
			stmt.setInt(4, userBean.getAge());
			stmt.setInt(5, userBean.isEligible());
			int updateCount = stmt.executeUpdate();
			conn.close();
			return updateCount;

		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

}