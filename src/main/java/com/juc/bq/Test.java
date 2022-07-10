package com.juc.bq;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Test{
  public static void main(String[] args){
    // test1();
    test2();
  }

  /**
   * 抛出异常
   */
  public static void test1(){
    // 队列大小
    ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);
    System.out.println(arrayBlockingQueue.add("a"));
    System.out.println(arrayBlockingQueue.add("b"));
    System.out.println(arrayBlockingQueue.add("c"));

    System.out.println(arrayBlockingQueue.element());//查看队首元素是谁

    // 超出容量，抛出异常
    // System.out.println(arrayBlockingQueue.add("d"));

    // 取出
    System.out.println(arrayBlockingQueue.remove());
    System.out.println(arrayBlockingQueue.remove());
    System.out.println(arrayBlockingQueue.remove());

    // 没有元素，抛出异常
    System.out.println(arrayBlockingQueue.remove());


  }

  public static void test2(){
    ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);

    System.out.println(arrayBlockingQueue.offer("a"));
    System.out.println(arrayBlockingQueue.offer("b"));
    System.out.println(arrayBlockingQueue.offer("c"));

    System.out.println(arrayBlockingQueue.peek()); // 检测队首元素

    // 不抛出异常 false
    System.out.println(arrayBlockingQueue.offer("d"));

    System.out.println(arrayBlockingQueue.poll());
    System.out.println(arrayBlockingQueue.poll());
    System.out.println(arrayBlockingQueue.poll());

    // 不抛出异常 null
    System.out.println(arrayBlockingQueue.poll());
  }

  /**
   * 等待，阻塞，一直阻塞
   */
  public static void test3() throws InterruptedException{
    ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);
    arrayBlockingQueue.put("a");
    arrayBlockingQueue.put("b");
    arrayBlockingQueue.put("c");
    // arrayBlockingQueue.put("d"); // 会一直等

    System.out.println(arrayBlockingQueue.take());
    System.out.println(arrayBlockingQueue.take());
    System.out.println(arrayBlockingQueue.take());

    System.out.println(arrayBlockingQueue.take()); // 会一直等
  }

  /**
   * 等待，阻塞，超时阻塞
   */
  public static void test4() throws InterruptedException{
    ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);
    System.out.println(arrayBlockingQueue.offer("a"));
    System.out.println(arrayBlockingQueue.offer("b"));
    System.out.println(arrayBlockingQueue.offer("c"));
    arrayBlockingQueue.offer("d",1, TimeUnit.SECONDS); // 等待超时，退出

    arrayBlockingQueue.poll();
    arrayBlockingQueue.poll();
    arrayBlockingQueue.poll();

    arrayBlockingQueue.poll(2,TimeUnit.SECONDS); // 超时退出

  }
}