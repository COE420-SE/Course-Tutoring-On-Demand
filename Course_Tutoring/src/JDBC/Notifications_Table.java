package JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Notifications_Table {
	
	DBConnection dbCon;
	ResultSet rs;
	
	public Notifications_Table() {
		// TODO Auto-generated constructor stub
		dbCon = new DBConnection();
	}
	
	public boolean insertNotification(String sender, String message, String receiver) {
		
		try {
			
			String sqlString = "INSERT INTO NOTIFICATION VALUES( "+sender+
					", "+receiver+
					", "+message+" )";
			int result = dbCon.executePrepared(sqlString);
			
			if(result>0) {return true;}

		} catch (SQLException e) {
			System.out.print(e.getMessage());
			return false;
		}
		return false;
		
	}
	
	public ResultSet getNotificationsFor(String userID) {
		String sqlString = "SELECT MESSAGE FROM NOTIFICATION WHERE RECEIVER_ID = "+ userID;
		try {
			rs = dbCon.executeStatement(sqlString);
			if(!rs.isBeforeFirst()) {return rs;}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return rs;
	}

}