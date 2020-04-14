package ApplicationModel;

import java.sql.ResultSet;
import java.sql.SQLException;

import JDBC.Admins_Table;

public class Department_Admin extends User{
	
	ResultSet rSet;
	
	
	public Department_Admin(String email) {
		Admins_Table dept_table = new Admins_Table();
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
	
	//add a faculty user
}
