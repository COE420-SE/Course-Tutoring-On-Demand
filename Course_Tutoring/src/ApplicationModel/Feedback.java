package ApplicationModel;

public class Feedback {


	String STUDENT_ID;
	String TUTOR_ID;
	String COMMENTS;
	String SEND_TUTOR;

	public Feedback(String sTUDENT_ID, String tUTOR_ID, String cOMMENTS, String sEND_TUTOR) {
		super();
		STUDENT_ID = sTUDENT_ID;
		TUTOR_ID = tUTOR_ID;
		COMMENTS = cOMMENTS;
		SEND_TUTOR = sEND_TUTOR;
	}

	public String getSTUDENT_ID() {
		return STUDENT_ID;
	}

	public void setSTUDENT_ID(String sTUDENT_ID) {
		STUDENT_ID = sTUDENT_ID;
	}
	
	public String getTUTOR_ID() {
		return TUTOR_ID;
	}

	public void setTUTOR_ID(String tUTOR_ID) {
		TUTOR_ID = tUTOR_ID;
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
