package org.xuan.linkedlist;

import org.xuan.util.ListNode;

/**
 * Created by xzhou2 on 12/13/16.
 */
public class DeleteDuplicateI_83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = head, tmp = head.next;
        while(tmp != null) {
            if (pre.val != tmp.val) {
                pre.next = tmp;
                pre = tmp;
            }
            tmp = tmp.next;
        }
        pre.next = null;
        return head;
    }
}
