package org.xuan.linkedlist;

import org.xuan.util.ListNode;

/**
 * Created by xzhou2 on 12/15/16.
 */
public class RevertLinkList_92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n || head == null) {
            return head;
        }
        ListNode result = new ListNode(-1);
        result.next = head;
        ListNode curr = result, pre, tail, next;
        int step = 0;
        while(++step < m) {
            curr = curr.next;
        }
        pre = curr;
        tail = curr.next;
        curr = tail;
        next = curr.next;
        while(step++ < n) {
            ListNode tmp = next;
            next = next.next;
            tmp.next = curr;
            curr = tmp;
        }
        pre.next = curr;
        tail.next = next;
        return result.next;
    }
}
