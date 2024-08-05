package com.nani454.challenges.leetcode;

public class _P7_ReverseInteger {
    public static void main(String[] args) {
        System.out.println(new _P7_ReverseInteger().reverse(1534236469));
    }
    public int reverse(int x) {
        String numString = ((Integer) x).toString();
        int result = 0;
        for(int i = numString.length()-1; i>=0; i--){

            String charAtI = String.valueOf(numString.charAt(i));

            if(charAtI.equals("-")){
                result = result * -1;
            }
            else {
                if(Integer.MAX_VALUE/10 < result)
                    return 0;
                result = result * 10 + Integer.parseInt(String.valueOf(charAtI));
            }
        }
        return result;
    }
}
