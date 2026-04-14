package com.sunbeam.daos;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.sunbeam.entities.User;

/*
RowMapper interface -- standard to convert a resultset row into corresponding pojo object.
*/

@Component
public class UserRowMapper implements RowMapper<User> {
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		int id = rs.getInt("id");
		String name = rs.getString("name");
		String email = rs.getString("email");
		String password = rs.getString("passwd");
		String role = rs.getString("role");
		String addr = rs.getString("addr");
		Date birth = rs.getDate("birth");
		User user = new User(id, name, password, email, addr, role, birth);
		return user;
	}
}
