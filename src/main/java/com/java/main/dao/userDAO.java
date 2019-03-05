package com.java.main.dao;

import java.util.List;

import com.java.main.User;

public interface userDAO {
	/**
     * 获得用户信息
     */
    public List<User> getUser();
}
