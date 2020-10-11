package com.test.factorypattern;

public class FactoryTestClass {

    //抽象工厂模式
    public static void main(String[] args) {
        IFactory factory = new Factory();
        factory.createProduct1().desc();
        factory.createProduct2().desc();
    }
}
