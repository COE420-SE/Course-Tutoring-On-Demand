package ApplicationModel;

import java.sql.ResultSet;
import java.sql.SQLException;

import JDBC.Admins_Table;
import JDBC.Faculty_Table;

public class Department_Admin extends User{
	
	ResultSet rSet;
	Admins_Table dept_table;
	Faculty_Table faculty_Table;
	
	
	public Department_Admin(String email) {
		dept_table = new Admins_Table();
		faculty_Table = new Faculty_Table();
		rSet = dept_table.getAdminDetails(email);
		try {
			rSet.beforeFirst();
			while(rSet.next()) {
				setUser_ID(rSet.getString("ADMIN_ID"));
				setUser_name(rSet.getString("ADMIN_NAME"));
				setUser_email(rSet.getString("ADMIN_EMAIL"));
				setUser_department(rSet.getString("A_DEPARTMENT_ID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public Department_Admin() {
		// TODO Auto-generated constructor stub
		dept_table = new Admins_Table();
		faculty_Table = new Faculty_Table();
	}

	public boolean addFacultyMember(String f_Name, String f_Email, String f_password, String f_departmentID) {
		
		//add check to make sure email is unique
		//should i put cause database checks 
		
		if(faculty_Table.insertFaculty(f_Name, f_Email, f_password, f_departmentID)) {
			
			return true;
		}
		
		return false;
	}

	
	
	
	
	}
