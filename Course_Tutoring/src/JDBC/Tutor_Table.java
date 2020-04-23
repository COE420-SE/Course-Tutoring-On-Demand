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
   
   //retreieve tutor by department
   public ResultSet retreiveTutorsbyDept(String dept_id) {
		// TODO Auto-generated method stub
		String sqlString = "select * from student where student_major = '"+dept_id+"' "
				+ "and student_id in (select tutor_id from tutor)";
		
		try {
			rs = dbCon.executeStatement(sqlString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
   
   //retreive tutor students have done course in
   public ResultSet retreiveTutorsofStudent(String student_id) {
		// TODO Auto-generated method stub
		String sqlString = "select * from student where student_id in (  select s_tutor_id "
				+ "from sessions, student_session "
				+ "where sessions.session_id = ss_session_id and ss_student_id = "+student_id+")";
		try {
			rs = dbCon.executeStatement(sqlString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}
