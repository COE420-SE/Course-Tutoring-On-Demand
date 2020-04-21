
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class StudentFilter
 */
@WebFilter("/*")
public class DeptAdminFilter implements Filter {
    private HttpServletRequest httpRequest;
 
    private static final String[] loginRequiredURLs = {
            "/DepartmentAdmin.html", "/AddFaculty.jsp", "/Choose_Application.jsp"
            
            //add approve/reject.jsp, //getfeedback.jsp //deletetutor.jsp
    };
 
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        httpRequest = (HttpServletRequest) request;
 
 
        HttpSession session = httpRequest.getSession(false);
 
        boolean isLoggedIn = (session != null && (session.getAttribute("type") == "department"));
 
        if (isLoggedIn) {
        	 chain.doFilter(request, response);
 
        } else if (isLoginRequired()) {
            // the user is not logged in, and the requested page requires
            // authentication, then forward to the login page
            RequestDispatcher dispatcher = httpRequest.getRequestDispatcher("login.html");
            dispatcher.forward(request, response);
        } 
        else  chain.doFilter(request, response);
    }
 
 
    private boolean isLoginRequired() {
        String requestURL = httpRequest.getRequestURL().toString();
 
        for (String loginRequiredURL : loginRequiredURLs) {
            if (requestURL.contains(loginRequiredURL)) {
                return true;
            }
        }
 
        return false;
    }
 
    public DeptAdminFilter() {
		// TODO Auto-generated constructor stub
	}
 
    public void destroy() {
    }
 
    public void init(FilterConfig fConfig) throws ServletException {
    }
}