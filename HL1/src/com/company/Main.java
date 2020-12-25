package com.company;

public class Main {

    public static void main(String[] args) {
        List<Integer>  list = new LinkedList<Integer>();

        list.insert(10);
        list.insert(-2);
        list.insert(3);
        list.insert(100);

        list.traverseList();
        System.out.println();
        System.out.println("Size: " + list.size());

        List<Person>  list1 = new LinkedList<Person>();
        list1.insert(new Person(20,"Alex"));
        list1.insert(new Person(21,"Davison"));
        list1.insert(new Person(22,"Aidann"));
        list1.insert(new Person(23,"Xyrus" ));

        list1.traverseList();
        System.out.println();
        System.out.println("Size: " + list1.size());


//        DoublyLinkedList<Integer> list11 = new DoublyLinkedList<>();
//
//        list11.insert(10);
//        list11.insert(-2);
//        list11.insert(3);
//        list11.insert(100);
//
//        System.out.println("Removed Node: " + list11.removeFromEnd());
//
//        list11.traverseList();

    }
}
