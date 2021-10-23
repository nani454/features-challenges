package com.nani454.challenges;

public class _P4_Median_Of_Two_Sorted_Arrays {
    public static void main(String[] args) {
        _P4_Median_Of_Two_Sorted_Arrays _p4 = new _P4_Median_Of_Two_Sorted_Arrays();
        System.out.println(_p4.findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
        System.out.println(_p4.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
        System.out.println(_p4.findMedianSortedArrays(new int[]{0,0}, new int[]{0,0}));
        System.out.println(_p4.findMedianSortedArrays(new int[]{}, new int[]{1}));
        System.out.println(_p4.findMedianSortedArrays(new int[]{2}, new int[]{}));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = mergeSortedArrays(nums1, nums2);
        if(mergedArray.length % 2 == 0){
            return ((double)(mergedArray[(mergedArray.length)/2] +  mergedArray[(mergedArray.length)/2-1]))/2;
        }else{
            return mergedArray[(mergedArray.length)/2];
        }
    }

    public int[] mergeSortedArrays(int[] nums1, int[] nums2){
        int i = 0, j = 0, k = 0, m = nums1.length, n = nums2.length;
        int[] mergedArray = new int[m+n];
        while(true){
            if(i >= m){
                while(j<n){
                    mergedArray[k] = nums2[j];
                    j++;
                    k++;
                }
                break;
            }if(j >= n){
                while(i<m){
                    mergedArray[k] = nums1[i];
                    i++;
                    k++;
                }
                break;
            }
            if(nums1[i]<nums2[j]){
                mergedArray[k] = nums1[i];
                i++;
            }else{
                mergedArray[k] = nums2[j];
                j++;
            }
            k++;
        }
        return mergedArray;
    }
}
