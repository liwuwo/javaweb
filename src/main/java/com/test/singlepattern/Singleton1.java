package com.test.singlepattern;

public class Singleton1 {

    private Singleton1(){
        System.out.println("instance a singleton");
    }

    private static final Singleton1 INSTANCE = new Singleton1();

    public static Singleton1 getInstance(){
        return Singleton1.INSTANCE;
    }
}
