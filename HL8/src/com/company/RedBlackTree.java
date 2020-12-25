package com.company;

public class RedBlackTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    @Override
    public void traverse() {

        if (root != null){
            inOrderTraversal(root);
        }
    }

    private void inOrderTraversal(Node<T> node) {

        if (node.getLeftNode() != null){
            inOrderTraversal(node.getLeftNode());
        }

        System.out.print(node + " - ");

        if (node.getRightNode() != null){
            inOrderTraversal(node.getRightNode());
        }
    }

    @Override
    public void insert(T data) {

        Node<T> node = new Node<>(data);
        root = insertIntoTree(root, node);

        fixViolations(node);
    }

    private void fixViolations(Node<T> node) {

        Node<T> parentNode = null;
        Node<T> grandParentNode = null;

        while(node != root && node.getColor() != NodeColor.BLACK && node.getParent().getColor() == NodeColor.RED){

            parentNode = node.getParent();
            grandParentNode = node.getParent().getParent();

            if (parentNode == grandParentNode.getLeftNode()){
                Node<T> uncle = grandParentNode.getRightNode();

                if (uncle != null &&  uncle.getColor() == NodeColor.RED){
                    grandParentNode.setColor(NodeColor.RED);
                    parentNode.setColor(NodeColor.BLACK);
                    uncle.setColor(NodeColor.BLACK);
                    node = grandParentNode;
                }else {
                    if (node == parentNode.getRightNode()){
                        leftRotation(parentNode);
                        node = parentNode;
                        parentNode = node.getParent();
                    }
                    rightRotation(grandParentNode);
                    NodeColor tempColor = parentNode.getColor();
                    parentNode.setColor(grandParentNode.getColor());
                    grandParentNode.setColor(tempColor);
                    node = parentNode;
                }
            }else {
                Node<T> uncle = grandParentNode.getLeftNode();

                if (uncle != null &&  uncle.getColor() == NodeColor.RED){
                    grandParentNode.setColor(NodeColor.RED);
                    parentNode.setColor(NodeColor.BLACK);
                    uncle.setColor(NodeColor.BLACK);
                    node = grandParentNode;
                }else {
                    if (node == parentNode.getLeftNode()){
                        rightRotation(parentNode);
                        node = parentNode;
                        parentNode = node.getParent();
                    }
                    leftRotation(grandParentNode);
                    NodeColor tempColor = parentNode.getColor();
                    parentNode.setColor(grandParentNode.getColor());
                    grandParentNode.setColor(tempColor);
                    node = parentNode;
                }
            }
        }

        if (root.getColor() == NodeColor.RED){
            root.setColor(NodeColor.BLACK);
        }
    }

    private Node<T> insertIntoTree(Node<T> root, Node<T> node) {

        if (root == null){
            return node;
        }

        if (node.getData().compareTo(root.getData()) < 0){
            root.setLeftNode(insertIntoTree(root.getLeftNode(), node));
            root.getLeftNode().setParent(root);
        }else if (node.getData().compareTo(root.getData()) > 0){
            root.setRightNode(insertIntoTree(root.getRightNode(), node));
            root.getRightNode().setParent(root);
        }

        return root;
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
            root = tempLeftNode;
        }else if (node == node.getParent().getLeftNode()){
            node.getParent().setLeftNode(tempLeftNode);
        }else{
            node.getParent().setRightNode(tempLeftNode);
        }

        tempLeftNode.setRightNode(node);
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
            root = tempRightNode;
        }else if (node == node.getParent().getRightNode()){
            node.getParent().setLeftNode(tempRightNode);
        }else{
            node.getParent().setRightNode(tempRightNode);
        }

        tempRightNode.setLeftNode(node);
        node.setParent(tempRightNode);
    }
}
