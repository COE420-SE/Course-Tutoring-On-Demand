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
	
		String facultyString = "SELECT * FROM FACULTY WHERE FACULTY_EMAIL = "+email+" AND FACULTY_PASSWORD = "+password;
	   
			rs = dbCon.executeStatement(facultyString);
			if(rs.isBeforeFirst()) {
				return true;
				}
				else return false;
	}
	
	
	
	//getFacultyDetails
	//return result set
	public ResultSet getAdminDetails(String faculty_email) {
		String facultyString = "SELECT * FROM FACULTY WHERE FACULTY_EMAIL = "+faculty_email;
		
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
	
	
	public boolean insertFaculty(String faculty) {
		
		
		
	}


}
