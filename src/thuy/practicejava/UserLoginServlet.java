package thuy.practicejava;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserLoginServlet() {
		super();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//doPost(request, response);
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserDAO userDao = new UserDAO();
		
		try {
			User user = userDao.checkLogin(email, password);
			String destPage = "login.jsp";
			
			if (user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				destPage = "home.jsp";
			} else {
				String message = "Invalid email/password";
				request.setAttribute("message", message);
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
			dispatcher.forward(request, response);
			
		} catch (SQLException | ClassNotFoundException ex) {
			throw new ServletException(ex);
		}
	}

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
	
}
