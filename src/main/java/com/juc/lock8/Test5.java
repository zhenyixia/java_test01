package com.juc.lock8;

import java.util.concurrent.TimeUnit;

// Synchronized 也是非公平锁
public class Test5{
  public static void main(String[] args){
    Phone5 phone5 = new Phone5();
    new Thread(() -> {
      phone5.sms();
    }, "A").start();

    try{
      TimeUnit.SECONDS.sleep(1);
    }catch(InterruptedException e){
      e.printStackTrace();
    }
    new Thread(() -> {
      phone5.sms();
    }, "B").start();
  }
}

class Phone5{
  public synchronized void sms(){
    System.out.println(Thread.currentThread().getName() + " sms ");
    try{
      TimeUnit.SECONDS.sleep(2);
    }catch(InterruptedException e){
      e.printStackTrace();
    }
    call();
  }

  public synchronized void call(){
    System.out.println(Thread.currentThread().getName() + " call");
  }
}