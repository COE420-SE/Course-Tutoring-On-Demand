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
	
	//seperate the above function into 2 
	//getFacultyDetails
	
//	public boolean insertFaculty()


}
