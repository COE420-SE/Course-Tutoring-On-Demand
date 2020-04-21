package ApplicationModel;

import java.sql.ResultSet;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

import com.sun.nio.sctp.Notification;

import JDBC.Admins_Table;
import JDBC.Classroom_Table;
import JDBC.Courses_Table;
import JDBC.Department_Table;
import JDBC.Faculty_Table;
import JDBC.MockAUSDatabase;
import JDBC.Notifications_Table;
import JDBC.Session_Table;
import JDBC.Student_Table;
import JDBC.Users_Database;


public class User {
	

	static String User_ID;
	static String user_name;
	static String user_email;
	static String user_department;
	static String user_type;
	static ArrayList<Courses> AUScourses;
	static ArrayList<Department> AUSdepartments; 
	static ArrayList<Classroom> AUSclassrooms; 
	Users_Database users_table;
	Courses_Table course_table;
	Department_Table depat_table;
	Session_Table session_Table;
	Classroom_Table classroom_Table ;

	public User(){
		users_table = new Users_Database();
		course_table = new Courses_Table();
		depat_table = new Department_Table();
		session_Table = new Session_Table();
		classroom_Table = new Classroom_Table();
		
		initializeAUSCourses();
		initializeAUSDepartments();
		initializeAUSClassrooms();
	}
	
	public ArrayList<Courses> getAUScourses() {
		return AUScourses;
	}

	public static void setAUScourses(ArrayList<Courses> aUScourses) {
		AUScourses = aUScourses;
	}

	public static ArrayList<Department> getAUSdepartments() {
		return AUSdepartments;
	}

	public static void setAUSdepartments(ArrayList<Department> aUSdepartments) {
		AUSdepartments = aUSdepartments;
	}
	
	public static ArrayList<Classroom> getAUSclassrooms() {
		return AUSclassrooms;
	}

	public static void setAUSclassrooms(ArrayList<Classroom> aUSclassrooms) {
		AUSclassrooms = aUSclassrooms;
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
	public static String getUser_department() {
			return user_department;
	}
	 
	public static void setUser_department(String user_department) {
			User.user_department = user_department;
	}
	public static String getUser_type() {
		return user_type;
	}

	public static void setUser_type(String user_type) {
		User.user_type = user_type;
	}
	//getter and setter finish
		
	
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
	
	//insert notification 
	//return true if inserted successfull and false otherwise
	public boolean insertNotification(String sender, String receiver,String message) {
		
		Notifications_Table notification = new Notifications_Table();
		return notification.insertNotification(sender, receiver, message);
	}
	
	//initialize AUS departments
	public void initializeAUSDepartments() {
		ResultSet deptSet = depat_table.retreiveAUSDepartments();
		AUSdepartments = new ArrayList<Department>();
			try {
				deptSet.beforeFirst();
				while (deptSet.next()) {
					
					AUSdepartments.add(new Department(deptSet.getString("DEPARTMENT_ID"), deptSet.getString("DEPARTMENT_NAME")));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	public void initializeAUSClassrooms() {
		ResultSet classSet = classroom_Table.retreiveAUSClassrooms();
		AUSclassrooms= new ArrayList<Classroom>();
			try {
				classSet.beforeFirst();
				while (classSet.next()) {
					
					AUSclassrooms.add(new Classroom(classSet.getString("CLASSROOM_ID"), classSet.getString("BUILDING"), classSet.getString("TOTAL_SEATS")));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	//initialize AUS Courses
	public void initializeAUSCourses(){
	ResultSet courseSet = course_table.retreiveAUSCourses();
	AUScourses = new ArrayList<Courses>();
		try {
			courseSet.beforeFirst();
			while (courseSet.next()) {
				
				AUScourses.add(new Courses(courseSet.getString("COURSE_ID"), courseSet.getString("COURSE_NAME"), courseSet.getString("C_DEPARTMENT_ID")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	

	

public String validateUser(String email, String password) {
	 
		String user_type;
		try {
			user_type = users_table.checkCredentials(email, password);

			if(user_type!= null)
			{
				
				setUser_type(user_type);
				System.out.print(user_type);
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
			sessionSet.beforeFirst();
			while(sessionSet.next()){
			session.add(new Session_Detail(sessionSet.getString("SESSION_ID"), 
					sessionSet.getString("STUDENT_NAME"), 
					sessionSet.getString("S_COURSE_ID"),
					sessionSet.getString("S_CLASSROOM_ID"),
					sessionSet.getString("DATE_OF_SESSION"),
					sessionSet.getString("START_TIME"),
					sessionSet.getString("END_TIME"),
					sessionSet.getString("MAX_CAPACITY")));
			
					}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		return session;
	}
	
	public ArrayList<Session_Detail>getSessionsByTutor(String tutor_id, boolean upcomming) {
		ArrayList<Session_Detail> session = new ArrayList<Session_Detail>();
		ResultSet sessionSet = session_Table.retreievSessionsByTutor(tutor_id, upcomming);
		
		try {
			sessionSet.beforeFirst();
			while(sessionSet.next()){
			session.add(new Session_Detail(sessionSet.getString("SESSION_ID"), 
					sessionSet.getString("STUDENT_NAME"), 
					sessionSet.getString("S_COURSE_ID"),
					sessionSet.getString("S_CLASSROOM_ID"),
					sessionSet.getString("DATE_OF_SESSION"),
					sessionSet.getString("START_TIME"),
					sessionSet.getString("END_TIME"),
					sessionSet.getString("MAX_CAPACITY")));
			
					}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		return session;
	}
	
	public ArrayList<Session_Detail>getSessionsByStudnet(String student_id, boolean upcomming) {
		ArrayList<Session_Detail> session = new ArrayList<Session_Detail>();
		ResultSet sessionSet = session_Table.retreievSessionsOfStudent(student_id, upcomming);
		
		try {
			sessionSet.beforeFirst();
			while(sessionSet.next()){
			session.add(new Session_Detail(sessionSet.getString("SESSION_ID"), 
					sessionSet.getString("STUDENT_NAME"), 
					sessionSet.getString("S_COURSE_ID"),
					sessionSet.getString("S_CLASSROOM_ID"),
					sessionSet.getString("DATE_OF_SESSION"),
					sessionSet.getString("START_TIME"),
					sessionSet.getString("END_TIME"),
					sessionSet.getString("MAX_CAPACITY")));
			
					}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		return session;
	}
	
	
	}
