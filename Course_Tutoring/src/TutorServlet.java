import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ApplicationModel.Courses;
import ApplicationModel.Tutor;
import oracle.net.aso.o;


@WebServlet("/TutorServlet")
public class TutorServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    Tutor tutor= new Tutor();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TutorServlet() {
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
		if (null != request.getParameter("create_button")) {
			tutor.initializeAUSCourses();
			
			ArrayList<Courses> course = tutor.getAUScourses();
		
			request.setAttribute("course", course);
			RequestDispatcher rd =  request.getRequestDispatcher("Create a session.jsp"); 
			
			for (int i = 0; i < course.size(); i++) {
				System.out.println("hi");
			}
			
			rd.forward(request, response);
		} 
		else if (null != request.getParameter("scancel_button")) {
			
		} 
		else if (null != request.getParameter("vfeedback_button")) {
			
		}
		else if (null != request.getParameter("notify_button")) {
			
		}
	}
}
