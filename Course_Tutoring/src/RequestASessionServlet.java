
import java.io.IOException;
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

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet("/RequestASessionServlet")
public class RequestASessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Student student;;
	


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

		String session = request.getParameter("session");
		
		// check if the session not already exist 
		if (session == Session_Detail.getCourse_ID()) {
			response.sendRedirect("error.html");
		}
		
		else {
			RequestDispatcher rd =  request.getRequestDispatcher("Request a session.jsp"); 
			rd.forward(request, response);
		}

	}
}
