package com.lyp.algorithm;

/**
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 *
 * 示例1:
 *
 * 输入：n = 3 输出：4 说明: 有四种走法 示例2:
 *
 * 输入：n = 5 输出：13
 */
public class ThreeStepProblem{

  public static long[] ss = new long[1000000 + 1];

  public static int waysToStep(int n){

    if(n < 4){
      if(n == 1){
        ss[n] = 1;
      }else if(n == 2){
        ss[n] = 2;
      }else if(n == 3){
        ss[n] = 4;
      }

      return (int)ss[n];
    }

    if(ss[n - 3] == 0){
      ss[n - 3] = waysToStep(n - 3) ;
    }

    if(ss[n - 2] == 0){
      ss[n - 2] = waysToStep(n - 2) ;
    }

    if(ss[n - 1] == 0){
      ss[n - 1] = waysToStep(n - 1) ;
    }





    return (int)((ss[n - 3] + ss[n - 2] + ss[n - 1])% 1000000007);
  }

  public static void main(String[] args){
    System.out.println(waysToStep(61));
  }
}