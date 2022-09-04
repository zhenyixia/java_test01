package com.lyp.algorithm;

/**
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。 结果可能很大，你需要对结果模1000000007。
 *
 * 示例1:
 *
 * 输入：n = 3 输出：4 说明: 有四种走法 示例2:
 *
 * 输入：n = 5 输出：13 n=61 输出  752119970
 */
public class ThreeStepProblem{

  public static long waysToStep(int n){

    int[] aa = {0, 1, 2, 4};

    if(n < 4){
      return aa[n];
    }

    for(int i = 4; i <= n; i++){
      // 结果可能很大，你需要对结果模 1000000007,
      // 这里的意思是只要计算过程中结果超过 1000000007 即要取模，所以每次出现加法就可能超过，就需要取模
      aa[0] = ((aa[1] + aa[2]) % 1000000007 + aa[3]) % 1000000007;
      aa[1] = aa[2];
      aa[2] = aa[3];
      aa[3] = aa[0];
    }
    return aa[3];
  }

  public static void main(String[] args){
    System.out.println(waysToStep(61));
  }
}