package com.company;

import java.util.HashMap;
import java.util.Map;

public class BoyerMooreAlgorithm {

    private String text;
    private String pattern;
    private Map<Character, Integer> mismatchShiftTable;

    public BoyerMooreAlgorithm(String text, String pattern) {
        this.text = text;
        this.pattern = pattern;
        this.mismatchShiftTable = new HashMap<>();
    }

    public void preComputeShifts(){

        int lengthOfPattern =  this.pattern.length();

        for (int index = 0; index < lengthOfPattern; index++){
            char actualCharacter = this.pattern.charAt(index);
            int maxShift = Math.max(1, lengthOfPattern - index - 1);
            this.mismatchShiftTable.put(actualCharacter, maxShift);
        }
    }

    public int search(){
        int lengthOfPattern = this.pattern.length();
        int lengthOfText = this.text.length();
        int numOfSkips;

        for (int i = 0; i < lengthOfText - lengthOfPattern; i += numOfSkips){
            numOfSkips = 0;

            for (int j = lengthOfPattern - 1; j >= 0; j--){
                char x = text.charAt(i+j);
                char z = pattern.charAt(j);
                if (pattern.charAt(j) != text.charAt(i+j)){

                    if (this.mismatchShiftTable.get(text.charAt(i+j)) != null){
                        numOfSkips = this.mismatchShiftTable.get(text.charAt(i+j));
                        break;
                    }else{
                        numOfSkips = lengthOfPattern;
                        break;
                    }

                }
            }
            if (numOfSkips == 0) return i;
        }

        return lengthOfText;
    }
}
