package com.company;

public class Main {

    public static void main(String[] args) {

        TernarySearchTree tst = new TernarySearchTree();

        tst.put("apple", 1);
        tst.put("orange", 2);

        System.out.println("get(banana): " + tst.get("banana"));
        System.out.println("get(orange): " + tst.get("orange"));
    }
}
