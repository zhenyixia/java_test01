package com.lyp.basicAPI.thread;

public class SyncTest01 implements Runnable{
  Timer timer = new Timer();

  public static void main(String[] args){
    SyncTest01 syncTest01 = new SyncTest01();
    Thread t1 = new Thread(syncTest01);
    Thread t2 = new Thread(syncTest01);
    t1.setName("t1");
    t2.setName("t2");
    t1.start();
    t2.start();
  }

  @Override
  public void run(){
    timer.add(Thread.currentThread().getName());
  }
}

class Timer{
  private static int num = 0;

  // 执行当前方法，锁定当前对象
  public synchronized void add(String name){
    // synchronized(this){ // 必须加互斥锁，否则结果都是：第2个，写法同在方法上加synchronized
      num++;
      try{
        Thread.sleep(1);
      }catch(InterruptedException e){
        e.printStackTrace();
      }
      System.out.println(name + ", 你是第" + num + "个使用timer的线程");
    }
  // }
}