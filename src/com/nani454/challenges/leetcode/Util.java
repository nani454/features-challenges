package com.nani454.challenges.leetcode;

import java.util.Arrays;

public class Util {
    public static String printArrayInLine(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Arrays.stream(arr).forEach(ele -> {
            if (sb.length() > 1)
                sb.append(",");
            sb.append(ele);
        });
        sb.append("]");
        return sb.toString();
    }

    public static String printLinkedList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        if (head != null) {

            ListNode pointer = head;
            do {

                if (sb.length() > 1) {
                    sb.append(",");
                }
                sb.append(pointer.val);

                if (pointer.next == null)
                    break;
                else
                    pointer = pointer.next;

            } while (true);
        }
        sb.append("]");
        return sb.toString();
    }
}
