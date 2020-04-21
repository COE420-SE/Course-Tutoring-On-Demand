package JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

import ApplicationModel.Feedback;
import ApplicationModel.Session_Requests;

public class Feedback_Table {

	DBConnection dbCon;
	ResultSet rs;
	
	public Feedback_Table() {
		// TODO Auto-generated constructor stub
		dbCon = new DBConnection();
	}
	
	//insert feedback	
	public boolean insertFeedback(Feedback feedback) {
			
		String sqlString = "INSERT INTO STUDENT_FEEDBACK VALUES("+feedback.getSTUDENT_ID()+", "
		     +feedback.getTUTOR_ID()+", '"
			 +feedback.getSEND_TUTOR()+"', '"
		     +feedback.getCOMMENTS()+"')";

				try {
					int result = dbCon.executePrepared(sqlString);
			
					if(result>0) {return true;}
			
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();}
			return true;	
		}
		
		//retreive feedback of tutor
	public ResultSet retreiveFeedbackofTutor(String tutor_id) {
			String sQLstString = "select * from student_feedback where sf_tutor_id = "+tutor_id;
				try {
					rs = dbCon.executeStatement(sQLstString);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
			return rs;
		}
		
		//delete feedback optional
	//	public boolean deleteFeedback() {		}
	
	
}
