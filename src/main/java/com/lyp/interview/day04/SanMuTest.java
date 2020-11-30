package com.lyp.interview.day04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SanMuTest {
  public static void main(String[] args) throws IOException {
    /*byte b = 1;
    char c = 1;
    short s = 1;
    int i = 1;

    i=true?b: c;
    s=true?s:b;*/

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line=reader.readLine())!=null){

      String[] ss = line.split(" ");
      System.out.println(ss[ss.length-1].length());
    }
  }
}
