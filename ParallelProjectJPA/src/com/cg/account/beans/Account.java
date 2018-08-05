package com.cg.account.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String phone;
	private String email;
	private double balance;

public Account(){	
}


public String getname() {
	return name;
}



public void setname(String name) {
	this.name = name;
}



public String getphone() {
	return phone;
}



public void setphone(String phone) {
	this.phone = phone;
}



public String getemail() {
	return email;
}



public void setemail(String email) {
	this.email = email;
}



public double getBalance() {
	return balance;
}



public void setBalance(double balance) {
	this.balance = balance;
}


public Account(int id, String name, String phone, String email,
		double balance) {
	super();
	this.id = id;
	this.name = name;
	this.phone = phone;
	this.email = email;
	this.balance = balance;

}

@Override
public String toString() {
	return "Account [id=" + id + ", name=" + name
			+ ", phone=" + phone + ", email=" + email
			+ ", balance=" + balance + "]";
}




/*LocalDateTime date;
public LocalDateTime getDate() {
	return date;
}
public void setDate(LocalDateTime date) {
	this.date = date;
}*/
}
