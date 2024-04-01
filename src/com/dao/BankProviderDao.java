package com.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.exception.DatabasrConnectionException;
import com.model.Account;

public interface BankProviderDao {

	void createAccount(String firstName, String lastName, LocalDate dob, String account_type, double amount) throws SQLException,DatabasrConnectionException;
	
}
