package org.xuan.linkedlist;

import org.xuan.util.ListNode;

/**
 * Created by xzhou2 on 11/9/16.
 */
public class AddTwoNumbers_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int base = 10;
        int carryOver = 0;
        ListNode pre = new ListNode(-1), curr = pre;
        while(l1 != null && l2 != null) {
            carryOver = l1.val + l2.val + carryOver;
            ListNode tmp = new ListNode(carryOver % base);
            curr.next = tmp;
            curr = tmp;
            carryOver /= base;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null) {
            l1 = l2;
        }
        while(l1 != null) {
            carryOver = l1.val + carryOver;
            ListNode tmp = new ListNode(carryOver % base);
            curr.next = tmp;
            curr = tmp;
            carryOver /= base;
            l1 = l1.next;
        }
        if (carryOver != 0) {
            ListNode tmp = new ListNode(carryOver);
            curr.next = tmp;
        }
        return pre.next;
    }
}
