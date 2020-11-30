package com.lyp.interview.computerexam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/**
 * 题目描述 Jessi初学英语，为了快速读出一串数字，编写程序将数字转换成英文：
 *
 * 如22：twenty two，123：one hundred and twenty three。
 *
 *
 * 说明：
 *
 * 数字为正整数，长度不超过九位，不考虑小数，转化结果为英文小写；
 *
 * 输出格式为twenty two；
 *
 * 非法数据请返回“error”；
 *
 * 关键字提示：and，billion，million，thousand，hundred。
 *
 *
 * 本题含有多组输入数据。
 *
 *
 * 输入描述: 输入一个long型整数
 *
 * 输出描述: 输出相应的英文写法
 *
 * 示例1 输入 2356 输出 two thousand three hundred and fifty six
 */
public class CE012 {
  private static List<String> inTen = Arrays.asList("zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
      "nine");

  private static List<String> inTenDig = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");

  private static List<String> inTwenty = Arrays.asList(
      "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen");

  private static List<String> inTwentyDig = Arrays.asList("10", "11", "12", "13", "14", "15", "16", "17", "18", "19");

  private static List<String> severalTen = Arrays.asList("twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety");

  private static List<String> severalTenDig = Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9");

  public static void main(String[] args) throws Exception {
    my1();
  }

  /**
   * 8ms 9480k
   */
  public static void my1() throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = reader.readLine()) != null) {
      if (line.length() > 9) {
        System.out.println("error");
        continue;
      }

      //根据输入的位数，如果不足9位，则在前面补0；
      String originStr = line;
      int minus = 9 - line.length();
      for (int i = 0; i < minus; i++) {
        originStr = "0" + originStr;
      }

      String result = "";
      String readMillion = processThreeDig(originStr.substring(0, 3));
      if (readMillion.equals("error")) {
        System.out.println("error");
        continue;
      }
      if (!readMillion.equals("0")) {
        result = readMillion + " million ";
      }
      String readThousand = processThreeDig(originStr.substring(3, 6));
      if (readThousand.equals("error")) {
        System.out.println("error");
        continue;
      }
      if (!readThousand.equals("0")) {
        result = result + readThousand + " thousand ";
      }
      String readHundred = processThreeDig(originStr.substring(6));
      if (readHundred.equals("error")) {
        System.out.println("error");
        continue;
      }
      if (!readHundred.equals("0")) {
        result = result + readHundred;
      }

      System.out.println(result.trim());
    }
  }

  /**
   * 处理三个数字，并返回读音，如321返回three hundred and twenty one; 056: fifty six
   *
   * @param substring "321", "056","502"
   * @return three hundred and twenty one
   */
  private static String processThreeDig(String substring) {
    if (substring.equals("000")) {
      return "0";
    }

    String first = substring.substring(0, 1);
    String result = "";
    if (!first.equals("0")) {
      result = inTen.get(inTenDig.indexOf(first)) + " hundred";
    }

    String second = substring.substring(1);
    int num = Integer.parseInt(second);
    if (num == 0) {
      return result;
    }

    if (!first.equals("0")) {
      result += " and ";
    }

    String numStr = String.valueOf(num);
    if (num < 10) {
      int index = inTenDig.indexOf(numStr);
      if (index != -1) {
        return result + inTen.get(index);
      }
    } else if (num < 20) {
      int index = inTwentyDig.indexOf(numStr);
      if (index != -1) {
        return result + inTwenty.get(index);
      }
    } else { // 小于100不用hundred，但是每个整数10是单独的单词，需要特殊对待
      String fir = String.valueOf(num / 10);
      String firstEn = severalTen.get(severalTenDig.indexOf(fir));
      result += firstEn;
      String sec = String.valueOf(num % 10);
      if (!sec.equals("0")) {
        result = result + " " + inTen.get(inTenDig.indexOf(sec));
      }

      return result;
    }

    return "error";
  }
}
