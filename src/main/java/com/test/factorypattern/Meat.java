package com.test.factorypattern;

public class Meat implements Food{
    @Override
    public void eat() {
        System.out.println("吃肉！");
    }
}
