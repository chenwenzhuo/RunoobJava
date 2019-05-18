package com.hey_there.Generics.coffee;

import java.util.Iterator;
import java.util.Random;

public class CoffeeGenerator
        implements Generator<Coffee>, Iterable<Coffee> {
    //Coffee子类的Class对象
    private Class[] types = {Latte.class, Mocha.class,
            Cappuccino.class, Americano.class, Breve.class,};
    //随机数生成器
    private static Random rand = new Random();
    // For iteration:
    private int size = 0;

    //默认构造方法
    public CoffeeGenerator() {
    }

    //带一个参数size的构造方法
    public CoffeeGenerator(int size) {
        this.size = size;
    }

    /**
     * next()方法每次随机选择一个Coffee的子类，生成其实例并返回
     * @return 随机的Coffee子类对象
     */
    public Coffee next() {
        try {
            return (Coffee)
                    types[rand.nextInt(types.length)].newInstance();
            // Report programmer errors at run time:
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    class CoffeeIterator implements Iterator<Coffee> {
        int count = size;

        public boolean hasNext() {
            return count > 0;
        }

        public Coffee next() {
            count--;
            /*调用外部类的next()方法，
            * 生成Coffee的子类实例*/
            return CoffeeGenerator.this.next();
        }

        public void remove() { // Not implemented
            throw new UnsupportedOperationException();
        }
    }

    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    public static void main(String[] args) {
        //生成器实例
        CoffeeGenerator gen = new CoffeeGenerator();

        //生成5个Coffee子类的对象
        for (int i = 0; i < 5; i++)
            System.out.println(gen.next());
        System.out.println();

        for (Coffee c : new CoffeeGenerator(4))
            System.out.println(c);
    }
}
