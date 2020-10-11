package com.test.proxypattern;

public class HelloProxy implements Ihello {

    private Ihello hello;

    public HelloProxy(Ihello hello){
        this.hello = hello;
    }

    @Override
    public void sayHello() {
        System.out.println("打招呼");
        hello.sayHello();
        System.out.println("挥手");
    }
}
