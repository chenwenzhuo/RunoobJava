package com.hey_there.Reflect.AccessPrivateMethodsAndFields;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AccessPrivateMembers {
    public static void main(String[] args) throws Exception {
        TestClass testInstance = new TestClass();

        callPrivateMethod(testInstance);
        modifyPrivateField(testInstance);
    }

    private static void callPrivateMethod(@NotNull TestClass testInstance)
            throws InvocationTargetException, IllegalAccessException {
        //1. 获取 Class 类实例
        Class iClass = testInstance.getClass();

        try {
            /*2.获取一个私有方法
            * 方法名：privateMethod
            * 参数列表：String,int*/
            Method privateMethod = iClass.getDeclaredMethod("privateMethod", String.class, int.class);

            //3. 开始操作方法
            //获取私有方法的访问权
            //只是获取访问权，并不是修改实际权限
            privateMethod.setAccessible(true);

            //使用 invoke 反射调用私有方法
            //privateMethod 是获取到的私有方法
            //testInstance 是要操作的对象
            //后面两个参数传实参
            privateMethod.invoke(testInstance, "Java reflect ", 666);

        } catch (NoSuchMethodException e) {
            System.out.println(iClass + " 中没有名为 privateMethod(String,int) 的 private 方法");
        }

    }

    private static void modifyPrivateField(@NotNull TestClass testInstance) throws IllegalAccessException {
        //1. 获取 Class 类实例
        Class iClass = testInstance.getClass();

        try {
            //2. 获取私有成员变量
            Field privateField = iClass.getDeclaredField("msg");

            //获取私有成员的访问权限
            privateField.setAccessible(true);

            //输出修改前成员的值
            System.out.println(testInstance.getMsg());

            //修改私有成员的值
            //调用 set(object , value) 修改变量的值
            //privateField 是获取到的私有变量
            //testInstance 要操作的对象
            //"The modified message." 为要修改成的值
            privateField.set(testInstance,"The modified message.");

            //输出修改后成员的值
            System.out.println(testInstance.getMsg());
        } catch (NoSuchFieldException e) {
            System.out.println(iClass + " 中没有名为 msg 的 private 成员");
        }
    }
}
