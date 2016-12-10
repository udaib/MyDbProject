package com.opms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class DataFromDb {
	private Connection conn;
	private PreparedStatement prst;
	private ResultSet rst;
	private static final String GET_DATA="select * from developer";
	private static final String VALIDATE_USER= "Select * from user where UserName = ?, Password = ?";

	public List<Student> getAllStudent() {
		List<Student> students = new ArrayList<>();
		try {
			conn = DbConnection.getNewInstance();
			prst = conn.prepareStatement(GET_DATA);
			rst = prst.executeQuery();
			while (rst.next()) {
				Student student = new Student();
				student.setId(rst.getInt(1));
				student.setName(rst.getString(2));
				student.setAddress(rst.getString(3));
				student.setPhone(rst.getString(4));
				students.add(student);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {

			try {
				if (conn != null) {
					conn.close();
				}
				if (prst != null) {
					prst.close();
				}
				if (rst != null) {
					rst.close();
				}

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return students;

	}
	
	
	public boolean validateUser(String userName,String password){
		
		try {
			conn=DbConnection.getNewInstance();
			prst=conn.prepareStatement(VALIDATE_USER);
			prst.setString(1, userName);
			prst.setString(2, password);
			rst=prst.executeQuery();
			if(rst.next()){
				return true;
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		finally{
			
				try {
					if(conn!=null){
					conn.close();
					}
					if(prst!=null){
						prst.close();
					}
					if(rst!=null){
						rst.close();
					}
					
				}catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		
		return false;
		
	}
}
