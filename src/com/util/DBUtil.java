package com.util;


import java.sql.DriverManager;
import java.sql.SQLException;

import com.exception.DatabasrConnectionException;


import java.sql.Connection;

public class DBUtil {
	private static Connection conn;
	
	public static Connection getDbConn() throws DatabasrConnectionException
	{
		String usernameDb="root";
		String passwordDb="";
		String urlDb="jdbc:mysql://localhost:3306/bank_hex_feb_24";
		String driverName="com.mysql.jdbc.Driver";
		
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			throw new DatabasrConnectionException("Unable to load the Database Driver :(");
		}
		
		try {
			conn=DriverManager.getConnection(urlDb,usernameDb,passwordDb);
		} catch (SQLException e) {
			throw new DatabasrConnectionException("Unable to establish a connection to the database :(");
		}
		
		return conn;
	}
	
	public static void  DBClose()
	{
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
