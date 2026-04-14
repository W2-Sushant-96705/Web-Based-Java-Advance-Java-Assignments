package com.sunbeam.controllers;
import com.sunbeam.entities.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PatchExchange;

import com.sunbeam.daos.UserDao;

@RequestMapping
@RestController
public class UserRestController {
	@Autowired
	private UserDao userDao;
	
	@GetMapping("/user")
	public List<User> getAllUsers(){
		List<User> list= userDao.findAll();
		return list;
	}
	
	@PostMapping("/user")
	public int addBook(@RequestBody User u) {
		int cnt = userDao.save(u);
		return cnt;
	}
	
	@PatchMapping("/user/{id}")
	public int updatePassword(@PathVariable int id, @RequestBody User u) {
	    return userDao.updatePassword(id, u.getPasswd());
	}
	  @DeleteMapping("/{id}")
	    public String deleteUser(@PathVariable int id) {
	        int count = userDao.deleteById(id);
	        return count == 1 ? "Deleted" : "User not found";
	    }
}
