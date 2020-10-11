package com.test.factorypattern;

public class Fruit implements Food{
    @Override
    public void eat() {
        System.out.println("吃水果！");
    }
}
