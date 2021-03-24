package com.lyp.basicAPI.thread;

public class PriorityTest{
  public static void main(String[] args){
    Thread2 t1 = new Thread2("t1");
    Thread2 t2 = new Thread2("t2");
    t1.setPriority(Thread.NORM_PRIORITY + 3);
    t1.start();
    t2.start();
  }
}

class Thread2 extends Thread{
  public Thread2(String name){
    super(name);
  }

  public void run(){
    for(int i = 0; i < 100; i++){
      System.out.println(getName() + "-----" + i);
    }
  }
}