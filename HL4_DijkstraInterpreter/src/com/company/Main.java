package com.company;

public class Main {

    public static void main(String[] args) {

        Algorithm algorithm = new Algorithm();

        algorithm.interpretExpression("( ( 2 * 1 ) + ( 5 * 2 ) )");

        algorithm.result();
    }
}
