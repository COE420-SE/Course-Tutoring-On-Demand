package JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Tutor_Courses_Table {

	DBConnection dbCon;
	ResultSet rs;
	
	public Tutor_Courses_Table() {
		
		dbCon = new DBConnection();	
	}
	
	//insert tutor course
	public boolean insertTutorCourse(String tutor_id, ArrayList<String> courses, ArrayList<String>grades) {
		
		
		for (int i = 0; i < courses.size(); i++) {
			String sqlString = "INSERT INTO tutor_courses VALUES("+tutor_id+", '"+courses.get(i)+"', '"+grades.get(i)+"')";

			try {
				
				int result = dbCon.executePrepared(sqlString);
		
				if(result<=0) {return false;}
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return true;	
	}
	
	//delete tutor course
	public boolean deleteCourses(String tutor_id) {

			String sqlString = "DELETE FROM tutor_courses WHERE tc_tutor_id = "+tutor_id+";";

			try {
				
				int result = dbCon.executePrepared(sqlString);
		
				if(result<=0) {return false;}
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return true;	
	}
	
	
	//retreive grades of tutor
	public ResultSet retreiveGradesOfTutor(String tutor_id) {
		// TODO Auto-generated method stub
		String sqlString = "select * from tutor_courses where tc_tutor_id = "+74266;
		
		try {
			rs = dbCon.executeStatement(sqlString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}
