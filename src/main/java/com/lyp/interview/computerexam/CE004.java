package com.lyp.interview.computerexam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 题目描述
 •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。

 输入描述:
 连续输入字符串(输入多次,每个字符串长度小于100)

 输出描述:
 输出到长度为8的新字符串数组

 示例1
 输入
 abc
 123456789
 输出
 abc00000
 12345678
 90000000
 */
public class CE004 {


  public static void main(String[] args) throws IOException {
    System.out.println(1/8);
    System.out.println(1%8);
    my1();
  }

  /**
   * 通过！ 9ms 9244k
   * @throws IOException
   */
  public static void my2() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while((line=reader.readLine())!=null){
      int length = line.length();
      int mod = length % 8;
      if(mod!=0){
        int needAdd = 8- mod;
        for(int i=0;i<needAdd;i++){
          line+="0";
        }
      }
      for(int j=0;j<line.length();j+=8){
        String temp = line.substring(j,j+8);
        System.out.println(temp);
      }
    }
  }

  /**
   * 通过率80%，不知道还有哪20%？
   * 到找原因，如果输入8位字符串，会多输一行
   * @throws IOException
   */
  public static void my1() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while((line=reader.readLine())!=null){
      if(line.equals("")){
        continue;
      }
      line = line.trim();
      int length = line.length();
      int mod = length % 8;
      int needAdd = 8- mod;
      for(int i=0;i<needAdd;i++){
        line+="0";
      }
      for(int j=0;j<line.length();j+=8){
        String temp = line.substring(j,j+8);
        System.out.println(temp);
      }
    }
  }
}
