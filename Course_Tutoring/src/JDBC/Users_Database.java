package JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

import ApplicationModel.Tutor;

public class Users_Database {
	DBConnection dbCon;
	ResultSet rs;
	Student_Table student;
	Admins_Table admin;
	Faculty_Table faculty;
	Tutor_Table tutor;
	
	public Users_Database() {
		// TODO Auto-generated constructor stub
		dbCon = new DBConnection();
		student = new Student_Table();
		admin = new Admins_Table();
		faculty = new Faculty_Table();
		tutor = new Tutor_Table();
	}
	
	
	public String checkCredentials(String email, String password) throws SQLException {
		
		System.out.print("in ceck credentials");
		
		//check if user is a student 
		//function return student id if exists
		String stud_id = student.checkStudentDetails(email, password);

		if(stud_id!= null) {
			//check if student is a tutor
			if (tutor.retreiveTutorTable(stud_id).isBeforeFirst()) {
				return "tutor";
			}
			else return "student";
		}
		
		//check if user is an admin
		System.out.println("checking in dept");
		String admin_type = admin.checkAdminDetails(email, password);
		
		if (admin_type!= null) {
			//return system or department
			System.out.println(admin_type);
			if(admin_type.equals("S")) {
				return "system";
				
			}
			
			else {
				System.out.println("why ???");
				return "department";}
			}
		
		//check if user is a faculty user.
		if(faculty.checkFacultyDetails(email, password))
		{	return "faculty";}
		
		else return null;
		}
	
	public ResultSet customExecuteSQL(String sql) {
		// TODO Auto-generated method stub
		String sqlString = sql;
		
		try {
			rs = dbCon.executeStatement(sqlString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	 public boolean customPreparedSQL(String sql) {
			
			String sqlString = sql;
			try {
				
				int result = dbCon.executePrepared(sqlString);
		
				if(result>0) {return true;}
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return false;
	}

	
}