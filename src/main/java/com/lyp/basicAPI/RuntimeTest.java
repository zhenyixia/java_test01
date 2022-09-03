package com.lyp.basicAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RuntimeTest{

  public static void main(String[] args) throws IOException{
    String encodeIp = "d: && cd D:\\GIT-repo\\java\\java_test01 && git status";
    String cmd = "cmd /c " + encodeIp;
    Runtime runtime = Runtime.getRuntime();
    Process proc = runtime.exec(cmd);

    InputStream is = proc.getInputStream();
    InputStreamReader bufferIs = new InputStreamReader(is,"utf-8");
    BufferedReader bufferedReader = new BufferedReader(bufferIs);
    String line;
    while((line=bufferedReader.readLine())!=null){
      System.out.println(line);
    }

    // proc.waitFor(); // 如果启动的是 notepad++.exe，则会等出现关闭该exe，才会执行后面代码。
    int result = proc.exitValue();
    System.out.println(result);


  }


}