package com.company;

public class Main {

    public static void main(String[] args) {

        Tree<Integer> RBT = new RedBlackTree<>();

        RBT.insert(10);
        RBT.insert(5);
        RBT.insert(6);
//        RBT.traverse();     // When uncommented gives an error!
    }
}
