package com.lyp.basicAPI.java8time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class LocalDateTimeTest {
  public static void main(String[] args) {
    // 将不带时区LocalDateTime转化为带时区的ZonedDateTime
    final String string ="2018-12-07T09:33:38";
    LocalDateTime parse = LocalDateTime.parse(string);
    ZonedDateTime z1 = ZonedDateTime.of(parse, ZoneId.of("Asia/Shanghai"));
    System.out.println(z1.toString());
    //2018-12-07T09:33:38+08:00[Asia/Shanghai]

    ZonedDateTime z2 = ZonedDateTime.of(parse, ZoneId.of("Z"));
    System.out.println(z2.toString());
    //2018-12-07T09:33:38Z

    ZonedDateTime z3 = ZonedDateTime.of(parse, ZoneId.of("UTC"));
    System.out.println(z3.toString());
    //2018-12-07T09:33:38Z[UTC]

    ZonedDateTime z4 = ZonedDateTime.of(parse, ZoneId.of("UTC+08:00"));
    System.out.println(z4.toString());
    //2018-12-07T09:33:38+08:00[UTC+08:00]

    ZonedDateTime z5 = ZonedDateTime.of(parse, ZoneId.of("+08:00"));
    System.out.println(z5.toString());
    //2018-12-07T09:33:38+08:00

    ZonedDateTime z6 = ZonedDateTime.of(parse, ZoneId.of("+00:00"));
    System.out.println(z6.toString());
    //2018-12-07T09:33:38Z

    /**
     * 由结果可知，String zoneId的字符串值，如果为：
     *
     * "Asia/Shanghai"例子为"2018-12-07T09:33:38+08:00[Asia/Shanghai]" ;
     *
     * "Z"和"+00:00"表示的是"2018-12-07T09:33:38Z"这种格式的时间；
     *
     * "UTC"表示的是"2018-12-07T09:33:38Z[UTC]" ;
     *
     * "UTC+08:00" 例子："2018-12-07T09:33:38+08:00[UTC+08:00]" ;
     *
     * "+08:00" 例子："2018-12-07T09:33:38+08:00"
     */


  }
}
