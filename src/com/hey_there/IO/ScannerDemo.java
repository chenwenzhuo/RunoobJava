package com.hey_there.IO;

import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // next方式接收字符串
        System.out.println("next方式接收：");
        //判断是否还有输入
        while (scanner.hasNext()) {
//            String str1 = scanner.next();
//            System.out.println("输入的数据为：" + str1);
            int num = scanner.nextInt();
            System.out.println("输入的数字是：" + num);
        }
        scanner.close();
    }
}
