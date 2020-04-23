package ApplicationModel;

import ApplicationModel.Session_Detail;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import JDBC.Feedback_Table;
import JDBC.MockAUSDatabase;
import JDBC.Session_Requests_Table;
import JDBC.Student_Session_Table;
import JDBC.Student_Table;
import JDBC.Tutor_Application_Table;
import JDBC.Tutor_Courses_Table;
import JDBC.Tutor_Table;
import oracle.net.aso.f;

public class Student extends User {
	
	MockAUSDatabase mock;
	Student_Table student_table;
	Student_Session_Table student_Session_Table;
	Session_Requests_Table session_Requests_Table;
	Tutor_Application_Table tutor_Application_Table;
	Tutor_Courses_Table tutor_Courses_Table;
	Tutor_Table tutor_Table;
	Feedback_Table feedback_Table;
	
	ResultSet rSet;

public Student() {
	mock = new MockAUSDatabase();
	student_table = new Student_Table();
	student_Session_Table = new Student_Session_Table();
	session_Requests_Table = new Session_Requests_Table();
	tutor_Courses_Table = new Tutor_Courses_Table();
	tutor_Application_Table = new Tutor_Application_Table();
	feedback_Table = new Feedback_Table();
	tutor_Table = new Tutor_Table();
	// TODO Auto-generated constructor stub
}


public Student(String mail) {
	mock = new MockAUSDatabase();
	student_table = new Student_Table();
	rSet = student_table.getStudentDetails(mail);
	try {
	rSet.beforeFirst();
	while(rSet.next()) {
		setUser_ID(rSet.getString("STUDENT_ID"));
		setUser_name(rSet.getString("STUDENT_NAME"));
		setUser_email(rSet.getString("STUDENT_EMAIL"));
		setUser_department(rSet.getString("STUDENT_MAJOR"));
	}} catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}

}


