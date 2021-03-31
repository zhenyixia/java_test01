package com.lyp.basicAPI.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadTest002{
  public static void main(String[] args){
    // 三种创建线程池的方法
    ExecutorService executorService = Executors.newCachedThreadPool();

    ExecutorService executorService1 = Executors.newFixedThreadPool(10);
    ExecutorService executorService2 = Executors.newSingleThreadExecutor();

    // 自定义
    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 0, TimeUnit.MILLISECONDS,
        new ArrayBlockingQueue<Runnable>(10));

    for(int i = 0; i < 1000; i++){
      // executorService.execute(new MyTask(i));
      // executorService1.execute(new MyTask(i));

      // executorService2.execute(new MyTask(i));

      // 在执行30个以后会出现异常：java.util.concurrent.RejectedExecutionException。
      // 为什么是30个？因为最多只有20个线程，队列只能放10个，当接收第31个时，队列放不下，
      // 而所有线程都还在run中，所以就会拒绝。所以第几次拒绝还要参考run运行的速度，
      // 如果速度快的话，也不一定是30个会拒绝。可能是30个以上，但最快拒绝也只能在30个。而实际生产环境则会先预估一个最大值，
      // 然后在最大值的基础上再乘以2或者加上一个系数。就可以了。

      threadPoolExecutor.execute(new MyTask(i));
    }
  }
}

class MyTask implements Runnable{

  int i = 0;

  MyTask(int i){
    this.i = i;
  }

  @Override
  public void run(){
    i++;
    System.out.println(Thread.currentThread().getName() + "--" + i);
    // try{
    //   Thread.sleep(1);
    //   i++;
    //   System.out.println(Thread.currentThread().getName() + "--" + i);
    // }catch(InterruptedException e){
    //   e.printStackTrace();
    // }
  }
}