import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ApplicationModel.Classroom;
import ApplicationModel.Courses;
import ApplicationModel.Department;
import ApplicationModel.Department_Admin;
import ApplicationModel.Faculty;
import ApplicationModel.Session_Detail;
import ApplicationModel.User;
import JDBC.Faculty_Table;


@WebServlet("/FacultyServlet")
public class FacultyServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	Faculty faculty = new Faculty();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacultyServlet() {
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
		 if (null != request.getParameter("display_session_button")) {
			
	
			ArrayList<Session_Detail> listSessions = faculty.getAllSessions(true);
			
	
			request.setAttribute("session", listSessions); 
			
			RequestDispatcher rd =  request.getRequestDispatcher("Display_Session.jsp"); 
			rd.forward(request, response);
			
		
	}

}}
