package com.lyp.interview.computerexam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 题目描述
 输入整型数组和排序标识，对其元素按照升序或降序进行排序（一组测试用例可能会有多组数据）

 本题有多组输入，请使用while(cin>>)处理

 输入描述:
 第一行输入数组元素个数
 第二行输入待排序的数组，每个数用空格隔开
 第三行输入一个整数0或1。0代表升序排序，1代表降序排序

 输出描述:
 输出排好序的数字

 示例1
 输入
 复制
 8
 1 2 4 9 3 55 64 25
 0
 5
 1 2 3 4 5
 1
 输出
 复制
 1 2 3 4 9 25 55 64
 5 4 3 2 1
 */
public class CE024Todo {
  public static void main(String[] args) throws Exception {
//    my01();
    other01();

  }

  public static void my01() throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = reader.readLine()) != null) {

    }

  }

  public static void other01() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input;
    while((input = br.readLine())!=null){
      int num = Integer.parseInt(input);
      String[] arr = br.readLine().split(" ");
      int flag = Integer.parseInt(br.readLine());

      int[] arr2 = new int[arr.length];
      for(int i=0;i<arr.length;i++) {
        arr2[i] = Integer.parseInt(arr[i]);
      }

      if(flag==0){
        Arrays.sort(arr2);
      }else if(flag==1){
        Arrays.sort(arr2);
        int temp;
        for(int i=0;i<arr2.length/2;i++){
          temp =arr2[i];
          arr2[i] = arr2[arr2.length-1-i];
          arr2[arr2.length-1-i] = temp;
        }
      }
      StringBuilder sb = new StringBuilder();
      for(int i=0;i<arr.length;i++){
        sb.append(arr2[i]).append(" ");
      }
      System.out.println(sb.substring(0,sb.length()-1));
    }
    br.close();
  }
}
