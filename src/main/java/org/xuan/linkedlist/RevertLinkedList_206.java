package org.xuan.linkedlist;

import org.xuan.util.ListNode;

/**
 * Created by xzhou2 on 1/1/17.
 */
public class RevertLinkedList_206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, curr = head, next;
        if (head == null) {
            return head;
        }
        while(curr.next != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        curr.next = pre;
        return curr;
    }

    public ListNode reverseList_recursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return helper(head)[0];
    }

    private ListNode[] helper(ListNode head) {
        if (head.next == null) {
            return new ListNode[]{head, head};
        }
        ListNode[] pre = helper(head.next);
        head.next = null;
        pre[1].next = head;
        return new ListNode[]{pre[0], head};
    }
}
