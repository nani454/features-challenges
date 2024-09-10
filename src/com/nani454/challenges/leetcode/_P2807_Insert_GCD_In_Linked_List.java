package com.nani454.challenges.leetcode;

public class _P2807_Insert_GCD_In_Linked_List {
    public static void main(String[] args) {
        System.out.println(Util.printLinkedList(new _P2807_Insert_GCD_In_Linked_List().insertGreatestCommonDivisors(
                new ListNode(18,
                        new ListNode(6,
                                new ListNode(10,
                                        new ListNode(3)))))));
    }

    private ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head.next != null) {
            ListNode pointer1 = head;
            ListNode pointer2 = head.next;
            do {
                pointer1.next = new ListNode(gcd(pointer1.val, pointer2.val), pointer2);
                pointer1 = pointer2;
                if (pointer1.next == null)
                    break;
                else
                    pointer2 = pointer1.next;
            } while (true);
        }
        return head;
    }

    private int gcd(int a, int b) {
        int gcd = 1;
        for (int i = Math.max(a, b); i > 0; i--) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
                break;
            }
        }
        return gcd;
    }

}
