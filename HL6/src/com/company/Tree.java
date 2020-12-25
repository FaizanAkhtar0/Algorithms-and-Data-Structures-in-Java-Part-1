package com.company;


public interface Tree<T> {
    public void traversal();
    public void insert(T data);
    public void delete(T data);
    public T getMaxVal();
    public T getMinVal();
}
