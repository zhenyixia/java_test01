package com.lyp.basicAPI.java8time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
//参考：https://lw900925.github.io/java/java8-newtime-api.html
public class TimeParseTest {

  public static void main(String[] args) {
    /**
     * Instant只能解析"**T**Z”这种格式的时间，即UTC字符串；
     *
     * ZonedDateTime解析的时间字符串必须是要有年月日时分秒以及时区；
     *
     * LocalDateTime解析的时间字符串必须要有年月日时分秒，但是不能有时区，例如末尾有"Z"的时间表示UTC的0时区就不能解析；
     *
     * LocalDate解析的时间字符串必须只能有年月日，格式如"2018-12-07"，多任何其他字符都不能解析。
     */

    String string = "2018-12-07T09:33:38+00:00";
    ZonedDateTime parse = ZonedDateTime.parse(string);
    System.out.println(parse.toString());
    //结果是2018-12-07T09:33:38Z
    ZoneId zone = parse.getZone();
    System.out.println(zone);
    /**
     * 新的日期API中提供了一个DateTimeFormatter类用于处理日期格式化操作，
     * 它被包含在java.time.format包中，Java 8的日期类有一个format()方法用于将日期格式化为字符串，
     * 该方法接收一个DateTimeFormatter类型参数：
     *
     */
    LocalDateTime dateTime = LocalDateTime.now();
    String strDate1 = dateTime.format(DateTimeFormatter.BASIC_ISO_DATE);    // 20170105
    String strDate2 = dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE);    // 2017-01-05
    String strDate3 = dateTime.format(DateTimeFormatter.ISO_LOCAL_TIME);    // 14:20:16.998
    String strDate4 = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));   // 2017-01-05
    String strDate5 = dateTime.format(DateTimeFormatter.ofPattern("今天是：YYYY年 MMMM DD日 E", Locale.CHINESE)); // 今天是：2017年 一月 05日 星期四

    String strDate6 = "2017-01-05";
    String strDate7 = "2017-01-05 12:30:05";
    LocalDate date = LocalDate.parse(strDate6, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    LocalDateTime dateTime1 = LocalDateTime.parse(strDate7, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

  }
}
