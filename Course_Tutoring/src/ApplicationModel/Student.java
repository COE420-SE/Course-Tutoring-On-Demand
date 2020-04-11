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

public boolean isAUSStudent(String student_mail) {
	//add check to see if its not in the student table
	try {
		rsResultSet = mock.retreiveAUSStudent(student_mail);
		if(rsResultSet.isBeforeFirst()){
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

//check if the student can register in the system
public boolean canRegister() {
	
	//get student details
	ResultSet temp = student_table.getStudentDetails(user_email);
	
	try {
		if(student_table.StudentExists(temp)) {
			//if not check if user exists in the mock database 
			if (isAUSStudent(user_email)) {
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
public boolean Registration(String password) {
	
	//Retrieve student record form mock database
	ResultSet mock_result = mock.retreiveAUSStudent(user_email);
	
	//insert the data into the course tutoring database
	if(student_table.insertStudent(mock_result, password)) {
		return true;
	}
	return false;
}

}

