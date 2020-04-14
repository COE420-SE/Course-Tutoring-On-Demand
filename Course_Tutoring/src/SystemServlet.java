import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ApplicationModel.Department;
import ApplicationModel.Department_Admin;
import ApplicationModel.System_Admin;
import ApplicationModel.User;

@WebServlet("/SystemServlet")
public class SystemServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	System_Admin system_Admin = new System_Admin();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SystemServlet() {
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
		if (null != request.getParameter("add_dept_button")) {
			
			System.out.print(system_Admin.getUser_name());
			ArrayList<Department> listDept = User.getAUSdepartments();
			
	
			request.setAttribute("department", listDept); 
			
			RequestDispatcher rd =  request.getRequestDispatcher("AddDepart.jsp"); 
			rd.forward(request, response);
			

	}
		}

}