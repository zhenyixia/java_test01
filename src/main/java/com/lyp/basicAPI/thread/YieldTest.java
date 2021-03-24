package com.lyp.basicAPI.thread;

public class YieldTest{
  public static void main(String[] args){
    Thread1 t1 = new Thread1("t1");
    Thread1 t2 = new Thread1("t2");
    t1.start();
    t2.start();
  }

}

class Thread1 extends Thread{
  public Thread1(String name){
    super(name);
  }

  public void run(){
    for(int i = 0; i < 100; i++){
      System.out.println(getName() + "-----" + i);
      if(i % 10 == 0){
        yield();
      }
    }
  }
}