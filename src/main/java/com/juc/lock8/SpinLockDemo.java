package com.juc.lock8;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 */
public class SpinLockDemo{
  // 默认为null
  AtomicReference<Thread> atomicReference = new AtomicReference<>();

  // 加锁
  public void myLock(){


  }

  // 解锁

  public static void main(String[] args){
    System.out.println(Runtime.getRuntime().availableProcessors());
  }

}