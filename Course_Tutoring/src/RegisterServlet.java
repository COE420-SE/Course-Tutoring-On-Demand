import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ApplicationModel.Student;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	Student stud;
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
			String student_psw = request.getParameter("psw");
			System.out.println("password is " + student_psw);
			// check if user exist in model
			stud = new Student();
			
			
			System.out.println("what is the email"+stud.getUser_email());
			boolean registartion = stud.Registration(stud.getUser_email(), student_psw);
			if (registartion) {
				response.sendRedirect("login.html");
			}
			//else response.sendRedirect("error.html");
	}
		}}

