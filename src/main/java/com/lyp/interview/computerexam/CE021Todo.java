package com.lyp.interview.computerexam;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 题目描述 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)，换行表示结束符，不算在字符里。不在范围内的不作统计。多个相同的字符只计算一次 例如，对于字符串abaca而言，有a、b、c三种不同的字符，因此输出3。 输入描述:
 * 输入一行没有空格的字符串。
 *
 * 输出描述: 输出范围在(0~127)字符的个数。
 *
 * 示例1 输入 复制 abc 输出 复制 3
 */
public class CE021Todo {
  public static void main(String[] args) throws Exception {
    //    my01();
    other01();
  }

  public static void my01() throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = reader.readLine()) != null) {

    }
  }

  public static void other01() throws Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String input;
    int counter = 0;

    while ((input = bf.readLine()) != null) {

      boolean[] flag = new boolean[128];

      for (int i = 0; i < input.length(); i++) {

        if (flag[input.charAt(i)] == false) {
          counter++;
          flag[input.charAt(i)] = true;
        }
      }

      System.out.println(counter);
    }
  }
}
