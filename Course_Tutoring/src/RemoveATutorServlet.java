import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ApplicationModel.Tutor;
import ApplicationModel.Department_Admin;

/**
 * Servlet implementation class RemoveATutorServlet
 */
@WebServlet("/RemoveATutorServlet")
public class RemoveATutorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Department_Admin depart_Admin = new Department_Admin();
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveATutorServlet() {
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
		if (null != request.getParameter("submit")) {
			String tutor_id = request.getParameter("tutor");
			System.out.println(tutor_id);
			
			//check if tutor has sessions
			
			if (depart_Admin.TutorHasSession(tutor_id)) {
				String message = "Tutor #"+tutor_id+" has upcomming sessions, please ask tutor to drop their sessions before proceeding";
				request.setAttribute("message", message);
				RequestDispatcher rd =  request.getRequestDispatcher("DepartMessage.jsp"); 
				rd.forward(request, response);
				}
			
			else if (depart_Admin.removeTutor(tutor_id)) {
				
				//insert notification
				depart_Admin.insertNotification(depart_Admin.getUser_ID(), tutor_id, "You have lost your Tutor privileges, you are a student now");
				
				String message = "Successfully removed tutor #"+tutor_id;
				request.setAttribute("message", message);
				RequestDispatcher rd =  request.getRequestDispatcher("DepartMessage.jsp"); 
				rd.forward(request, response);}
			else {
				String message = "Error: there was an error with removing a tutor, try again later";
				request.setAttribute("message", message);
				RequestDispatcher rd =  request.getRequestDispatcher("DepartMessage.jsp"); 
				rd.forward(request, response);
			}

	}
		}
	}
	
	
