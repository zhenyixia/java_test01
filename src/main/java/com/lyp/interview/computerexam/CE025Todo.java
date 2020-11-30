package com.lyp.interview.computerexam;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 题目描述
 功能:等差数列 2，5，8，11，14。。。。

 输入:正整数N >0

 输出:求等差数列前N项和

 本题为多组输入，请使用while(cin>>)等形式读取数据

 输入描述:
 输入一个正整数。

 输出描述:
 输出一个相加后的整数。

 示例1
 输入
 复制
 2
 输出
 复制
 7
 *
 */
public class CE025Todo {
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
    String str = "";
    while((str=br.readLine())!=null){
      int n = Integer.parseInt(str);
      System.out.println((3*n*n+n)/2);
    }
  }
}
