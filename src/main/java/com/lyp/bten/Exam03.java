package com.lyp.bten;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
 * <p>
 * 例如，当输入5时，应该输出的三角形为：
 * <p>
 * 1 3 6 10 15
 * 2 5 9 14
 * 4 8 13
 * 7 12
 * 11
 **/
public class Exam03{
  /**
   * (0,0)
   * (0,1),(1,0)
   * (0,2),(1,1),(2,0)
   * (0,3),(1,2),(2,1),(3,0)
   * 解题思路，根据纵坐标与横坐标下标和，输入n，则下标和为0-(n-1)；纵坐标都是从0开始
   *
   * @param args
   */
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    while(scanner.hasNextLine()){
      String line = scanner.nextLine();
      int num = Integer.parseInt(line);
      List<List<Integer>> rows = new ArrayList<>(num);
      for(int i = 0; i < num; i++){
        rows.add(new ArrayList<>());
      }

      int index = 0;
      for(int i = 0; i < num; i++){
        for(int j = 0; j <= i; j++){
          int row = i - j;
          List<Integer> cols = rows.get(row);
          cols.add(++index);
        }
      }

      StringBuilder sb = new StringBuilder();
      for(List<Integer> row : rows){
        for(Integer col : row){
          sb.append(col).append(" ");
        }
        sb.append("\n");
      }
      System.out.println(sb.deleteCharAt(sb.length() - 1));
    }
  }
}