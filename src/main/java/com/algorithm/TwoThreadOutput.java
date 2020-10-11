package com.algorithm;

public class TwoThreadOutput {

    public Integer num = 1;

    public Boolean flag = true;

    public static void main(String[] args) {
        TwoThreadOutput twoThreadOutput = new TwoThreadOutput();

        new Thread(new JiNum(twoThreadOutput),"thread 1").start();
        new Thread(new OuNum(twoThreadOutput),"thread 2").start();
    }

    static class JiNum implements Runnable{

        public TwoThreadOutput twoThreadOutput;

        public JiNum(TwoThreadOutput twoThreadOutput){
            this.twoThreadOutput = twoThreadOutput;
        }

        @Override
        public void run() {
            while(twoThreadOutput.num < 100){
                synchronized (TwoThreadOutput.class){
                    if(twoThreadOutput.flag){
                        System.out.println(Thread.currentThread().getName() + "==>" + twoThreadOutput.num);
                        twoThreadOutput.num++;
                        twoThreadOutput.flag = false;
                        TwoThreadOutput.class.notifyAll();
                    }else{
                        try {
                            TwoThreadOutput.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    static class OuNum implements Runnable{

        public TwoThreadOutput twoThreadOutput;

        public OuNum(TwoThreadOutput twoThreadOutput){
            this.twoThreadOutput = twoThreadOutput;
        }

        @Override
        public void run() {
            while(twoThreadOutput.num < 100){
                synchronized (TwoThreadOutput.class){
                    if(!twoThreadOutput.flag){
                        System.out.println(Thread.currentThread().getName() + "==>" + twoThreadOutput.num);
                        twoThreadOutput.num++;
                        twoThreadOutput.flag = true;
                        TwoThreadOutput.class.notifyAll();
                    }else{
                        try {
                            TwoThreadOutput.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }
    }

}
