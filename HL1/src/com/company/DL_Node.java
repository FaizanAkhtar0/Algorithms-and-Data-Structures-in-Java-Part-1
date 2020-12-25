package com.company;

public class DL_Node<T extends Comparable<T>> {

    private T data;
    private DL_Node<T> nextNode;
    private DL_Node<T> previousNode;

    public DL_Node(T data){
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNextNode(DL_Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    public DL_Node<T> getNextNode() {
        return nextNode;
    }

    public DL_Node<T> getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(DL_Node<T> previousNode) {
        this.previousNode = previousNode;
    }

    @Override
    public String toString(){
        return this.data.toString();
    }
}
