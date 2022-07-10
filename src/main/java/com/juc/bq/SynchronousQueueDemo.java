package com.juc.bq;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * 同步队列与其它 BlockingQueue不一样，它不存储元素 put 一个元素，必须从里面先take出来，不然不能再put进去
 */
public class SynchronousQueueDemo{
  public static void main(String[] args){

    System.out.println(Runtime.getRuntime().availableProcessors());

    // SynchronousQueue synchronousQueue = new SynchronousQueue();
    BlockingQueue<String> synchronousQueue = new SynchronousQueue<>();

    //同步队列，如何要测出一个进一个出呢？

    new Thread(() -> {
      try{
        System.out.println(Thread.currentThread().getName() + " put 1");
        synchronousQueue.put("1");

        System.out.println(Thread.currentThread().getName() + " put 2");
        synchronousQueue.put("2");

        System.out.println(Thread.currentThread().getName() + " put 3");
        synchronousQueue.put("3");
      }catch(InterruptedException e){
        e.printStackTrace();
      }
    }, "T1").start();

    new Thread(() -> {
      try{
        TimeUnit.SECONDS.sleep(2);
        System.out.println(Thread.currentThread().getName() + "取出：" + synchronousQueue.take());

        TimeUnit.SECONDS.sleep(2);
        System.out.println(Thread.currentThread().getName() + "取出：" + synchronousQueue.take());

        TimeUnit.SECONDS.sleep(2);
        System.out.println(Thread.currentThread().getName() + "取出：" + synchronousQueue.take());
      }catch(InterruptedException e){
        e.printStackTrace();
      }
    }, "T2").start();
  }
}