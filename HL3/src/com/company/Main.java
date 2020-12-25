package com.company;

public class Main {

    public static void main(String[] args) {

        Stack<Integer> mystack = new Stack<>();

        mystack.push(10);
        mystack.push(100);
        mystack.push(1000);

        System.out.println("Size: " + mystack.size());

        System.out.println("Pop: " + mystack.pop());
        System.out.println("Pop: " + mystack.pop());
        System.out.println("IsEmpty: " + mystack.isEmpty());
    }
}
