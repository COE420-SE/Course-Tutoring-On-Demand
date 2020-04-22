
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ApplicationModel.Student;
import ApplicationModel.User;

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
    	
			Boolean success = student.CancelABooking(session_id);
			if (success) {
				
				String message = "Success: "+student.getUser_name()+" is succesfully dropped from session #"+session_id;
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
					String message = "Error: An error occured while cancelling booking, Try again later";
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
	}
