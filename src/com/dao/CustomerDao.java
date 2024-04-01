package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.exception.DatabasrConnectionException;
import com.exception.InvalidAccountException;
import com.model.Account;
import com.model.Customer;

public interface CustomerDao {
	
	public List<Account> fetchAllAccount()throws DatabasrConnectionException,SQLException;

	public void updateCustomer(int id, String fieldd, double amount)throws InvalidAccountException,DatabasrConnectionException,SQLException;

	public List<Customer> fetchAllCustomer()throws DatabasrConnectionException,SQLException;

	
	
}
