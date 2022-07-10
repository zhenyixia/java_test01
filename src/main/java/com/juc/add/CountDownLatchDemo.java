package com.juc.add;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo{
  public static void main(String[] args) throws InterruptedException{
    // 总数是6
    CountDownLatch countDownLatch = new CountDownLatch(6);
    for(int i = 0; i < 6; i++){
      new Thread(() -> {
        System.out.println(Thread.currentThread().getName() + " go out");
        countDownLatch.countDown();
      }, String.valueOf(i)).start();
    }

    countDownLatch.await(); // 等待计数器归零，然后再向下执行 注意：这里是await不是wait写成wait会报错

    System.out.println("close Door");
  }
}