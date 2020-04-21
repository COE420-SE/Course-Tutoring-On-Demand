import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ApplicationModel.Student;


@WebServlet("/GiveFeedbackServlet")
public class GiveFeedbackServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	Student stud;
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (null != request.getParameter("next")) {
			String[] sessions = request.getParameterValues("session");
			ArrayList<String> SessionChosen = new ArrayList<String>();
			for (int i = 0; i < sessions.length; i++) {
				SessionChosen.add((String) sessions[i]);
			}
			for (int i = 0; i < SessionChosen.size(); i++) {
				System.out.println(SessionChosen.get(i));
			}

			request.setAttribute("session_list", SessionChosen);
			RequestDispatcher rd =  request.getRequestDispatcher("FeedbackForm.jsp"); 
			rd.forward(request, response);
		}
		else {
			String[] comment = request.getParameterValues("comment");
			for (int i = 0; i < comment.length; i++) {
				System.out.println(comment[i]);
			}
			//add the comment
			response.sendRedirect("FeedbackSentSuccessfully.jsp");
		}

	}
	
}

