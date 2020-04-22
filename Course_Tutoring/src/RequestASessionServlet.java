
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
import ApplicationModel.Session_Requests;

/**
 * Servlet implementation class CreateSessionServlet
 */
@WebServlet("/RequestASessionServlet")
public class RequestASessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Student studentModel = new Student();

	


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
			String course = request.getParameter("course");
			String date = request.getParameter("datemin");
			String tYPE = request.getParameter("session type");
			String comment = request.getParameter("comment");
			
			Session_Requests req =new Session_Requests(studentModel.getUser_ID(),course, date, tYPE, comment);
			
			if(studentModel.RequestASession(req)) {
				String message = "Success: Session request for "+course+" is successfull";
				request.setAttribute("message", message);
				RequestDispatcher rd =  request.getRequestDispatcher("StudentMessage.jsp"); 
				rd.forward(request, response);
			}
			else {
				String message = "Error: Session request is unsuccesfull, Try again later";
				request.setAttribute("message", message);
				RequestDispatcher rd =  request.getRequestDispatcher("DepartmentMessage.jsp"); 
				rd.forward(request, response);
			}

	
}}
