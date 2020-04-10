package ApplicationModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import JDBC.Users_Database;

public class User {
	
	static int User_ID;
	static String user_name;
	static String user_email;
	Users_Database users_table;

	User(){
		users_table = new Users_Database();
	}

public int getUser_ID() {
		return User_ID;
	}

	public void setUser_ID(int user_ID) {
		User_ID = user_ID;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_email() {
		return user_email;
	}

	
	public void setUser_email(String email) {
		this.user_email = email;
		
	}
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
				setUser_email(email);
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
