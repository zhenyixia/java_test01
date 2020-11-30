package com.lyp.interview.day01;

public class FatherAndSonClass {
  public static void main(String[] args) {
    Father father = new Son();
    father.say();
    father.action();
    System.out.println(father.name);

    //结果为：son
    //    爸爸打儿子！
    /*
    解释1：
    当调用say方法执行的是Son的方法，也就是重写的say方法，而当调用action方法时，执行的是Father的方法。
    普通方法，运用的是动态单分配，是根据new的类型确定对象，从而确定调用的方法；
    静态方法，运用的是静态多分派，是根据静态类型确定对象，因此不是根据new的类型确定调用的方法

    解释2：
    引用毕向东的一段话：
    1，成员变量：编码和运行都参考左边； 2，成员函数（非静态）：编译看左边，运行看右边；
    3，静态函数：编译和运行都看左边。

    解释3：
    举个简单的例子，子类继承父类，但是没有实现其中的方法，当进行向上转型赋值时，调用的就去就只是父类的。
    而静态方法不能重写
     */
  }
}

class Father {
  public String name = "father name";
  public void say() {
    System.out.println("father");
  }

  public static void action() {
    System.out.println("爸爸打儿子！");
  }
}

class Son extends Father {
  public String name = "son name";

  @Override
  public void say() {
    System.out.println("son");
  }

  public static void action() {
    System.out.println("打打！");
  }
}