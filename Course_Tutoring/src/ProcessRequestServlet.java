import java.io.IOException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ApplicationModel.Department_Admin;
import ApplicationModel.Session_Detail;
import ApplicationModel.System_Admin;
import ApplicationModel.Tutor;


/**
 * Servlet implementation class CreateSessionServlet
 */
@WebServlet("/AddDepartServlet")
public class ProcessRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Department_Admin dept_Admin = new Department_Admin();
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProcessRequestServlet() {
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
		
			String tutor_id = request.getParameter("tutor_id");
			System.out.println(tutor_id);
			ArrayList<Tutor_Application> listapp = dept_Admin.gettutorrequestbyid(tutor_id);
			request.setAttribute("applications", listapp); 
			RequestDispatcher rd =  request.getRequestDispatcher("Process_Application.jsp"); 
			rd.forward(request, response);
	}
				 

	//}
	}
	
	
}



