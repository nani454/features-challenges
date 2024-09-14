package com.nani454.challenges.leetcode;

public class _P1310_XOR_Queries_Of_Subarray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 8};
        int[][] queries = {{0, 1}, {1, 2}, {0, 3}, {3, 3}};
        System.out.println(Util.printArrayInLine(new _P1310_XOR_Queries_Of_Subarray().xorQueries(arr, queries)));
    }

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] results = new int[queries.length];
        int[] prefixXorArray = new int[arr.length];
        prefixXorArray[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixXorArray[i] = prefixXorArray[i - 1] ^ arr[i];
        }

        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            if (left == 0) {
                results[i] = prefixXorArray[right];
            } else {
                results[i] = prefixXorArray[left - 1] ^ prefixXorArray[right];
            }
        }

        return results;
    }
}
