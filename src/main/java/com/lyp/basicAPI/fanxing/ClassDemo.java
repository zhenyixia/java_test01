package com.lyp.basicAPI.fanxing;

/**
 * 参考 《java-泛型学习》技术总结
 */
public class ClassDemo{
  public static void main(String[] args){
    /*Box box = new Box();
    box.setObject(new Apple());
    Apple apple = (Apple)box.getObject();
    System.out.println(apple);

    Box<Apple> appleBox = new Box<>();
    Apple object = appleBox.getObject();
    System.out.println(object);*/
    Test<String, Integer, Boolean> obj3Test = new Test<>();
    obj3Test.print("1", 1, true);
  }
}

class Box<T>{
  private T object;

  public T getObject(){
    return object;
  }

  public void setObject(T object){
    this.object = object;
  }
}

class Apple{

}

class Test<T1, T2, T3>{
  public void print(T1 t1, T2 t2, T3 t3){
    System.out.println(t1.getClass());
    System.out.println(t2.getClass());
    System.out.println(t3.getClass());
  }

  public static void main(String[] args){
    Test<String, Integer, Boolean> obj3Test = new Test<>();
    obj3Test.print("1", 1, true);
  }
}