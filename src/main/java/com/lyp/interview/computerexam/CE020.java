package com.lyp.interview.computerexam;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 题目描述 有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，问每个月的兔子总数为多少？
 *
 * 本题有多组数据。
 *
 * 输入描述: 输入int型表示month
 *
 * 输出描述: 输出兔子总数int型
 *
 * 示例1 输入 9 输出 34
 */
public class CE020 {
  public static void main(String[] args) throws Exception {
    my01();
    //    other01();
  }

  /**
   * 12ms 9220k
   */
  public static void my01() throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = reader.readLine()) != null) {
      int i = Integer.parseInt(line);
      System.out.println(myCalc(i));
    }
  }

  private static int myCalc(int n) {
    if (n == 1 || n == 2) {
      return 1;
    }

    return myCalc(n - 1) + myCalc(n - 2);
  }

  public static void other01() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = "";
    while ((line = br.readLine()) != null) {
      int monthCount = Integer.parseInt(line);
      System.out.println(getTotalCount1(monthCount));
    }
  }

  public static int getTotalCount1(int monthCount) {
    int a = 1;
    int b = 1;
    int c = 1;
    for (int i = 2; i < monthCount; ++i) {
      c = a + b;
      a = b;
      b = c;
    }

    return c;
  }

  /**
   * 统计出兔子总数。
   *
   * @param monthCount 第几个月
   * @return 兔子总数
   */
  public static int getTotalCount2(int monthCount) {
    int ttCount = 0;
    if (monthCount <= 2) {
      ttCount = 1;
    } else if (monthCount == 3) {
      ttCount = 2;
    } else {
      //进入此判断已经是第4个月了
      int oneMonCount = 1; //1个月大的兔子
      int twoMonCount = 0; //2个月大的兔子
      int threeMonCount = 1; //3个月及以上大的兔子
      //从第4个月开始
      for (int i = 4; i <= monthCount; i++) {
        threeMonCount = threeMonCount + twoMonCount;//之前两个月大的会变成3个月
        twoMonCount = oneMonCount;//之前一个月大的会长大长成2个月大的
        oneMonCount = threeMonCount;//三个月的会下兔宝宝 1个月大
        ttCount = oneMonCount + twoMonCount + threeMonCount;
        //System.out.println("月份："+i+"-->1个月大:"+oneMonCount+"-->2个月大:"+twoMonCount+"-->3个月大:"+threeMonCount+"-->总计:"+ttCount);
      }
    }
    return ttCount;
  }
}
