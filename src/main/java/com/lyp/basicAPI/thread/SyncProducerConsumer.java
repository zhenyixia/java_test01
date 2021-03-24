package com.lyp.basicAPI.thread;

import org.apache.commons.beanutils.PropertyUtils;

public class SyncProducerConsumer{
  public static void main(String[] args){

    SyncStack ss = new SyncStack();
    Producer p = new Producer(ss);
    Producer p2 = new Producer(ss);
    Producer p3 = new Producer(ss);
    Consumer c = new Consumer(ss);
    new Thread(p).start();
    // new Thread(p2).start();
    // new Thread(p3).start();
    new Thread(c).start();
  }
}

class Bread{
  int id;

  public Bread(int id){
    this.id = id;
  }

  @Override
  public String toString(){
    return "Bread{" + "id=" + id + '}';
  }
}

class SyncStack{
  int index = 0;

  Bread[] breads = new Bread[6];

  public synchronized void push(Bread bread){
    //如果用if，当wait被打断的时候，就会继续往下执行到notify，而此时index如果仍然最大值breads.length，
    // 继续走下去index将大于breads.length，就会出错。所以一般用while，即使被打断，再次判断是否等于breads.length
    // 消费者的pop同理
    // if(index == breads.length){
    while(index == breads.length){

      try{
        // 当前正在访问此对象的线程 wait，只有在synchonized下才能wait。wait的时候，锁就释放了。
        // wait需要唤醒，如果没有唤醒，则会挂掉。
        this.wait();
      }catch(InterruptedException e){
        e.printStackTrace();
      }
    }
    // notify 叫醒一个正在wait的线程，一般与wait一一对应的使用。与wait一样都是Object的方法。
    // notifyAll 叫醒其它多个线程执行
    this.notify();
    breads[index] = bread;
    index++;
  }

  public synchronized Bread pop(){
    if(index == 0){
      try{
        this.wait();
      }catch(InterruptedException e){
        e.printStackTrace();
      }
    }
    this.notify();
    index--;
    return breads[index];
  }
}

class Producer implements Runnable{
  SyncStack ss = null;

  Producer(SyncStack ss){
    this.ss = ss;
  }

  @Override
  public void run(){
    for(int i = 0; i < 15; i++){
      Bread bread = new Bread(i);
      ss.push(bread);
      System.out.println("生产了： " + bread);
      try{
        Thread.sleep(100);
      }catch(InterruptedException e){
        e.printStackTrace();
      }
    }
  }
}

class Consumer implements Runnable{
  SyncStack ss = null;

  Consumer(SyncStack ss){
    this.ss = ss;
  }

  @Override
  public void run(){
    for(int i = 0; i < 20; i++){
      Bread bread = ss.pop();
      System.out.println("消费了： " + bread);
      try{
        Thread.sleep(1000);
      }catch(InterruptedException e){
        e.printStackTrace();
      }
    }
  }
}