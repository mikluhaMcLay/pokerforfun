package com.pokerforfun.rest.auth;

import com.google.common.base.Optional;

import com.pokerforfun.dataaccess.service.SimpleUserService;
import com.pokerforfun.dataaccess.service.UserService;
import com.pokerforfun.entity.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

public class DummyAuthenticator implements Authenticator<BasicCredentials, String> {
    private static final Logger log = LoggerFactory.getLogger(DummyAuthenticator.class);

    private final UserService userService = SimpleUserService.getInstance();

    @Override
    public Optional<String> authenticate(BasicCredentials credentials) throws AuthenticationException {
        String username = credentials.getUsername();
        if (username != null && !username.trim().isEmpty()) {
            boolean stored = userService.store(new User(username));
            log.debug("User {} authenticated: {}", username, stored);
            return Optional.of(username);
        } else {
            return Optional.absent();
        }
    }
}
