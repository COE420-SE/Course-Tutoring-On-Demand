
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
			String comments = request.getParameter("tutor");
			String send_tutor = request.getParameter("tutor");
			
			Feedback feed = new Feedback(student.getUser_ID(), tutor, comments, send_tutor);
			
			String comment = request.getParameter("comment");
			System.out.println(comment);
			//add the comment
			response.sendRedirect("FeedbackSentSuccessfully.jsp");

	}
	
}

