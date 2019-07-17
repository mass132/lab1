package com.capgemini.xyz.dao;

import com.capgemini.xyz.bean.Customer;
import com.capgemini.xyz.bean.Loan;

public interface ILoanDao {

	public long applyLoan(Loan loan);

	public long insertCust(Customer cust);

}
