package com.java.main.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.main.User;
import com.java.main.dao.userDAO;

@Service
public class userService {
	private static final Logger logger = LoggerFactory.getLogger(userService.class);
	
	@Autowired
	userDAO userDAO;
	
	public void getUsersInfo() {
		List<User> users = userDAO.getUsers();
		for (int i = 0; i < users.size(); i++) {
			logger.info(users.get(i).getUserName());
		}
	}
	
	public User getUserInfo(String name) {
		logger.info("查找用户"+name);
		User user = userDAO.getUser(name);
		return user;
	}
	public String AddUser(String name,String password) {
		logger.info("新增用户"+name+"----密码"+password);
		userDAO.InsertUser(name,password);
		return "插入成功";
	}
}
