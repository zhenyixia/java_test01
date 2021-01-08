package com.lyp.basicAPI.java8time;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
//参考：https://lw900925.github.io/java/java8-newtime-api.html
public class DurationTest {
  public static void main(String[] args) {
    /**
     * Duration的内部实现与Instant类似，也是包含两部分：seconds表示秒，nanos表示纳秒。
     * 两者的区别是Instant用于表示一个时间戳（或者说是一个时间点），
     * 而Duration表示一个时间段，所以Duration类中不包含now()静态方法。
     * 可以通过Duration.between()方法创建Duration对象：
     */
    LocalDateTime from = LocalDateTime.of(2017, Month.JANUARY, 5, 10, 7, 0);    // 2017-01-05 10:07:00
    LocalDateTime to = LocalDateTime.of(2017, Month.FEBRUARY, 5, 10, 7, 0);     // 2017-02-05 10:07:00
    Duration duration = Duration.between(from, to);     // 表示从 2017-01-05 10:07:00 到 2017-02-05 10:07:00 这段时间

    long days = duration.toDays();              // 这段时间的总天数
    long hours = duration.toHours();            // 这段时间的小时数
    long minutes = duration.toMinutes();        // 这段时间的分钟数
    long seconds = duration.getSeconds();       // 这段时间的秒数
    long milliSeconds = duration.toMillis();    // 这段时间的毫秒数
    long nanoSeconds = duration.toNanos();      // 这段时间的纳秒数
    //Duration对象还可以通过of()方法创建，该方法接受一个时间段长度，和一个时间单位作为参数：
    Duration duration1 = Duration.of(5, ChronoUnit.DAYS);       // 5天
    Duration duration2 = Duration.of(1000, ChronoUnit.MILLIS);  // 1000毫秒

  }
}
