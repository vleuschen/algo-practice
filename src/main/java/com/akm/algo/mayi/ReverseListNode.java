package com.akm.algo.mayi;

import com.akm.algo.model.ListNode;
import com.akm.algo.util.ListNodeUtil;

public class ReverseListNode {

    public static ListNode reverseListNode(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode tempNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNode;
        }

        return prev;
    }

    public static void main(String[] args) {

        ListNodeUtil.printListNode(reverseListNode(ListNodeUtil.initialListNode()));

    }
}
