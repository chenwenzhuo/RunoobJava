package com.hey_there.Override;

public class TestOverride {
    public static void main(String[] args) {
        //测试父类引用调用子类方法
        Animal animal = new Animal();
        Animal dog_1 = new Dog();
        Dog dog_2 = new Dog();

        System.out.print("animal.move()---");
        animal.move();

        System.out.print("dog_1.move()---");
        dog_1.move();

        System.out.print("dog_2.move()---");
        dog_2.move();

        System.out.print("dog_2.bark()---");
        dog_2.bark();
        System.out.println();

        //测试子类重写父类方法后返回不同值
        System.out.println(animal.returnObject());
        System.out.println(dog_1.returnObject());
        System.out.println(dog_2.returnObject());
    }
}
