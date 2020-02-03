package com.haoran.thread.deadLock;

public class DeadLock  {
    public static void main(String[] args) {
        Thread t1 = new makeUp("小红",0);
        Thread t2 = new makeUp("小绿",2);
        t1.start();
        t2.start();
    }
}

class Lipstick{

}

class Mirror{

}

class makeUp extends Thread{

    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice;
    String girlName;

    public makeUp(String girlName, int choice){
        this.girlName = girlName;
        this.choice = choice;
    }

    @Override
    public void run() {
        try {
            makeUp();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //化妆
    private void makeUp() throws InterruptedException {
        if (choice == 0){
            synchronized (lipstick){
                System.out.println(this.girlName+"想获得口红");
                Thread.sleep(1000);
            }
            synchronized (mirror){
                System.out.println(this.girlName+"想获得镜子");
            }
        }else {
            synchronized (mirror){
                System.out.println(this.girlName+"想获得镜子");
                Thread.sleep(2000);
            }
            synchronized (lipstick){
                System.out.println(this.girlName+"想获得口红");
            }
        }
    }
}
