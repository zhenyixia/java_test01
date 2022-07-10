package com.juc.lock8;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Synchronized 也是非公平锁
public class Test6{
  public static void main(String[] args){
    Phone5 phone5 = new Phone5();
    new Thread(() -> {
      phone5.sms();
    }, "A").start();

    new Thread(() -> {
      phone5.sms();
    }, "B").start();
  }
}

class Phone6{
  Lock lock = new ReentrantLock();

  public void sms(){
    lock.lock(); // 细节问题
    // lock锁必须配对，否则会死锁
    try{
      System.out.println(Thread.currentThread().getName() + " sms ");
      call(); // 这里也有锁
    }finally{
      lock.unlock();
    }
  }

  public void call(){
    lock.lock();

    try{
      System.out.println(Thread.currentThread().getName() + " call");
    }finally{
      lock.unlock();
    }
  }
}