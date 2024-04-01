package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.model.Account;
import com.model.Customer;
import com.service.CustomerService;
import com.exception.*;
import com.test.CustomerServiceTest;
public class CustomerController {
	public static void main(String [] args) 
	{
		Scanner sc=new Scanner(System.in);
		CustomerService cs=new CustomerService();
		CustomerServiceTest ct=new CustomerServiceTest();
		BankingApp  bapp=new BankingApp();
		
		while(true)
		{
			System.out.println("***** customer *****");
			System.out.println("1.Get account balance");
			System.out.println("2.Deposite");
			System.out.println("3.Withdraw");
			System.out.println("4.Transfer");
			System.out.println("5.Get account details");
			System.out.println("Press 0 to navigate back to home page");
			int input =sc.nextInt();
			if(input==0)
			{
				BankingApp.main(args);
				break;
			}
			switch(input)
			{
			case 1:
				try
				{
				List<Account> l=cs.fetchAllAccount();
			
				System.out.println("Enter account id");
				int id=sc.nextInt();
				Account a = cs.getAccountBalance(l,id);
				System.out.println(String.format("%-15s%-15s%-15s%-15s", "id",
						"account_type", "balance", "customer_id"));
				System.out.println(String.format("%-15d%-15s%-15f%-15d", a.getId(),
						a.getAccount_type(), a.getBalance(),a.getCustomer_id()));
				}
				catch(DatabasrConnectionException |SQLException e)
				{
					System.out.println(e.getMessage());
					break;
				} catch (InvalidAccountException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 5:
				try
				{
					List<Account> l=cs.fetchAllAccount();
					List<Customer> cl=cs.fetchAllCustomer();
					System.out.println("Enter account id");
					int id=sc.nextInt();
					Account a=cs.getAccountDetails(l,id);
					Customer c =cs.getCustomerDetails(cl,a.getCustomer_id());
					System.out.println(String.format("%-15s%-15s%-15s%-15s%-15s%-15s", "id","first_name","Last_name",
							"account_type", "balance", "customer_id"));
					System.out.println(String.format("%-15d%-15s%-15s%-15s%-15f%-15d", a.getId(),c.getFirst_name(),c.getLast_name(),
							a.getAccount_type(), a.getBalance(),a.getCustomer_id()));
					
				}
				catch(DatabasrConnectionException |SQLException e)
				{
					System.out.println(e.getMessage());
					break;
				}
				break;
				
				
			case 2:
				try {
					List<Account>list = cs.fetchAllAccount();
					System.out.println("Enter account Id of the depositing account:");
					int id = sc.nextInt();
					System.out.println();
					Account c = cs.getAccountDetails(list, id);
					System.out.println(String.format("%-15s%-15s%-15s%-15s", "Id",
							"account_type","balance","customer_id"));
					System.out.println(String.format("%-15d%-15s%-15f%-15d", c.getId(),
							c.getAccount_type(), c.getBalance(), c.getCustomer_id()));				
					String field="balance";
					System.out.println("Enter the amount to be deposited:");
					double amount=sc.nextDouble();
					cs.deposite(c,id,field,amount);
					System.out.println("amount deposited Successfully");
				} catch ( SQLException|DatabasrConnectionException | InvalidAccountException e) {
					System.out.println(e.getMessage());
					break;
				}
				break;
				
			case 3:
				try
				{
					List<Account> l1=cs.fetchAllAccount();
					System.out.println("Enter account id for withdrawal ");
					int id=sc.nextInt();
					Account c=cs.getAccountDetails(l1, id);
					System.out.println(String.format("%-15s%-15s%-15s%-15s", "Id",
							"account_type","balance","customer_id"));
					System.out.println(String.format("%-15d%-15s%-15f%-15d", c.getId(),
							c.getAccount_type(), c.getBalance(), c.getCustomer_id()));
					String field="balance";
					System.out.println("Enter the amount to be withdraw");
					double amount=sc.nextDouble();
					cs.withdraw(c,id,field,amount);
					System.out.println("amount withdraw is successful");
					
				}
				catch(SQLException|DatabasrConnectionException | InvalidAccountException | InsufficientFundException e)
				{
					System.out.println(e.getMessage());
					break;
				}
				break;
				
			case 4:
				try
				{
					List<Account> l1=cs.fetchAllAccount();
					System.out.println("Enter sender account address");
					int sid=sc.nextInt();
					System.out.println("Enter reciver account address");
					int rid=sc.nextInt();
					
					Account a1=cs.getAccountDetails(l1, sid);
					Account a2=cs.getAccountDetails(l1, rid);
					
					System.out.println("******Sender account details******");
					System.out.println(String.format("%-15s%-15s%-15s%-15s", "Id",
							"account_type","balance","customer_id"));
					System.out.println(String.format("%-15d%-15s%-15f%-15d", a1.getId(),
							a1.getAccount_type(), a1.getBalance(), a1.getCustomer_id()));
					
					System.out.println("******Reciver account details******");
					System.out.println(String.format("%-15s%-15s%-15s%-15s", "Id",
							"account_type","balance","customer_id"));
					System.out.println(String.format("%-15d%-15s%-15f%-15d", a2.getId(),
							a2.getAccount_type(), a2.getBalance(), a2.getCustomer_id()));
					
					String field="balance";
					System.out.println("Enter the amount to be transfered to reciver:");
					double amount=sc.nextDouble();
					cs.deposite(a2,rid,field,amount);
					cs.withdraw(a1,sid,field,amount);
					System.out.println("amount transfered Successfully");
					
				}
				catch(SQLException|DatabasrConnectionException | InvalidAccountException | InsufficientFundException e)
				{
					System.out.println(e.getMessage());
				}
				break;
			
			}
			
		}
	}

}
