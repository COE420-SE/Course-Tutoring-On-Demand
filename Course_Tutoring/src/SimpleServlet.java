
import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ApplicationModel.Student;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet("/SimpleServlet")
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Student stud;
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SimpleServlet() {
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
		if (null != request.getParameter("register_button")) {
			String student_email= request.getParameter("username");
			System.out.println("username entered is " + student_email);
			// check if user exist in model
			stud = new Student(student_email);
			
			boolean reg = stud.canRegister();
			
			
			if (reg) {
				response.sendRedirect("register.html");
			}
			else response.sendRedirect("doesnotexist.html");
		} 
		else if (null != request.getParameter("login_button")) {
			response.sendRedirect("login.html");
		} 
	}
}
