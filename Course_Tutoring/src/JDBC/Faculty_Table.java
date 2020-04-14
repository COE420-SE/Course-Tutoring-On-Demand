package JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Faculty_Table {
	DBConnection dbCon;
	ResultSet rs;
	
	public Faculty_Table() {
		
		dbCon = new DBConnection();
	}
	
	public boolean checkFacultyDetails(String email, String password) throws SQLException {
	
		String facultyString = "SELECT * FROM FACULTY_USER WHERE FACULTY_EMAIL = '"+email+"' AND FACULTY_PASSWORD = '"+password+"'";
	   
			rs = dbCon.executeStatement(facultyString);
			if(rs.isBeforeFirst()) {
				return true;
				}
				else return false;
	}
	
	
	
	//getFacultyDetails
	//return result set
	public ResultSet getFacultyDetails(String faculty_email) {
		String facultyString = "SELECT * FROM FACULTY_USER WHERE FACULTY_EMAIL = '"+faculty_email+"'";
		
		try {
			rs = dbCon.executeStatement(facultyString);
			if(rs.isBeforeFirst()) 
				return rs;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	
	//Insert faculty 
	public boolean insertFaculty(String f_Name, String f_Email, String f_password, String f_departmentID) {
		
		String sqlString = "INSERT INTO faculty_user VALUES((select max(FACULTY_ID)+1 from FACULTY_USER) , '"
		+f_Name+"', '"
		+f_Email+"', '"
		+f_password+"', '"
		+f_departmentID+"')";
		
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
