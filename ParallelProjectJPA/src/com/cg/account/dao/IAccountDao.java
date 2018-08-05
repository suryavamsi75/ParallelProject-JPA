package com.cg.account.dao;

import com.cg.account.beans.Account;
import com.cg.account.exception.AccountException;


public interface IAccountDao {
	public String createAccount(Account account) throws AccountException;
	public double AccountBalance(String mobileNo) throws AccountException;
	Account deposit(String mobileNo,double balance) throws AccountException;
	Account withdraw(String mobileNo,double balance) throws AccountException;
    Account TransactionDetails(String mobileNo) throws AccountException;
   public boolean fundTransfer(String sourceMobileNo,String destMobileNo,double transferAmount) throws AccountException;
}
