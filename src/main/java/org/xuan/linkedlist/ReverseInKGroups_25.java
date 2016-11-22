package org.xuan.linkedlist;

import org.xuan.util.ListNode;

/**
 * Created by xzhou2 on 11/21/16.
 */
public class ReverseInKGroups_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode pre = new ListNode(-1), curr = pre;
        while(head != null) {
            ListNode[] nextK = nextK(head, k);
            if (nextK[1] != null) {
                head = nextK[1].next;
                nextK[1].next = null;
                ListNode[] reverse = reverse(nextK[0]);
                curr.next = reverse[0];
                curr = reverse[1];
            } else {
                curr.next = nextK[0];
                head = null;
            }
        }
        return pre.next;
    }

    private ListNode[] nextK(ListNode node, int k) {
        ListNode head  = node;
        while(node != null && k > 1) {
            node = node.next;
            k--;
        }
        return k == 1 ? new ListNode[]{head, node} : new ListNode[]{head, null};
    }

    private ListNode[] reverse(ListNode node) {
        ListNode curr = node.next, next = curr.next, pre = node;
        pre.next = null;
        while(next != null) {
            curr.next = pre;
            pre = curr;
            curr = next;
            next = next.next;
        }
        curr.next = pre;
        return new ListNode[]{curr, node};
    }
}
