package ApplicationModel;

public class Session_Requests {
	
	String STUDENT_ID;
	String COURSE_ID;
	String DATE;
	//G for group S for single
	String TYPE;
	String COMMENT;
	
	
	public Session_Requests(String sTUDENT_ID, String cOURSE_ID, String dATE, String tYPE, String cOMMENT) {
		super();
		STUDENT_ID = sTUDENT_ID;
		COURSE_ID = cOURSE_ID;
		DATE = dATE;
		TYPE = tYPE;
		COMMENT = cOMMENT;
	}
	public String getSTUDENT_ID() {
		return STUDENT_ID;
	}
	public void setSTUDENT_ID(String sTUDENT_ID) {
		STUDENT_ID = sTUDENT_ID;
	}
	public String getCOURSE_ID() {
		return COURSE_ID;
	}
	public void setCOURSE_ID(String cOURSE_ID) {
		COURSE_ID = cOURSE_ID;
	}
	public String getDATE() {
		return DATE;
	}
	public void setDATE(String dATE) {
		DATE = dATE;
	}
	public String getTYPE() {
		return TYPE;
	}
	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}
	public String getCOMMENT() {
		return COMMENT;
	}
	public void setCOMMENT(String cOMMENT) {
		COMMENT = cOMMENT;
	}


}
