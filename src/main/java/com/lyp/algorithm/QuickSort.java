package com.lyp.algorithm;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {

  /**
   * 总体思路： int[] a : 3，5，6，1，2，9
   *
   * 1，取一个基准数，一般取第一个，最后一个，或中间的那个 这里取 a[0]: 3 2，从前往后找比基准数大的数，从后往前找比基准数小的数 从i=1
   * 自增往后找，从j=5自减往前找，找到后互换。直到i>=j时，说明已经把数组循环一遍，可以结束一轮。 3，找到a[1]:5,a[4]:2。需要交换，结果为：
   * 3,2,6,1,5,9。 4，继续第一轮走 5，找到a[2]:6,a[3]:1。需要交换，结果为：3,2,1,6,5,9。此时i=2,j=3，i<j,还需要继续走
   * 6，a[3]:6,a[2]:1,两者不符合条件，且i:3,j:2，i>=j，已经闭环一轮，可以结束，但是发现a[0]位置不对
   * 这时候可以做个处理，将a[0]再与a[j]交换，即a[2]即可。 7，此时数组为：2，1，3，6，5，9。第一次基准数为a[2]:3。
   * 8，然后需分两个方向继续。a[2]左侧，与右侧。左侧仍取第一个数a[0]:2为基准，范围为[0,1].
   * 右侧也取第一个数a[3]:6,范围为[3,5]
   */


  public static void main(String[] args) {
    int[] a = {3, 1, 2, 6, 8, 10, 7, 2};
    quickSort1(a, 0, a.length - 1);

    System.out.println(Arrays.toString(a));


  }

  private static void quickSort1(int[] a, int low, int high) {

    //程序出口，递归结束
    if (low > high) {
      return;
    }

    int left = low;
    int right = high;
    int key = a[low];
    while (left < right) {
      while (left < right && a[right] > key) {
        right--;
      }

      while (left < right && a[left] <= key) {
        left++;
      }

      if (left < right) {
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
      }
    }

    a[low] = a[left];
    a[left] = key;
    quickSort1(a, low, left - 1);
    quickSort1(a, left + 1, high);

  }

  private static int partition(int[] arr, int left, int right) {

    /*//将随机数作为索引，将索引对应值与最后一位值right交换
    int ranNum = (int) (left + Math.random() * (right - left + 1));
    swap(arr, right, ranNum);*/

    int value = arr[left];
    int position = left;

    //
    for (int i = left + 1; i <= right; i++) {
      if (arr[i] < value) {
        swap(arr, i, ++position);
      }
    }

    return 0;

  }

  private static void swap(int[] arr, int right, int ranNum) {
    int temp = arr[right];
    arr[right] = arr[ranNum];
    arr[ranNum] = temp;
  }


}
