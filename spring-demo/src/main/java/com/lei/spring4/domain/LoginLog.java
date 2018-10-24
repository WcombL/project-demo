package com.lei.spring4.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * 用户登录日志表
 *
 * @author wujunbo
 * @date 2018年10月18日 下午6:10:16
 */
public class LoginLog  implements Serializable{

	private static final long serialVersionUID = -7794096315664268691L;
	
	private String login_log_id = UUID.randomUUID().toString();
	private String user_id;
	private String ip;
	private Date login_datetime;
	public String getLogin_log_id() {
		return login_log_id;
	}
	public void setLogin_log_id(String login_log_id) {
		this.login_log_id = login_log_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getLogin_datetime() {
		return login_datetime;
	}
	public void setLogin_datetime(Date login_datetime) {
		this.login_datetime = login_datetime;
	}
}
