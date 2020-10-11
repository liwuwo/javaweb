package com.test.singlepattern;

public class SingletonTestClass {
    //单例模式
    public static void main(String[] args) {
        Singleton1.getInstance();
        Singleton2 s = Singleton2.INSTANCE;
    }
}
