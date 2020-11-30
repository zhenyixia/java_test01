package com.lyp.interview.computerexam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 题目描述 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
 *
 * 输入描述: 输入两个正整数A和B。
 *
 * 输出描述: 输出A和B的最小公倍数。
 *
 * 示例1 输入 5 7
 *
 * 输出 35
 */
public class CE016 {
  public static void main(String[] args) throws Exception {
    my01();
    //    other01();
  }

  /**
   * 9ms 9240k
   */
  public static void my01() throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = reader.readLine()) != null) {
      String[] allNumStr = line.split(" ");
      int first = Integer.parseInt(allNumStr[0]);
      int second = Integer.parseInt(allNumStr[1]);

      // 求每个数的所有约数，如6，9，分别为 2，3 ； 3，3
      ArrayList<Integer> firstList = new ArrayList<>();
      for (int i = 2; i <= first; i++) {
        if (first % i == 0) {
          firstList.add(i);
          first = first / i;
          i--;
        }
      }
      if (firstList.size() == 0) {
        firstList.add(first);
      }

      ArrayList<Integer> secondList = new ArrayList<>();
      for (int i = 2; i <= second; i++) {
        if (second % i == 0) {
          secondList.add(i);
          second = second / i;
          i--;
        }
      }
      if (secondList.size() == 0) {
        secondList.add(second);
      }

      //循环两个list，将公有的数，去掉，如：2 3；3 3去掉一个公有的3即可。2 3 3 ，3 3 3 取 2 3 3 3
      // 方法为：循环第一个list，如果第二个list遇到相同的，则删除。
      for (Integer integer : firstList) {
        int index = secondList.indexOf(integer);
        if (index != -1) {
          secondList.remove(index);
        }
      }

      //合并后，计算
      int result = 1;
      ArrayList<Integer> resultList = new ArrayList<>();
      resultList.addAll(firstList);
      resultList.addAll(secondList);
      for (Integer integer : resultList) {
        result *= integer;
      }

      System.out.println(result);
    }
  }

  // todo
  public static void other01() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str;
    while ((str = br.readLine()) != null) {
      String[] strArr = str.split(" ");
      int n = Integer.parseInt(strArr[0]);
      int m = Integer.parseInt(strArr[1]);
      int j = m * n;
      if (n > m) {
        int temp = m;
        m = n;
        n = temp;
      }
      //最大公约数
      while (n != 0) {
        int r = m % n;
        m = n;
        n = r;
      }
      int max = j / m;
      System.out.println(max);
    }
  }
}
