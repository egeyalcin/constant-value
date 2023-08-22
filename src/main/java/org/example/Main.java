package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(solve("chruschtschov"));
    }

    public static int solve(final String s) {
        char[] charArray = s.toCharArray();
        String keep = "";
        List<String> list = new ArrayList<>();
        for (int i = 0; i < charArray.length; i++) {
            String s1 = String.valueOf(charArray[i]);
            if (!s1.equals("a") && !s1.equals("e") && !s1.equals("i") && !s1.equals("o") && !s1.equals("u")) {
                keep+= String.valueOf(charArray[i]);
                if(i == charArray.length - 1) {
                    list.add(keep);
                }
            }
            else {
                if(!keep.isEmpty()) {
                    list.add(keep);
                }
                keep = "";
            }
        }
        int max = 0;
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            char[] charArray1 = list.get(i).toCharArray();
            for (int j = 0; j < charArray1.length; j++) {
                char upperCase = Character.toUpperCase(charArray1[j]);
                sum+= Character.getNumericValue(upperCase) - 9;
            }
            max = Math.max(sum, max);
            sum = 0;
        }
        return max;
    }
}