package com.juc.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 在B类的基础上做精准通知 A执行完通知调用 B，然后通知调用C，然后调用A
 */
public class C{
  public static void main(String[] args){
    Data3 data = new Data3();

    new Thread(() -> {
      for(int i = 0; i < 10; i++){
        data.printA();
      }
    }, "A").start();

    new Thread(() -> {
      for(int i = 0; i < 10; i++){
        data.printB();
      }
    }, "B").start();

    new Thread(() -> {
      for(int i = 0; i < 10; i++){
        data.printC();
      }
    }, "C").start();
  }
}

//总结为： 判断是否要等待，业务 ，通知
class Data3{

  private Lock lock = new ReentrantLock();

  private Condition condition1 = lock.newCondition();

  private Condition condition2 = lock.newCondition();

  private Condition condition3 = lock.newCondition();

  private int number = 1; // 1 A 2 B 3 C

  public void printA(){
    lock.lock();
    try{
      while(number != 1){
        //等待
        condition1.await();
      }

      System.out.println(Thread.currentThread().getName() + "==>A");

      // 唤醒，指定的线程
      number = 2;
      condition2.signal();
    }catch(Exception e){
      e.printStackTrace();
    }finally{
      lock.unlock();
    }
  }

  public void printB(){
    lock.lock();
    try{
      while(number != 2){
        //等待
        condition2.await();
      }

      System.out.println(Thread.currentThread().getName() + "==>B");

      // 唤醒，指定的线程
      number = 3;
      condition3.signal();
    }catch(Exception e){
      e.printStackTrace();
    }finally{
      lock.unlock();
    }
  }

  public void printC(){
    lock.lock();
    try{
      while(number != 3){
        //等待
        condition3.await();
      }

      System.out.println(Thread.currentThread().getName() + "==>C");

      // 唤醒，指定的线程
      number = 1;
      condition1.signal();
    }catch(Exception e){
      e.printStackTrace();
    }finally{
      lock.unlock();
    }
  }

  // 生产线： 下单--》支付--》交易--》物流
}