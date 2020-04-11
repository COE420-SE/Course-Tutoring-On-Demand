package JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MockAUSDatabase {
	DBConnection dbCon;
	ResultSet rs;
	
	public MockAUSDatabase() {
		
		dbCon = new DBConnection();
		
	}
	
	public ResultSet retreiveAUSStudent(String student_id) {
		String studentSQL = "SELECT * FROM MOCK_AUS_STUDENT WHERE MSTUDENT_ID = "+student_id;
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
	
	public boolean searchStudentByID(String studentID) throws SQLException{

		ResultSet rr = retreiveAUSStudent(studentID);
		return  rr.isBeforeFirst();
	}
}
