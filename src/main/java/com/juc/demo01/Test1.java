package com.juc.demo01;

public class Test1{

  public static void main(String[] args){
    //获取cpu的核数
    // cpu密集型，io密集型
    System.out.println(Runtime.getRuntime().availableProcessors());

    // Thread.State

    // TimeUnit.DAYS.sleep(1);
  }

}