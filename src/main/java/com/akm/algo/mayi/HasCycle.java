package com.akm.algo.mayi;

import com.akm.algo.model.ListNode;

/**
 * 判断一个链表是否是环形链表
 */
public class HasCycle {

    public static boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return  false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {

            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(0);
        ListNode listNode4 = new ListNode(-4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode2;

        System.out.println(hasCycle(listNode1));

        ListNode listNode5 = new ListNode(1);
        ListNode listNode6 = new ListNode(2);

        listNode5.next = listNode6;
        listNode6.next = listNode5;

        System.out.println(hasCycle(listNode5));

        ListNode listNode7 = new ListNode(7);
        System.out.println(hasCycle(listNode7));
    }
}
