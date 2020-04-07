package JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Users_Database {
	DBConnection dbCon;
	ResultSet rs;
	
	public Users_Database() {
		// TODO Auto-generated constructor stub
		dbCon = new DBConnection();
	}
	
	
	public String checkCredentials(String email, String password) {
		//modify to make each class have the check method
//		String student = "SELECT * FROM STUDENT WHERE STUDENT_ID = "+email+" AND STUDENT_PASSWORD = "+password;
//			rs = dbCon.executeStatement(student);
//			if(rs.isBeforeFirst()) {
//				//check if id is in tutor table if true return tutor else student
//			}
//		//check admin
//			String admin;
//			//if type is ..
//			return admin;
//
//	//return "none" or null
	}
	
}
