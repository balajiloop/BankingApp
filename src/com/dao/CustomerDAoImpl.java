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
import com.exception.InvalidAccountException;
import com.model.Account;
import com.model.Customer;
import com.util.DBUtil;



public class CustomerDAoImpl implements CustomerDao{



	@Override
	
	public List<Account> fetchAllAccount() throws SQLException, DatabasrConnectionException {
		List<Account> list=new ArrayList<>();
		Connection conn=DBUtil.getDbConn();
		
		String sql="select * from account";
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		
		ResultSet rst=pstmt.executeQuery();
		
		while(rst.next())
		{
			int id=rst.getInt("id");
			String account_type=rst.getString("account_type");
			double accountBalance=rst.getDouble("balance");
			int customerId=rst.getInt("customer_id");
			
			Account a=new Account(id,account_type,accountBalance,customerId);
			list.add(a);
		}
		
		DBUtil.DBClose();
		
		return list;
	}
	
	
	
	

	@Override
	public void updateCustomer(int id, String fieldd, double amount) throws InvalidAccountException, DatabasrConnectionException, SQLException {
		Connection conn=DBUtil.getDbConn();
		
		String sql = "update account set "+fieldd+"=? where id=?";
		
         PreparedStatement pstmt = conn.prepareStatement(sql);
		
		if(fieldd.equals("balance"))
			pstmt.setDouble(1,amount);
	
		
		pstmt.setInt(2, id);


		pstmt.executeUpdate();

		DBUtil.DBClose();
		
	}
	
	public List<Customer> fetchAllCustomer() throws SQLException, DatabasrConnectionException {
		List<Customer> list=new ArrayList<>();
		Connection conn=DBUtil.getDbConn();
		
		String sql="select * from customer";
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		
		ResultSet rst=pstmt.executeQuery();
		
		while(rst.next())
		{
			int id=rst.getInt("id");
			String first_name=rst.getString("first_name");
			String last_name=rst.getString("last_name");
			LocalDate dob = rst.getDate("dob").toLocalDate();
			
			Customer c=new Customer(id,first_name,last_name,dob);
			list.add(c);
		}
		
		DBUtil.DBClose();
		
		return list;
	}

}
