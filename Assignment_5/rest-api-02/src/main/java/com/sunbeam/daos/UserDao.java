package com.sunbeam.daos;

import java.util.List;


import com.sunbeam.entities.User;

public interface UserDao {
	List<User> findAll();
	int save(User b);
	int updatePassword(int id, String passwd);
	int deleteById(int id);

		
	

}
