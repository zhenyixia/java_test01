package com.lyp.interview.computerexam;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 题目描述
 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。

 输入描述:
 输入一个十六进制的数值字符串。注意：一个用例会同时有多组输入数据，
 请参考帖子https://www.nowcoder.com/discuss/276处理多组输入的问题。

 输出描述:
 输出该数值的十进制字符串。不同组的测试用例用\n隔开。

 示例1
 输入
 0xA
 0xAA
 输出
 10
 170
 */
public class CE005 {

  public static void my1() throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = reader.readLine()) != null) {
      line = line.substring(2);
      int result = 0;
      for (int i = 0, length = line.length(); i < length; i++) {
        String c = String.valueOf(line.charAt(i));
        int num;
        if (c.equals("A")) {
          num = 10;
        } else if (c.equals("B")) {
          num = 11;
        } else if (c.equals("C")) {
          num = 12;
        } else if (c.equals("D")) {
          num = 13;
        } else if (c.equals("E")) {
          num = 14;
        } else if (c.equals("F")) {
          num = 15;
        } else {
          num = Integer.parseInt(c);
        }
        result += num * Math.pow(16, length - i - 1);
      }
      System.out.println(result);
    }
  }

  public static void other1() throws Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String input;
    while ((input = bf.readLine()) != null) {
      String temp = input.substring(2, input.length());
      int sum = 0;
      int length = temp.length();
      for (int i = length - 1; i >= 0; i--) {
        char c = temp.charAt(i);
        int tempNum = (int) c;
        if (tempNum >= 65) {
          tempNum = tempNum - 65 + 10;
        } else {
          tempNum = tempNum - 48;
        }
        sum = sum + (int) Math.pow(16, length - i - 1) * tempNum;
      }

      System.out.println(sum);
    }
  }
}
