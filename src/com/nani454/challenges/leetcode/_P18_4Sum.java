package com.nani454.challenges.leetcode;

import java.util.*;

public class _P18_4Sum {


    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();
        Set<String> comboStrings = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    for (int l = k + 1; l < nums.length; l++) {
                        int fourSum = 0;
                        try {
                            fourSum = Math.addExact(Math.addExact(nums[i], nums[j]), Math.addExact(nums[k], nums[l]));
                        }catch (ArithmeticException e){
                            continue;
                        }
                        if (fourSum == target) {
                            List<Integer> combo = Arrays.asList(new Integer[]{nums[i], nums[j], nums[k], nums[l]});
                            Collections.sort(combo);
                            String comboString = "";
                            for (Integer comboVal : combo) {
                                comboString += comboVal;
                            }
                            if (!comboStrings.contains(comboString)) {
                                comboStrings.add(comboString);
                                result.add(combo);
                            }
                            break;
                        }
                    }
                }
            }
        }

        return result;
    }
}
