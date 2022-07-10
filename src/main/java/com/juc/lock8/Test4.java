package com.juc.lock8;

import java.util.concurrent.TimeUnit;

public class Test4{
  public static void main(String[] args) throws InterruptedException{
    // 两个Class类模板只有一个
    Phone4 phone1 = new Phone4();
    Phone4 phone2 = new Phone4();
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

class Phone4{
  // synchronized 锁的对象是方法的调用者！
  // static静态方法 的锁是class即 Phone4.class 全局唯一的。
  public static synchronized void sendSms() throws InterruptedException{
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