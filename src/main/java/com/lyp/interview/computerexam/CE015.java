package com.lyp.interview.computerexam;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 题目描述 实现函数 int sqrt(int x). 计算并返回x的平方根 示例1 输入 2 返回值 1
 */
public class CE015 {
  public static void main(String[] args) throws Exception {
        my01();
//    other01();
  }

  public static void my01() throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = reader.readLine()) != null) {
      int sqr = Integer.parseInt(line);
      int left = 1;
      int right = sqr;
      int result = 0;
      while (left <= right) {
        int mid = (left + right) / 2;
        if (mid * mid <= sqr && (mid + 1) * (mid + 1) > sqr) {
          result = mid;
          break;
        } else if (mid * mid < sqr) {
          left = mid;
        } else {
          right = mid;
        }
      }
      if (result == 0) {
        result = left;
      }
      System.out.println(result);
    }
  }

  public static void other01() throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = reader.readLine()) != null) {
      int x = Integer.parseInt(line);
      long left = 1;
      long right = x;
      while (left < right) {
        long middle = (left + right) / 2;
        if (middle * middle <= x && (middle + 1) * (middle + 1) > x) {
          System.out.println((int) middle);
          break;
        } else if (middle * middle < x) {
          left = middle;
        } else {
          right = middle;
        }
      }
      System.out.println((int) left);
    }
  }
}
