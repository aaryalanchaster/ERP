package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Admin;
import com.model.Manager;
import com.model.Products;
import com.util.Db_conn;

public class Datadao {
	Connection con;
	Db_conn db = new Db_conn();

	public String insertProduct(Products p) {
		try {
			con = db.gConnection();
			PreparedStatement psmt = con.prepareStatement("insert into product_table (p_id,p_name,p_desc,price) values(?,?,?,?)");
			psmt.setInt(1, p.getP_id());
			psmt.setString(2, p.getP_name());
			psmt.setString(3, p.getP_desc());
			psmt.setDouble(4, p.getPrice());

			int i = psmt.executeUpdate();
			if (i > 0) {
				return "product inserted";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String insertManager(Manager m) {
		try {
			con = db.gConnection();
			PreparedStatement psmt = con.prepareStatement("insert into manager_table (m_name,m_desig,p_id) values(?,?,?)");
			psmt.setString(1, m.getM_name());
			psmt.setString(2, m.getM_desig());
			psmt.setInt(3, m.getP_id());
			int i = psmt.executeUpdate();
			if (i > 0) {
				return "manager inserted";

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public List<Products> getProducts() {

		try {
			con = db.gConnection();
			PreparedStatement psmt = con.prepareStatement("select * from product_table");

			ArrayList<Products> al = new ArrayList<Products>();
			ResultSet rs = psmt.executeQuery();

			Products p = null;

			while (rs.next()) {
				p = new Products();
				p.setP_id(rs.getInt("p_id"));
				p.setP_name(rs.getString("p_name"));
				p.setP_desc(rs.getString("p_desc"));
				p.setPrice(rs.getDouble("price"));
				al.add(p);

			}
			return al;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}
	
	
	public Manager showManager(int p_id) {
		try {
			con = db.gConnection();
			PreparedStatement psmt = con.prepareStatement("select * from manager_table where p_id=?");
			psmt.setInt(1, p_id);
			ResultSet rs = psmt.executeQuery();
			Manager m = null;
			while(rs.next()) {
				m = new Manager();
				m.setP_id(rs.getInt("p_id"));
				m.setM_name(rs.getString("m_name"));
				m.setM_desig(rs.getString("m_desc"));
			}
			
			return m;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public ArrayList<Manager> showAll()
	{
		try {
			con= db.gConnection();
			PreparedStatement psmt = con.prepareStatement("select p.p_id, p.p_name, p.p_desc, p.price, m.m_name, m.m_desig from product_table as p, manager_table as m where m.p_id=p.p_id");
			//psmt.setInt(1, p_id);
			ResultSet rs = psmt.executeQuery();
			ArrayList<Manager> al = new ArrayList<Manager>();
			Manager m = null;
			while(rs.next())
			{
				m = new Manager();
				m.setP_id(rs.getInt("p_id"));
				m.setP_name(rs.getString("p_name"));
				m.setP_desc(rs.getString("p_desc"));
				m.setPrice(rs.getDouble("price"));
				m.setM_name(rs.getString("m_name"));
				m.setM_desig(rs.getString("m_desig"));
				/*p.setP_id(rs.getInt("p_id"));
				p.setP_name(rs.getString("p_name"));
				p.setP_desc(rs.getString("p_desc"));
				p.setPrice(rs.getInt("p_price"));
				m.setM_name(rs.getString("m_name"));
				m.setM_desig(rs.getString("m_desig"));
				al.add(p);*/
				al.add(m);				
			}
			
			return al;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public ArrayList<Manager> show(int id)
	{
		try {
			con= db.gConnection();
			System.out.println(id);
			PreparedStatement psmt = con.prepareStatement("select p.p_id, p.p_name, p.p_desc, p.price, m.m_name, m.m_desig from product_table as p, manager_table as m where m.p_id=p.p_id and p.p_id=?");
			psmt.setInt(1, id);
			ResultSet rs = psmt.executeQuery();
			ArrayList<Manager> al = new ArrayList<Manager>();
			Manager m = null;
			while(rs.next())
			{
				m = new Manager();
				m.setP_id(rs.getInt("p_id"));
				m.setP_name(rs.getString("p_name"));
				m.setP_desc(rs.getString("p_desc"));
				m.setPrice(rs.getDouble("price"));
				m.setM_name(rs.getString("m_name"));
				m.setM_desig(rs.getString("m_desig"));
				al.add(m);				
			}
			
			return al;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public String updateProduct(Manager m)
	{
		try {
			con = db.gConnection();
			PreparedStatement psmt = con.prepareStatement("update product_table set p_name=?, p_desc=?, price=? where p_id=?");
			psmt.setString(1, m.getP_name());
			psmt.setString(2, m.getP_desc());
			psmt.setDouble(3, m.getPrice());
			psmt.setInt(4, m.getP_id());
			
			int i = psmt.executeUpdate();
			
			if(i>0)
				return"updated";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
/*	public int getPID(String name)
	{
		try {
			con = db.gConnection();
			PreparedStatement psmt = con.prepareStatement("select p_id from product_table where p_name=?");
			psmt.setString(1, name);
			
			ResultSet rs = psmt.executeQuery();
			Products 
			while(rs.next())
			{
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}*/
	
	public String updateManager(Manager m)
	{
		try {
			con = db.gConnection();
			PreparedStatement psmt = con.prepareStatement("update manager_table set m_name=?, m_desig=? where p_id=?");
			psmt.setString(1, m.getM_name());
			psmt.setString(2, m.getM_desig());
			psmt.setInt(3, m.getP_id());
			
			int i = psmt.executeUpdate();
			
			if(i>0)
				return "updated";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
}
