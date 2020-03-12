package com.model;

import java.sql.Blob;

public class Admin {
	
	private int admin_id;
	private String a_email, a_password, a_dob, a_gender, a_name, a_profilepic;
	private Blob profile;
	private byte[] img;
	
	public Blob getProfile() {
		return profile;
	}
	public void setProfile(Blob profile) {
		this.profile = profile;
	}	
	public byte[] getImg() {
		return img;
	}
	public void setImg(byte[] img) {
		this.img = img;
	}
	public int getId() {
		return admin_id;
	}
	public void setId(int id) {
		this.admin_id = id;
	}
	public String getEmail() {
		return a_email;
	}
	public void setEmail(String email) {
		this.a_email = email;
	}
	public String getPassword() {
		return a_password;
	}
	public void setPassword(String password) {
		this.a_password = password;
	}
	public String getDob() {
		return a_dob;
	}
	public void setDob(String dob) {
		this.a_dob = dob;
	}
	public String getGender() {
		return a_gender;
	}
	public void setGender(String gender) {
		this.a_gender = gender;
	}
	public String getName() {
		return a_name;
	}
	public void setName(String name) {
		this.a_name = name;
	}
	
}
