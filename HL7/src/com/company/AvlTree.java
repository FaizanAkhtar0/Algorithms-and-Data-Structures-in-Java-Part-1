package com.company;

public class AvlTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    @Override
    public void insert(T data) {
        root = insert(root, data);
    }

    private Node<T> insert(Node<T> node, T data) {

        if (node == null) {
            return new Node<>(data);
        }

        if (data.compareTo(node.getData()) < 0){
            node.setLeftNode(insert(node.getLeftNode(), data));
        }else{
            node.setRightNode(insert(node.getRightNode(), data));
        }

        node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);
        System.out.println("Height of: " + node + " : " + node.getHeight());
        node = settleViolation(data, node);

        return node;
    }

    private Node<T> settleViolation(T data, Node<T> node) {

        int balance = getBalance(node);

        System.out.println("Balance: " + balance + " AT: " + node);

        //Case I Left-Left
        if (balance > 1 && data.compareTo(node.getLeftNode().getData()) < 0){
            System.out.println("Case I Left-Left");
            return rightRotation(node);
        }

        //Case II Right-Right
        if (balance < -1 && data.compareTo(node.getRightNode().getData()) > 0){
            System.out.println("Case II Right-Right");
            return leftRotation(node);
        }

        //Case III Left-Right
        if (balance > 1 && data.compareTo(node.getLeftNode().getData()) > 0){
            System.out.println("Case III Left-Right");
            node.setLeftNode(leftRotation(node.getLeftNode()));
            return rightRotation(node);
        }

        //Case IV Right-Left
        if (balance < -1 && data.compareTo(node.getRightNode().getData()) < 0){
            System.out.println("Case IV Right-Left");
            node.setRightNode(rightRotation(node.getRightNode()));
            return leftRotation(node);
        }

        return node;
    }

    private int height(Node<T> node){

        if (node == null){
            return -1;
        }

        return node.getHeight();
    }

    private int getBalance(Node<T> node){

        if (node ==  null){
            return 0;
        }

        return height(node.getLeftNode()) - height(node.getRightNode());
    }

    private Node<T> rightRotation(Node<T> node){

        System.out.println("Rotating to right on node: " + node);

        Node<T> tempRightNode = node.getLeftNode();
        Node<T> t = tempRightNode.getRightNode();

        tempRightNode.setRightNode(node);
        node.setLeftNode(t);

        node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);
        tempRightNode.setHeight(Math.max(height(tempRightNode.getLeftNode()), height(tempRightNode.getRightNode())) + 1);

        return tempRightNode;
    }

    private Node<T> leftRotation(Node<T> node){

        System.out.println("Rotating to left on node: " + node);

        Node<T> tempLeftNode = node.getRightNode();
        Node<T> t = tempLeftNode.getLeftNode();

        tempLeftNode.setLeftNode(node);
        node.setRightNode(t);

        node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);
        tempLeftNode.setHeight(Math.max(height(tempLeftNode.getLeftNode()), height(tempLeftNode.getRightNode())) + 1);

        return tempLeftNode;
    }

    @Override
    public void delete(T data){

        if (root != null){
            root = delete(root, data);
        }
    }

    private Node<T> delete(Node<T> node, T data) {

        if (node == null){
            return node;
        }

        if (data.compareTo(node.getData()) < 0){
            node.setLeftNode(delete(node.getLeftNode(), data));
        }else if (data.compareTo(node.getData()) > 0){
            node.setRightNode(delete(node.getRightNode(), data));
        }else{

            if (node.getLeftNode() == null && node.getRightNode() == null){
                System.out.println("Removing a leaf node...");
                return null;
            }

            if (node.getLeftNode() == null){
                System.out.println("Removing a right-child node...");
                Node<T> tempNode = node.getRightNode();
                node = null;
                return tempNode;
            }else if(node.getRightNode() == null){
                System.out.println("Removing a left-child node...");
                Node<T> tempNode = node.getRightNode();
                node = null;
                return tempNode;
            }

            System.out.println("Removing a node with two childs(Left-Right)...");
            Node<T> tempNode = getPredecessor(node.getLeftNode());

            node.setData(tempNode.getData());

            node.setLeftNode(delete(node.getLeftNode(), tempNode.getData()));
        }

        node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);

        return settleDeletion(node);
    }

    private Node<T> settleDeletion(Node<T> node) {

        int balance = getBalance(node);

        if (balance > 1){

            if (getBalance(node.getLeftNode()) < 0){
                node.setLeftNode(leftRotation(node.getLeftNode()));
            }

            return rightRotation(node);
        }

        if (balance < 1){
            if (getBalance(node.getRightNode()) < 0){
                node.setRightNode(rightRotation(node.getRightNode()));
            }

            return leftRotation(node);
        }

        return node;
    }


    @Override
    public void traverse() {
        
        if (root == null) return;
        
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node<T> node) {

        if (node.getLeftNode() != null){
            inOrderTraversal(node.getLeftNode());
        }

        System.out.println(node);

        if (node.getRightNode() != null){
            inOrderTraversal(node.getRightNode());
        }
    }

    private Node<T> getPredecessor(Node<T> node) {

        if (node.getRightNode() != null){
            return getPredecessor(node.getRightNode());
        }

        System.out.println("Predecessor: " + node);
        return node;
    }

    @Override
    public T getMaxVal(){

        if (root == null){
            return null;
        }

        return getMax(root);
    }

    private T getMax(Node<T> node) {

        if (node.getRightNode() != null){
            return getMax(node.getRightNode());
        }

        return node.getData();
    }

    @Override
    public T getMinVal(){

        if (root == null){
            return null;
        }

        return getMin(root);
    }


    private T getMin(Node<T> node) {

        if (node.getLeftNode() != null){
            return getMin(node.getLeftNode());
        }

        return node.getData();
    }

}
