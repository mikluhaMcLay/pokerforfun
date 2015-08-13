package com.pokerforfun;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pokerforfun.rest.controller.HelloWorld;

import org.hibernate.validator.constraints.NotEmpty;

import javax.inject.Named;

import dagger.*;
import io.dropwizard.Configuration;

@dagger.Module
public class Config extends Configuration {
    @JsonProperty private @NotEmpty String example;
    @JsonProperty private String testEmpty;
    @JsonProperty private Double number;

    @Provides
    @Named("example")
    public String getExample() {
        return example;
    }

    @Provides
    @Named("test")
    public String getTestEmpty() {
        return testEmpty;
    }

    @Provides
    @Named("number")
    public Double getNumber() {
        return number;
    }
}
