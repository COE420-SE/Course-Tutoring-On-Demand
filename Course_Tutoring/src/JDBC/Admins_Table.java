package JDBC;

import java.sql.ResultSet;

import java.sql.SQLException;


import ApplicationModel.Department_Admin;

public class Admins_Table {
	DBConnection dbCon;
	ResultSet rs;
	
	public Admins_Table() {
		
		dbCon = new DBConnection();
	}
	
	public String checkAdminDetails(String email, String password) throws SQLException {
	
		String adminString = "SELECT * FROM ADMINS WHERE ADMIN_EMAIL = '"+email+"' AND ADMIN_PASSWORD = '"+password+"'";
	   
			rs = dbCon.executeStatement(adminString);
			if(rs.isBeforeFirst()) {
				rs.next();
				String t = rs.getString("ADMIN_TYPE");
				System.out.println(t);
				return t;
			}
				return null;
	}
	
	public ResultSet getAdminDetails(String admmin_email) {
		String adminString = "SELECT * FROM ADMINS WHERE ADMIN_EMAIL = '"+admmin_email+"'";
		
		try {
			rs = dbCon.executeStatement(adminString);
			if(rs.isBeforeFirst()) 
				return rs;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	public boolean insertDeptAdmin(String d_Name, String d_Email, String d_password, String d_departmentID) {

		String sqlString = "INSERT INTO admins VALUES((select max(ADMIN_ID)+1 from ADMINS) , '"
		+d_Name+"', '"
		+d_Email+"', '"
		+d_password+"', 'D', '"
		+d_departmentID+"')";
		
		int success;
		try {
			success = dbCon.executePrepared(sqlString);
			if (success>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}
	

}