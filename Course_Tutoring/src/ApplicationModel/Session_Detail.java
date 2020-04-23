package ApplicationModel;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Session_Detail {
	
	String Session_ID;
	String Tutor_Name;
	String Course_Name;
	String Classroom_ID;
	String date_of_session;
	String start_time;
	String end_time;
	String max_Seats;
	
	public Session_Detail(String session_ID, String tutor_Name, String course, String classroom_ID,
			String date_of_session, String start_time, String end_time, String max_Seats) {
		super();
		Session_ID = session_ID;
		Tutor_Name = tutor_Name;
		Course_Name = course;
		Classroom_ID = classroom_ID;
		this.date_of_session = date_of_session;
//    String dateStr = date_of_session;
//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:MM:ss:ms");
//    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MMM-yy");
//	this.date_of_session = LocalDate.parse(dateStr, formatter).format(formatter2);
//	
		this.start_time = start_time;
		this.end_time = end_time;
		this.max_Seats = max_Seats;
	}
	
	//constructor for inserting session
	public Session_Detail(String course_ID, String classroom_ID, String date_of_session, String start_time, String end_time, String max_Seats) {
		super();
		Session_ID = " ";
		this.Course_Name = course_ID;
		this.Classroom_ID = classroom_ID;
				this.date_of_session = date_of_session;
		this.start_time = start_time;
		this.end_time = end_time;
		this.max_Seats = max_Seats;
	}
	
	
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

	public void setCourse_ID(String course_ID) {
		Course_Name = course_ID;
	}
	public String getClassroom_ID() {
		return Classroom_ID;
	}
	public void setClassroom_ID(String classroom_ID) {
		Classroom_ID = classroom_ID;
	}
	public String getDate_of_session() {
		return date_of_session;
	}
	public void setDate_of_session(String date_of_session) {
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
	public String getMax_Seats() {
		return max_Seats;
	}
	public void setMax_Seats(String max_Seats) {
		this.max_Seats = max_Seats;
	}

	public String getCourse_ID() {
		// TODO Auto-generated method stub
		return Course_Name;
	}

}
