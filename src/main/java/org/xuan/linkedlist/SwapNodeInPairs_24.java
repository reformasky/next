package org.xuan.linkedlist;

import org.xuan.util.ListNode;

/**
 * Created by xzhou2 on 11/21/16.
 */
public class SwapNodeInPairs_24 {
    public ListNode swapPairs(ListNode head) {
       ListNode pre = new ListNode(-1), curr = pre;
        pre.next = head;
        while(curr.next != null) {
            ListNode next = curr.next, second = next.next;
            if (second == null) {
                break;
            }

            next.next = second.next;
            second.next = next;
            curr.next = second;
            curr = next;
        }
        return pre.next;
    }

    public ListNode swapPairs_recusion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = head.next, tmp = result.next;
        result.next = head;
        head.next = swapPairs_recusion(tmp);
        return result;
    }

}
