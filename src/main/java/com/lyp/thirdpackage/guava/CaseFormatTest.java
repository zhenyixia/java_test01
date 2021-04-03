package com.lyp.thirdpackage.guava;

import com.google.common.base.CaseFormat;

public class CaseFormatTest{

  public static void main(String[] args){
    String data = "test_data";
    System.out.println(CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL, "test-data"));

    System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "test_data"));

    System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "test_data"));

    System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "test_data"));

    System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_HYPHEN, "test_data"));


    System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_UNDERSCORE, "test_data"));

    System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_HYPHEN, "test_data"));

    System.out.println(CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, "testData"));

    /**
     * 总结，从运行结果可以观察到：
     * 1，关键在于to方法的第一个参数，第一个参数即为第二个参数最终要转换的形式
     * 2，但是在调用to方法前，需要将对应的格式先使用，如果源字符串为小驼峰，则要用：CaseFormat.LOWER_HYPHEN.to
     * 3，其实从上面的事例可以观察到: 有些调用主体不一样，但结果一样如：
     * CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, "testData")
     * CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, "testData")
     * 最终都是改为下划线形式。
     * 4，但最好用符合其格式的枚举调用。
     *
     */


  }

}