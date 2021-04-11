package com.lyp.basicAPI.fanxing;

import java.math.BigDecimal;

public class Generic<T extends Number>{
  private T key;

  public Generic(T key) {
    this.key = key;
  }

  public T getKey(){
    return key;
  }

  //在泛型方法中添加上下边界限制的时候，必须在权限声明与返回值之间的<T>上添加上下边界，即在泛型声明的时候添加
  //public <T> T showKeyName(Generic<T extends Number> container)，编译器会报错："Unexpected bound"
  public <T extends Number> T showKeyName(Generic<T> container){
    System.out.println("container key :" + container.getKey());
    T test = container.getKey();
    return test;
  }

  public static void main(String[] args){
    BigDecimal decimal = new BigDecimal("123");
    Generic<BigDecimal> bigDecimalGeneric = new Generic<>(decimal);
    System.out.println(bigDecimalGeneric.showKeyName(bigDecimalGeneric));
  }
}