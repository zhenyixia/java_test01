package com.lyp.basicAPI;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class MapTest {

  @Test
  public void mapNewMethodTest() {

    Map<String, String> map = new HashMap<>();
    map.put("a", "aValue");

    System.out.println("----compute()。1，如果有key，取新的计算值为value；2，如果没有key，则插入key，并取新的计算为val");
    String b = map.compute("b", (k, v) -> "bValue");
    System.out.println(b);
    System.out.println(map);

    b = map.compute("b", (k, v) -> "bValue2");
    System.out.println(b);
    System.out.println(map);

    System.out.println("----computeIfAbsent().1，如果有key则取对应的value；2，如果没有key，则取新的计算");
    String c = map.computeIfAbsent("c", v -> "cValue");
    System.out.println(c);
    System.out.println(map);

    c = map.computeIfAbsent("c", v -> "cValue2");
    System.out.println(c);
    System.out.println(map);

    System.out.println("----computeIfPresent().1，如果有key则取对应的计算，如果计算结果为null，则删除key；2，如果没有key，则不操作");
    String d = map.computeIfPresent("d", (k, v) -> "dValue");
    System.out.println(d);
    System.out.println(map);
    d = map.computeIfPresent("c", (k, v) -> null);
    System.out.println(d);
    System.out.println(map);

    System.out.println("----putIfAbsent().1，如果有key则不操作，但是如果key对应的value为null，则取新的value；2，如果没有key，则取新的value");
    map.put("e", null);
    String e = map.putIfAbsent("e", "eValue");
    System.out.println(e);
    System.out.println(map);
    e = map.putIfAbsent("e", "eValue2");
    System.out.println(e);
    System.out.println(map);

    System.out.println("----getOrDefault");
    System.out.println(map.getOrDefault("f", "f is null."));

    System.out.println("----replace().1，replace(k,v)直接替换为v；2，replace(k,oldV,newV)只有k和oldV两个值都匹配才替换");
    String replace = map.replace("e", "eReplace");
    System.out.println(replace);
    System.out.println(map);
    boolean replace1 = map.replace("e", "old", "newReplace");
    System.out.println(replace1);
    System.out.println(map);

    System.out.println("----merge(k,newVal,BigFunction); 1,newVal不能为null。2，如果key不存在，或对应的val为null，则直接取newVal;3,如果key存在则取计算结果");
    map.put("m", "mValue");
    String merge = map.merge("g", "mMerge", (oldV, newV) -> oldV + newV);
    System.out.println(merge);
    System.out.println(map);

    System.out.println("----remove();1,只传key则直接删除对应的key和value，如果key不存在则不删除；2，如果传key和value，则两者必须都对应才能删除成功");
    System.out.println(map.remove("m"));
    System.out.println(map);
    System.out.println(map.remove("g", "g"));
    System.out.println(map);
  }
}
