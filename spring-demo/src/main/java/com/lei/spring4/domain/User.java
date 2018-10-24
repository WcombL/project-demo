package com.lei.spring4.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * 用户表
 *
 * @author wujunbo
 * @date 2018年10月18日 下午6:02:32
 */
public class User implements Serializable{
	
	private static final long serialVersionUID = 1856991611425616964L;
	
	private String userId = UUID.randomUUID().toString();
	String user_name;
	private int credits;
	private String password;
	private Date last_visit;
	private String last_ip;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLast_visit() {
		return last_visit;
	}

	public void setLast_visit(Date last_visit) {
		this.last_visit = last_visit;
	}

	public String getLast_ip() {
		return last_ip;
	}

	public void setLast_ip(String last_ip) {
		this.last_ip = last_ip;
	}
}
