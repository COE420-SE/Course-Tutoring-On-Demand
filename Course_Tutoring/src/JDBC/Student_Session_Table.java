package JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Student_Session_Table {

		DBConnection dbCon;
		ResultSet rs;
		
		public Student_Session_Table() {
			// TODO Auto-generated constructor stub
			dbCon = new DBConnection();
		}
		
	
	//insert session table
		public boolean insertStudentSession(String student_id, String session_id) {
			
			String sqlString = "insert into student_session values("+student_id+", "+session_id+")";
			try {
				
				int result = dbCon.executePrepared(sqlString);
		
				if(result>0) {return true;}
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return false;	
	}
	
	//delete session
		public boolean deleteStudentSession(String student_id, String session_id) {
			
			String sqlString = "DELETE FROM student_session WHERE ss_student_id = "+student_id+" and ss_session_id = "+session_id;
			try {
				
				int result = dbCon.executePrepared(sqlString);
		
				if(result<=0) {return false;}
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return true;	
	}
	
	
}
