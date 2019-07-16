package com.cg.mra.dao;

import com.cg.mra.entities.Account;

import java.util.HashMap;
import java.util.Map;


public class AccountDaoImpl implements AccountDao {

    private Map<String, Account> accountEntry;

    protected Map<String, Account> getAccountEntry() {
        return accountEntry;
    }
    public AccountDaoImpl() {
        accountEntry = new HashMap<>();
        Account account1 = new Account("prepaid", "Vaishali", 200);
        accountEntry.put("9010210131", account1);
        Account account2 = new Account("prepaid", "Megha", 450);
        accountEntry.put("9823920123", account2);
        Account account3 = new Account("prepaid", "Vikas", 631);
        accountEntry.put("9932012345", account3);
        Account account4 = new Account("prepaid", "Anju", 521);
        accountEntry.put("9010210131", account4);
        Account account5 = new Account("prepaid", "Tushar", 632);
        accountEntry.put("9010210131", account5);

    }
    public Account getAccount(final String mobileNo) {
        return getAccountEntry().get(mobileNo);
    }
    /**
     *  fetches account details
     *
     * @param mobileNo
     * @return Account related to mobileno
     */
    @Override
    public Account getAccountDetails(final String mobileNo) {
        validationCheck(mobileNo);
        Account account = getAccount(mobileNo);
        return account;
    }

    /**
     *  method which will throw exception if number is NOT Found
     *  Done separately so we can reuse it
     *
     * @param mobileNo
     */
    public void validationCheck(final String mobileNo) {
        boolean noExists = getAccountEntry().containsKey(mobileNo);
        if (!noExists) {
            throw new AccountNotFoundException("No Account found for this number=" + mobileNo);
        }

    }

    /**
     * We can return the balance after recharge in double but in the question integer is used so
     * using integer for total balance
     *
     */
    @Override
    public int rechargeAccount(final String mobileNo, final double rechargeAmount) {
        validationCheck(mobileNo);
        Account account = getAccount(mobileNo);
        double initialBalance = account.getAccountBalance();
        double balanceNow = initialBalance + rechargeAmount;
        return (int) balanceNow;
    }


}
