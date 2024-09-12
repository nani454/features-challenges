package com.nani454.challenges.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _P1684_Count_Consistent_Strings {
    public static void main(String[] args) {
        String allowed = "ab";
        String[] words = {"ad", "bd", "aaab", "baa", "badab"};
        System.out.println(new _P1684_Count_Consistent_Strings().countConsistentStrings(allowed, words));
    }

    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;

        char[] allowedChars = allowed.toCharArray();
        Set<Character> allowedCharsSet = new HashSet<Character>();
        for (char allowedChar : allowedChars) {
            allowedCharsSet.add(allowedChar);
        }
        for (String word : words) {
            char[] wordChars = word.toCharArray();
            boolean isConsistentString = true;
            for (char wordChar : wordChars) {
                if (!allowedCharsSet.contains(wordChar)) {
                    isConsistentString = false;
                    break;
                }
            }
            if (isConsistentString)
                count++;
        }
        return count;
    }
}
