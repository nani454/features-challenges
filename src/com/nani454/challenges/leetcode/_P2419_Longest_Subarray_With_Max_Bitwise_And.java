package com.nani454.challenges.leetcode;

public class _P2419_Longest_Subarray_With_Max_Bitwise_And {

    public static void main(String[] args) {
        int[] nums = {378034,378034,378034};
        System.out.println(new _P2419_Longest_Subarray_With_Max_Bitwise_And().longestSubarray(nums));
    }

    public int longestSubarray(int[] nums) {
        int maxBitwiseAnd = Integer.MIN_VALUE;
        int longestSubArray = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxBitwiseAnd < nums[i]) {
                maxBitwiseAnd = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (maxBitwiseAnd == nums[i]) {
                count++;
            }
            else{
                count = 0;
            }
            if (longestSubArray < count)
                longestSubArray = count;

        }
        return  longestSubArray;
    }
}
