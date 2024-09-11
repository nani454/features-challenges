package com.nani454.challenges.leetcode;

public class _P2220_Min_Bit_Flips_To_Convert_Number {
    public static void main(String[] args) {
        System.out.println(new _P2220_Min_Bit_Flips_To_Convert_Number().minBitFlips(99, 29));
    }

    public int minBitFlips(int start, int goal) {
        String startBinary = Integer.toBinaryString(start);
        String goalBinary = Integer.toBinaryString(goal);
        int startBinaryLength = startBinary.length();
        int goalBinaryLength = goalBinary.length();
        if (goalBinaryLength > startBinaryLength) {
            for (int i = 0; i < goalBinaryLength - startBinaryLength; i++)
                startBinary = "0" + startBinary;
        } else if (startBinaryLength > goalBinaryLength) {
            for (int i = 0; i < startBinaryLength - goalBinaryLength; i++)
                goalBinary = "0" + goalBinary;
        }
        int result = 0;

        for (int i = 0; i < startBinary.length(); i++) {
            if (startBinary.charAt(i) != goalBinary.charAt(i))
                result++;
        }
        return result;
    }
}
