package com.hey_there.RegularExpression.CaptureGroup;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {
    public static void main(String[] args) {

        // 按指定模式在字符串查找
        String line = "1000 This order was placed for QT3000! OK?";
        String patternStr = "(\\D*)(\\d+)(.*)";

        // 创建 Pattern 对象
        Pattern pattern = Pattern.compile(patternStr);
        // 现在创建 matcher 对象
        Matcher m = pattern.matcher(line);
        if (m.find()) {
            System.out.println("Found value: " + m.group(0));
            System.out.println("Found value: " + m.group(1));
            System.out.println("Found value: " + m.group(2));
            System.out.println("Found value: " + m.group(3));
            System.out.println("Group count: " + m.groupCount());
        } else {
            System.out.println("NO MATCH");
        }
        System.out.println();

        m = Pattern.compile("(\\D*)").matcher(line);
        if (m.find()) {
            System.out.println("Found value: " + m.group(0));
            System.out.println("Found value: " + m.group(1));
            System.out.println("Group count: " + m.groupCount());
            System.out.println(m.lookingAt());
        }else {
            System.out.println("NO MATCH");
        }
    }
}
