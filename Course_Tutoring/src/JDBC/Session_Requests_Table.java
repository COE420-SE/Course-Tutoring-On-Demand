package JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ApplicationModel.Session_Requests;

public class Session_Requests_Table {
	DBConnection dbCon;
	ResultSet rs;
	
	public Session_Requests_Table() {
		// TODO Auto-generated constructor stub
		dbCon = new DBConnection();
	}
	
	//insert session request
		public boolean insertSessionRequests(Session_Requests request) {
			
		String sqlString = "INSERT INTO session_requests VALUES("+request.getSTUDENT_ID()+","
				+ " '"+request.getCOURSE_ID()+"',"
				+ " '"+request.getDATE()+"', "
				+ " '"+request.getTYPE()+"', "
				+ " '"+request.getCOMMENT()+"')";

				try {
					
					int result = dbCon.executePrepared(sqlString);
			
					if(result>0) {return true;}
			
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			return true;	
		}
		
		//retreive session request by tutor
		public ResultSet retreiveSessionRequestsforTutor(String tutor_id) {
			String sQLstString = "select * from session_requests "
					+ "where sr_course_id in (select tc_course_id "
					           + "from tutor_courses "
					            + "where tutor_courses.tc_tutor_id = "+tutor_id;
				try {
					rs = dbCon.executeStatement(sQLstString);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
			return rs;
		}
		
		//delete session requests past their date
		public boolean deleteSessionRequests() {

				String sqlString = "DELETE FROM session_requests WHERE  request_date <sysdate";

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
