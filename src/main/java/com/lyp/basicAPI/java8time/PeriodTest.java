package com.lyp.basicAPI.java8time;

import java.time.LocalDate;
import java.time.Period;
//参考：https://lw900925.github.io/java/java8-newtime-api.html
public class PeriodTest {
  public static void main(String[] args) {
    /**
     * Period在概念上和Duration类似，区别在于Period是以年月日来衡量一个时间段，比如2年3个月6天：
     */
    Period period = Period.of(2, 3, 6);
    /**
     * Period对象也可以通过between()方法创建，值得注意的是，由于Period是以年月日衡量时间段，
     * 所以between()方法只能接收LocalDate类型的参数：
     */
    // 2017-01-05 到 2017-02-05 这段时间
     period = Period.between(
        LocalDate.of(2017, 1, 5),
        LocalDate.of(2017, 2, 5));


  }
}
