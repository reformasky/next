package org.xuan.linkedlist;

import org.xuan.util.ListNode;

/**
 * Created by xzhou2 on 12/21/16.
 */
public class InsertSortList_147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(-1), pre, curr, next;
        newHead.next = head;
        curr = head.next;
        head.next = null;
        while(curr != null) {
            pre = newHead;
            next = curr.next;
            curr.next = null;
            while(pre.next != null && pre.next.val <= curr.val) {
                pre = pre.next;
            }
            curr.next = pre.next;
            pre.next = curr;
            curr = next;
        }
        return newHead.next;
    }
}
