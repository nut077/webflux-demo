package com.github.nut077.webfluxdemo.util;

import lombok.SneakyThrows;

public class SleepUtil {

  @SneakyThrows
  public static void sleepSeconds(int seconds) {
    Thread.sleep(seconds * 1000L);
  }
}
