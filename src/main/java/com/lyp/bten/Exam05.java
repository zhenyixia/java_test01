package com.lyp.bten;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 描述
 * 输入一个表达式（用字符串表示），求这个表达式的值。
 * 保证字符串中的有效字符包括[‘0’-‘9’],‘+’,‘-’, ‘*’,‘/’ ,‘(’， ‘)’,‘[’, ‘]’,‘{’ ,‘}’。且表达式一定合法。
 * 数据范围：表达式计算结果和过程中满足 |val| \le 1000 ，字符串长度满足  1≤n≤1000
 *
 * 输入描述：
 * 输入一个算术表达式
 *
 * 输出描述：
 * 得到计算结果
 * 输入：
 * 3+2*{1+2*[-4/(8-6)+7]}
 * 复制
 * 输出：
 * 25
 */
public class Exam05{
  // 14.43 -16.56

  /**
   * 四则运算优先级：1，将中括号，大括号都替换成小括号
   * 2，然后根据正则表达式，循环提取出小括号区，注意每次都提取最里面的小括号。
   * 3，计算不带有括号的表达式的值
   *
   * 该题解法的关键点在于：
   * 1，使用正则提取，大大减轻了自己写逻辑处理。
   * 2，去括号的时候 大胆将 类似 10/(-2) 处理成 10/-2，保证去括号的彻底性。
   * 3，注意可能会出现 -- -+ +- ++的情况，如 3-10/-2 -> 3--20
   * 4，将减号看成负号，最后基础部分只有加法运算，如 3-2+5，提取出 3，-2，5 三个数字，然后计算三个之和
   */

  // 匹配数字
  static Pattern p1 = Pattern.compile("(-?\\d+)");

  // 10*2 10/2 10*-2  10/-2
  static Pattern p3 = Pattern.compile("((\\d+)([\\*/]+)(-?\\d+))");

  // 匹配小括号中的表达式，小括号中没有小括号
  static Pattern p5 = Pattern.compile("\\(([\\+\\-\\*/\\d]+)\\)");

  // 3+22/11-1 传入不包含括号的表达式
  public static String base1(String reg){
    while(reg.contains("*") || reg.contains("/")){
      Matcher matcher = p3.matcher(reg);
      while(matcher.find()){
        String ss = matcher.group();
        String f = matcher.group(2);
        String j = matcher.group(3);
        String s = matcher.group(4);
        int result;
        if("*".equals(j)){
          result = Integer.parseInt(f) * Integer.parseInt(s);
        }else{
          result = Integer.parseInt(f) / Integer.parseInt(s);
        }
        reg = reg.replace(ss, String.valueOf(result));
        reg = reg.replace("+-", "-").replace("-+", "-").replace("--", "+").replace("++", "+");
      }
    }

    // System.out.println(reg);
    Matcher matcher = p1.matcher(reg);
    int count = 0;
    while(matcher.find()){
      String ss = matcher.group();
      count += Integer.parseInt(ss);
    }
    return String.valueOf(count);
  }

  // 去括号 不必关注负数，如： 10/-5 3*-2 这种，只要能在基础解析出 3与-2即可
  public static String base2(String ss){
    while(ss.contains("(")){
      Matcher matcher = p5.matcher(ss);
      while(matcher.find()){
        String ss1 = matcher.group();
        String ss2 = matcher.group(1);
        String result = base1(ss2);
        ss = ss.replace(ss1, result);
      }
    }

    return ss;
  }

  public static void main(String[] args) throws IOException{
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while((line = reader.readLine()) != null){
      line = line.replace("[", "(").replace("]", ")").replace("{", "(").replace("}", ")");
      if(line.contains("(")){
        line = base2(line);
      }

      line = base1(line);
      System.out.println(line);
    }
  }
}