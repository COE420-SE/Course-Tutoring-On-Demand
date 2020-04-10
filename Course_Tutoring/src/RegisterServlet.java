import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ApplicationModel.Student;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	Student student_model;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		
		// get password and call register
	
		if (null != request.getParameter("register_button")) {
			String student_mail = request.getParameter("username");
			System.out.println("username entered is " + student_mail);
			// check if user exist in model
			//
				RequestDispatcher req = request.getRequestDispatcher("register.html");
				req.include(request, response);
			}
			else response.sendRedirect("doesnotexist.html");
		} 
//		else if (null != request.getParameter("login_button")) {
//			response.sendRedirect("login.html");
//		} 
			//response.sendRedirect("login.html");
	}

