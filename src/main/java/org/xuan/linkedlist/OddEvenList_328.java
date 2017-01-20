package org.xuan.linkedlist;

import org.xuan.util.ListNode;

/**
 * Created by xzhou2 on 1/18/17.
 */
public class OddEvenList_328 {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(-1), even = new ListNode(-1), oddCurr = odd, evenCurr = even;
        ListNode curr = head, next;
        boolean isOdd = true;
        while(curr != null) {
            next = curr.next;
            if (isOdd) {
                oddCurr.next = curr;
                oddCurr = curr;
            } else {
                evenCurr.next = curr;
                evenCurr = curr;
            }
            isOdd = !isOdd;
            curr = next;
        }
        evenCurr.next = null;
        oddCurr.next = even.next;
        return odd.next;
    }

}
