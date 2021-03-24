package com.lyp.basicAPI.thread;

/**
 * 线程实现的两种方式
 */
public class ThreadImpl{
  public static void main(String[] args){
    Run1 run1 = new Run1();
    Thread t1 = new Thread(run1);
    t1.start();

    Run2 run2 = new Run2();
    run2.start();

    for(int i = 0; i < 350; i++){
      System.out.println("main---" + i);
    }
  }
}

class Run1 implements Runnable{

  @Override
  public void run(){
    for(int i = 0; i < 350; i++){
      System.out.println("run1---" + i);
    }
  }
}

class Run2 extends Thread{

  @Override
  public void run(){
    for(int i = 0; i < 350; i++){
      System.out.println("run2---" + i);
    }
  }
}