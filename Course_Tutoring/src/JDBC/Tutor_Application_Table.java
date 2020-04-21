package JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Tutor_Application_Table {
	DBConnection dbCon;
	ResultSet rs;
	
	public Tutor_Application_Table() {
		
		dbCon = new DBConnection();	
	}
	
	//insert
   public boolean insertTutorApplication(String student_id, String academic_standing, String status_of_application) {
		
			String sqlString = "insert into tutor_applications values("+student_id+", '"+academic_standing+"', '"+status_of_application+"')";
			try {
				
				int result = dbCon.executePrepared(sqlString);
		
				if(result>0) {return true;}
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return false;	
	}
   
	//delete application
   public boolean deleteTutorApplication(String tutor_id) {
		
		String sqlString = "DELETE FROM tutor_applications WHERE ta_student_id = "+tutor_id;
		try {
			
			int result = dbCon.executePrepared(sqlString);
	
			if(result>0) {return true;}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	return false;	
}
   //retreieve details from tutor table 
   public ResultSet retreiveTutorApplicationTable(String tutor_id) {
		// TODO Auto-generated method stub
		String sqlString = "select * from tutor where ta_student_id = "+tutor_id;
		
		try {
			rs = dbCon.executeStatement(sqlString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	//update status of application
   public boolean updateTutorApplicationStatus(String student_id, String status) {
		
		String sqlString = "UPDATE tutor_applications SET status = '"+status+"' where ta_student_id = "+student_id;
		try {
			
			int result = dbCon.executePrepared(sqlString);
	
			if(result>0) {return true;}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	return false;
}
}
