package com.lyp.interview.computerexam;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 题目描述 查找两个字符串a,b中的最长公共子串。若有多个，输出在较短串中最先出现的那个。 注：子串的定义：将一个字符串删去前缀和后缀（也可以不删）形成的字符串。请和“子序列”的概念分开！
 *
 * 本题含有多组输入数据！ 输入描述: 输入两个字符串
 *
 * 输出描述: 返回重复出现的字符 示例1 输入 复制 abcdefghijklmnop abcsafjklmnopqrstuvw 输出 复制 jklmnop
 */
public class CE023Todo {
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
    String line = null;
    while ((line = br.readLine()) != null) {
      String str1 = line;
      String str2 = br.readLine();
      if (str1.length() > str2.length()) {
        cal(str2, str1, 0);
      } else {
        cal(str1, str2, 0);
      }
    }
  }

  public static void cal(String minStr, String maxStr, int index) {
    int left = 0;
    int max = 1;
    String res = "";
    while ((left + max <= minStr.length())) {
      String s = minStr.substring(left, left + max);
      if (maxStr.contains(s)) {
        res = s;
        max++;
      } else {
        left++;
      }
    }
    System.out.println(res);
  }
}
