package com.pokerforfun.dataaccess.dao;

import com.pokerforfun.entity.User;

public interface UserDao {
    boolean save(User user);

    User find(String username);
}
