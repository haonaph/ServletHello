package poly.pt15304.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/home/Index")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String params=request.getParameter("name");
		String name = params ==null ?"Alo alo": params;
		System.out.println("___1___" +request.getParameter("name"));
		request.setAttribute("message", name);
		request.getRequestDispatcher("//Index.jsp").forward(request, response);
	}



}
