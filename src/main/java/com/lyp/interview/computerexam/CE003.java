package com.lyp.interview.computerexam;

import java.io.*;
import java.util.*;

/**
 * 题目描述 明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性， 他先用计算机生成了N个1到1000之间的随机整数（N≤1000），对于其中重复的数字，只保留一个，把其余相同的数去掉，
 * 不同的数对应着不同的学生的学号。然后再把这些数从小到大排序，按照排好的顺序去找同学做调查。请 你协助明明完成“去重”与“排序”的工作(同一个测试用例里可能会有多组数据，希望大家能正确处理)。
 *
 *
 * 注：测试用例保证输入参数的正确性，答题者无需验证。测试用例不止一组。
 *
 * 当没有新的输入时，说明输入结束。
 *
 * 输入描述: 注意：输入可能有多组数据。每组数据都包括多行，第一行先输入随机整数的个数N， 接下来的N行再输入相应个数的整数。具体格式请看下面的"示例"。
 *
 * 输出描述: 返回多行，处理后的结果
 *
 * 示例1 输入 3 2 2 1 2 5 5 输出 1 2 5 说明 样例输入解释： 样例有两组测试 第一组是3个数字，分别是：2，2，1。 第二组是2个数字，分别是：5,5。
 */
public class CE003 {
  public static void main(String[] args) throws IOException {

  }

  /**
   * 别人的解题，待研究
   */

  public static void other1(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String str;
    while ((str = bf.readLine()) != null) {
      boolean[] stu = new boolean[1001];
      StringBuilder sb = new StringBuilder();
      int n = Integer.parseInt(str);
      for (int i = 0; i < n; i++) {
        stu[Integer.parseInt(bf.readLine())] = true;
      }
      for (int i = 0; i < 1001; i++) {
        if (stu[i]) {
          sb.append(i).append("\n");
        }
      }
      sb.deleteCharAt(sb.length() - 1);
      System.out.println(sb.toString());
    }
  }

  /**
   * 自己原来思路
   */
  public static void my1(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line;
    boolean first = true;
    int total = 0;
    int count = 0;
    Set<Integer> arrSet = new HashSet<>();
    while ((line = reader.readLine()) != null) {
      int num = Integer.parseInt(line);
      if (first) {
        total = num;
        first = false;
        continue;
      }
      if (total == count) {
        first = true;
        count = 0;
        total = 0;
      }
      arrSet.add(num);
      count += 1;
    }
    ArrayList<Integer> arrList = new ArrayList<>(arrSet);
    Collections.sort(arrList);
    for (int i : arrList) {
      System.out.println(i);
    }
  }

  /**
   * 自己思路改进后通过
   */
  public static void my2(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line;
    boolean first = true;
    int total = 0;
    int count = 0;
    Set<Integer> arrSet = new HashSet<>();
    while ((line = reader.readLine()) != null) {
      int num = Integer.parseInt(line);
      if (first) {
        total = num;
        first = false;
        continue;
      }

      arrSet.add(num);
      count += 1;

      if (total == count) {
        first = true;
        count = 0;

        ArrayList<Integer> arrList = new ArrayList<>(arrSet);
        Collections.sort(arrList);
        for (int i : arrList) {
          System.out.println(i);
        }
        arrSet.clear();
      }
    }
  }
}

