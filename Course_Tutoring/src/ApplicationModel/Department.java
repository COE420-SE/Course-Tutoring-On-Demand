package ApplicationModel;

public class Department {
	String DepartmentID;
	String departmentNameString;
	
	public Department(String departmentID, String departmentNameString) {
		super();
		DepartmentID = departmentID;
		this.departmentNameString = departmentNameString;
	}

	public String getDepartmentID() {
		return DepartmentID;
	}
	public String getDepartmentNameString() {
		return departmentNameString;
	}
}
