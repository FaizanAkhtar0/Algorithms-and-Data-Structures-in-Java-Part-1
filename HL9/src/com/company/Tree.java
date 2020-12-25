package com.company;

public interface Tree<T extends Comparable<T>> {
    public void insert(T data);
    public Node<T> find(T data);
    public T getMax();
    public T getMin();
    public void inOrderTraversal();
    public void printRoot();
}
