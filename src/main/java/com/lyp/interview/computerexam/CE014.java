package com.lyp.interview.computerexam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述 输入一个只包含小写英文字母和数字的字符串，按照不同字符统计个数由多到少输出统计结果，如果统计的个数相同，则按照ASCII码由小到大排序输出。 本题含有多组样例输入
 *
 * 输入描述: 一个只包含小写英文字母和数字的字符串。
 *
 * 输出描述: 一个字符串，为不同字母出现次数的降序表示。若出现次数相同，则按ASCII码的升序输出。
 *
 * 示例1 输入
 *
 * aadccddc 1b1bbbbbbbbb 输出
 *
 * cda b1 说明 第一个样例里，c和d出现3次，a出现2次，但c的ASCII码比d小，所以先输出c，再输出d，最后输出a.
 */
public class CE014 {
  public static void main(String[] args) throws Exception {
//    my1();
    other();
  }

  /**
   * 21ms 占用内存：10212k
   */
  public static void my1() throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = reader.readLine()) != null) {
      String[] all = line.split("");
      //生成 每个字符 对应的次数
      Map<String, Integer> allCountMap = new HashMap<>();
      for (int k = 0; k < all.length; k++) {
        String str = all[k];
        Integer count = allCountMap.getOrDefault(str, 0);
        count += 1;
        allCountMap.put(str, count);
      }

      // 升序排序原来的数组，然后去重为 newAllList。而排序后即按ascii升序，即使有次数相同也会先取ascii小的
      Arrays.sort(all);
      int num = allCountMap.size();
      ArrayList<String> newAllList = new ArrayList<>();
      for (int i = 0; i < all.length; i++) {
        String str = all[i];
        if (newAllList.contains(str)) {
          continue;
        }
        newAllList.add(str);
      }
      //             System.out.println(newAllList);

      // 生成数组 countList 用于存放原来排序后字符对应的个数
      // 复制数组countList 为 countListSort，然后按降序排序
      ArrayList<Integer> countList = new ArrayList<>();
      ArrayList<Integer> countListSort = new ArrayList<>();
      for (int j = 0; j < num; j++) {
        countList.add(allCountMap.get(newAllList.get(j)));
        countListSort.add(allCountMap.get(newAllList.get(j)));
      }
      //              System.out.println(countList);
      //              System.out.println(countListSort);

      Collections.sort(countListSort);
      Collections.reverse(countListSort);
      //              System.out.println(countListSort);

      // 遍历countListSort，countListSort的元素在countList中的坐标与newAll坐标一致
      String result = "";
      for (int k = 0; k < num; k++) {
        int afterSortCount = countListSort.get(k);
        int originCount = countList.indexOf(afterSortCount);
        String ss = newAllList.get(originCount);
        if (result.contains(ss)) {
          countList.set(originCount, -1);
          originCount = countList.indexOf(afterSortCount);
          ss = newAllList.get(originCount);
        }
        result += ss;
      }

      System.out.println(result);
    }
  }

  public static void other() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str;
    while ((str = br.readLine()) != null) {
      char[] chArr = str.toCharArray();
      int[] temp = new int[150];
      for (int i = 0; i < chArr.length; i++) {
        temp[chArr[i]]++;
      }
      int max = 0;
      for (int j = 0; j < temp.length; j++) {
        if (max < temp[j]) {
          max = temp[j];
        }
      }
      StringBuilder sbf = new StringBuilder();
      while (max != 0) {
        for (int j = 0; j < temp.length; j++) {
          if (temp[j] == max) {
            sbf.append((char) j);
          }
        }
        max--;
      }
      System.out.println(sbf.toString());
    }
  }
}
