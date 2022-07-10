package com.juc.function;

import java.util.function.Supplier;

/**
 * Supplier 供给型接口，没有参数，只有返回值
 */
public class Demo04{

  public static void main(String[] args){
    Supplier<String> supplier = new Supplier<String>(){
      @Override
      public String get(){
        System.out.println("get()");
        return "1024";
      }
    };

    Supplier<String> supplier2 = () -> {
      System.out.println("get()");
      return "1024";
    };

    System.out.println(supplier.get());
    System.out.println(supplier2.get());
  }
}