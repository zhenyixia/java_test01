package com.juc.unsafe;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

// java.util.ConcurrentModificationException 并发修改异常？
public class ListTest{
  public static void main(String[] args){
    // List<String> strings = Arrays.asList("1", "2", "3");
    // strings.forEach(System.out::println);

    /**
     * 解决方法：
     * 1,List<String> list = new Vector<>();
     * 2,List<String> list = Collections.synchronizedList(new ArrayList<>());
     * 3，List<String> list = new CopyOnWriteArrayList<>();
     */

    // 写入时复制，简称COW 是计算机程序设计领域的一种优化策略
    // 多个线程调用的时候 list 读取的时候，固定的。写入（可能存在覆盖）的。
    // CopyOnWriteArrayList 在写入的时候避免覆盖，造成数据问题
    // CopyOnWriteArrayList 比Vector好在哪里， 1，只要有synchronized效率比较低。CopyOnWriteArrayList用的Lock锁
    List<String> list = new CopyOnWriteArrayList<>();
    for(int i = 0; i < 10; i++){
      // list.add(UUID.randomUUID().toString().substring(0,5));
      new Thread(() -> {
        list.add(UUID.randomUUID().toString().substring(0, 5));
        System.out.println(list);
      }, String.valueOf(i)).start();
    }
  }
}