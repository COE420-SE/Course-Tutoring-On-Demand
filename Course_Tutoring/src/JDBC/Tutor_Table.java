package JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Tutor_Table {
	DBConnection dbCon;
	ResultSet rs;
	
	public Tutor_Table() {
		
		dbCon = new DBConnection();	
	}
	
	//insert
   public boolean insertTutor(String tutor_id, String academic_standing) {
		
			String sqlString = "insert into tutor values("+tutor_id+", '"+academic_standing+"')";
			try {
				
				int result = dbCon.executePrepared(sqlString);
		
				if(result<=0) {return false;}
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return true;	
	}
   
	//delete
   public boolean deleteTutor(String tutor_id) {
		
		String sqlString = "DELETE FROM tutor WHERE tutor_id = "+tutor_id;
		try {
			
			int result = dbCon.executePrepared(sqlString);
	
			if(result<=0) {return false;}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	return true;	
}
   //retreieve details from tutor table 
   public ResultSet retreiveTutorTable(String tutor_id) {
		// TODO Auto-generated method stub
		String sqlString = "select * from tutor where tutor_id = "+tutor_id;
		
		try {
			rs = dbCon.executeStatement(sqlString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
   

}
