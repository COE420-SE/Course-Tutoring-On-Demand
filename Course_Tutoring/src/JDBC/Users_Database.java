package JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Users_Database {
	DBConnection dbCon;
	ResultSet rs;
	Student_Table student;
	Admins_Table admin;
	Faculty_Table faculty;
	
	public Users_Database() {
		// TODO Auto-generated constructor stub
		dbCon = new DBConnection();
	}
	
	
	public String checkCredentials(String email, String password) throws SQLException {
		
		String stud_id = student.checkStudentDetails(email, password);
		// check if user is a student or a tutor;
		if(stud_id!= null) {
			
			if (student.isStudentTutor(stud_id)) {
				return "tutor";
			}
			else return "student";
		}
		
		String admin_type = admin.checkAdmin(email, password);
		if (admin_type!= null) {
			//return system or department
			return admin_type;
		}
		
		if(faculty.checkFaculty(email, password))
		{	return "faculty";}
		
		else return null;
		}

	
		public boolean deleteUser(String email) {
			
			return true;
		}
}