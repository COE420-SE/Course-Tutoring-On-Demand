package ApplicationModel;

import java.util.ArrayList;

public class Tutor_Application {
	
	String STUDENT_ID;
	ArrayList<String>COURSES;
	ArrayList<String>GRADES;
	String ACADEMIC_STANDING;
	String STATUS_OF_APPLICATION;
	
	public Tutor_Application(String sTUDENT_ID, ArrayList<String> cOURSES, ArrayList<String> gRADES,
			String aCADEMIC_STANDING, String sTATUS_OF_APPLICATION) {
		super();
		STUDENT_ID = sTUDENT_ID;
		COURSES = cOURSES;
		GRADES = gRADES;
		ACADEMIC_STANDING = aCADEMIC_STANDING;
		STATUS_OF_APPLICATION = sTATUS_OF_APPLICATION;
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
	public String getSTATUS_OF_APPLICATION() {
		return STATUS_OF_APPLICATION;
	}
	public void setSTATUS_OF_APPLICATION(String sTATUS_OF_APPLICATION) {
		STATUS_OF_APPLICATION = sTATUS_OF_APPLICATION;
	}

}
