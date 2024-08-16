package com.nani454.challenges.leetcode;

public class _P5_Longest_Palindromic_Substring {
    public static void main(String[] args) {
        System.out.println(new _P5_Longest_Palindromic_Substring().longestPalindrome("cbbd"));
    }

    public String longestPalindrome(String s) {
        char[] charArray = s.toCharArray();
        String longestPalindrome = "";

        for (int i = 0; i < charArray.length; i++) {
            for (int j = charArray.length; j >= i; j--) {
                String substring = s.substring(i, j);
                if (substring.length() < longestPalindrome.length())
                    break;
                else if (substring.length() > longestPalindrome.length() && isPalindrome(substring)) {
                    longestPalindrome = substring;
                }
            }
        }

        return longestPalindrome;
    }

    private boolean isPalindrome(String substring) {
        for (int i = 0, j = substring.length() - 1; i < substring.length() && j >= i; i++, j--) {
            if (!(substring.charAt(i) == substring.charAt(j))) {
                return false;
            }
        }
        return true;
    }
}
