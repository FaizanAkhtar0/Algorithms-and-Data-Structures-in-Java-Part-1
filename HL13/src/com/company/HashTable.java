package com.company;

public class HashTable {

    private HashItem[] hashTable;

    public HashTable(){
        this.hashTable = new HashItem[Constants.TABLE_SIZE];
    }

    public void put(int key, int value){
        int generatedIndex = hashFunction(key);
        System.out.println("Put() value: " + value + " - generatedIndex: " + generatedIndex);

        while(hashTable[generatedIndex] != null){
            generatedIndex = (generatedIndex + 1) % Constants.TABLE_SIZE;
            System.out.println("Collision -> newIndex: " + generatedIndex);
        }

        System.out.println("Inserted on Index: " + generatedIndex);
        hashTable[generatedIndex] = new HashItem(key, value);
    }

    public int get(int key){
        int generatedIndex = hashFunction(key);

        while (hashTable[generatedIndex] != null && hashTable[generatedIndex].getKey() != key){
            generatedIndex = (generatedIndex + 1) % Constants.TABLE_SIZE;
            System.out.println("Hoping to the next index: " + generatedIndex);
        }

        if (hashTable[generatedIndex] == null){
            return -1;
        }else{
            return hashTable[generatedIndex].getValue();
        }
    }

    private int hashFunction(int key) {
        return key % Constants.TABLE_SIZE;
    }
}
