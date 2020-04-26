
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.events.EndDocument;

import ApplicationModel.Courses;
import ApplicationModel.Session_Detail;
import ApplicationModel.Student;
import ApplicationModel.Tutor;
import ApplicationModel.Tutor_Application;
import ApplicationModel.User;

/**
 * Servlet implementation class CreateSessionServlet
 */
@WebServlet("/BeTutorServlet")
public class BeTutorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Student studentModel = new Student();
	ArrayList<String> CourseChosen;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BeTutorServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (null != request.getParameter("next")) {
			String[] course = request.getParameterValues("courses");
			CourseChosen = new ArrayList<String>();
			for (int i = 0; i < course.length; i++) {
				CourseChosen.add((String) course[i]);
			}
			for (int i = 0; i < CourseChosen.size(); i++) {
				System.out.println(CourseChosen.get(i));
			}
			if (CourseChosen.size() > 10) {
				String message = "Error: you cannot tutor more than 10 courses :)";
				request.setAttribute("message", message);
				RequestDispatcher rd =  request.getRequestDispatcher("StudentMessage.jsp"); 
				rd.forward(request, response);
			}
			//add the courses to tutorcourse table (dhriti)
			else {
				request.setAttribute("course_list", CourseChosen);
			RequestDispatcher rd =  request.getRequestDispatcher("Apply_Tutor_Grade.jsp"); 
			rd.forward(request, response);
			}
		}
		// TODO Auto-generated method stub
		else {
			String[] grades = request.getParameterValues("grades");
			ArrayList<String> grade = new ArrayList<String>();
			for (int i = 0; i < grades.length; i++) {
				grade.add((String) grades[i]);
			}
			for (int i = 0; i < grade.size(); i++) {
				System.out.println(grade.get(i));
			}
			String AcademicStanding = request.getParameter("standing");
			
			Tutor_Application newApplication = new Tutor_Application(studentModel.getUser_ID(), studentModel.getUser_name(),CourseChosen,grade, AcademicStanding);
			
			
			//add the grades and acadamic standing 
			if(studentModel.ApplyToBeTutor(newApplication)) {
				
				ArrayList<String> notifyStrings= studentModel.getDeptAdminID(Student.getUser_department());
				
				for (String string : notifyStrings) {
					studentModel.insertNotification(studentModel.getUser_ID(), string, "New Tutor request from "+studentModel.getUser_name());
				}
				
				String message = studentModel.getUser_name()+ "successfully completed tutor applications";
				request.setAttribute("message", message);
				RequestDispatcher rd =  request.getRequestDispatcher("StudentMessage.jsp"); 
				rd.forward(request, response);}
			else {
				String message = "Error: there was an error with your application try again later";
				request.setAttribute("message", message);
				RequestDispatcher rd =  request.getRequestDispatcher("StudentMessage.jsp"); 
				rd.forward(request, response);
			}
		}
	}
}
