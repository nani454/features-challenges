package com.nani454.challenges.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _P3_Longest_Substring_Without_repeating_Characters {

    public static void main(String[] args) {
        System.out.println(new _P3_Longest_Substring_Without_repeating_Characters().lengthOfLongestSubstring("abcabcbb"));
    }


    public int lengthOfLongestSubstring(String s) {
        Set<String> subStringsWithoutRepeatingCharacters = getSubStringsWithoutRepeatingCharacters(s);
        int subStringWithMaxChars = 0;
        for (String str : subStringsWithoutRepeatingCharacters) {
            if (str.length() > subStringWithMaxChars)
                subStringWithMaxChars = str.length();
        }
        return subStringWithMaxChars;
    }

    private Set<String> getSubStringsWithoutRepeatingCharacters(String str) {
        Set<String> subStringsWithoutRepeatingCharacters = new HashSet<>();
        char[] strCharArray = str.toCharArray();
        for (int i = 0; i < strCharArray.length; i++) {
            Set<Character> setToFindDuplicates = new HashSet<>();
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = i; j < strCharArray.length; j++) {
                if (setToFindDuplicates.add(strCharArray[j])) {
                    stringBuilder.append(strCharArray[j]);
                } else {
                    break;
                }
            }
            subStringsWithoutRepeatingCharacters.add(stringBuilder.toString());
        }
        return subStringsWithoutRepeatingCharacters;
    }
}
