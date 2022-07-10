package com.juc.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo{
  public static void main(String[] args){

    // CAS即为compareAndSet的缩写，这是传统的CAS
    AtomicInteger atomicInteger = new AtomicInteger(2020);

    // 如果期望的值达到了，就更新，否则就不更新. CAS是CPU的并发原语，是CPU的指令。
    atomicInteger.compareAndSet(2020, 2021);

    System.out.println(atomicInteger.get());

    atomicInteger.getAndIncrement();
/*
    boolean b = atomicInteger.compareAndSet(2020, 2022);
    System.out.println(b); // false，不能再更新，因为期望值不一样。
    System.out.println(atomicInteger.get());*/

  }
}