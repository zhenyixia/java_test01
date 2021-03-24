package com.lyp.basicAPI.thread;

public class ShutDownTest{
  public static void main(String[] args) throws InterruptedException{
    Runner4 runner4 = new Runner4();
    Thread t = new Thread(runner4);
    t.start();
    for(int i = 0; i < 1000; i++){
      if(i % 10 == 0){
        System.out.println("in thread main i= " + i);
      }
    }

    System.out.println("Thread main is over.");
    try{
      Thread.sleep(1);
    }catch(InterruptedException e){
      e.printStackTrace();
    }
    System.out.println(t.isAlive()); // true
    // t.stop(); 不要直接使用stop方法
    runner4.shutDown();
    System.out.println(t.isAlive()); // true
    Thread.sleep(100);
    System.out.println(t.isAlive()); //false
    System.out.println(Thread.currentThread().getName()); // main
    System.out.println(Thread.currentThread().isAlive()); // true
  }
}

class Runner4 implements Runnable{

  private boolean flag = true;

  @Override
  public void run(){
    int i = 0;
    while(flag){
      System.out.println("--------" + i++);
    }
  }

  public void shutDown(){
    flag = false;
  }
}