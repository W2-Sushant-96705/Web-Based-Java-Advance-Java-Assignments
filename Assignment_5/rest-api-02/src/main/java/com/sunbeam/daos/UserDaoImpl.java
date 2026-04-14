package com.sunbeam.daos;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sunbeam.entities.User;
@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private UserRowMapper userRowMapper;
	@Override
	public List<User> findAll() {
		String sql= "SELECT * FROM users";
		List<User> list = jdbcTemplate.query(sql, userRowMapper);
		return list;
	}
	@Override
	public int save(User u) {
		String sql =  "INSERT INTO users (name, passwd, email, addr, role, birth) VALUES (?, ?, ?, ?, ?, ?)";
		int cnt = jdbcTemplate.update(sql, u.getName(), u.getPasswd(), u.getEmail(), u.getAddr(), u.getRole(), u.getBirth());
		return cnt;
	}
	@Override
	public int updatePassword(int userId, String newPasswd) {
		String sql =  "UPDATE users SET passwd=? WHERE id=?";
		int cnt = jdbcTemplate.update(sql, newPasswd, userId);
		return cnt;
	}
	@Override
	public int deleteById(int id) {
		 String sql = "DELETE FROM users WHERE id = ?";
		    return jdbcTemplate.update(sql, id);
		}
	
}

	

