package JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Courses_Table {
	DBConnection dbCon;
	ResultSet rs;
	
	public Courses_Table() {
		// TODO Auto-generated constructor stub
		
		dbCon = new DBConnection();
	}
	
	
	public ResultSet retreiveAUSCourses() {
		String sqlString = "SELECT * FROM COURSES";
		
		try {
			rs = dbCon.executeStatement(sqlString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;		
	}
	
	

	public ResultSet retreiveCoursesofTutor(String tutor_id) {
		// TODO Auto-generated method stub
		String sqlString = "select * from courses where course_id in (select tc_course_id from tutor_courses where tc_tutor_id = "+tutor_id+")";
		
		try {
			rs = dbCon.executeStatement(sqlString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}
