package com.opms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	private static final DbConnection DB_CONN=new DbConnection();
	private static final String URL="jdbc:mysql://localhost:3306/student";
	private static final String USER_NAME="root";
	private static final String PASSWORD="udaib";
	private static Connection connect;
	private DbConnection(){}
	private Connection getConnection(){
		
		try {
			if(connect!=null){
				return connect;
			}
			else{
				connect=DriverManager.getConnection(URL,USER_NAME,PASSWORD);
			}
			return connect;
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return connect;
	}
	
	public static Connection getNewInstance(){
		//here they return connect object if not null return first one else create new object
		return DB_CONN.getConnection();
	}

}
