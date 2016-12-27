package org.xuan.linkedlist;

import org.xuan.util.ListNode;

/**
 * Created by xzhou2 on 12/20/16.
 */
public class ReorderList_143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode fast = head, slow = head, secondHalf;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        secondHalf = slow.next;
        slow.next = null;
        secondHalf = reverse(secondHalf);
        merge(head, secondHalf);

    }

    private ListNode reverse(ListNode node) {
        ListNode pre = null, curr = node, next = node.next;
        while(next != null) {
            curr.next = pre;
            pre = curr;
            curr = next;
            next = next.next;
        }
        curr.next = pre;
        return curr;
    }

    private void merge(ListNode h1, ListNode h2) {
        ListNode tmp1, tmp2;
        while(h2 != null) {
            // System.out.println(h1.val + " " + h2.val);
            tmp1 = h1.next;
            tmp2 = h2.next;
            h1.next = h2;
            h2.next = tmp1;
            h1 = tmp1;
            h2 = tmp2;
        }

    }
}
