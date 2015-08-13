package com.pokerforfun;

import com.pokerforfun.rest.App;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        new App().run(new String[]{"server", System.getProperty("dropwizard.config")});
        log.info("Started at {}", new Date());
    }
}
