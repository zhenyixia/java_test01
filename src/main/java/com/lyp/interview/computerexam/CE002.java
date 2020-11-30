package com.lyp.interview.computerexam;

/**
 * 题目描述 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字母，然后输出输入字符串中该字母的出现次数。不区分大小写。
 *
 * 输入描述: 第一行输入一个由字母和数字以及空格组成的字符串，第二行输入一个字母。
 *
 * 输出描述: 输出输入字符串中含有该字符的个数。
 *
 * 示例1 输入 ABCabc A 输出 2
 */

import java.io.*;

public class CE002 {
  //他人的实现
  public static void main(String[] args) throws IOException {

  }

  public static void other1() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line;
    String c;
    while ((line = reader.readLine()) != null) {
      c = reader.readLine();
      int count = 0;
      for (int i = 0; i < line.length(); i++) {
        if (String.valueOf(line.charAt(i)).equalsIgnoreCase(c)) {
          count++;
        }
      }
      System.out.println(count);
    }
  }

  public static void my1() throws Exception {
    InputStream input = System.in;
    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
    String line1 = reader.readLine();
    InputStream input2 = System.in;
    char c = (char) input2.read();
    char[] chars = line1.toCharArray();
    int count = 0;
    for (char cc : chars) {
      if (cc == c) {
        count++;
      }
    }
    System.out.println(count);
  }
}
