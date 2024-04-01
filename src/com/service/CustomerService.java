package com.service;

import java.sql.SQLException;
import java.util.*;

import com.model.Customer;
import com.dao.CustomerDAoImpl;
import com.dao.CustomerDao;
import com.exception.DatabasrConnectionException;
import com.exception.InsufficientFundException;
import com.exception.InvalidAccountException;
import com.model.Account;
public class CustomerService {
    CustomerDao cd=new CustomerDAoImpl();
    
    
    public List<Account> fetchAllAccount() throws DatabasrConnectionException, SQLException 
	{
		List<Account> list = cd.fetchAllAccount();
		return list;
	}
    
    
    public Account getAccountBalance(List<Account> l,int id) throws InvalidAccountException 
    {
    	for (Account a : l)
    	{
			if (a.getId() == id)
				return a;
		}
		 throw new InvalidAccountException("Invalid id");
    }
    
    public Account getAccountDetails(List<Account> l,int id)
    {
    	for(Account a : l)
    	{
    		if(a.getId()==id)
    		{
    			return a;
    		}
    	}
		return null;
    	
    }
    
    public void deposite(Account a,int id,String field,double amount) throws InvalidAccountException, DatabasrConnectionException, SQLException
    {
    	String fieldd=field.toLowerCase().replace(" ","_");
		if(fieldd.equals("id"))
			throw new InvalidAccountException("Sorry!! Customer Id could not be updated :<");
		else
			cd.updateCustomer(id,fieldd,a.getBalance()+amount);
    }
    


	public void withdraw(Account a, int id, String field, double amount) throws DatabasrConnectionException, SQLException, InvalidAccountException, InsufficientFundException {
		String fieldd=field.toLowerCase().replace(" ","_" );
		if(fieldd.equals("id"))
		{
			throw new InvalidAccountException("Sorry!! Customer Id could not be updated :<");
		}
		else 
		{
			if(a.getBalance()<=amount)
			{
				throw new InsufficientFundException("sorry !! check ur balance");
			}
			else
			{
			cd.updateCustomer(id, fieldd, a.getBalance()-amount);
			}
			
		}
		
	}

	public List<Customer> fetchAllCustomer() throws DatabasrConnectionException,SQLException{
		 List<Customer> list=cd.fetchAllCustomer();
		return list;
	}

	
	public Customer getCustomerDetails(List<Customer> cl, int customer_id) {
         for(Customer c:cl)
         {
        	 if(c.getId()== customer_id)
        	 {
        		 return c;
        	 }
         }
		return null;
	}


	


    

}
