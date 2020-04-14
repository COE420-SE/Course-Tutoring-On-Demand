import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ApplicationModel.Department_Admin;
import ApplicationModel.System_Admin;

/**
 * Servlet implementation class CreateSessionServlet
 */
@WebServlet("/AddFacultyServlet")
public class AddFacultyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Department_Admin department_Admin = new Department_Admin();
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddFacultyServlet() {
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
			String name = request.getParameter("name");
			String email = request.getParameter("username");
			String pass = request.getParameter("psw");
			String dept = request.getParameter("department");
			
			
			System.out.println(name);
			System.out.println(email);
			System.out.println(dept);
			System.out.println(pass);
	
		
			//make a instance of session detail
			
			boolean success = department_Admin.addFacultyMember(name, email, pass, dept);
			
			if (success) {
				
			
				
			RequestDispatcher rd =  request.getRequestDispatcher("DepartmentAdmin.html"); 
			rd.forward(request, response);
			
			}
			
			else {
				RequestDispatcher error =  request.getRequestDispatcher("error.html");
				error.forward(request, response);
			}
	}
				 

	//}
	}
	
	
}
