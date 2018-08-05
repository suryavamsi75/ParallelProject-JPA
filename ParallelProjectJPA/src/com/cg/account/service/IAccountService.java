package com.cg.account.service;

import com.cg.account.beans.Account;
import com.cg.account.exception.AccountException;

public interface IAccountService {

	public String createAccount(Account account) throws AccountException;
	public double AccountBalance(String mobileNo) throws AccountException;
	public Account deposit(String mobileNo,double depositAmount) throws AccountException;
	public Account withdraw(String mobileNo,double withdrawAmount) throws AccountException;
	public Account TransactionDetails(String mobileNo) throws AccountException;
    public boolean fundTransfer(String sourceMobileNo,String destMobileNo,double transferAmount) throws AccountException;
}
