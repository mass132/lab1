package com.capgemini.xyz.service;

import com.capgemini.xyz.bean.Customer;
import com.capgemini.xyz.bean.Loan;
import com.capgemini.xyz.dao.ILoanDao;
import com.capgemini.xyz.dao.LoanAppException;
import com.capgemini.xyz.dao.LoanDao;
import com.capgemini.xyz.util.Util;

public class LoanService implements ILoanService {
	private static final ILoanDao loanDao = new LoanDao();

	public static ILoanDao getLoanDao() {
		return loanDao;
	}

	@Override
	public Loan applyLoan(Loan loan) {
		getLoanDao().applyLoan(loan);
		return loan;
	}

	@Override
	public Customer validateCustomer(Customer customer) throws LoanAppException {
		if (customer == null) {
			throw new LoanAppException("Invalid Details entered!");
		}
		if (!Util.validateName(customer.getCustName())) {
			throw new LoanAppException("Please enter a valid name!");

		}
		if (!Util.validateEmail(customer.getEmail())) {
			throw new LoanAppException("Please enter a valid email!");

		}
		if (!Util.validateAddress(customer.getAddress())) {
			throw new LoanAppException("Please enter a valid Address!");

		}
		return customer;
	}

	@Override
	public long insertCust(Customer cust) {
		long custId = getLoanDao().insertCust(cust);
		return custId;
	}

	@Override
	public double calculateEMI(double amount, int duration) {
		double rate = 9.5f;
		double emi = amount * rate * (1 + rate) * duration / (((1 + rate) * duration) - 1);
		return emi;
	}

	public Customer getCustomerDetails(long custId) {
		Customer customer = LoanDao.getCustomerEntry().get(custId);
		return customer;
	}

}
