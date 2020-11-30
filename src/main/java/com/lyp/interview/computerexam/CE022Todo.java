package com.lyp.interview.computerexam;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 题目描述
 *
 * 把m个同样的苹果放在n个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？（用K表示）5，1，1和1，5，1 是同一种分法。
 *
 * 数据范围：0<=m<=10，1<=n<=10。 本题含有多组样例输入。
 *
 *
 * 输入描述: 输入两个int整数
 *
 * 输出描述: 输出结果，int型
 *
 * 示例1 输入 复制 7 3 输出 复制 8
 */
public class CE022Todo {
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
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = " ";
    while ((str = br.readLine()) != null) {
      String[] s = str.split(" ");
      int m = Integer.parseInt(s[0]);
      int n = Integer.parseInt(s[1]);
      System.out.println(count(m, n));
    }
  }

  public static int count(int m, int n) {
    if (n == 1 || m == 0) {
      return 1;
    } else if (n > m) {
      return count(m, m);
    } else {
      return count(m, n - 1) + count(m - n, n);
    }
  }
}
