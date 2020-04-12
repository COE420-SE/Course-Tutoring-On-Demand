package JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MockAUSDatabase {
	DBConnection dbCon;
	ResultSet rs;
	
	public MockAUSDatabase() {
		
		dbCon = new DBConnection();
		
	}
	
	//get record details of student
	//return result set
	public ResultSet retreiveAUSStudent(String student_email) {
		String studentSQL = "SELECT * FROM MOCK_AUS_STUDENT WHERE MSTUDENT_ID = '"+student_email+"'";
			try {
				rs = dbCon.executeStatement(studentSQL);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.print("error retreiving AUS student");
				e.printStackTrace();
				return null;
			}
		return rs;
	}
}
