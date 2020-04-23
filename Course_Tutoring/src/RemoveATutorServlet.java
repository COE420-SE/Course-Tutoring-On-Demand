import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ApplicationModel.Tutor;
import ApplicationModel.Department_Admin;

/**
 * Servlet implementation class RemoveATutorServlet
 */
@WebServlet("/RemoveATutorServlet")
public class RemoveATutorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Department_Admin depart_Admin = new Department_Admin();
	Tutor tutor = new Tutor();
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveATutorServlet() {
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
		if (null != request.getParameter("submit")) {
			String tutor_id = request.getParameter("tutor");
			System.out.println(tutor_id);

			Boolean success = depart_Admin.removeTutor(tutor_id);
			if (success) {
				RequestDispatcher rd = request.getRequestDispatcher("RemoveATutorSuccessful.jsp");
				rd.forward(request, response);
			}
			else
				response.sendRedirect("error_action.html");
		}

	}
	
	
}
