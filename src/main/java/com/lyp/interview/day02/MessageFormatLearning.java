package com.lyp.interview.day02;

import java.text.MessageFormat;

public class MessageFormatLearning {

  public static void main(String[] args) {
    String message = "My name is {0} , age is {1,number,integer} , height is {2,number,#.##}";
    String newMsg = MessageFormat.format(message, "zhangsan", 16, 1.721);
    System.out.println(newMsg);

    //两个单引号代表单引号，一个会被忽略
    message = "oh, {0} is ''a'' pig";
    //    message = "oh, {0} is 'a' pig";
    String value = MessageFormat.format(message, "ZhangSan");
    System.out.println(value);

    //单引号会使其后面的占位符均失效，导致直接输出占位符。
    message = "oh, '{0,number,#.#} is a pig";
    Object[] array = new Object[]{new Double(3.1415)};

    value = MessageFormat.format(message, array);
    System.out.println(value);
  }
}
