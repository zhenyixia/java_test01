package com.lyp.interview.computerexam;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 题目描述 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
 *
 * 输入描述: 输入一个整数（int类型）
 *
 * 输出描述: 这个数转换成2进制后，输出1的个数
 *
 * 示例1 输入 5 输出 2
 */
public class CE017 {
  public static void main(String[] args) throws Exception {
    my01();
    //    other01();

  }

  public static void my01() throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = reader.readLine()) != null) {
      int ori = Integer.parseInt(line);
      String oriStr = Integer.toBinaryString(ori);

      int count = 0;
      String[] allChar = oriStr.split("");
      for (String str : allChar) {
        if (str.equals("1")) {
          count++;
        }
      }
      System.out.println(count);
    }
  }

  public static void other01() throws Exception {
    InputStream stream = System.in;
    int length;
    byte[] bytes = new byte[1024];
    while ((length = stream.read(bytes)) > 0) {
      String numStr = new String(bytes, 0, length - 1);
      int num = Integer.parseInt(numStr);
      char[] numChars = Integer.toBinaryString(num).toCharArray();
      int countNum = 0;
      for (int i = 0; i < numChars.length; i++) {
        if (numChars[i] == '1') {
          countNum = countNum + 1;
        }
      }
      System.out.println(countNum);
    }
  }
}
