package com.haoran.thread.join;

/**
 * 1.sleep是线程的静态方法，当前线程睡眠，wait是object的方法，释放锁
 * 2.
 */

public class WaitAndSleep {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getThreadGroup().getName());
    }

    public static void method2(){
        try {
            Thread.sleep(123);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
