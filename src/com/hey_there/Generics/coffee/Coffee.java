package com.hey_there.Generics.coffee;

public class Coffee {
    private static long counter = 0;
    private final long id = counter++;
    public String toString() {
        return getClass().getSimpleName() + "---" + id;//输出类名加上id
    }
}