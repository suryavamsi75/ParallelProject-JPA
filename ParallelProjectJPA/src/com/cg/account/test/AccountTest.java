package com.cg.account.test;
import static org.junit.Assert.*;

import org.junit.Test;

import com.cg.account.beans.Account;
import com.cg.account.exception.AccountException;
import com.cg.account.service.IAccountService;
import com.cg.account.service.AccountService;

public class AccountTest { 

	private IAccountService service= new AccountService();
	
	@Test
	public void testCreateAccountForMobile() {
	Account ac = new Account();
	ac.setphone("9999");
	ac.setname("Surya");
	ac.setemail("Surya@gmail.com");
	ac.setBalance(200.0);
	try {
	service.createAccount(ac);
	} catch (AccountException e) {
	assertEquals("Mobile number should contain 10 digits", e.getMessage());
	}
	}
	 
	@Test
	public void testCreateAccountForName() {
	Account ac = new Account();
	ac.setphone("9999999999");
	ac.setname("vamsi123");
	ac.setemail("vamsi@gmail.com");
	ac.setBalance(500.0);
	try {
	service.createAccount(ac);
	} catch (AccountException e) {
	assertEquals("Name should start with Capital letter and should contain only alphabets", e.getMessage());
	}
	}
	 
	@Test
	public void testCreateAccountForNameIsEmpty() {
	Account ac = new Account();
	ac.setphone("9999999999");
	ac.setname("");
	ac.setemail("deepak@gmail.com");
	ac.setBalance(200.0);
	try {
	service.createAccount(ac);
	} catch (AccountException e) {
	assertEquals("Name cannot be empty", e.getMessage());
	}
	}	 
	@Test
	public void testCreateAccountForEmailId() {
	Account ac = new Account();
	ac.setphone("9999999999");
	ac.setname("Surya");
	ac.setemail("Surya@@23gmail.com");
	ac.setBalance(200.0);
	try {
	service.createAccount(ac);
	} catch (AccountException e) {
	assertEquals("Enter a valid EmailID", e.getMessage());
	}
	}
	@Test
	public void testCreateAccount() {
	Account ac = new Account();
	ac.setphone("9999999999");
	ac.setname("Surya");
	ac.setemail("surya@gmail.com");
	ac.setBalance(200.0);
	 
	try {
	String s=service.createAccount(ac);
	assertNotNull(s);
	} catch (AccountException e) { 
	}	 
	}
	 
	@Test
	public void testShowBalanceForMobileNo() {
	try {
	service.AccountBalance("950349");
	} catch (AccountException e) {
	assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
	}
	
	@Test
	public void testDepositForMobileNo() {
	Account ac=new Account();
	ac.setphone("95054445");
	try {
	service.deposit(ac.getphone(), 230);
	} catch (AccountException e) {
	assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
	}
	@Test
	public void testDepositForDepositAmt1() {
	Account ac=new Account();
	ac.setphone("6666666666");
	try {
	service.deposit(ac.getphone(), -230);
	} catch (AccountException e) {
	assertEquals("deposit amount must be greater than zero",e.getMessage());
	}
	}
	
	@Test
	public void testDepositForDepositAmt1IsZero() {
	Account ac=new Account();
	ac.setphone("6666666666");
	try {
	service.deposit(ac.getphone(), 0);
	} catch (AccountException e) {
	assertEquals("deposit amount must be greater than zero",e.getMessage());
	}
	}
	
	@Test
	public void testWithdrawForAmt() {
	Account ac=new Account();
	ac.setphone("6666666666");
	try {
	service.withdraw(ac.getphone(), -230);
	} catch (AccountException e) {
	assertEquals("Amount should be greater than zero",e.getMessage());
	}
	}
	
	@Test
	public void testWithdrawForAmtIsZero() {
	Account ac=new Account();
	ac.setphone("6666666666");
	try {
	service.withdraw(ac.getphone(),0);
	} catch (AccountException e) {
	assertEquals("Amount should be greater than zero",e.getMessage());
	}
	}
	 
	@Test
	public void testFundTransferForMobileNo() {
	Account ac=new Account();
	Account ac2=new Account();
	ac.setphone("95559345");
	ac2.setphone("1234");
	try {
	service.fundTransfer(ac.getphone(),ac2.getphone(), 230);
	} catch (AccountException e) {
	assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
	}

	@Test
	public void testFundTransferForAmt() {
	Account ac=new Account();
	Account ac2=new Account();
	ac.setphone("6666666666");
	ac2.setphone("7777777777");
	try {
	service.fundTransfer(ac.getphone(), ac2.getphone(),  -230);
	} catch (AccountException e) {
	// TODO Auto-generated catch block
	assertEquals("Amount should be greater than zero",e.getMessage());
	}
	}
	@Test
	public void testFundTransfer() {
	Account ac=new Account();
	Account ac2=new Account();
	ac.setphone("6666666666");
	ac2.setphone("7777777777");
	try {
	assertTrue(service.fundTransfer(ac.getphone(), ac2.getphone(),  230));
	} catch (AccountException e) {
	}
	}
	@Test
	public void testPrinttransactionDetails() {
	Account ac=new Account();
	ac.setphone("8888888888");
	try {
	Account acc=service.TransactionDetails(ac.getphone());
	assertNotNull(acc);
	} catch (AccountException e) {
	//System.out.println(e.getMessage());
	}
	}
	
	@Test
	public void testPrinttransactionDetailsForMobile() {
		Account ac=new Account();
		ac.setphone("950593");
		try {
		Account acc=service.TransactionDetails(ac.getphone());
		} catch (AccountException e) {
		assertEquals("Mobile number should contain 10 digits",e.getMessage());
		}
	}
	
	@Test
	public void testPrinttransactionDetailsForMobileDoesNotExist() {
		Account ac=new Account();
		ac.setphone("1234567890");
		try {
		Account acc=service.TransactionDetails(ac.getphone());
		} catch (AccountException e) {
		assertEquals("the mobile number is not there in the data base",e.getMessage());
		}
	}
	
	@Test
	public void testFundTransferForFirstMobile() {
	Account ac=new Account();
	Account ac2=new Account();
	ac.setphone("950592");
	ac2.setphone("9848468242");
	try {
		service.fundTransfer(ac.getphone(),ac2.getphone(),230);
	} catch (AccountException e) {
		assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
	}
	
	@Test
	public void testFundTransferForSecondMobile() {
	Account ac=new Account();
	Account ac2=new Account();
	ac.setphone("9999999999");
	ac2.setphone("9848");
	try {
		service.fundTransfer(ac.getphone(),ac2.getphone(),230);
	} catch (AccountException e) {
		assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
	}
}
