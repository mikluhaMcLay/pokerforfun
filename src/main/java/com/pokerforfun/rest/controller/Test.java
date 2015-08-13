package com.pokerforfun.rest.controller;

import org.jboss.logging.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
public class Test {
    private static final Logger log = LoggerFactory.getLogger(Test.class);

    private final Map<String, String> data = new ConcurrentHashMap<>();

    @POST
    @Path("/{key}/{value}")
    public void postKVPair(@PathParam("key") String key, @PathParam("value") String value) {
        assert key != null && value !=null : "Key and value should be not null";
        log.info("Key: {}, value:{}", key, value);
        data.put(key, value);
    }

    @GET
    public Map<String, String> getData() {
        return data;
    }
}
