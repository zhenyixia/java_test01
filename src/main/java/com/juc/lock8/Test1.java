package com.juc.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 8锁，关于锁的8个问题
 */
public class Test1{

  public static void main(String[] args) throws InterruptedException{
    Phone phone = new Phone();
    new Thread(()->{phone.sendSms();},"A").start();
    TimeUnit.SECONDS.sleep(1);
    new Thread(()->{phone.call();},"A").start();
  }

}

class Phone{
  // synchronized 锁的对象是方法的调用者！
  public synchronized void sendSms(){
    System.out.println("sendSms");
  }

  public synchronized void call(){
    System.out.println("call");
  }
}