package ApplicationModel;

import java.sql.SQLException;

import JDBC.MockAUSDatabase;

public class Student extends User {
	boolean Apply_for_tutor;
	MockAUSDatabase mock;

public Student() {
	mock = new MockAUSDatabase();
	// TODO Auto-generated constructor stub
}

public boolean isAUSStudent(String studentID) {
	boolean student_exists = false;
	//add check to see if its not in the student table
	try {
		student_exists = mock.searchStudentByID(studentID);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.print("checking in model");
	return student_exists;
}

public boolean Register(String student) {return false;}

}

