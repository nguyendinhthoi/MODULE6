package org.example;

import java.util.Arrays;

public class Bai264 {
    public static void sortString(String input){
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
    }

    public static void main(String[] args) {
        String s = "Hello my friend";
        sortString(s);
    }
}
