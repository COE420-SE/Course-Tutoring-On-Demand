package ApplicationModel;

import java.sql.ResultSet;
import java.sql.SQLException;

import JDBC.Admins_Table;

public class System_Admin extends User{
	
	ResultSet rSet;
	Admins_Table system_table;
	
	public System_Admin(String userEmail) {
		system_table = new Admins_Table();
		rSet = system_table.getAdminDetails(userEmail);
			try {
				rSet.beforeFirst();
				while(rSet.next())
				setUser_ID(rSet.getString("ADMIN_ID"));
				setUser_name(rSet.getString("ADMIN_NAME"));
				setUser_email(rSet.getString("ADMIN_EMAIL"));
				setUser_department(rSet.getString("A_DEPARTMENT_ID"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}
	
	
	public System_Admin() {
		// TODO Auto-generated constructor stub
		system_table = new Admins_Table();
	}


	public boolean addDepartmentAdmin(String d_Name, String d_Email, String d_password, String d_departmentID) {
		
		//add check to make sure email is unique
		if(system_table.insertDeptAdmin(d_Name, d_Email, d_password, d_departmentID)) {
			
			return true;
		}

		return false;
		
		
	}

}
