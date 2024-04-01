package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.exception.DatabasrConnectionException;
import com.model.Account;
import com.util.DBUtil;

public class BankProviderDaoImpl implements BankProviderDao {
    public static int cid=19;

	@Override
	public void createAccount(String firstName, String lastName, LocalDate dob, String account_type, double amount)
			throws SQLException, DatabasrConnectionException {
		      Connection conn = DBUtil.getDbConn();
		      String sql = "insert into customer(first_name,last_name,dob) values(?,?,?)";

		        
				PreparedStatement pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, firstName);
				pstmt.setString(2, lastName);
				 
				 
				pstmt.setDate(3, Date.valueOf(dob));
				pstmt.executeUpdate();
				
				String sql1="insert into account(account_type,balance,customer_id) values(?,?,?)";
				
				PreparedStatement pstmt1 = conn.prepareStatement(sql1);

				pstmt1.setString(1, account_type);
				pstmt1.setDouble(2, amount);
				pstmt1.setInt(3, cid);
				cid++;

				pstmt.executeUpdate();
				  DBUtil.DBClose();
		
	}
	

	
	

}
