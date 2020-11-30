package com.lyp.basicAPI;

public class MathRandomTest {

  public static void main(String[] args) {

    //返回一个 >=0,<1的double型数字
    double d = Math.random();
    System.out.println(d);

    // 乘以n后，强转的数字一定会小于n
    int i = (int) (d * 5);
    System.out.println(i);
    System.out.println((int) 4.9999);
  }


}
