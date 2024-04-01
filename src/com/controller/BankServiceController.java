package com.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import com.service.*;


import com.exception.DatabasrConnectionException;
import com.model.Account;
import com.service.BankProviderService;

public class BankServiceController {
	public static void main(String [] args)
	{
		Scanner sc=new Scanner(System.in);
		BankProviderService bps=new BankProviderService();
		CustomerService cs=new CustomerService();
		BankingApp bapp=new BankingApp();
		
		while(true)
		{
			System.out.println("****Banking sevice****");
			System.out.println("1.Create account");
			System.out.println("2.List All Account");
			System.out.println("3.calculate Intrest");
			System.out.println("press 0 to navigate back to home page");
			int input=sc.nextInt();
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
					System.out.println("Enter first name:");
					String firstName = sc.next();
					System.out.println("Enter last name:");
					String lastName = sc.next();
					System.out.println("Enter date of birth (YYYY-MM-DD):");
					sc.nextLine();
					String dateInput = sc.nextLine(); 
					LocalDate dob = LocalDate.parse(dateInput);
					System.out.println("Enter account type:");
					String account_type = sc.next();
					System.out.println("Enter amount:");
					double amount = sc.nextDouble();
					bps.createAccount(firstName, lastName, dob, account_type, amount);
					System.out.println("Registration Successful!!");
					    break;
					} catch (SQLException | DatabasrConnectionException e) {
					    e.printStackTrace();
					}
				
			case 2:
				try
				{
					List<Account> l=cs.fetchAllAccount();
					ListIterator<Account> li=l.listIterator();
					while(li.hasNext())
					{
						System.out.println(li.next());
					}
				}
				catch(DatabasrConnectionException |SQLException e)
				{
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				try
				{
					List<Account> l=cs.fetchAllAccount();
					System.out.println("Enter ur account id:");
					int aid=sc.nextInt();
					Account a=cs.getAccountBalance(l, aid);
					double interest=bps.calculateInterest(a.getBalance());
					System.out.println("Intrest for the account id "+aid+" for monthly is "+interest);
					cs.deposite(a, aid, "balance", interest);
					break;
				}
				catch(Exception e)
				{
					 e.printStackTrace();
				}
				
			}
			
		}
	}

}
