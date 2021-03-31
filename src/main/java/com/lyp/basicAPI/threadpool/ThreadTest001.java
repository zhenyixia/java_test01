package com.lyp.basicAPI.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadTest001{

  public static void main(String[] args) throws InterruptedException{

    long start = System.currentTimeMillis();
    Random random = new Random();
    List<Integer> list = new ArrayList<>();
    for(int i = 0; i < 10000; i++){
      Thread t1 = new Thread(() -> list.add(random.nextInt()));
      t1.start();
      t1.join();
    }

    long end = System.currentTimeMillis();
    System.out.println(end - start + "毫秒，条数： " + list.size());
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    for(int i = 0; i < 10000; i++){
      executorService.execute(() -> list.add(random.nextInt()));
    }
    executorService.shutdown();
    // 当使用awaitTermination时，主线程会处于一种等待的状态，等待线程池中所有的线程都运行完毕后才继续运行。
    executorService.awaitTermination(1, TimeUnit.DAYS);

    long end2 = System.currentTimeMillis();
    System.out.println(end2 - end + "毫秒，条数： " + list.size());
  }
  /**
   * 为什么第二种速度会远远快于第一种，原因在于，第一种创建线程会真正的创建1万个线程，然后才去执行。而第二种只
   * 会创建一个线程，创建线程也是需要消耗资源与时间的。
   */
}

