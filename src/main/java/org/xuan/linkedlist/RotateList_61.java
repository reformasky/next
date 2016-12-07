package org.xuan.linkedlist;

import org.xuan.util.ListNode;

/**
 * Created by xzhou2 on 12/6/16.
 */
public class RotateList_61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int length = 1, steps;
        ListNode curr = head, last, res;
        while(curr.next != null) {
            length++;
            curr = curr.next;
        }
        last = curr;
        curr = head;
        k %= length;
        if (k == 0) {
            return head;
        }
        steps = length - k - 1;
        for(int i = 0; i < steps; i++) {
            curr = curr.next;
        }
        res = curr.next;
        curr.next = null;
        last.next = head;
        return res;
    }
}
