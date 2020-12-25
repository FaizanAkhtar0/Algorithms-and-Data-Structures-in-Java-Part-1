package com.company;

public class Main {

    public static void main(String[] args) {

        StringOperations operations = new StringOperations();

        System.out.println("Reversing: " + operations.revertString("House"));

        System.out.println("getPrefixes: " + operations.getPrefixes("House"));

        System.out.println("getSuffixes: " + operations.getSuffixes("House"));

        System.out.println("longestCommonPrefix: " + operations.longestCommonPrefix("House", "Hoe's"));

        System.out.println("longestRepeatedSubString: " + operations.longestRepeatedSubString("HelloHeHeHHello"));
    }
}
