package com.lyp.interview.computerexam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * 题目描述 考试题目和要点：
 *
 * 1、中文大写金额数字前应标明“人民币”字样。中文大写金额数字应用壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、佰、仟、万、亿、元、角、分、零、整等字样填写。
 *
 * 2、中文大写金额数字到“元”为止的，在“元”之后，应写“整字，如532.00应写成“人民币伍佰叁拾贰元整”。在”角“和”分“后面不写”整字。
 *
 * 3、阿拉伯数字中间有“0”时，中文大写要写“零”字，阿拉伯数字中间连续有几个“0”时，中文大写金额中间只写一个“零”字，如6007.14，应写成“人民币陆仟零柒元壹角肆分“。 4、10应写作“拾”，100应写作“壹佰”。例如，1010.00应写作“人民币壹仟零拾元整”，110.00应写作“人民币壹佰拾元整”
 * 5、十万以上的数字接千不用加“零”，例如，30105000.00应写作“人民币叁仟零拾万伍仟元整”
 *
 * 本题含有多组样例输入。
 *
 * 输入描述: 输入一个double数
 *
 * 输出描述: 输出人民币格式
 *
 * 示例1
 *
 * 151121.15 10012.02 输出
 *
 * 人民币拾伍万壹仟壹佰贰拾壹元壹角伍分 人民币壹万零拾贰元贰分
 */
public class CE013 {
  private static final List<String> base = Arrays.asList("零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖");

  private static final List<String> base2 = Arrays.asList("拾", "佰", "仟", "万", "亿");

  private static final List<String> base3 = Arrays.asList("元", "角", "分");

  private static final String pre = "人民币";

  private static final String suf = "整";

  public static void main(String[] args) throws Exception {
    my1();
  }

