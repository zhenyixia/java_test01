package com.lyp.interview.day02;

import java.io.Serializable;

public class AbstractAndInteger {
  private String name;
}

class AbstractClass02 {
  private String name;
}

class AbstractClass03 extends AbstractAndInteger implements Serializable, Interface02 {
  private String name;
}

class AbstractClass04 {

}

interface Interface01 {
//  private String name;

}

interface Interface02 extends Interface01 {
  default void test() {
    System.out.println("default test");
  }
}

interface Interface03 extends Interface01, Interface02 {

}
/**
 * 从以上代码可以看出：
 * 1，抽象类中可以没有抽象方法，也可以没有成员变量，可以为空
 * 2，抽象类可以只能继承一个抽象类，实现多个接口
 * 3，接口可以继承接口，并且是多个接口
 * 4,java8后接口增加了default方法，实现类可以选择实现该方法。默认方法主要优势是提供了一种拓展接口的方法，
 * 而不破坏现有代码。另一个优势是该方法是可选的，子类可以根据不同的需求复写或默认实现。
 */
