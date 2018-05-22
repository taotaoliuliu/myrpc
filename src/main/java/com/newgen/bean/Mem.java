package com.newgen.bean;

import java.io.Serializable;

public class Mem implements Serializable{

	private String id;
	private String username;
	
	private String loginname;
	
	private String password;
	
	private String createtime;
	
	private String phone;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Mem [id=" + id + ", username=" + username + ", loginname=" + loginname + ", password=" + password
				+ ", createtime=" + createtime + ", phone=" + phone + "]";
	}


	
	
	
	
	
}
