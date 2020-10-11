package com.test.factorypattern;

public class Product1 implements IProduct1{
    @Override
    public void desc() {
        System.out.println("这是1号产品！");
    }
}
