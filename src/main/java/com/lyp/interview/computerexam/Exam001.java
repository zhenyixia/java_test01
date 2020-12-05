package com.lyp.interview.computerexam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * abc abcaybec
 */
public class Exam001 {
  public static void main(String[] args) throws IOException {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    String target;
    while ((target = read.readLine()) != null) {

      //1,求目标首字母在source序列中的位置集合
      List<Integer> firstIndexList = new ArrayList<>();
      String source = read.readLine();
      char[] sArray = source.toCharArray();
      char[] tArray = target.toCharArray();
      for (int i = 0; i < sArray.length; i++) {
        if (sArray[i] == tArray[0]) {
          firstIndexList.add(i);
        }
      }

      /*if(firstIndexList.size()==0){
        System.out.println(-1);
        continue;
      }*/

      //2，从目标首字母的位置开始，往后循环查找是否包含其它字母，如果包含则记录其坐标
      List<List<Integer>> allMatchLists = new ArrayList<>();
      for (int i : firstIndexList) {
        List<Integer> oneMatchList = new ArrayList<>();

        for (int k = 0; k < tArray.length; k++) {
          for (int j = i; j < sArray.length; j++) {
            if (!oneMatchList.contains(j) && tArray[k] == sArray[j]) {
              oneMatchList.add(j);
              break;
            }
          }
        }

        if (oneMatchList.size() == tArray.length) {
          allMatchLists.add(oneMatchList);
        }
      }

      //3,循环所有满足的序列list取最大的首位元素，即为最后的坐标
      int index = -1;
      for (int i = 0; i < allMatchLists.size(); i++) {
        List<Integer> match = allMatchLists.get(i);
        int fir = match.get(0);
        if (index < fir) {
          index = fir;
        }
      }

      System.out.println(index);
    }
  }
}



