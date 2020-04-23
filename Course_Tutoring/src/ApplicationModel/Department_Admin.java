package ApplicationModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;


import JDBC.Admins_Table;
import JDBC.Faculty_Table;
import JDBC.Feedback_Table;
import JDBC.Student_Table;
import JDBC.Tutor_Application_Table;
import JDBC.Tutor_Courses_Table;
import JDBC.Tutor_Table;

public class Department_Admin extends User{
	
	ResultSet rSet;
	Admins_Table dept_table;
	Faculty_Table faculty_Table;
	Tutor_Table tutor;
	Tutor_Application_Table tutor_Application_Table;
	Tutor_Courses_Table tutor_Courses_Table;
	Student_Table student;
	Feedback_Table feedback_Table;
	
	//constructor
	public Department_Admin(String email) {
		dept_table = new Admins_Table();
		rSet = dept_table.getAdminDetails(email);
		try {
			rSet.beforeFirst();
			while(rSet.next()) {
				setUser_ID(rSet.getString("ADMIN_ID"));
				setUser_name(rSet.getString("ADMIN_NAME"));
				setUser_email(rSet.getString("ADMIN_EMAIL"));
				setUser_department(rSet.getString("A_DEPARTMENT_ID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	//default constructor
	public Department_Admin() {
		// TODO Auto-generated constructor stub
		dept_table = new Admins_Table();
		faculty_Table = new Faculty_Table();
		tutor = new Tutor_Table();
		tutor_Application_Table = new Tutor_Application_Table();
		tutor_Courses_Table = new Tutor_Courses_Table();
		student = new Student_Table();
		feedback_Table = new Feedback_Table();
	}

	//insert faculty memeber
	public boolean addFacultyMember(String f_Name, String f_Email, String f_password, String f_departmentID) {
		
		//add check to make sure email is unique
		//should i put cause database checks 
		
		if(faculty_Table.insertFaculty(f_Name, f_Email, f_password, f_departmentID)) {
			
			return true;
		}
		
		return false;
	}
	
	//approve tutor request
	public boolean approveTutor(Tutor_Application application) {
		
		//insert tutor
		if(tutor.insertTutor(application.getSTUDENT_ID(), application.ACADEMIC_STANDING))
		{
			//update tutor application status to Approved
			if(tutor_Application_Table.updateTutorApplicationStatus(application.getSTUDENT_ID(), "Approved")) {
				return true;
			}
		}
		return false;	
	}
	
	//reject tutor
     public boolean rejectTutor(Tutor_Application application) {
		
		if (tutor_Courses_Table.deleteCourses(application.getSTUDENT_ID())) {
			
			if (tutor_Application_Table.updateTutorApplicationStatus(application.getSTUDENT_ID(), "Rejected")) {
				
				return true;
			}
		}
		return false;
	}
	
	//getTutorApplications
     public ArrayList<Tutor_Application>getTutorApplications() {
 		ArrayList<Tutor_Application> application = new ArrayList<Tutor_Application>();
 		//get students of a dept
 		ResultSet studentdept = student.retreiveStudentsbyDept(getUser_department());
 		ResultSet applicationSet; 
 		
 		System.out.println(getUser_department());
 		try {
 		if (studentdept.isBeforeFirst()) {
 		while (studentdept.next()) {
 			//retreive application of a student
 			System.out.println(studentdept.getString("STUDENT_ID"));
 			applicationSet = tutor_Application_Table.retreiveTutorApplicationTable(studentdept.getString("STUDENT_ID"));
 	 		
 			if (applicationSet.isBeforeFirst()) {
				while(applicationSet.next()) {
				//add applications that are not processed

					System.out.print(studentdept.getString("STUDENT_ID"));
				if(applicationSet.getString("STATUS").equals("Applied")){
					
						application.add(new Tutor_Application(applicationSet.getString("TA_STUDENT_ID"), 
								applicationSet.getString("STUDENT_NAME"), 
								applicationSet.getString("ACADEMIC_STANDING")));
						}
				}}
 			}
 		}} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
 		return application;
 		
 	}
     
     public Tutor_Application getSpecificTutorApplication(String student_id) {
    	 
    	 ArrayList<Tutor_Application> allapplications = getTutorApplications();
    	 Tutor_Application particularApplication = null;
    	 Iterator<Tutor_Application> itr=allapplications.iterator();  
         //traverse elements of ArrayList object  
         while(itr.hasNext()){  
             Tutor_Application  ta=(Tutor_Application)itr.next();  
              if(ta.getSTUDENT_ID().equals(student_id)) {  // LINE ADDED
             	 particularApplication = ta;
     	 }}
         
         //get course and grades
         ArrayList<String> courses = new ArrayList<String>();
     	ArrayList<String> grades = new ArrayList<String>();
     	
     	ResultSet rSet = tutor_Courses_Table.retreiveTutorCourseTable(student_id);
		
     	try {
			rSet.beforeFirst();
			while(rSet.next()){
				courses.add(rSet.getString("TC_COURSE_ID"));
				grades.add(rSet.getString("GRADES"));
						}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     	particularApplication.setCOURSES(courses);
		particularApplication.setGRADES(grades);
		return particularApplication;
     }
     
     
 	//get Student feedback
    public ArrayList<Feedback> getFeedback() {
    	ArrayList<Feedback> feedbacks = new ArrayList<Feedback>();
 		//get students of a dept
 		ResultSet studentdept = student.retreiveStudentsbyDept(getUser_department());
 		ResultSet applicationSet; 
 		try {
 		studentdept.isBeforeFirst();
 		while (studentdept.next()) {
 			//retreive application of a student
 			ResultSet rSet = feedback_Table.retreiveFeedbackofTutor(studentdept.getString("STUDENT_ID"));
 			rSet.isBeforeFirst();
				while(rSet.next())
				
				feedbacks.add(new Feedback(rSet.getString("SF_STUDENT_ID"), 
						rSet.getString("STUDENT_NAME"), 
						rSet.getString("SF_TUTOR_ID"), 
						rSet.getString("TUTOR_NAME"),
						rSet.getString("COMMENTS"), 
						rSet.getString("TUTOR_ALSO")));
				}
 			} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
 		return feedbacks;
	}
     
    // (Dhriti) can you please add this function
    public Feedback getSpecificFeedbackFrom(String tutor_id) {

    	
    }
    
  //remove tutor
    public boolean removeTutor(String tutor_id) {
    
    if(tutor.deleteTutor(tutor_id)) {
    	
    	return true;
    }
    
    return false;}
    

    }
    
     

	

	
	

	

