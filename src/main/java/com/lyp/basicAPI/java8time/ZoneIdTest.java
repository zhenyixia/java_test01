package com.lyp.basicAPI.java8time;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Set;
import java.util.TimeZone;

//参考：https://lw900925.github.io/java/java8-newtime-api.html
public class ZoneIdTest {
  public static void main(String[] args) {
    /**
     * ZoneId对象可以通过ZoneId.of()方法创建，也可以通过ZoneId.systemDefault()获取系统默认时区：
     *
     */
    ZoneId shanghaiZoneId = ZoneId.of("Asia/Shanghai");
    ZoneId systemZoneId = ZoneId.systemDefault();
    //of()方法接收一个“区域/城市”的字符串作为参数，你可以通过getAvailableZoneIds()方法
    // 获取所有合法的“区域/城市”字符串：
    Set<String> zoneIds = ZoneId.getAvailableZoneIds();

    //    对于老的时区类TimeZone，Java 8也提供了转化方法：
    ZoneId oldToNewZoneId = TimeZone.getDefault().toZoneId();

    //有了ZoneId，我们就可以将一个LocalDate、LocalTime或LocalDateTime对象转化为ZonedDateTime对象：
    LocalDateTime localDateTime = LocalDateTime.now();
    ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, shanghaiZoneId);
    //将zonedDateTime打印到控制台为：2017-01-05T15:26:56.147+08:00[Asia/Shanghai]
    //ZonedDateTime对象由两部分构成，LocalDateTime和ZoneId，其中2017-01-05T15:26:56.147部分为LocalDateTime，
    // +08:00[Asia/Shanghai]部分为ZoneId。

    //另一种表示时区的方式是使用ZoneOffset，
    // 它是以当前时间和世界标准时间（UTC）/格林威治时间（GMT）的偏差来计算，例如：
    ZoneOffset zoneOffset = ZoneOffset.of("+09:00");
    localDateTime = LocalDateTime.now();
    OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, zoneOffset);
  }
}
