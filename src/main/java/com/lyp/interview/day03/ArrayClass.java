package com.lyp.interview.day03;

public class ArrayClass {
  public static void main(String[] args) {
    int[] i = new int[]{1, 2, 3};
    int[] j = new int[]{1, 2, 3};
    int[] k = i;
    int[] array = new int[100];
    double[] array_1 = new double[100];
    System.out.println(i);
    System.out.println(j);
    System.out.println(array);
    System.out.println(array_1);
    System.out.println(i.equals(j));
    System.out.println(i.equals(k));
  }
}
