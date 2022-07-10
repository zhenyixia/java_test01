package com.juc.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicReferenceDemo{
  public static void main(String[] args){
    Integer expect = 2020;
    Integer newReference = 2021;
    AtomicStampedReference<Integer> atomicReference = new AtomicStampedReference<>(expect, 1);
    // 想要A做的操作，B是知道的。
    new Thread(() -> {
      int stamp = atomicReference.getStamp();// 获得版本号
      System.out.println("a1 " + stamp); // 1

      try{
        TimeUnit.SECONDS.sleep(1);
      }catch(InterruptedException e){
        e.printStackTrace();
      }

      // 巨坑：这里返回false，是因为expectedReference中传入的是一个对象，而值为2020的Integer类型不属于缓存（-128-127）之间的值，
      // 每次会创建一个新的Integer对象，导致期望对象与初始对象不是同一个对象，导致比较并交换执行失败。
      // 解决方法有两个：1，修改值为-128到127之间的值；2，定义变量引用
      System.out.println(atomicReference.compareAndSet(expect, newReference, atomicReference.getStamp(),
          atomicReference.getStamp() + 1));
      System.out.println("a2 " + atomicReference.getStamp()); // 1 原来期望为2，因为上面的巨坑，导致修改失败

      System.out.println(atomicReference.compareAndSet(newReference, expect, atomicReference.getStamp(),
          atomicReference.getStamp() + 1));
      System.out.println("a3 " + atomicReference.getStamp()); // 1 原来期望为3，因为上面的巨坑，导致修改失败
    }, "A").start();

    new Thread(() -> {
      int stamp = atomicReference.getStamp();// 获得版本号
      System.out.println("b1 " + stamp);
      try{
        TimeUnit.SECONDS.sleep(2);
      }catch(InterruptedException e){
        e.printStackTrace();
      }

      System.out.println(atomicReference.compareAndSet(expect, 666, stamp, stamp + 1));
      System.out.println("b2 " + stamp);
      // atomicReference.compareAndSet(2021, 2022, atomicReference.getStamp(), atomicReference.getStamp() + 1);
      // System.out.println("b3" + stamp);
    }, "B").start();
  }
}