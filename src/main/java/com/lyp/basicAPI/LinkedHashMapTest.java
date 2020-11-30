package com.lyp.basicAPI;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {

  public static void main(String[] args) {

    //hashMap存放键值时，是无序的，如下
    Map<String, String> map = new HashMap<>();
    map.put("1", "a");
    map.put("5", "a");
    map.put("3", "a");
    map.put("2", "a");
    map.put("4", "a");
    System.out.println(map);
    System.out.println("----------------------------");

    //linkedHashMap存放键值是有序的，1，存入排序序
    Map<String, String> linkedMap = new LinkedHashMap<>();
    linkedMap.put("1", "a");
    linkedMap.put("5", "a");
    linkedMap.put("3", "a");
    linkedMap.put("2", "a");
    linkedMap.put("4", "a");
    System.out.println(linkedMap);
    System.out.println("----------------------------");

    //2，按读取排序
    Map<String, String> linkedMap2 = new LinkedHashMap<>(5, 0.75f, true);
    linkedMap2.put("1", "a");
    linkedMap2.put("5", "a");
    linkedMap2.put("3", "a");
    linkedMap2.put("2", "a");
    linkedMap2.put("4", "a");
    System.out.println(linkedMap2); //{1=a, 5=a, 3=a, 2=a, 4=a}

    linkedMap2.get("5");
    linkedMap2.get("4");
    linkedMap2.get("3");
    System.out.println(linkedMap2);//{1=a, 2=a, 5=a, 4=a, 3=a}

    /**
     * 结论：
     * 1，linkedHashMap默认是按存入排序，即accessOrder默认值为false.一般业务中使用这个功能的比较多。
     * 2，如果按读取排序，需要在初始化时设置accessOrder为true.从上面的输出可见，如果有读取操作时，linkedHashMap
     * 会把读取的key-value放到末尾。
     */

  }

}
