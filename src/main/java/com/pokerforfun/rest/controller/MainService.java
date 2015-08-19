package com.pokerforfun.rest.controller;

import com.google.common.base.Optional;

import com.pokerforfun.dataaccess.service.SimpleUserService;
import com.pokerforfun.dataaccess.service.UserService;
import com.pokerforfun.entity.Table;
import com.pokerforfun.entity.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.dropwizard.auth.Auth;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
public class MainService {
    private static final Logger log = LoggerFactory.getLogger(MainService.class);

    private final UserService userService = SimpleUserService.getInstance();

    @GET
    @Path("/tables")
    public List<Table> fetchTables(@Auth String username) {
        return Collections.emptyList();
    }

    @GET
    @Path("/user")
    public User fetchUser(@Auth String username) {
        User user;

        Optional<User> fetch = userService.fetch(username);
        if (fetch.isPresent()) {
            user = fetch.get();
        } else {
            user = null;
        }

        return user;
    }
}
