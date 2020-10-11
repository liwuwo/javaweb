package com.test.observerpattern;

public class ObTestClass {
    //观察者模式
    public static void main(String[] args) {
        User zhangsan = new User("zhangsan");
        User lisi = new User("lisi");
        User wangwu = new User("wangwu");

        Server server = new Server();
        server.createOb(zhangsan);
        server.createOb(lisi);
        server.createOb(wangwu);
        server.setMsg("欢迎大家");
        server.deleteOb(lisi);
        server.setMsg("hello world");
    }
}
