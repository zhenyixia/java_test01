package com.lyp.interview.computerexam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 题目描述 编写一个程序，将输入字符串中的字符按如下规则排序。
 *
 * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
 *
 * 如，输入： Type 输出： epTy
 *
 * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
 *
 * 如，输入： BabA 输出： aABb
 *
 * 规则 3 ：非英文字母的其它字符保持原来的位置。
 *
 * 如，输入： By?e 输出： Be?y
 *
 * 示例1
 输入
 复制
 A Famous Saying: Much Ado About Nothing (2012/8).
 输出
 复制
 A aaAAbc dFgghh: iimM nNn oooos Sttuuuy (2012/8).
 */
public class CE018 {
  public static void main(String[] args) throws Exception {
    my01();
//        other01();

  }

  /**
   * 33ms 11192k
   *
   * 示例不通过。。。todo
   * @throws Exception
   */
  public static void my01() throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = reader.readLine()) != null) {

      line = line.trim();
      //所有非英文字母字符的坐标
      ArrayList<Integer> sIndexes = new ArrayList<>();

      //所有正常字母集合
      ArrayList<String> allNormalList = new ArrayList<>();
      ArrayList<String> afterSortList = new ArrayList<>();

      //所有的字符
      char[] allChars = line.toCharArray();
      for (int i = 0; i < allChars.length; i++) {
        char c = allChars[i];
        if ((c >= 65 && c < 91) || (c >= 97 && c < 123)) {
          allNormalList.add(String.valueOf(c));
          afterSortList.add(String.valueOf(c).toUpperCase());
        } else {
          sIndexes.add(i);
        }
      }

      //排序所有正常字母集合
      Collections.sort(afterSortList);

      //存放最终结果
      String result = "";

      //遍历排序后的集合，如果遇到的坐标在特殊字符中有，则先添加特殊字符，然后再加正常元素
      for (int i = 0; i < allChars.length; i++) {
        if (sIndexes.contains(i)) {
          result += String.valueOf(allChars[i]);
          sIndexes.remove(Integer.valueOf(i));
        }else {
          if(afterSortList.size()==0){
            continue;
          }
          String ss = afterSortList.get(0);
          afterSortList.remove(0);
          for (int i1 = 0; i1 < allNormalList.size(); i1++) {
            String ori = allNormalList.get(i1);
            if (ori.equalsIgnoreCase(ss)) {
              result += ori;
              allNormalList.remove(ori);
              break;
            }
          }
        }
      }

      System.out.println(result);
    }
  }

  public static void other01() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s;
    while((s = br.readLine()) != null){
      char[] ch = s.toCharArray();
      char[] chars = new char[ch.length];
      int flag = 65,j = 0;
      while(flag <= 90){
        for(int i = 0; i < ch.length; i ++){
          if((ch[i] >= 65 && ch[i] <= 90) || (ch[i] >= 97 && ch[i] <= 122)){
            if(ch[i] == flag || ch[i] == flag + 32){
              chars[j] = ch[i];
              j++;
            }
          }
        }
        flag++;
      }
      j = 0;
      for(int i = 0; i < ch.length; i ++){
        if((ch[i] >= 65 && ch[i] <= 90) || (ch[i] >= 97 && ch[i] <= 122)){
          ch[i] = chars[j];
          j++;
        }
      }
      System.out.println(String.valueOf(ch));
    }
  }

  public static void other2() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str;
    while ((str = br.readLine()) != null) {
      char[] arr = str.toCharArray();
      StringBuilder builder = new StringBuilder();
      // 英文字母从 A 到 Z 排列，不区分大小写：26 个
      for (int i = 0; i < 26; i++) {
        char c = (char) ('A' + i);
        // 遍历字符串
        for (int j = 0, length = str.length(); j < length; j++) {
          // 不区分大小写
          if (c == arr[j] || c == arr[j] - 'a' + 'A') {
            builder.append(arr[j]);
          }
        }
      }
      // 非英文字母的其它字符保持原来的位置
      for (int i = 0, length = str.length(); i < length; i++) {
        if (!((arr[i] >= 'A' && arr[i] <= 'Z') || (arr[i] >= 'a' && arr[i] <= 'z'))) {
          builder.insert(i, arr[i]);
        }
      }
      System.out.println(builder.toString());
    }

  }
}
