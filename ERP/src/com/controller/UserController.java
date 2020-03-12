package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.model.Products;
import com.model.User;

/**
 * Servlet implementation class UserController
 */
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UserController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
	
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sess = request.getSession();
		String u_name=request.getParameter("u_name");
		String u_gender=request.getParameter("u_gender");
		String u_dob=request.getParameter("u_dob");
		String u_email=request.getParameter("u_email");
		String u_password=request.getParameter("u_password");
		sess.setAttribute("email", u_email);
		sess.setAttribute("password", u_password);
		User u = new User();
		u.setU_name(u_name);
		u.setU_dob(u_dob);
		u.setU_email(u_email);
		u.setU_gender(u_gender);
		u.setU_password(u_password);
		
		UserDao ud = new UserDao();
		String str = ud.insertUser(u);
		if(str.equals("user inserted")) {
			request.getRequestDispatcher("DashBoardShow").forward(request, response);
		}
		
		
		doGet(request, response);
	}

}
