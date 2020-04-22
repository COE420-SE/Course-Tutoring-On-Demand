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
			String sQLstString = "select f.sf_student_id, s.student_name, f.sf_tutor_id, t.student_name TUTOR_NAME, f.tutor_also, f.comments " + 
					"from student_feedback f, student s, student t " + 
					"where f.sf_student_id = s.student_id and f.sf_tutor_id = t.student_id and f.sf_tutor_id ="+tutor_id;
				try {
					rs = dbCon.executeStatement(sQLstString);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
			return rs;
		}
		
	//retreive feedbacks that a tutor can see
	public ResultSet retreiveFeedbackforTutor(String tutor_id) {
		String sQLstString = "select f.sf_student_id, s.student_name, f.sf_tutor_id, t.student_name TUTOR_NAME, f.tutor_also, f.comments " + 
				"from student_feedback f, student s, student t " + 
				"where f.sf_student_id = s.student_id and f.sf_tutor_id = t.student_id and  f.tutor_also = 'Y' and f.sf_tutor_id ="+tutor_id;
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
	
}
