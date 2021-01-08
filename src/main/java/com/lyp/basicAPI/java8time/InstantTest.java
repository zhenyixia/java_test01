package com.lyp.basicAPI.java8time;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class InstantTest {

  /**
   * Instant代表的是 时间线上模拟单个瞬时点； 它是精确到纳秒的； 实际上其内部是由两个Long字段组成，第一个部分保存的是自标准Java计算时代（就是1970年1月1日开始）到现在的秒数， 第二部分保存的是纳秒数（永远不会超过999,999,999）；
   * 是不带时区的即时时间点 Instant和Date不同的是，它是时区无关的，始终是0时区的
   */
  public static void main(String[] args) {

    // 1，获取当前时间，默认为0时区
    Instant instant = Instant.now();
    System.out.println(instant);

    // 1.1,获取当前时间戳，注意，如果要获取本地时区的，则要先将instant转到本地时区。
    // instant精度是纳秒级别，但是getNano()方法获取的值是毫秒纳秒格式的，如： 234000000,即234毫秒，0纳秒。
    // 但精度比System.currentTimeMillis() 高
    System.out.println(instant.getEpochSecond());
    System.out.println(instant.toEpochMilli());
    System.out.println(instant.getNano());

    // 2,获取当前时区时间
    instant = Instant.now().plusMillis(TimeUnit.HOURS.toMillis(8));
    System.out.println(instant);

    // 3,date转instant，记住一种即可
    System.out.println("------date转instant-----");
    Date date = new Date();
    Instant instant1 = date.toInstant();
    System.out.println(instant1);
    Instant instant2 = Instant.ofEpochMilli(date.getTime());
    System.out.println(instant2);

    // 4, instant 思考date
    System.out.println("instant 思考date");
    Date from = Date.from(instant2);
    System.out.println(from);
    Date date1 = new Date(instant2.toEpochMilli());
    System.out.println(date1);

    // 5, instant解析字符串为时间，注意，只能解析utc格式时间
    System.out.println("instant解析字符串为时间");
    Instant parse = Instant.parse("2019-02-13T09:01:52.484Z");
    System.out.println(parse);

    // 6,instant 时间，增加减少，比较
    Instant instant3 = parse.plus(Duration.ofDays(5).plusHours(2).plusMinutes(4));
    System.out.println(instant3);

    //计算5天前的时间
    instant.minus(5, ChronoUnit.DAYS); // Option 1　方法1
    instant.minus(Duration.ofDays(5)); // Option 2  方法2

    //计算两个Instant之间的分钟数
    long diffAsMinutes = ChronoUnit.MINUTES.between(instant, instant1); // 方法2
    System.out.println(diffAsMinutes);

    // 7,instant 相互比较
    System.out.println("instant 相互比较");
    long between = ChronoUnit.HOURS.between(instant, instant1);
    System.out.println(between);
    between = ChronoUnit.DAYS.between(instant, instant1);
    System.out.println(between);

    System.out.println(instant3.compareTo(parse));
    System.out.println(instant3.isAfter(parse));
    System.out.println(instant3.isBefore(parse));

    // 8,转化为LocalDateTime,LocalDate
    System.out.println("转化为LocalDateTime,LocalDate");
    ZoneId zoneId = ZoneId.systemDefault();
    LocalDateTime localDateTime = instant3.atZone(zoneId).toLocalDateTime();
    System.out.println(localDateTime);

    LocalDate localDate = instant3.atZone(zoneId).toLocalDate();
    System.out.println(localDate);

    LocalTime localTime = instant3.atZone(zoneId).toLocalTime();
    System.out.println(localTime);

    LocalDateTime localDateTime1 = LocalDateTime.ofInstant(instant3, zoneId);
    System.out.println(localDateTime1);

    // 9,localDateTime转为instant
    System.out.println("localDateTime转为instant");
    LocalDateTime now = LocalDateTime.now();
    System.out.println(now);

    Instant instant4 = now.toInstant(ZoneOffset.of("+8"));
    System.out.println(instant4);

    instant4 = now.toInstant(ZoneOffset.ofHours(8));
    System.out.println(instant4);

    instant4 = now.toInstant(ZoneOffset.of("+0"));
    System.out.println(instant4);
  }
}
