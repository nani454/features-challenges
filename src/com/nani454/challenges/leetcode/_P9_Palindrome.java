package com.nani454.challenges.leetcode;

public class _P9_Palindrome {
    public static void main(String[] args){
        System.out.println("121 is palindrome: " + isPalindrome(121));
        System.out.println("-121 is palindrome: " + isPalindrome(-121));
        System.out.println("10 is palindrome: " + isPalindrome(10));
        System.out.println("-101 is palindrome: " + isPalindrome(-101));
    }
    public static boolean isPalindrome(int x) {
        char[] input = ((Integer) x).toString().toCharArray();

        for(int i = 0, j = input.length-1; i < input.length && i < j; i++, j--){
            if(input[i] != input[j])
                return false;
        }

        return true;
    }
}
