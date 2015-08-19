package com.pokerforfun.dataaccess.service;

import com.google.common.base.Optional;

import com.pokerforfun.dataaccess.dao.InMemoryUserDao;
import com.pokerforfun.dataaccess.dao.UserDao;
import com.pokerforfun.entity.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleUserService implements UserService {
    private static final Logger log = LoggerFactory.getLogger(SimpleUserService.class);

    private final UserDao userDao = new InMemoryUserDao();
    private static final SimpleUserService instance = new SimpleUserService();

    private SimpleUserService() {}

    public static SimpleUserService getInstance() {
        return instance;
    }

    @Override
    public boolean store(User user) {
        boolean stored = userDao.save(user);
        log.debug("Has user {} been stored?: {}", user, stored);
        return stored;
    }

    @Override
    public Optional<User> fetch(String username) {
        User user = userDao.find(username);
        log.debug("User {} was found by username {}", user, username);
        return Optional.fromNullable(user);
    }

    @Override
    public User buyChips(int amount) {

        return null;
    }
}
