package com.company;

public interface DL_List<T> {
    public void insert(T data);
    public void remove(T data);
    public void traverseList();
    public DL_Node removeFromBeginning();
    public DL_Node removeFromEnd();
    public int size();
}
