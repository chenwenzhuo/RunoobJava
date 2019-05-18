package com.hey_there.Reflect.AccessPrivateMethodsAndFields;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;

public class ModifyFinalFields {
    public static void main(String[] args) throws Exception {
        TestClass testInstance = new TestClass();

        modifyFinal(testInstance, "CONSTANT_MSG_1");
        System.out.println();
        modifyFinal(testInstance, "CONSTANT_MSG_2");
        System.out.println();
        modifyFinal(testInstance, "CONSTANT_MSG_3");
    }

    private static void modifyFinal(@NotNull TestClass testInstance, String constantName) throws Exception {
        //1. 获取 Class 类实例
        Class mClass = testInstance.getClass();

        //2. 获取私有常量
        Field finalField = mClass.getDeclaredField(constantName);
        //3. 修改常量的值
        if (finalField != null) {

            //获取私有常量的访问权
            finalField.setAccessible(true);

            //调用 finalField 的 getter 方法
            //输出 FINAL_VALUE 修改前的值
            System.out.println("Before Modify：" + constantName + " = " + finalField.get(testInstance));

            //修改私有常量
            finalField.set(testInstance, "modified.");

            //调用 finalField 的 getter 方法
            //输出 FINAL_VALUE 修改后的值
            System.out.println("After Modify：" + constantName + " = " + finalField.get(testInstance));

            //使用对象调用类的 getter 方法
            //获取值并输出
            System.out.print("Actually ：" + constantName + " = ");
            switch (constantName) {
                case "CONSTANT_MSG_1":
                    System.out.println(testInstance.getCONSTANT_MSG_1());
                    break;
                case "CONSTANT_MSG_2":
                    System.out.println(testInstance.getCONSTANT_MSG_2());
                    break;
                case "CONSTANT_MSG_3":
                    System.out.println(testInstance.getCONSTANT_MSG_3());
                    break;
            }
        }
    }
}
