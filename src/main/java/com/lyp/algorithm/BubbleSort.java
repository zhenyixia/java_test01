package com.lyp.algorithm;

import java.util.Arrays;

public class BubbleSort {

  public static void sort(int[] a) {

    //n个数，需要排n-1次； 每次需要比较n-1次

   /* for (int i = 0; i < a.length - 1; i++) {
      for (int j = 0; j < a.length - 1 - i; j++) {
        if (a[j] > a[j + 1]) {
          int temp = a[j];
          a[j] = a[j + 1];
          a[j + 1] = temp;
        }
      }

    }*/


    /*for (int i = a.length; i > 0; i--) {
      for (int j = 0; j < i - 1; j++) {
        if (a[j] > a[j + 1]) {
          int temp = a[j];
          a[j] = a[j + 1];
          a[j + 1] = temp;
        }
      }
    }*/

    for (int i = 0; i < a.length - 1; i++) {
      for (int j = 0; j < a.length - i - 1; j++) {
        if (a[j] > a[j + 1]) {
          int temp = a[j];
          a[j] = a[j + 1];
          a[j + 1] = temp;
        }
      }
    }

    System.out.println(Arrays.toString(a));
  }

  public static void main(String[] args) {
    int[] a = {3, 1, 5, 2, 7, 7, 4};
    sort(a);
  }


}
