package com.lyp.interview.computerexam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 输入
 * 2
 d 0 2 2 0
 e -1 1 1 -1
 输出
 3

 2
 d 0 2 2 0
 d -1 1 1 -1
 输出
 7

 */
public class Exam002 {
  public static void main(String[] args) throws IOException {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = read.readLine()) != null) {
      int n = Integer.parseInt(line);
      for (int i = 0; i < n; i++) {
        String row = read.readLine();
        String[] imgi = row.split("");
        String operate = imgi[0];
        int x1 = Integer.parseInt(imgi[1]);
        int x2 = Integer.parseInt(imgi[3]);
        int y1 = Integer.parseInt(imgi[2]);
        int y2 = Integer.parseInt(imgi[4]);



      }
    }
  }
}
