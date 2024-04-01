package com.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.junit.Test;
import org.junit.Assert;


import com.exception.DatabasrConnectionException;
import com.exception.InvalidAccountException;
import com.model.Account;
import com.model.Customer;
import com.service.CustomerService;





public class CustomerServiceTest {
	CustomerService cs = new CustomerService();

	/*@Test
	public void getAccountBalanceTest() {
		try {
			List<Account> list = cs.fetchAllAccount();
			
			//case1
			int id=1;
			Account a=new Account(1,"savings",1000.0,1);
			Assert.assertEquals(a, cs.getAccountBalance(list,id)); 
			
			//case2
			int id1=10;
			Account a1=new Account(10,"savings",112000,3);
			Assert.assertNotSame(a1,cs.getAccountBalance(list,id1));
			
			//case3
			int id2=11;
			Account a2=new Account( 10,"savings",112000,3);
			Assert.assertNotSame(a2,cs.getAccountBalance(list,id2));
			
		}catch (SQLException e ) {
			Assert.fail();
		}catch(DatabasrConnectionException e) {
			Assert.assertEquals("Unable to establish a connection to the database :(", e.getMessage());
		}catch(InvalidAccountException e) {
			Assert.assertEquals("Account not found :(\nRecheck the Account Id", e.getMessage());
		}
	}*/
	
	
	/*@Test
	public void depositeTest() {
		try {
			List<Account> list=cs.fetchAllAccount();
			Account a=list.get(0);
			int id=a.getId();
			double amount=a.getBalance();
			amount=amount+500.0;
			cs.deposite(a,id,"balance",500.0);
			Account updatedbalance=cs.getAccountBalance(list, id);
			Assert.assertSame(amount,updatedbalance.getBalance());
		} catch (SQLException e) {
			Assert.fail();
		} catch (DatabasrConnectionException e) {
			Assert.assertEquals("Unable to establish a connection to the database :(", e.getMessage());
		} catch (InvalidAccountException e) {
			Assert.assertEquals("Sorry!! Account Id could not be updated :<", e.getMessage());
		}
	}*/
	
	/*@Test
	public void withdrawTest() throws SQLException, DatabasrConnectionException, InvalidAccountException {
	try
	{
	    List<Account> list = cs.fetchAllAccount();
	    Account a = list.get(1);
	    int id = a.getId();
	    double newBalance = a.getBalance() - 500.00; // Calculate new balance
	    cs.withdraw(a, id, "balance", 500.00); // Withdraw using the new balance
	    Account updatedBalance = cs.getAccountBalance(list, id);
	    Assert.assertSame(newBalance, updatedBalance.getBalance(),0.001); // Assert expected balance
	}
	catch (SQLException e) {
			Assert.fail();
		} catch (DatabasrConnectionException e) {
			Assert.assertEquals("Unable to establish a connection to the database :(", e.getMessage());
		} catch (InvalidAccountException e) {
			Assert.assertEquals("Sorry!! Account Id could not be updated :<", e.getMessage());
		}
	}*/

	
	
}
