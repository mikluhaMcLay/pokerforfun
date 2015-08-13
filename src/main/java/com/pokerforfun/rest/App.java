package com.pokerforfun.rest;

import com.codahale.metrics.JmxReporter;
import com.pokerforfun.Config;
import com.pokerforfun.Module;
import com.pokerforfun.rest.controller.HelloWorld;
import com.pokerforfun.rest.controller.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class App extends Application<Config> {
    private static final Logger log = LoggerFactory.getLogger(App.class);

    @Override
    public void run(Config configuration, Environment environment) throws Exception {
        // Manually add JMX reporting (Dropwizard regression)
        JmxReporter.forRegistry(environment.metrics()).build().start();

        environment.jersey().register(new HelloWorld(configuration));
        environment.jersey().register(new Test());
    }
}
