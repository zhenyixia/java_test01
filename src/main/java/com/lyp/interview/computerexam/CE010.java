package com.lyp.interview.computerexam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 题目描述
 有一种技巧可以对数据进行加密，它使用一个单词作为它的密匙。下面是它的工作原理：
 首先，选择一个单词作为密匙，如TRAILBLAZERS。如果单词中包含有重复的字母，只保留第1个，其余几个丢弃。
 现在，修改过的那个单词属于字母表的下面，如下所示：

 A B C D E F G H I J K L M N O P Q R S T U V W X Y Z

 T R A I L B Z E S C D F G H J K M N O P Q U V W X Y

 上面其他用字母表中剩余的字母填充完整。在对信息进行加密时，信息中的每个字母被固定于顶上那行，
 并用下面那行的对应字母一一取代原文的字母(字母字符的大小写状态应该保留)。
 因此，使用这个密匙，Attack AT DAWN(黎明时攻击)就会被加密为Tpptad TP ITVH。

 请实现下述接口，通过指定的密匙和明文得到密文。

 本题有多组输入数据。

 输入描述:
 先输入key和要加密的字符串

 输出描述:
 返回加密后的字符串

 示例1
 输入
 nihao
 ni
 输出
 le
 */
public class CE010 {
  public static void main(String[] args) throws Exception {
    other1();
  }

  /**
   * 10ms 9308k
   */
  public static void my1() throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = reader.readLine()) != null) {
      //去重
      ArrayList<String> keyList = new ArrayList();
      for (int i = 0; i < line.length(); i++) {
        String s = String.valueOf(line.charAt(i)).toUpperCase();
        if (keyList.contains(s)) {
          continue;
        }
        keyList.add(s);
      }

      //生成第一行
      String[] firstAlph = new String[26];
      for (byte j = 0; j < 26; j++) {
        firstAlph[j] = String.valueOf((char) (65 + j));
      }

      //根据keyList 和第一行，生成第二行
      ArrayList<String> alphsList = new ArrayList(Arrays.asList(firstAlph));
      Iterator<String> it = alphsList.iterator();
      while (it.hasNext()) {
        String c = it.next();
        if (keyList.contains(c)) {
          it.remove();
        }
      }
      ArrayList<String> secondList = new ArrayList();
      secondList.addAll(keyList);
      secondList.addAll(alphsList);

      //根据第一行和第二行，生成对应map
      Map<String, String> secMap = new HashMap<>();
      for (int m = 0; m < 26; m++) {
        secMap.put(firstAlph[m], secondList.get(m));
      }

      //读取待加密字符串，转换，遇见空格则不转
      String toSec = reader.readLine();
      String lastStr = "";
      for (int n = 0; n < toSec.length(); n++) {
        char c = toSec.charAt(n);
        String cc = String.valueOf(c);
        //如果是大写，则获取到映射的val要转为大写
        if (65 <= c && c < 91) {
          lastStr += secMap.get(cc.toUpperCase()).toUpperCase();
        } else if (97 <= c && c < 123) {
          lastStr += secMap.get(cc.toUpperCase()).toLowerCase();
        } else {
          lastStr += cc;
        }
      }

      System.out.println(lastStr);
    }
  }

  /**
   * 6ms 9164k
   * 其中getKey(String key)这段有个方法比较好
   */
  public static void other1() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = "";
    while ((str = br.readLine()) != null){
      String key = getKey(str);
      String code = br.readLine();
      String asn = buildCode(code,key);
      System.out.println(asn);
    }
  }

  public static String getKey(String key){
    StringBuilder sb = new StringBuilder();
    String str = key.toUpperCase()+"ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    //判重复
    int[] ltr = new int[26];
    for(int i = 0;i<str.length();i++){
      char c = str.charAt(i);
      if(ltr[c - 'A'] == 0){
        sb.append(c);
        ltr[c - 'A']++;
      }

    }
    return sb.toString();
  }
  public static String buildCode(String str,String key){
    StringBuilder sb = new StringBuilder();
    String code = null;
    char[] ch = key.toCharArray();
    //对照 大写小写区分
    for(int i = 0;i<str.length();i++){
      char c = str.charAt(i);
      if(c >= 'a' && c<= 'z'){
        sb.append((char)('a'+ch[c-'a']-'A'));
      }
      else if(c >= 'A' && c<= 'Z'){
        sb.append((char)(ch[c-'A']));
      }
      else sb.append(c);
    }

    return sb.toString();
  }
}
