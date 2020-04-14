package ApplicationModel;

import java.sql.ResultSet;
import java.sql.SQLException;

import JDBC.Faculty_Table;

public class Faculty extends User{

	ResultSet rSet;
	Faculty_Table faculty_Table;
	
	
	public  Faculty(String userEmail) {
		
	faculty_Table = new Faculty_Table();
	rSet = faculty_Table.getFacultyDetails(userEmail);
	try {
		rSet.beforeFirst();
		while(rSet.next()) {
			setUser_ID(rSet.getString("FACULTY_ID"));
			setUser_name(rSet.getString("FACULTY_NAME"));
			setUser_email(rSet.getString("FACULTY_EMAIL"));
			setUser_department(rSet.getString("F_DEPARTMENT_ID"));}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}


	public Faculty() {
		// TODO Auto-generated constructor stub
		faculty_Table = new Faculty_Table();
	}

	
}
