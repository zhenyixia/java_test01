package com.lyp.basicAPI.thread;

public class JoinTest{
  public static void main(String[] args){
    Run3 run3 = new Run3("run3");
    run3.start();
    try{
      run3.join();
    }catch(InterruptedException e){
      e.printStackTrace();
    }
    for(int i = 0; i < 10; i++){
      System.out.println("main---" + i);
    }
  }
}

class Run3 extends Thread{
  Run3(String name){
    super(name);
  }

  @Override
  public void run(){
    for(int i = 0; i < 10; i++){
      try{
        sleep(1000);
        System.out.println("run2---" + i + getName());
      }catch(InterruptedException e){
        e.printStackTrace();
      }
    }
  }
}