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
	
	public boolean insertNewSession(Session_Detail newSession){return true;}
	
	public ResultSet retreievAllSessions(boolean upcomming) {
		int status;
		if(upcomming) {
			status = 0; //upcomming
		}
		else status = 1; //completed
		String sqlString = "Select ses.session_id, stud.student_name, ses.s_course_id, ses.s_classroom_id, ses.date_of_session, ses.start_time, ses.end_time, ses.max_capacity " + 
				"From sessions ses " + 
				"INNER JOIN student stud ON ses.S_TUTOR_ID = stud.STUDENT_ID WHERE ses.status = 0";
		
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
	
	
	
}
