
import java.io.IOException;
import java.util.ArrayList;

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

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet("/CreateSessionServlet")
public class CreateSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Tutor tutor;;
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateSessionServlet() {
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
		
	//	if (null != request.getParameter("register_button")) {
			// check if user exist in model
			
	//}
	}
}