package com.dao;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.model.Admin;
import com.model.User;
import com.util.Db_conn;

public class Logindao {
	
	Connection con;
	Db_conn db = new Db_conn();
	

	public Admin fetch(String email,String password)
	{
		try {
			con=db.gConnection();
			PreparedStatement psmt=con.prepareStatement("select * from admin_table where a_email = ? and a_password=?");
			psmt.setString(1, email);
			psmt.setString(2, password);
			
			ResultSet rs = psmt.executeQuery();
			Admin a=null;
			while(rs.next())
			{
				a=new Admin();
				a.setEmail(rs.getString("a_email"));
				a.setPassword(rs.getString("a_password"));
				a.setId(rs.getInt("admin_id"));
				
			}
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
	
	public List<Admin> showProfile(String email, String password)
	{
		
		PreparedStatement psmt;
		try {
			con=db.gConnection();
//			Statement stmt= con.createStatement();
//			ResultSet rs=stmt.executeQuery("select * from admin_table where a_email = ? and a_password=?");
			
			
			psmt = con.prepareStatement("select * from admin_table where a_email = ? and a_password=?");
			psmt.setString(1, email);
			psmt.setString(2, password);
			ArrayList<Admin> al = new ArrayList<Admin>();
			ResultSet rs = psmt.executeQuery();		
			Admin a=null;
			byte[] imgdata = null;
			Blob b = null;
			while(rs.next())
			{
				a=new Admin();
				a.setEmail(rs.getString("a_email"));
				a.setPassword(rs.getString("a_password"));
				a.setGender(rs.getString("a_gender"));
				a.setDob(rs.getString("a_dob"));
				a.setName(rs.getString("a_name"));
				/*a.setProfile(rs.getBlob("a_profilepic"));
				b=rs.getBlob("a_profilepic");
				imgdata = b.getBytes(7, (int )b.length());
				a.setImg(imgdata);
				*/
//				Blob blob = rs.getBlob("a_profilepic");
//				InputStream inputstream = rs.getBinaryStream(5);
//				FileOutputStream fos;
//				try {
//					fos = new FileOutputStream("profile.jpg");
//					int i = inputstream.read();
//					while(i!=-1)
//					{
//						fos.write(i);
//						i=inputstream.read();
//					}
//				} catch (FileNotFoundException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				
//				ByteArrayOutputStream outputstream = new ByteArrayOutputStream();
//				byte[] buffer = new byte[4096];
//				int bytesRead = -1;
//				
//				try {
//					while((bytesRead = inputstream.read(buffer)) !=-1)
//					{
//						outputstream.write(buffer, 0, bytesRead);
//					}
//					
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				byte[] imageBytes = outputstream.toByteArray();
//				String a_profilepic = Base64.getEncoder().encodeToString(imageBytes);
//				a.setA_profilepic(a_profilepic);
				al.add(a);
				
			}
			return al;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;

	}
	
	public String adminUpdate(Admin a)
	{
		try {
			con = db.gConnection();
			PreparedStatement psmt = con.prepareStatement("update admin_table set a_name=?, a_email=?, a_password=?, a_gender=?, a_dob=? where admin_id=?");
			psmt.setString(1, a.getName());
			psmt.setString(2, a.getEmail());
			psmt.setString(3, a.getPassword());
			psmt.setString(4, a.getGender());
			psmt.setString(5, a.getDob());
			psmt.setInt(6, a.getId());
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
	
