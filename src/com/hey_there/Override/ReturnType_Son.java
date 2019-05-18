package com.hey_there.Override;

public class ReturnType_Son extends ReturnType_Father {
    @Override
    public String toString() {
        return "ReturnType_Son" + "---"  + this.hashCode();
    }
}
