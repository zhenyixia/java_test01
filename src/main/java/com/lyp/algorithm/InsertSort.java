package com.lyp.algorithm;

import java.util.Arrays;

public class InsertSort {

  public static void sort(int[] a) {
    //保有一张牌，从第二张牌开始，将该牌保存在一个临时变量中，然后拿数组中的a[i]和前一个数a[i-1比较，
    // 如果比前一张小，则将前一个数赋值到a[i],然后i减1，继续往前比较，一直到a[i-1]不大于a[i]时停止
   /* int temp;
    int j;
    for (int i = 1; i < a.length; i++) {
      temp = a[i];
      for (j = i; j > 0 && temp < a[j - 1]; j--) {
        a[j] = a[j - 1];
      }

      a[j] = temp;
    }*/

    int temp;
    int j;
    for (int i = 1; i <= a.length - 1; i++) {
      temp = a[i];
      for (j = i; j > 0 && temp < a[j - 1]; j--) {
        a[j] = a[j - 1];
      }

      a[j] = temp;

    }

    System.out.println(Arrays.toString(a));
  }

  public static void main(String[] args) {
    int[] a = {4, 7, 1, 8, 2};

    sort(a);
  }

}