  /**
   * 未完成？？？？
   * ????暂时找不到通不过的用例，不知道为什么不对？？？？ 输入： 151121.15 10012.02 30105000.00 1010.00 100 6007.14 110.00 6007.14 532.00 9876541320 6.1 输出：
   * 人民币拾伍万壹仟壹佰贰拾壹元壹角伍分 人民币壹万零拾贰元贰分 人民币叁仟零拾万伍仟元整 人民币壹仟零拾元整 人民币壹佰元整 人民币陆仟零柒元壹角肆分 人民币壹佰拾元整 人民币陆仟零柒元壹角肆分 人民币伍佰叁拾贰元整 人民币玖拾捌亿柒仟陆佰伍拾肆万壹仟叁佰贰拾元整
   * 人民币陆元壹角
   * todo
   */
  public static void my1() throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = reader.readLine()) != null) {
      // 分别存储： 人民币，亿，万，个，小数点后，整，六部分读法
      String[] readers = {pre, "", "", "", "", ""};

      String origin = line;
      //1,处理小数点后
      int index = line.indexOf(".");
      if (index != -1) {
        String underZeroStr = line.substring(index + 1);
        origin = line.substring(0, index);
        int underZero = Integer.parseInt(underZeroStr);

        if (underZeroStr.length() == 2) {
          if (underZero == 0) {
            readers[4] = "";
            readers[5] = suf;
          } else if (underZero < 10) {
            readers[4] = base.get(underZero) + "分";
          } else if (underZero % 10 == 0) {
            readers[4] = base.get(underZero / 10) + "角";
          } else {
            readers[4] = base.get(underZero / 10) + "角" + base.get(underZero % 10) + "分";
          }
        } else if (underZeroStr.length() == 1) {
          readers[4] = base.get(underZero) + "角";
        }
      } else {
        readers[5] = suf;
      }

      readers[4] = "元" + readers[4];

      // 分别处理
      if (origin.length() <= 4) {
        String ss = processFourBit(origin);
        if (ss.startsWith("零")) {
          ss = ss.substring(1);
        }
        readers[3] = ss;
      } else if (origin.length() <= 8) {
        String s1 = processFourBit(origin.substring(0, origin.length() - 4));
        if (s1.startsWith("零")) {
          s1 = s1.substring(1);
        }
        readers[2] = s1 + "万";
        String s2 = processFourBit(origin.substring(origin.length() - 4));
        if (s2.equals("零")) {
          readers[3] = "";
        } else {
          readers[3] = s2;
        }
      } else {
        String s1 = processFourBit(origin.substring(0, origin.length() - 8));
        if (s1.startsWith("零")) {
          s1 = s1.substring(1);
        }
        readers[1] = s1 + "亿";
        String s2 = processFourBit(origin.substring(origin.length() - 8, origin.length() - 4));
        if (s2.equals("零")) {
          readers[2] = "";
        } else {
          if (s2.startsWith("零")) {
            s2 = s2.substring(1);
          }
          readers[2] = s2 + "万";
        }

        String s3 = processFourBit(origin.substring(origin.length() - 4));
        if (s3.equals("零")) {
          readers[3] = "";
        } else {
          readers[3] = s3;
        }
      }
      String result = "";
      for (String ss : readers) {
        result += ss;
      }
      System.out.println(result);
    }
  }

  public static String processFourBit(String fourString) {
    String result;
    int temp = Integer.parseInt(fourString);

    int t1 = temp / 1000;
    result = base.get(t1);
    if (t1 != 0) {
      result += "仟";
    }

    int t2 = temp % 1000 / 100;
    result += base.get(t2);
    if (t2 != 0) {
      result += "佰";
    }

    if (result.equals("零零")) {
      result = "零";
    }

    int t3 = temp % 1000 % 100 / 10;
    if (t3 == 1) {
      result += "拾";
    } else if (t3 != 0) {
      result = result + base.get(t3) + "拾";
    } else {
      result = result + "零";
    }

    if (result.endsWith("零零")) {
      result = result.substring(0, result.length() - 1);
    }

    int t4 = temp % 1000 % 100 % 10;
    if (t4 == 0 && result.endsWith("零")) {
      result = result.substring(0, result.length() - 1);
    } else if (t4 != 0) {
      result += base.get(t4);
    }

    return result;
  }

  private static void other1() {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      double number = scanner.nextDouble();
      String value = new DecimalFormat("#0.00").format(number);
      String[] segments = value.split("\\.");
      long integer = Long.valueOf(segments[0]);
      initUnitArray(segments[0].length());
      int decimal = Integer.valueOf(segments[1]);
      String result = "人民币" + parseInteger(integer, 0) + "元" + parseDecimal(decimal);
      result = result.replaceAll("(\\u96f6[\\u62fe\\u4f70\\u4edf])+", "零"); //移除连续的零
      result = result.replaceAll("(\\u96f6+)([\\u5143\\u4e07\\u4ebf])", "$2"); //移除某些特殊单位前面的零
      result = result.replaceAll("(\\u4ebf)(\\u4e07)", "$1"); //不存在亿万的单位，需要转换。
      result = result.replaceAll("(\\u5e01)(\\u5143)", "$1"); //不存在此单位，进行转换
      result = result.replaceAll("(\\u58f9)(\\u62fe)", "$2");//“壹拾”替换成“拾”
      System.out.println(result);
    }
  }

  private static String parseInteger(long origin, int parsedLength) {
    String formatted = parseNum((int) (origin % 10)) + getUnit(parsedLength);
    if (origin >= 10) {
      return parseInteger(origin / 10, parsedLength + 1) + formatted;
    }
    return formatted;
  }

  private static String parseDecimal(int origin) {
    if (origin == 0) {
      return "整";
    } else {
      return (origin / 10 != 0 ? parseNum(origin / 10) + "角" : "") + (origin % 10 != 0 ? parseNum(origin % 10) + "分" : "");
    }
  }

  private static String parseNum(int num) {
    String[] translate = {
        "零", "壹", "贰", "叁",
        "肆", "伍", "陆", "柒",
        "捌", "玖"
    };
    return translate[num];
  }

  private static List<String> UNITS;

  private static void initUnitArray(int numLength) {
    String[] units = {
        "", "拾", "佰", "仟",
        "万", "拾", "佰", "仟",
        "亿", "拾", "佰", "仟",
        "万", "拾", "佰", "仟"
    };
    UNITS = new ArrayList<>(numLength);
    for (String item : units) {
      UNITS.add(item);
    }
    if (numLength > units.length) {
      int offset = numLength - units.length;
      for (int index = 0; index < offset; index++) {
        switch (index % 8) {
          case 0:
            UNITS.add("万");
            break;
          case 1:
          case 5:
            UNITS.add("拾");
            break;
          case 2:
          case 6:
            UNITS.add("佰");
            break;
          case 3:
          case 7:
            UNITS.add("仟");
            break;
          case 4:
            UNITS.add("亿");
            break;
        }
      }
    }
  }

  private static String getUnit(int length) {
    return UNITS.get(length);
  }
}
