package com.lyp.basicAPI;

import com.lyp.interview.bean.Apple;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

public class ReadPropertiesTest {


  public static void main(String[] args) throws
      IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    Apple a;
    List<Apple> aList = new ArrayList<>();
    for (int i = 10; i < 1000000; i++) {
      a = new Apple();
      a.setAddress("address" + i);
      a.setName("name" + i);
      a.setAge(i);
      aList.add(a);
    }

//    System.out.println(aList);

    String[] attrs = {"name", "address", "age"};

    testBeanUtils(aList, attrs);
    testBeanUtils2(aList, attrs);

    
  }

  private static <T> void testBeanUtils(List<T> aList, String[] attrs)
      throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    long start = System.currentTimeMillis();
    for (T o : aList) {
      for (String attr : attrs) {
        Object val = PropertyUtils.getProperty(o, attr);
//        System.out.print(val + "\t");
      }
    }

    System.out.println((System.currentTimeMillis() - start) / 1000);
  }

  private static <T> void testBeanUtils2(List<T> aList, String[] attrs)
      throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    long start = System.currentTimeMillis();
    for (T o : aList) {
      for (String attr : attrs) {
        String val = BeanUtils.getProperty(o, attr);
//        System.out.print(val + "\t");
      }
    }

    System.out.println((System.currentTimeMillis() - start) / 1000);
  }


}
