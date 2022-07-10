package com.juc.unsafe;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * java.util.ConcurrentModificationException
 */
public class MapTest{
  public static void main(String[] args){
    // map是这样用的吗？ 不是，工作中不用HashMap
    // 默认等价于什么？  加载因子，初始容量 new HashMap<>(16,0.75);
    // Map<String, String> map = new HashMap<>();

    // 唯一的一个家庭作业，研究ConcurrentHashMap的原理 ？？？
    Map<String, String> map = new ConcurrentHashMap<>();

    for(int i = 0; i < 30; i++){
      new Thread(() -> {
        map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 5));
        System.out.println(map);
      }, String.valueOf(i)).start();
    }
  }
}