package com.java.main.dao;

import java.util.List;

import com.java.main.User;

public interface userDAO {
	/**
     * 获得用户信息
     */
    public List<User> getUsers();
    
    public User getUser(String name);
    
    public void InsertUser(String name,String password);
}
