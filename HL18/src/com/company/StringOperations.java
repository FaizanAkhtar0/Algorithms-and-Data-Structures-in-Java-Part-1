package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringOperations {

    public String revertString(String text){

        int lengthOfString = text.length();
        StringBuilder stringBuilder = new StringBuilder();

        for (int index = lengthOfString - 1; index >= 0; index--){
            stringBuilder.append(text.charAt(index));
        }

        return stringBuilder.toString();
    }

    public String longestCommonPrefix(String text1, String text2){
        int commonlenght = Math.min(text1.length(), text2.length());

        for (int index = 0; index < commonlenght; ++index){
            if (text1.charAt(index) != text2.charAt(index)){
                return text1.substring(0, index);
            }
        }

        return text1.substring(0, commonlenght);
    }

    public String longestRepeatedSubString(String text){
        int lengthOfText = text.length();
        List<String> suffixList = getSuffixes(text);
        Collections.sort(suffixList);
        String longestSubstring = "";

        for(int i=0;i<lengthOfText-1;i++){
            String tempString = longestCommonPrefix(suffixList.get(i), suffixList.get(i+1));

            if( tempString.length() > longestSubstring.length()){
                longestSubstring = tempString;
            }
        }

        return longestSubstring;
    }

    public List<String> getPrefixes(String text){
        int lengthOfText = text.length();
        List<String> suffixList = new ArrayList<>();

        for (int index = 0; index < lengthOfText + 1; ++index){
            suffixList.add(text.substring(0, index));
        }

        return suffixList;
    }

    public List<String> getSuffixes(String text){
        int lengthOfText = text.length();
        List<String> suffixList = new ArrayList<>();

        for (int index = 0; index < lengthOfText; ++index){
            suffixList.add(text.substring(index, lengthOfText));
        }

        return suffixList;
    }
}
