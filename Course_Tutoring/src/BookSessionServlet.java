
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.events.EndDocument;



import ApplicationModel.Courses;
import ApplicationModel.Session_Detail;
import ApplicationModel.Student;
import ApplicationModel.Tutor;
import ApplicationModel.User;

/**
 * Servlet implementation class CreateSessionServlet
 */
@WebServlet("/BookSessionServlet")
public class BookSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Student student = new Student();
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookSessionServlet() {
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
	
			String session_id = request.getParameter("session");
			
			if(student.BookASession(session_id)) {
				String message = "Success: "+student.getUser_name()+" succesfully booked session "+session_id;
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
				String message = "Error: An error occured while booking, Try again later";
				request.setAttribute("message", message);
				RequestDispatcher rd;
				if(User.getUser_type().equals("student"))
					rd =  request.getRequestDispatcher("StudentMessage.jsp"); 
					else {
					 rd =  request.getRequestDispatcher("TutorMessage.jsp"); 
					}
					rd.forward(request, response);
			}
			
	}
}



