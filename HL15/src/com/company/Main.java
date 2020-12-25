package com.company;

public class Main {

    public static void main(String[] args) {

        Trie trie = new Trie();

        trie.insert("adam",1);
        trie.insert("adaed",2);
        trie.insert("adeem",3);
        trie.insert("adeed",4);

        System.out.println("Search(adam): " + trie.search("adam"));
        System.out.println("SearchAsMap(adam): " + trie.searchAsMap("adam"));

        System.out.println("allWordsWithPrefix(ad): " + trie.allWordsWithPrefix("ad"));
//        System.out.println("allWordsWithPrefix(): " + trie.allWordsWithPrefix("")); // -> For sorting.

        System.out.println("longestCommonPrefix(): " + trie.longestCommonPrefix());
    }
}
