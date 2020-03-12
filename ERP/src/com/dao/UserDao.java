package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Products;
import com.model.User;
import com.util.Db_conn;

public class UserDao {
	Connection con;
	Db_conn Db= new Db_conn();
	
	
	public String updateUser(User u) {
		try {
			con=Db.gConnection();
			PreparedStatement psmt = con.prepareStatement("update user_table set u_name=?,u_dob=?,u_email=?,u_password=?,u_gender=? where u_id=?");
			psmt.setString(1, u.getU_name());
			psmt.setString(2, u.getU_dob());
			psmt.setString(3, u.getU_email());
			psmt.setString(4, u.getU_password());
			psmt.setString(5, u.getU_gender());
			psmt.setInt(6, u.getU_id());
			int i = psmt.executeUpdate();
			 
			if(i>0)
			{
	
				return "updated";
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	public List<User> showProfile(String email,String password){
		try {
			con=Db.gConnection();
			PreparedStatement psmt = con.prepareStatement("select * from user_table where u_email=? and u_password=?");
			psmt.setString(1, email);
			psmt.setString(2, password);
			ArrayList<User> al = new ArrayList<User>();
			ResultSet rs = psmt.executeQuery();
			User u=null;
			while(rs.next()) {
				u=new User();
				u.setU_email(rs.getString("u_email"));
				u.setU_name(rs.getString("u_name"));
				u.setU_dob(rs.getString("u_dob"));
				u.setU_gender(rs.getString("u_gender"));
				u.setU_password(rs.getString("u_password"));
				al.add(u);
			}
			return al;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public String insertUser(User u) {
		try {
			con=Db.gConnection();
			PreparedStatement psmt = con.prepareStatement("insert into user_table (u_name,u_gender,u_dob,u_password,u_email) values(?,?,?,?,?)");
			psmt.setString(1, u.getU_name());
			psmt.setString(2, u.getU_gender());
			psmt.setString(3, u.getU_dob());
			psmt.setString(4, u.getU_password());
			psmt.setString(5, u.getU_email());
			int i =psmt.executeUpdate();
			if(i>0) {
				return "user inserted" ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
		
	}
	
	public User fetch(String email,String password) {
		try {
			con=Db.gConnection();
			PreparedStatement psmt = con.prepareStatement("select * from user_table where u_email=? and u_password=? ");
			psmt.setString(1, email);
			psmt.setString(2, password);
			ResultSet rs = psmt.executeQuery();
			User u = null;
			while(rs.next()) {
				u=new User();
				u.setU_email(rs.getString("u_email"));
				u.setU_password(rs.getString("u_password"));
				u.setU_id(rs.getInt("u_id"));
			}
			return u;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		
		
		return null;
		
	}
	
	public ArrayList<Products> showProduct()
	{
		
		try {
			con =Db.gConnection();
			PreparedStatement psmt = con.prepareStatement("select * from product_table");
			ResultSet rs = psmt.executeQuery();
			ArrayList<Products> al = new ArrayList<Products>();
			Products p = null;
			while(rs.next())
			{
				p = new Products();
				p.setP_desc(rs.getString("p_desc"));
				p.setP_name(rs.getString("p_name"));
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
	

}
