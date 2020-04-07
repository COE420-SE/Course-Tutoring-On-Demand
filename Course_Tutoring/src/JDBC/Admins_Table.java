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

	}}
