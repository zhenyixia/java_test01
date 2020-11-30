package com.lyp.interview.day03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListRemove {
  public static void main(String[] args) {
    List<Integer> list1 = new ArrayList<>();
    list1.add(1);
    list1.add(3);
    list1.add(2);
    System.out.println("----删除方法1-----");
    System.out.println(list1);
    for (int i = list1.size() - 1; i >= 0; i--) {
      list1.remove(i);
    }
    System.out.println(list1);

    System.out.println("----删除方法2------");
    list1.add(1);
    list1.add(3);
    list1.add(2);
    for (int i = 0; i < list1.size(); i++) {
      list1.remove(i);
      i--;
    }

    System.out.println(list1);

    System.out.println("----删除方法3------");
    list1.add(1);
    list1.add(3);
    list1.add(2);
    Iterator<Integer> iter = list1.iterator();
    while(iter.hasNext()){
      int obj = iter.next();
      iter.remove();
    }


    System.out.println(list1);
  }
}
