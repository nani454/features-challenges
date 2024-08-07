package com.nani454.challenges.leetcode;

public class _P43_Multiply_Strings {
    public static void main(String[] args) {
        System.out.println(new _P43_Multiply_Strings().multiply("123456789", "987654321"));
    }

    public String sum(String num1, String num2) {
        String result = "";
        if (num1.length() < num2.length()) {
            int leadingZeroesToBeAdded = num2.length() - num1.length();
            for (int i = 0; i < leadingZeroesToBeAdded; i++) {
                num1 = "0" + num1;
            }
        } else if (num1.length() > num2.length()) {
            int leadingZeroesToBeAdded = num1.length() - num2.length();
            for (int i = 0; i < leadingZeroesToBeAdded; i++) {
                num2 = "0" + num2;
            }
        }

        int carryForward = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int sum = Integer.parseInt(String.valueOf(num1.charAt(i))) + Integer.parseInt(String.valueOf(num2.charAt(i))) + carryForward;
            carryForward = sum / 10;
            result = sum % 10 + result;
        }
        if (carryForward > 0) {
            result = carryForward + result;
        }
        return result;
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String result = "0";

        if (num1.length() < num2.length()) {
            String temp = num2;
            num2 = num1;
            num1 = temp;
        }

        for (int i = num2.length() - 1, digitPlaceFactor = 0; i >= 0; i--, digitPlaceFactor++) {
            int num2Digit = Integer.parseInt(String.valueOf(num2.charAt(i)));
            int carryForward = 0;
            String digitMultiplactionResult = "";
            for (int j = num1.length() - 1; j >= 0; j--) {
                int digitToDigitMultiplicationResult = Integer.parseInt(String.valueOf(num1.charAt(j))) * num2Digit + carryForward;
                carryForward = digitToDigitMultiplicationResult / 10;///////dfasdf/
                digitMultiplactionResult = digitToDigitMultiplicationResult % 10 + digitMultiplactionResult;
            }
            if (carryForward > 0) {
                digitMultiplactionResult = carryForward + digitMultiplactionResult;
            }
            //append trailing zeroes
            for (int k = 0; k < digitPlaceFactor; k++) {
                digitMultiplactionResult = digitMultiplactionResult + "0";
            }
            result = sum(result, digitMultiplactionResult);
        }

        return result;
    }
}
