package com.model;

public class Manager extends Products{
	private int m_id,p_id;
	private String m_name,m_desig;
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	

	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_desig() {
		return m_desig;
	}
	public void setM_desig(String m_desig) {
		this.m_desig = m_desig;
	}

}
