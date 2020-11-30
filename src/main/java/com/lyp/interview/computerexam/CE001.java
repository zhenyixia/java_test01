package com.lyp.interview.computerexam;

import java.io.InputStream;

/**
 * 题目描述 计算字符串最后一个单词的长度，单词以空格隔开。
 *
 * 输入描述: 输入一行，代表要计算的字符串，非空，长度小于5000。
 *
 * 输出描述: 输出一个整数，表示输入字符串最后一个单词的长度。 示例1 输入
 *
 * hello nowcoder 输出
 *
 * 8
 */
public class CE001 {
  public static void main(String[] args) throws Exception {
    myTest();
    //    other1();
  }

  public static void other1() throws Exception {
    int times = 0;
    InputStream in = System.in;
    char c = (char) in.read();
    while (c != '\n') {
      if (c == ' ') {
        times = 0;
      } else {
        times += 1;
      }
      c = (char) in.read();
    }

    System.out.println(times);
  }

  public static void myTest() throws Exception {
    InputStream in = System.in;

    char c = (char) in.read();
    int times = 0;
    while (c != '\n') {
      if (c == ' ') {
        times = 0;
      } else {
        times += 1;
      }
      c = (char) in.read();
    }
    System.out.println(times);
  }
}
