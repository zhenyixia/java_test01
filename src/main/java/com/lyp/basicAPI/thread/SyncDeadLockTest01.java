package com.lyp.basicAPI.thread;

public class SyncDeadLockTest01 implements Runnable{
  private int flag = 0;

  static Object o1 = new Object(), o2 = new Object();

  public static void main(String[] args) throws InterruptedException{
    SyncDeadLockTest01 syncDeadLockTest01 = new SyncDeadLockTest01();
    Thread t1 = new Thread(syncDeadLockTest01);
    t1.setName("t1");
    Thread t2 = new Thread(syncDeadLockTest01);
    t2.setName("t2");
    syncDeadLockTest01.flag = 1;
    t1.start();
    Thread.sleep(10);
    syncDeadLockTest01.flag = 2;
    t2.start();
  }

  @Override
  public void run(){
    System.out.println("flag = " + flag);
    if(flag == 1){
      synchronized(o1){
        System.out.println(Thread.currentThread().getName());
        try{
          Thread.sleep(500);
        }catch(InterruptedException e){
          e.printStackTrace();
        }

        synchronized(o2){
          System.out.println("1");
        }
      }
    }

    if(flag == 2){
      synchronized(o2){
        System.out.println(Thread.currentThread().getName());
        try{
          Thread.sleep(500);
        }catch(InterruptedException e){
          e.printStackTrace();
        }

        synchronized(o1){
          System.out.println("2");
        }
      }
    }
  }
}