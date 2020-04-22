import java.io.IOException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ApplicationModel.Department_Admin;
import ApplicationModel.Session_Detail;
import ApplicationModel.System_Admin;
import ApplicationModel.Tutor;
import ApplicationModel.Tutor_Application;


/**
 * Servlet implementation class CreateSessionServlet
 */
@WebServlet("/ProcessRequestServlet")
public class ProcessRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Department_Admin dept_Admin = new Department_Admin();
	String student_id;
	Tutor_Application application;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProcessRequestServlet() {
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
		if (null!= request.getParameter("next")) {
			student_id = request.getParameter("tutor_id");
			System.out.println(student_id);
			
			application = dept_Admin.getSpecificTutorApplication(student_id);
			request.setAttribute("application", application); 
			RequestDispatcher rd =  request.getRequestDispatcher("ProcessTutorRequest.jsp"); 
			rd.forward(request, response);
			}
		else if(null!= request.getParameter("accept")) {
			
			if(dept_Admin.approveTutor(application)) {
				String message = "Tutor application for "+student_id+" has been approved";
				request.setAttribute("message", message);
				RequestDispatcher rd =  request.getRequestDispatcher("DepartmentMessage.jsp"); 
				rd.forward(request, response);
				
			dept_Admin.insertNotification(dept_Admin.getUser_ID(), student_id, "Your application has been approved, you are a tutor now");
			}
				
			}
		else if(null!= request.getParameter("reject")){
			
			if(dept_Admin.rejectTutor(application)) {
				String message = "Tutor application for "+student_id+" has been rejected";
				request.setAttribute("message", message);
				RequestDispatcher rd =  request.getRequestDispatcher("DepartmentMessage.jsp"); 
				rd.forward(request, response);}
				
			}
		else {
			String message = "There has been an error with processing the application. Try again later";
			request.setAttribute("message", message);
			RequestDispatcher rd =  request.getRequestDispatcher("DepartmentMessage.jsp"); 
			rd.forward(request, response);
		}
			
	}
				 

	}
	




