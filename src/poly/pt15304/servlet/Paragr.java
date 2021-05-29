package poly.pt15304.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Paragr
 */
@WebServlet("/paragr")
public class Paragr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/view/paragr/form.jsp").forward(request, response);
	}

@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String hoten=request.getParameter("Hoten");
		request.setAttribute("message",hoten);
		request.getRequestDispatcher("/view/paragr/acon.jsp").forward(request, response);
	}

}
