package ApplicationModel;

import java.util.ArrayList;

public class Tutor_Application {

	String STUDENT_ID;
	String STUDENT_NAME;
	ArrayList<String>COURSES;
	ArrayList<String>GRADES;
	String ACADEMIC_STANDING;
	
	public Tutor_Application(String sTUDENT_ID, String sTUDENT_NAME, String aCADEMIC_STANDING) {
		super();
		STUDENT_ID = sTUDENT_ID;
		STUDENT_NAME = sTUDENT_NAME;
		ACADEMIC_STANDING = aCADEMIC_STANDING;
	}


	public Tutor_Application(String sTUDENT_ID, String sTUDENT_NAME, ArrayList<String> cOURSES,
			ArrayList<String> gRADES, String aCADEMIC_STANDING) {
		STUDENT_ID = sTUDENT_ID;
		STUDENT_NAME = sTUDENT_NAME;
		COURSES = cOURSES;
		GRADES = gRADES;
		ACADEMIC_STANDING = aCADEMIC_STANDING;
	}
	public String getSTUDENT_NAME() {
		return STUDENT_NAME;
	}

	public void setSTUDENT_NAME(String sTUDENT_NAME) {
		STUDENT_NAME = sTUDENT_NAME;
	}
	
	public String getSTUDENT_ID() {
		return STUDENT_ID;
	}
	public void setSTUDENT_ID(String sTUDENT_ID) {
		STUDENT_ID = sTUDENT_ID;
	}
	public ArrayList<String> getCOURSES() {
		return COURSES;
	}
	public void setCOURSES(ArrayList<String> cOURSES) {
		COURSES = cOURSES;
	}
	public ArrayList<String> getGRADES() {
		return GRADES;
	}
	public void setGRADES(ArrayList<String> gRADES) {
		GRADES = gRADES;
	}
	public String getACADEMIC_STANDING() {
		return ACADEMIC_STANDING;
	}
	public void setACADEMIC_STANDING(String aCADEMIC_STANDING) {
		ACADEMIC_STANDING = aCADEMIC_STANDING;
	}


}
