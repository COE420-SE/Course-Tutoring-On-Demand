
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ApplicationModel.Student;

/**
 * Servlet implementation class CancelBookingServlet
 */
@WebServlet("/CancelBookingServlet")
public class CancelBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Student student = new Student();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelBookingServlet() {
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
    	
			Boolean success = student.cancelBooking(session_id);
			if (success) {
				RequestDispatcher rd = request.getRequestDispatcher("CancelBookingSuccessful.jsp");
				rd.forward(request, response);
			}
			else
				response.sendRedirect("error_action.html");
		}
	}
}
