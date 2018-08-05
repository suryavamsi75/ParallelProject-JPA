package com.cg.account.dao;

import java.time.LocalDateTime;  
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cg.account.beans.Account;
import com.cg.account.exception.AccountException;


public class AccountDao implements IAccountDao{
//	static HashMap<String, Account> accountEntry=AccountDB.getAccountDb();
	EntityManagerFactory fact=Persistence.createEntityManagerFactory("JPA-PU");
	EntityManager em=fact.createEntityManager();
	@Override
	public String createAccount(Account account) throws AccountException {
		em.getTransaction().begin();
		em.persist(account);
		em.getTransaction().commit();
		return account.getphone();
	}

	@Override
	public double AccountBalance(String phone) throws AccountException {
		String strqry="select e from Account e where e.mobile_no=?";
		TypedQuery<Account> query=em.createQuery(strqry,Account.class);
		query.setParameter(1,phone);
		Account acc=query.getSingleResult();
   if(!phone.equals(acc.getphone())){
	throw new AccountException("the mobile number is not there in the data base");}
   else{
		return acc.getBalance();
	}
	}
	@Override
	public Account deposit(String phone,double balance) throws AccountException {
		em.getTransaction().begin();
		String strqry="select e from Account e where e.phone=?";
		TypedQuery<Account> query=em.createQuery(strqry,Account.class);
		query.setParameter(1,phone);
		Account acc=query.getSingleResult();
		if(acc==null){
			throw new AccountException("the mobile number is not there in the data base");
		}
		double d=acc.getBalance()+balance;
		acc.setBalance(d);
		em.merge(acc);
		em.getTransaction().commit();
		return acc;
	}

	@Override
	public Account withdraw(String phone,double balance) throws AccountException {
		em.getTransaction().begin();
		String strqry="select e from Account e where e.phone=?";
		TypedQuery<Account> query=em.createQuery(strqry,Account.class);
		query.setParameter(1,phone);
		Account acc=query.getSingleResult();
		if(acc==null){
			throw new AccountException("the mobile number is not there in the data base");
		}
		double d=acc.getBalance()-balance;
		acc.setBalance(d);
		em.merge(acc);
		em.getTransaction().commit();
		
		return acc;
	}

	@Override
	public Account TransactionDetails(String phone)
			throws AccountException {
		String strqry="select e from Account e where e.phone=?";
		TypedQuery<Account> query=em.createQuery(strqry,Account.class);
		query.setParameter(1,phone);
		Account acc=query.getSingleResult();
   if(acc==null){
	throw new AccountException("the mobile number is not there in the data base");

}
		return acc;
	}

	@Override
	public boolean fundTransfer(String sourcephone, String destphone,
			double transferAmount) throws AccountException {
		String strqry="select e from Account e where e.phone=?";
			TypedQuery<Account> query=em.createQuery(strqry,Account.class);
			query.setParameter(1,sourcephone);
			Account acc=query.getSingleResult();
			String strqry1="select e from Account e where e.mobile_no=?";
			TypedQuery<Account> query1=em.createQuery(strqry1,Account.class);
			query1.setParameter(1,destphone);
			Account acc1=query.getSingleResult();
		if(acc==null){
			throw new AccountException("the mobile number is not there in the data base");
		}
		else if(acc1==null)
		{
			throw new AccountException("the mobile number is not there in the data base");
		}
		else
		{
		return true;
		}
	}


}
