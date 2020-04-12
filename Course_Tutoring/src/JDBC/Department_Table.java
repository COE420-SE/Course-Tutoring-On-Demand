package JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Department_Table {
	
	DBConnection dbCon;
	ResultSet rs;
	
	public Department_Table() {
		// TODO Auto-generated constructor stub
		
		dbCon = new DBConnection();
	}
	
	
	public ResultSet retreiveAUSDepartments() {
		String sqlString = "SELECT * FROM DEPARTMENT";
		
		try {
			rs = dbCon.executeStatement(sqlString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;		
	}

}
