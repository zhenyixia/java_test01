package com.juc.function;

import java.util.function.Function;

/**
 * Function 函数型接口
 */
public class Demo01{
  public static void main(String[] args){
    Function<String, String> function0 = new Function<String, String>(){
      @Override
      public String apply(String o){
        return o + "-0";
      }
    };

    System.out.println(function0.apply("abc")); // abc-0

    // 转为lambda
    Function function1 = (str) -> str + "-1";

    System.out.println(function1.apply("abc")); // abc-1

    System.out.println(function1.apply("abc"));

    Function<Integer, Integer> times2 = i -> i * 2;
    System.out.println(times2.apply(4)); // 8

    Function<Integer, Integer> squared = i -> i * i;
    System.out.println(squared.apply(4)); // 16

    System.out.println(times2.compose(squared).apply(4)); //32

    Function<Integer, Integer> subtract = i -> i - 1;
    System.out.println(times2.compose(times2).compose(subtract).apply(4)); //12

    Function<String, String> identity = Function.identity();
    System.out.println(identity.apply("identity"));  // identity
  }
}