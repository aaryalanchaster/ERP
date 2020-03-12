package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.model.User;

/**
 * Servlet implementation class UserShowController
 */
public class UserShowController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserShowController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession sess = request.getSession();
		String email = (String)sess.getAttribute("email");
		String pwd = (String)sess.getAttribute("password");
		UserDao ud = new UserDao();
		List<User> list = ud.showProfile(email, pwd);
		
		if(sess.getAttribute("password")!=null)
		{
			request.setAttribute("data", list);
			request.getRequestDispatcher("uprofile.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("uregister.jsp").forward(request, response);
		}
			

	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sess = request.getSession();
		int id = (Integer) sess.getAttribute("userID");
		System.out.println("showcontroller: "+id);
		User u = new User();
		u.setU_name(request.getParameter("name"));
		u.setU_dob(request.getParameter("date"));
		u.setU_email(request.getParameter("email"));
		sess.setAttribute("email", request.getParameter("email"));
		u.setU_password(request.getParameter("password"));
		sess.setAttribute("password", request.getParameter("password"));
		u.setU_gender(request.getParameter("gender"));
		u.setU_id(id);
		
		UserDao ud = new UserDao();
		String str = ud.updateUser(u);
	
		if(str.equals("updated"))
		{
			doGet(request, response);
		}
		
		
	
	}

}
