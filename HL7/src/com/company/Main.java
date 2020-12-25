package com.company;

public class Main {

    public static void main(String[] args) {

        Tree<Integer> avl = new AvlTree<>();

//        avl.insert(3);
//        avl.insert(1);   //Left-Right
//        avl.insert(2);

//        avl.insert(3);
//        avl.insert(2);  //Right
//        avl.insert(1);
//
        avl.insert(3);
        avl.insert(5);  //Right-Left
        avl.insert(4);
        avl.insert(1);
        avl.insert(2);

        System.out.println("Max: " +avl.getMaxVal());
        System.out.println("Min: " +avl.getMinVal());

        avl.delete(2);
//
//        avl.insert(10);
//        avl.insert(20);
//        avl.insert(30);
//        avl.insert(40);
//        avl.insert(50);
//        avl.insert(60);


        avl.traverse();

    }
}
