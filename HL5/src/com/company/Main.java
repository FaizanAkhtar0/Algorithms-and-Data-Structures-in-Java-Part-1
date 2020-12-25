package com.company;

public class Main {

    public static void main(String[] args) {

        Queue<Integer> myqueue = new Queue<>();

        myqueue.enqueue(10);
        myqueue.enqueue(100);
        myqueue.enqueue(1000);

        System.out.println("Size: " + myqueue.size());

        System.out.println(myqueue.dequeue());
        System.out.println(myqueue.dequeue());
        System.out.println(myqueue.dequeue());
    }
}
