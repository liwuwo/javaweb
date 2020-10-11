package com.test.observerpattern;

public class User implements ObServer{

    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void refresh(String msg) {
        System.out.println(name + "收到了消息:" + msg);
    }
}
