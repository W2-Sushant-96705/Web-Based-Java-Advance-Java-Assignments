package com.sunbeam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sunbeam.daos.User;
import com.sunbeam.daos.UserDao;

@SpringBootApplication
public class Sb13Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Sb13Application.class, args);
	}
	
	@Autowired
	private UserDao userDao;

	@Override
	public void run(String... args) throws Exception {
		
		List<User> list = userDao.findAll();
		for(User u : list)
			System.out.println(u);
		
	}

}
