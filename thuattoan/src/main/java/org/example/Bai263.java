package org.example;

import java.util.HashMap;
import java.util.Map;

public class Bai263 {
    public static void countChar(String input){
        Map<String,Integer> stringIntegerMap = new HashMap<>();
        String[] strings = input.split("");
        for (int i = 0; i < strings.length; i++) {
            if (stringIntegerMap.containsKey(strings[i])){
                stringIntegerMap.put(strings[i],stringIntegerMap.get(strings[i])+1);
            }else {
                stringIntegerMap.put(strings[i],1);
            }
        }
        for (Map.Entry<String,Integer> entry : stringIntegerMap.entrySet()){
            System.out.println(entry.getKey() + " xuất hiện " + entry.getValue() + " lần");
        }
    }

    public static void main(String[] args) {
        String string = "abcddecbaa";
        countChar(string);
    }
}
