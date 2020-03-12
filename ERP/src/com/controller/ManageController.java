package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Datadao;
import com.model.Manager;
import com.model.Products;

/**
 * Servlet implementation class ManageController
 */
public class ManageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManageController() {
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
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		Datadao dao = new Datadao();
		ArrayList<Manager> list = dao.showAll();
		HttpSession sess = request.getSession();
		
		if(sess.getAttribute("pwd")!=null)
		{
		request.setAttribute("show", list);
		request.getRequestDispatcher("manage.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int p_id = Integer.parseInt(request.getParameter("p_id"));
		String p_name = request.getParameter("p_name");
		String p_desc = request.getParameter("p_desc");
		double price = Double.parseDouble(request.getParameter("price"));
		String m_name = request.getParameter("m_name");
		String m_desig = request.getParameter("m_desig");
		Products p = new Products();
		p.setP_desc(p_desc);
		p.setP_name(p_name);
		p.setPrice(price);
		p.setP_id(p_id);

		Manager m = new Manager();
		m.setM_name(m_name);
		m.setM_desig(m_desig);
		m.setP_id(p_id);

		Datadao db = new Datadao();
		String s = db.insertProduct(p);
		String s1 = db.insertManager(m);
		if (s.equals("product inserted") && s1.equals("manager inserted")) {
			// request.getRequestDispatcher("manage.jsp").forward(request, response);
			doGet(request, response);
		}

	}

}
