package com.lyp.interview.computerexam;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 题目描述
 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）

 最后一个数后面也要有空格

 输入描述:
 输入一个long型整数

 输出描述:
 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。

 示例1
 输入
 180
 输出
 2 2 3 3 5
 */
public class CE007 {
  public static void main(String[] args) throws Exception {
    my1();
    other1();
  }

  //递归未完成 todo
  /*public static void main(String[] args) throws Exception{
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while((line=reader.readLine())!=null){
      long num = Long.parseLong(line);
      ArrayList<Long> list = new ArrayList<>();
      loop(num,false,list);
      Collections.sort(list);
      for(int i=0;i<list.size();i++){
        System.out.print(list.get(i)+" ");
      }
    }
  }

  public static void loop(long num,boolean stop,ArrayList<Long> list){
    if(stop){
      return;
    }
    for(long i=2;i<num;i++){
      if(num%i==0){
        loop(i,false,list);

      }
    }
    if(num%i==0){
      list.add(i);
    }

  }*/

  public static void my1() throws Exception {

  }

  /**
   * 该题涉及几个定理：
   * 1，一个合数可以分解为多个质数乘积；
   * 2，一个合数最多只有一个质因数大于其平方根，如26，有13大于26的平方根。
   * 3，由1，2 得出一个合数等于由多个小于其平方根的质数乘积，最多再加上一个大于平方根的质因数乘积
   * @throws Exception
   */
  public static void other1() throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while((line=reader.readLine())!=null){
      long num = Long.valueOf(line);
      StringBuilder sb = new StringBuilder();
      for(int i=2;i<=Math.sqrt(num);i++){
        if(num%i==0){
          sb.append(i+" ");//从最小质数2开始，直接添加
          num/=i; //下一次循环直接可以从其商数开始
          i--; //-1，表示可能被一个质数整除多次，所以要再试一遍
        }
      }
      //因为一个合数最终可分解为质数相乘，所以被整除到最后，剩余的商也是质数。
      // 如果该数本身也是质数，则直接在这里加上算输出结果
      sb.append(num+" ");
      System.out.println(sb.toString());

    }
  }

}
