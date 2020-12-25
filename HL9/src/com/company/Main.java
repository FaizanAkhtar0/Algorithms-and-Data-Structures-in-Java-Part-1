package com.company;

public class Main {

    public static void main(String[] args) {

        Tree<Integer> splaytree = new SplayTree<>();

        splaytree.insert(10);
        splaytree.insert(-5);
        splaytree.insert(0);
        splaytree.insert(20);
        splaytree.insert(30);

        splaytree.printRoot();

//        splaytree.inOrderTraversal();
    }
}
