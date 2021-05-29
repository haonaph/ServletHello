package com.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.Dao.UserDAO;
import com.enpyty.User;


@WebServlet("/admin/users/update")
public class UpdateUserServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;

	public UpdateUserServlet() {
		super();
		this.userDAO = new UserDAO();
	
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(req.getParameter("id"));
		User entipy = this.userDAO.findbyid(id);
		req.setAttribute("user", entipy);

        String view ="/view/admin/users/Update.jsp";
        req.setAttribute("view", view);
		req.getRequestDispatcher("/view/layout.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User entipy = new User();
		entipy.setStatus(1);
		try {
			BeanUtils.populate(entipy, req.getParameterMap());
			System.out.println("Th�nh c�ng.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.userDAO.update(entipy);
	
        resp.sendRedirect(req.getContextPath() + "/admin/users"); 
	}

}
