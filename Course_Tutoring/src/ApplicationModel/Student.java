package ApplicationModel;

import java.sql.ResultSet;
import java.sql.SQLException;

import JDBC.MockAUSDatabase;
import JDBC.Student_Table;

public class Student extends User {
	boolean Apply_for_tutor;
	MockAUSDatabase mock;
	Student_Table student_table;
	ResultSet rsResultSet;

public Student(String email) {
	mock = new MockAUSDatabase();
	student_table = new Student_Table();
	
	super.setUser_email(email);
	
	// TODO Auto-generated constructor stub
}

public boolean isAUSStudent(String student_email) {
	boolean student_exists = false;
	//add check to see if its not in the student table
	try {
		student_exists = mock.searchStudentByID(student_email);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.print("checking in model");
	return student_exists;
}

public boolean canRegister() {
	
	//check if user exists in Course Tutoring System
	try {
		if(!student_table.StudentExists(user_email)) {
			//if not check if user exists in the mock database 
			if (isAUSStudent(user_email)) {
				return true;
			}
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
	
}

public boolean Registration(String password) {
	
	//Retrieve student record form mock database
	rsResultSet = mock.retreiveAUSStudent(user_email);
	
	//insert the data into the course tutoring database
	if(student_table.insertStudent(rsResultSet, password)) {
		return true;
	}
	return false;
}

}

