package com.capgemini.xyz.service;

import com.capgemini.xyz.bean.Customer;
import com.capgemini.xyz.bean.Loan;
import com.capgemini.xyz.dao.LoanAppException;

public interface ILoanService {
	public Loan applyLoan(Loan loan);

	public Customer validateCustomer(Customer customer) throws LoanAppException;

	public long insertCust(Customer cust);

	public double calculateEMI(double amount, int duration);

}
