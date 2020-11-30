package com.lyp.interview.computerexam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 题目描述
 找出给定字符串中大写字符(即'A'-'Z')的个数。

 输入描述:
 本题含有多组样例输入
 对于每组样例，输入一行，代表待统计的字符串

 输出描述:
 对于每组样例，输出一个整数，代表字符串中大写字母的个数

 示例1
 输入
 add123#$%#%#O
 150175017(&^%&$vabovbao
 输出
 1
 0
 */
public class CE011 {
  public static void main(String[] args) throws Exception {
    my1();
  }

  /**
   * 6ms 9292k
   */
  public static void my1() throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while((line=reader.readLine())!=null){
      char[] input = line.toCharArray();
      int count =0;
      for(char c:input){
        if(c>='A' && c<='Z'){
          count+=1;
        }
      }
      System.out.println(count);
    }
  }


}
