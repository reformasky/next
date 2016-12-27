package org.xuan.linkedlist;

import org.xuan.util.ListNode;

/**
 * Created by xzhou2 on 12/21/16.
 */
public class SortList_148 {
    public ListNode sortList(ListNode head) {
        int len = 0;
        ListNode curr = head;
        while(curr != null) {
            curr = curr.next;
            len++;
        }
        if (len < 2) {
            return head;
        }
        return sortList(head, len);
    }

    private ListNode sortList(ListNode head, int len) {
        if (len <= 1) {
            return head;
        }
        ListNode pre = head;
        int counter = 1;
        while(counter < len/2) {
            pre = pre.next;
            counter++;
        }
        ListNode rightHead = pre.next;
        pre.next = null;
        ListNode left = sortList(head, len / 2), right = sortList(rightHead, len - len / 2);

        return 	merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode pre = new ListNode(-1), curr = pre;
        while(left != null && right != null) {
            if (left.val <= right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        if (left == null) {
            curr.next = right;
        } else {
            curr.next = left;
        }
        return pre.next;

    }
}
