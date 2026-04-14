package com.sunbeam.entities;

import java.sql.Date;

public class User {
	private Integer id;
	private String name;
	private String passwd;
	private String email;
	private String addr;
	private String role;
	private Date birth;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(Integer id, String name, String passwd, String email, String addr, String role, Date birth) {
		super();
		this.id = id;
		this.name = name;
		this.passwd = passwd;
		this.email = email;
		this.addr = addr;
		this.role = role;
		this.birth = birth;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", passwd=" + passwd + ", email=" + email + ", addr=" + addr
				+ ", role=" + role + ", birth=" + birth + "]";
	}
	
}