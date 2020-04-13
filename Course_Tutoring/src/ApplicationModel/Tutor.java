package ApplicationModel;

import java.sql.ResultSet;
import java.util.List;

import JDBC.Student_Table;
import JDBC.Tutor_Table;
import sun.security.util.Password;

public class Tutor extends User{

	
	Tutor_Table tutor_table;
	ResultSet rsResultSet;
	
	public Tutor() {
		
		tutor_table = new Tutor_Table();
	}
	//createSession()
	//pass the tutor_id ad course_id also session detail, 
	
	
	
//	public List<String> getCourseName(){

}
