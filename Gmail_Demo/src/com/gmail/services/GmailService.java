package com.gmail.services;

import com.gmail.beans.UserBean;
import com.gmail.dao.GmailDAO;

public class GmailService implements GmailServiceInterface{

	@Override
	public int addUser(String username, String password, String mobile, int age) {
		int isEligible = 0;
		if(age >=18)
		{
			isEligible = 1;
		}
		GmailDAO gmailDAO = new GmailDAO();
		UserBean userBean = new UserBean();
		userBean.setUsername(username);
		userBean.setPassword(password);
		userBean.setMobile(mobile);
		userBean.setAge(age);
		userBean.setEligible(isEligible);
		int updateResult = 0;
		try {
			updateResult = gmailDAO.addUser(userBean);
			return updateResult;
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
		return updateResult;
	}

}
