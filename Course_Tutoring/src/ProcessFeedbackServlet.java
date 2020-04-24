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
import ApplicationModel.Feedback;
import ApplicationModel.Session_Detail;
import ApplicationModel.System_Admin;
import ApplicationModel.Tutor;
import ApplicationModel.Tutor_Application;


/**
 * Servlet implementation class ProcessFeedbackServlet
 */
@WebServlet("/ProcessFeedbackServlet")
public class ProcessFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Department_Admin dept_Admin = new Department_Admin();
	String feedback_id;
	Feedback form;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProcessFeedbackServlet() {
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
			feedback_id = request.getParameter("feedback_id");
			System.out.println(feedback_id);
			
			form = dept_Admin.getSpecificFeedbackFrom(feedback_id);
			
			request.setAttribute("feedback", form); 
			RequestDispatcher rd =  request.getRequestDispatcher("ProcessTutorFeedback.jsp"); 
			rd.forward(request, response);
			}
		
		else {
			RequestDispatcher rd ;
			String message = "There has been an error. Try again later";
			request.setAttribute("message", message);
			if (Department_Admin.getUser_type().equals("tutor")) {
				rd =  request.getRequestDispatcher("TutorMessage.jsp"); 
			}
			else {rd =  request.getRequestDispatcher("DepartmentMessage.jsp");} 
			
			rd.forward(request, response);
		}
			
	}
				 

	}
	





