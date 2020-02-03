package com.haoran.thread.producer_customer;

/**
 * 生产者消费组模式1  管程法，使用容器
 */
public class CoTest01 {

    public static void main(String[] args) {
        Container container = new Container();
        new Producer(container).start();
        new Consumer(container).start();
    }

}

class Producer extends Thread{
    Container container;

    Producer(Container container){
        this.container = container;
    }
    @Override
    public void run() {
        for (int i = 0;i<1000;i++){
            System.out.println(Thread.currentThread().getName()+"开始生产第"+i+"个馒头"+"  剩余："+container.count+"  "+System.currentTimeMillis());
            try {
                container.push(new SteamedBuns(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread{

    Container container;

    Consumer(Container container){
        this.container = container;
    }
    @Override
    public void run() {
        for (int i=0;i<1000;i++){
            System.out.println(Thread.currentThread().getName()+"开始消费第"+i+"个馒头"+"  剩余："+container.count+"  "+System.currentTimeMillis());
            try {
                container.pop();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Container {

    SteamedBuns[] buns = new SteamedBuns[100];
    int count = 0;

    public synchronized void push(SteamedBuns steamedBuns) throws InterruptedException {
        if (count==99){
            wait();
        }
        buns[count++] = steamedBuns;
        notify();
    }

    public synchronized SteamedBuns pop() throws InterruptedException {
        if (count<1){
            wait();
        }
        count--;
        notify();
        return buns[count];
    }
}

class SteamedBuns{
    int id;

    SteamedBuns(int id){
        this.id = id;
    }
}