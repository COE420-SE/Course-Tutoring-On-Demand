package ApplicationModel;

public class User {
	
	int User_ID;
	String user_name;
	String user_email;

	User(){}

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
	public void getNotifications(String receiver) {}

	}
