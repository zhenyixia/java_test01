package com.lyp.basicAPI.fanxing;

public class Demo02{

  public static void main(String[] args){

    try{
      Class<?> aClass = Class.forName("com.lyp.basicAPI.fanxing.Fruit");
      Fruit o = (Fruit)aClass.newInstance();

      Object instance = createInstance(aClass);
    }catch(ClassNotFoundException | InstantiationException e){
      e.printStackTrace();
    }catch(IllegalAccessException e){
      e.printStackTrace();
    }

    try{
      Fruit fruit = createInstance(Fruit.class);
    }catch(IllegalAccessException e){
      e.printStackTrace();
    }catch(InstantiationException e){
      e.printStackTrace();
    }
  }



  private static <T> T createInstance(Class<T> fruitClass) throws IllegalAccessException, InstantiationException{
    return fruitClass.newInstance();
  }
}

class Fruit{

}