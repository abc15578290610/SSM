package com.java.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.main.User;
import com.java.main.dao.userDAO;

@Service
public class userService {
	@Autowired
	userDAO userDAO;
	
	public void getUserInfo() {
		List<User> users = userDAO.getUser();
		for (int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i).getName());
		}
	}
}
