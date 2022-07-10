package com.lyp.bten;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

/**
 * 描述
 * 输入一个只包含小写英文字母和数字的字符串，按照不同字符统计个数由多到少输出统计结果，如果统计的个数相同，则按照ASCII码由小到大排序输出。
 * 数据范围：字符串长度满足 1 \le len(str) \le 1000 \1≤len(str)≤1000
 *
 * 输入描述：
 * 一个只包含小写英文字母和数字的字符串。
 *
 * 输出描述：
 * 一个字符串，为不同字母出现次数的降序表示。若出现次数相同，则按ASCII码的升序输出。
 *
 * 示例1
 * 输入：
 * aaddccdc
 * 复制
 * 输出：
 * cda
 * 复制
 * 说明：
 * 样例里，c和d出现3次，a出现2次，但c的ASCII码比d小，所以先输出c，再输出d，最后输出a.
 */
public class Exam01{

  public static void main(String[] args) throws IOException{
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while((line = reader.readLine()) != null){
      char[] chars = line.toCharArray();
      byte[] bytes = new byte[128];
      for(char c : chars){
        bytes[(byte)c]++;
      }

      LinkedHashMap<Character, Integer> charMap = new LinkedHashMap<>();
      for(int i = 0; i < bytes.length; i++){
        int num = bytes[i];
        if(num == 0){
          continue;
        }
        String charStr = String.valueOf((char)i);
        charMap.put((char)i, num);
      }

      List<Entry<Character, Integer>> list = new ArrayList<>(charMap.entrySet());
      list.sort((o1, o2) -> o2.getValue() - o1.getValue());
      String result = "";
      for(Entry<Character, Integer> entry : list){
        result = result + entry.getKey();
      }
      System.out.println(result);
    }
  }
}