package com.nani454.challenges.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _P1_TwoSum {

    public static void main(String[] args) {
        _P1_TwoSum _p1 = new _P1_TwoSum();
        System.out.println(Util.printArrayInLine(_p1.twoSum(new int[]{2, 7, 11, 15}, 9)));//O(n^2) time complexity solution
        System.out.println(Util.printArrayInLine(_p1.twoSumUsingHashMap(new int[]{2, 7, 11, 15}, 9)));//less than O(n^2) time complexity solution
        System.out.println(Util.printArrayInLine(_p1.twoSumUsingHashMap(new int[]{3, 3}, 6))); //less than O(n^2) time complexity solution
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        outer:
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    result[0] = i;
                    result[1] = j;
                    break outer;
                }
            }
        }
        return result;
    }

    /**
     * less than O(n^2) time complexity solution
     **/
    public int[] twoSumUsingHashMap(int[] nums, int target) {
        HashMap<Integer, List<Integer>> valuePositionMap = new HashMap<>(); //position is stored in a list as there could be same int values at different postions

        for (int pos = 0; pos < nums.length; pos++) {
            if (valuePositionMap.containsKey(nums[pos])) {
                List<Integer> posList = valuePositionMap.get(nums[pos]);
                posList.add(pos);
                valuePositionMap.put(nums[pos], posList);
            } else {
                List<Integer> posList = new ArrayList<>();
                posList.add(pos);
                valuePositionMap.put(nums[pos], posList);
            }
        }
        int[] result = new int[2];
        for (Map.Entry<Integer, List<Integer>> entry : valuePositionMap.entrySet()) {
            int diff = target - entry.getKey();
            if (valuePositionMap.containsKey(diff)) {
                result[0] = entry.getValue().get(0);
                if (diff == entry.getKey()) { //logic to handle if the target is sum of two duplicate elements at different locations.
                    result[1] = entry.getValue().get(1);
                } else {
                    result[1] = valuePositionMap.get(diff).get(0);
                }
                break;
            }
        }
        return result;
    }
}
