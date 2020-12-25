package com.company;

public class Main {

    public static void main(String[] args) {

        HashTable<String, Integer> hashTable = new HashTable<>();

        hashTable.put("Alex", 20);
        hashTable.put("David", 22);
        hashTable.put("Jhon", 25);

        System.out.println(hashTable.get("ubuntu"));
    }
}
