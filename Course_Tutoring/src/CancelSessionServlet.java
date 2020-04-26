

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ApplicationModel.Tutor;

/**
 * Servlet implementation class CancelSessionServlet
 */
@WebServlet("/CancelSessionServlet")
public class CancelSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Tutor tutor = new Tutor();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelSessionServlet() {
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
		
		if (null != request.getParameter("submit_button")) {
			String session_id = request.getParameter("session");
			System.out.println(session_id);

			Boolean success = tutor.cancelSession(session_id);
			if (success) {
				
				//insert notification
				ArrayList<String> student_id = tutor.getAllStudentIDsOfSession(session_id);
				
				for (String string : student_id) {
					tutor.insertNotification(tutor.getUser_ID(), string, tutor.getUser_name()+" cancelled session #"+session_id);

				}
				
				//redirect to success page
					String message = "Session #"+session_id+" has been cancelled successfully";
					request.setAttribute("message", message);
					RequestDispatcher rd =  request.getRequestDispatcher("TutorMessage.jsp"); 
					rd.forward(request, response);}
					
				}
			else {
				String message = "There has been an error with cancelling the session. Try again later";
				request.setAttribute("message", message);
				RequestDispatcher rd =  request.getRequestDispatcher("TutorMessage.jsp"); 
				rd.forward(request, response);
			}
	}
}
