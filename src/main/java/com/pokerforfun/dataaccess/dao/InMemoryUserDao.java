package com.pokerforfun.dataaccess.dao;

import com.pokerforfun.entity.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryUserDao implements UserDao {
    private final Map<String, User> users = new ConcurrentHashMap<>();

    @Override
    public boolean save(User user) {
        return users.put(user.getUsername(), user) == null;
    }

    @Override
    public User find(String username) {
        return users.get(username);
    }
}
