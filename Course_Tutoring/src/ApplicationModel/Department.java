package ApplicationModel;

public class Department {
	
	String DEPARTMENT_ID;
	String DEPARTMENT_NAME;
	
	public Department(String dEPARTMENT_ID, String dEPARTMENT_NAME) {
		super();
		DEPARTMENT_ID = dEPARTMENT_ID;
		DEPARTMENT_NAME = dEPARTMENT_NAME;
	}
	public String getDEPARTMENT_ID() {
		return DEPARTMENT_ID;
	}
	public void setDEPARTMENT_ID(String dEPARTMENT_ID) {
		DEPARTMENT_ID = dEPARTMENT_ID;
	}
	public String getDEPARTMENT_NAME() {
		return DEPARTMENT_NAME;
	}
	public void setDEPARTMENT_NAME(String dEPARTMENT_NAME) {
		DEPARTMENT_NAME = dEPARTMENT_NAME;
	}
	
	
}
