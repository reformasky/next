package org.xuan.linkedlist;

import org.xuan.util.ListNode;

/**
 * Created by xzhou2 on 12/13/16.
 */
public class DeleteDuplicateII_82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(-1), curr = pre, tmp = head;
        pre.next = head;
        while(tmp != null) {
            if (tmp.next != null && tmp.next.val == tmp.val) {
                while(tmp.next != null && tmp.val == tmp.next.val) {
                    tmp = tmp.next;
                }
            } else {
                curr.next = tmp;
                curr = tmp;
            }
            tmp = tmp.next;

        }
        curr.next = null;
        return pre.next;
    }
}
