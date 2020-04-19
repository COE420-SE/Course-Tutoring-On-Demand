package ApplicationModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import JDBC.Session_Table;
import JDBC.Student_Table;
import JDBC.Tutor_Table;

public class Tutor extends User{

	
	Tutor_Table tutor_table;
	Session_Table session_Table;
	ResultSet rsResultSet;
	
	public Tutor() {
		
		tutor_table = new Tutor_Table();
		session_Table = new Session_Table();
		
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
	
	
	// get courses 
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
		
		//check if there is not time and date conflict
		System.out.println("in create session");
		
		if(session_Table.insertNewSession(newSession, getUser_ID()))
			return true;
		else
			return false;
	}
	
	public boolean cancelSession(String sessionID) {
		if (session_Table.deleteSession(sessionID))
			return true;
		else
			return false;
	}
	
	//get session requests
	
	//get student feedback
	
	//get tutor sessions for drop

}
