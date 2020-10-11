package com.test.cyclicbarrierdemo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(4);
        ExecutorService es = Executors.newFixedThreadPool(4);

        es.submit(new TestThread("Thread-A",cb));
        es.submit(new TestThread("Thread-B",cb));
        es.submit(new TestThread("Thread-C",cb));
        es.submit(new TestThread("Thread-D",cb));
        es.shutdown();
    }

    static class TestThread implements Runnable{

        private String name;

        private CyclicBarrier cb;

        public TestThread(String name, CyclicBarrier cb) {
            this.name = name;
            this.cb = cb;
        }

        @Override
        public void run() {
            try {
                System.out.println(name);
                cb.await();
                System.out.println(name + " is over");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

}
