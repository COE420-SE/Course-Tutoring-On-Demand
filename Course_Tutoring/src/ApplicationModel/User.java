package ApplicationModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import JDBC.Courses_Table;
import JDBC.Department_Table;
import JDBC.Student_Table;
import JDBC.Users_Database;
import jdk.javadoc.internal.doclets.formats.html.AllClassesFrameWriter;

public class User {
	
	static String User_ID;
	static String user_name;
	static String user_email;
	static ArrayList<Courses> AUScourses;
	static ArrayList<Department> AUSdepartments; 
	Users_Database users_table;
	Courses_Table course_table;
	Department_Table depat_table;

	User(){
		users_table = new Users_Database();
		
		ResultSet courseSet = course_table.retreiveAUSCourses();
		
		courseSet.beforeFirst();
		while (courseSet.next()) {
			
			AUScourses.add(new Courses(course_ID, course_Name, departmentID));
		}
		
		
	}

public String getUser_ID() {
		return User_ID;
	}

	public void setUser_ID(String stud_id) {
		User_ID = stud_id;
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
	
	public String validateUser(String email, String password) {
		
		String user_type = null;
		try {
			user_type = users_table.checkCredentials(email, password);
			if(user_type!= null)
			{
				return user_type;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;}
		
		return null;
	}
	
	public ArrayList<Session_Detail>getSessions(ResultSet messages) {
		ArrayList<Session_Detail> session = new ArrayList<Session_Detail>();
		try {
			if(!messages.isBeforeFirst()) {return null;}
			while(messages.next()){
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		return session;
	}
	
	}
