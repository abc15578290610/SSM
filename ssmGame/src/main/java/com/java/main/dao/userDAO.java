package com.java.main.dao;

import java.util.List;

import com.java.main.User;

public interface userDAO {
    public List<User> getUsers();
    
    public User getUser(String name);
    
    public void InsertUser(String name,String password);
}
