package com.lyp.interview.computerexam;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 题目描述
 接受一个只包含小写字母的字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）

 输入描述:
 输入一行，为一个只包含小写字母的字符串。

 输出描述:
 输出该字符串反转后的字符串。

 示例1
 输入
 abcd
 输出
 dcba
 */
public class CE008 {
  public static void main(String[] args) throws Exception {
    other1();
  }

  /**
   * 7ms 9316k
   * @throws Exception
   */
  public static void my1() throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while((line=reader.readLine())!=null){
      StringBuilder sb = new StringBuilder();
      sb.append(line);
      System.out.println(sb.reverse().toString());
    }

  }

  /**
   * 6ms 9172
   * @throws Exception
   */
  public static void other1() throws Exception {
    InputStream in  = System.in;
    int len;
    byte[] b = new byte[1024];
    //从输入流中读取一定数量的字节，并将其存储在缓冲区数组 b 中。以整数形式返回实际读取的字节数。
    while((len = in.read(b)) > 0){
      //通过使用平台的默认字符集解码指定的 byte 子数组，构造一个新的 String。
      // 新 String 的长度是字符集的函数，因此可能不等于该子数组的长度。
      // 如输入abc，则b为：{97,98,99,10,0,...,0}其中10为换行符，所以要len-1
      String str = new String(b,0,len-1);
      char [] chars = str.toCharArray();
      char [] charsFb = new char[chars.length];
      for(int i = 0;i<chars.length;i++){
        charsFb[i] = chars[chars.length -1 -i];
      }
      System.out.println(new String(charsFb));
    }

  }
}
