package com.nani454.challenges.leetcode;

import java.util.Stack;

public class _P38_Count_And_Say {
    public static void main(String[] args) {
        System.out.println(new _P38_Count_And_Say().rle("3322251"));
    }
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        return rle(countAndSay(n-1));
    }
    public String rle(String num){
        String rleOfNum = "";
        char[] charArray = num.toCharArray();
        Stack<Character> characterStack = new Stack<>();
        for(int i=0; i<charArray.length;i++){
            if(characterStack.isEmpty() || characterStack.peek() == charArray[i]){
                characterStack.push(charArray[i]);
            }else{
                rleOfNum = rleOfNum + characterStack.size() + characterStack.peek();
                characterStack.removeAllElements();
                characterStack.push(charArray[i]);
            }
        }
        if(!characterStack.isEmpty()){
            rleOfNum = rleOfNum + characterStack.size() + characterStack.peek();
        }
        return rleOfNum;
    }

}
