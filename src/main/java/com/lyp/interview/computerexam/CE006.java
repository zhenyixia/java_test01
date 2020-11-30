package com.lyp.interview.computerexam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 题目描述
 给定n个字符串，请对n个字符串按照字典序排列。
 输入描述:
 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
 输出描述:
 数据输出n行，输出结果为按照字典序排列的字符串。
 示例1
 输入

 9
 cap
 to
 cat
 card
 two
 too
 up
 boat
 boot

 输出

 boat
 boot
 cap
 card
 cat
 to
 too
 two
 up
 */
public class CE006 {
  public static void main(String[] args) throws Exception {
    my1();
  }

  public static void my1() throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = reader.readLine()) != null) {
      int total = Integer.parseInt(line);
      ArrayList allStr = new ArrayList<>();
      for (int i = 0; i < total; i++) {
        String str = reader.readLine();
        allStr.add(str);
      }
      Collections.sort(allStr);
      //      Collections.sort(allStr, Comparator.reverseOrder());
      for (int j = 0; j < total; j++) {
        System.out.println(allStr.get(j));
      }
    }
  }

  public static void other1() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = null;
    while ((str = br.readLine()) != null) {

      Integer count = Integer.parseInt(str);
      String[] strings = new String[count];

      for (int i = 0; i < count; i++) {
        String str2 = br.readLine();
        strings[i] = str2;
      }

      Arrays.sort(strings);
      StringBuffer stringBuffer = new StringBuffer();

      for (String string : strings) {
        stringBuffer.append(string);
        stringBuffer.append("\n");
      }

      stringBuffer.deleteCharAt(stringBuffer.length() - 1);
      System.out.println(stringBuffer.toString());
    }
  }

  public static void other2() throws Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int count = Integer.parseInt(bf.readLine());
    String[] result = new String[count];
    for (int i = 0; i < count; i++) {
      result[i] = bf.readLine();
    }
    StringBuilder sb = new StringBuilder();
    Arrays.sort(result, Comparator.reverseOrder());
    for (String w : result) {
      sb.append(w).append('\n');
    }
    System.out.println(sb.toString());
  }
}
