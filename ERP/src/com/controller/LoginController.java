package com.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InterruptedNamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Datadao;
import com.dao.Logindao;
import com.model.Admin;
import com.model.Manager;
import com.model.Products;

/**
 * Servlet implementation class LoginConroller
 */
public class LoginController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession sess = request.getSession();
		if(sess.getAttribute("pwd")!=null)
		{
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated met		
		HttpSession sess=request.getSession();
		
		
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			Admin a=new Admin();
			/*a.setEmail("email");
			a.setPassword("pwd");*/
			Logindao ld = new Logindao();
			a = ld.fetch(email,password);		
			if(a!=null)
			{		
				int id = a.getId();
				sess.setAttribute("email", email);
				sess.setAttribute("pwd", password);
				sess.setAttribute("adminID", id);
				request.getRequestDispatcher("dashboard.jsp").forward(request, response);
			}
			else
			{
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		
			doGet(request, response);
		
		
		
	}	

}
