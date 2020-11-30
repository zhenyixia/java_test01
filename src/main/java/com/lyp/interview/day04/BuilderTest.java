package com.lyp.interview.day04;

public class BuilderTest {
  public static void main(String[] args) {
    A a = new A.Builder("name").address("address").build();
  }
}

class A {

  private String name;

  private String address;

  public A(Builder builder) {
    this.name = builder.name;
    this.address = builder.address;
  }

  public static class Builder {
    private String name;

    private String address;

    public Builder(String name) {
      this.name = name;
    }

    /*public Builder() {
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }*/

    public Builder address(String address) {
      this.address = address;
      return this;
    }

    public A build() {
      return new A(this);
    }
  }
}
