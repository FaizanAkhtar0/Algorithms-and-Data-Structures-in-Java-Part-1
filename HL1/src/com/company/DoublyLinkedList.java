package com.company;

@SuppressWarnings("Duplicates")
public class DoublyLinkedList<T extends Comparable<T>> implements DL_List<T>{

    private DL_Node<T> root;
    private DL_Node<T> tail;
    private int sizeOfList;

    @Override
    public void insert(T data) {

        insertDataAtBeginning(data);
        sizeOfList++;
    }

    private void insertDataAtBeginning(T data) {
        DL_Node<T> newNode = new DL_Node<>(data);
        newNode.setNextNode(root);

        if (root == null){
            tail = newNode;
        }else {
            root.setPreviousNode(newNode);
        }

        this.root = newNode;
    }

    private void insertDataAtEnd(T data){
        DL_Node<T> newNode = new DL_Node<>(data);

        if (tail == null){
            root = newNode;
        }else {
            tail.setNextNode(newNode);
            newNode.setPreviousNode(tail);
        }

        this.tail = newNode;
    }

    @Override
    public void remove(T data) {

        if (this.root == null) return;

        --this.sizeOfList;

        if (this.root.getData().compareTo(data) == 0){
            this.root = this.root.getNextNode();
        }else {
            remove(data, root, root.getNextNode());
        }
    }

    private void remove(T dataToRemove, DL_Node<T> previousNode, DL_Node<T> actualNode) {
        while (actualNode != null) {
            if (actualNode.getData().compareTo(dataToRemove) == 0){
                previousNode.setNextNode(actualNode.getNextNode());
                actualNode = null;
                return;
            }

            previousNode = actualNode;
            actualNode = actualNode.getNextNode();
        }
    }

    @Override
    public void traverseList() {
        if (this.root == null) return;

        DL_Node<T> actualNode = this.root;

        while (actualNode != null){
            if (actualNode.getNextNode() == null){
                System.out.print(actualNode + " -> null");
            }else{
                System.out.print(actualNode + " <->  ");
            }
            actualNode = actualNode.getNextNode();
        }
    }

    @Override
    public DL_Node<T> removeFromBeginning() {

        if (isEmpty()){
            return null;
        }

        DL_Node<T> removedNode = this.root;
        if(root.getNextNode() == null){
            tail = null;
        }else {
            root.getNextNode().setPreviousNode(null);
        }

        root = root.getNextNode();
        sizeOfList--;
        removedNode.setNextNode(null);
        return removedNode;
    }

    @Override
    public DL_Node<T> removeFromEnd() {

        if (isEmpty()){
            return null;
        }

        DL_Node<T> removedNode = this.tail;
        if(tail.getPreviousNode() == null){
           root = null;
        }else {
           tail.getPreviousNode().setNextNode(null);
        }

        tail = tail.getPreviousNode();
        sizeOfList--;
        removedNode.setPreviousNode(null);
        return removedNode;
    }

    private boolean isEmpty(){
        return this.root == null && this.tail == null;
    }

    @Override
    public int size() {
        return this.sizeOfList;
    }
}
