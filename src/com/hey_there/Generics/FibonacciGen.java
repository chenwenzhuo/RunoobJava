package com.hey_there.Generics;

import com.hey_there.Generics.coffee.Generator;

public class FibonacciGen implements Generator<Integer> {
    private int count = 0;//计数器，表示已生成了Fibonacci数列的前count个

    public Integer next() {
        return fib(count++);
    }

    private int fib(int n) {
        if (n < 2)
            return 1;

        return fib(n - 2) + fib(n - 1);
    }

    public static void main(String[] args) {
        FibonacciGen gen = new FibonacciGen();

        //生成Fibonacci数列的前20个数
        for (int i = 0; i < 20; i++)
            System.out.print(gen.next() + " ");
    }
}
