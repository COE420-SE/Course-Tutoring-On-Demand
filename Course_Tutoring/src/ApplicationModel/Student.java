package ApplicationModel;

import java.sql.SQLException;

import JDBC.MockAUSDatabase;

public class Student extends User {
boolean Apply_for_tutor;

public Student() {
	// TODO Auto-generated constructor stub
}

public boolean isAUSStudent(String studentID) {
	MockAUSDatabase mock = new MockAUSDatabase();
	boolean student_exists = false;
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

