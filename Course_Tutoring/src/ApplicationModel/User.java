package ApplicationModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

import com.sun.crypto.provider.RSACipher;
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
import jdk.javadoc.internal.doclets.formats.html.AllClassesFrameWriter;

public class User {
	
	static String User_ID;
	static String user_name;
	static String user_email;
	static String user_department;
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
	
	//initialzes attributes for the user
	//should this be moved to the respective classes ?
public void initializeUsers(String usertype, String userEmail) throws SQLException {
	
	String ID;
	String NAME;
	String EMAIL;
	String DEPARTMENT;
	ResultSet rSet;
	//check which user, get details and set the attributes
	if(usertype.toLowerCase() == "student") {
		
		Student_Table student_Table = new Student_Table();
		rSet = student_Table.getStudentDetails(userEmail);
		rSet.beforeFirst();
		while(rSet.next()) {
			ID = rSet.getString("STUDENT_ID");
			NAME = rSet.getString("STUDENT_NAME");
			EMAIL =  rSet.getString("STUDENT_EMAIL");
			DEPARTMENT = rSet.getString("STUDENT_MAJOR");
		}
	}
	else if (usertype.toLowerCase() == "tutor") {
		Student_Table tutor_Table = new Student_Table();
		rSet = tutor_Table.getStudentDetails(userEmail);
		rSet.beforeFirst();
		while(rSet.next()) {
			ID = rSet.getString("STUDENT_ID");
			NAME = rSet.getString("STUDENT_NAME");
			EMAIL =  rSet.getString("STUDENT_EMAIL");
			DEPARTMENT = rSet.getString("STUDENT_MAJOR");
		}
	}
    else if (usertype.toLowerCase() == "department") {
    	Admins_Table dept_table = new Admins_Table();
		rSet = dept_table.getAdminDetails(userEmail);
		rSet.beforeFirst();
		while(rSet.next()) {
			ID = rSet.getString("ADMIN_ID");
			NAME = rSet.getString("ADMIN_NAME");
			EMAIL =  rSet.getString("ADMIN_EMAIL");
			DEPARTMENT = rSet.getString("A_DEPARTMENT_ID");
		}
	}
    else if (usertype.toLowerCase() == "system") {
    	Admins_Table system_table = new Admins_Table();
		rSet = system_table.getAdminDetails(userEmail);
		rSet.beforeFirst();
		while(rSet.next()) {
			ID = rSet.getString("ADMIN_ID");
			NAME = rSet.getString("ADMIN_NAME");
			EMAIL =  rSet.getString("ADMIN_EMAIL");
			DEPARTMENT = rSet.getString("A_DEPARTMENT_ID");
		}
}
    else if (usertype.toLowerCase() == "faculty") {
    	Faculty_Table faculty_Table = new Faculty_Table();
		rSet = faculty_Table.getFacultyDetails(userEmail);
		rSet.beforeFirst();
		while(rSet.next()) {
			ID = rSet.getString("STUDENT_ID");
			NAME = rSet.getString("STUDENT_NAME");
			EMAIL =  rSet.getString("STUDENT_EMAIL");
			DEPARTMENT = rSet.getString("STUDENT_MAJOR");
		}
}
    else {""}
	
	

	}
	

public String validateUser(String email, String password) {
	 
		String user_type;
		try {
			user_type = users_table.checkCredentials(email, password);

			if(user_type!= null)
			{
				
				//initialize user
				//set everything 
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
