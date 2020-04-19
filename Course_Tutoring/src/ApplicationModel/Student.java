package ApplicationModel;

import ApplicationModel.Session_Detail;
import java.sql.ResultSet;
import java.sql.SQLException;

import JDBC.MockAUSDatabase;
import JDBC.Student_Table;

public class Student extends User {
	
	MockAUSDatabase mock;
	Student_Table student_table;
	ResultSet rSet;

public Student() {
	mock = new MockAUSDatabase();
	student_table = new Student_Table();
	// TODO Auto-generated constructor stub
}


public Student(String mail) {
	mock = new MockAUSDatabase();
	student_table = new Student_Table();
	
	student_table = new Student_Table();
	rSet = student_table.getStudentDetails(mail);
	try {
	rSet.beforeFirst();
	while(rSet.next()) {
		setUser_ID(rSet.getString("STUDENT_ID"));
		setUser_name(rSet.getString("STUDENT_NAME"));
		setUser_email(rSet.getString("STUDENT_EMAIL"));
		setUser_department(rSet.getString("STUDENT_MAJOR"));
	}} catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}

}


//check if student 
public boolean isAUSStudent(String student_mail) {
	//add check to see if its not in the student table
	try {
		rSet = mock.retreiveAUSStudent(student_mail);
		System.out.println(student_mail);
		if(rSet.isBeforeFirst()){
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

//check if student exists in the course tutpring databse
	//returns tru if exists false otherwise
	public boolean StudentExists(ResultSet student_details) throws SQLException {
		
		if(student_details.isBeforeFirst()) {
			System.out.print("student exists in the course tutoring database");
			return true;
		}
		else {
			System.out.println("Student doesnt exist");
			return false;}
		}

//check if the student can register in the system
public boolean canRegister(String email) {
	
	//get student details
	ResultSet temp = student_table.getStudentDetails(email);
	
	try {
		if(!StudentExists(temp)) {
			//if not check if user exists in the mock database 
			if (isAUSStudent(email)) {
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
public boolean Registration(String email, String password) {
	
	//Retrieve student record form mock database
	System.out.println("in registration");
	ResultSet mock_result = mock.retreiveAUSStudent(email);
	System.out.println("testing registration");
	//insert the data into the course tutoring database
	if(student_table.insertStudent(mock_result, password)) {
		return true;
	}
	System.out.println("problem in inserting");
	return false;
}

//book a session

//cancel a booking

//request a session

//apply to become a tutor


//get booked sessions


}

