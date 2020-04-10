package JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

import sun.print.PSPrinterJob.PluginPrinter;

public class Admins_Table {
	DBConnection dbCon;
	ResultSet rs;
	
	public Admins_Table() {
		
		dbCon = new DBConnection();
	}
	
	public String checkAdmin(String email, String password) throws SQLException {
	
		String adminString = "SELECT * FROM ADMINS WHERE ADMIN_EMAIL = "+email+" AND ADMIN_PASSWORD = "+password;
	   
			rs = dbCon.executeStatement(adminString);
			if(rs.isBeforeFirst()) {
				
				if(rs.getString(5) == "S") {
					return "system";
				}
				else return "department";}
			else  return null;

	}
	
	public ResultSet getAdminDetails(String admmin_email) {
		String adminString = "SELECT * FROM ADMINS WHERE ADMIN_EMAIL = "+admmin_email;
		
		try {
			rs = dbCon.executeStatement(adminString);
			if(rs.isBeforeFirst()) 
				return rs;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	public boolean insertDeptAdmin(Department_Admin newAdmin) {
		try {
			//change new_admin.get for all 
			String ADMIN_ID = rs.getString(1);
			String ADMIN_NAME = rs.getString(2);
			String ADMIN_EMAIL = rs.getString(3);
			String ADMIN_PASSWORD = rs.getString(4);
			String ADMIN_TYPE = "D";
			String A_DEPARTMENT_ID = rs.getString(6);
			
			String sqlString = "INSERT INTO STUDENT VALUES( "+ADMIN_ID+
					", "+ADMIN_NAME+
					", "+ADMIN_EMAIL+
					", "+ADMIN_PASSWORD+
					", "+ADMIN_TYPE+
					", "+A_DEPARTMENT_ID+" )";
			int result = dbCon.executePrepared(sqlString);
			
			if(result>0) {return true;}

		} catch (SQLException e) {
			System.out.print(e.getMessage());
			return false;
		}
		return false;
	}
	

}