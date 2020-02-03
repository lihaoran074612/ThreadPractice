package com.haoran.thread.daemon;

/**
 * 守护线程
 */
public class DeamonTest {
    public static void main(String[] args) {
        Thread god = new Thread(new God());
        god.start();
        System.out.println(god.getThreadGroup());
        System.out.println(Thread.currentThread().getThreadGroup());

    }
}
class You implements Runnable{
    public static void main(String[] args) {
        System.out.println(123);
    }
    public void run(){
        for (int i =0;i<3;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("life");
        }

    }
}

class God implements Runnable{
    public void run(){
        System.out.println(Thread.currentThread().getName());
        new Thread(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getThreadGroup()+"1234");
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
    }
}

