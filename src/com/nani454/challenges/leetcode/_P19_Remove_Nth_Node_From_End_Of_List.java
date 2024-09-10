package com.nani454.challenges.leetcode;

public class _P19_Remove_Nth_Node_From_End_Of_List {
    public static void main(String[] args) {
        ListNode linkedList = new ListNode(1,
                new ListNode(2));
        System.out.println(Util.printLinkedList(new _P19_Remove_Nth_Node_From_End_Of_List().removeNthFromEnd(linkedList, 2)));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pointer1 = head;
        ListNode pointer2;
        ListNode dummy = pointer1.next;
        for (int i = 1; i < n; i++) {
            dummy = dummy.next;
        }
        pointer2 = dummy;
        if (pointer2 == null) {
            return pointer1.next;
        }
        do {
            if (pointer2.next == null) {
                ListNode nodeToBeRemoved = pointer1.next;
                pointer1.next = nodeToBeRemoved.next;
                break;
            }
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        } while (true);
        return head;
    }
}
