package com.pokerforfun.rest.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.validator.constraints.Length;

public class TestConfig {
    public long id;
    public @Length(max = 10, min = 5) String example;
    public String test;
    public Double number;

    public TestConfig() {
    }

    public TestConfig(long id, String example, String test, Double number) {
        this.id = id;
        this.example = example;
        this.test = test;
        this.number = number;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getExample() {
        return example;
    }

    @JsonProperty
    public String getTest() {
        return test;
    }

    @JsonProperty
    public Double getNumber() {
        return number;
    }
}
