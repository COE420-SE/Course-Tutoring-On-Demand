
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
@WebServlet("/BeTutorServlet")
public class BeTutorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Student studentModel = new Student();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BeTutorServlet() {
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
		if (null != request.getParameter("next")) {
			String[] course = request.getParameterValues("courses");
			ArrayList<String> CourseChosen = new ArrayList<String>();
			for (int i = 0; i < course.length; i++) {
				CourseChosen.add((String) course[i]);
			}
			for (int i = 0; i < CourseChosen.size(); i++) {
				System.out.println(CourseChosen.get(i));
			}
			//add the courses to tutorcourse table (dhriti)
			request.setAttribute("course_list", CourseChosen);
			RequestDispatcher rd =  request.getRequestDispatcher("Apply_Tutor_Grade.jsp"); 
			rd.forward(request, response);
		}
		// TODO Auto-generated method stub
		else {
			String[] grades = request.getParameterValues("grades");
			for (int i = 0; i < grades.length; i++) {
				System.out.println(grades[i]);
			}
			String AcademicStanding = request.getParameter("standing");
			//add the grades and acadamic standing 
			studentModel.setApply_for_tutor(true);
			response.sendRedirect("TutorRequestSuccessful.jsp");
		}
	}
}
