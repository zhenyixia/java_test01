package com.lyp.interview.computerexam;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 题目描述 输入一个表达式（用字符串表示），求这个表达式的值。 保证字符串中的有效字符包括[‘0’-‘9’],‘+’,‘-’, ‘*’,‘/’ ,‘(’， ‘)’,‘[’, ‘]’,‘{’ ,‘}’。且表达式一定合法。
 *
 *
 *
 * 输入描述: 输入一个算术表达式
 *
 * 输出描述: 得到计算结果
 *
 * 示例1 输入 3+2*{1+2*[-4/(8-6)+7]} 输出 25
 */
public class CE009Todo {
  public static void main(String[] args) throws Exception {

    other1();
  }

  /**
   *
   * @throws Exception
   */
  public static void my1() throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = reader.readLine()) != null) {

    }
  }

  /**
   * 6ms 9172
   */
  public static void other1() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = "";
    while ((line = br.readLine()) != null) {
      // List 存放后缀表达式
      List<String> list = new ArrayList<>();
      // 定义操作符栈stack，用于存放操作符 + - * / (
      Stack<Character> stack = new Stack<>();
      for (int i = 0; i < line.length(); i++) {
        // 定义一个字符，记录字符串当前循环的变量
        char c = line.charAt(i);
        // 取出以当前字符开头数字结尾的整数字符串进行判定是否为数字
        if (isNum(c)) {
          int start = i; //记录开头数字的
          if (i == line.length() - 1) {
            i++;     //加1，因为subString取值是前闭后开
          } else {
            while (isNum(line.charAt(++i))) {   //先加减再运算，因为subString取值是前闭后开
            }
          }
          list.add(line.substring(start, i));
          i--;
        } else if (c == '(' || c == '[' || c == '{') {  //为左括号，则入栈
          stack.push(c);
        } else if (c == ')' || c == ']' || c == '}') {   //为右括号，则
          while (stack.peek() != '(' && stack.peek() != '[' && stack.peek() != '{') {
            list.add(String.valueOf(stack.pop()));
          }
          stack.pop();
        } else if (c == '-') {
          //判断是减号还是负号
          if ((i != 0 && (isNum(line.charAt(i - 1)) && isNum(line.charAt(i + 1)))) || (line.charAt(i - 1) == ')'
              || line.charAt(i - 1) == ']' || line.charAt(i - 1) == '}') || (line.charAt(i + 1) == '(' || line.charAt(i + 1) == '['
              || line.charAt(i + 1) == '{')) { //减号
            // 优先级 小于 栈顶运算符
            while (!greaterThan(c, stack)) {
              list.add(String.valueOf(stack.pop()));
            }
            stack.push(c);
          } else { //负号
            int start = i;
            while (isNum(line.charAt(++i))) {
            }
            list.add(line.substring(start, i));
            i--;
          }
        } else if (c == '+' || c == '*' || c == '/') {
          while (!greaterThan(c, stack)) {
            list.add(String.valueOf(stack.pop()));
          }
          stack.push(c);
        }
      }
      while (!stack.isEmpty()) {
        list.add(String.valueOf(stack.pop()));
      }

      //            System.out.println(list.toString());
      //计算后缀表达式
      int result = calculate(list);
      System.out.println(result);
    }
  }

  //判断是否为数字
  public static boolean isNum(char c) {
    return (c >= '0' && c <= '9');
  }

  // 比较运算符与栈顶运算符的优先级
  public static boolean greaterThan(char c, Stack<Character> stack) {
    if (stack.isEmpty()) {
      return true;
    } else {
      char c1 = stack.peek();
      if (c == '*' || c == '/') {
        return !(c1 == '*' || c1 == '/');
      } else {
        return (c1 == '(' || c1 == '[' || c1 == '{');
      }
    }
  }

  public static int calculate(List<String> list) {
    // 定义数字栈，存放后缀表达式计算过程中的值
    Stack<Integer> stack = new Stack<>();
    int n1, n2;
    for (int i = 0; i < list.size(); i++) {
      switch (list.get(i)) {
        case "+":
          stack.push(stack.pop() + stack.pop());
          break;
        case "-":
          n1 = stack.pop();
          n2 = stack.pop();
          stack.push(n2 - n1);
          break;
        case "*":
          stack.push(stack.pop() * stack.pop());
          break;
        case "/":
          n1 = stack.pop();
          n2 = stack.pop();
          stack.push(n2 / n1);
          break;
        default:
          stack.push(Integer.parseInt(list.get(i)));
      }
    }
    return stack.pop();
  }
}
