package com.lyp.basicAPI;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.SerializationUtils;

public class ObjectClone{
  public static void main(String[] args) throws CloneNotSupportedException{
    UserDO userDO = new UserDO().setName("小明").setAge(10);
    Programmer programmer = new Programmer("20年");
    userDO.setProgrammerList(Arrays.asList(programmer));

    // 不需要实现Serializable接口，但是需要实现Cloneable接口
    // clone后设置两个属性，一个浅属性 age，一个深属性 workyear
    UserDO clone = (UserDO)userDO.clone();
    clone.setAge(11);
    List<Programmer> programmerList = clone.getProgrammerList();
    Programmer programmer1 = programmerList.get(0);
    programmer1.setWorkYear("30年");

    // 从打印结果可以看到，浅属性的值不会一起变化。而深属性的值会一起变化。这就是浅拷贝
    System.out.println(userDO);  //UserDO{name='小明', age=10, programmerList=[Programmer{workYear='30年'}]}
    System.out.println(clone);   //UserDO{name='小明', age=11, programmerList=[Programmer{workYear='30年'}]}

    // 注意，必须实现Serializable接口
    UserDO clone1 = SerializationUtils.clone(userDO);
    clone.setAge(12);
    programmer1.setWorkYear("40年");
    System.out.println(userDO);
    System.out.println(clone);
    System.out.println(clone1);
    /**
     * 总结： 实现Clonable接口只能实现浅拷贝，如果属性只有集合或对象的话，则不能拷贝
     * 而SerializationUtils.clone 可以实现深拷贝，但是所有涉及的对象都必须实现 Serializable接口
     * 实现Clonable接口的浅拷贝效率要高。
     */
  }
}

class Programmer implements Serializable{
  String workYear;

  public String getWorkYear(){
    return workYear;
  }

  public void setWorkYear(String workYear){
    this.workYear = workYear;
  }

  public Programmer(String workYear){
    this.workYear = workYear;
  }

  @Override
  public String toString(){
    return "Programmer{" + "workYear='" + workYear + '\'' + '}';
  }
}

class UserDO implements Cloneable,Serializable{

  /**
   * 姓名
   */
  private String name;

  /**
   * 年龄
   */
  private Integer age;

  private List<Programmer> programmerList;

  @Override
  protected Object clone() throws CloneNotSupportedException{
    return super.clone();
  }

  public String getName(){
    return name;
  }

  public UserDO setName(String name){
    this.name = name;
    return this;
  }

  public Integer getAge(){
    return age;
  }

  public UserDO setAge(Integer age){
    this.age = age;
    return this;
  }

  public List<Programmer> getProgrammerList(){
    return programmerList;
  }

  public void setProgrammerList(List<Programmer> programmerList){
    this.programmerList = programmerList;
  }

  @Override
  public String toString(){
    return "UserDO{" + "name='" + name + '\'' + ", age=" + age + ", programmerList=" + programmerList + '}';
  }
}