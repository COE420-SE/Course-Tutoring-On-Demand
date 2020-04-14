import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ApplicationModel.Session_Detail;
import ApplicationModel.System_Admin;
import ApplicationModel.Tutor;


/**
 * Servlet implementation class CreateSessionServlet
 */
@WebServlet("/AddDepartServlet")
public class AddDepartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	System_Admin system_Admin = new System_Admin();
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddDepartServlet() {
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
			
			boolean success = system_Admin.addDepartmentAdmin(name, email, pass, dept);
			
			if (success) {
				
			
				
			RequestDispatcher rd =  request.getRequestDispatcher("SystemAdmin.html"); 
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



