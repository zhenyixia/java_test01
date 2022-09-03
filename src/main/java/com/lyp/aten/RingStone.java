package com.lyp.aten;

import java.util.Scanner;

/**
 * https://blog.csdn.net/weixin_42172972/article/details/114244805
 */
public class RingStone{

  public static int dpSum(int[] stones, int i, int j){
    int sum = 0;
    for(int k = i; k <= j; k++){
      sum += stones[k];
    }

    return sum;
  }

  public static int dpOptimization(int[] stones){
    int n = stones.length;
    int[][] dp = new int[n + 1][n + 1];
    int[][] s = new int[n + 1][n + 1];

    for(int i = 0; i < n; i++){
      dp[i][i] = 0;
      s[i][i] = i;
    }

    for(int i = n - 1; i >= 0; i--){
      for(int j = i + 1; j < n; j++){

        int tmp = Integer.MAX_VALUE;
        int fence = 0;
        for(int k = s[i][j - 1]; k <= s[i + 1][j]; k++){
          int sum = dp[i][k] + dp[k + 1][j] + dpSum(stones, i, j);
          if(tmp > sum){
            tmp = sum;
            fence = k;
          }
        }

        dp[i][j] = tmp;
        s[i][j] = fence;
      }
    }

    int min = Integer.MAX_VALUE;
    for(int i = 0; i < n / 2; i++){
      if(min > dp[i][i + (n / 2 - 1)]){
        min = dp[i][i + (n / 2 - 1)];
      }
    }

    return min;
  }

  public static void main(String[] args){
    //第一行输入石子堆数n,第二行输入每堆石子的数量,用空格分开
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] stones = new int[n * 2];

    for(int i = 0; i < n; i++){
      stones[i] = in.nextInt();
    }

    for(int i = n; i < n * 2; i++){
      stones[i] = stones[i - n];
    }

    System.out.println(dpOptimization(stones));
  }
}



