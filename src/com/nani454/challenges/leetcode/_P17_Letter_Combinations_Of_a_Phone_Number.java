package com.nani454.challenges.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _P17_Letter_Combinations_Of_a_Phone_Number {


    Map<Character, char[]> digitCharMap = new HashMap<>();

    public _P17_Letter_Combinations_Of_a_Phone_Number() {
        digitCharMap.put('2', new char[]{'a', 'b', 'c'});
        digitCharMap.put('3', new char[]{'d', 'e', 'f'});
        digitCharMap.put('4', new char[]{'g', 'h', 'i'});
        digitCharMap.put('5', new char[]{'j', 'k', 'l'});
        digitCharMap.put('6', new char[]{'m', 'n', 'o'});
        digitCharMap.put('7', new char[]{'p', 'q', 'r', 's'});
        digitCharMap.put('8', new char[]{'t', 'u', 'v'});
        digitCharMap.put('9', new char[]{'w', 'x', 'y', 'z'});
    }

    public static void main(String[] args) {
        System.out.println(new _P17_Letter_Combinations_Of_a_Phone_Number().letterCombinations(""));
    }

    public List<String> letterCombinations(String digits) {
        List<String> letterCombinations = new ArrayList<>();
        if (digits.length() == 0) {
            return letterCombinations;
        } else if (digits.length() == 1) {
            char[] letters = digitCharMap.get(digits.charAt(0));
            for (char c : letters) {
                letterCombinations.add("" + c);
            }
            return letterCombinations;
        } else {

            List<String> subStringLetterCombinations = letterCombinations(digits.substring(1));

            char[] letters = digitCharMap.get(digits.charAt(0));

            for (char letter : letters) {
                for (String subStringLetterCombination : subStringLetterCombinations) {
                    letterCombinations.add(letter + subStringLetterCombination);
                }
            }
        }

        return letterCombinations;

    }
}
