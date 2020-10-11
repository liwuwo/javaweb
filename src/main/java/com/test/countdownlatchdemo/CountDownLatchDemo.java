package com.test.countdownlatchdemo;

import com.common.util.JsonUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(4);
        List<String> list = new ArrayList<>();

        TestThread tt1 = new TestThread(countDownLatch,list);

        TestThread tt2 = new TestThread(countDownLatch,list);

        TestThread tt3 = new TestThread(countDownLatch,list);

        TestThread tt4 = new TestThread(countDownLatch,list);

        new Thread(tt1,"thread-A").start();
        new Thread(tt2,"thread-B").start();
        new Thread(tt3,"thread-C").start();
        new Thread(tt4,"thread-D").start();
        countDownLatch.await();
        System.out.println(JsonUtil.write2JsonStr(list));
        System.out.println("Finish!");
    }

    static class TestThread implements Runnable{

        private CountDownLatch countDownLatch;

        private List<String> list;

        private TestThread(CountDownLatch countDownLatch,List<String> list) {
            this.countDownLatch = countDownLatch;
            this.list = list;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            countDownLatch.countDown();
            list.add("add " + Thread.currentThread().getName());
        }
    }
}


