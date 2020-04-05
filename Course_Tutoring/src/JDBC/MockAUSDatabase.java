package JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MockAUSDatabase {
	DBConnection dbCon;
	ResultSet rs;
	
	public MockAUSDatabase() {
		
		dbCon = new DBConnection();
		
	}
	
	public ResultSet retreiveAUSStudent(String studentID) {
		String student = "SELECT * FROM MOCK_AUS_STUDENT WHERE MSTUDENT_ID = "+studentID;
			try {
				rs = dbCon.executeStatement(student);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return rs;
	}
	public boolean searchStudentByID(String studentID) throws SQLException{
		
		boolean exist = retreiveAUSStudent(studentID).next();
		return exist;
		
	}
}
