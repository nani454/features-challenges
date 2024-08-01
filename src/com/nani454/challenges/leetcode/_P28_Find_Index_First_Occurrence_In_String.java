package com.nani454.challenges.leetcode;

public class _P28_Find_Index_First_Occurrence_In_String {
    public static void main(String[] args) {
        new _P28_Find_Index_First_Occurrence_In_String().strStr("mississippi","issipi");
    }
    public int strStr(String haystack, String needle) {
        char[] needleChars = needle.toCharArray();
        char initialCharOfNeedle = needleChars[0];
        char[] haystackChars = haystack.toCharArray();
        if(haystackChars.length < needleChars.length){
            return -1;
        }
        for(int i=0; i<haystackChars.length; i++){
            if(initialCharOfNeedle == haystackChars[i]) {
                if (i + needleChars.length - 1 < haystackChars.length) {
                    boolean remainingCharsMatch = true;
                    for (int j = i, k = 0; k < needleChars.length; j++, k++) {
                        if (haystackChars[j] != needleChars[k]) {
                            remainingCharsMatch = false;
                            break;
                        }
                    }
                    if (remainingCharsMatch)
                        return i;
                }
            }
        }

        return -1;
    }
}
