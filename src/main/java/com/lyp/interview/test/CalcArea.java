package com.lyp.interview.test;

public class CalcArea {
  /*
  题目参考图片：求面积.jpg
   */

  public static void main(String[] args) {
    int[] array = {1, 8, 6, 2, 5, 4, 8, 3, 7};
//    int[] array = {1, 8, 6};
    System.out.println(calc(array));
  }

  public static int calc(int[] array) {

    // 循环遍历数组求最大面积
    int max = 0;
    int length = array.length;
    for (int i = 1; i < length; i++) {
      int curX = i;
      int curY = array[i - 1];
      for (int j = i + 1; j <= length; j++) {
        int nextX = j;
        int nextY = array[j - 1];
        int area = (nextX - curX) * Math.min(curY, nextY);
        if (area > max) {
          max = area;
        }
      }
    }

    return max;
  }
}
