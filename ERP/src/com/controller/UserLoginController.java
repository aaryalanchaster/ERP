package com.controller;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.model.User;

/**
 * Servlet implementation class UserLoginController
 */
public class UserLoginController extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession sess = request.getSession();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User u = new User();
		UserDao ud = new UserDao();
		u = ud.fetch(email, password);
		if(u!=null)
		{
			int id= u.getU_id();
			sess.setAttribute("userID", id);
			sess.setAttribute("email", email);
			sess.setAttribute("password", password);
			request.getRequestDispatcher("DashBoardShow").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("uregister.jsp").forward(request, response);
		}		
		
		doGet(request, response);
	}

}
