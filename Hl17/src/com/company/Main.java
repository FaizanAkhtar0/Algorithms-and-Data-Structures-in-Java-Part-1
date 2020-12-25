package com.company;

public class Main {

    public static void main(String[] args) {

        BoyerMooreAlgorithm boyerMooreAlgorithm = new BoyerMooreAlgorithm("My name is UnKnown!", "is");
        boyerMooreAlgorithm.preComputeShifts();

        System.out.println(boyerMooreAlgorithm.search());
    }
}
