package com.lyp.interview.bean;

public class Child extends Parent {

    String name;

    public Child(int d) {
        super(d);
//        super;
    }

    public Child(String s, int d) {
        super(d);
        name = s;
    }

    public static void main(String[] args) {
        Child child = new Child(34);
    }

}

class Parent {

    private int data;

    public Parent(int d) {
        data = d;
    }
}
