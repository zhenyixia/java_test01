package com.lyp.interview.day02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListCompare {
  public static void main(String[] args) {
    List<Integer> list1 = new ArrayList<>();
    list1.add(1);
    list1.add(3);
    list1.add(2);

    List<Integer> list2 = new ArrayList<>();
    list2.add(1);
    list2.add(3);
    list2.add(2);

    //错误方法1：这种比较会出现，如果list元素为：1，2，3，3而list2元素为：1，2，2，3，这样也会相等
    list1.add(3);
    list2.add(2);
    boolean equ = list1.containsAll(list2) && list1.size() == list2.size();
    System.out.println(equ); // true

    //错误方法2：这种比较也会出现问题，就算两个size不一样，但是只要有共同元素就会报错
    list1.add(2);
    boolean equ2 = list1.containsAll(list2) && list2.containsAll(list1);
    System.out.println(equ2); //true

    //正确方法：
    Collections.sort(list1);
    Collections.sort(list2);
    System.out.println(list1.equals(list2));
  }
}
