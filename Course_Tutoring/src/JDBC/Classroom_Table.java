package JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Classroom_Table {
	DBConnection dbCon;
	ResultSet rs;
	
	public Classroom_Table() {
		// TODO Auto-generated constructor stub
		
		dbCon = new DBConnection();
	}
	
	public ResultSet retreiveAUSClassrooms() {
		String sqlString = "SELECT * FROM CLASSROOM";
		
		try {
			rs = dbCon.executeStatement(sqlString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;		
	}
	
}
