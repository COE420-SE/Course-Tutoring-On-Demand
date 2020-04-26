
import java.io.IOException;
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

import ApplicationModel.Courses;
import ApplicationModel.Student;
import ApplicationModel.Tutor;
import ApplicationModel.User;
import ApplicationModel.Session_Detail;
import ApplicationModel.Session_Requests;

/**
 * Servlet implementation class CreateSessionServlet
 */
@WebServlet("/RequestASessionServlet")
public class RequestASessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Student studentModel = new Student();
	RequestDispatcher rd;

	


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RequestASessionServlet() {
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
		// TODO Auto-generated method stub
		
			String course = request.getParameter("course");
			String date = convertDate(request.getParameter("datemin"));
			String tYPE = request.getParameter("session_type");
			String comment = request.getParameter("comment");
			
			Session_Requests req =new Session_Requests(studentModel.getUser_ID(),course, date, tYPE, comment);
			
			if(studentModel.RequestASession(req)) {
				//insert notification to tutor about session request;
				ArrayList<String> tutList = new ArrayList<String>();
				tutList = studentModel.getTutorsByCourseTaught(course);
				
				for (String string : tutList) {
					studentModel.insertNotification(studentModel.getUser_ID(), string, "There is a new session request for course: "+course+"");    
				}
				
				String message = "Success: Session request for "+course+" is successfull";
				request.setAttribute("message", message);
				
				
				if (Student.getUser_type().equals("student")) {
					rd = request.getRequestDispatcher("StudentMessage.jsp"); 	
				}
				else {
					rd = request.getRequestDispatcher("TutorMessage.jsp"); 	
				}
				rd.forward(request, response);
			}
			else {
				String message = "Error: Session request is unsuccesfull, Try again later";
				request.setAttribute("message", message);
				if (Student.getUser_type().equals("student")) {
					rd = request.getRequestDispatcher("StudentMessage.jsp"); 	
				}
				else {
					rd = request.getRequestDispatcher("TutorMessage.jsp"); 	
				}
				rd.forward(request, response);
			}

	
}
	public String convertDate(String date) {

	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MMM-yy");
	    String newDate = LocalDate.parse(date, formatter).format(formatter2);
	    
	    return newDate;
	}	
}
