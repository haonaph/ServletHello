package com.servlet.hi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.UserDAO;
import com.enpyty.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		this.userDAO = new UserDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        String view ="/view/auth/Login.jsp";
        request.setAttribute("view", view);
		request.getRequestDispatcher("/view/layout.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		User entipy = this.userDAO.login(email, password);
		if (entipy == null) {
			response.sendRedirect(request.getContextPath() + "/Login");
		} else {
			HttpSession session =request.getSession();
			session.setAttribute("user", entipy);
			
			response.sendRedirect(request.getContextPath() + "/admin/users");
		}
	}

}
