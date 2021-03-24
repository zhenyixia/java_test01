package com.lyp.basicAPI;

public class MathExact{

  public static void main(String[] args){
    byte e = -128;
    byte f = 127;

    System.out.println(Math.decrementExact(e));
    System.out.println(Math.incrementExact(f));

    System.out.println(Math.addExact(f, 1));
    System.out.println(Math.subtractExact(e, 1));

    System.out.println(Math.multiplyExact(e, 2));

    System.out.println(Math.negateExact(e));
  }
}