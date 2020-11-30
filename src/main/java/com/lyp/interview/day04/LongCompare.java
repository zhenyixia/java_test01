package com.lyp.interview.day04;

public class LongCompare {
  public static void main(String[] args) {
    Long l1 = 127L;
    Long l2 = 127L;
    //在-128--127范围内，用的是缓存池中的数据
    System.out.println(l1 == l2); // true

    l1 = 128L;
    l2 = 128L;
    //不在-128--127范围内，需要new一个对象，所以用==号比是false
    System.out.println(l1 == l2); //false

    //这里的equals相当于调用的longValue()方法。
    System.out.println(l1.equals(l2));//true
    System.out.println(l1.longValue()==l2.longValue());//true

    long l3 = 128L;
    //Long与long用==相比，会自动拆箱比较
    System.out.println(l1 == l3);//true
  }
}
