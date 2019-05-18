package com.hey_there.Override;

public class Dog extends Animal {
    @Override
    public void move() {
        System.out.println("Dogs can walk and run.");
    }

    public void bark() {
        System.out.println("Dogs can bark.");
    }

    @Override
    public ReturnType_Son returnObject() {
        return new ReturnType_Son();
    }
}
