package JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

import ApplicationModel.Session_Detail;

public class Session_Table {
	DBConnection dbCon;
	ResultSet rs;
	
	public Session_Table() {
		// TODO Auto-generated constructor stub
		dbCon = new DBConnection();
	}
	
	//inserting new sessions record in the database
	public boolean insertNewSession(Session_Detail newSession, String tutor_ID){
		System.out.println("in insert session");
	try {	
		String sqlString = "INSERT INTO SESSIONS VALUES((select max(SESSION_ID)+1 from SESSIONS), '"
		+tutor_ID+"', '"
		+newSession.getCourse_ID()+"', '"
		+newSession.getClassroom_ID()+"', '"
		+newSession.getDate_of_session()+"', '"
		+newSession.getStart_time()+"', '"
		+newSession.getEnd_time()+"', "
		+newSession.getMax_Seats()+", 0)";
		
		int success = dbCon.executePrepared(sqlString);
		
		if(success>0) {return true;}

	} catch (SQLException e) {
		System.out.print(e.getMessage());
		return false;
	}
	return false;
	}
	
	public ResultSet retreievAllSessions(boolean upcomming) {
		int status;
		if(upcomming) {
			status = 0; //upcomming
		}
		else status = 1; //completed
		String sqlString = "Select ses.session_id, stud.student_name, ses.s_course_id, ses.s_classroom_id, ses.date_of_session, ses.start_time, ses.end_time, ses.max_capacity " + 
				"From sessions ses " + 
				"INNER JOIN student stud ON ses.S_TUTOR_ID = stud.STUDENT_ID WHERE ses.status = "+status;
		
		try {
			rs = dbCon.executeStatement(sqlString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet retreievSessionsByTutor(String tutor_id, boolean upcomming) {
		int status;
		if(upcomming) {
			status = 0; //upcomming
		}
		else status = 1; //completed
		String sqlString = "Select ses.session_id, stud.student_name, ses.s_course_id, ses.s_classroom_id, ses.date_of_session, ses.start_time, ses.end_time, ses.max_capacity " + 
				"From sessions ses " + 
				"INNER JOIN student stud ON ses.S_TUTOR_ID = stud.STUDENT_ID " + 
				"WHERE stud.student_id = "+tutor_id+" AND ses.status = "+status;
		try {
			rs = dbCon.executeStatement(sqlString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
			return null;
		}
		return rs;
	}
	
	public ResultSet retreievSessionsOfStudent(String student_id, boolean upcomming) {
		int status;
		if(upcomming) {
			status = 0; //upcomming
		}
		else status = 1; //completed
		String sqString = "Select ses.session_id, stud.student_name, ses.s_course_id, ses.s_classroom_id, ses.date_of_session, ses.start_time, ses.end_time, ses.max_capacity " + 
				"From sessions ses " + 
				"INNER JOIN student stud ON ses.S_TUTOR_ID = stud.STUDENT_ID " + 
				"WHERE ses.status = "+status+" AND ses.session_id in (SELECT t.ss_session_id from STUDENT_SESSION t WHERE t.ss_student_id = " +student_id+")";
		try {
			rs = dbCon.executeStatement(sqString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
			return null;
		}
		return rs;
	}
	
	public ResultSet retreievSessionsByCourse(String course_id, boolean upcomming) {
		int status;
		if(upcomming) {
			status = 0; //upcomming
		}
		else status = 1; //completed
		String sqlString = "Select ses.session_id, stud.student_name, ses.s_course_id, ses.s_classroom_id, ses.date_of_session, ses.start_time, ses.end_time, ses.max_capacity\r\n" + 
				"From sessions ses\r\n" + 
				"INNER JOIN student stud ON ses.S_TUTOR_ID = stud.STUDENT_ID\r\n" + 
				"WHERE ses.s_course_id = '"+course_id+"'";
		try {
			rs = dbCon.executeStatement(sqlString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		}	
		return rs;
	}
	
	public ResultSet retreievSessionsByDept(String dept_id, boolean upcomming) {
		int status;
		if(upcomming) {
			status = 0; //upcomming
		}
		else status = 1; //completed
		String sqlString = "Select ses.session_id, stud.student_name, ses.s_course_id, ses.s_classroom_id, ses.date_of_session, ses.start_time, ses.end_time, ses.max_capacity " + 
				"From sessions ses " + 
				"INNER JOIN student stud ON ses.S_TUTOR_ID = stud.STUDENT_ID " + 
				"WHERE ses.s_course_id in (select c.course_id " + 
				"FROM courses " + 
				"INNER JOIN department d on c.c_department_id = d.department_id " + 
				"WHERE d.department_id = '"+dept_id+"')";
		try {
			rs = dbCon.executeStatement(sqlString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return rs;
	}
	
	//updateSessionStatus by system date
	public void updateSessionStatus() {
		
		String sqlString = "UPDATE sessions SET status = 1 where date_of_session<=sysdate";
		try {
			
			int result = dbCon.executePrepared(sqlString);
	
			if(result>0) {System.out.println("updation is successfull");}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		System.out.println("updation of session staus is not successfull");
		   
	}

	
	
	
//retreive session_id, max_capacity and count for unbookale sessions	
	public ResultSet retreieveBookableSessionOfStudent(String student_id) {
		
		String sqString = "select  max_capacity, session_id, count(ss_student_id) as NO_OF_STUDENTS " + 
				"from sessions " + 
				"left join student_session on student_session.ss_session_id = sessions.session_id " + 
				"where status = 0 AND session_id not in (SELECT t.ss_session_id from STUDENT_SESSION t WHERE t.ss_student_id = "+student_id+") AND s_tutor_id != " +student_id+ 
				" group by session_id, max_capacity";
		try {
			rs = dbCon.executeStatement(sqString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
			return null;
		}
		return rs;
	}
	
	public ResultSet retreiveSessionBySessionID(String session_id) {
		
		String sqlString = "Select ses.session_id, stud.student_name, ses.s_course_id, ses.s_classroom_id, ses.date_of_session, ses.start_time, ses.end_time, ses.max_capacity " + 
				"From sessions ses " + 
				"INNER JOIN student stud ON ses.S_TUTOR_ID = stud.STUDENT_ID WHERE ses.session_id = "+session_id;
		
		try {
			rs = dbCon.executeStatement(sqlString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	//delete session
	   public boolean deleteSession(String session_id) {
			
			String sqlString = "DELETE FROM sessions WHERE session_id = "+session_id;
			try {
				
				int result = dbCon.executePrepared(sqlString);
		
				if(result>0) {return true;}
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return false;	
	}
	   
	 public ResultSet retreiveTutorDetailsOfSession(String sessionID){
		   
		 String sqlString = "select * from student right join sessions on sessions.s_tutor_id = student.student_id where sessions.session_id = "+sessionID;
			
			try {
				rs = dbCon.executeStatement(sqlString);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return rs;
	   }
	
	
}
