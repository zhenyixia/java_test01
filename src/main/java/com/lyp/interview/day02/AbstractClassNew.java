package com.lyp.interview.day02;

/**
 * 通过上转型来“实例化”一个抽象类
 */
public abstract class AbstractClassNew {
  protected String name = "aaa";

  public void test(){
    System.out.println("father test method");
  }

  abstract void read();
}

abstract class AbstractClassNew2 {
  protected String name = "aaa";

  public void test(){
    System.out.println("father test method");
  }

  abstract void read();
}

class AbstractSon extends AbstractClassNew{

  public static void main(String[] args) {
    AbstractClassNew aa = new AbstractSon();
    aa.test();
    aa.read();
  }

  @Override
  void read() {
    System.out.println("son read method");
  }
}
/**
 * 上述代码可以看出，1，这样算是间接实现了抽象类； 2，子类必须实现抽象类的抽象方法。
 */


