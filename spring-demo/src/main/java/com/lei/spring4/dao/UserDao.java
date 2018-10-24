package com.lei.spring4.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.lei.spring4.domain.User;

/**
 *
 *
 * @author wujunbo
 * @date 2018年10月18日 上午10:37:11
 */
@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int getMatchCount(String username, String password) {
		String sql = "SELECT count(*) FROM t_user WHERE user_name = ? and password = ? ";
		return jdbcTemplate.queryForObject(sql, new Object[] { username, password }, Integer.class);
	}
	
	public User findUserByUserName(final String userName){
		final User user = new User();
		String sql = "SELECT count(*) FROM t_user WHERE user_name = ? ";
		jdbcTemplate.query(sql, new Object[]{userName}, new RowCallbackHandler(){
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				user.setUserId(rs.getString("user_id"));
				user.setUser_name(userName);
				user.setCredits(rs.getInt("credits"));
			}
		});
		return user;
	}
	
	public void updateLoginInfo(){
		
	}
}
