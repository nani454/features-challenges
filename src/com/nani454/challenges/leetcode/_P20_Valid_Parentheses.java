package com.nani454.challenges.leetcode;

import java.util.Stack;

public class _P20_Valid_Parentheses {
    public static void main(String[] args) {
        new _P20_Valid_Parentheses().isValid("(])");
    }
    public boolean isValid(String s) {

        Stack<Character> parenthesesStack = new Stack<>();

        for (Character parentheses: s.toCharArray()) {
            if(parentheses.equals('(') ||
                    parentheses.equals('[') ||
                    parentheses.equals('{')){
                parenthesesStack.push(parentheses);
            }
            else{
                if(parenthesesStack.isEmpty()){
                    parenthesesStack.push(parentheses);
                }
                else {
                    Character peekOfparenthesesStack = parenthesesStack.peek();
                    if (parentheses.equals(')') && peekOfparenthesesStack.equals('(')) {
                        parenthesesStack.pop();
                    } else if (parentheses.equals(']') && peekOfparenthesesStack.equals('[')) {
                        parenthesesStack.pop();
                    } else if (parentheses.equals('}') && peekOfparenthesesStack.equals('{')) {
                        parenthesesStack.pop();
                    }else{
                        parenthesesStack.push(parentheses);
                    }
                }
            }
        }

        if(parenthesesStack.isEmpty())
            return true;
        else
            return false;
    }
}
