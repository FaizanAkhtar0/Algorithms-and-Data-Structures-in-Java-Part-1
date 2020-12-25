package com.company;

public interface Tree<T> {
    public void insert(T data);
    public void traverse();
    public void delete(T data);
    public T getMaxVal();
    public T getMinVal();
}
