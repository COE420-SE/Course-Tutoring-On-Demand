package JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Courses_Table {
	DBConnection dbCon;
	ResultSet rs;
	
	public Courses_Table() {
		// TODO Auto-generated constructor stub
		
		dbCon = new DBConnection();
	}
	
	
	public ResultSet retreiveAUSCourses() {
		String sqlString = "SELECT * FROM COURSES";
		
		try {
			rs = dbCon.executeStatement(sqlString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;		
	}

}
