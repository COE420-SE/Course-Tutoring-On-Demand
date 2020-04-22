
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
import ApplicationModel.Feedback;
import ApplicationModel.Student;
import ApplicationModel.Tutor;
import ApplicationModel.User;
import JDBC.Feedback_Table;
import ApplicationModel.Session_Detail;


@WebServlet("/GiveFeedbackServlet")
public class GiveFeedbackServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	Student student = new Student();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GiveFeedbackServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
			String tutor = request.getParameter("tutor");
			String comments = request.getParameter("comments");
			String send_tutor = request.getParameter("yes_no");
			
			Feedback feed = new Feedback(student.getUser_ID(), tutor, comments, send_tutor);
			
			if(student.givefeedback(feed)) {

				String message = "Success: Feedback for tutor #"+tutor+" has been succesfully recorded";
				request.setAttribute("message", message);
				RequestDispatcher rd;
				if(User.getUser_type().equals("student"))
					rd =  request.getRequestDispatcher("StudentMessage.jsp"); 
					else {
					 rd =  request.getRequestDispatcher("TutorMessage.jsp"); 
					}
					rd.forward(request, response);
				}
				else {
					String message = "Error: An error occured while giving feedback, Try again later";
					request.setAttribute("message", message);
					RequestDispatcher rd;
					if(User.getUser_type().equals("student"))
						rd =  request.getRequestDispatcher("StudentMessage.jsp"); 
						else {
						 rd =  request.getRequestDispatcher("TutorMessage.jsp"); 
						}
						rd.forward(request, response);
					rd.forward(request, response);
				}
			}
			
	}


