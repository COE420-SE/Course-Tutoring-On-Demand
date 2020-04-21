
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


@WebServlet("/GiveFeedbackServlet")
public class GiveFeedbackServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
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
		
		if (null != request.getParameter("next")) {
			String[] session_id = request.getParameterValues("session");
			ArrayList<String> SessionChosen = new ArrayList<String>();
			
			for (int i = 0; i < session_id.length; i++) {
				SessionChosen.add((String) session_id[i]);
			}
			for (int i = 0; i < SessionChosen.size(); i++) {
				System.out.println(SessionChosen.get(i));
			}
			
			System.out.println(SessionChosen);
			
			// add the sessions to the studentsession table (dhriti)
			request.setAttribute("session_list", SessionChosen);
			RequestDispatcher rd =  request.getRequestDispatcher("FeedbackForm.jsp"); 
			rd.forward(request, response);
		}
		else {
			String comment = request.getParameter("comment");
			System.out.println(comment);
			//add the comment
			response.sendRedirect("FeedbackSentSuccessfully.jsp");
		}

	}
	
}

