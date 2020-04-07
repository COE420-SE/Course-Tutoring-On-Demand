package JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Student_Table {
	DBConnection dbCon;
	ResultSet rs;
	
	public Student_Table() {
		
		dbCon = new DBConnection();
		
	}
	
	public boolean StudentExists(String email) throws SQLException {
		
		String student_email = "SELECT * FROM STUDENT WHERE STUDENT_EMAIL = "+ email;
		rs = dbCon.executeStatement(student_email);
		if(rs.isBeforeFirst()) {return true;}
		else {return false;}
	}
	
	public String checkStudent(String email, String password) throws SQLException {
		
		String student_password = "SELECT * FROM STUDENT WHERE STUDENT_EMAIL = " + email+" AND STUDENT_PASSWORD = "+ password;
		rs = dbCon.executeStatement(student_password);
		if(rs.isBeforeFirst()) {return rs.getString("STUDENT_ID");}
		else return null;
	}
	
	public boolean isStudentTutor(String studentID) throws SQLException {
		
		String sqlString = "SELECT * FROM TUTOR WHERE TUTOR_ID = "+ studentID;
		rs = dbCon.executeStatement(sqlString);
		if(rs.isBeforeFirst()) {return true;}
		else {return false;}
		
	}
	
	public boolean insertStudent(ResultSet old, String password) {
		
	try {
		String STUDENT_ID = rs.getString(1);
		String STUDENT_NAME = rs.getString(2);
		String STUDENT_EMAIL = rs.getString(3);
		String STUDENT_MAJOR = rs.getString(4);
		String Apply_Tutor = "0";
		String STUDENT_PASSWORD = rs.getString(6);
		
		String sqlString = "INSERT INTO STUDENT VALUES( "+STUDENT_ID+
				", "+STUDENT_NAME+
				", "+STUDENT_EMAIL+
				", "+STUDENT_MAJOR+
				", "+Apply_Tutor+
				", "+STUDENT_PASSWORD+" )";
		int result = dbCon.executePrepared(sqlString);
		
		if(result>0) {return true;}

	} catch (SQLException e) {
		System.out.print(e.getMessage());
	}
	return false;
		
		
	}
}

