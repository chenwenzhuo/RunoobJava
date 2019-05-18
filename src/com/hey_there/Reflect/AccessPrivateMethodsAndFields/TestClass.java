package com.hey_there.Reflect.AccessPrivateMethodsAndFields;

public class TestClass {
    private String msg = "The original message.";
    private final String CONSTANT_MSG_1 = "original.";
    private final String CONSTANT_MSG_2;
    private final String CONSTANT_MSG_3 = true ? "original." : null;

    public TestClass() {
        CONSTANT_MSG_2 = "original.";
    }
    private void privateMethod(String head, int tail) {
        System.out.print(head + tail);
    }

    public String getMsg() {
        return msg;
    }

    public String getCONSTANT_MSG_1() {
        return CONSTANT_MSG_1;
    }

    public String getCONSTANT_MSG_2() {
        return CONSTANT_MSG_2;
    }

    public String getCONSTANT_MSG_3() {
        return CONSTANT_MSG_3;
    }
}