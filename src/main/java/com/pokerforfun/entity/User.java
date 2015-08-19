package com.pokerforfun.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class User {
    private final String username;
    private AtomicInteger stack;
    private AtomicInteger loan;

    public User(String username, int stack, int loan) {
        this.username = username;
        this.stack = new AtomicInteger(stack);
        this.loan = new AtomicInteger(loan);
    }

    public User(String username) {
        this.username = username;
        stack = new AtomicInteger(0);
        loan = new AtomicInteger(0);
    }

    public String getUsername() {
        return username;
    }

    public int getStack() {
        return stack.get();
    }

    public int getLoan() {
        return loan.get();
    }

    public int changeLoan(int delta) {
        return loan.addAndGet(delta);
    }

    public int changeStack(int delta) {
        return stack.addAndGet(delta);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", stack=" + stack.get() +
                ", loan=" + loan.get() +
                '}';
    }
}
