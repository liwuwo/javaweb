package com.algorithm;

public class minCountCoin {

    public static void main(String[] args) {
        staticFuncion();
    }

    static minCountCoin mc = new minCountCoin();
    int a = 110;
    static int b = 112;
    static{
        System.out.println("1");
    }
    {
        System.out.println("2");
    }

    minCountCoin(){
        System.out.println("3");
        System.out.println("a=" + a + "b = " + b);
    }

    public static void staticFuncion(){
        System.out.println("4");
    }
}
