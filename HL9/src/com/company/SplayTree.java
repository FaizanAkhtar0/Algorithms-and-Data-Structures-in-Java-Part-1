package com.company;

public class SplayTree<T extends Comparable<T>> implements Tree<T>{

    private int size;
    private Node<T> rootNode;

    @Override
    public void insert(T data) {

        Node<T> tempNode = this.rootNode;
        Node<T> parentNode = null;

        while(tempNode != null){

            parentNode = tempNode;

            if (tempNode.getData().compareTo(data) < 0){
                tempNode = tempNode.getRightNode();
            }else{
                tempNode = tempNode.getLeftNode();
            }
        }

        tempNode = new Node<>(data);
        tempNode.setParent(parentNode);

        if (parentNode == null){
            this.rootNode = tempNode;
        }else if (parentNode.getData().compareTo(tempNode.getData()) < 0){
            parentNode.setRightNode(tempNode);
        }else{
            parentNode.setLeftNode(tempNode);
        }

        splay(tempNode);
        this.size++;
    }

    @Override
    public Node<T> find(T data) {

        Node<T> tempNode = this.rootNode;

        while(tempNode != null){

            if (tempNode.getData().compareTo(data) < 0){
                tempNode = tempNode.getRightNode();
            }else if (tempNode.getData().compareTo(data) > 0){
                tempNode = tempNode.getLeftNode();
            }else{
                splay(tempNode);
                return tempNode;
            }
        }
        splay(tempNode);

        return null;
    }

    private void splay(Node<T> node) {

        while (node.getParent() != null){
            //ZIG SITUATION
            if (node.getParent().getParent() == null){  //node is a leftNode and grandparent is a null...
                if (node.getParent().getLeftNode() == node){
                    rightRotation(node.getParent());
                }else {
                    leftRotation(node.getParent());  //node is a rightNode and grandparent is a null...
                }

            //ZIG-ZIG SITUATION
            } else if (node.getParent().getLeftNode() == node  //  leftNode and parent is a leftNode too...
                    && node.getParent().getParent().getLeftNode() == node.getParent()){
                rightRotation(node.getParent().getParent());
                rightRotation(node.getParent());

            }else if (node.getParent().getRightNode() == node //  rightNode and parent is a rightNode too...
                    && node.getParent().getParent().getRightNode() == node.getParent()){
                leftRotation(node.getParent().getParent());
                leftRotation(node.getParent());

            //ZIG-ZAG SITUATION
            }else if (node.getParent().getLeftNode() == node  //  leftNode and parent is a rightNode...
                && node.getParent().getParent().getRightNode() == node.getParent()){
                rightRotation(node.getParent());
                leftRotation(node.getParent());
            }else{
                leftRotation(node.getParent()); //  rightNode and parent is a leftNode...
                rightRotation(node.getParent());
            }
        }
    }

    @Override
    public void printRoot(){
        System.out.println("RootNode: " + rootNode);
    }

    public boolean isEmpty(){
        return this.rootNode == null;
    }

    public int size(){
        return this.size;
    }

    @Override
    public T getMax() {

        if (!isEmpty()){
            return getMax(rootNode);
        }

        return null;
    }

    private T getMax(Node<T> node) {

        if (node.getRightNode() != null){
            return getMax(node.getRightNode());
        }else{
            return node.getData();
        }
    }

    @Override
    public T getMin() {

        if (!isEmpty()){
            return getMin(rootNode);
        }

        return null;
    }

    private T getMin(Node<T> node) {
        if (node.getLeftNode() != null){
            return getMin(node.getLeftNode());
        }else{
            return node.getData();
        }
    }

    @Override
    public void inOrderTraversal() {

        if (this.rootNode != null){
            inOrderTraversal(rootNode);
        }
    }

    private void inOrderTraversal(Node<T> node) {

        if (node.getLeftNode() != null){
            inOrderTraversal(node.getLeftNode());
        }

        System.out.print(" -> ");

        if (node.getRightNode() != null){
            inOrderTraversal(node.getRightNode());
        }
    }

    private void rightRotation(Node<T> node){

        System.out.println("Rotating to right on node: " + node);

        Node<T> tempLeftNode = node.getLeftNode();
        node.setLeftNode(tempLeftNode.getRightNode());

        if (node.getLeftNode() != null){
            node.getLeftNode().setParent(node);
        }

        tempLeftNode.setParent(node.getParent());

        if (tempLeftNode.getParent() == null){
            this.rootNode = tempLeftNode;
        }else if (node == node.getParent().getLeftNode()){
            node.getParent().setLeftNode(tempLeftNode);
        }else{
            node.getParent().setRightNode(tempLeftNode);
        }

        if (tempLeftNode != null){
            tempLeftNode.setRightNode(node);
        }

        node.setParent(tempLeftNode);
    }

    private void leftRotation(Node<T> node){

        System.out.println("Rotating to left on node: " + node);

        Node<T> tempRightNode = node.getRightNode();
        node.setRightNode(tempRightNode.getLeftNode());

        if (node.getRightNode() != null){
            node.getRightNode().setParent(node);
        }

        tempRightNode.setParent(node.getParent());

        if (tempRightNode.getParent() == null){
            this.rootNode = tempRightNode;
        }else if (node == node.getParent().getRightNode()){
            node.getParent().setLeftNode(tempRightNode);
        }else{
            node.getParent().setRightNode(tempRightNode);
        }

        if (tempRightNode != null){
            tempRightNode.setLeftNode(node);
        }

        node.setParent(tempRightNode);
    }
}
