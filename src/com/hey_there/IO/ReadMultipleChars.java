package com.hey_there.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 从控制台逐个读取字符，遇到字符q结束
 */
public class ReadMultipleChars {
    public static void main(String[] args) throws IOException {
        char c;
        // 使用 System.in 创建 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入字符, 按下 'q' 键退出。");
        // 读取字符
        while (true){
            c = (char) br.read();
            if ('q' == c) {
                break;
            }
            System.out.print(c);
        }
    }
}
