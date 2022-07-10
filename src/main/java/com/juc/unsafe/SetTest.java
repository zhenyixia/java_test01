package com.juc.unsafe;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class SetTest{
  public static void main(String[] args){
    Set<String> set = new HashSet<>();
    // 两种解决方法
    //  Set<String> set = Collections.synchronizedSet(new HashSet<>());
    // Set<String> set = new CopyOnWriteArraySet();

    for(int i = 0; i < 50; i++){
      new Thread(() -> {
        set.add(UUID.randomUUID().toString().substring(0, 15));
        System.out.println(set);
      }, String.valueOf(i)).start();
    }
  }
}