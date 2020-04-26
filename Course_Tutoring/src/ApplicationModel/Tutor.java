package ApplicationModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


import JDBC.Feedback_Table;
import JDBC.Session_Requests_Table;
import JDBC.Session_Table;
import JDBC.Student_Table;
import JDBC.Tutor_Table;

public class Tutor extends User{

	
	Tutor_Table tutor_table;
	Session_Table session_Table;
	Session_Requests_Table requests_table;
	Feedback_Table feedback_Table;
	ResultSet rsResultSet;
	
	public Tutor() {
		
		tutor_table = new Tutor_Table();
		session_Table = new Session_Table();
		requests_table = new Session_Requests_Table();
		feedback_Table = new Feedback_Table();
		
	}
	
	public Tutor(String email) {
		
		Student_Table tutor_Table = new Student_Table();
		ResultSet rSet = tutor_Table.getStudentDetails(email);
		try {
			rSet.beforeFirst();
			while(rSet.next()) {
				setUser_ID(rSet.getString("STUDENT_ID"));
				setUser_name(rSet.getString("STUDENT_NAME"));
				setUser_email(rSet.getString("STUDENT_EMAIL"));
				setUser_department(rSet.getString("STUDENT_MAJOR"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	// get courses of tutor
	public ArrayList<Courses> getCoursesTaughtByTutor(String tutor_id) {

		ResultSet courseSet = course_table.retreiveCoursesofTutor(tutor_id);
		ArrayList<Courses> tutor_courses = new ArrayList<Courses>();
		try {
			courseSet.beforeFirst();
			while (courseSet.next()) {

				tutor_courses.add(new Courses(courseSet.getString("COURSE_ID"), courseSet.getString("COURSE_NAME"),
						courseSet.getString("C_DEPARTMENT_ID")));
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tutor_courses;

	}
	
	//createSession()
	public boolean createSession(Session_Detail newSession) {
		
		System.out.println("in create session");
		
		if(session_Table.insertNewSession(newSession, getUser_ID()))
			return true;
		else
			return false;
	}
	
	public boolean checkIfSessionExists(Session_Detail session) {
		return true;
	}
	
	//cancel a session
	public boolean cancelSession(String sessionID) {
		
		if(session_Table.deleteSession(sessionID)) {
			
			return true;
		}
		return false;
	}
	
	//get session requests
	public ArrayList<Session_Requests> retreiveSessionRequestsforTutor(String tutor_id){
		
		ArrayList<Session_Requests> requests = new ArrayList<Session_Requests>();
		ResultSet requestSet = requests_table.retreiveSessionRequestsforTutor(tutor_id);
		
		try {
			if(requestSet.isBeforeFirst()) {
			while(requestSet.next()){
			requests.add(new Session_Requests(requestSet.getString("SR_STUDENT_ID"),
					requestSet.getString("SR_COURSE_ID"), 
					requestSet.getString("REQUEST_DATE"),
					requestSet.getString("TYPE_OF_SESSION"),
					 requestSet.getString("COMMENTS")));
					}}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			return requests;
	}
	
	//get student feedback for tutors
		public ArrayList<Feedback> retreiveFeedbacksforTutor(String tutor_id){
			
			ArrayList<Feedback> feedbacks = new ArrayList<Feedback>();
			ResultSet feedbackSet = feedback_Table.retreiveFeedbackforTutor(tutor_id);
			
			try {
				feedbackSet.beforeFirst();
				while(feedbackSet.next()){
				feedbacks.add(new Feedback(feedbackSet.getString("FEEDBACK_ID"),
						feedbackSet.getString("SF_STUDENT_ID"), 
						feedbackSet.getString("STUDENT_NAME"), 
						feedbackSet.getString("SF_TUTOR_ID"), 
						feedbackSet.getString("TUTOR_NAME"), 
						feedbackSet.getString("COMMENTS"), 
						feedbackSet.getString("TUTOR_ALSO")));
						}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();}
			
				return feedbacks;
		}
		
	
	//get tutor sessions of tutor
		//this is for cancel a session
		public ArrayList<Session_Detail>getSessionsofTutor(String tutor_id, boolean upcomming) {
			ArrayList<Session_Detail> session = new ArrayList<Session_Detail>();
			ResultSet sessionSet = session_Table.retreievSessionsByTutor(tutor_id, upcomming);
			
			try {
				sessionSet.beforeFirst();
				while(sessionSet.next()){
					java.sql.Date date = sessionSet.getDate("DATE_OF_SESSION");
					DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
					String dateStr = dateFormat.format(date);
					
					Session_Detail sDetail = new Session_Detail(sessionSet.getString("SESSION_ID"), 
							sessionSet.getString("STUDENT_NAME"), 
							sessionSet.getString("S_COURSE_ID"),
							sessionSet.getString("S_CLASSROOM_ID"),
							dateStr,
							sessionSet.getString("START_TIME"),
							sessionSet.getString("END_TIME"),
							sessionSet.getString("MAX_CAPACITY"));
					
					ArrayList<String> student_name= getAllStudentNamesOfSession(sessionSet.getString("SESSION_ID"));
					
					sDetail.setStudent_names(student_name);
					
				session.add(sDetail);
				
						}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
			return session;
		}
		
		public boolean checkIFSessionExists(String date) {
			
			String sqlString = "select * from sessions where s_tutor_id = "+getUser_ID()+" and date_of_session = '"+date+"'";
			ResultSet sessionSet = users_table.customExecuteSQL(sqlString);
			
			try {
				if (sessionSet.isBeforeFirst()) {
					sessionSet.next();
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false;
		}
		
		

}
