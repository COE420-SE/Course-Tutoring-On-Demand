package ApplicationModel;

import java.sql.Date;

public class Session_Detail {
	public String getSession_ID() {
		return Session_ID;
	}
	public void setSession_ID(String session_ID) {
		Session_ID = session_ID;
	}
	public String getTutor_Name() {
		return Tutor_Name;
	}
	public void setTutor_Name(String tutor_Name) {
		Tutor_Name = tutor_Name;
	}
	public String getCourse_ID() {
		return Course_ID;
	}
	public void setCourse_ID(String course_ID) {
		Course_ID = course_ID;
	}
	public String getClassroom_ID() {
		return Classroom_ID;
	}
	public void setClassroom_ID(String classroom_ID) {
		Classroom_ID = classroom_ID;
	}
	public Date getDate_of_session() {
		return date_of_session;
	}
	public void setDate_of_session(Date date_of_session) {
		this.date_of_session = date_of_session;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public int getMax_Seats() {
		return max_Seats;
	}
	public void setMax_Seats(int max_Seats) {
		this.max_Seats = max_Seats;
	}
	String Session_ID;
	String Tutor_Name;
	String Course_ID;
	String Classroom_ID;
	Date date_of_session;
	String start_time;
	String end_time;
	int max_Seats;
}
