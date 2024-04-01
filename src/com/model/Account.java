package com.model;

import java.util.Objects;

public class Account {
	private int id;
	private String account_type;
	private double balance;
	private int customer_id;
	public Account(int id, String account_type, double balance, int customer_id) {
		super();
		this.id = id;
		this.account_type = account_type;
		this.balance = balance;
		this.customer_id = customer_id;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", account_type=" + account_type + ", balance=" + balance + ", customer_id="
				+ customer_id + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(account_type, balance, customer_id, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(account_type, other.account_type)
				&& Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance)
				&& customer_id == other.customer_id && id == other.id;
	}
	
	
	

}
