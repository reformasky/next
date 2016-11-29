package org.xuan.linkedlist;

import org.xuan.util.ListNode;

/**
 * Created by xzhou2 on 11/18/16.
 */
public class RemoveNthNodeFromEnd_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(-1), fast = pre, slow = pre;
        pre.next = head;
        for(int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (n == 1 && fast == null) {
            return null;
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return pre.next;
    }
}
