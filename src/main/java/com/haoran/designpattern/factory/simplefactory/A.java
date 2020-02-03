package com.haoran.designpattern.factory.simplefactory;

public class A {
    public static void main(String[] args) {
        Integer z = 0;
        B b = new B();
        if(b.getFlag() == null){
            System.out.println("异常");
        }
    }

    static class B{
       public Integer flag;

        public Integer getFlag() {
            return flag;
        }

        public void setFlag(Integer flag) {
            this.flag = flag;
        }
    }
}
