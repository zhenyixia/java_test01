package com.juc.add;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo{

  public static void main(String[] args){

    // 召唤龙珠的线程
    CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
      System.out.println("召唤神龙成功！");
    });

    for(int i = 0; i < 7; i++){
      final int temp = i;
      new Thread(() -> {
        System.out.println(Thread.currentThread().getName() + "收集" + temp + "个龙珠");
        try{
          cyclicBarrier.await(); // 等待计数器变成7。如果这里循环了6次，则会一直等待
        }catch(InterruptedException e){
          e.printStackTrace();
        }catch(BrokenBarrierException e){
          e.printStackTrace();
        }
      }).start();
    }
  }
}