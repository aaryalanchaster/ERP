package com.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.w3c.dom.html.HTMLParagraphElement;

import com.dao.Logindao;
import com.model.Admin;

/**
 * Servlet implementation class AdminShowController
 */
public class AdminShowController extends HttpServlet {
	private static final long serialVersionUID = 1L;

		
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminShowController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	/*
		String email = request.getParameter("email");
		String password = request.getParameter("password");*/
		/*HttpSession sess=request.getSession();
		sess.setAttribute("email", email);
		sess.setAttribute("pwd", password);*/
		
		
		HttpSession sess = request.getSession();
		String email = (String)sess.getAttribute("email");
		String pwd = (String)sess.getAttribute("pwd");
		Logindao ld = new Logindao();
		List<Admin> list= ld.showProfile(email, pwd);
	/*	response.setContentType("image/jpg");
		OutputStream o = response.getOutputStream();
		byte [] b=null;
		for(Admin a: list) {
			b=a.getImg();
		}*/
	/*	o.write(b); 
		o.flush();*/
		
		if(sess.getAttribute("pwd")!=null)
		{
		request.setAttribute("data", list);
		request.getRequestDispatcher("profile.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			HttpSession sess = request.getSession();
			int id = (Integer) sess.getAttribute("adminID");
			Admin a = new Admin();
			a.setName(request.getParameter("name"));
			a.setEmail(request.getParameter("email"));
			sess.setAttribute("email", request.getParameter("email"));
			a.setPassword(request.getParameter("password"));
			sess.setAttribute("pwd", request.getParameter("password"));
			a.setDob(request.getParameter("date"));
			a.setGender(request.getParameter("gender"));
			a.setId(id);
			Logindao ld = new Logindao();
			String str=ld.adminUpdate(a);
			if(str.equals("updated"))
			{
				doGet(request, response);
				//request.getRequestDispatcher("AdminShowController").forward(request, response);
			}
		
		
	}

}
