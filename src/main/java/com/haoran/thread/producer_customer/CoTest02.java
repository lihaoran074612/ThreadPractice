package com.haoran.thread.producer_customer;

/**
 * 生产者消费组模式2 使用信号灯
 */
public class CoTest02 {
    public static void main(String[] args) {

    }
}

/**
 * 生产者 演员
 * 消费组 观众
 * 信号灯 电视
 */
class Tv{
    String voice;
    public void play(String vioce){
        this.voice= vioce;

    }
    public void watch(){
        System.out.println("听到了："+voice);
    }


}

class Actor{

}

class Audience{

}

