package com.nani454.challenges.leetcode;

import java.math.BigInteger;
import java.util.Stack;

public class _P2_AddTwoNumbers {
    public static void main(String[] args) {
        _P2_AddTwoNumbers _p2 = new _P2_AddTwoNumbers();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = _p2.addTwoNumbers(l1, l2);

        System.out.print("[");
        while (true) {
            System.out.print(result.val);
            if (result.next != null) {
                result = result.next;
                System.out.print(" ,");
            } else
                break;
        }
        System.out.print("]");
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger _num1 = getReversedNumber(l1);
        BigInteger _num2 = getReversedNumber(l2);

        BigInteger _sum = _num1.add(_num2);

        return formReversedResult(_sum);
    }

    public BigInteger getReversedNumber(ListNode l) {
        Stack<Integer> digits = new Stack<>();

        while (true) {
            digits.push(l.val);

            if (l.next != null)
                l = l.next;
            else
                break;

        }
        BigInteger result = BigInteger.ZERO;
        while (digits.size() > 0) {
            result = result.multiply(BigInteger.TEN);
            result = result.add(new BigInteger("" + digits.pop()));
        }
        return result;
    }

    public ListNode formReversedResult(BigInteger num) {
        ListNode firstNode = new ListNode();
        firstNode.val = num.mod(BigInteger.TEN).intValue();
        num = num.divide(BigInteger.TEN);
        firstNode.next = null;
        ListNode latestNode = firstNode;

        while (num.compareTo(BigInteger.ZERO) > 0) {
            ListNode _newNode = new ListNode();
            _newNode.val = num.mod(BigInteger.TEN).intValue();
            num = num.divide(BigInteger.TEN);
            _newNode.next = null;
            latestNode.next = _newNode;
            latestNode = _newNode;
        }

        return firstNode;

    }
}


