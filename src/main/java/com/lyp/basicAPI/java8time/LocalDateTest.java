package com.lyp.basicAPI.java8time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalAdjusters;
import org.junit.Test;

public class LocalDateTest {

  public static void main(String[] args) {

  }

  @Test
  public void test1() {
    LocalDate oneday = LocalDate.now();
    System.out.println("今天的日期：" + oneday); //今天的日期：2016-10-20

    // 根据年月日取日期，12月就是12：
    LocalDate crischristmas = LocalDate.of(2014, 12, 25); // -> 2014-12-25

    // 根据字符串取：
    // 严格按照ISO yyyy-MM-dd验证，02写成2都不行，当然也有一个重载方法允许自己定义格式
    //LocalDate.parse("2014-02-29"); // 无效日期无法通过：DateTimeParseException: Invalid date
    LocalDate endOfFeb = LocalDate.parse("2014-02-28");

    //取2016年10月的第1天
    LocalDate firstDay = oneday.with(TemporalAdjusters.firstDayOfMonth());
    System.out.println(firstDay);

    //取2016年10月的第1，2，。。。天，另外一种写法
    LocalDate firstDay2 = oneday.withDayOfMonth(1);
    LocalDate firstDay3 = oneday.withDayOfMonth(2);
    System.out.println(firstDay2 + " " + firstDay3);

    //取2016年10月的最后1天，不用考虑大月，小月，平年，闰年
    LocalDate lastDay = oneday.with(TemporalAdjusters.lastDayOfMonth());
    System.out.println(lastDay);

    //当前日期＋1天
    LocalDate tomorrow = oneday.plusDays(1);
    System.out.println(tomorrow);

    // 取2015年1月第一个周一，这个计算用Calendar要死掉很多脑细胞：
    LocalDate firstMondayOf2015 = LocalDate.parse("2015-01-01").with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)); // 2015-01-05
    System.out.println(firstMondayOf2015);

    LocalDate localDate = LocalDate.of(2018, 2, 12);

    //下一周的该星期
    LocalDate localDate1 = localDate.minusWeeks(-1);
    System.out.println(localDate1);
    //2018-02-19

    //获取下个月的这天
    LocalDate localDate2 = localDate.minusMonths(-1);
    System.out.println(localDate2);
    //2018-03-12

    //下个月的1号
    LocalDate localDate3 = LocalDate.of(localDate.getYear(), localDate.getMonthValue()+1, 1);
    System.out.println(localDate3);
    //2018-03-01

    //判断是否为闰年
    boolean isLeapYear = tomorrow.isLeapYear();
    System.out.println(isLeapYear);
  }

  @Test
  public void test02(){
    //判断两个日期之间相差多少天
    LocalDate date1 = LocalDate.of(2018,9,20);
    LocalDate date2 = LocalDate.of(2018,10,3);
    long l = date2.toEpochDay() - date1.toEpochDay();
    System.out.println(l);

    //某个月有多少天
    LocalDate localDate = LocalDate.of(2018, 2, 22);
    LocalDate lastDay = localDate.with(TemporalAdjusters.lastDayOfMonth());
    int dayOfMonth = lastDay.getDayOfMonth();
    System.out.println(dayOfMonth);

    //比较两个LocalDate的大小 -1 小 1 大 0 等于
    int i = date1.compareTo(date2);
    System.out.println(i);

//    比较两个LocalDate相差多少年、月、日
    Period period = Period.between(date1, date2);
    int years = period.getYears();
    int months = period.getMonths();
    int days = period.getDays();
    System.out.println("years:"+years+", months:"+months+", days:"+days);



  }
}
