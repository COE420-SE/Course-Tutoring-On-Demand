package JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Student_Table {
	DBConnection dbCon;
	ResultSet rs;
	
	public Student_Table() {
		
		dbCon = new DBConnection();	
	}
	
	//get student details from database
	//return result set 
	public ResultSet getStudentDetails(String stud_email) {
		String student_email = "SELECT * FROM STUDENT WHERE STUDENT_EMAIL = '"+ stud_email+"'";

		try {
			rs = dbCon.executeStatement(student_email);
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	//check if student exists in the course tutpring databse
	//returns tru if exists false otherwise
	public boolean StudentExists(ResultSet student_details) throws SQLException {
		
		if(student_details.isBeforeFirst()) {
			System.out.print("student exists in the course tutoring database");
			return true;
		}
		else {
			System.out.println("Student doesnt exist");
			return false;}
		}
		
	//checks if the student email and password match for login purposes
	//return the student_ID if exists null otherwise
	public String checkStudentDetails(String email, String password) throws SQLException {
		
		String student_password = "SELECT * FROM STUDENT WHERE STUDENT_EMAIL = '" + email+"' AND STUDENT_PASSWORD = '"+ password+"'";
		rs = dbCon.executeStatement(student_password);
		if(rs.isBeforeFirst()) {
			System.out.println("Student "+email+": details match" );
			return rs.getString("STUDENT_ID");}
		else return null;
	}
	
	//check if the student is also a tutor
	//return strue of it is false otherwise
	public boolean isStudentTutor(String studentID) throws SQLException {
		
		String sqlString = "SELECT * FROM TUTOR WHERE TUTOR_ID = "+ studentID;
		rs = dbCon.executeStatement(sqlString);
		if(rs.isBeforeFirst()) {
			System.out.println("Student "+studentID+": is also a tutor");
			return true;}
		else {return false;}
		
	}
	
	//insert new student in the STUDENT table
	//return true if insertion is succesfull false otherwise
	public boolean insertStudent(ResultSet old, String password) {
		
	try {
		
		old.next();
		String STUDENT_ID = old.getString("MSTUDENT_ID");
		String STUDENT_NAME = old.getString("MSTUDENT_NAME");
		String STUDENT_EMAIL = old.getString("MSTUDENT_EMAIL");
		String STUDENT_MAJOR = old.getString("MSTUDENT_MAJOR");
		String Apply_Tutor = "0";
		String STUDENT_PASSWORD = password;
		
		System.out.println("Student "+STUDENT_ID+": being inserted" );
		
		String sqlString = "INSERT INTO STUDENT VALUES( "+STUDENT_ID+
				", '"+STUDENT_NAME+
				"', '"+STUDENT_EMAIL+
				"', '"+STUDENT_MAJOR+
				"', '"+Apply_Tutor+
				"', '"+STUDENT_PASSWORD+"')";
		int result = dbCon.executePrepared(sqlString);
		
		if(result>0) {return true;}

	} catch (SQLException e) {
		System.out.print(e.getMessage());
		System.out.print("error at inserting");
		return false;
	}
	return false;		
	}
}

