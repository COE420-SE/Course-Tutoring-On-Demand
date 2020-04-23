import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ApplicationModel.Department;
import ApplicationModel.Department_Admin;
import ApplicationModel.Feedback;
import ApplicationModel.Session_Detail;
import ApplicationModel.Tutor;
import ApplicationModel.Tutor_Application;
import ApplicationModel.User;


@WebServlet("/DepartServlet")
public class DepartServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	Department_Admin deptAdmin = new Department_Admin();
	Tutor tutor = new Tutor();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartServlet() {
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
		if (null != request.getParameter("process_button")) {
			ArrayList<Tutor_Application> listapp = deptAdmin.getTutorApplications();
			
			request.setAttribute("applications", listapp);
			for (int i = 0; i < listapp.size(); i++) {
				
				System.out.println(listapp.get(i).getSTUDENT_NAME());
			}
			
			RequestDispatcher rd =  request.getRequestDispatcher("Choose_Application.jsp"); 
			rd.forward(request, response);
			
		} 
		else if (null != request.getParameter("add_faculty_button")) {
			
			System.out.print(deptAdmin.getUser_name());
			ArrayList<Department> listDept = User.getAUSdepartments();
			request.setAttribute("department", listDept); 
			
			RequestDispatcher rd =  request.getRequestDispatcher("AddFaculty.jsp"); 
			rd.forward(request, response);
			
		} 
		else if (null != request.getParameter("view_feedback_button")) {
			ArrayList<Feedback> listFeedback = deptAdmin.getFeedback();
			request.setAttribute("feedback", listFeedback); 
			RequestDispatcher rd =  request.getRequestDispatcher("Display_Feedback.jsp"); 
			rd.forward(request, response);
		}
		else if (null != request.getParameter("remove_tutor_button")) {
			
		}
		else if (null != request.getParameter("display_session_button")) {
			ArrayList<Session_Detail> listSessions = deptAdmin.getAllSessions(true);
			
			
			request.setAttribute("session", listSessions); 
			
			RequestDispatcher rd =  request.getRequestDispatcher("Display_Session.jsp"); 
			rd.forward(request, response);
			
		}
		else if (null != request.getParameter("notify_button")) {
			
		}
	}

}
