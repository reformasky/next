package org.xuan.linkedlist;

import org.xuan.util.ListNode;

/**
 * Created by xzhou2 on 12/14/16.
 */
public class PartitionList_86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        ListNode first = new ListNode(-1), second = new ListNode(-1),
                curr1 = first, curr2 = second;
        while(head != null) {
            if (head.val < x) {
                curr1.next = head;
                curr1 = curr1.next;
            } else {
                curr2.next = head;
                curr2 = curr2.next;
            }
            head = head.next;
        }
        curr2.next = null;
        curr1.next = second.next;
        return first.next;
    }
}
