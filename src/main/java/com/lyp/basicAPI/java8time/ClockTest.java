package com.lyp.basicAPI.java8time;

import java.time.Clock;
import java.time.Instant;

public class ClockTest {

  public static void main(String[] args) {
    Clock clock = Clock.systemDefaultZone();
    System.out.println(clock);
    System.out.println(clock.millis());
    System.out.println(System.currentTimeMillis());
    System.out.println(clock.getZone());
    Instant instant = clock.instant();
    System.out.println(instant);
    System.out.println(clock.millis());
  }
}
