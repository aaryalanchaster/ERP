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

public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ProductController() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		HttpSession sess = request.getSession();
		
		Datadao dao = new Datadao();
		String id = request.getParameter("productID");
//		int Id = Integer.parseInt(id);
//		System.out.println(Id);
		ArrayList<Manager> list = dao.show(Integer.parseInt(id));

		if(sess.getAttribute("pwd")!=null)
		{
			request.setAttribute("productshow", list);
			request.getRequestDispatcher("updateProduct.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sess = request.getSession();
		sess.setAttribute("pid", request.getParameter("id"));
		Datadao dao = new Datadao();
		Manager m = new Manager();
		m.setP_name(request.getParameter("name"));
		m.setP_desc(request.getParameter("desc"));
		m.setPrice(Double.parseDouble(request.getParameter("price")));
		m.setM_desig(request.getParameter("mdesig"));
		m.setM_name(request.getParameter("mname"));
		String productUpdate = dao.updateProduct(m);
		String managerUpdate = dao.updateManager(m);
		
		if(productUpdate.equals("updated") && managerUpdate.equals("updated"))
			request.getRequestDispatcher("ManageController").forward(request, response);
			//doGet(request, response);
	}

}
