package org.example;

import java.util.HashMap;
import java.util.Map;

public class CountChar {
    public static void countCharacter(String input){
        Map<String,Integer> charCount = new HashMap<>();
        String[] characters = input.split("");
        for (String character : characters) {
            if (charCount.containsKey(character)) {
                charCount.put(character, charCount.get(character)+1);
            } else {
                charCount.put(character, 1);
            }
        }
        for (Map.Entry<String,Integer> entry : charCount.entrySet()){
            System.out.println(entry.getValue()+entry.getKey());
        }
    }

    public static void main(String[] args) {
        countCharacter("aabacsdc");
    }
}
