package com.hey_there.Reflect.GetInfoOfClass;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class PrintInfo {
    public static void main(String[] args) {
        //printFields();
        printMethods();
    }

    /**
     * 通过反射获取类的所有变量
     */
    private static void printFields() {
        //1.获取并输出类的名称
        Class mClass = SonClass.class;
        System.out.println("类的名称：" + mClass.getName() + "\n");

        //2.1 获取所有 public 访问权限的变量
        // 包括本类声明的和从父类继承的
        Field[] fields = mClass.getFields();

        //2.2 获取所有本类声明的变量（不问访问权限）
        Field[] declared_fields = mClass.getDeclaredFields();

        //3. 遍历变量并输出变量信息
        for (Field field : fields) {
            //获取访问权限并输出
            int modifiers = field.getModifiers();
            System.out.print(Modifier.toString(modifiers) + " ");
            //输出变量的类型及变量名
            System.out.println(field.getType().getName()
                    + " " + field.getName());
        }
        System.out.println();

        for (Field field : declared_fields) {
            //获取访问权限并输出
            int modifiers = field.getModifiers();
            System.out.print(Modifier.toString(modifiers) + " ");
            //输出变量的类型及变量名
            System.out.println(field.getType().getName()
                    + " " + field.getName());
        }
    }

    /**
     * 通过反射获取类的所有方法
     */
    private static void printMethods() {
        //1.获取并输出类的名称
        Class mClass = SonClass.class;
        System.out.println("类的名称：" + mClass.getName());

        //2.1 获取所有 public 访问权限的方法
        //包括自己声明和从父类继承的
        Method[] mMethods = mClass.getMethods();

        //2.2 获取所有本类的的方法（不问访问权限）
        //Method[] mMethods = mClass.getDeclaredMethods();

        //3.遍历所有方法
        for (Method method : mMethods) {
            //获取并输出方法的访问权限（Modifiers：修饰符）
            int modifiers = method.getModifiers();
            System.out.print(Modifier.toString(modifiers) + " ");

            //获取并输出方法的返回值类型
            Class returnType = method.getReturnType();
            System.out.print(returnType.getName() + " " + method.getName() + "( ");

            //获取并输出方法的所有参数
            Parameter[] parameters = method.getParameters();
            if (parameters.length > 0) {
                for (int i = 0; i < parameters.length; i++) {
                    System.out.print(parameters[i].getType().getName() + " " + parameters[i].getName());

                    //处理参数列表中的逗号
                    //若此次循环输出的不是最后一个参数，则输出逗号
                    if (i < parameters.length - 1) {
                        System.out.print(",");
                    }
                }
            }

            //获取并输出方法抛出的异常
            Class[] exceptionTypes = method.getExceptionTypes();
            if (exceptionTypes.length == 0) {
                System.out.println(" )");
            } else {
                System.out.print(" ) throws ");

                for (int i = 0; i < exceptionTypes.length; i++) {
                    System.out.print(exceptionTypes[i].getName());

                    //同样的方法，处理异常列表里的逗号
                    if (i < exceptionTypes.length - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println();
            }
        }
    }
}
