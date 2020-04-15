
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ApplicationModel.Courses;
import ApplicationModel.Session_Detail;
import ApplicationModel.Student;
import ApplicationModel.Tutor;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 Student student= new Student();

	Student studentModel = new Student();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentServlet() {
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
		if (null != request.getParameter("book_button")) {
					ArrayList<Session_Detail> listSessions = studentModel.getAllSessions(true);
					
			
					request.setAttribute("session", listSessions); 
					
					RequestDispatcher rd =  request.getRequestDispatcher("Book_Session.jsp"); 
					rd.forward(request, response);	
			
		}
		else if (null != request.getParameter("cancel_button")) {
			
		} 
		else if (null != request.getParameter("feedback_button")) {
			
		}
		else if (null != request.getParameter("request_button")) {
			
		}
		else if (null != request.getParameter("notify_button")) {
			ArrayList<String> message;
		}
		else if (null != request.getParameter("tutor_button")) {
			
		}		
}
}

