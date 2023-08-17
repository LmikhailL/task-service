package com.ates.taskservice.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class UserUuidHolder {

  private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

  public static ThreadLocal<String> getThreadLocal() {
    return THREAD_LOCAL;
  }

  public static void setUuid(final String uuid) {
    UserUuidHolder.getThreadLocal().set(uuid);
  }

  public static String getUuid() {
    return THREAD_LOCAL.get();
  }

  public static void remove() {
    THREAD_LOCAL.remove();
  }
}
