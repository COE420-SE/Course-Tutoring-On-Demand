import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ApplicationModel.Student;
import ApplicationModel.User;
import JDBC.Faculty_Table;
import jdk.internal.jline.console.UserInterruptException;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	User login_user;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//che
		String user = request.getParameter("username");
		String pswd = request.getParameter("pwd");
		System.out.println("username and password entered is "+ user + pswd);
		
		//student, tutpr, Faculty_Table, System, department
		login_user = new User();
	    String user_type = login_user.validateUser(user, pswd);
		//redirect to student view
		if(user_type.toLowerCase() == "student") {
			Student student = new Student();
		RequestDispatcher req = request.getRequestDispatcher("Student.html");
		req.include(request, response);
		}
		else if(user_type.toLowerCase() == "tutor") {
			RequestDispatcher req = request.getRequestDispatcher("Tutor_Student.html");
			req.include(request, response);
		}
		else if(user_type.toLowerCase() == "department") {
			RequestDispatcher req = request.getRequestDispatcher("DepartmentAdmin.html");
			req.include(request, response);
		}
		else if(user_type.toLowerCase() == "system") {
			RequestDispatcher req = request.getRequestDispatcher("SystemAdmin.html");
			req.include(request, response);
		}
		else if(user_type.toLowerCase() == "faculty") {
			RequestDispatcher req = request.getRequestDispatcher("faculty.html");
			req.include(request, response);
		}
		else {
			response.sendRedirect("error.html");
		} 
	}

}
