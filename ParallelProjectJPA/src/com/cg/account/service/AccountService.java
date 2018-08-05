package com.cg.account.service;

import java.time.LocalDateTime;

import com.cg.account.beans.Account;
import com.cg.account.dao.IAccountDao;
import com.cg.account.dao.AccountDao;
import com.cg.account.exception.AccountException;

public class AccountService implements IAccountService {
IAccountDao dao=new AccountDao();
	
	@Override
	public String createAccount(Account account) throws AccountException {
	if(!account.getphone().matches("\\d{10}")){
		throw new AccountException("Mobile number should contain 10 digits");
	}
	if(account.getname().isEmpty()||account.getname()==null){
		throw new AccountException("Name cannot be empty");
	} else{
		if(!account.getname().matches("[A-Z][A-Za-z]{3,}")){
			throw new AccountException("Name should start with Capital letter and should contain only alphabets");
		}
	}
	if(!account.getemail().matches("[a-z0-9]+@[a-z]+\\.com")){
		throw new AccountException("Enter a valid EmailID");
	}
	if(account.getBalance()<=0){
		throw new AccountException("Balance should be greater than zero");
	}
		return dao.createAccount(account);
	}

	@Override
	public double AccountBalance(String phone) throws AccountException {
		if(!phone.matches("\\d{10}")){
			throw new AccountException("Mobile number should contain 10 digits");
		}
		return dao.AccountBalance(phone);
	}

	@Override
	public Account deposit(String phone, double depositAmount)
			throws AccountException {
		if(!phone.matches("\\d{10}")){
			throw new AccountException("Mobile number should contain 10 digits");
		}
		Account account=dao.deposit(phone, depositAmount);
		if(depositAmount<=0){
				throw new AccountException("deposit amount must be greater than zero");
		}
		//account.setBalance(account.getBalance()+depositAmount);
		//account.setDate(LocalDateTime.now());
		return account;
	}

	@Override
	public Account withdraw(String phone, double withdrawAmount)
			throws AccountException {
		Account account=dao.withdraw(phone, withdrawAmount);
		if(!phone.matches("\\d{10}")){
			throw new AccountException("Mobile number should contain 10 digits");
		}
		else if(withdrawAmount<=0){
			throw new AccountException("Amount should be greater than zero");	
		}
		else if(withdrawAmount>account.getBalance()){
			throw new AccountException("Balance should be greater than the withdraw amount");
		}
		/*else if(!phone.equals(account.getMobile_no())){
			throw new AccountException("the mobile number is not there in the data base");
		}*/
		
		else{
			return account;
			}
		}
	
	

	@Override
	public Account TransactionDetails(String phone)
			throws AccountException {
		if(!phone.matches("\\d{10}")){
			throw new AccountException("Mobile number should contain 10 digits");
		}
		else
		{
		return dao.TransactionDetails(phone);
	}}

	@Override
	public boolean fundTransfer(String sourcephone, String destphone, double transferAmount) throws AccountException {
		if(!sourcephone.matches("\\d{10}")){
			throw new AccountException("Mobile number should contain 10 digits");
		}
			if(!destphone.matches("\\d{10}")){
				throw new AccountException("Mobile number should contain 10 digits");
			}
		IAccountService service =new AccountService();
		service.withdraw(sourcephone, transferAmount);
		service.deposit(destphone, transferAmount);
		
		return true;
	}


}