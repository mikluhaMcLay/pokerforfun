package com.pokerforfun.rest.controller;

import com.codahale.metrics.annotation.Timed;
import com.pokerforfun.Config;
import com.pokerforfun.rest.entity.TestConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorld {
    private static final Logger log = LoggerFactory.getLogger(HelloWorld.class);

    private final AtomicLong counter = new AtomicLong();
    private final Config config;

    public HelloWorld(Config config) {
        this.config = config;
    }

    @GET
    public Map<String, Object> sayHello(@QueryParam("name") String name) {
        Map<String, Object> res = new HashMap<>();
        res.put("id", counter.incrementAndGet());
        res.put("content", "Hello, " + (name != null ? name : "World"));
        return res;
    }

    @Timed
    @GET
    @Path("/config")
    public TestConfig getConfig() throws InterruptedException {
        Thread.sleep(ThreadLocalRandom.current().nextInt(10, 500));
        return new TestConfig(
                counter.getAndIncrement(),
                config.getExample(),
                config.getTestEmpty(),
                config.getNumber());
    }
}
