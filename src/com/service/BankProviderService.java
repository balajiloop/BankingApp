package com.service;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.dao.*;
import com.exception.DatabasrConnectionException;
import com.model.Account;
import com.service.*;
public class BankProviderService {
	BankProviderDao bpd=new BankProviderDaoImpl();
	CustomerService cs=new CustomerService();

	public void createAccount(String firstName, String lastName, LocalDate dob, String account_type, double amount) throws SQLException, DatabasrConnectionException {
		
		bpd.createAccount(firstName, lastName, dob, account_type, amount);
	}

	public double calculateInterest(double balance) {
		double Interest = balance * 0.045 * 1;
		return Interest;
	}

	

}
