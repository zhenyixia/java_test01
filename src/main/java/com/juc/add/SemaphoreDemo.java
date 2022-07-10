package com.juc.add;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import org.apache.commons.collections4.ListUtils;

public class SemaphoreDemo{
  public static void main(String[] args){
    // 线程数量： 停车位 限流
    Semaphore semaphore = new Semaphore(3);

    List<String> ss = new ArrayList<>();
    List<List<String>> partition = Lists.partition(ss, 100);
    List<List<String>> partition1 = ListUtils.partition(ss, 100);
    int batchNum = 100;
    for(int i = 0; i < ss.size(); i+=batchNum){
      int toIndex = Math.min(ss.size(),i+batchNum);
      List<String> strings = ss.subList(i, toIndex);
    }

    for(int i = 0; i < 6; i++){
      new Thread(() -> {

        try{
          // acquire() 得到
          semaphore.acquire();
          System.out.println(Thread.currentThread().getName() + "抢到车位");

          // 停车2秒钟
          TimeUnit.SECONDS.sleep(2);
          System.out.println(Thread.currentThread().getName() + "离开车位");
        }catch(InterruptedException e){
          e.printStackTrace();
        }finally{
          semaphore.release();  // release() 释放
        }
      }, String.valueOf(i)).start();
    }
  }
}