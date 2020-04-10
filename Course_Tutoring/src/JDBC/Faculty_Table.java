package JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Faculty_Table {
	DBConnection dbCon;
	ResultSet rs;
	
	public Faculty_Table() {
		
		dbCon = new DBConnection();
	}
	
	public boolean checkFaculty(String email, String password) throws SQLException {
	
		String facultyString = "SELECT * FROM FACULTY WHERE FACULTY_EMAIL = "+email+" AND FACULTY_PASSWORD = "+password;
	   
			rs = dbCon.executeStatement(facultyString);
			if(rs.isBeforeFirst()) {
				return true;
				}
				else return false;

	}
	
//	public boolean insertFaculty()


}
