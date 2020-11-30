package com.lyp.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/**
 * windows命名格式
 */
public class WindowsNameFormatUtils {

  /**
   * 命名排除的字符
   */
  public static final String EXCLUDE_CHARS = "[\\\\|/|:|*|?|\"|<|>]*";

  public static final Pattern pattern = Pattern.compile(EXCLUDE_CHARS);


  public static final String en2Zh(String param) {
    if (StringUtils.isBlank(param)) {
      return param;
    }

    Matcher matcher = pattern.matcher(param);
    if (!matcher.find()) {
      return param;
    }

    param = param.replace("\\", "").replace("|", "").replace("*", "")
        .replace("?", "？").replace("\"", "'").replace("<", "(")
        .replace(">", ")").replace("<", "(").replace(":","：");
    return param;
  }


  public static void main(String[] args) {
    String ss = "\\/:*?\"<>|";
    Pattern pattern = Pattern.compile(EXCLUDE_CHARS);
    Matcher matcher = pattern.matcher(ss);
    boolean b = matcher.matches();
    System.out.println(b);
  }
}
