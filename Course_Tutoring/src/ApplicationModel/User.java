package ApplicationModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import JDBC.Courses_Table;
import JDBC.Department_Table;
import JDBC.Session_Table;
import JDBC.Student_Table;
import JDBC.Users_Database;
import jdk.javadoc.internal.doclets.formats.html.AllClassesFrameWriter;

public class User {
	
	static String User_ID;
	static String user_name;
	static String user_email;
	static String user_department;
	static ArrayList<Courses> AUScourses;
	static ArrayList<Department> AUSdepartments; 
	Users_Database users_table;
	Courses_Table course_table;
	Department_Table depat_table;
	Session_Table session_Table;

	User(){
		users_table = new Users_Database();
	}

public String getUser_ID() {
		return User_ID;
	}

	public void setUser_ID(String student) {
		User.User_ID = student;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		User.user_name = user_name;
	}

	public String getUser_email() {
		return user_email;
	}

	
	public void setUser_email(String email) {
		User.user_email = email;
		
	}
	
		//set everything including getting all the department and courses
	public ArrayList<String >getNotifications(ResultSet messages) {
		ArrayList<String> message = new ArrayList<String>();
		try {
			if(!messages.isBeforeFirst()) {return null;}
			while(messages.next()){
				message.add(messages.getString("MESSAGE"));
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		return message;
	}
	
	public boolean insertNotification(String sender, String receiver,String message) {}
	
	public void initializeAUSDepartments() {
		
	}
	
	public void initializeAUSCourses(){
	ResultSet courseSet = course_table.retreiveAUSCourses();
		
		courseSet.beforeFirst();
		while (courseSet.next()) {
			
			AUScourses.add(new Courses("course_ID", "course_Name", "departmentID"));
		}
	}
	
public void initializeUsers(String usertype, String userID) {
		//check which user, get details and set the attributes
	}
	
	public String validateUser(String email, String password) {
		
		String user_type = null;
		try {
			user_type = users_table.checkCredentials(email, password);
			if(user_type!= null)
			{
				//initialize user
				//set everything 
				return user_type;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;}
		
		return null;
	}
	
	public ArrayList<Session_Detail>getAllSessions(boolean upcomming) {
		ArrayList<Session_Detail> session = new ArrayList<Session_Detail>();
		ResultSet sessionSet = session_Table.retreievAllSessions(upcomming);
		
		try {
			if(!sessionSet.isBeforeFirst()) {return null;}
			while(sessionSet.next()){
			//	session.add(new Session_Detail(session_ID, tutor_Name, course_Name, classroom_ID, date_of_session, start_time, end_time, max_Seats))
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		return session;
	}
	
	
	
	}
