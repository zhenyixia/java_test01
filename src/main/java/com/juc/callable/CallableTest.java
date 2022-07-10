package com.juc.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest{

  public static void main(String[] args) throws ExecutionException, InterruptedException{
    // new Thread(new Runnable()).start();
    // new Thread(new FutureTask<V>()).start();  // 为Runnable实现类
    // new Thread(new FutureTask<V>(Callable)).start(); // FutureTask支持Callable
    new Thread(new RunnableThread()).start();

    CallableThread thread = new CallableThread();
    FutureTask<String> futureTask = new FutureTask(thread);
    new Thread(futureTask,"A").start();
    new Thread(futureTask,"B").start(); // 只会打一次，结果会缓存
    String o = futureTask.get(); // get方法可能产生阻塞，要等待返回结果，一般把它放到最后，或用异步通信来处理
    System.out.println(o);

  }
}

class CallableThread implements Callable<String>{

  @Override
  public String call() throws Exception{
    System.out.println(123);
    return "abc";
  }
}

class RunnableThread implements Runnable{

  @Override
  public void run(){

  }
}

