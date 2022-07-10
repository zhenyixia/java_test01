package com.juc.function;

import java.util.function.Predicate;

/**
 * 断定型接口：有一个输入参数，返回值只能是布尔值！
 */
public class Demo02{
  public static void main(String[] args){
   /* Predicate<String> predicate = new Predicate<String>(){
      @Override
      public boolean test(String s){
        return false;
      }
    };

    System.out.println(predicate.test("abc"));*/

    // 判断字符串是否为空
    /*Predicate<String> predicate = new Predicate<String>(){
      @Override
      public boolean test(String s){
        return s == null || s.isEmpty();
      }
    };*/

    // 简化为lambda
    Predicate<String> predicate = (s) -> {return s == null || s.isEmpty();};
    Predicate<String> predicate1 = s -> s == null || s.isEmpty();

    System.out.println(predicate.test("abc"));
    System.out.println(predicate.test(""));
  }
}