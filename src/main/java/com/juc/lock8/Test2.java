package com.juc.lock8;

import java.util.concurrent.TimeUnit;

public class Test2{
  public static void main(String[] args) throws InterruptedException{
    Phone2 phone1 = new Phone2();
    Phone2 phone2 = new Phone2();
    new Thread(() -> {
      try{
        phone1.sendSms();
      }catch(InterruptedException e){
        e.printStackTrace();
      }
    }, "A").start();
    TimeUnit.SECONDS.sleep(1);
    new Thread(() -> {phone2.call();}, "B").start();
  }
}

class Phone2{
  // synchronized 锁的对象是方法的调用者！
  public synchronized void sendSms() throws InterruptedException{
    TimeUnit.SECONDS.sleep(3);
    System.out.println("sendSms");
  }

  public synchronized void call(){
    System.out.println("call");
  }

  public void hello(){
    System.out.println("hello");
  }
}