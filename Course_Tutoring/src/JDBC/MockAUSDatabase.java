package JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MockAUSDatabase {
	DBConnection dbCon;
	ResultSet rs;
	
	public MockAUSDatabase() {
		
		dbCon = new DBConnection();
		
	}
	
	public ResultSet retreiveAUSStudent(String student_email) {
		String student = "SELECT * FROM MOCK_AUS_STUDENT WHERE MSTUDENT_ID = "+student_email;
			try {
				rs = dbCon.executeStatement(student);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return rs;
	}
	public boolean searchStudentByID(String studentID) throws SQLException{
		
		return  retreiveAUSStudent(studentID).next();
		
	}
}