//check if student 
public boolean isAUSStudent(String student_mail) {
	//add check to see if its not in the student table
	try {
		rSet = mock.retreiveAUSStudent(student_mail);
		System.out.println(student_mail);
		if(rSet.isBeforeFirst()){
			System.out.println("Student exists in AUS database");
			return true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("Student doesnt exist in AUS database");
	return false;
}

//check if student exists in the course tutpring databse
	//returns tru if exists false otherwise
	public boolean StudentExists(ResultSet student_details) throws SQLException {
		
		if(student_details.isBeforeFirst()) {
			System.out.print("student exists in the course tutoring database");
			return true;
		}
		else {
			System.out.println("Student doesnt exist");
			return false;}
		}

//check if the student can register in the system
public boolean canRegister(String email) {
	
	//get student details
	ResultSet temp = student_table.getStudentDetails(email);
	
	try {
		if(!StudentExists(temp)) {
			//if not check if user exists in the mock database 
			if (isAUSStudent(email)) {
				return true;
			}
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("cant register");
	return false;
}

//registers the student
public boolean Registration(String email, String password) {
	
	//Retrieve student record form mock database
	System.out.println("in registration");
	ResultSet mock_result = mock.retreiveAUSStudent(email);
	System.out.println("testing registration");
	//insert the data into the course tutoring database
	if(student_table.insertStudent(mock_result, password)) {
		return true;
	}
	System.out.println("problem in inserting");
	return false;
}

//book a session
public boolean BookASession(String session_id) {
	
	if (student_Session_Table.insertStudentSession(getUser_ID(), session_id)) {
		
		return true;
	}
	else return false;
}




//cancel a booking
public boolean CancelABooking(String session_id) {
	
	if (student_Session_Table.deleteStudentSession(getUser_ID(), session_id)){
		
		return true;
	}
	else return false;
}


//request a session
public boolean RequestASession(Session_Requests newRequest) {
	
	if (session_Requests_Table.insertSessionRequests(newRequest)) {
		
		return true;
	}
	else return false;
}


//apply to become a tutor
public boolean ApplyToBeTutor(Tutor_Application newApplication) {
	
	//insert in tutor apploctaion
	if(tutor_Application_Table.insertTutorApplication(getUser_ID(),newApplication.getACADEMIC_STANDING())) {
	
	ArrayList<String> courses = newApplication.getCOURSES();
	ArrayList<String> grades = newApplication.getGRADES();
	//insert in tutor_courses
	for (int i = 0; i < courses.size(); i++) {
		
		if (!tutor_Courses_Table.insertTutorCourse(getUser_ID(), courses.get(i), grades.get(i))) {
			return false;
		}
	}
	//update apply_to_be)tutor in student
	if (student_table.updateApplyForTutor(getUser_ID())) {
		return true;
	}	
}
	return false;}

  public boolean givefeedback(Feedback feedback) {
	  
	  if(feedback_Table.insertFeedback(feedback)) {
		  return true;
	  }
	  return false;
}

 //get tutor names and id
  public ArrayList<Feedback> getTutorsofSessionDone(){
	  
	  ArrayList<Feedback> tutorList = new ArrayList<Feedback>();
	  ResultSet sResultSet = tutor_Table.retreiveTutorsofStudent(getUser_ID());
	  
	  try {
		if (sResultSet.isBeforeFirst()) {
			while (sResultSet.next()) {
				
				tutorList.add(new Feedback(sResultSet.getString("STUDENT_ID"), sResultSet.getString("STUDENT_NAME")));
				}
			}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return tutorList;
  }

  
//check if student already applied
public boolean alreadyApplied() {
	
	ResultSet  rSet = tutor_Application_Table.retreiveTutorApplicationTable(getUser_ID());
		
	try {
		if (rSet.isBeforeFirst()) {
			return true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
}

//get unbooked and non full sessions
public ArrayList<Session_Detail>getBookableSessionforStudent(String student_id) {
	ArrayList<Session_Detail> session = new ArrayList<Session_Detail>();
	ResultSet countSet = session_Table.retreieveBookableSessionOfStudent(student_id);
	
	try {
		countSet.beforeFirst();
		while(countSet.next()){
			
		if (countSet.getInt("NO_OF_STUDENTS")+1 < countSet.getInt("MAX_CAPACITY") ) {
			
			ResultSet sessionSet = session_Table.retreiveSessionBySessionID(countSet.getString("SESSION_ID"));
			
			if (sessionSet.isBeforeFirst()) {
				sessionSet.next();
				
				java.sql.Date date = sessionSet.getDate("DATE_OF_SESSION");
				DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
				String dateStr = dateFormat.format(date);
				
			session.add(new Session_Detail(sessionSet.getString("SESSION_ID"), 
					sessionSet.getString("STUDENT_NAME"), 
					sessionSet.getString("S_COURSE_ID"),
					sessionSet.getString("S_CLASSROOM_ID"),
					dateStr,
					sessionSet.getString("START_TIME"),
					sessionSet.getString("END_TIME"),
					sessionSet.getString("MAX_CAPACITY")));
			}
		}
				}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	return session;
}

public String getTutorIDofSession(String sessioString) {
	String tutoridString = null;
	
	ResultSet rSet = session_Table.retreiveTutorDetailsOfSession(sessioString);
	
	
		try {
			rSet.beforeFirst();
			while(rSet.next()) {
			tutoridString = rSet.getString("STUDENT_ID");}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tutoridString;
}


//get tutor dept for notifying adminabout feedback
public String getTutorDept(String tutor_id) {
	
String tutoridString = null;
	
	ResultSet rSet = student_table.retreiveStudentTableDetails(tutor_id);
	
		try {
			rSet.beforeFirst();
			while(rSet.next()) {
			tutoridString = rSet.getString("STUDENT_MAJOR");}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tutoridString;
}

public ArrayList<String> getTutorsByCourseTaught(String course) {

	ArrayList<String> tutor = new ArrayList<String>();
	
	ResultSet resultSet = tutor_Courses_Table.retreiveTutorCourseTableBYCourse(course);
	
	
		try {
			if (!resultSet.isAfterLast()) admins_Table = null;
			while(resultSet.next()) {
			tutor.add(resultSet.getString("TC_TUTOR_ID"));}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tutor;
}
}


