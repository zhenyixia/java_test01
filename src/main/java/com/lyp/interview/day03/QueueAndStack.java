package com.lyp.interview.day03;

public class QueueAndStack {
}

class Node<T> {
  public T data;

  public Node next;

  public Node() {
  }

  public Node(T data, Node next) {
    this.data = data;
    this.next = next;
  }
}