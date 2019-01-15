package org.xuan.linkedlist;

import org.xuan.util.ListNode;

/**
 * Created by xzhou2 on 2/26/17.
 */
public class AddTwoNumbers_445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = getLength(l1);
        int len2 = getLength(l2);
        ListNode result;
        if (len1 < len2) {
            result = addTwoNumbers(l2, l1, len2, len1);
        } else {
            result = addTwoNumbers(l1, l2, len1, len2);
        }
        if (result != null && result.val >= 10) {
            ListNode pre = new ListNode(1);
            pre.next = result;
            result.val -= 10;
            result = pre;
        }
        return result;
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2, int len1, int len2) {
        if (len1 == 0) {
            return null;
        }
        ListNode curr, next;

        if (len1 == len2) {
            curr = new ListNode(l1.val + l2.val);
            next = addTwoNumbers(l1.next, l2.next, len1 - 1, len2 - 1);

        } else {
            curr = new ListNode(l1.val);
            next = addTwoNumbers(l1.next, l2, len1 - 1, len2);
        }
        curr.next = next;
        if (next != null && next.val >= 10) {
            next.val -= 10;
            curr.val += 1;
        }
        return curr;
    }

    private int getLength(ListNode l) {
        int result = 0;
        while(l != null) {
            result++;
            l = l.next;
        }
        return result;
    }
}
