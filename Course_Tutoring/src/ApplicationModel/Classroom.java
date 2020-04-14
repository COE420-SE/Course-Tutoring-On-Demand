package ApplicationModel;

public class Classroom {
	String ClassroomID;
	String ClassroomName;
	
	public Classroom(String classroomId, String classroomname) {
		super();
		ClassroomID = classroomId;
		ClassroomName = classroomname;
	}
	
	public String getClassroomID() {
		return ClassroomID;
	}
	
	public String getClassroomName() {
		return ClassroomName;
	}
}
