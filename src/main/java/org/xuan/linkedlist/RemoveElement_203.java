package org.xuan.linkedlist;

import org.xuan.util.ListNode;

/**
 * Created by xzhou2 on 12/30/16.
 */
public class RemoveElement_203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = new ListNode(-1), curr = pre;
        pre.next = head;
        while(curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return pre.next;
    }
}
