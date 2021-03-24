package com.lyp.interview.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Temp {
  public static void main(String[] args) {
    String input = "abbd";
    String reg = "a.b*c*";
    System.out.println(match(input, reg));
  }

  private static boolean match(String input, String reg) {
    // 1，读取正则字符，去匹配输入字符
    char[] chars = input.toCharArray();
    char[] regChars = reg.toCharArray();
    char[] newChars = new char[chars.length];
    char temp = 0;
    int index = 0;
    for (int i = 0; i < regChars.length; i++) {
      char regChar = regChars[i];
      char c = chars[index];
      if (regChar == '.' || regChar == c) {
        newChars[index] = c;
      }

      if (regChar != '*') {
        temp = regChar;
        index++;
        if (index >= chars.length - 1) {
          index = chars.length - 1;
        }
      } else {
        // 等于*，则循环输入字符后面的字符,看是否与*前的字符相等，如果相等则一直循环下去
        for (int j = index; j < chars.length; j++) {
          if (chars[j] == temp || temp == '.') {
            newChars[j] = chars[j];
          } else {
            index = j;
            break;
          }
        }
      }
    }

    return new String(chars).equals(new String(newChars));
  }
}
