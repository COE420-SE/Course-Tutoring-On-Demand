package ApplicationModel;

public class Feedback {
	
	String STUDENT_ID;
	String SESSION_ID;
	String COMMENTS;
	String SEND_TUTOR;

	public Feedback(String sTUDENT_ID, String sESSION_ID, String cOMMENTS, String sEND_TUTOR) {
		super();
		STUDENT_ID = sTUDENT_ID;
		SESSION_ID = sESSION_ID;
		COMMENTS = cOMMENTS;
		SEND_TUTOR = sEND_TUTOR;
	}
	public String getSTUDENT_ID() {
		return STUDENT_ID;
	}
	public void setSTUDENT_ID(String sTUDENT_ID) {
		STUDENT_ID = sTUDENT_ID;
	}
	public String getSESSION_ID() {
		return SESSION_ID;
	}
	public void setSESSION_ID(String sESSION_ID) {
		SESSION_ID = sESSION_ID;
	}
	public String getCOMMENTS() {
		return COMMENTS;
	}
	public void setCOMMENTS(String cOMMENTS) {
		COMMENTS = cOMMENTS;
	}
	public String getSEND_TUTOR() {
		return SEND_TUTOR;
	}
	public void setSEND_TUTOR(String sEND_TUTOR) {
		SEND_TUTOR = sEND_TUTOR;
	}

	
}
