package com.nani454.challenges.leetcode;

public class _P16_3Sum_closest {
    public static void main(String[] args) {
        System.out.println(new _P16_3Sum_closest().threeSumClosest(new int[]{-1,2,1,-4}, 1));
    }
    public int threeSumClosest(int[] nums, int target) {
        int result=0;
        int closestDifference=Integer.MAX_VALUE;
        for(int i=0; i < nums.length;i++){
            for(int j=i+1; j < nums.length;j++){
                for(int k=j+1; k < nums.length;k++){
                    int sum = nums[i]+nums[j]+nums[k];
                    if(sum == target){
                        return target;
                    }else{
                        int difference = Math.abs(sum-target);
                        if(difference<closestDifference){
                            result = sum;
                            closestDifference = difference;
                        }
                    }
                }
            }
        }
        return result;
    }
}
