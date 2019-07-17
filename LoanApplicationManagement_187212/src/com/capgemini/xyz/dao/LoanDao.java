package com.capgemini.xyz.dao;

import java.util.HashMap;
import java.util.Map;

import com.capgemini.xyz.bean.Customer;
import com.capgemini.xyz.bean.Loan;
import com.capgemini.xyz.util.Util;

public class LoanDao implements ILoanDao {

	private static final Map<Long, Customer> customerEntry = new HashMap<Long, Customer>();
	private static final Map<Long, Loan> loanEntry = new HashMap<Long, Loan>();

	public static Map<Long, Customer> getCustomerEntry() {
		return customerEntry;
	}

	public static Map<Long, Loan> getLoanEntry() {
		return loanEntry;
	}

	@Override
	public long applyLoan(Loan loan) {
		long loanId = Util.generateLoanId();
		loan.setLoanID(loanId);
		loanId = getLoanEntry().putIfAbsent(loan.getCustId(), loan).getLoanID();
		return loanId;
	}

	@Override
	public long insertCust(Customer cust) {
		long custId = Util.generateCustId();
		cust.setCustId(custId);
		getCustomerEntry().putIfAbsent(cust.getCustId(), cust).getCustId();
		return custId;
	}

}
