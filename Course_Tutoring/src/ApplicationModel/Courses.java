package ApplicationModel;

public class Courses {

	String COURSE_ID;
	String COURSE_NAME;
	String DEPARTMENT_ID;
	
	public Courses(String course_ID, String course_Name, String departmentID) {
		super();
		this.COURSE_ID = course_ID;
		this.COURSE_NAME = course_Name;
		this.DEPARTMENT_ID = departmentID;
	}
	public String getCOURSE_ID() {
		return COURSE_ID;
	}

	public void setCOURSE_ID(String cOURSE_ID) {
		COURSE_ID = cOURSE_ID;
	}

	public String getCOURSE_NAME() {
		return COURSE_NAME;
	}

	public void setCOURSE_NAME(String cOURSE_NAME) {
		COURSE_NAME = cOURSE_NAME;
	}

	public String getDEPARTMENT_ID() {
		return DEPARTMENT_ID;
	}

	public void setDEPARTMENT_ID(String dEPARTMENT_ID) {
		DEPARTMENT_ID = dEPARTMENT_ID;
	}

}
