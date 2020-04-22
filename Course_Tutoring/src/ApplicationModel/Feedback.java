package ApplicationModel;

public class Feedback {


	

	String STUDENT_ID;
	String STUDENT_NAME;
	String TUTOR_ID;
	String TUTOR_NAME;
	String COMMENTS;
	String SEND_TUTOR;


	public Feedback(String sTUDENT_ID, String sTUDENT_NAME, String tUTOR_ID, String tUTOR_NAME, String cOMMENTS,
			String sEND_TUTOR) {
		super();
		STUDENT_ID = sTUDENT_ID;
		STUDENT_NAME = sTUDENT_NAME;
		TUTOR_ID = tUTOR_ID;
		TUTOR_NAME = tUTOR_NAME;
		COMMENTS = cOMMENTS;
		SEND_TUTOR = sEND_TUTOR;
	}

	public Feedback(String sTUDENT_ID, String tUTOR_ID, String cOMMENTS, String sEND_TUTOR) {
		super();
		STUDENT_ID = sTUDENT_ID;
		TUTOR_ID = tUTOR_ID;
		COMMENTS = cOMMENTS;
		SEND_TUTOR = sEND_TUTOR;
	}
	public Feedback(String tUTOR_ID, String tUTOR_NAME) {
		super();
		TUTOR_ID = tUTOR_ID;
		TUTOR_NAME = tUTOR_NAME;
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


	public String getSTUDENT_NAME() {
		return STUDENT_NAME;
	}

	public void setSTUDENT_NAME(String sTUDENT_NAME) {
		STUDENT_NAME = sTUDENT_NAME;
	}

	public String getTUTOR_NAME() {
		return TUTOR_NAME;
	}

	public void setTUTOR_NAME(String tUTOR_NAME) {
		TUTOR_NAME = tUTOR_NAME;
	}

}
