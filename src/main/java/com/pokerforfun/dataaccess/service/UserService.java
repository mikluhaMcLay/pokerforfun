package com.pokerforfun.dataaccess.service;

import com.google.common.base.Optional;

import com.pokerforfun.entity.User;

public interface UserService {
    boolean store(User user);

    Optional<User> fetch(String username);

    User buyChips(int amount);
}
