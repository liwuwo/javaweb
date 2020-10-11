package com.test.proxypattern;

public class ProxyTestClass {

    public static void main(String[] args) {
        //代理模式
        Ihello ihello = new Hello();
        Ihello proxy = new HelloProxy(ihello);
        proxy.sayHello();
    }
}
