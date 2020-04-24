import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ApplicationModel.Classroom;
import ApplicationModel.Courses;
import ApplicationModel.Feedback;
import ApplicationModel.Session_Detail;
import ApplicationModel.Tutor;
import ApplicationModel.User;
import oracle.net.aso.o;


@WebServlet("/TutorServlet")
public class TutorServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    Tutor tutor= new Tutor();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TutorServlet() {
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
		if (null != request.getParameter("create_button")) {
			
			System.out.print(tutor.getUser_ID());
			ArrayList<Courses> listCourse = tutor.getCoursesTaughtByTutor(tutor.getUser_ID());
			for (int i = 0; i < listCourse.size(); i++) {
				System.out.println(listCourse.get(i).getCOURSE_NAME());
			}
			
			ArrayList<Classroom> listclassrooms = Tutor.getAUSclassrooms();
			
			
			request.setAttribute("course", listCourse); 
			request.setAttribute("classroom", listclassrooms);
			
			RequestDispatcher rd =  request.getRequestDispatcher("Create a session.jsp"); 
			
			rd.forward(request, response);
			
		//	response.sendRedirect("Create a session.jsp");
		} 
		else if (null != request.getParameter("scancel_button")) {
			Boolean upcoming = true; //as only an upcoming session will be available to cancel
			
			System.out.print(tutor.getUser_ID());
			ArrayList<Session_Detail> listSession = tutor.getSessionsofTutor(tutor.getUser_ID(), upcoming);
			for (int i = 0; i < listSession.size(); i++) {
				System.out.println(listSession.get(i).getSession_ID());
			}
			
			request.setAttribute("session", listSession);
			RequestDispatcher rd = request.getRequestDispatcher("Cancel_Session.jsp");
			rd.forward(request, response);


		// response.sendRedirect("Cancel a session.jsp");
		} 
		else if (null != request.getParameter("feedback_button")) {
			
			ArrayList<Feedback> feedbacks = tutor.retreiveFeedbacksforTutor(tutor.getUser_ID());
			request.setAttribute("feedback", feedbacks);
			RequestDispatcher rd = request.getRequestDispatcher("View_Feedback.jsp");
			rd.forward(request, response);
		}
		else if (null != request.getParameter("dsession_button")) {
			
			ArrayList<Session_Detail> listSessions = tutor.getSessionsofTutor(tutor.getUser_ID(), true);
			request.setAttribute("session", listSessions); 
			RequestDispatcher rd =  request.getRequestDispatcher("Display_Session.jsp"); 
			rd.forward(request, response);
		}
	}
	
	public ArrayList<String> timining() {
		ArrayList<String> time = new ArrayList<String>();

		for (int i = 7; i < 11; i++) {
			time.add("0"+i+":00 am");
		}
		time.add("12:00 pm");
		for (int i = 1; i < 11; i++) {
			time.add("0"+i+":00 pm");
		}
		
		return time;
	}
}
