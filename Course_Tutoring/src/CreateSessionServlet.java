
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
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
@WebServlet("/CreateSessionServlet")
public class CreateSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Tutor tutor = new Tutor();
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateSessionServlet() {
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
		
		if (null != request.getParameter("submit_button")) {
			String course_name = request.getParameter("courses");
			String classroom_id = request.getParameter("classroom");
			String date = convertDate(request.getParameter("date"));
			String Start = convertTime(request.getParameter("start_time"));
			String End = convertTime(request.getParameter("end_time"));
			String Max_seats = request.getParameter("seats");
			System.out.println(course_name);
			System.out.println(classroom_id);
			System.out.println(date);
			System.out.println(Start);
			System.out.println(End);
			System.out.println(Max_seats);
		
			//make a instance of session detail
			Session_Detail newSession_Detail = new Session_Detail(course_name, classroom_id, date, Start, End, Max_seats);
			
			//get session from database if exist then error
			if (tutor.checkIFSessionExists(date)) {
				String message = "Error: You have another section on that day, Try again on another dat";
				request.setAttribute("message", message);
				RequestDispatcher rd;
					rd =  request.getRequestDispatcher("TutorMessage.jsp"); 
					rd.forward(request, response);
			}
			
			Boolean success = tutor.createSession(newSession_Detail);
			
			if (success) {

				String message = "Success: Session on "+date+" has been succesfully created";
				request.setAttribute("message", message);
				RequestDispatcher rd;
					 rd =  request.getRequestDispatcher("TutorMessage.jsp"); 
					rd.forward(request, response);
				}
				else {
					String message = "Error: An error occured while creating, Try again later";
					request.setAttribute("message", message);
					RequestDispatcher rd;
						 rd =  request.getRequestDispatcher("TutorMessage.jsp"); 
						rd.forward(request, response);
				}
			
			}
			
		}
	
			
	
	public String convertDate(String date) {

	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MMM-yy");
	    String newDate = LocalDate.parse(date, formatter).format(formatter2);
	    
	    return newDate;
	}
	
	public String convertTime(String time) {

		String input = time;
	       //Date/time pattern of input date
	       DateFormat df = new SimpleDateFormat("HH:mm");
	       //Date/time pattern of desired output date
	       DateFormat outputformat = new SimpleDateFormat("hh:mm aa");
	       java.util.Date date = null;
	       String output = null;
	       
	          //Conversion of input String to date
	    	  try {
				date= df.parse(input);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	          //old date format to new date format
	    	  output = outputformat.format(date);
	    	  return output;
	    	  }
}



