package com.test.observerpattern;

public interface ObServerable {

    void createOb(ObServer ob);

    void deleteOb(ObServer ob);

    void sendMsg(String msg);
}
