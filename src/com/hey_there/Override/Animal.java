package com.hey_there.Override;

public class Animal {
    public void move() {
        System.out.println("Animals can move.");
    }

    public ReturnType_Father returnObject() {
        return new ReturnType_Father();
    }
}
