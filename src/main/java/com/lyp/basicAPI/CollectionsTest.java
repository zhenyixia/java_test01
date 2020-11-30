package com.lyp.basicAPI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class CollectionsTest {

  public static void main(String[] args) {

  }

  @Test
  public void sortTest() {
    List<String> ss = new ArrayList<>();
    ss.add("klfs");
    ss.add("ldlfs");
    ss.add("vcfs");
    ss.add("akfs");
    System.out.println("原来顺序------");
    System.out.println(ss);

    System.out.println("2，逆向排序------");
    Collections.sort(ss, Collections.<String>reverseOrder());
    System.out.println(ss);

    System.out.println("1，正向排序------");
    Collections.sort(ss);
    System.out.println(ss);

    System.out.println("3，从后向前反转------");
    Collections.reverse(ss);
    System.out.println(ss);

    /**
     * 总结：
     * 1，排序只有正向和逆向
     * 2，逆向排序也可以这样实现：1，先正向，2，再反转
     * 3，同上，正向排序正好可以相反
     */
  }

  @Test
  public void nCopiesTest() {
    List<String> ss = new ArrayList<>(Collections.nCopies(6,"a"));
    System.out.println(ss);

  }


//  @Test
//  public void sortTest() {


  //  @Test
//  public void sortTest() {


  //  @Test
//  public void sortTest() {

  //  @Test
//  public void sortTest() {

}
